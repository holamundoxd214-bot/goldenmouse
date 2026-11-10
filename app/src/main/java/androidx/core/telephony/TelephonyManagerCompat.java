package androidx.core.telephony;

import android.os.Build$VERSION;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

public class TelephonyManagerCompat {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static String getImei(TelephonyManager arg0) {
            return arg0.getImei();
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static int getSubscriptionId(TelephonyManager arg0) {
            return arg0.getSubscriptionId();
        }
    }

    private static Method sGetSubIdMethod;

    private TelephonyManagerCompat() {
        super();
    }

    public static String getImei(TelephonyManager arg0) {
        return Api26Impl.getImei(arg0);
    }

    public static int getSubscriptionId(TelephonyManager arg4) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getSubscriptionId(arg4);
        }

        try {
            if(TelephonyManagerCompat.sGetSubIdMethod == null) {
                Method v0 = TelephonyManager.class.getDeclaredMethod("getSubId");
                TelephonyManagerCompat.sGetSubIdMethod = v0;
                v0.setAccessible(true);
            }

            Object v4 = TelephonyManagerCompat.sGetSubIdMethod.invoke(arg4);
            if(v4 != null && ((Integer)v4).intValue() != -1) {
                return ((Integer)v4).intValue();
            }

            return 0x7FFFFFFF;
        }
        catch(NoSuchMethodException ) {
            return 0x7FFFFFFF;
        }
    }
}

