package androidx.compose.material.ripple;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="Replaced by the new RippleNode implementation") @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b!\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0002\u0010\u0010JC\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00140\u0007H\'¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001A\u00020\u00032\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/material/ripple/Ripple;", "Landroidx/compose/foundation/Indication;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "<init>", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "rememberUpdatedInstance", "Landroidx/compose/foundation/IndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/IndicationInstance;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "equals", "other", "", "hashCode", "", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class Ripple implements Indication {
    public static final int $stable;
    private final boolean bounded;
    private final State color;
    private final float radius;

    static {
    }

    private Ripple(boolean arg1, float arg2, State arg3) {
        super();
        this.bounded = arg1;
        this.radius = arg2;
        this.color = arg3;
    }

    public Ripple(boolean arg1, float arg2, State arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((Ripple)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Ripple)) {
            return 0;
        }

        if(this.bounded != ((Ripple)arg5).bounded) {
            return 0;
        }

        if(!Dp.equals-impl0(this.radius, ((Ripple)arg5).radius)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.color, ((Ripple)arg5).color)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.bounded) * 0x1F + Dp.hashCode-impl(this.radius)) * 0x1F + this.color.hashCode();
    }

    @Deprecated(message="Super method is deprecated") public final IndicationInstance rememberUpdatedInstance(InteractionSource arg12, Composer arg13, int arg14) {
        long v3;
        int v0 = 0x3AEF0613;
        arg13.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg13, "C(rememberUpdatedInstance)N(interactionSource)191@9517L7,193@9557L229,200@9871L13,200@9844L41,203@9922L85,205@10061L491,205@10017L535:Ripple.kt#vhb33q");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg14, -1, "androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:190)");
        }

        ProvidableCompositionLocal v0_1 = RippleThemeKt.getLocalRippleTheme();
        ComposerKt.sourceInformationMarkerStart(arg13, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_2 = arg13.consume(((CompositionLocal)v0_1));
        ComposerKt.sourceInformationMarkerEnd(arg13);
        int v2 = 0;
        if(Long.compare(this.color.getValue().unbox-impl(), 16) != 0) {
            arg13.startReplaceGroup(0x2D7808FC);
            arg13.endReplaceGroup();
            v3 = this.color.getValue().unbox-impl();
        }
        else {
            arg13.startReplaceGroup(0x2D78EAB4);
            ComposerKt.sourceInformation(arg13, "197@9740L14");
            v3 = ((RippleTheme)v0_2).defaultColor-WaAFU9c(arg13, 0);
            arg13.endReplaceGroup();
        }

        State v7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v3), arg13, 0);
        State v8 = SnapshotStateKt.rememberUpdatedState(((RippleTheme)v0_2).rippleAlpha(arg13, 0), arg13, 0);
        v0 = arg14 & 14;
        InteractionSource v4 = arg12;
        Composer v9 = arg13;
        RippleIndicationInstance v11 = this.rememberUpdatedRippleInstance-942rkJo(v4, this.bounded, this.radius, v7, v8, v9, v0 | arg14 << 12 & 0x70000);
        ComposerKt.sourceInformationMarkerStart(v9, 0x3B46281E, "CC(remember):Ripple.kt#9igjgp");
        int v13 = 4;
        if((v0 ^ 6) > v13 && (v9.changed(v4)) || (arg14 & 6) == v13) {
            v2 = 1;
        }

        int v12 = v9.changedInstance(v11) | v2;
        Object v13_1 = v9.rememberedValue();
        if(v12 != 0 || v13_1 == Composer.Companion.getEmpty()) {
            Ripple$rememberUpdatedInstance$1$1 v13_2 = new Ripple$rememberUpdatedInstance$1$1(v4, v11, null);
            v9.updateRememberedValue(v13_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v9);
        EffectsKt.LaunchedEffect(v11, v4, ((Function2)v13_1), v9, arg14 << 3 & 0x70);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v9.endReplaceGroup();
        return ((IndicationInstance)v11);
    }

    public abstract RippleIndicationInstance rememberUpdatedRippleInstance-942rkJo(InteractionSource arg1, boolean arg2, float arg3, State arg4, State arg5, Composer arg6, int arg7);
}

