package androidx.compose.foundation;

import android.os.Build$VERSION;
import android.view.View;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\ba\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017JO\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2={"Landroidx/compose/foundation/PlatformMagnifierFactory;", "", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifier;", "view", "Landroid/view/View;", "useTextDefault", "size", "Landroidx/compose/ui/unit/DpSize;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "create-nHHXs2Y", "(Landroid/view/View;ZJFFZLandroidx/compose/ui/unit/Density;F)Landroidx/compose/foundation/PlatformMagnifier;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PlatformMagnifierFactory {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0007¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/PlatformMagnifierFactory$Companion;", "", "<init>", "()V", "getForCurrentPlatform", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final PlatformMagnifierFactory getForCurrentPlatform() {
            if(Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null)) {
                if(Build$VERSION.SDK_INT == 28) {
                    return PlatformMagnifierFactoryApi28Impl.INSTANCE;
                }

                return PlatformMagnifierFactoryApi29Impl.INSTANCE;
            }

            throw new UnsupportedOperationException("Magnifier is only supported on API level 28 and higher.");
        }
    }

    public static final Companion Companion;

    static {
        PlatformMagnifierFactory.Companion = Companion.$$INSTANCE;
    }

    PlatformMagnifier create-nHHXs2Y(View arg1, boolean arg2, long arg3, float arg4, float arg5, boolean arg6, Density arg7, float arg8);

    boolean getCanUpdateZoom();
}

