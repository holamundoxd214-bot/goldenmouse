package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\u001A\u0019\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0001H\u0080\b\u001A\u0019\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0080\b\u001AC\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001AO\u0010\u0014\u001A\u00020\u00072\n\u0010\u0015\u001A\u00060\u0016j\u0002`\u00172\b\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u0011H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001AM\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\t2\b\u0010\u001D\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u0011H\u0007¢\u0006\u0004\b\u001E\u0010\u001F\u001AY\u0010 \u001A\u00020\u001B2\n\u0010\u0015\u001A\u00060\u0016j\u0002`\u00172\b\u0010\u001C\u001A\u0004\u0018\u00010\t2\b\u0010\u001D\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u0011H\u0007¢\u0006\u0004\b!\u0010\"\u001A\u0016\u0010#\u001A\u00020$*\u00020\u00072\b\u0010%\u001A\u0004\u0018\u00010\tH\u0007\u001A\u000E\u0010&\u001A\u0004\u0018\u00010\t*\u00020\u0007H\u0007\u001A\u0014\u0010\'\u001A\u00020$*\u00020\u00072\u0006\u0010(\u001A\u00020\u000BH\u0007\u001A\f\u0010)\u001A\u00020\u000B*\u00020\u0007H\u0007\u001A \u0010*\u001A\u00020$*\u00020\u001B2\b\u0010+\u001A\u0004\u0018\u00010\t2\b\u0010,\u001A\u0004\u0018\u00010\tH\u0007\u001A\u000E\u0010-\u001A\u0004\u0018\u00010\t*\u00020\u001BH\u0007\u001A\u000E\u0010.\u001A\u0004\u0018\u00010\t*\u00020\u001BH\u0007\u001A\u0014\u0010\'\u001A\u00020$*\u00020\u001B2\u0006\u0010(\u001A\u00020\u000BH\u0007\u001A\f\u0010)\u001A\u00020\u000B*\u00020\u001BH\u0007\u001A\u0010\u0010/\u001A\u00020\u000B2\u0006\u00100\u001A\u000201H\u0003\u001A\u0010\u00102\u001A\u0002012\u0006\u0010(\u001A\u00020\u000BH\u0003\u001A\u0019\u00103\u001A\u0004\u0018\u00010\t2\b\u00104\u001A\u0004\u0018\u000101H\u0003¢\u0006\u0002\u00105\u001A\u0019\u00106\u001A\u0004\u0018\u0001012\b\u0010%\u001A\u0004\u0018\u00010\tH\u0003¢\u0006\u0002\u00107¨\u00068"}, d2={"formatDatePickerNavigateToYearString", "", "template", "localizedYear", "formatHeadlineDescription", "verboseDateDescription", "rememberDatePickerState", "Landroidx/compose/material3/DatePickerState;", "initialSelectedDate", "Ljava/time/LocalDate;", "initialDisplayedMonth", "Ljava/time/YearMonth;", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "rememberDatePickerState-EU0dCGE", "(Ljava/time/LocalDate;Ljava/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "DatePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/time/LocalDate;Ljava/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "rememberDateRangePickerState", "Landroidx/compose/material3/DateRangePickerState;", "initialSelectedStartDate", "initialSelectedEndDate", "rememberDateRangePickerState-IlFM19s", "(Ljava/time/LocalDate;Ljava/time/LocalDate;Ljava/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "DateRangePickerState", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/time/LocalDate;Ljava/time/LocalDate;Ljava/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "setSelectedDate", "", "date", "getSelectedDate", "setDisplayedMonth", "yearMonth", "getDisplayedMonth", "setSelection", "startDate", "endDate", "getSelectedStartDate", "getSelectedEndDate", "getYearMonth", "millisUtcFirstOfMonth", "", "getYearMonthMillisUtc", "getLocalDate", "millisUtc", "(Ljava/lang/Long;)Ljava/time/LocalDate;", "getLocalDateMillisUtc", "(Ljava/time/LocalDate;)Ljava/lang/Long;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DatePicker_jvmKt {
    public static final DatePickerState DatePickerState-sHin3Bw(Locale arg2, LocalDate arg3, YearMonth arg4, IntRange arg5, int arg6, SelectableDates arg7) {
        Long v3 = DatePicker_jvmKt.getLocalDateMillisUtc(arg3);
        Long v4 = arg4 != null ? Long.valueOf(DatePicker_jvmKt.getYearMonthMillisUtc(arg4)) : null;
        return DatePickerKt.DatePickerState-sHin3Bw(arg2, v3, v4, arg5, arg6, arg7);
    }

    public static DatePickerState DatePickerState-sHin3Bw$default(Locale arg6, LocalDate arg7, YearMonth arg8, IntRange arg9, int arg10, SelectableDates arg11, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg8 = arg7 != null ? YearMonth.from(arg7) : null;
        }

        YearMonth v2 = arg8;
        if((arg12 & 8) != 0) {
            arg9 = DatePickerDefaults.INSTANCE.getYearRange();
        }

        IntRange v3 = arg9;
        if((arg12 & 16) != 0) {
            arg10 = DisplayMode.Companion.getPicker-jFl-4v0();
        }

        int v4 = arg10;
        if((arg12 & 0x20) != 0) {
            arg11 = DatePickerDefaults.INSTANCE.getAllDates();
        }

        return DatePicker_jvmKt.DatePickerState-sHin3Bw(arg6, arg7, v2, v3, v4, arg11);
    }

    public static final DateRangePickerState DateRangePickerState-HVP43zI(Locale arg2, LocalDate arg3, LocalDate arg4, YearMonth arg5, IntRange arg6, int arg7, SelectableDates arg8) {
        Long v3 = DatePicker_jvmKt.getLocalDateMillisUtc(arg3);
        Long v4 = DatePicker_jvmKt.getLocalDateMillisUtc(arg4);
        Long v5 = arg5 != null ? Long.valueOf(DatePicker_jvmKt.getYearMonthMillisUtc(arg5)) : null;
        return DateRangePickerKt.DateRangePickerState-HVP43zI(arg2, v3, v4, v5, arg6, arg7, arg8);
    }

    public static DateRangePickerState DateRangePickerState-HVP43zI$default(Locale arg7, LocalDate arg8, LocalDate arg9, YearMonth arg10, IntRange arg11, int arg12, SelectableDates arg13, int arg14, Object arg15) {
        if((arg14 & 8) != 0) {
            arg10 = arg8 != null ? YearMonth.from(arg8) : null;
        }

        YearMonth v3 = arg10;
        if((arg14 & 16) != 0) {
            arg11 = DatePickerDefaults.INSTANCE.getYearRange();
        }

        IntRange v4 = arg11;
        if((arg14 & 0x20) != 0) {
            arg12 = DisplayMode.Companion.getPicker-jFl-4v0();
        }

        int v5 = arg12;
        if((arg14 & 0x40) != 0) {
            arg13 = DatePickerDefaults.INSTANCE.getAllDates();
        }

        return DatePicker_jvmKt.DateRangePickerState-HVP43zI(arg7, arg8, arg9, v3, v4, v5, arg13);
    }

    public static final String formatDatePickerNavigateToYearString(String arg1, String arg2) {
        arg1 = String.format(arg1, Arrays.copyOf(new Object[]{arg2}, 1));
        Intrinsics.checkNotNullExpressionValue(arg1, "format(...)");
        return arg1;
    }

    public static final String formatHeadlineDescription(String arg1, String arg2) {
        arg1 = String.format(arg1, Arrays.copyOf(new Object[]{arg2}, 1));
        Intrinsics.checkNotNullExpressionValue(arg1, "format(...)");
        return arg1;
    }

    public static final YearMonth getDisplayedMonth(DatePickerState arg2) {
        return DatePicker_jvmKt.getYearMonth(arg2.getDisplayedMonthMillis());
    }

    public static final YearMonth getDisplayedMonth(DateRangePickerState arg2) {
        return DatePicker_jvmKt.getYearMonth(arg2.getDisplayedMonthMillis());
    }

    private static final LocalDate getLocalDate(Long arg2) {
        if(arg2 == null) {
            return null;
        }

        return Instant.ofEpochMilli(arg2.longValue()).atZone(ZoneOffset.UTC).toLocalDate();
    }

    private static final Long getLocalDateMillisUtc(LocalDate arg2) {
        if(arg2 == null) {
            return null;
        }

        return Long.valueOf(arg2.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli());
    }

    public static final LocalDate getSelectedDate(DatePickerState arg0) {
        return DatePicker_jvmKt.getLocalDate(arg0.getSelectedDateMillis());
    }

    public static final LocalDate getSelectedEndDate(DateRangePickerState arg0) {
        return DatePicker_jvmKt.getLocalDate(arg0.getSelectedEndDateMillis());
    }

    public static final LocalDate getSelectedStartDate(DateRangePickerState arg0) {
        return DatePicker_jvmKt.getLocalDate(arg0.getSelectedStartDateMillis());
    }

    private static final YearMonth getYearMonth(long arg0) {
        return YearMonth.from(Instant.ofEpochMilli(arg0).atZone(ZoneOffset.UTC));
    }

    private static final long getYearMonthMillisUtc(YearMonth arg2) {
        return arg2.atDay(1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    public static final DatePickerState rememberDatePickerState-EU0dCGE(LocalDate arg11, YearMonth arg12, IntRange arg13, int arg14, SelectableDates arg15, Composer arg16, int arg17, int arg18) {
        int v0 = arg17;
        int v2 = -1802387829;
        Composer v8 = arg16;
        ComposerKt.sourceInformationMarkerStart(v8, v2, "C(rememberDatePickerState)N(initialSelectedDate,initialDisplayedMonth,yearRange,initialDisplayMode:c#material3.DisplayMode,selectableDates)73@3393L283:DatePicker.jvm.kt#uh7d8r");
        Long v3 = null;
        if((arg18 & 2) != 0) {
            arg12 = arg11 != null ? YearMonth.from(arg11) : ((YearMonth)v3);
        }

        if((arg18 & 4) != 0) {
            arg13 = DatePickerDefaults.INSTANCE.getYearRange();
        }

        IntRange v5 = arg13;
        if((arg18 & 8) != 0) {
            arg14 = DisplayMode.Companion.getPicker-jFl-4v0();
        }

        int v6 = arg14;
        if((arg18 & 16) != 0) {
            arg15 = DatePickerDefaults.INSTANCE.getAllDates();
        }

        SelectableDates v7 = arg15;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.jvm.kt:70)");
        }

        Long v11 = arg11 != null ? DatePicker_jvmKt.getLocalDateMillisUtc(arg11) : v3;
        if(arg12 != null) {
            v3 = Long.valueOf(DatePicker_jvmKt.getYearMonthMillisUtc(arg12));
        }

        DatePickerState v11_1 = DatePickerKt.rememberDatePickerState-EU0dCGE(v11, v3, v5, v6, v7, v8, v0 & 0xFF80, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg16);
        return v11_1;
    }

    public static final DateRangePickerState rememberDateRangePickerState-IlFM19s(LocalDate arg12, LocalDate arg13, YearMonth arg14, IntRange arg15, int arg16, SelectableDates arg17, Composer arg18, int arg19, int arg20) {
        int v0 = arg19;
        int v2 = -1580705706;
        Composer v9 = arg18;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(rememberDateRangePickerState)N(initialSelectedStartDate,initialSelectedEndDate,initialDisplayedMonth,yearRange,initialDisplayMode:c#material3.DisplayMode,selectableDates)179@9398L367:DatePicker.jvm.kt#uh7d8r");
        Long v3 = null;
        if((arg20 & 4) != 0) {
            arg14 = arg12 != null ? YearMonth.from(arg12) : ((YearMonth)v3);
        }

        if((arg20 & 8) != 0) {
            arg15 = DatePickerDefaults.INSTANCE.getYearRange();
        }

        IntRange v6 = arg15;
        int v7 = (arg20 & 16) != 0 ? DisplayMode.Companion.getPicker-jFl-4v0() : arg16;
        SelectableDates v8 = (arg20 & 0x20) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : arg17;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.material3.rememberDateRangePickerState (DatePicker.jvm.kt:175)");
        }

        Long v12 = arg12 != null ? DatePicker_jvmKt.getLocalDateMillisUtc(arg12) : v3;
        Long v4 = arg13 != null ? DatePicker_jvmKt.getLocalDateMillisUtc(arg13) : v3;
        if(arg14 != null) {
            v3 = Long.valueOf(DatePicker_jvmKt.getYearMonthMillisUtc(arg14));
        }

        DateRangePickerState v12_1 = DateRangePickerKt.rememberDateRangePickerState-IlFM19s(v12, v4, v3, v6, v7, v8, v9, v0 & 0x7FC00, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg18);
        return v12_1;
    }

    public static final void setDisplayedMonth(DatePickerState arg2, YearMonth arg3) {
        arg2.setDisplayedMonthMillis(DatePicker_jvmKt.getYearMonthMillisUtc(arg3));
    }

    public static final void setDisplayedMonth(DateRangePickerState arg2, YearMonth arg3) {
        arg2.setDisplayedMonthMillis(DatePicker_jvmKt.getYearMonthMillisUtc(arg3));
    }

    public static final void setSelectedDate(DatePickerState arg0, LocalDate arg1) {
        arg0.setSelectedDateMillis(DatePicker_jvmKt.getLocalDateMillisUtc(arg1));
    }

    public static final void setSelection(DateRangePickerState arg0, LocalDate arg1, LocalDate arg2) {
        arg0.setSelection(DatePicker_jvmKt.getLocalDateMillisUtc(arg1), DatePicker_jvmKt.getLocalDateMillisUtc(arg2));
    }
}

