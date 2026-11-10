package androidx.compose.foundation.text.contextmenu.internal;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u001A\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH&J\u0018\u0010\f\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH&J\u0018\u0010\r\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000FH&J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "", "onGetContentRect", "Landroidx/compose/ui/geometry/Rect;", "mode", "Landroid/view/ActionMode;", "view", "Landroid/view/View;", "onCreateActionMode", "", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TextActionModeCallback {
    boolean onActionItemClicked(ActionMode arg1, MenuItem arg2);

    boolean onCreateActionMode(ActionMode arg1, Menu arg2);

    void onDestroyActionMode(ActionMode arg1);

    Rect onGetContentRect(ActionMode arg1, View arg2);

    boolean onPrepareActionMode(ActionMode arg1, Menu arg2);
}

