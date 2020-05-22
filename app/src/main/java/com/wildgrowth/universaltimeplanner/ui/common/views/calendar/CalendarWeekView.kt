package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_week_view.view.*
import java.util.*

class CalendarWeekView: BaseView {
    companion object {
        val SUNDAY: Int = 0
        val MONDAY: Int = 1
        val TUESDAY: Int = 2
        val WEDNESDAY: Int = 3
        val THURSDAY: Int = 4
        val FRIDAY: Int = 5
        val SATURDAY: Int = 6
    }

    private var month = 0;

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun initLayout(): Int {
        return R.layout.calendar_week_view
    }

    fun setWeek(sundayDate: Date, month: Int) {
        this.month = month
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = sundayDate
        setDay(sunday_view, calendar)

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
    }

    private fun setDay(dayView: CalendarDayView, calendar: Calendar) {
        dayView.date = calendar.time
        val month = calendar.get(Calendar.MONTH)
        if(this.month != month) {
            dayView.setDisable()
        }
    }
}