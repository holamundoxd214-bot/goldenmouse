package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.core.util.Consumer;

public final class SidecarCompat$$ExternalSyntheticLambda0 implements Consumer {
    public SidecarCompat$$ExternalSyntheticLambda0(SidecarCompat arg1, Activity arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void accept(Object arg2) {
        SidecarCompat.registerConfigurationChangeListener$lambda$0(this.f$0, this.f$1, ((Configuration)arg2));
    }
}

