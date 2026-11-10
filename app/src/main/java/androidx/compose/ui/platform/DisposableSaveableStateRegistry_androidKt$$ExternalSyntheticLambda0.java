package androidx.compose.ui.platform;

import android.os.Bundle;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;

public final class DisposableSaveableStateRegistry_androidKt$$ExternalSyntheticLambda0 implements SavedStateProvider {
    public DisposableSaveableStateRegistry_androidKt$$ExternalSyntheticLambda0(SaveableStateRegistry arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Bundle saveState() {
        return DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry$lambda$0(this.f$0);
    }
}

