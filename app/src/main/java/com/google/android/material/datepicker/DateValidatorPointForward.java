package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.Arrays;

public class DateValidatorPointForward implements DateValidator {
    class com.google.android.material.datepicker.DateValidatorPointForward$1 implements Parcelable$Creator {
        com.google.android.material.datepicker.DateValidatorPointForward$1() {
            super();
        }

        public DateValidatorPointForward createFromParcel(Parcel arg3) {
            return new DateValidatorPointForward(arg3.readLong(), null);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public DateValidatorPointForward[] newArray(int arg1) {
            return new DateValidatorPointForward[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;
    private final long point;

    static {
        DateValidatorPointForward.CREATOR = new com.google.android.material.datepicker.DateValidatorPointForward$1();
    }

    private DateValidatorPointForward(long arg1) {
        super();
        this.point = arg1;
    }

    DateValidatorPointForward(long arg1, com.google.android.material.datepicker.DateValidatorPointForward$1 arg3) {
        this(arg1);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object arg6) {
        if(this == (((DateValidatorPointForward)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof DateValidatorPointForward)) {
            return 0;
        }

        if(this.point == ((DateValidatorPointForward)arg6).point) {
            return 1;
        }

        return 0;
    }

    public static DateValidatorPointForward from(long arg1) {
        return new DateValidatorPointForward(arg1);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    public boolean isValid(long arg3) {
        if(arg3 >= this.point) {
            return 1;
        }

        return 0;
    }

    public static DateValidatorPointForward now() {
        return DateValidatorPointForward.from(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    public void writeToParcel(Parcel arg3, int arg4) {
        arg3.writeLong(this.point);
    }
}

