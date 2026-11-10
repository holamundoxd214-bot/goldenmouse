package androidx.core.location;

import android.location.Location;

public final class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3 implements Runnable {
    public LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3(LocationListenerTransport arg1, Location arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        this.f$0.lambda$onLocationChanged$0$androidx-core-location-LocationManagerCompat$LocationListenerTransport(this.f$1);
    }
}

