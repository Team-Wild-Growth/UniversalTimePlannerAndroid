package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_week_view.view.*
import java.util.*

class CalendarWeekView: BaseView {
    private var month = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun initLayout(): Int {
        return R.layout.calendar_week_view
    }

    fun setOnDateClickListener(onDateClickListener: CalendarDateView.OnDateClickListener) {
        sunday_view.setOnDateClickListeners(onDateClickListener)
        monday_view.setOnDateClickListeners(onDateClickListener)
        tuesday_view.setOnDateClickListeners(onDateClickListener)
        wednesday_view.setOnDateClickListeners(onDateClickListener)
        thursday_view.setOnDateClickListeners(onDateClickListener)
        friday_view.setOnDateClickListeners(onDateClickListener)
        saturday_view.setOnDateClickListeners(onDateClickListener)
    }

    fun setWeek(sundayDate: Date, month: Int) {
        this.month = month
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = sundayDate
        setDay(sunday_view, calendar)
        sunday_view.setHolyday()

        calendar.add(Calendar.DATE, 1)
        setDay(monday_view, calendar)

        calendar.add(Calendar.DATE, 1)
        setDay(tuesday_view, calendar)

        calendar.add(Calendar.DATE, 1)
        setDay(wednesday_view, calendar)

        calendar.add(Calendar.DATE, 1)
        setDay(thursday_view, calendar)

        calendar.add(Calendar.DATE, 1)
        setDay(friday_view, calendar)

        calendar.add(Calendar.DATE, 1)
        setDay(saturday_view, calendar)
        saturday_view.setSaturday()
    }

    private fun setDay(dateView: CalendarDateView, calendar: Calendar) {
        dateView.date = calendar.time
        val month = calendar.get(Calendar.MONTH)
        if(this.month != month) {
            dateView.setDisable()
        } else {
            dateView.setEnable()
        }
    }

    fun selectDate(date: Date) {
        sunday_view.selectDate(date)
        monday_view.selectDate(date)
        tuesday_view.selectDate(date)
        wednesday_view.selectDate(date)
        thursday_view.selectDate(date)
        friday_view.selectDate(date)
        saturday_view.selectDate(date)
    }
}