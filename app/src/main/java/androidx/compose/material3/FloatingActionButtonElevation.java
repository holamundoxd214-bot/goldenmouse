package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B2\u0006\u0010\f\u001A\u00020\rH\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0003H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001B\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B2\u0006\u0010\f\u001A\u00020\rH\u0003¢\u0006\u0002\u0010\u000FJ\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0019"}, d2={"Landroidx/compose/material3/FloatingActionButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "shadowElevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "shadowElevation$material3", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tonalElevation", "tonalElevation-D9Ej5fM$material3", "()F", "animateElevation", "equals", "", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public class FloatingActionButtonElevation {
    public static final int $stable;
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    static {
    }

    public FloatingActionButtonElevation(float arg1, float arg2, float arg3, float arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    private FloatingActionButtonElevation(float arg1, float arg2, float arg3, float arg4) {
        super();
        this.defaultElevation = arg1;
        this.pressedElevation = arg2;
        this.focusedElevation = arg3;
        this.hoveredElevation = arg4;
    }

    public static final float access$getDefaultElevation$p(FloatingActionButtonElevation arg0) {
        return arg0.defaultElevation;
    }

    public static final float access$getFocusedElevation$p(FloatingActionButtonElevation arg0) {
        return arg0.focusedElevation;
    }

    public static final float access$getHoveredElevation$p(FloatingActionButtonElevation arg0) {
        return arg0.hoveredElevation;
    }

    public static final float access$getPressedElevation$p(FloatingActionButtonElevation arg0) {
        return arg0.pressedElevation;
    }

    private final State animateElevation(InteractionSource arg19, Composer arg20, int arg21) {
        FloatingActionButtonElevation$animateElevation$1$1 v12_3;
        FloatingActionButtonElevationAnimatable v11_1;
        FloatingActionButtonElevation v0 = this;
        InteractionSource v1 = arg19;
        Composer v2 = arg20;
        int v3 = arg21;
        int v5 = -1845106002;
        ComposerKt.sourceInformationMarkerStart(v2, v5, "C(animateElevation)N(interactionSource)630@28424L346,639@28801L277,639@28780L298,648@29122L1282,648@29088L1316:FloatingActionButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v5, v3, -1, "androidx.compose.material3.FloatingActionButtonElevation.animateElevation (FloatingActionButton.kt:628)");
        }

        String v5_1 = "CC(remember):FloatingActionButton.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v2, 0x28360928, v5_1);
        int v4 = v3 & 14;
        int v6 = v4 ^ 6;
        int v7 = 0;
        int v9 = 4;
        int v10 = v6 > v9 && (v2.changed(v1)) || (v3 & 6) == v9 ? 1 : 0;
        Object v11 = v2.rememberedValue();
        if(v10 != 0 || v11 == Composer.Companion.getEmpty()) {
            FloatingActionButtonElevationAnimatable v12 = new FloatingActionButtonElevationAnimatable(v0.defaultElevation, v0.pressedElevation, v0.hoveredElevation, v0.focusedElevation, null);
            v2.updateRememberedValue(v12);
            v11_1 = v12;
        }

        ComposerKt.sourceInformationMarkerEnd(v2);
        ComposerKt.sourceInformationMarkerStart(v2, 0x28363803, v5_1);
        boolean v10_1 = v2.changedInstance(v11_1);
        int v13 = 0x20;
        int v12_1 = (v3 & 0x70 ^ 0x30) > v13 && (v2.changed(v0)) || (v3 & 0x30) == v13 ? 1 : 0;
        v10 = (((int)v10_1)) | v12_1;
        Object v12_2 = v2.rememberedValue();
        Continuation v13_1 = null;
        if(v10 != 0 || v12_2 == Composer.Companion.getEmpty()) {
            v12_3 = new FloatingActionButtonElevation$animateElevation$1$1(v11_1, v0, v13_1);
            v2.updateRememberedValue(v12_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v2);
        EffectsKt.LaunchedEffect(v0, ((Function2)v12_3), v2, v3 >> 3 & 14);
        ComposerKt.sourceInformationMarkerStart(v2, 674653200, v5_1);
        if(v6 > v9 && (v2.changed(v1)) || (v3 & 6) == v9) {
            v7 = 1;
        }

        int v0_1 = v2.changedInstance(v11_1) | v7;
        Object v3_1 = v2.rememberedValue();
        if(v0_1 != 0 || v3_1 == Composer.Companion.getEmpty()) {
            FloatingActionButtonElevation$animateElevation$2$1 v3_2 = new FloatingActionButtonElevation$animateElevation$2$1(v1, v11_1, v13_1);
            v2.updateRememberedValue(v3_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v2);
        EffectsKt.LaunchedEffect(v1, ((Function2)v3_1), v2, v4);
        State v0_2 = v11_1.asState();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v2);
        return v0_2;
    }

    public boolean equals(Object arg4) {
        if(this == (((FloatingActionButtonElevation)arg4))) {
            return 1;
        }

        if(arg4 != null) {
            if(!(arg4 instanceof FloatingActionButtonElevation)) {
            }
            else if(!Dp.equals-impl0(this.defaultElevation, ((FloatingActionButtonElevation)arg4).defaultElevation)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.pressedElevation, ((FloatingActionButtonElevation)arg4).pressedElevation)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.focusedElevation, ((FloatingActionButtonElevation)arg4).focusedElevation)) {
                return 0;
            }
            else {
                return Dp.equals-impl0(this.hoveredElevation, ((FloatingActionButtonElevation)arg4).hoveredElevation);
            }
        }

        return 0;
    }

    public int hashCode() {
        return ((Dp.hashCode-impl(this.defaultElevation) * 0x1F + Dp.hashCode-impl(this.pressedElevation)) * 0x1F + Dp.hashCode-impl(this.focusedElevation)) * 0x1F + Dp.hashCode-impl(this.hoveredElevation);
    }

    public final State shadowElevation$material3(InteractionSource arg4, Composer arg5, int arg6) {
        int v1 = -424810125;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(shadowElevation)N(interactionSource)620@28145L55:FloatingActionButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.material3.FloatingActionButtonElevation.shadowElevation (FloatingActionButton.kt:619)");
        }

        State v3 = this.animateElevation(arg4, arg5, arg6 & 0x7E);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v3;
    }

    public final float tonalElevation-D9Ej5fM$material3() {
        return this.defaultElevation;
    }
}

