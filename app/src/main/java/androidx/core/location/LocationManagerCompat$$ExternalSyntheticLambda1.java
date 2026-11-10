package androidx.core.location;

import android.os.CancellationSignal$OnCancelListener;

public final class LocationManagerCompat$$ExternalSyntheticLambda1 implements CancellationSignal$OnCancelListener {
    public LocationManagerCompat$$ExternalSyntheticLambda1(CancellableLocationListener arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onCancel() {
        this.f$0.cancel();
    }
}

