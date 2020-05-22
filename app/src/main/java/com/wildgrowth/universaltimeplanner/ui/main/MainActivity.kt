package com.wildgrowth.universaltimeplanner.ui.main

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.clock.GPS
import com.wildgrowth.universaltimeplanner.ui.common.BaseActivity
import com.wildgrowth.universaltimeplanner.utils.Permission
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {
    private var gps: GPS? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission(Manifest.permission.ACCESS_FINE_LOCATION) {
            Toast.makeText(this, "위치 권한이 거부되었습니다.", Toast.LENGTH_LONG).show()
        }
        calendar_view.setCalendar(2020, 5)
    }
}
