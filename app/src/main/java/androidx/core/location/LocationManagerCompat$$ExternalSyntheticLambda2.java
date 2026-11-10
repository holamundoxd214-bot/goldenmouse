package androidx.core.location;

import android.location.LocationManager;
import java.util.concurrent.Callable;

public final class LocationManagerCompat$$ExternalSyntheticLambda2 implements Callable {
    public LocationManagerCompat$$ExternalSyntheticLambda2(LocationManager arg1, GpsStatusTransport arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object call() {
        return LocationManagerCompat.lambda$registerGnssStatusCallback$1(this.f$0, this.f$1);
    }
}

