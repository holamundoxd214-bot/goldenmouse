package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

class MonthsPagerAdapter extends Adapter {
    public class ViewHolder extends androidx.recyclerview.widget.RecyclerView$ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        ViewHolder(LinearLayout arg3, boolean arg4) {
            super(((View)arg3));
            View v0 = arg3.findViewById(id.month_title);
            this.monthTitle = ((TextView)v0);
            ViewCompat.setAccessibilityHeading(v0, true);
            this.monthGrid = arg3.findViewById(id.month_grid);
            if(!arg4) {
                ((TextView)v0).setVisibility(8);
            }
        }
    }

    private final CalendarConstraints calendarConstraints;
    private final DateSelector dateSelector;
    private final DayViewDecorator dayViewDecorator;
    private final int itemHeight;
    private final OnDayClickListener onDayClickListener;

    MonthsPagerAdapter(Context arg4, DateSelector arg5, CalendarConstraints arg6, DayViewDecorator arg7, OnDayClickListener arg8) {
        super();
        Month v0 = arg6.getStart();
        Month v1 = arg6.getEnd();
        Month v2 = arg6.getOpenAt();
        if(v0.compareTo(v2) <= 0) {
            if(v2.compareTo(v1) <= 0) {
                int v0_1 = MonthAdapter.MAXIMUM_WEEKS * MaterialCalendar.getDayHeight(arg4);
                int v4 = MaterialDatePicker.isFullscreen(arg4) ? MaterialCalendar.getDayHeight(arg4) : 0;
                this.itemHeight = v0_1 + v4;
                this.calendarConstraints = arg6;
                this.dateSelector = arg5;
                this.dayViewDecorator = arg7;
                this.onDayClickListener = arg8;
                this.setHasStableIds(true);
                return;
            }

            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }

        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    static OnDayClickListener access$000(MonthsPagerAdapter arg0) {
        return arg0.onDayClickListener;
    }

    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    public long getItemId(int arg1) {
        return this.calendarConstraints.getStart().monthsLater(arg1).getStableId();
    }

    Month getPageMonth(int arg1) {
        return this.calendarConstraints.getStart().monthsLater(arg1);
    }

    CharSequence getPageTitle(int arg1) {
        return this.getPageMonth(arg1).getLongName();
    }

    int getPosition(Month arg1) {
        return this.calendarConstraints.getStart().monthsUntil(arg1);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder arg1, int arg2) {
        this.onBindViewHolder(((ViewHolder)arg1), arg2);
    }

    public void onBindViewHolder(ViewHolder arg5, int arg6) {
        Month v6 = this.calendarConstraints.getStart().monthsLater(arg6);
        arg5.monthTitle.setText(v6.getLongName());
        View v5 = arg5.monthGrid.findViewById(id.month_grid);
        if(((MaterialCalendarGridView)v5).getAdapter() == null || !v6.equals(((MaterialCalendarGridView)v5).getAdapter().month)) {
            MonthAdapter v0 = new MonthAdapter(v6, this.dateSelector, this.calendarConstraints, this.dayViewDecorator);
            ((MaterialCalendarGridView)v5).setNumColumns(v6.daysInWeek);
            ((MaterialCalendarGridView)v5).setAdapter(((ListAdapter)v0));
        }
        else {
            ((MaterialCalendarGridView)v5).invalidate();
            ((MaterialCalendarGridView)v5).getAdapter().updateSelectedStates(((MaterialCalendarGridView)v5));
        }

        ((MaterialCalendarGridView)v5).setOnItemClickListener(new AdapterView$OnItemClickListener(((MaterialCalendarGridView)v5)) {
            public void onItemClick(AdapterView arg1, View arg2, int arg3, long arg4) {
                if(this.val$monthGrid.getAdapter().withinMonth(arg3)) {
                    MonthsPagerAdapter.this.onDayClickListener.onDayClick(this.val$monthGrid.getAdapter().getItem(arg3).longValue());
                }
            }
        });
    }

    public androidx.recyclerview.widget.RecyclerView$ViewHolder onCreateViewHolder(ViewGroup arg1, int arg2) {
        return this.onCreateViewHolder(arg1, arg2);
    }

    public ViewHolder onCreateViewHolder(ViewGroup arg3, int arg4) {
        View v4 = LayoutInflater.from(arg3.getContext()).inflate(layout.mtrl_calendar_month_labeled, arg3, false);
        if(MaterialDatePicker.isFullscreen(arg3.getContext())) {
            ((LinearLayout)v4).setLayoutParams(new LayoutParams(-1, this.itemHeight));
            return new ViewHolder(((LinearLayout)v4), true);
        }

        return new ViewHolder(((LinearLayout)v4), false);
    }
}

