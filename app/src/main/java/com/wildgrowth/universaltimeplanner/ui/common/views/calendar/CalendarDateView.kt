package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.wildgrowth.universaltimeplanner.R
import com.wildgrowth.universaltimeplanner.ui.common.Utils
import com.wildgrowth.universaltimeplanner.ui.common.views.BaseView
import kotlinx.android.synthetic.main.calendar_date_view.view.*
import java.util.*

class CalendarDateView: BaseView {
    interface OnDateClickListener {
        fun onDateClick(date: Date)
    }

    private var baseColor: Int = Color.parseColor("#000000")
    private var isDisabled: Boolean = false

    var onDateClickListener: OnDateClickListener? = null

    var date: Date? = null
        set(value) {
            if(value != null) {
                field = value
                val calendar: Calendar = Calendar.getInstance()
                calendar.time = value
                val day: Int = calendar.get(Calendar.DATE)
                item_view.setText("$day")
            }
        }


    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun onCreate() {
        super.onCreate()
        baseColor = item_view.getTextColor()
        isDisabled = false
        setOnClickListener {
            date?.let {
                onDateClickListener?.onDateClick(it)
            }
        }
        marker.visibility = View.GONE
    }

    fun setOnDateClickListeners(listener: OnDateClickListener) {
        this.onDateClickListener = listener
    }

    override fun initLayout(): Int {
        return R.layout.calendar_date_view
    }

    fun setDisable() {
        isDisabled = true
        setColor()
    }

    fun setEnable() {
        isDisabled = false
        setColor()
    }

    fun selectDate(date: Date) {
        if(this.date != null) {
            val c1: Calendar = Calendar.getInstance()
            val c2: Calendar = Calendar.getInstance()
            c1.time = date
            c2.time = this.date
            if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
                && c1.get(Calendar.DATE) == c2.get(Calendar.DATE)){
                marker.visibility = View.VISIBLE
            } else {
                marker.visibility = View.GONE
            }
        }
    }

    fun setSaturday() {
        baseColor = Color.parseColor("#0000ff")
        setColor()
    }

    fun setHolyday() {
        baseColor = Color.parseColor("#ff0000")
        setColor()
    }

    fun setColor() {
        if(isDisabled) {
            item_view.setTextColor(
                Utils.mixColor(baseColor, ContextCompat.getColor(context, R.color.color_disabled_text)))
        } else {
            item_view.setTextColor(baseColor)
        }
    }
}