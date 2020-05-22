package com.wildgrowth.universaltimeplanner.ui.common

import android.content.Context
import com.wildgrowth.universaltimeplanner.App

class Utils {
    companion object {
        fun pxToDp(px: Float): Float {
            return px / App.getContext().getResources().getDisplayMetrics().density
        }

        fun dpToPx(dp: Float): Float {
            return dp * App.getContext().getResources().getDisplayMetrics().density
        }
    }
}