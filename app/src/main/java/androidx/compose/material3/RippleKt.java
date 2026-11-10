package androidx.compose.material3;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A-\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001A+\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\n2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u000B\u0010\f\"\u0019\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0014\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"ripple", "Landroidx/compose/foundation/IndicationNodeFactory;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "ripple-H2RKhps", "(ZFJ)Landroidx/compose/foundation/IndicationNodeFactory;", "Landroidx/compose/ui/graphics/ColorProducer;", "ripple-wH6b6FI", "(Landroidx/compose/ui/graphics/ColorProducer;ZF)Landroidx/compose/foundation/IndicationNodeFactory;", "LocalRippleConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/RippleConfiguration;", "getLocalRippleConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DefaultBoundedRipple", "Landroidx/compose/material3/RippleNodeFactory;", "DefaultUnboundedRipple", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RippleKt {
    private static final RippleNodeFactory DefaultBoundedRipple;
    private static final RippleNodeFactory DefaultUnboundedRipple;
    private static final ProvidableCompositionLocal LocalRippleConfiguration;

    static {
        RippleKt.LocalRippleConfiguration = CompositionLocalKt.compositionLocalOf$default(null, new RippleKt$$ExternalSyntheticLambda0(), 1, null);
        RippleKt.DefaultBoundedRipple = new RippleNodeFactory(true, Dp.Companion.getUnspecified-D9Ej5fM(), Color.Companion.getUnspecified-0d7_KjU(), null);
        RippleKt.DefaultUnboundedRipple = new RippleNodeFactory(false, Dp.Companion.getUnspecified-D9Ej5fM(), Color.Companion.getUnspecified-0d7_KjU(), null);
    }

    static final RippleConfiguration LocalRippleConfiguration$lambda$0() {
        return new RippleConfiguration(0, null, 3, null);
    }

    public static final ProvidableCompositionLocal getLocalRippleConfiguration() {
        return RippleKt.LocalRippleConfiguration;
    }

    public static final IndicationNodeFactory ripple-H2RKhps(boolean arg6, float arg7, long arg8) {
        if((Dp.equals-impl0(arg7, Dp.Companion.getUnspecified-D9Ej5fM())) && (Color.equals-impl0(arg8, Color.Companion.getUnspecified-0d7_KjU()))) {
            RippleNodeFactory v6 = arg6 ? RippleKt.DefaultBoundedRipple : RippleKt.DefaultUnboundedRipple;
            return ((IndicationNodeFactory)v6);
        }

        return new RippleNodeFactory(arg6, arg7, arg8, null);
    }

    public static IndicationNodeFactory ripple-H2RKhps$default(boolean arg0, float arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg4 & 4) != 0) {
            arg2 = Color.Companion.getUnspecified-0d7_KjU();
        }

        return RippleKt.ripple-H2RKhps(true, arg1, arg2);
    }

    public static final IndicationNodeFactory ripple-wH6b6FI(ColorProducer arg2, boolean arg3, float arg4) {
        return new RippleNodeFactory(arg3, arg4, arg2, null);
    }

    public static IndicationNodeFactory ripple-wH6b6FI$default(ColorProducer arg0, boolean arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return RippleKt.ripple-wH6b6FI(arg0, true, arg2);
    }
}

