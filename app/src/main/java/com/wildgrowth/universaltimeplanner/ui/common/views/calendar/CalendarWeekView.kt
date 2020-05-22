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

    fun setWeek(sundayDate: Date) {
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = sundayDate
        sunday_view.date = calendar.time

        calendar.add(Calendar.DATE, 1)
        monday_view.date = calendar.time

        calendar.add(Calendar.DATE, 1)
        tuesday_view.date = calendar.time

        calendar.add(Calendar.DATE, 1)
        wednesday_view.date = calendar.time

        calendar.add(Calendar.DATE, 1)
        thursday_view.date = calendar.time

        calendar.add(Calendar.DATE, 1)
        friday_view.date = calendar.time

        calendar.add(Calendar.DATE, 1)
        saturday_view.date = calendar.time
    }
}