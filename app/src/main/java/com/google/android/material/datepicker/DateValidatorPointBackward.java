package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.Arrays;

public class DateValidatorPointBackward implements DateValidator {
    class com.google.android.material.datepicker.DateValidatorPointBackward$1 implements Parcelable$Creator {
        com.google.android.material.datepicker.DateValidatorPointBackward$1() {
            super();
        }

        public DateValidatorPointBackward createFromParcel(Parcel arg3) {
            return new DateValidatorPointBackward(arg3.readLong(), null);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public DateValidatorPointBackward[] newArray(int arg1) {
            return new DateValidatorPointBackward[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;
    private final long point;

    static {
        DateValidatorPointBackward.CREATOR = new com.google.android.material.datepicker.DateValidatorPointBackward$1();
    }

    private DateValidatorPointBackward(long arg1) {
        super();
        this.point = arg1;
    }

    DateValidatorPointBackward(long arg1, com.google.android.material.datepicker.DateValidatorPointBackward$1 arg3) {
        this(arg1);
    }

    public static DateValidatorPointBackward before(long arg1) {
        return new DateValidatorPointBackward(arg1);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object arg6) {
        if(this == (((DateValidatorPointBackward)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof DateValidatorPointBackward)) {
            return 0;
        }

        if(this.point == ((DateValidatorPointBackward)arg6).point) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    public boolean isValid(long arg3) {
        if(arg3 <= this.point) {
            return 1;
        }

        return 0;
    }

    public static DateValidatorPointBackward now() {
        return DateValidatorPointBackward.before(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    public void writeToParcel(Parcel arg3, int arg4) {
        arg3.writeLong(this.point);
    }
}

