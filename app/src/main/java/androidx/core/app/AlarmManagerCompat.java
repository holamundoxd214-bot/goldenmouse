package androidx.core.app;

import android.app.AlarmManager$AlarmClockInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build$VERSION;
import androidx.annotation.ReplaceWith;

public final class AlarmManagerCompat {
    class Api31Impl {
        private Api31Impl() {
            super();
        }

        static boolean canScheduleExactAlarms(AlarmManager arg0) {
            return arg0.canScheduleExactAlarms();
        }
    }

    private AlarmManagerCompat() {
        super();
    }

    public static boolean canScheduleExactAlarms(AlarmManager arg2) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.canScheduleExactAlarms(arg2);
        }

        return 1;
    }

    public static void setAlarmClock(AlarmManager arg1, long arg2, PendingIntent arg4, PendingIntent arg5) {
        arg1.setAlarmClock(new AlarmManager$AlarmClockInfo(arg2, arg4), arg5);
    }

    public static void setAndAllowWhileIdle(AlarmManager arg0, int arg1, long arg2, PendingIntent arg4) {
        arg0.setAndAllowWhileIdle(arg1, arg2, arg4);
    }

    @ReplaceWith(expression="alarmManager.setExact(type, triggerAtMillis, operation)") @Deprecated public static void setExact(AlarmManager arg0, int arg1, long arg2, PendingIntent arg4) {
        arg0.setExact(arg1, arg2, arg4);
    }

    public static void setExactAndAllowWhileIdle(AlarmManager arg0, int arg1, long arg2, PendingIntent arg4) {
        arg0.setExactAndAllowWhileIdle(arg1, arg2, arg4);
    }
}

