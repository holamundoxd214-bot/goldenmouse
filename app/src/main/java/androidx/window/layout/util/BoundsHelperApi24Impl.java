package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH\u0016¨\u0006\u000B"}, d2={"Landroidx/window/layout/util/BoundsHelperApi24Impl;", "Landroidx/window/layout/util/BoundsHelper;", "<init>", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class BoundsHelperApi24Impl implements BoundsHelper {
    public static final BoundsHelperApi24Impl INSTANCE;

    static {
        BoundsHelperApi24Impl.INSTANCE = new BoundsHelperApi24Impl();
    }

    private BoundsHelperApi24Impl() {
        super();
    }

    public Rect currentWindowBounds(Activity arg4) {
        Intrinsics.checkNotNullParameter(arg4, "activity");
        Rect v3 = new Rect();
        Display v0 = arg4.getWindowManager().getDefaultDisplay();
        v0.getRectSize(v3);
        if(!ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(arg4)) {
            DisplayHelper v1 = DisplayHelper.INSTANCE;
            Intrinsics.checkNotNull(v0);
            Point v0_1 = v1.getRealSizeForDisplay(v0);
            int v4 = BoundsHelperKt.access$getNavigationBarHeight(((Context)arg4));
            if(v3.bottom + v4 == v0_1.y) {
                v3.bottom += v4;
                return v3;
            }
            else if(v3.right + v4 == v0_1.x) {
                v3.right += v4;
            }
        }

        return v3;
    }

    public Rect maximumWindowBounds(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        return BoundsHelperApi16Impl.INSTANCE.maximumWindowBounds(arg1);
    }
}

