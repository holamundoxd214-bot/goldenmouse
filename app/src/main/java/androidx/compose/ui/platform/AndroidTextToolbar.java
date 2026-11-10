package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J`\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u000E\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000E\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000E\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014H\u0016JP\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u000E\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000E\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000E\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014H\u0016J\b\u0010\u0019\u001A\u00020\u0010H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u001A"}, d2={"Landroidx/compose/ui/platform/AndroidTextToolbar;", "Landroidx/compose/ui/platform/TextToolbar;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "actionMode", "Landroid/view/ActionMode;", "textActionModeCallback", "Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "value", "Landroidx/compose/ui/platform/TextToolbarStatus;", "status", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "showMenu", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "onAutofillRequested", "hide", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidTextToolbar implements TextToolbar {
    public static final int $stable = 8;
    private ActionMode actionMode;
    private TextToolbarStatus status;
    private final TextActionModeCallback textActionModeCallback;
    private final View view;

    static {
    }

    public AndroidTextToolbar(View arg11) {
        super();
        this.view = arg11;
        this.textActionModeCallback = new TextActionModeCallback(new AndroidTextToolbar$textActionModeCallback$1(this), null, null, null, null, null, null, 0x7E, null);
        this.status = TextToolbarStatus.Hidden;
    }

    public static final void access$setActionMode$p(AndroidTextToolbar arg0, ActionMode arg1) {
        arg0.actionMode = arg1;
    }

    public TextToolbarStatus getStatus() {
        return this.status;
    }

    public void hide() {
        this.status = TextToolbarStatus.Hidden;
        ActionMode v0 = this.actionMode;
        if(v0 != null) {
            v0.finish();
        }

        this.actionMode = null;
    }

    public void showMenu(Rect arg8, Function0 arg9, Function0 arg10, Function0 arg11, Function0 arg12) {
        this.showMenu(arg8, arg9, arg10, arg11, arg12, null);
    }

    public void showMenu(Rect arg2, Function0 arg3, Function0 arg4, Function0 arg5, Function0 arg6, Function0 arg7) {
        this.textActionModeCallback.setRect(arg2);
        this.textActionModeCallback.setOnCopyRequested(arg3);
        this.textActionModeCallback.setOnCutRequested(arg5);
        this.textActionModeCallback.setOnPasteRequested(arg4);
        this.textActionModeCallback.setOnSelectAllRequested(arg6);
        this.textActionModeCallback.setOnAutofillRequested(arg7);
        ActionMode v2 = this.actionMode;
        if(v2 == null) {
            this.status = TextToolbarStatus.Shown;
            this.actionMode = TextToolbarHelperMethods.INSTANCE.startActionMode(this.view, new FloatingTextActionModeCallback(this.textActionModeCallback), 1);
            return;
        }

        if(v2 != null) {
            v2.invalidate();
        }
    }
}

