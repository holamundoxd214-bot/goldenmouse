package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;

public final class ComponentActivity$$ExternalSyntheticLambda8 implements SavedStateProvider {
    public ComponentActivity$$ExternalSyntheticLambda8(ComponentActivity arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Bundle saveState() {
        return ComponentActivity._init_$lambda$3(this.f$0);
    }
}

