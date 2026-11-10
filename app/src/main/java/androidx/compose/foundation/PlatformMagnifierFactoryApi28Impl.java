package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl;", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "<init>", "()V", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "view", "Landroid/view/View;", "useTextDefault", "size", "Landroidx/compose/ui/unit/DpSize;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "create-nHHXs2Y", "(Landroid/view/View;ZJFFZLandroidx/compose/ui/unit/Density;F)Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "PlatformMagnifierImpl", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformMagnifierFactoryApi28Impl implements PlatformMagnifierFactory {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001A\u00020\rH\u0016J\'\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001A\u00020\rH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "Landroidx/compose/foundation/PlatformMagnifier;", "magnifier", "Landroid/widget/Magnifier;", "<init>", "(Landroid/widget/Magnifier;)V", "getMagnifier", "()Landroid/widget/Magnifier;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "updateContent", "", "update", "sourceCenter", "Landroidx/compose/ui/geometry/Offset;", "magnifierCenter", "zoom", "", "update-Wko1d7g", "(JJF)V", "dismiss", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public class PlatformMagnifierImpl implements PlatformMagnifier {
        public static final int $stable = 8;
        private final Magnifier magnifier;

        static {
        }

        public PlatformMagnifierImpl(Magnifier arg1) {
            super();
            this.magnifier = arg1;
        }

        public void dismiss() {
            this.magnifier.dismiss();
        }

        public final Magnifier getMagnifier() {
            return this.magnifier;
        }

        public long getSize-YbymL2g() {
            return IntSize.constructor-impl((((long)this.magnifier.getWidth())) << 0x20 | (((long)this.magnifier.getHeight())) & 0xFFFFFFFFL);
        }

        public void update-Wko1d7g(long arg1, long arg3, float arg5) {
            this.magnifier.show(Float.intBitsToFloat(((int)(arg1 >> 0x20))), Float.intBitsToFloat(((int)(arg1 & 0xFFFFFFFFL))));
        }

        public void updateContent() {
            this.magnifier.update();
        }
    }

    public static final int $stable;
    public static final PlatformMagnifierFactoryApi28Impl INSTANCE;
    private static final boolean canUpdateZoom;

    static {
        PlatformMagnifierFactoryApi28Impl.INSTANCE = new PlatformMagnifierFactoryApi28Impl();
    }

    private PlatformMagnifierFactoryApi28Impl() {
        super();
    }

    public PlatformMagnifier create-nHHXs2Y(View arg1, boolean arg2, long arg3, float arg5, float arg6, boolean arg7, Density arg8, float arg9) {
        return this.create-nHHXs2Y(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9);
    }

    public PlatformMagnifierImpl create-nHHXs2Y(View arg1, boolean arg2, long arg3, float arg5, float arg6, boolean arg7, Density arg8, float arg9) {
        return new PlatformMagnifierImpl(new Magnifier(arg1));
    }

    public boolean getCanUpdateZoom() {
        return PlatformMagnifierFactoryApi28Impl.canUpdateZoom;
    }
}

