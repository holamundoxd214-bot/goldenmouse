package androidx.window.layout.util;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.view.WindowMetrics;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/window/layout/util/DensityCompatHelper;", "", "density", "", "context", "Landroid/content/Context;", "configuration", "Landroid/content/res/Configuration;", "windowMetrics", "Landroid/view/WindowMetrics;", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DensityCompatHelper {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2={"Landroidx/window/layout/util/DensityCompatHelper$Companion;", "", "<init>", "()V", "getInstance", "Landroidx/window/layout/util/DensityCompatHelper;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final DensityCompatHelper getInstance() {
            if(Build$VERSION.SDK_INT >= 34) {
                return DensityCompatHelperApi34Impl.INSTANCE;
            }

            return DensityCompatHelperBaseImpl.INSTANCE;
        }
    }

    public static final Companion Companion;

    static {
        DensityCompatHelper.Companion = Companion.$$INSTANCE;
    }

    float density(Configuration arg1, WindowMetrics arg2);

    float density(Context arg1);
}

