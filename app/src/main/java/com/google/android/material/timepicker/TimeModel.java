package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import com.google.android.material.R$string;
import java.util.Arrays;

class TimeModel implements Parcelable {
    class com.google.android.material.timepicker.TimeModel$1 implements Parcelable$Creator {
        com.google.android.material.timepicker.TimeModel$1() {
            super();
        }

        public TimeModel createFromParcel(Parcel arg1) {
            return new TimeModel(arg1);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public TimeModel[] newArray(int arg1) {
            return new TimeModel[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR = null;
    public static final String NUMBER_FORMAT = "%d";
    public static final String ZERO_LEADING_NUMBER_FORMAT = "%02d";
    final int format;
    int hour;
    private final MaxInputValidator hourInputValidator;
    int minute;
    private final MaxInputValidator minuteInputValidator;
    int period;
    int selection;

    static {
        TimeModel.CREATOR = new com.google.android.material.timepicker.TimeModel$1();
    }

    public TimeModel() {
        this(0);
    }

    public TimeModel(int arg3) {
        this(0, 0, 10, arg3);
    }

    public TimeModel(int arg1, int arg2, int arg3, int arg4) {
        super();
        this.hour = arg1;
        this.minute = arg2;
        this.selection = arg3;
        this.format = arg4;
        this.period = TimeModel.getPeriod(arg1);
        this.minuteInputValidator = new MaxInputValidator(59);
        arg2 = arg4 == 1 ? 23 : 12;
        this.hourInputValidator = new MaxInputValidator(arg2);
    }

    protected TimeModel(Parcel arg4) {
        this(arg4.readInt(), arg4.readInt(), arg4.readInt(), arg4.readInt());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object arg5) {
        if(this == (((TimeModel)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TimeModel)) {
            return 0;
        }

        if(this.hour == ((TimeModel)arg5).hour && this.minute == ((TimeModel)arg5).minute && this.format == ((TimeModel)arg5).format && this.selection == ((TimeModel)arg5).selection) {
            return 1;
        }

        return 0;
    }

    public static String formatText(Resources arg1, CharSequence arg2) {
        return TimeModel.formatText(arg1, arg2, "%02d");
    }

    public static String formatText(Resources arg0, CharSequence arg1, String arg2) {
        try {
            return String.format(arg0.getConfiguration().locale, arg2, Integer.valueOf(Integer.parseInt(String.valueOf(arg1))));
        }
        catch(NumberFormatException ) {
            return null;
        }
    }

    public int getHourContentDescriptionResId() {
        if(this.format == 1) {
            return string.material_hour_24h_suffix;
        }

        return string.material_hour_suffix;
    }

    public int getHourForDisplay() {
        int v0 = this.format;
        int v1 = this.hour;
        if(v0 == 1) {
            return v1 % 24;
        }

        int v3 = 12;
        if(v1 % 12 == 0) {
            return v3;
        }

        if(this.period == 1) {
            v1 -= v3;
        }

        return v1;
    }

    public MaxInputValidator getHourInputValidator() {
        return this.hourInputValidator;
    }

    public MaxInputValidator getMinuteInputValidator() {
        return this.minuteInputValidator;
    }

    private static int getPeriod(int arg1) {
        if(arg1 >= 12) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.format), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.selection)});
    }

    public void setHour(int arg4) {
        if(this.format == 1) {
            this.hour = arg4;
            return;
        }

        int v0 = 12;
        arg4 %= v0;
        if(this.period == 1) {
        }
        else {
            v0 = 0;
        }

        this.hour = arg4 + v0;
    }

    public void setHourOfDay(int arg2) {
        this.period = TimeModel.getPeriod(arg2);
        this.hour = arg2;
    }

    public void setMinute(int arg1) {
        this.minute = arg1 % 60;
    }

    public void setPeriod(int arg4) {
        if(arg4 != this.period) {
            this.period = arg4;
            int v0 = this.hour;
            int v1 = 12;
            if(v0 < v1 && arg4 == 1) {
                this.hour = v0 + v1;
                return;
            }

            if(v0 < v1) {
                return;
            }

            if(arg4 != 0) {
                return;
            }

            this.hour = v0 - v1;
        }
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeInt(this.hour);
        arg1.writeInt(this.minute);
        arg1.writeInt(this.selection);
        arg1.writeInt(this.format);
    }
}

