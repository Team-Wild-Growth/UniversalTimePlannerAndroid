package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import com.wildgrowth.universaltimeplanner.R

class DefaultCalendarMarker : BaseCalendarMarker {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun initLayout(): Int {
        return R.layout.default_calendar_marker
    }
}