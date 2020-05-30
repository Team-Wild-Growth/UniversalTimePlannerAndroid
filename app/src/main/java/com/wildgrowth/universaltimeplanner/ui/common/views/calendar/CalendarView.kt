package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.viewpager.widget.ViewPager
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
        adapter = CalendarPagerAdapter()
        view_pager.adapter = adapter
        view_pager.currentItem = CalendarPagerAdapter.START_POSITION
        view_pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                view_pager.findViewWithTag<CalendarMonthView>(position).selectDate(selectedDate)
            }
        })
        view_pager.post({
            selectDate(Date())
        })
    }

    fun selectDate(date: Date) {
        selectedDate = date
        val monthView = view_pager.findViewWithTag(view_pager.currentItem) as CalendarMonthView
        monthView.selectDate(selectedDate)
    }
}