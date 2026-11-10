package androidx.compose.ui.window;

import android.graphics.Insets;
import android.view.Window;
import android.view.WindowInsets$Type;
import android.view.WindowManager$LayoutParams;
import android.view.WindowMetrics;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007J\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\tH\u0007J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000EH\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/window/Api30Impl;", "", "<init>", "()V", "setFitInsetsSides", "", "attrs", "Landroid/view/WindowManager$LayoutParams;", "sides", "", "setFitInsetsTypes", "types", "getMaxDialogHeightExcludingSystemBarInsets", "window", "Landroid/view/Window;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api30Impl {
    public static final Api30Impl INSTANCE;

    static {
        Api30Impl.INSTANCE = new Api30Impl();
    }

    private Api30Impl() {
        super();
    }

    public final int getMaxDialogHeightExcludingSystemBarInsets(Window arg2) {
        WindowMetrics v1 = arg2.getWindowManager().getCurrentWindowMetrics();
        Insets v2 = v1.getWindowInsets().getInsets(WindowInsets$Type.systemBars());
        return v1.getBounds().height() - (v2.top + v2.bottom);
    }

    public final void setFitInsetsSides(WindowManager$LayoutParams arg1, int arg2) {
        arg1.setFitInsetsSides(arg2);
    }

    public final void setFitInsetsTypes(WindowManager$LayoutParams arg1, int arg2) {
        arg1.setFitInsetsTypes(arg2);
    }
}

