package androidx.compose.foundation.text.contextmenu.internal;

import android.graphics.Rect;
import android.view.ActionMode$Callback2;
import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0018\u0010\r\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0018\u0010\u000E\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\nH\u0016J\"\u0010\u0013\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\n2\b\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/FloatingTextActionModeCallback;", "Landroid/view/ActionMode$Callback2;", "Landroid/view/ActionMode$Callback;", "textActionModeCallback", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;)V", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class FloatingTextActionModeCallback extends ActionMode$Callback2 implements ActionMode$Callback {
    private final TextActionModeCallback textActionModeCallback;

    public FloatingTextActionModeCallback(TextActionModeCallback arg1) {
        super();
        this.textActionModeCallback = arg1;
    }

    public boolean onActionItemClicked(ActionMode arg1, MenuItem arg2) {
        return this.textActionModeCallback.onActionItemClicked(arg1, arg2);
    }

    public boolean onCreateActionMode(ActionMode arg1, Menu arg2) {
        return this.textActionModeCallback.onCreateActionMode(arg1, arg2);
    }

    public void onDestroyActionMode(ActionMode arg1) {
        this.textActionModeCallback.onDestroyActionMode(arg1);
    }

    public void onGetContentRect(ActionMode arg2, View arg3, Rect arg4) {
        androidx.compose.ui.geometry.Rect v1 = this.textActionModeCallback.onGetContentRect(arg2, arg3);
        arg4.set(Math.round(v1.getLeft()), Math.round(v1.getTop()), Math.round(v1.getRight()), Math.round(v1.getBottom()));
    }

    public boolean onPrepareActionMode(ActionMode arg1, Menu arg2) {
        return this.textActionModeCallback.onPrepareActionMode(arg1, arg2);
    }
}

