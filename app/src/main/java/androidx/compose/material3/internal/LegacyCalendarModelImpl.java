package androidx.compose.material3.internal;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 12\u00020\u0001:\u00011B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0015\u001A\u00020\u00162\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u0019H\u0016J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0018\u001A\u00020\u0019H\u0016J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\bH\u0016J\u0018\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\fH\u0016J\u0010\u0010\u001F\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\bH\u0016J\u0018\u0010 \u001A\u00020\u001B2\u0006\u0010!\u001A\u00020\u001B2\u0006\u0010\"\u001A\u00020\fH\u0016J\u0018\u0010#\u001A\u00020\u001B2\u0006\u0010!\u001A\u00020\u001B2\u0006\u0010$\u001A\u00020\fH\u0016J$\u0010%\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\u00192\u0006\u0010\'\u001A\u00020\u00122\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0016J&\u0010(\u001A\u0004\u0018\u00010\b2\u0006\u0010\u001C\u001A\u00020\u00122\u0006\u0010\'\u001A\u00020\u00122\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0016J\b\u0010)\u001A\u00020\u0012H\u0016J\u0010\u0010*\u001A\u00020\f2\u0006\u0010+\u001A\u00020\fH\u0002J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010,\u001A\u00020-H\u0002J\f\u0010.\u001A\u00020-*\u00020\u001BH\u0002J\u0014\u0010.\u001A\u00020-*\u00020\b2\u0006\u0010/\u001A\u000200H\u0002R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER&\u0010\u000F\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u00062"}, d2={"Landroidx/compose/material3/internal/LegacyCalendarModelImpl;", "Landroidx/compose/material3/internal/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/util/Locale;)V", "today", "Landroidx/compose/material3/internal/CalendarDate;", "getToday", "()Landroidx/compose/material3/internal/CalendarDate;", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "weekdayNames", "", "Lkotlin/Pair;", "", "getWeekdayNames", "()Ljava/util/List;", "getDateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "getCanonicalDate", "timeInMillis", "", "getMonth", "Landroidx/compose/material3/internal/CalendarMonth;", "date", "year", "month", "getDayOfWeek", "plusMonths", "from", "addedMonthsCount", "minusMonths", "subtractedMonthsCount", "formatWithPattern", "utcTimeMillis", "pattern", "parse", "toString", "dayInISO8601", "day", "firstDayCalendar", "Ljava/util/Calendar;", "toCalendar", "timeZone", "Ljava/util/TimeZone;", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LegacyCalendarModelImpl extends CalendarModel {
    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\n\u0010\t\u001A\u00060\nj\u0002`\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rJ0\u0010\u0012\u001A\u00020\u00132\u0006\u0010\b\u001A\u00020\u00052\n\u0010\t\u001A\u00060\nj\u0002`\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rH\u0002R\u0014\u0010\u000E\u001A\u00020\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2={"Landroidx/compose/material3/internal/LegacyCalendarModelImpl$Companion;", "", "<init>", "()V", "formatWithPattern", "", "utcTimeMillis", "", "pattern", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "cache", "", "utcTimeZone", "Ljava/util/TimeZone;", "getUtcTimeZone$material3", "()Ljava/util/TimeZone;", "getCachedSimpleDateFormat", "Ljava/text/SimpleDateFormat;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final String formatWithPattern(long arg1, String arg3, Locale arg4, Map arg5) {
            SimpleDateFormat v3 = this.getCachedSimpleDateFormat(arg3, arg4, arg5);
            Calendar v0 = Calendar.getInstance(this.getUtcTimeZone$material3());
            v0.setTimeInMillis(arg1);
            return v3.format(Long.valueOf(v0.getTimeInMillis()));
        }

        private final SimpleDateFormat getCachedSimpleDateFormat(String arg2, Locale arg3, Map arg4) {
            String v1 = arg2 + arg3.toLanguageTag();
            Object v0 = arg4.get(v1);
            if(v0 == null) {
                SimpleDateFormat v0_1 = new SimpleDateFormat(arg2, arg3);
                v0_1.setTimeZone(LegacyCalendarModelImpl.Companion.getUtcTimeZone$material3());
                arg4.put(v1, v0_1);
            }

            return ((SimpleDateFormat)v0);
        }

        public final TimeZone getUtcTimeZone$material3() {
            return LegacyCalendarModelImpl.utcTimeZone;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final int firstDayOfWeek;
    private static final TimeZone utcTimeZone;
    private final List weekdayNames;

    static {
        LegacyCalendarModelImpl.Companion = new Companion(null);
        LegacyCalendarModelImpl.$stable = 8;
        LegacyCalendarModelImpl.utcTimeZone = TimeZone.getTimeZone("UTC");
    }

    public LegacyCalendarModelImpl(Locale arg9) {
        super(arg9);
        this.firstDayOfWeek = this.dayInISO8601(Calendar.getInstance(arg9).getFirstDayOfWeek());
        List v0 = CollectionsKt.createListBuilder();
        String[] v1 = new DateFormatSymbols(arg9).getWeekdays();
        String[] v9 = new DateFormatSymbols(arg9).getShortWeekdays();
        List v2 = ArraysKt.drop(((Object[])v1), 2);
        int v3 = v2.size();
        int v4;
        for(v4 = 0; v4 < v3; ++v4) {
            v0.add(new Pair(v2.get(v4), v9[v4 + 2]));
        }

        v0.add(new Pair(v1[1], v9[1]));
        this.weekdayNames = CollectionsKt.build(v0);
    }

    public static final TimeZone access$getUtcTimeZone$cp() {
        return LegacyCalendarModelImpl.utcTimeZone;
    }

    private final int dayInISO8601(int arg1) {
        int v0 = 7;
        arg1 = (arg1 + 6) % v0;
        if(arg1 == 0) {
            return v0;
        }

        return arg1;
    }

    public String formatWithPattern(long arg7, String arg9, Locale arg10) {
        return LegacyCalendarModelImpl.Companion.formatWithPattern(arg7, arg9, arg10, this.getFormatterCache$material3());
    }

    public CalendarDate getCanonicalDate(long arg7) {
        Calendar v6 = Calendar.getInstance(LegacyCalendarModelImpl.utcTimeZone);
        v6.setTimeInMillis(arg7);
        v6.set(11, 0);
        v6.set(12, 0);
        v6.set(13, 0);
        v6.set(14, 0);
        return new CalendarDate(v6.get(1), v6.get(2) + 1, v6.get(5), v6.getTimeInMillis());
    }

    public DateInputFormat getDateInputFormat(Locale arg1) {
        DateFormat v0 = DateFormat.getDateInstance(3, arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type java.text.SimpleDateFormat");
        return CalendarModelKt.datePatternAsInputFormat(((SimpleDateFormat)v0).toPattern());
    }

    public int getDayOfWeek(CalendarDate arg2) {
        return this.dayInISO8601(this.toCalendar(arg2, TimeZone.getDefault()).get(7));
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    private final CalendarMonth getMonth(Calendar arg9) {
        int v0 = this.dayInISO8601(arg9.get(7)) - this.getFirstDayOfWeek();
        if(v0 < 0) {
            v0 += 7;
        }

        return new CalendarMonth(arg9.get(1), arg9.get(2) + 1, arg9.getActualMaximum(5), v0, arg9.getTimeInMillis());
    }

    public CalendarMonth getMonth(int arg3, int arg4) {
        Calendar v0 = Calendar.getInstance(LegacyCalendarModelImpl.utcTimeZone);
        v0.clear();
        v0.set(1, arg3);
        v0.set(2, arg4 - 1);
        v0.set(5, 1);
        return this.getMonth(v0);
    }

    public CalendarMonth getMonth(long arg2) {
        Calendar v0 = Calendar.getInstance(LegacyCalendarModelImpl.utcTimeZone);
        v0.setTimeInMillis(arg2);
        v0.set(5, 1);
        v0.set(11, 0);
        v0.set(12, 0);
        v0.set(13, 0);
        v0.set(14, 0);
        return this.getMonth(v0);
    }

    public CalendarMonth getMonth(CalendarDate arg2) {
        return this.getMonth(arg2.getYear(), arg2.getMonth());
    }

    public CalendarDate getToday() {
        Calendar v9 = Calendar.getInstance();
        v9.set(11, 0);
        v9.set(12, 0);
        v9.set(13, 0);
        v9.set(14, 0);
        return new CalendarDate(v9.get(1), 1 + v9.get(2), v9.get(5), v9.getTimeInMillis() + (((long)(v9.get(15) + v9.get(16)))));
    }

    public List getWeekdayNames() {
        return this.weekdayNames;
    }

    public CalendarMonth minusMonths(CalendarMonth arg2, int arg3) {
        if(arg3 <= 0) {
            return arg2;
        }

        Calendar v2 = this.toCalendar(arg2);
        v2.add(2, -arg3);
        return this.getMonth(v2);
    }

    public CalendarDate parse(String arg7, String arg8, Locale arg9) {
        SimpleDateFormat v6 = new SimpleDateFormat(arg8);
        TimeZone v8 = LegacyCalendarModelImpl.utcTimeZone;
        v6.setTimeZone(v8);
        v6.setLenient(false);
        CalendarDate v9 = null;
        try {
            Date v6_1 = v6.parse(arg7);
            if(v6_1 == null) {
                return v9;
            }

            Calendar v7 = Calendar.getInstance(v8);
            v7.setTime(v6_1);
            return new CalendarDate(v7.get(1), v7.get(2) + 1, v7.get(5), v7.getTimeInMillis());
        }
        catch(ParseException ) {
            return v9;
        }
    }

    public CalendarMonth plusMonths(CalendarMonth arg2, int arg3) {
        if(arg3 <= 0) {
            return arg2;
        }

        Calendar v2 = this.toCalendar(arg2);
        v2.add(2, arg3);
        return this.getMonth(v2);
    }

    private final Calendar toCalendar(CalendarDate arg2, TimeZone arg3) {
        Calendar v1 = Calendar.getInstance(arg3);
        v1.clear();
        v1.set(1, arg2.getYear());
        v1.set(2, arg2.getMonth() - 1);
        v1.set(5, arg2.getDayOfMonth());
        return v1;
    }

    private final Calendar toCalendar(CalendarMonth arg3) {
        Calendar v2 = Calendar.getInstance(LegacyCalendarModelImpl.utcTimeZone);
        v2.setTimeInMillis(arg3.getStartUtcTimeMillis());
        return v2;
    }

    public String toString() {
        return "LegacyCalendarModel";
    }
}

