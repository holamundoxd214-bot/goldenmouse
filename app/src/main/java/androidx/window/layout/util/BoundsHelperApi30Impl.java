package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH\u0016¨\u0006\u000B"}, d2={"Landroidx/window/layout/util/BoundsHelperApi30Impl;", "Landroidx/window/layout/util/BoundsHelper;", "<init>", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class BoundsHelperApi30Impl implements BoundsHelper {
    public static final BoundsHelperApi30Impl INSTANCE;

    static {
        BoundsHelperApi30Impl.INSTANCE = new BoundsHelperApi30Impl();
    }

    private BoundsHelperApi30Impl() {
        super();
    }

    public Rect currentWindowBounds(Activity arg1) {
        Intrinsics.checkNotNullParameter(arg1, "activity");
        Rect v0 = arg1.getSystemService(WindowManager.class).getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(v0, "getBounds(...)");
        return v0;
    }

    public Rect maximumWindowBounds(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        Rect v0 = arg1.getSystemService(WindowManager.class).getMaximumWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(v0, "getBounds(...)");
        return v0;
    }
}

