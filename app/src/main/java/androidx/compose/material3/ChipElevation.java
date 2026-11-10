package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001AJ#\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0003¢\u0006\u0002\u0010\u001AJ\u0013\u0010\u001C\u001A\u00020\u00162\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001E\u001A\u00020\u001FH\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000E\u0010\fR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000F\u0010\fR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u0012\u0010\f¨\u0006 ²\u0006\f\u0010!\u001A\u0004\u0018\u00010\"X\u008A\u008E\u0002"}, d2={"Landroidx/compose/material3/ChipElevation;", "", "elevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "<init>", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getElevation-D9Ej5fM", "()F", "F", "getPressedElevation-D9Ej5fM", "getFocusedElevation-D9Ej5fM", "getHoveredElevation-D9Ej5fM", "getDraggedElevation-D9Ej5fM", "getDisabledElevation-D9Ej5fM", "shadowElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "shadowElevation$material3", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateElevation", "equals", "other", "hashCode", "", "material3", "lastInteraction", "Landroidx/compose/foundation/interaction/Interaction;"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ChipElevation {
    public static final int $stable;
    private final float disabledElevation;
    private final float draggedElevation;
    private final float elevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    static {
    }

    public ChipElevation(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private ChipElevation(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6) {
        super();
        this.elevation = arg1;
        this.pressedElevation = arg2;
        this.focusedElevation = arg3;
        this.hoveredElevation = arg4;
        this.draggedElevation = arg5;
        this.disabledElevation = arg6;
    }

    public static final Interaction access$animateElevation$lambda$2(MutableState arg0) {
        return ChipElevation.animateElevation$lambda$2(arg0);
    }

    public static final void access$animateElevation$lambda$3(MutableState arg0, Interaction arg1) {
        ChipElevation.animateElevation$lambda$3(arg0, arg1);
    }

    private final State animateElevation(boolean arg21, InteractionSource arg22, Composer arg23, int arg24) {
        Animatable v1_2;
        float v0_1;
        ChipElevation$animateElevation$1$1 v11_2;
        SnapshotStateList v4_1;
        ChipElevation v0 = this;
        boolean v3 = arg21;
        InteractionSource v1 = arg22;
        Composer v7 = arg23;
        int v2 = arg24;
        int v5 = -2071499570;
        ComposerKt.sourceInformationMarkerStart(v7, v5, "C(animateElevation)N(enabled,interactionSource)2362@112849L46,2363@112927L47,2364@113017L1473,2364@112983L1507,2416@115045L51,2418@115129L515,2418@115106L538:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v5, v2, -1, "androidx.compose.material3.ChipElevation.animateElevation (Chip.kt:2361)");
        }

        String v5_1 = "CC(remember):Chip.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v7, 0x805F85FC, v5_1);
        Object v4 = v7.rememberedValue();
        if(v4 == Composer.Companion.getEmpty()) {
            v4_1 = SnapshotStateKt.mutableStateListOf();
            v7.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        ComposerKt.sourceInformationMarkerStart(v7, 0x805F8FBD, v5_1);
        Object v6 = v7.rememberedValue();
        Object v9 = null;
        if(v6 == Composer.Companion.getEmpty()) {
            MutableState v6_1 = SnapshotStateKt.mutableStateOf$default(v9, ((SnapshotMutationPolicy)v9), 2, v9);
            v7.updateRememberedValue(v6_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        ComposerKt.sourceInformationMarkerStart(v7, 0x805FA08F, v5_1);
        int v10 = 1;
        int v11 = 0x20;
        int v8 = (v2 & 0x70 ^ 0x30) > v11 && (v7.changed(v1)) || (v2 & 0x30) == v11 ? 1 : 0;
        Object v11_1 = v7.rememberedValue();
        if(v8 != 0 || v11_1 == Composer.Companion.getEmpty()) {
            v11_2 = new ChipElevation$animateElevation$1$1(v1, v4_1, ((Continuation)v9));
            v7.updateRememberedValue(v11_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        EffectsKt.LaunchedEffect(v1, ((Function2)v11_2), v7, v2 >> 3 & 14);
        v4 = CollectionsKt.lastOrNull(((List)v4_1));
        if(!v3) {
            v0_1 = v0.disabledElevation;
        }
        else if((v4 instanceof Press)) {
            v0_1 = v0.pressedElevation;
        }
        else if((v4 instanceof Enter)) {
            v0_1 = v0.hoveredElevation;
        }
        else if((v4 instanceof Focus)) {
            v0_1 = v0.focusedElevation;
        }
        else if((v4 instanceof Start)) {
            v0_1 = v0.draggedElevation;
        }
        else {
            v0_1 = v0.elevation;
        }

        ComposerKt.sourceInformationMarkerStart(v7, 0x80609881, v5_1);
        Object v1_1 = v7.rememberedValue();
        if(v1_1 == Composer.Companion.getEmpty()) {
            Animatable v13 = new Animatable(Dp.box-impl(v0_1), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
            v7.updateRememberedValue(v13);
            v1_2 = v13;
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        Dp v8_1 = Dp.box-impl(v0_1);
        ComposerKt.sourceInformationMarkerStart(v7, 0x8060A4D1, v5_1);
        v5 = v7.changedInstance(v1_2) | v7.changed(v0_1);
        v11 = 4;
        if((v2 & 14 ^ 6) <= v11 || !v7.changed(v3)) {
            if((v2 & 6) == v11) {
            }
            else {
                v10 = 0;
            }
        }

        v2 = v5 | v10 | v7.changedInstance(v4);
        Object v5_2 = v7.rememberedValue();
        if(v2 != 0 || v5_2 == Composer.Companion.getEmpty()) {
            ChipElevation$animateElevation$2$1 v5_3 = new ChipElevation$animateElevation$2$1(v1_2, v0_1, v3, ((Interaction)v4), v6, null);
            v7.updateRememberedValue(v5_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        EffectsKt.LaunchedEffect(v8_1, ((Function2)v5_2), v7, 0);
        State v0_2 = v1_2.asState();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        return v0_2;
    }

    private static final Interaction animateElevation$lambda$2(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void animateElevation$lambda$3(MutableState arg0, Interaction arg1) {
        arg0.setValue(arg1);
    }

    public boolean equals(Object arg5) {
        if(this == (((ChipElevation)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(!(arg5 instanceof ChipElevation)) {
            }
            else if(!Dp.equals-impl0(this.elevation, ((ChipElevation)arg5).elevation)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.pressedElevation, ((ChipElevation)arg5).pressedElevation)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.focusedElevation, ((ChipElevation)arg5).focusedElevation)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.hoveredElevation, ((ChipElevation)arg5).hoveredElevation)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.disabledElevation, ((ChipElevation)arg5).disabledElevation)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final float getDisabledElevation-D9Ej5fM() {
        return this.disabledElevation;
    }

    public final float getDraggedElevation-D9Ej5fM() {
        return this.draggedElevation;
    }

    public final float getElevation-D9Ej5fM() {
        return this.elevation;
    }

    public final float getFocusedElevation-D9Ej5fM() {
        return this.focusedElevation;
    }

    public final float getHoveredElevation-D9Ej5fM() {
        return this.hoveredElevation;
    }

    public final float getPressedElevation-D9Ej5fM() {
        return this.pressedElevation;
    }

    public int hashCode() {
        return (((Dp.hashCode-impl(this.elevation) * 0x1F + Dp.hashCode-impl(this.pressedElevation)) * 0x1F + Dp.hashCode-impl(this.focusedElevation)) * 0x1F + Dp.hashCode-impl(this.hoveredElevation)) * 0x1F + Dp.hashCode-impl(this.disabledElevation);
    }

    public final State shadowElevation$material3(boolean arg4, InteractionSource arg5, Composer arg6, int arg7) {
        int v1 = 0x702B2A93;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(shadowElevation)N(enabled,interactionSource)2354@112599L74:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.material3.ChipElevation.shadowElevation (Chip.kt:2353)");
        }

        State v3 = this.animateElevation(arg4, arg5, arg6, arg7 & 0x3FE);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return v3;
    }
}

