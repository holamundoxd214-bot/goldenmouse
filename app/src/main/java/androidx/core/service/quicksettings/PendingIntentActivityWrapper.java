package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;

public class PendingIntentActivityWrapper {
    private final Context mContext;
    private final int mFlags;
    private final Intent mIntent;
    private final boolean mIsMutable;
    private final Bundle mOptions;
    private final PendingIntent mPendingIntent;
    private final int mRequestCode;

    public PendingIntentActivityWrapper(Context arg1, int arg2, Intent arg3, int arg4, Bundle arg5, boolean arg6) {
        super();
        this.mContext = arg1;
        this.mRequestCode = arg2;
        this.mIntent = arg3;
        this.mFlags = arg4;
        this.mOptions = arg5;
        this.mIsMutable = arg6;
        this.mPendingIntent = this.createPendingIntent();
    }

    public PendingIntentActivityWrapper(Context arg8, int arg9, Intent arg10, int arg11, boolean arg12) {
        this(arg8, arg9, arg10, arg11, null, arg12);
    }

    private PendingIntent createPendingIntent() {
        Bundle v4 = this.mOptions;
        Context v0 = this.mContext;
        if(v4 == null) {
            return PendingIntentCompat.getActivity(v0, this.mRequestCode, this.mIntent, this.mFlags, this.mIsMutable);
        }

        return PendingIntentCompat.getActivity(v0, this.mRequestCode, this.mIntent, this.mFlags, v4, this.mIsMutable);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public Bundle getOptions() {
        return this.mOptions;
    }

    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public boolean isMutable() {
        return this.mIsMutable;
    }
}

