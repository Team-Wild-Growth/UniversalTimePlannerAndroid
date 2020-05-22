package com.wildgrowth.universaltimeplanner.clock

import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import com.wildgrowth.universaltimeplanner.utils.Permission

class GPS(context: Context) {
    class LocationListener(var lastLocation: Location) : android.location.LocationListener {
        override fun onLocationChanged(location: android.location.Location?) {
            if(location != null) {
                lastLocation.latitude = location.latitude
                lastLocation.longitude = location.longitude
            }
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}

        override fun onProviderDisabled(provider: String?) {}

        override fun onProviderEnabled(provider: String?) {}
    }

    val lastLocation: Location = Location(0.0, 0.0)
    init {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        var provider: String
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER
        } else {
            provider = LocationManager.NETWORK_PROVIDER
        }
        if(Permission.check(context, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            val lastKnownLocation: android.location.Location? =
                locationManager.getLastKnownLocation(provider)
            if (lastKnownLocation != null) {
                lastLocation.latitude = lastKnownLocation.latitude
                lastLocation.longitude = lastKnownLocation.longitude
                val locationListener: LocationListener = LocationListener(lastLocation)
                locationManager.requestLocationUpdates(
                    provider,
                    0,
                    0.0f,
                    locationListener
                )
            }
        }
    }
}