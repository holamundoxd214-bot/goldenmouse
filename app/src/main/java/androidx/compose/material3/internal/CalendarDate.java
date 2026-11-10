package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u0000H\u0096\u0002J\u0016\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0013J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0007HÆ\u0003J1\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u001D2\b\u0010\u0011\u001A\u0004\u0018\u00010\u001EHÖ\u0003J\t\u0010\u001F\u001A\u00020\u0003HÖ\u0001J\t\u0010 \u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006!"}, d2={"Landroidx/compose/material3/internal/CalendarDate;", "", "year", "", "month", "dayOfMonth", "utcTimeMillis", "", "<init>", "(IIIJ)V", "getYear", "()I", "getMonth", "getDayOfMonth", "getUtcTimeMillis", "()J", "compareTo", "other", "format", "", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "skeleton", "component1", "component2", "component3", "component4", "copy", "equals", "", "", "hashCode", "toString", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CalendarDate implements Comparable {
    public static final int $stable;
    private final int dayOfMonth;
    private final int month;
    private final long utcTimeMillis;
    private final int year;

    static {
    }

    public CalendarDate(int arg1, int arg2, int arg3, long arg4) {
        super();
        this.year = arg1;
        this.month = arg2;
        this.dayOfMonth = arg3;
        this.utcTimeMillis = arg4;
    }

    public int compareTo(CalendarDate arg3) {
        return Intrinsics.compare(this.utcTimeMillis, arg3.utcTimeMillis);
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((CalendarDate)arg1));
    }

    public final int component1() {
        return this.year;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.dayOfMonth;
    }

    public final long component4() {
        return this.utcTimeMillis;
    }

    public final CalendarDate copy(int arg1, int arg2, int arg3, long arg4) {
        return new CalendarDate(arg1, arg2, arg3, arg4);
    }

    public static CalendarDate copy$default(CalendarDate arg0, int arg1, int arg2, int arg3, long arg4, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.year;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.month;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.dayOfMonth;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.utcTimeMillis;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg6) {
        if(this == (((CalendarDate)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof CalendarDate)) {
            return 0;
        }

        if(this.year != ((CalendarDate)arg6).year) {
            return 0;
        }

        if(this.month != ((CalendarDate)arg6).month) {
            return 0;
        }

        if(this.dayOfMonth != ((CalendarDate)arg6).dayOfMonth) {
            return 0;
        }

        if(this.utcTimeMillis != ((CalendarDate)arg6).utcTimeMillis) {
            return 0;
        }

        return 1;
    }

    public final String format(CalendarModel arg2, String arg3) {
        return arg2.formatWithSkeleton(this, arg3, arg2.getLocale());
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getMonth() {
        return this.month;
    }

    public final long getUtcTimeMillis() {
        return this.utcTimeMillis;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return ((Integer.hashCode(this.year) * 0x1F + Integer.hashCode(this.month)) * 0x1F + Integer.hashCode(this.dayOfMonth)) * 0x1F + Long.hashCode(this.utcTimeMillis);
    }

    public String toString() {
        return "CalendarDate(year=" + this.year + ", month=" + this.month + ", dayOfMonth=" + this.dayOfMonth + ", utcTimeMillis=" + this.utcTimeMillis + ')';
    }
}

