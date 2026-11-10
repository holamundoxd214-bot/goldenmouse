package androidx.compose.material.ripple;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Deprecated(message="Replaced by the new RippleNode implementation") @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJC\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0017¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/material/ripple/PlatformRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "<init>", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformRipple extends Ripple {
    public static final int $stable;

    static {
    }

    private PlatformRipple(boolean arg2, float arg3, State arg4) {
        super(arg2, arg3, arg4, null);
    }

    public PlatformRipple(boolean arg1, float arg2, State arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public RippleIndicationInstance rememberUpdatedRippleInstance-942rkJo(InteractionSource arg9, boolean arg10, float arg11, State arg12, State arg13, Composer arg14, int arg15) {
        int v0 = 0x13BE9E37;
        arg14.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg14, "C(rememberUpdatedRippleInstance)N(interactionSource,bounded,radius:c#ui.unit.Dp,color,rippleAlpha)85@3492L7,86@3516L138:Ripple.android.kt#vhb33q");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg15, -1, "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:84)");
        }

        ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(arg14, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_2 = arg14.consume(((CompositionLocal)v0_1));
        ComposerKt.sourceInformationMarkerEnd(arg14);
        ViewGroup v6 = Ripple_androidKt.access$findNearestViewGroup(((View)v0_2));
        ComposerKt.sourceInformationMarkerStart(arg14, 0x1E901321, "CC(remember):Ripple.android.kt#9igjgp");
        int v1 = 0;
        int v3 = 4;
        int v9 = (arg15 & 14 ^ 6) > v3 && (arg14.changed(arg9)) || (arg15 & 6) == v3 ? 1 : 0;
        v3 = 0x30000;
        int v4 = 0x20000;
        if((0x70000 & arg15 ^ v3) > v4 && (arg14.changed(this)) || (arg15 & v3) == v4) {
            v1 = 1;
        }

        int v8 = v9 | v1 | arg14.changed(v6);
        Object v9_1 = arg14.rememberedValue();
        if(v8 != 0 || v9_1 == Composer.Companion.getEmpty()) {
            AndroidRippleIndicationInstance v1_1 = new AndroidRippleIndicationInstance(arg10, arg11, arg12, arg13, v6, null);
            arg14.updateRememberedValue(v1_1);
            AndroidRippleIndicationInstance v9_2 = v1_1;
        }

        ComposerKt.sourceInformationMarkerEnd(arg14);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg14.endReplaceGroup();
        return ((RippleIndicationInstance)v9_1);
    }
}

