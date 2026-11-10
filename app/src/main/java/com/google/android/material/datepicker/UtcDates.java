package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import com.google.android.material.R$string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

class UtcDates {
    static final String UTC = "UTC";
    static AtomicReference timeSourceRef;

    static {
        UtcDates.timeSourceRef = new AtomicReference();
    }

    private UtcDates() {
        super();
    }

    static long canonicalYearMonthDay(long arg1) {
        Calendar v0 = UtcDates.getUtcCalendar();
        v0.setTimeInMillis(arg1);
        return UtcDates.getDayCopy(v0).getTimeInMillis();
    }

    private static int findCharactersInDateFormatPattern(String arg2, String arg3, int arg4, int arg5) {
        while(arg5 >= 0) {
            if(arg5 >= arg2.length()) {
                return arg5;
            }

            if(arg3.indexOf(arg2.charAt(arg5)) != -1) {
                return arg5;
            }

            int v1 = 39;
            if(arg2.charAt(arg5) == v1) {
                while(true) {
                    arg5 += arg4;
                    if(arg5 >= 0 && arg5 < arg2.length() && arg2.charAt(arg5) != v1) {
                        continue;
                    }

                    break;
                }
            }

            arg5 += arg4;
        }

        return arg5;
    }

    static DateFormat getAbbrMonthDayFormat(Locale arg1) {
        return UtcDates.getAndroidFormat("MMMd", arg1);
    }

    private static DateFormat getAndroidFormat(String arg0, Locale arg1) {
        DateFormat v0 = DateFormat.getInstanceForSkeleton(arg0, arg1);
        v0.setTimeZone(UtcDates.getUtcAndroidTimeZone());
        v0.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return v0;
    }

    static String getDatePatternAsInputFormat(String arg3) {
        return arg3.replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", "dd").replaceAll("M{1,2}", "MM").replaceAll("y{1,4}", "yyyy").replaceAll("\\.$", "").replaceAll("My", "M/y");
    }

    static Calendar getDayCopy(Calendar arg4) {
        arg4 = UtcDates.getUtcCalendarOf(arg4);
        Calendar v0 = UtcDates.getUtcCalendar();
        v0.set(arg4.get(1), arg4.get(2), arg4.get(5));
        return v0;
    }

    static SimpleDateFormat getDefaultTextInputFormat() {
        SimpleDateFormat v1 = new SimpleDateFormat(UtcDates.getDatePatternAsInputFormat(java.text.DateFormat.getDateInstance(3, Locale.getDefault()).toPattern()), Locale.getDefault());
        v1.setTimeZone(UtcDates.getTimeZone());
        v1.setLenient(false);
        return v1;
    }

    static String getDefaultTextInputHint(Resources arg6, SimpleDateFormat arg7) {
        String v7 = arg7.toPattern();
        String v0 = arg6.getString(string.mtrl_picker_text_input_year_abbr);
        String v1 = arg6.getString(string.mtrl_picker_text_input_month_abbr);
        String v6 = arg6.getString(string.mtrl_picker_text_input_day_abbr);
        String v3 = "y";
        String v4 = "M";
        String v5 = "d";
        if(Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage())) {
            v7 = v7.replaceAll("d+", v5).replaceAll("M+", v4).replaceAll("y+", v3);
        }

