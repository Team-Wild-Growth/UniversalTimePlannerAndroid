package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.core.view.children
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_view.view.*
import java.util.*

class CalendarView: BaseView {
    private lateinit var adapter: CalendarPagerAdapter
    private lateinit var selectedDate: Date

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
                selectDate(date)
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        selectedDate = Date()
        adapter = CalendarPagerAdapter()
        view_pager.adapter = adapter
        view_pager.currentItem = CalendarPagerAdapter.START_POSITION
    }

    fun selectDate(date: Date) {
        selectedDate = date
        for(i in 0 until view_pager.childCount) {
            val monthView = view_pager.getChildAt(i) as CalendarMonthView
            monthView.selectDate(date)
        }
    }
}