package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build$VERSION;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static void stopForeground(Service arg0, int arg1) {
            arg0.stopForeground(arg1);
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void startForeground(Service arg1, int arg2, Notification arg3, int arg4) {
            if(arg4 != 0) {
                if(arg4 == -1) {
                }
                else {
                    arg1.startForeground(arg2, arg3, arg4 & 0xFF);
                    return;
                }
            }

            arg1.startForeground(arg2, arg3, arg4);
        }
    }

    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static void startForeground(Service arg1, int arg2, Notification arg3, int arg4) {
            if(arg4 != 0) {
                if(arg4 == -1) {
                }
                else {
                    arg1.startForeground(arg2, arg3, arg4 & 0x40000FFF);
                    return;
                }
            }

            arg1.startForeground(arg2, arg3, arg4);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface StopForegroundFlags {
    }

    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 0xFF;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 0x40000FFF;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    private ServiceCompat() {
        super();
    }

    public static void startForeground(Service arg2, int arg3, Notification arg4, int arg5) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.startForeground(arg2, arg3, arg4, arg5);
            return;
        }

        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.startForeground(arg2, arg3, arg4, arg5);
            return;
        }

        arg2.startForeground(arg3, arg4);
    }

    public static void stopForeground(Service arg0, int arg1) {
        Api24Impl.stopForeground(arg0, arg1);
    }
}

