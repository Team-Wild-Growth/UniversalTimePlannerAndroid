package com.wildgrowth.universaltimeplanner.ui.common.views

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout

abstract class BaseView : LinearLayout {
    constructor(context: Context) : super(context) {
        onCreate()
    }
    constructor(context: Context, attributeSet: AttributeSet)
            : super(context, attributeSet) {
        onCreate()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        onCreate()
    }

    protected abstract fun initLayout(): Int

    protected fun onCreate() {
        setContentView(initLayout())
    }

    protected fun setContentView(layoutId: Int) {
        val inflater: LayoutInflater? = getLayoutInflater()
        if(inflater != null) {
            val mainLayout: View = inflater.inflate(layoutId, this, false)
            addView(mainLayout)
        }

    }

    protected fun getLayoutInflater(): LayoutInflater {
        return context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}
