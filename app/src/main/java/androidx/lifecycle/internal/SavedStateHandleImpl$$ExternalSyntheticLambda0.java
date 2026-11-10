package androidx.lifecycle.internal;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;

public final class SavedStateHandleImpl$$ExternalSyntheticLambda0 implements SavedStateProvider {
    public SavedStateHandleImpl$$ExternalSyntheticLambda0(SavedStateHandleImpl arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Bundle saveState() {
        return SavedStateHandleImpl.savedStateProvider$lambda$0(this.f$0);
    }
}

