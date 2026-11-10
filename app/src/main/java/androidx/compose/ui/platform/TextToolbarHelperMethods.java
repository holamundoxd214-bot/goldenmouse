package androidx.compose.ui.platform;

import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0005H\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/platform/TextToolbarHelperMethods;", "", "<init>", "()V", "startActionMode", "Landroid/view/ActionMode;", "view", "Landroid/view/View;", "actionModeCallback", "Landroid/view/ActionMode$Callback;", "type", "", "invalidateContentRect", "", "actionMode", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextToolbarHelperMethods {
    public static final int $stable;
    public static final TextToolbarHelperMethods INSTANCE;

    static {
        TextToolbarHelperMethods.INSTANCE = new TextToolbarHelperMethods();
    }

    private TextToolbarHelperMethods() {
        super();
    }

    public final void invalidateContentRect(ActionMode arg1) {
        arg1.invalidateContentRect();
    }

    public final ActionMode startActionMode(View arg1, ActionMode$Callback arg2, int arg3) {
        return arg1.startActionMode(arg2, arg3);
    }
}

