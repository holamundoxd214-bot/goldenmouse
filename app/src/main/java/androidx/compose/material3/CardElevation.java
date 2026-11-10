package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\'\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0015\u001A\u00020\u000F2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u0010\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u0010\u0010\u0005\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u0010\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u0010\u0010\u0007\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u0010\u0010\b\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000B¨\u0006\u0019"}, d2={"Landroidx/compose/material3/CardElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "<init>", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "shadowElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "shadowElevation$material3", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateElevation", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CardElevation {
    public static final int $stable;
    private final float defaultElevation;
    private final float disabledElevation;
    private final float draggedElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    static {
    }

    public CardElevation(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private CardElevation(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6) {
        super();
        this.defaultElevation = arg1;
        this.pressedElevation = arg2;
        this.focusedElevation = arg3;
        this.hoveredElevation = arg4;
        this.draggedElevation = arg5;
        this.disabledElevation = arg6;
    }

    public static final float access$getDraggedElevation$p(CardElevation arg0) {
        return arg0.draggedElevation;
    }

    public static final float access$getFocusedElevation$p(CardElevation arg0) {
        return arg0.focusedElevation;
    }

    public static final float access$getHoveredElevation$p(CardElevation arg0) {
        return arg0.hoveredElevation;
    }

    public static final float access$getPressedElevation$p(CardElevation arg0) {
        return arg0.pressedElevation;
    }

    private final State animateElevation(boolean arg19, InteractionSource arg20, Composer arg21, int arg22) {
        Object v1_1;
        float v2_2;
        SnapshotStateList v2_1;
        CardElevation v4 = this;
        boolean v3 = arg19;
        InteractionSource v0 = arg20;
        Composer v7 = arg21;
        int v1 = arg22;
        int v5 = 0xAB3FAB46;
        ComposerKt.sourceInformationMarkerStart(v7, v5, "C(animateElevation)N(enabled,interactionSource)667@30190L46,668@30279L1473,668@30245L1507,720@32314L51,722@32398L937,722@32375L960:Card.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v5, v1, -1, "androidx.compose.material3.CardElevation.animateElevation (Card.kt:666)");
        }

        String v5_1 = "CC(remember):Card.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v7, 0xDA020674, v5_1);
        Object v2 = v7.rememberedValue();
        if(v2 == Composer.Companion.getEmpty()) {
            v2_1 = SnapshotStateKt.mutableStateListOf();
            v7.updateRememberedValue(v2_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        ComposerKt.sourceInformationMarkerStart(v7, 0xDA021727, v5_1);
        int v8 = 0x20;
        int v9 = 1;
        int v6 = (v1 & 0x70 ^ 0x30) > v8 && (v7.changed(v0)) || (v1 & 0x30) == v8 ? 1 : 0;
        Object v8_1 = v7.rememberedValue();
        if(v6 != 0 || v8_1 == Composer.Companion.getEmpty()) {
            CardElevation$animateElevation$1$1 v8_2 = new CardElevation$animateElevation$1$1(v0, v2_1, null);
            v7.updateRememberedValue(v8_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        EffectsKt.LaunchedEffect(v0, ((Function2)v8_1), v7, v1 >> 3 & 14);
        Object v0_1 = CollectionsKt.lastOrNull(((List)v2_1));
        if(!v3) {
            v2_2 = v4.disabledElevation;
        }
        else if((v0_1 instanceof Press)) {
            v2_2 = v4.pressedElevation;
        }
        else if((v0_1 instanceof Enter)) {
            v2_2 = v4.hoveredElevation;
        }
        else if((v0_1 instanceof Focus)) {
            v2_2 = v4.focusedElevation;
        }
        else if((v0_1 instanceof Start)) {
            v2_2 = v4.draggedElevation;
        }
        else {
            v2_2 = v4.defaultElevation;
        }

        ComposerKt.sourceInformationMarkerStart(v7, 0xDA030FF9, v5_1);
        Object v6_1 = v7.rememberedValue();
        if(v6_1 == Composer.Companion.getEmpty()) {
            Animatable v11 = new Animatable(Dp.box-impl(v2_2), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
            v7.updateRememberedValue(v11);
            Animatable v6_2 = v11;
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        Dp v8_3 = Dp.box-impl(v2_2);
        ComposerKt.sourceInformationMarkerStart(v7, 0xDA031DEF, v5_1);
        v5 = v7.changedInstance(v6_1) | v7.changed(v2_2);
        int v12 = 4;
        int v11_1 = (v1 & 14 ^ 6) > v12 && (v7.changed(v3)) || (v1 & 6) == v12 ? 1 : 0;
        v5 |= v11_1;
        v12 = 0x100;
        if((v1 & 0x380 ^ 0x180) <= v12 || !v7.changed(v4)) {
            if((v1 & 0x180) == v12) {
            }
            else {
                v9 = 0;
            }
        }

        v1 = v5 | v9 | v7.changedInstance(v0_1);
        Object v5_2 = v7.rememberedValue();
        if(v1 != 0 || v5_2 == Composer.Companion.getEmpty()) {
            v1_1 = v6_1;
            CardElevation$animateElevation$2$1 v5_3 = new CardElevation$animateElevation$2$1(((Animatable)v1_1), v2_2, v3, v4, v0_1, null);
            v7.updateRememberedValue(v5_3);
        }
        else {
            v1_1 = v6_1;
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        EffectsKt.LaunchedEffect(v8_3, ((Function2)v5_2), v7, 0);
        State v0_2 = ((Animatable)v1_1).asState();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        return v0_2;
    }

    public boolean equals(Object arg5) {
        if(this == (((CardElevation)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(!(arg5 instanceof CardElevation)) {
            }
            else if(!Dp.equals-impl0(this.defaultElevation, ((CardElevation)arg5).defaultElevation)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.pressedElevation, ((CardElevation)arg5).pressedElevation)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.focusedElevation, ((CardElevation)arg5).focusedElevation)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.hoveredElevation, ((CardElevation)arg5).hoveredElevation)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.disabledElevation, ((CardElevation)arg5).disabledElevation)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public int hashCode() {
        return (((Dp.hashCode-impl(this.defaultElevation) * 0x1F + Dp.hashCode-impl(this.pressedElevation)) * 0x1F + Dp.hashCode-impl(this.focusedElevation)) * 0x1F + Dp.hashCode-impl(this.hoveredElevation)) * 0x1F + Dp.hashCode-impl(this.disabledElevation);
    }

    public final State shadowElevation$material3(boolean arg4, InteractionSource arg5, Composer arg6, int arg7) {
        int v0 = 0x96E3690B;
        arg6.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(shadowElevation)N(enabled,interactionSource)659@29940L74:Card.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg7, -1, "androidx.compose.material3.CardElevation.shadowElevation (Card.kt:655)");
        }

        if(arg5 == null) {
            arg6.startReplaceGroup(0x9FFAE2B);
            ComposerKt.sourceInformation(arg6, "657@29869L45");
            ComposerKt.sourceInformationMarkerStart(arg6, 1806527288, "CC(remember):Card.kt#9igjgp");
            Object v4 = arg6.rememberedValue();
            if(v4 == Composer.Companion.getEmpty()) {
                MutableState v4_1 = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(this.defaultElevation), null, 2, null);
                arg6.updateRememberedValue(v4_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg6);
            arg6.endReplaceGroup();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            arg6.endReplaceGroup();
            return ((State)v4);
        }

        arg6.startReplaceGroup(0xA00CB77);
        arg6.endReplaceGroup();
        State v3 = this.animateElevation(arg4, arg5, arg6, arg7 & 0x3FE);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg6.endReplaceGroup();
        return v3;
    }
}

