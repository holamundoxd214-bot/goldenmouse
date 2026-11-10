package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final class LocationManagerCompat$$ExternalSyntheticLambda0 implements Runnable {
    public LocationManagerCompat$$ExternalSyntheticLambda0(Consumer arg1, Location arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        LocationManagerCompat.lambda$getCurrentLocation$0(this.f$0, this.f$1);
    }
}

