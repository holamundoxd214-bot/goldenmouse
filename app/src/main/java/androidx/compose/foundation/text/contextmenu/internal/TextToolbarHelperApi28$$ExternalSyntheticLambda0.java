package androidx.compose.foundation.text.contextmenu.internal;

import android.content.Context;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.textclassifier.TextClassification;

public final class TextToolbarHelperApi28$$ExternalSyntheticLambda0 implements MenuItem$OnMenuItemClickListener {
    public TextToolbarHelperApi28$$ExternalSyntheticLambda0(Context arg1, TextClassification arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final boolean onMenuItemClick(MenuItem arg2) {
        return TextToolbarHelperApi28.addLegacyMenuItem$lambda$0(this.f$0, this.f$1, arg2);
    }
}

