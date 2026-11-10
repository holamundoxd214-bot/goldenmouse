package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000E\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0016J\u0016\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0018J\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0003HÆ\u0003J\t\u0010 \u001A\u00020\bHÆ\u0003J;\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001A\u00020\u0003HÖ\u0001J\t\u0010&\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0011¨\u0006\'"}, d2={"Landroidx/compose/material3/internal/CalendarMonth;", "", "year", "", "month", "numberOfDays", "daysFromStartOfWeekToFirstOfMonth", "startUtcTimeMillis", "", "<init>", "(IIIIJ)V", "getYear", "()I", "getMonth", "getNumberOfDays", "getDaysFromStartOfWeekToFirstOfMonth", "getStartUtcTimeMillis", "()J", "endUtcTimeMillis", "getEndUtcTimeMillis", "indexIn", "years", "Lkotlin/ranges/IntRange;", "format", "", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "skeleton", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CalendarMonth {
    public static final int $stable;
    private final int daysFromStartOfWeekToFirstOfMonth;
    private final long endUtcTimeMillis;
    private final int month;
    private final int numberOfDays;
    private final long startUtcTimeMillis;
    private final int year;

    static {
    }

    public CalendarMonth(int arg1, int arg2, int arg3, int arg4, long arg5) {
        super();
        this.year = arg1;
        this.month = arg2;
        this.numberOfDays = arg3;
        this.daysFromStartOfWeekToFirstOfMonth = arg4;
        this.startUtcTimeMillis = arg5;
        this.endUtcTimeMillis = arg5 + (((long)arg3)) * 86400000 - 1;
    }

    public final int component1() {
        return this.year;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.numberOfDays;
    }

    public final int component4() {
        return this.daysFromStartOfWeekToFirstOfMonth;
    }

    public final long component5() {
        return this.startUtcTimeMillis;
    }

    public final CalendarMonth copy(int arg1, int arg2, int arg3, int arg4, long arg5) {
        return new CalendarMonth(arg1, arg2, arg3, arg4, arg5);
    }

    public static CalendarMonth copy$default(CalendarMonth arg0, int arg1, int arg2, int arg3, int arg4, long arg5, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.year;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.month;
        }

        if((arg7 & 4) != 0) {
            arg3 = arg0.numberOfDays;
        }

        if((arg7 & 8) != 0) {
            arg4 = arg0.daysFromStartOfWeekToFirstOfMonth;
        }

        if((arg7 & 16) != 0) {
            arg5 = arg0.startUtcTimeMillis;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg6) {
        if(this == (((CalendarMonth)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof CalendarMonth)) {
            return 0;
        }

        if(this.year != ((CalendarMonth)arg6).year) {
            return 0;
        }

        if(this.month != ((CalendarMonth)arg6).month) {
            return 0;
        }

        if(this.numberOfDays != ((CalendarMonth)arg6).numberOfDays) {
            return 0;
        }

        if(this.daysFromStartOfWeekToFirstOfMonth != ((CalendarMonth)arg6).daysFromStartOfWeekToFirstOfMonth) {
            return 0;
        }

        if(this.startUtcTimeMillis != ((CalendarMonth)arg6).startUtcTimeMillis) {
            return 0;
        }

        return 1;
    }

    public final String format(CalendarModel arg2, String arg3) {
        return arg2.formatWithSkeleton(this, arg3, arg2.getLocale());
    }

    public final int getDaysFromStartOfWeekToFirstOfMonth() {
        return this.daysFromStartOfWeekToFirstOfMonth;
    }

    public final long getEndUtcTimeMillis() {
        return this.endUtcTimeMillis;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getNumberOfDays() {
        return this.numberOfDays;
    }

    public final long getStartUtcTimeMillis() {
        return this.startUtcTimeMillis;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.year) * 0x1F + Integer.hashCode(this.month)) * 0x1F + Integer.hashCode(this.numberOfDays)) * 0x1F + Integer.hashCode(this.daysFromStartOfWeekToFirstOfMonth)) * 0x1F + Long.hashCode(this.startUtcTimeMillis);
    }

    public final int indexIn(IntRange arg2) {
        return (this.year - arg2.getFirst()) * 12 + this.month - 1;
    }

    public String toString() {
        return "CalendarMonth(year=" + this.year + ", month=" + this.month + ", numberOfDays=" + this.numberOfDays + ", daysFromStartOfWeekToFirstOfMonth=" + this.daysFromStartOfWeekToFirstOfMonth + ", startUtcTimeMillis=" + this.startUtcTimeMillis + ')';
    }
}

