package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import java.util.concurrent.Executor;

public final class LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0 implements Runnable {
    public LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0(GnssMeasurementsTransport arg1, Executor arg2, GnssMeasurementsEvent arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        this.f$0.lambda$onGnssMeasurementsReceived$0$androidx-core-location-LocationManagerCompat$GnssMeasurementsTransport(this.f$1, this.f$2);
    }
}

