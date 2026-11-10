package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager$WakeLock;
import android.util.Log;
import android.util.SparseArray;

@Deprecated public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final String EXTRA_WAKE_LOCK_ID = "androidx.contentpager.content.wakelockid";
    private static int mNextId;
    private static final SparseArray sActiveWakeLocks;

    static {
        WakefulBroadcastReceiver.sActiveWakeLocks = new SparseArray();
        WakefulBroadcastReceiver.mNextId = 1;
    }

    public WakefulBroadcastReceiver() {
        super();
    }

    public static boolean completeWakefulIntent(Intent arg5) {
        String v0 = "No active wake lock id #";
        int v5 = arg5.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if(v5 == 0) {
            return 0;
        }

        SparseArray v1 = WakefulBroadcastReceiver.sActiveWakeLocks;
        __monitor_enter(v1);
        try {
            Object v2 = v1.get(v5);
            if(v2 != null) {
                ((PowerManager$WakeLock)v2).release();
                v1.remove(v5);
                __monitor_exit(v1);
                return 1;
            }

            Log.w("WakefulBroadcastReceiv.", v0 + v5);
            __monitor_exit(v1);
            return 1;
        label_24:
            __monitor_exit(v1);
        }
        catch(Throwable v5_1) {
            goto label_24;
        }

        throw v5_1;
    }

    public static ComponentName startWakefulService(Context arg5, Intent arg6) {
        String v0 = "androidx.core:wake:";
        SparseArray v1 = WakefulBroadcastReceiver.sActiveWakeLocks;
        __monitor_enter(v1);
        try {
            int v2 = WakefulBroadcastReceiver.mNextId;
            int v3 = v2 + 1;
            WakefulBroadcastReceiver.mNextId = v3;
            if(v3 <= 0) {
                WakefulBroadcastReceiver.mNextId = 1;
            }

            arg6.putExtra("androidx.contentpager.content.wakelockid", v2);
            ComponentName v6 = arg5.startService(arg6);
            if(v6 == null) {
                __monitor_exit(v1);
                return null;
            }

            PowerManager$WakeLock v5_1 = arg5.getSystemService("power").newWakeLock(1, v0 + v6.flattenToShortString());
            v5_1.setReferenceCounted(false);
            v5_1.acquire(60000);
            v1.put(v2, v5_1);
            __monitor_exit(v1);
            return v6;
        label_32:
            __monitor_exit(v1);
        }
        catch(Throwable v5) {
            goto label_32;
        }

        throw v5;
    }
}

