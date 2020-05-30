package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_month_view.view.*
import java.util.*

class CalendarMonthView: BaseView {
    var month: Int = 0
        set(value) {
            field = value - 1
        }
    var year: Int = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun initLayout(): Int {
        return R.layout.calendar_month_view
    }

    fun addOnDateClickListener(onClickListener: CalendarDateView.OnDateClickListener) {
        first_week_view.setOnDateClickListener(onClickListener)
        second_week_view.setOnDateClickListener(onClickListener)
        third_week_view.setOnDateClickListener(onClickListener)
        fourth_week_view.setOnDateClickListener(onClickListener)
        fifth_week_view.setOnDateClickListener(onClickListener)
        sixth_week_view.setOnDateClickListener(onClickListener)
    }

    fun update() {
        val calendar: Calendar = Calendar.getInstance()

        calendar.set(year, month, 1)
        val firstDayOfWeek: Int = calendar.get(Calendar.DAY_OF_WEEK)
        calendar.add(Calendar.DATE, (firstDayOfWeek - 1) * -1)
        first_week_view.setWeek(calendar.time, month)

        calendar.add(Calendar.DATE, 7)
        second_week_view.setWeek(calendar.time, month)

        calendar.add(Calendar.DATE, 7)
        third_week_view.setWeek(calendar.time, month)

        calendar.add(Calendar.DATE, 7)
        fourth_week_view.setWeek(calendar.time, month)

        calendar.add(Calendar.DATE, 7)
        fifth_week_view.setWeek(calendar.time, month)

        calendar.add(Calendar.DATE, 7)
        sixth_week_view.setWeek(calendar.time, month)
    }

    fun selectDate(date: Date) {
        first_week_view.selectDate(date);
        second_week_view.selectDate(date);
        third_week_view.selectDate(date);
        fourth_week_view.selectDate(date);
        fifth_week_view.selectDate(date);
        sixth_week_view.selectDate(date);
    }
}