package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH\u0016¨\u0006\u000B"}, d2={"Landroidx/window/layout/util/BoundsHelperApi16Impl;", "Landroidx/window/layout/util/BoundsHelper;", "<init>", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class BoundsHelperApi16Impl implements BoundsHelper {
    public static final BoundsHelperApi16Impl INSTANCE;

    static {
        BoundsHelperApi16Impl.INSTANCE = new BoundsHelperApi16Impl();
    }

    private BoundsHelperApi16Impl() {
        super();
    }

    public Rect currentWindowBounds(Activity arg3) {
        Intrinsics.checkNotNullParameter(arg3, "activity");
        Display v2 = arg3.getWindowManager().getDefaultDisplay();
        DisplayHelper v3 = DisplayHelper.INSTANCE;
        Intrinsics.checkNotNull(v2);
        Point v3_1 = v3.getRealSizeForDisplay(v2);
        Rect v0 = new Rect();
        if(v3_1.x != 0) {
            if(v3_1.y == 0) {
            }
            else {
                v0.right = v3_1.x;
                v0.bottom = v3_1.y;
                return v0;
            }
        }

        v2.getRectSize(v0);
        return v0;
    }

    public Rect maximumWindowBounds(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        Object v2 = arg3.getSystemService("window");
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type android.view.WindowManager");
        Display v2_1 = ((WindowManager)v2).getDefaultDisplay();
        DisplayHelper v3 = DisplayHelper.INSTANCE;
        Intrinsics.checkNotNull(v2_1);
        Point v2_2 = v3.getRealSizeForDisplay(v2_1);
        return new Rect(0, 0, v2_2.x, v2_2.y);
    }
}

