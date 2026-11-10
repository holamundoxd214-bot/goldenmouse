package androidx.core.location;

import java.util.concurrent.Executor;

public final class LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda1 implements Runnable {
    public LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda1(GnssMeasurementsTransport arg1, Executor arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        this.f$0.lambda$onStatusChanged$1$androidx-core-location-LocationManagerCompat$GnssMeasurementsTransport(this.f$1, this.f$2);
    }
}

