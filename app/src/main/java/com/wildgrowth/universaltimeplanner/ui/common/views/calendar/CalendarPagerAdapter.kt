package com.wildgrowth.universaltimeplanner.ui.common.views.calendar

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.viewpager.widget.PagerAdapter
import com.wildgrowth.universaltimeplanner.App
import com.wildgrowth.universaltimeplanner.R
import java.util.*

class CalendarPagerAdapter: PagerAdapter() {
    var onDateClickListener: CalendarDateView.OnDateClickListener? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    companion object {
        const val START_POSITION: Int = Int.MAX_VALUE / 2
    }

    private val date: Date = Date()

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj as CalendarMonthView
    }

    override fun getCount(): Int {
        return Int.MAX_VALUE
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val monthView = CalendarMonthView(App.getContext())
        monthView.setTag(R.string.test, "TEST")
        val params: ViewGroup.LayoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        monthView.layoutParams = params
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.MONTH, position - START_POSITION)
        monthView.year = calendar.get(Calendar.YEAR)
        monthView.month = calendar.get(Calendar.MONTH)
        onDateClickListener?.let {
            monthView.addOnDateClickListener(it)
        }
        monthView.update()
        container.addView(monthView)
        return monthView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }
}