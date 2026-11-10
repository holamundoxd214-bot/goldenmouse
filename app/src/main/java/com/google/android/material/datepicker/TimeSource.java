package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE;
    private final Long fixedTimeMs;
    private final TimeZone fixedTimeZone;

    static {
        TimeSource.SYSTEM_TIME_SOURCE = new TimeSource(null, null);
    }

    private TimeSource(Long arg1, TimeZone arg2) {
        super();
        this.fixedTimeMs = arg1;
        this.fixedTimeZone = arg2;
    }

    static TimeSource fixed(long arg1) {
        return new TimeSource(Long.valueOf(arg1), null);
    }

    static TimeSource fixed(long arg1, TimeZone arg3) {
        return new TimeSource(Long.valueOf(arg1), arg3);
    }

    Calendar now() {
        return this.now(this.fixedTimeZone);
    }

    Calendar now(TimeZone arg3) {
        Calendar v3 = arg3 == null ? Calendar.getInstance() : Calendar.getInstance(arg3);
        Long v2 = this.fixedTimeMs;
        if(v2 != null) {
            v3.setTimeInMillis(v2.longValue());
        }

        return v3;
    }

    static TimeSource system() {
        return TimeSource.SYSTEM_TIME_SOURCE;
    }
}

