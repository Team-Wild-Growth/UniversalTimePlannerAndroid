package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_month_view.view.*
import java.util.*

class CalendarMonthView: BaseView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun initLayout(): Int {
        return R.layout.calendar_month_view
    }

    fun setCalendar(year: Int, _month: Int) {
        var month = _month - 1
        val calendar: Calendar = Calendar.getInstance()

        calendar.set(year, month, 1)
        val firstDayOfWeek: Int = calendar.get(Calendar.DAY_OF_WEEK)
        calendar.add(Calendar.DATE, (firstDayOfWeek - 1) * -1)
        val firstWeekSunday: Date = calendar.time
        first_week_view.setWeek(firstWeekSunday, month)

        calendar.add(Calendar.DATE, 7)
        val secondWeekSunday: Date = calendar.time
        second_week_view.setWeek(secondWeekSunday, month)

        calendar.add(Calendar.DATE, 7)
        val thirdWeekSunday: Date = calendar.time
        third_week_view.setWeek(thirdWeekSunday, month)

        calendar.add(Calendar.DATE, 7)
        val fourthWeekSunday: Date = calendar.time
        fourth_week_view.setWeek(fourthWeekSunday, month)

        calendar.add(Calendar.DATE, 7)
        val fifthWeekSunday: Date = calendar.time
        fifth_week_view.setWeek(fifthWeekSunday, month)

        calendar.add(Calendar.DATE, 7)
        val sixthWeekSunday: Date = calendar.time
        sixth_week_view.setWeek(sixthWeekSunday, month)
    }
}