        return v7.replace(((CharSequence)v5), ((CharSequence)v6)).replace(((CharSequence)v4), ((CharSequence)v1)).replace(((CharSequence)v3), ((CharSequence)v0));
    }

    private static java.text.DateFormat getFormat(int arg0, Locale arg1) {
        java.text.DateFormat v0 = java.text.DateFormat.getDateInstance(arg0, arg1);
        v0.setTimeZone(UtcDates.getTimeZone());
        return v0;
    }

    static java.text.DateFormat getFullFormat() {
        return UtcDates.getFullFormat(Locale.getDefault());
    }

    static java.text.DateFormat getFullFormat(Locale arg1) {
        return UtcDates.getFormat(0, arg1);
    }

    static java.text.DateFormat getMediumFormat() {
        return UtcDates.getMediumFormat(Locale.getDefault());
    }

    static java.text.DateFormat getMediumFormat(Locale arg1) {
        return UtcDates.getFormat(2, arg1);
    }

    static java.text.DateFormat getMediumNoYear() {
        return UtcDates.getMediumNoYear(Locale.getDefault());
    }

    static java.text.DateFormat getMediumNoYear(Locale arg1) {
        java.text.DateFormat v1 = UtcDates.getMediumFormat(arg1);
        ((SimpleDateFormat)v1).applyPattern(UtcDates.removeYearFromDateFormatPattern(((SimpleDateFormat)v1).toPattern()));
        return v1;
    }

    static DateFormat getMonthWeekdayDayFormat(Locale arg1) {
        return UtcDates.getAndroidFormat("MMMMEEEEd", arg1);
    }

    static java.text.DateFormat getNormalizedFormat(java.text.DateFormat arg1) {
        Object v1 = arg1.clone();
        ((java.text.DateFormat)v1).setTimeZone(UtcDates.getTimeZone());
        return ((java.text.DateFormat)v1);
    }

    static SimpleDateFormat getSimpleFormat(String arg1) {
        return UtcDates.getSimpleFormat(arg1, Locale.getDefault());
    }

    private static SimpleDateFormat getSimpleFormat(String arg1, Locale arg2) {
        SimpleDateFormat v0 = new SimpleDateFormat(arg1, arg2);
        v0.setTimeZone(UtcDates.getTimeZone());
        return v0;
    }

    static TimeSource getTimeSource() {
        TimeSource v0_1;
        Object v0 = UtcDates.timeSourceRef.get();
        if(v0 == null) {
            v0_1 = TimeSource.system();
        }

        return v0_1;
    }

    private static TimeZone getTimeZone() {
        return TimeZone.getTimeZone("UTC");
    }

    static Calendar getTodayCalendar() {
        Calendar v0 = UtcDates.getTimeSource().now();
        v0.set(11, 0);
        v0.set(12, 0);
        v0.set(13, 0);
        v0.set(14, 0);
        v0.setTimeZone(UtcDates.getTimeZone());
        return v0;
    }

    private static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar getUtcCalendar() {
        return UtcDates.getUtcCalendarOf(null);
    }

    static Calendar getUtcCalendarOf(Calendar arg3) {
        Calendar v0 = Calendar.getInstance(UtcDates.getTimeZone());
        if(arg3 == null) {
            v0.clear();
            return v0;
        }

        v0.setTimeInMillis(arg3.getTimeInMillis());
        return v0;
    }

    static DateFormat getYearAbbrMonthDayFormat(Locale arg1) {
        return UtcDates.getAndroidFormat("yMMMd", arg1);
    }

    static DateFormat getYearMonthFormat(Locale arg1) {
        return UtcDates.getAndroidFormat("yMMMM", arg1);
    }

    static DateFormat getYearMonthWeekdayDayFormat(Locale arg1) {
        return UtcDates.getAndroidFormat("yMMMMEEEEd", arg1);
    }

    private static String removeYearFromDateFormatPattern(String arg5) {
        int v0 = UtcDates.findCharactersInDateFormatPattern(arg5, "yY", 1, 0);
        if(v0 >= arg5.length()) {
            return arg5;
        }

        String v1 = "EMd";
        int v3 = UtcDates.findCharactersInDateFormatPattern(arg5, v1, 1, v0);
        if(v3 < arg5.length()) {
            v1 = "EMd,";
        }

        return arg5.replace(arg5.substring(UtcDates.findCharactersInDateFormatPattern(arg5, v1, -1, v0) + 1, v3), " ").trim();
    }

    static void setTimeSource(TimeSource arg1) {
        UtcDates.timeSourceRef.set(arg1);
    }
}

