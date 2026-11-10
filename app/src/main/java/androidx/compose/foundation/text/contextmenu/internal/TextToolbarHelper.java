package androidx.compose.foundation.text.contextmenu.internal;

import android.view.ActionMode;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005¨\u0006\r"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/TextToolbarHelper;", "", "<init>", "()V", "startActionMode", "Landroid/view/ActionMode;", "view", "Landroid/view/View;", "textActionModeCallback", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "invalidateContentRect", "", "actionMode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextToolbarHelper {
    public static final TextToolbarHelper INSTANCE;

    static {
        TextToolbarHelper.INSTANCE = new TextToolbarHelper();
    }

    private TextToolbarHelper() {
        super();
    }

    public final void invalidateContentRect(ActionMode arg1) {
        TextToolbarHelperApi23.INSTANCE.invalidateContentRect(arg1);
    }

    public final ActionMode startActionMode(View arg2, TextActionModeCallback arg3) {
        return TextToolbarHelperApi23.INSTANCE.startActionMode(arg2, new FloatingTextActionModeCallback(arg3), 1);
    }
}

