package androidx.core.telephony;

import android.os.Build$VERSION;
import android.telephony.SubscriptionManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SubscriptionManagerCompat {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static int getSlotIndex(int arg0) {
            return SubscriptionManager.getSlotIndex(arg0);
        }
    }

    private static Method sGetSlotIndexMethod;

    private SubscriptionManagerCompat() {
        super();
    }

    public static int getSlotIndex(int arg7) {
        int v0 = -1;
        if(arg7 == v0) {
            return v0;
        }

        if(Build$VERSION.SDK_INT >= 29) {
            return Api29Impl.getSlotIndex(arg7);
        }

        try {
            if(SubscriptionManagerCompat.sGetSlotIndexMethod == null) {
                Method v1 = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE);
                SubscriptionManagerCompat.sGetSlotIndexMethod = v1;
                v1.setAccessible(true);
            }

            Object v7 = SubscriptionManagerCompat.sGetSlotIndexMethod.invoke(null, Integer.valueOf(arg7));
            if(v7 == null) {
                return v0;
            }

            return ((Integer)v7).intValue();
        }
        catch(InvocationTargetException ) {
            return v0;
        }
    }
}

