package androidx.core.location;

import java.util.concurrent.Executor;

public final class LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda0 implements Runnable {
    public LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda0(GpsStatusTransport arg1, Executor arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        this.f$0.lambda$onGpsStatusChanged$0$androidx-core-location-LocationManagerCompat$GpsStatusTransport(this.f$1);
    }
}

