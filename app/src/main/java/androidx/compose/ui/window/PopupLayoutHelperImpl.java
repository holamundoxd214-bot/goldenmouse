package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.WindowManager;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J \u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fH\u0016J \u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0013H\u0016¨\u0006\u0014"}, d2={"Landroidx/compose/ui/window/PopupLayoutHelperImpl;", "Landroidx/compose/ui/window/PopupLayoutHelper;", "<init>", "()V", "getWindowVisibleDisplayFrame", "", "composeView", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "setGestureExclusionRects", "width", "", "height", "updateViewLayout", "windowManager", "Landroid/view/WindowManager;", "popupView", "params", "Landroid/view/ViewGroup$LayoutParams;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) class PopupLayoutHelperImpl implements PopupLayoutHelper {
    public PopupLayoutHelperImpl() {
        super();
    }

    public void getWindowVisibleDisplayFrame(View arg1, Rect arg2) {
        arg1.getWindowVisibleDisplayFrame(arg2);
    }

    public void setGestureExclusionRects(View arg1, int arg2, int arg3) {
    }

    public void updateViewLayout(WindowManager arg1, View arg2, ViewGroup$LayoutParams arg3) {
        arg1.updateViewLayout(arg2, arg3);
    }
}

