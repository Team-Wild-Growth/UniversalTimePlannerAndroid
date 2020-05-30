package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_item_view.view.*

class CalendarItemView : BaseView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun initLayout(): Int {
        return R.layout.calendar_item_view
    }

    fun setTextColor(color: Int) {
        text_view.setTextColor(color)
    }

    fun setText(text: String) {
        text_view.text = text
    }
}