package androidx.core.location;

import java.util.concurrent.Executor;

public final class LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda2 implements Runnable {
    public LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda2(GpsStatusTransport arg1, Executor arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        this.f$0.lambda$onGpsStatusChanged$2$androidx-core-location-LocationManagerCompat$GpsStatusTransport(this.f$1, this.f$2);
    }
}

