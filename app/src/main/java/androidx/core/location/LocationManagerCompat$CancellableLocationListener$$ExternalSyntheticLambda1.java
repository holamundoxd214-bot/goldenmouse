package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final class LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda1 implements Runnable {
    public LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda1(Consumer arg1, Location arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        CancellableLocationListener.lambda$onLocationChanged$1(this.f$0, this.f$1);
    }
}

