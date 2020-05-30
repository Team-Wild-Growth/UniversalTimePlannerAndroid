package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.View.OnClickListener
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_view.view.*
import java.util.*

class CalendarView: BaseView {
    private lateinit var adapter: CalendarPagerAdapter

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)


    override fun initLayout(): Int {
        return R.layout.calendar_view
    }

    fun setOnDateClickListener(onDateClickListener: (Date) -> Unit) {
        adapter.onDateClickListener = object :CalendarDateView.OnDateClickListener {
            override fun onDateClick(date: Date) {
                onDateClickListener.invoke(date)
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        adapter = CalendarPagerAdapter()
        view_pager.adapter = adapter
        view_pager.currentItem = CalendarPagerAdapter.START_POSITION
    }
}