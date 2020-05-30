package com.wildgrowth.universaltimeplanner.ui.common

import android.content.Context
import android.graphics.Color
import android.util.Log
import com.wildgrowth.universaltimeplanner.App

class Utils {
    companion object {
        fun pxToDp(px: Float): Float {
            return px / App.getContext().getResources().getDisplayMetrics().density
        }

        fun dpToPx(dp: Float): Float {
            return dp * App.getContext().getResources().getDisplayMetrics().density
        }

        fun mixColor(color1: Int, color2: Int): Int {
            val alpha1 = color1.ushr(24)
            val alpha2 = color2.ushr(24)
            val red1 = (color1.and(0x00ff0000)).shr(16)
            val red2 = (color2.and(0x00ff0000)).shr(16)
            val green1 = (color1.and(0x0000ff00)).shr(8)
            val green2 = (color2.and(0x0000ff00)).shr(8)
            val blue1 = color1.and(0x000000ff)
            val blue2 = color2.and(0x000000ff)

            val mixed_alpha = (alpha1 + alpha2) / 2
            val mixed_red = (red1 + red2) / 2
            val mixed_green = (green1 + green2) / 2
            val mixed_blue = (blue1 + blue2) / 2

            val mixed_color  = (mixed_alpha.shl(24)
                    + mixed_red.shl(16)
                    + mixed_green.shl(8)
                    + mixed_blue)
            return mixed_color
        }
    }
}