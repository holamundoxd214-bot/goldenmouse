package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Parcelable, Comparable {
    class com.google.android.material.datepicker.Month$1 implements Parcelable$Creator {
        com.google.android.material.datepicker.Month$1() {
            super();
        }

        public Month createFromParcel(Parcel arg1) {
            return Month.create(arg1.readInt(), arg1.readInt());
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public Month[] newArray(int arg1) {
            return new Month[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;
    final int daysInMonth;
    final int daysInWeek;
    private final Calendar firstOfMonth;
    private String longName;
    final int month;
    final long timeInMillis;
    final int year;

    static {
        Month.CREATOR = new com.google.android.material.datepicker.Month$1();
    }

    private Month(Calendar arg4) {
        super();
        arg4.set(5, 1);
        arg4 = UtcDates.getDayCopy(arg4);
        this.firstOfMonth = arg4;
        this.month = arg4.get(2);
        this.year = arg4.get(1);
        this.daysInWeek = arg4.getMaximum(7);
        this.daysInMonth = arg4.getActualMaximum(5);
        this.timeInMillis = arg4.getTimeInMillis();
    }

    public int compareTo(Month arg1) {
        return this.firstOfMonth.compareTo(arg1.firstOfMonth);
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((Month)arg1));
    }

    static Month create(int arg2, int arg3) {
        Calendar v0 = UtcDates.getUtcCalendar();
        v0.set(1, arg2);
        v0.set(2, arg3);
        return new Month(v0);
    }

    static Month create(long arg1) {
        Calendar v0 = UtcDates.getUtcCalendar();
        v0.setTimeInMillis(arg1);
        return new Month(v0);
    }

    static Month current() {
        return new Month(UtcDates.getTodayCalendar());
    }

    int daysFromStartOfWeekToFirstOfMonth(int arg3) {
        int v0 = this.firstOfMonth.get(7);
        if(arg3 > 0) {
        }
        else {
            arg3 = this.firstOfMonth.getFirstDayOfWeek();
        }

        v0 -= arg3;
        if(v0 < 0) {
            v0 += this.daysInWeek;
        }

        return v0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object arg5) {
        if(this == (((Month)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Month)) {
            return 0;
        }

        if(this.month == ((Month)arg5).month && this.year == ((Month)arg5).year) {
            return 1;
        }

        return 0;
    }

    long getDay(int arg2) {
        Calendar v1 = UtcDates.getDayCopy(this.firstOfMonth);
        v1.set(5, arg2);
        return v1.getTimeInMillis();
    }

    int getDayOfMonth(long arg1) {
        Calendar v0 = UtcDates.getDayCopy(this.firstOfMonth);
        v0.setTimeInMillis(arg1);
        return v0.get(5);
    }

    String getLongName() {
        String v0 = this.longName;
        if(v0 == null) {
            v0 = DateStrings.getYearMonth(this.firstOfMonth.getTimeInMillis());
            this.longName = v0;
        }

        return v0;
    }

    long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    Month monthsLater(int arg2) {
        Calendar v1 = UtcDates.getDayCopy(this.firstOfMonth);
        v1.add(2, arg2);
        return new Month(v1);
    }

    int monthsUntil(Month arg3) {
        if((this.firstOfMonth instanceof GregorianCalendar)) {
            return (arg3.year - this.year) * 12 + (arg3.month - this.month);
        }

        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeInt(this.year);
        arg1.writeInt(this.month);
    }
}

