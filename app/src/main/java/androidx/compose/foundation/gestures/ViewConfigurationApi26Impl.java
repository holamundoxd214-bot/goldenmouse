package androidx.compose.foundation.gestures;

import android.view.ViewConfiguration;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\t"}, d2={"Landroidx/compose/foundation/gestures/ViewConfigurationApi26Impl;", "", "<init>", "()V", "getVerticalScrollFactor", "", "viewConfiguration", "Landroid/view/ViewConfiguration;", "getHorizontalScrollFactor", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ViewConfigurationApi26Impl {
    public static final ViewConfigurationApi26Impl INSTANCE;

    static {
        ViewConfigurationApi26Impl.INSTANCE = new ViewConfigurationApi26Impl();
    }

    private ViewConfigurationApi26Impl() {
        super();
    }

    public final float getHorizontalScrollFactor(ViewConfiguration arg1) {
        return arg1.getScaledHorizontalScrollFactor();
    }

    public final float getVerticalScrollFactor(ViewConfiguration arg1) {
        return arg1.getScaledVerticalScrollFactor();
    }
}

