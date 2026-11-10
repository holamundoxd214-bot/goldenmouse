package androidx.core.location;

import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

public interface LocationListenerCompat extends LocationListener {
    default void onFlushComplete(int arg1) {
    }

    default void onLocationChanged(List arg4) {
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.onLocationChanged(arg4.get(v1));
        }
    }

    default void onProviderDisabled(String arg1) {
    }

    default void onProviderEnabled(String arg1) {
    }

    default void onStatusChanged(String arg1, int arg2, Bundle arg3) {
    }
}

