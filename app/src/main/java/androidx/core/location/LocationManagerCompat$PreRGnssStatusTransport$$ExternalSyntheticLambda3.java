package androidx.core.location;

import java.util.concurrent.Executor;

public final class LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda3 implements Runnable {
    public LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda3(PreRGnssStatusTransport arg1, Executor arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        this.f$0.lambda$onStarted$0$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(this.f$1);
    }
}

