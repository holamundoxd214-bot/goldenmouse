package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Deprecated(message="Replaced by the new RippleNode implementation") @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJC\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0017¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/material/ripple/CommonRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "<init>", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CommonRipple extends Ripple {
    public static final int $stable;

    static {
    }

    private CommonRipple(boolean arg2, float arg3, State arg4) {
        super(arg2, arg3, arg4, null);
    }

    public CommonRipple(boolean arg1, float arg2, State arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public RippleIndicationInstance rememberUpdatedRippleInstance-942rkJo(InteractionSource arg7, boolean arg8, float arg9, State arg10, State arg11, Composer arg12, int arg13) {
        CommonRippleIndicationInstance v7_2;
        int v0 = -1768051227;
        arg12.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg12, "C(rememberUpdatedRippleInstance)N(interactionSource,bounded,radius:c#ui.unit.Dp,color,rippleAlpha)57@2186L125:CommonRipple.kt#vhb33q");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg13, -1, "androidx.compose.material.ripple.CommonRipple.rememberUpdatedRippleInstance (CommonRipple.kt:56)");
        }

        ComposerKt.sourceInformationMarkerStart(arg12, 1709828066, "CC(remember):CommonRipple.kt#9igjgp");
        int v1 = 0;
        int v3 = 4;
        int v7 = (arg13 & 14 ^ 6) > v3 && (arg12.changed(arg7)) || (arg13 & 6) == v3 ? 1 : 0;
        v3 = 0x30000;
        int v4 = 0x20000;
        if((0x70000 & arg13 ^ v3) > v4 && (arg12.changed(this)) || (arg13 & v3) == v4) {
            v1 = 1;
        }

        int v6 = v7 | v1;
        Object v7_1 = arg12.rememberedValue();
        if(v6 != 0 || v7_1 == Composer.Companion.getEmpty()) {
            CommonRippleIndicationInstance v0_1 = new CommonRippleIndicationInstance(arg8, arg9, arg10, arg11, null);
            arg12.updateRememberedValue(v0_1);
            v7_2 = v0_1;
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg12.endReplaceGroup();
        return ((RippleIndicationInstance)v7_2);
    }
}

