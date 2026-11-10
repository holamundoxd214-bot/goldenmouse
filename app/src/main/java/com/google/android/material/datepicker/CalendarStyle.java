package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

final class CalendarStyle {
    final CalendarItemStyle day;
    final CalendarItemStyle invalidDay;
    final Paint rangeFill;
    final CalendarItemStyle selectedDay;
    final CalendarItemStyle selectedYear;
    final CalendarItemStyle todayDay;
    final CalendarItemStyle todayYear;
    final CalendarItemStyle year;

    CalendarStyle(Context arg5) {
        super();
        TypedArray v0 = arg5.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(arg5, attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), styleable.MaterialCalendar);
        this.day = CalendarItemStyle.create(arg5, v0.getResourceId(styleable.MaterialCalendar_dayStyle, 0));
        this.invalidDay = CalendarItemStyle.create(arg5, v0.getResourceId(styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.selectedDay = CalendarItemStyle.create(arg5, v0.getResourceId(styleable.MaterialCalendar_daySelectedStyle, 0));
        this.todayDay = CalendarItemStyle.create(arg5, v0.getResourceId(styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList v1 = MaterialResources.getColorStateList(arg5, v0, styleable.MaterialCalendar_rangeFillColor);
        this.year = CalendarItemStyle.create(arg5, v0.getResourceId(styleable.MaterialCalendar_yearStyle, 0));
        this.selectedYear = CalendarItemStyle.create(arg5, v0.getResourceId(styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.todayYear = CalendarItemStyle.create(arg5, v0.getResourceId(styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint v5 = new Paint();
        this.rangeFill = v5;
        v5.setColor(v1.getDefaultColor());
        v0.recycle();
    }
}

