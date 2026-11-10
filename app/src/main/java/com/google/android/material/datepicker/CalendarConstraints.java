package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
import java.util.Objects;

public final class CalendarConstraints implements Parcelable {
    class com.google.android.material.datepicker.CalendarConstraints$1 implements Parcelable$Creator {
        com.google.android.material.datepicker.CalendarConstraints$1() {
            super();
        }

        public CalendarConstraints createFromParcel(Parcel arg9) {
            return new CalendarConstraints(arg9.readParcelable(Month.class.getClassLoader()), arg9.readParcelable(Month.class.getClassLoader()), arg9.readParcelable(DateValidator.class.getClassLoader()), arg9.readParcelable(Month.class.getClassLoader()), arg9.readInt(), null);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public CalendarConstraints[] newArray(int arg1) {
            return new CalendarConstraints[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END;
        static final long DEFAULT_START;
        private long end;
        private int firstDayOfWeek;
        private Long openAt;
        private long start;
        private DateValidator validator;

        static {
            Builder.DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
            Builder.DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        }

        public Builder() {
            super();
            this.start = Builder.DEFAULT_START;
            this.end = Builder.DEFAULT_END;
            this.validator = DateValidatorPointForward.from(-9223372036854775808L);
        }

        Builder(CalendarConstraints arg3) {
            super();
            this.start = Builder.DEFAULT_START;
            this.end = Builder.DEFAULT_END;
            this.validator = DateValidatorPointForward.from(-9223372036854775808L);
            this.start = arg3.start.timeInMillis;
            this.end = arg3.end.timeInMillis;
            this.openAt = Long.valueOf(arg3.openAt.timeInMillis);
            this.firstDayOfWeek = arg3.firstDayOfWeek;
            this.validator = arg3.validator;
        }

        public CalendarConstraints build() {
            Bundle v0 = new Bundle();
            v0.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.validator);
            Month v4 = Month.create(this.start);
            Month v5 = Month.create(this.end);
            Parcelable v6 = v0.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long v0_1 = this.openAt;
            Month v0_2 = v0_1 == null ? null : Month.create(v0_1.longValue());
            return new CalendarConstraints(v4, v5, ((DateValidator)v6), v0_2, this.firstDayOfWeek, null);
        }

        public Builder setEnd(long arg1) {
            this.end = arg1;
            return this;
        }

        public Builder setFirstDayOfWeek(int arg1) {
            this.firstDayOfWeek = arg1;
            return this;
        }

        public Builder setOpenAt(long arg1) {
            this.openAt = Long.valueOf(arg1);
            return this;
        }

        public Builder setStart(long arg1) {
            this.start = arg1;
            return this;
        }

        public Builder setValidator(DateValidator arg2) {
            Objects.requireNonNull(arg2, "validator cannot be null");
            this.validator = arg2;
            return this;
        }
    }

    public interface DateValidator extends Parcelable {
        boolean isValid(long arg1);
    }

    public static final Parcelable$Creator CREATOR;
    private final Month end;
    private final int firstDayOfWeek;
    private final int monthSpan;
    private Month openAt;
    private final Month start;
    private final DateValidator validator;
    private final int yearSpan;

    static {
        CalendarConstraints.CREATOR = new com.google.android.material.datepicker.CalendarConstraints$1();
    }

    private CalendarConstraints(Month arg2, Month arg3, DateValidator arg4, Month arg5, int arg6) {
        super();
        Objects.requireNonNull(arg2, "start cannot be null");
        Objects.requireNonNull(arg3, "end cannot be null");
        Objects.requireNonNull(arg4, "validator cannot be null");
        this.start = arg2;
        this.end = arg3;
        this.openAt = arg5;
        this.firstDayOfWeek = arg6;
        this.validator = arg4;
        if(arg5 != null) {
            if(arg2.compareTo(arg5) <= 0) {
            }
            else {
                throw new IllegalArgumentException("start Month cannot be after current Month");
            }
        }

        if(arg5 != null) {
            if(arg5.compareTo(arg3) <= 0) {
            }
            else {
                throw new IllegalArgumentException("current Month cannot be after end Month");
            }
        }

        if(arg6 >= 0 && arg6 <= UtcDates.getUtcCalendar().getMaximum(7)) {
            this.monthSpan = arg2.monthsUntil(arg3) + 1;
            this.yearSpan = arg3.year - arg2.year + 1;
            return;
        }

        throw new IllegalArgumentException("firstDayOfWeek is not valid");
    }

    CalendarConstraints(Month arg1, Month arg2, DateValidator arg3, Month arg4, int arg5, com.google.android.material.datepicker.CalendarConstraints$1 arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    static Month access$100(CalendarConstraints arg0) {
        return arg0.start;
    }

    static Month access$200(CalendarConstraints arg0) {
        return arg0.end;
    }

    static Month access$300(CalendarConstraints arg0) {
        return arg0.openAt;
    }

    static int access$400(CalendarConstraints arg0) {
        return arg0.firstDayOfWeek;
    }

    static DateValidator access$500(CalendarConstraints arg0) {
        return arg0.validator;
    }

    Month clamp(Month arg2) {
        if(arg2.compareTo(this.start) < 0) {
            return this.start;
        }

        if(arg2.compareTo(this.end) > 0) {
            return this.end;
        }

        return arg2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object arg5) {
        if(this == (((CalendarConstraints)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CalendarConstraints)) {
            return 0;
        }

        if((this.start.equals(((CalendarConstraints)arg5).start)) && (this.end.equals(((CalendarConstraints)arg5).end)) && (ObjectsCompat.equals(this.openAt, ((CalendarConstraints)arg5).openAt)) && this.firstDayOfWeek == ((CalendarConstraints)arg5).firstDayOfWeek && (this.validator.equals(((CalendarConstraints)arg5).validator))) {
            return 1;
        }

        return 0;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    Month getEnd() {
        return this.end;
    }

    public long getEndMs() {
        return this.end.timeInMillis;
    }

    int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    int getMonthSpan() {
        return this.monthSpan;
    }

    Month getOpenAt() {
        return this.openAt;
    }

    public Long getOpenAtMs() {
        Month v2 = this.openAt;
        if(v2 == null) {
            return null;
        }

        return Long.valueOf(v2.timeInMillis);
    }

    Month getStart() {
        return this.start;
    }

    public long getStartMs() {
        return this.start.timeInMillis;
    }

    int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, Integer.valueOf(this.firstDayOfWeek), this.validator});
    }

    boolean isWithinBounds(long arg5) {
        if(this.start.getDay(1) <= arg5 && arg5 <= this.end.getDay(this.end.daysInMonth)) {
            return 1;
        }

        return 0;
    }

    void setOpenAt(Month arg1) {
        this.openAt = arg1;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeParcelable(this.start, 0);
        arg2.writeParcelable(this.end, 0);
        arg2.writeParcelable(this.openAt, 0);
        arg2.writeParcelable(this.validator, 0);
        arg2.writeInt(this.firstDayOfWeek);
    }
}

