package androidx.core.location;

public final class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda1 implements Runnable {
    public LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda1(LocationListenerTransport arg1, String arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        this.f$0.lambda$onProviderDisabled$5$androidx-core-location-LocationManagerCompat$LocationListenerTransport(this.f$1);
    }
}

