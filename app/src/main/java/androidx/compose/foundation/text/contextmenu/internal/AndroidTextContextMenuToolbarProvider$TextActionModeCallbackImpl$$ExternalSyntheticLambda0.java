package androidx.compose.foundation.text.contextmenu.internal;

import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;

public final class AndroidTextContextMenuToolbarProvider$TextActionModeCallbackImpl$$ExternalSyntheticLambda0 implements MenuItem$OnMenuItemClickListener {
    public AndroidTextContextMenuToolbarProvider$TextActionModeCallbackImpl$$ExternalSyntheticLambda0(TextContextMenuComponent arg1, TextActionModeCallbackImpl arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final boolean onMenuItemClick(MenuItem arg2) {
        return TextActionModeCallbackImpl.$r8$lambda$iBF5LEAJhMqvy1KvI9bmkI0Wv9Y(this.f$0, this.f$1, arg2);
    }
}

