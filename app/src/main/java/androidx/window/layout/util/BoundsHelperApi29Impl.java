package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0017J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH\u0016¨\u0006\u000B"}, d2={"Landroidx/window/layout/util/BoundsHelperApi29Impl;", "Landroidx/window/layout/util/BoundsHelper;", "<init>", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class BoundsHelperApi29Impl implements BoundsHelper {
    public static final BoundsHelperApi29Impl INSTANCE;

    static {
        BoundsHelperApi29Impl.INSTANCE = new BoundsHelperApi29Impl();
    }

    private BoundsHelperApi29Impl() {
        super();
    }

    public Rect currentWindowBounds(Activity arg5) {
        Intrinsics.checkNotNullParameter(arg5, "activity");
        Configuration v4 = arg5.getResources().getConfiguration();
        try {
            Field v0 = Configuration.class.getDeclaredField("windowConfiguration");
            v0.setAccessible(true);
            Object v4_2 = v0.get(v4);
            v4_2 = v4_2.getClass().getDeclaredMethod("getBounds").invoke(v4_2);
            Intrinsics.checkNotNull(v4_2, "null cannot be cast to non-null type android.graphics.Rect");
            return new Rect(((Rect)v4_2));
        }
        catch(Exception v4_1) {
            if(!(v4_1 instanceof NoSuchFieldException) && !(v4_1 instanceof NoSuchMethodException) && !(v4_1 instanceof IllegalAccessException)) {
                if((v4_1 instanceof InvocationTargetException)) {
                }
                else {
                    throw v4_1;
                }
            }

            Log.w(BoundsHelper.Companion.getTAG(), ((Throwable)v4_1));
            return BoundsHelperApi28Impl.INSTANCE.currentWindowBounds(arg5);
        }
    }

    public Rect maximumWindowBounds(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        return BoundsHelperApi28Impl.INSTANCE.maximumWindowBounds(arg1);
    }
}

