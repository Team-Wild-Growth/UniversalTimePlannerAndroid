package com.wildgrowth.universaltimeplanner.utils

import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {
        fun format(date: Date): String {
            val formatter: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            return formatter.format(date)
        }
    }
}