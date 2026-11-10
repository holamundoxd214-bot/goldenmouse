package androidx.core.location;

import java.util.List;

public final class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2 implements Runnable {
    public LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2(LocationListenerTransport arg1, List arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        this.f$0.lambda$onLocationChanged$1$androidx-core-location-LocationManagerCompat$LocationListenerTransport(this.f$1);
    }
}

