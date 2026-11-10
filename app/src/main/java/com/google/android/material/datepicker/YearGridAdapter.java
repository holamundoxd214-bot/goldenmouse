package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.google.android.material.R$layout;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

class YearGridAdapter extends Adapter {
    public class ViewHolder extends androidx.recyclerview.widget.RecyclerView$ViewHolder {
        final TextView textView;

        ViewHolder(TextView arg1) {
            super(((View)arg1));
            this.textView = arg1;
        }
    }

    private final MaterialCalendar materialCalendar;

    YearGridAdapter(MaterialCalendar arg1) {
        super();
        this.materialCalendar = arg1;
    }

    static MaterialCalendar access$000(YearGridAdapter arg0) {
        return arg0.materialCalendar;
    }

    private View$OnClickListener createYearClickListener(int arg2) {
        return new View$OnClickListener(arg2) {
            public void onClick(View arg2) {
                YearGridAdapter.this.materialCalendar.setCurrentMonth(YearGridAdapter.this.materialCalendar.getCalendarConstraints().clamp(Month.create(this.val$year, YearGridAdapter.this.materialCalendar.getCurrentMonth().month)));
                YearGridAdapter.this.materialCalendar.setSelector(CalendarSelector.DAY);
            }
        };
    }

    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    int getPositionForYear(int arg1) {
        return arg1 - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    int getYearForPosition(int arg1) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + arg1;
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder arg1, int arg2) {
        this.onBindViewHolder(((ViewHolder)arg1), arg2);
    }

    public void onBindViewHolder(ViewHolder arg8, int arg9) {
        arg9 = this.getYearForPosition(arg9);
        arg8.textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(arg9)));
        arg8.textView.setContentDescription(DateStrings.getYearContentDescription(arg8.textView.getContext(), arg9));
        CalendarStyle v0 = this.materialCalendar.getCalendarStyle();
        Calendar v1 = UtcDates.getTodayCalendar();
        CalendarItemStyle v3 = v1.get(1) == arg9 ? v0.todayYear : v0.year;
        Iterator v4 = this.materialCalendar.getDateSelector().getSelectedDays().iterator();
        while(v4.hasNext()) {
            v1.setTimeInMillis(v4.next().longValue());
            if(v1.get(1) != arg9) {
                continue;
            }

            v3 = v0.selectedYear;
        }

        v3.styleItem(arg8.textView);
        arg8.textView.setOnClickListener(this.createYearClickListener(arg9));
    }

    public androidx.recyclerview.widget.RecyclerView$ViewHolder onCreateViewHolder(ViewGroup arg1, int arg2) {
        return this.onCreateViewHolder(arg1, arg2);
    }

    public ViewHolder onCreateViewHolder(ViewGroup arg2, int arg3) {
        return new ViewHolder(LayoutInflater.from(arg2.getContext()).inflate(layout.mtrl_calendar_year, arg2, false));
    }
}

