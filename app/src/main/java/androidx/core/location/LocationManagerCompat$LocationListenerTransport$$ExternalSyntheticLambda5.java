package androidx.core.location;

import android.os.Bundle;

public final class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5 implements Runnable {
    public LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5(LocationListenerTransport arg1, String arg2, int arg3, Bundle arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final void run() {
        this.f$0.lambda$onStatusChanged$3$androidx-core-location-LocationManagerCompat$LocationListenerTransport(this.f$1, this.f$2, this.f$3);
    }
}

