package androidx.core.app;

import android.app.PendingIntent$CanceledException;
import android.app.PendingIntent$OnFinished;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

public final class PendingIntentCompat {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        public static PendingIntent getForegroundService(Context arg0, int arg1, Intent arg2, int arg3) {
            return PendingIntent.getForegroundService(arg0, arg1, arg2, arg3);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Flags {
    }

    class GatedCallback implements Closeable {
        private PendingIntent$OnFinished mCallback;
        private final CountDownLatch mComplete;
        private boolean mSuccess;

        public static void $r8$lambda$-_JLK_p2qvpYOAwGjpaXu2HJ864(GatedCallback arg0, PendingIntent arg1, Intent arg2, int arg3, String arg4, Bundle arg5) {
            arg0.onSendFinished(arg1, arg2, arg3, arg4, arg5);
        }

        GatedCallback(PendingIntent$OnFinished arg3) {
            super();
            this.mComplete = new CountDownLatch(1);
            this.mCallback = arg3;
            this.mSuccess = false;
        }

        public void close() {
            if(!this.mSuccess) {
                this.mCallback = null;
            }

            this.mComplete.countDown();
        }

        public void complete() {
            this.mSuccess = true;
        }

        public PendingIntent$OnFinished getCallback() {
            if(this.mCallback == null) {
                return null;
            }

            return new PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0(this);
        }

        private void onSendFinished(PendingIntent arg8, Intent arg9, int arg10, String arg11, Bundle arg12) {
            // Method was not decompiled
        }
    }

    private PendingIntentCompat() {
        super();
    }

    static int addMutabilityFlags(boolean arg1, int arg2) {
        int v1;
        if(!arg1) {
            v1 = 0x4000000;
        }
        else if(Build$VERSION.SDK_INT >= 0x1F) {
            v1 = 0x2000000;
        }
        else {
            return arg2;
        }

        return v1 | arg2;
    }

    public static PendingIntent getActivities(Context arg0, int arg1, Intent[] arg2, int arg3, Bundle arg4, boolean arg5) {
        return PendingIntent.getActivities(arg0, arg1, arg2, PendingIntentCompat.addMutabilityFlags(arg5, arg3), arg4);
    }

    public static PendingIntent getActivities(Context arg0, int arg1, Intent[] arg2, int arg3, boolean arg4) {
        return PendingIntent.getActivities(arg0, arg1, arg2, PendingIntentCompat.addMutabilityFlags(arg4, arg3));
    }

    public static PendingIntent getActivity(Context arg0, int arg1, Intent arg2, int arg3, Bundle arg4, boolean arg5) {
        return PendingIntent.getActivity(arg0, arg1, arg2, PendingIntentCompat.addMutabilityFlags(arg5, arg3), arg4);
    }

    public static PendingIntent getActivity(Context arg0, int arg1, Intent arg2, int arg3, boolean arg4) {
        return PendingIntent.getActivity(arg0, arg1, arg2, PendingIntentCompat.addMutabilityFlags(arg4, arg3));
    }

    public static PendingIntent getBroadcast(Context arg0, int arg1, Intent arg2, int arg3, boolean arg4) {
        return PendingIntent.getBroadcast(arg0, arg1, arg2, PendingIntentCompat.addMutabilityFlags(arg4, arg3));
    }

    public static PendingIntent getForegroundService(Context arg0, int arg1, Intent arg2, int arg3, boolean arg4) {
        return Api26Impl.getForegroundService(arg0, arg1, arg2, PendingIntentCompat.addMutabilityFlags(arg4, arg3));
    }

    public static PendingIntent getService(Context arg0, int arg1, Intent arg2, int arg3, boolean arg4) {
        return PendingIntent.getService(arg0, arg1, arg2, PendingIntentCompat.addMutabilityFlags(arg4, arg3));
    }

    public static void send(PendingIntent arg1, int arg2, PendingIntent$OnFinished arg3, Handler arg4) throws PendingIntent$CanceledException {
        GatedCallback v0 = new GatedCallback(arg3);
        try {
            arg1.send(arg2, v0.getCallback(), arg4);
            v0.complete();
        }
        catch(Throwable v1) {
            try {
                v0.close();
            }
            catch(Throwable v2) {
                v1.addSuppressed(v2);
            }

            throw v1;
        }

        v0.close();
    }

    public static void send(PendingIntent arg8, Context arg9, int arg10, Intent arg11, PendingIntent$OnFinished arg12, Handler arg13) throws PendingIntent$CanceledException {
        PendingIntentCompat.send(arg8, arg9, arg10, arg11, arg12, arg13, null, null);
    }

    public static void send(PendingIntent arg2, Context arg3, int arg4, Intent arg5, PendingIntent$OnFinished arg6, Handler arg7, String arg8, Bundle arg9) throws PendingIntent$CanceledException {
        GatedCallback v1 = new GatedCallback(arg6);
        try {
            arg2.send(arg3, arg4, arg5, arg6, arg7, arg8, arg9);
            v1.complete();
        }
        catch(Throwable v0) {
            Throwable v2 = v0;
            try {
                v1.close();
            }
            catch(Throwable v0) {
                v2.addSuppressed(v0);
            }

            throw v2;
        }

        v1.close();
    }
}

