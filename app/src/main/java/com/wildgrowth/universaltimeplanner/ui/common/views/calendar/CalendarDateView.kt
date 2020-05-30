package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_date_view.view.*
import java.util.*

class CalendarDateView: BaseView {
    interface OnDateClickListener {
        fun onDateClick(date: Date)
    }

    var onDateClickListener: OnDateClickListener? = null

    var date: Date? = null
        set(value) {
            if(value != null) {
                field = value
                val calendar: Calendar = Calendar.getInstance()
                calendar.time = value
                val day: Int = calendar.get(Calendar.DATE)
                day_text_view.text = "$day"
            }
        }


    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun onCreate() {
        super.onCreate()
        setOnClickListener {
            date?.let {
                onDateClickListener?.onDateClick(it)
            }
        }
        selected_view.visibility = View.GONE;
    }

    fun setOnDateClickListeners(listener: OnDateClickListener) {
        this.onDateClickListener = listener
    }

    override fun initLayout(): Int {
        return R.layout.calendar_date_view
    }

    fun setDisable() {
        day_text_view.setTextColor(ContextCompat.getColor(context, R.color.color_disabled_text))
    }

    fun setEnable() {
        day_text_view.setTextColor(ContextCompat.getColor(context, R.color.black))
    }

    fun selectDate(date: Date) {
        if(date == this.date) {
            selected_view.visibility = View.VISIBLE
        } else {
            selected_view.visibility = View.GONE
        }
    }
}