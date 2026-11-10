package androidx.compose.material3.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b!\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001B\u0010\u001C\u001A\u00020\u001D2\f\b\u0002\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H&¢\u0006\u0002\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\u00102\u0006\u0010 \u001A\u00020!H&J\u0010\u0010\"\u001A\u00020#2\u0006\u0010 \u001A\u00020!H&J\u0010\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u0010H&J\u0018\u0010\"\u001A\u00020#2\u0006\u0010%\u001A\u00020\u00142\u0006\u0010&\u001A\u00020\u0014H&J\u0010\u0010\'\u001A\u00020\u00142\u0006\u0010$\u001A\u00020\u0010H&J\u0018\u0010(\u001A\u00020#2\u0006\u0010)\u001A\u00020#2\u0006\u0010*\u001A\u00020\u0014H&J\u0018\u0010+\u001A\u00020#2\u0006\u0010)\u001A\u00020#2\u0006\u0010,\u001A\u00020\u0014H&J)\u0010-\u001A\u00020\f2\u0006\u0010&\u001A\u00020#2\u0006\u0010.\u001A\u00020\f2\f\b\u0002\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010/J)\u0010-\u001A\u00020\f2\u0006\u0010$\u001A\u00020\u00102\u0006\u0010.\u001A\u00020\f2\f\b\u0002\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u00100J)\u00101\u001A\u00020\f2\u0006\u00102\u001A\u00020!2\u0006\u00103\u001A\u00020\f2\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H&¢\u0006\u0002\u00104J+\u00105\u001A\u0004\u0018\u00010\u00102\u0006\u0010$\u001A\u00020\f2\u0006\u00103\u001A\u00020\f2\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H&¢\u0006\u0002\u00106R\u0017\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\bR \u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0012\u0010\u000F\u001A\u00020\u0010X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001A\u00020\u0014X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00190\u0018X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001B¨\u00067"}, d2={"Landroidx/compose/material3/internal/CalendarModel;", "", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/util/Locale;)V", "getLocale", "()Ljava/util/Locale;", "Ljava/util/Locale;", "formatterCache", "", "", "getFormatterCache$material3", "()Ljava/util/Map;", "today", "Landroidx/compose/material3/internal/CalendarDate;", "getToday", "()Landroidx/compose/material3/internal/CalendarDate;", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "weekdayNames", "", "Lkotlin/Pair;", "getWeekdayNames", "()Ljava/util/List;", "getDateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "(Ljava/util/Locale;)Landroidx/compose/material3/internal/DateInputFormat;", "getCanonicalDate", "timeInMillis", "", "getMonth", "Landroidx/compose/material3/internal/CalendarMonth;", "date", "year", "month", "getDayOfWeek", "plusMonths", "from", "addedMonthsCount", "minusMonths", "subtractedMonthsCount", "formatWithSkeleton", "skeleton", "(Landroidx/compose/material3/internal/CalendarMonth;Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "(Landroidx/compose/material3/internal/CalendarDate;Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "formatWithPattern", "utcTimeMillis", "pattern", "(JLjava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "parse", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Locale;)Landroidx/compose/material3/internal/CalendarDate;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class CalendarModel {
    public static final int $stable = 8;
    private final Map formatterCache;
    private final Locale locale;

    static {
    }

    public CalendarModel(Locale arg1) {
        super();
        this.locale = arg1;
        this.formatterCache = new LinkedHashMap();
    }

    public abstract String formatWithPattern(long arg1, String arg2, Locale arg3);

    public final String formatWithSkeleton(CalendarDate arg3, String arg4, Locale arg5) {
        return CalendarModel_androidKt.formatWithSkeleton(arg3.getUtcTimeMillis(), arg4, arg5, this.formatterCache);
    }

    public final String formatWithSkeleton(CalendarMonth arg3, String arg4, Locale arg5) {
        return CalendarModel_androidKt.formatWithSkeleton(arg3.getStartUtcTimeMillis(), arg4, arg5, this.formatterCache);
    }

    public static String formatWithSkeleton$default(CalendarModel arg0, CalendarDate arg1, String arg2, Locale arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 4) != 0) {
                arg3 = arg0.locale;
            }

            return arg0.formatWithSkeleton(arg1, arg2, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatWithSkeleton");
    }

    public static String formatWithSkeleton$default(CalendarModel arg0, CalendarMonth arg1, String arg2, Locale arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 4) != 0) {
                arg3 = arg0.locale;
            }

            return arg0.formatWithSkeleton(arg1, arg2, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatWithSkeleton");
    }

    public abstract CalendarDate getCanonicalDate(long arg1);

    public abstract DateInputFormat getDateInputFormat(Locale arg1);

    public static DateInputFormat getDateInputFormat$default(CalendarModel arg0, Locale arg1, int arg2, Object arg3) {
        if(arg3 == null) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.locale;
            }

            return arg0.getDateInputFormat(arg1);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDateInputFormat");
    }

    public abstract int getDayOfWeek(CalendarDate arg1);

    public abstract int getFirstDayOfWeek();

    public final Map getFormatterCache$material3() {
        return this.formatterCache;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public abstract CalendarMonth getMonth(long arg1);

    public abstract CalendarMonth getMonth(CalendarDate arg1);

    public abstract CalendarMonth getMonth(int arg1, int arg2);

    public abstract CalendarDate getToday();

    public abstract List getWeekdayNames();

    public abstract CalendarMonth minusMonths(CalendarMonth arg1, int arg2);

    public abstract CalendarDate parse(String arg1, String arg2, Locale arg3);

    public abstract CalendarMonth plusMonths(CalendarMonth arg1, int arg2);
}

