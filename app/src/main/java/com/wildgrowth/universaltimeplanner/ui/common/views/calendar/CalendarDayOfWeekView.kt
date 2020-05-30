package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_day_of_week_view.view.*

class CalendarDayOfWeekView : BaseView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun initLayout(): Int {
        return R.layout.calendar_day_of_week_view
    }

    override fun onCreate() {
        super.onCreate()
        sunday_view.setText("일")
        sunday_view.setTextColor(Color.parseColor("#ff0000"))
        monday_view.setText("월")
        tuesday_view.setText("화")
        wednesday_view.setText("수")
        thursday_view.setText("목")
        friday_view.setText("금")
        saturday_view.setText("토")
        saturday_view.setTextColor(Color.parseColor("#0000ff"))
    }
}