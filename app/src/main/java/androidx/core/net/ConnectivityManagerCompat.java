package androidx.core.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import androidx.annotation.ReplaceWith;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ConnectivityManagerCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static int getRestrictBackgroundStatus(ConnectivityManager arg0) {
            return arg0.getRestrictBackgroundStatus();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface RestrictBackgroundStatus {
    }

    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    private ConnectivityManagerCompat() {
        super();
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager arg1, Intent arg2) {
        Parcelable v2 = arg2.getParcelableExtra("networkInfo");
        if(v2 != null) {
            return arg1.getNetworkInfo(((NetworkInfo)v2).getType());
        }

        return null;
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager arg0) {
        return Api24Impl.getRestrictBackgroundStatus(arg0);
    }

    @ReplaceWith(expression="cm.isActiveNetworkMetered()") @Deprecated public static boolean isActiveNetworkMetered(ConnectivityManager arg0) {
        return arg0.isActiveNetworkMetered();
    }
}

