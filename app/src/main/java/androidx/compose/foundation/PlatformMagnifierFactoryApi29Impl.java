package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier$Builder;
import android.widget.Magnifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl;", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "<init>", "()V", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "view", "Landroid/view/View;", "useTextDefault", "size", "Landroidx/compose/ui/unit/DpSize;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "create-nHHXs2Y", "(Landroid/view/View;ZJFFZLandroidx/compose/ui/unit/Density;F)Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "PlatformMagnifierImpl", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\'\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "magnifier", "Landroid/widget/Magnifier;", "<init>", "(Landroid/widget/Magnifier;)V", "update", "", "sourceCenter", "Landroidx/compose/ui/geometry/Offset;", "magnifierCenter", "zoom", "", "update-Wko1d7g", "(JJF)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformMagnifierImpl extends androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl {
        public static final int $stable = 8;

        static {
        }

        public PlatformMagnifierImpl(Magnifier arg1) {
            super(arg1);
        }

        public void update-Wko1d7g(long arg6, long arg8, float arg10) {
            if(!Float.isNaN(arg10)) {
                this.getMagnifier().setZoom(arg10);
            }

            long v0 = 0xFFFFFFFFL;
            int v2 = 0x20;
            if(Long.compare(0x7FFFFFFF7FFFFFFFL & arg8, 0x7FC000007FC00000L) != 0) {
                this.getMagnifier().show(Float.intBitsToFloat(((int)(arg6 >> v2))), Float.intBitsToFloat(((int)(arg6 & v0))), Float.intBitsToFloat(((int)(arg8 >> v2))), Float.intBitsToFloat(((int)(arg8 & v0))));
                return;
            }

            this.getMagnifier().show(Float.intBitsToFloat(((int)(arg6 >> v2))), Float.intBitsToFloat(((int)(arg6 & v0))));
        }
    }

    public static final int $stable;
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE;
    private static final boolean canUpdateZoom;

    static {
        PlatformMagnifierFactoryApi29Impl.INSTANCE = new PlatformMagnifierFactoryApi29Impl();
        PlatformMagnifierFactoryApi29Impl.canUpdateZoom = true;
    }

    private PlatformMagnifierFactoryApi29Impl() {
        super();
    }

    public PlatformMagnifier create-nHHXs2Y(View arg1, boolean arg2, long arg3, float arg5, float arg6, boolean arg7, Density arg8, float arg9) {
        return this.create-nHHXs2Y(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9);
    }

    public PlatformMagnifierImpl create-nHHXs2Y(View arg3, boolean arg4, long arg5, float arg7, float arg8, boolean arg9, Density arg10, float arg11) {
        if(arg4) {
            return new PlatformMagnifierImpl(new Magnifier(arg3));
        }

        long v4 = arg10.toSize-XkaWNTQ(arg5);
        float v2 = arg10.toPx-0680j_4(arg7);
        float v6 = arg10.toPx-0680j_4(arg8);
        Magnifier$Builder v7 = new Magnifier$Builder(arg3);
        if(v4 != 0x7FC000007FC00000L) {
            v7.setSize(MathKt.roundToInt(Float.intBitsToFloat(((int)(v4 >> 0x20)))), MathKt.roundToInt(Float.intBitsToFloat(((int)(v4 & 0xFFFFFFFFL)))));
        }

        if(!Float.isNaN(v2)) {
            v7.setCornerRadius(v2);
        }

        if(!Float.isNaN(v6)) {
            v7.setElevation(v6);
        }

        if(!Float.isNaN(arg11)) {
            v7.setInitialZoom(arg11);
        }

        v7.setClippingEnabled(arg9);
        return new PlatformMagnifierImpl(v7.build());
    }

    public boolean getCanUpdateZoom() {
        return PlatformMagnifierFactoryApi29Impl.canUpdateZoom;
    }
}

