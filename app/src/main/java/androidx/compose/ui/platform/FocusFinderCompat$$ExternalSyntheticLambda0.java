package androidx.compose.ui.platform;

import android.view.View;

public final class FocusFinderCompat$$ExternalSyntheticLambda0 implements NextFocusGetter {
    public FocusFinderCompat$$ExternalSyntheticLambda0(FocusFinderCompat arg1) {
        super();
        this.f$0 = arg1;
    }

    public final View get(View arg1, View arg2) {
        return FocusFinderCompat.userSpecifiedFocusComparator$lambda$0(this.f$0, arg1, arg2);
    }
}

