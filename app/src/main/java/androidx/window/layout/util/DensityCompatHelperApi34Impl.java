package androidx.window.layout.util;

import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowManager;
import android.view.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016¨\u0006\f"}, d2={"Landroidx/window/layout/util/DensityCompatHelperApi34Impl;", "Landroidx/window/layout/util/DensityCompatHelper;", "<init>", "()V", "density", "", "context", "Landroid/content/Context;", "configuration", "Landroid/content/res/Configuration;", "windowMetrics", "Landroid/view/WindowMetrics;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class DensityCompatHelperApi34Impl implements DensityCompatHelper {
    public static final DensityCompatHelperApi34Impl INSTANCE;

    static {
        DensityCompatHelperApi34Impl.INSTANCE = new DensityCompatHelperApi34Impl();
    }

    private DensityCompatHelperApi34Impl() {
        super();
    }

    public float density(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        return arg1.getSystemService(WindowManager.class).getCurrentWindowMetrics().getDensity();
    }

    public float density(Configuration arg1, WindowMetrics arg2) {
        Intrinsics.checkNotNullParameter(arg1, "configuration");
        Intrinsics.checkNotNullParameter(arg2, "windowMetrics");
        return arg2.getDensity();
    }
}

