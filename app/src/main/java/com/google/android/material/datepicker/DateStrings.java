package com.google.android.material.datepicker;

import android.content.Context;
import androidx.core.util.Pair;
import com.google.android.material.R$string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class DateStrings {
    private DateStrings() {
        super();
    }

    static Pair getDateRangeString(Long arg1, Long arg2) {
        return DateStrings.getDateRangeString(arg1, arg2, null);
    }

    static Pair getDateRangeString(Long arg5, Long arg6, SimpleDateFormat arg7) {
        Object v0 = null;
        if(arg5 == null && arg6 == null) {
            return Pair.create(v0, v0);
        }

        if(arg5 == null) {
            return Pair.create(v0, DateStrings.getDateString(arg6.longValue(), arg7));
        }

        if(arg6 == null) {
            return Pair.create(DateStrings.getDateString(arg5.longValue(), arg7), v0);
        }

        Calendar v0_1 = UtcDates.getTodayCalendar();
        Calendar v1 = UtcDates.getUtcCalendar();
        v1.setTimeInMillis(arg5.longValue());
        Calendar v2 = UtcDates.getUtcCalendar();
        v2.setTimeInMillis(arg6.longValue());
        if(arg7 != null) {
            return Pair.create(arg7.format(new Date(arg5.longValue())), arg7.format(new Date(arg6.longValue())));
        }

        if(v1.get(1) == v2.get(1)) {
            if(v1.get(1) == v0_1.get(1)) {
                return Pair.create(DateStrings.getMonthDay(arg5.longValue(), Locale.getDefault()), DateStrings.getMonthDay(arg6.longValue(), Locale.getDefault()));
            }

            return Pair.create(DateStrings.getMonthDay(arg5.longValue(), Locale.getDefault()), DateStrings.getYearMonthDay(arg6.longValue(), Locale.getDefault()));
        }

        return Pair.create(DateStrings.getYearMonthDay(arg5.longValue(), Locale.getDefault()), DateStrings.getYearMonthDay(arg6.longValue(), Locale.getDefault()));
    }

    static String getDateString(long arg1) {
        return DateStrings.getDateString(arg1, null);
    }

    static String getDateString(long arg1, SimpleDateFormat arg3) {
        if(arg3 != null) {
            return arg3.format(new Date(arg1));
        }

        if(DateStrings.isDateWithinCurrentYear(arg1)) {
            return DateStrings.getMonthDay(arg1);
        }

        return DateStrings.getYearMonthDay(arg1);
    }

    static String getDayContentDescription(Context arg0, long arg1, boolean arg3, boolean arg4, boolean arg5) {
        String v1 = DateStrings.getOptionalYearMonthDayOfWeekDay(arg1);
        if(arg3) {
            v1 = String.format(arg0.getString(string.mtrl_picker_today_description), v1);
        }

        if(arg4) {
            return String.format(arg0.getString(string.mtrl_picker_start_date_description), v1);
        }

        if(arg5) {
            return String.format(arg0.getString(string.mtrl_picker_end_date_description), v1);
        }

        return v1;
    }

    static String getMonthDay(long arg1, Locale arg3) {
        return UtcDates.getAbbrMonthDayFormat(arg3).format(new Date(arg1));
    }

    static String getMonthDay(long arg1) {
        return DateStrings.getMonthDay(arg1, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long arg1) {
        return DateStrings.getMonthDayOfWeekDay(arg1, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long arg1, Locale arg3) {
        return UtcDates.getMonthWeekdayDayFormat(arg3).format(new Date(arg1));
    }

    static String getOptionalYearMonthDayOfWeekDay(long arg1) {
        if(DateStrings.isDateWithinCurrentYear(arg1)) {
            return DateStrings.getMonthDayOfWeekDay(arg1);
        }

        return DateStrings.getYearMonthDayOfWeekDay(arg1);
    }

    static String getYearContentDescription(Context arg2, int arg3) {
        if(UtcDates.getTodayCalendar().get(1) == arg3) {
            return String.format(arg2.getString(string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(arg3));
        }

        return String.format(arg2.getString(string.mtrl_picker_navigate_to_year_description), Integer.valueOf(arg3));
    }

    static String getYearMonth(long arg2) {
        return UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(arg2));
    }

    static String getYearMonthDay(long arg1, Locale arg3) {
        return UtcDates.getYearAbbrMonthDayFormat(arg3).format(new Date(arg1));
    }

    static String getYearMonthDay(long arg1) {
        return DateStrings.getYearMonthDay(arg1, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long arg1) {
        return DateStrings.getYearMonthDayOfWeekDay(arg1, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long arg1, Locale arg3) {
        return UtcDates.getYearMonthWeekdayDayFormat(arg3).format(new Date(arg1));
    }

    private static boolean isDateWithinCurrentYear(long arg2) {
        Calendar v0 = UtcDates.getTodayCalendar();
        Calendar v1 = UtcDates.getUtcCalendar();
        v1.setTimeInMillis(arg2);
        if(v0.get(1) == v1.get(1)) {
            return 1;
        }

        return 0;
    }
}

