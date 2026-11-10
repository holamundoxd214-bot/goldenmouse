package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;

public final class WindowRecomposerFactory$Companion$$ExternalSyntheticLambda0 implements WindowRecomposerFactory {
    public WindowRecomposerFactory$Companion$$ExternalSyntheticLambda0() {
        super();
    }

    public final Recomposer createRecomposer(View arg1) {
        return Companion.LifecycleAware$lambda$0(arg1);
    }
}

