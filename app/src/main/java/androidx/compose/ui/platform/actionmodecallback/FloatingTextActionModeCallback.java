package androidx.compose.ui.platform.actionmodecallback;

import android.graphics.Rect;
import android.view.ActionMode$Callback2;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001C\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0016J\u001C\u0010\f\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0016J\u001C\u0010\u000F\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0016J\u0012\u0010\u0010\u001A\u00020\u00112\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0016J&\u0010\u0012\u001A\u00020\u00112\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\u0013\u001A\u0004\u0018\u00010\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/ui/platform/actionmodecallback/FloatingTextActionModeCallback;", "Landroid/view/ActionMode$Callback2;", "callback", "Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "<init>", "(Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;)V", "onActionItemClicked", "", "mode", "Landroid/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onDestroyActionMode", "", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FloatingTextActionModeCallback extends ActionMode$Callback2 {
    public static final int $stable = 8;
    private final TextActionModeCallback callback;

    static {
    }

    public FloatingTextActionModeCallback(TextActionModeCallback arg1) {
        super();
        this.callback = arg1;
    }

    public boolean onActionItemClicked(ActionMode arg1, MenuItem arg2) {
        return this.callback.onActionItemClicked(arg1, arg2);
    }

    public boolean onCreateActionMode(ActionMode arg1, Menu arg2) {
        return this.callback.onCreateActionMode(arg1, arg2);
    }

    public void onDestroyActionMode(ActionMode arg1) {
        this.callback.onDestroyActionMode();
    }

    public void onGetContentRect(ActionMode arg2, View arg3, Rect arg4) {
        androidx.compose.ui.geometry.Rect v1 = this.callback.getRect();
        if(arg4 != null) {
            arg4.set(((int)v1.getLeft()), ((int)v1.getTop()), ((int)v1.getRight()), ((int)v1.getBottom()));
        }
    }

    public boolean onPrepareActionMode(ActionMode arg1, Menu arg2) {
        return this.callback.onPrepareActionMode(arg1, arg2);
    }
}

