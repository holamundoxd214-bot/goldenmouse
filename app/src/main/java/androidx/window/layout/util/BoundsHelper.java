package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build$VERSION;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2={"Landroidx/window/layout/util/BoundsHelper;", "", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface BoundsHelper {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001A\u00020\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2={"Landroidx/window/layout/util/BoundsHelper$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getInstance", "Landroidx/window/layout/util/BoundsHelper;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final String TAG;

        static {
            Companion.$$INSTANCE = new Companion();
            Intrinsics.checkNotNullExpressionValue("BoundsHelper", "getSimpleName(...)");
            Companion.TAG = "BoundsHelper";
        }

        private Companion() {
            super();
        }

        public final BoundsHelper getInstance() {
            if(Build$VERSION.SDK_INT >= 30) {
                return BoundsHelperApi30Impl.INSTANCE;
            }

            if(Build$VERSION.SDK_INT >= 29) {
                return BoundsHelperApi29Impl.INSTANCE;
            }

            if(Build$VERSION.SDK_INT >= 28) {
                return BoundsHelperApi28Impl.INSTANCE;
            }

            return BoundsHelperApi24Impl.INSTANCE;
        }

        public final String getTAG() {
            return Companion.TAG;
        }
    }

    public static final Companion Companion;

    static {
        BoundsHelper.Companion = Companion.$$INSTANCE;
    }

    Rect currentWindowBounds(Activity arg1);

    Rect maximumWindowBounds(Context arg1);
}

