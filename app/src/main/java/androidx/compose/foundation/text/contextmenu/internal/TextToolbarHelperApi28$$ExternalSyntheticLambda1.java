package androidx.compose.foundation.text.contextmenu.internal;

import android.app.RemoteAction;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;

public final class TextToolbarHelperApi28$$ExternalSyntheticLambda1 implements MenuItem$OnMenuItemClickListener {
    public TextToolbarHelperApi28$$ExternalSyntheticLambda1(RemoteAction arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean onMenuItemClick(MenuItem arg1) {
        return TextToolbarHelperApi28.addMenuItem$lambda$0(this.f$0, arg1);
    }
}

