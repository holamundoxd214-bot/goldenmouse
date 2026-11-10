package androidx.compose.foundation.text.contextmenu.internal;

import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0018\u0010\f\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0018\u0010\r\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\b\u001A\u00020\tH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/PrimaryTextActionModeCallback;", "Landroid/view/ActionMode$Callback;", "textActionModeCallback", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;)V", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class PrimaryTextActionModeCallback implements ActionMode$Callback {
    private final TextActionModeCallback textActionModeCallback;

    public PrimaryTextActionModeCallback(TextActionModeCallback arg1) {
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

    public boolean onPrepareActionMode(ActionMode arg1, Menu arg2) {
        return this.textActionModeCallback.onPrepareActionMode(arg1, arg2);
    }
}

