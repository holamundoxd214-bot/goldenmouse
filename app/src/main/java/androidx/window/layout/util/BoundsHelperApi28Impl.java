package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0017J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH\u0016¨\u0006\u000B"}, d2={"Landroidx/window/layout/util/BoundsHelperApi28Impl;", "Landroidx/window/layout/util/BoundsHelper;", "<init>", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class BoundsHelperApi28Impl implements BoundsHelper {
    public static final BoundsHelperApi28Impl INSTANCE;

    static {
        BoundsHelperApi28Impl.INSTANCE = new BoundsHelperApi28Impl();
    }

    private BoundsHelperApi28Impl() {
        super();
    }

    public Rect currentWindowBounds(Activity arg7) {
        Object v0_2;
        Intrinsics.checkNotNullParameter(arg7, "activity");
        Rect v6 = new Rect();
        Configuration v0 = arg7.getResources().getConfiguration();
        try {
            Field v2 = Configuration.class.getDeclaredField("windowConfiguration");
            v2.setAccessible(true);
            v0_2 = v2.get(v0);
            boolean v2_1 = ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(arg7);
        }
        catch(Exception v0_1) {
            goto label_37;
        }

        String v3 = "null cannot be cast to non-null type android.graphics.Rect";
        if(!v2_1) {
            goto label_26;
        }

        try {
            v0_2 = v0_2.getClass().getDeclaredMethod("getBounds").invoke(v0_2);
            Intrinsics.checkNotNull(v0_2, v3);
            v6.set(((Rect)v0_2));
            goto label_50;
        label_26:
            v0_2 = v0_2.getClass().getDeclaredMethod("getAppBounds").invoke(v0_2);
            Intrinsics.checkNotNull(v0_2, v3);
            v6.set(((Rect)v0_2));
        }
        catch(Exception v0_1) {
        label_37:
            if(!(v0_1 instanceof NoSuchFieldException) && !(v0_1 instanceof NoSuchMethodException) && !(v0_1 instanceof IllegalAccessException)) {
                if((v0_1 instanceof InvocationTargetException)) {
                }
                else {
                    throw v0_1;
                }
            }

            Log.w(BoundsHelper.Companion.getTAG(), ((Throwable)v0_1));
            BoundsHelperKt.access$getRectSizeFromDisplay(arg7, v6);
        }

    label_50:
        Display v0_3 = arg7.getWindowManager().getDefaultDisplay();
        Point v2_2 = new Point();
        v0_3.getRealSize(v2_2);
        if(!ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(arg7)) {
            int v3_1 = BoundsHelperKt.access$getNavigationBarHeight(arg7);
            if(v6.bottom + v3_1 == v2_2.y) {
                v6.bottom += v3_1;
            }
            else if(v6.right + v3_1 == v2_2.x) {
                v6.right += v3_1;
            }
            else if(v6.left == v3_1) {
                v6.left = 0;
            }
        }

        if((v6.width() < v2_2.x || v6.height() < v2_2.y) && !ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(arg7)) {
            Intrinsics.checkNotNull(v0_3);
            DisplayCutout v7 = BoundsHelperKt.access$getCutoutForDisplay(v0_3);
            if(v7 != null) {
                if(v6.left == DisplayCompatHelperApi28.INSTANCE.safeInsetLeft(v7)) {
                    v6.left = 0;
                }

                if(v2_2.x - v6.right == DisplayCompatHelperApi28.INSTANCE.safeInsetRight(v7)) {
                    v6.right += DisplayCompatHelperApi28.INSTANCE.safeInsetRight(v7);
                }

                if(v6.top == DisplayCompatHelperApi28.INSTANCE.safeInsetTop(v7)) {
                    v6.top = 0;
                }

                if(v2_2.y - v6.bottom != DisplayCompatHelperApi28.INSTANCE.safeInsetBottom(v7)) {
                    return v6;
                }

                v6.bottom += DisplayCompatHelperApi28.INSTANCE.safeInsetBottom(v7);
            }
        }

        return v6;
    }

    public Rect maximumWindowBounds(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        return BoundsHelperApi24Impl.INSTANCE.maximumWindowBounds(arg1);
    }
}

