package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityManager;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0005¨\u0006\n"}, d2={"Landroidx/compose/ui/platform/Api29Impl;", "", "<init>", "()V", "getRecommendedTimeoutMillis", "", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "originalTimeout", "uiContentFlags", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Api29Impl {
    public static final int $stable;
    public static final Api29Impl INSTANCE;

    static {
        Api29Impl.INSTANCE = new Api29Impl();
    }

    private Api29Impl() {
        super();
    }

    public final int getRecommendedTimeoutMillis(AccessibilityManager arg1, int arg2, int arg3) {
        return arg1.getRecommendedTimeoutMillis(arg2, arg3);
    }
}

