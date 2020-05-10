package com.wildgrowth.universaltimeplanner.ui.common

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


open class BaseActivity : AppCompatActivity() {
    var onPermissionRequestFailedListener: (()->Unit)? = null

    companion object {
        const val PERMISSION_REQUEST_CODE: Int = 0b1000
    }

    protected fun requestPermission(
        permission: String,
        onPermissionRequestFailedListener: (()->Unit)?
    ) {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
            onPermissionRequestFailedListener?.invoke()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(permission), PERMISSION_REQUEST_CODE)
            this.onPermissionRequestFailedListener = onPermissionRequestFailedListener
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == PERMISSION_REQUEST_CODE) {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                onPermissionRequestFailedListener?.invoke()
            }
            onPermissionRequestFailedListener = null
        }
    }
}