package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_view.view.*

class CalendarView: BaseView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)


    override fun initLayout(): Int {
        return R.layout.calendar_view
    }

    override fun onCreate() {
        super.onCreate()
        view_pager.adapter = CalendarPagerAdapter(context)
        view_pager.currentItem = CalendarPagerAdapter.START_POSITION
    }
}