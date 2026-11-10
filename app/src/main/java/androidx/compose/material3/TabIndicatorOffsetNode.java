package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0012\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000E\u0010\u000FJ#\u0010&\u001A\u00020\'*\u00020(2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,H\u0016¢\u0006\u0004\b-\u0010.R&\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0007\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR \u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u001C\u0010 \u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010#\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010$\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006/"}, d2={"Landroidx/compose/material3/TabIndicatorOffsetNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "tabPositionsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/material3/TabPosition;", "selectedTabIndex", "", "followContentSize", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Landroidx/compose/runtime/State;IZLandroidx/compose/animation/core/FiniteAnimationSpec;)V", "getTabPositionsState", "()Landroidx/compose/runtime/State;", "setTabPositionsState", "(Landroidx/compose/runtime/State;)V", "getSelectedTabIndex", "()I", "setSelectedTabIndex", "(I)V", "getFollowContentSize", "()Z", "setFollowContentSize", "(Z)V", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "offsetAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "widthAnimatable", "initialOffset", "initialWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TabIndicatorOffsetNode extends Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private FiniteAnimationSpec animationSpec;
    private boolean followContentSize;
    private Dp initialOffset;
    private Dp initialWidth;
    private Animatable offsetAnimatable;
    private int selectedTabIndex;
    private State tabPositionsState;
    private Animatable widthAnimatable;

    static {
    }

    public TabIndicatorOffsetNode(State arg1, int arg2, boolean arg3, FiniteAnimationSpec arg4) {
        super();
        this.tabPositionsState = arg1;
        this.selectedTabIndex = arg2;
        this.followContentSize = arg3;
        this.animationSpec = arg4;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getFollowContentSize() {
        return this.followContentSize;
    }

    public final int getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    public final State getTabPositionsState() {
        return this.tabPositionsState;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg12, Measurable arg13, long arg14) {
        Animatable v4_1;
        Animatable v3;
        if(this.tabPositionsState.getValue().isEmpty()) {
            return MeasureScope.layout$default(arg12, 0, 0, null, new TabIndicatorOffsetNode$$ExternalSyntheticLambda0(), 4, null);
        }

        MeasureScope v0 = arg12;
        boolean v12 = this.followContentSize;
        State v1 = this.tabPositionsState;
        float v12_1 = v12 ? v1.getValue().get(this.selectedTabIndex).getContentWidth-D9Ej5fM() : v1.getValue().get(this.selectedTabIndex).getWidth-D9Ej5fM();
        Continuation v2 = null;
        if(this.initialWidth != null) {
            Animatable v1_1 = this.widthAnimatable;
            if(v1_1 == null) {
                Dp v4 = this.initialWidth;
                Intrinsics.checkNotNull(v4);
                v3 = new Animatable(v4, VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
                this.widthAnimatable = v3;
                v1_1 = v3;
            }

            if(Dp.equals-impl0(v12_1, v1_1.getTargetValue().unbox-impl())) {
                goto label_60;
            }

            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new TabIndicatorOffsetNode$measure$2(v1_1, v12_1, this, v2), 3, null);
        }
        else {
            this.initialWidth = Dp.box-impl(v12_1);
        }

    label_60:
        float v1_2 = this.tabPositionsState.getValue().get(this.selectedTabIndex).getLeft-D9Ej5fM();
        if(this.initialOffset != null) {
            v3 = this.offsetAnimatable;
            if(v3 == null) {
                Dp v5 = this.initialOffset;
                Intrinsics.checkNotNull(v5);
                v4_1 = new Animatable(v5, VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
                this.offsetAnimatable = v4_1;
                v3 = v4_1;
            }

            if(Dp.equals-impl0(v1_2, v3.getTargetValue().unbox-impl())) {
                goto label_97;
            }

            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new TabIndicatorOffsetNode$measure$3(v3, v1_2, this, v2), 3, null);
        }
        else {
            this.initialOffset = Dp.box-impl(v1_2);
        }

    label_97:
        LayoutDirection v2_1 = v0.getLayoutDirection();
        LayoutDirection v3_1 = LayoutDirection.Ltr;
        v4_1 = this.offsetAnimatable;
        if(v2_1 != v3_1) {
            if(v4_1 != null) {
                v1_2 = v4_1.getValue().unbox-impl();
            }

            v1_2 = Dp.constructor-impl(-v1_2);
        }
        else if(v4_1 != null) {
            v1_2 = v4_1.getValue().unbox-impl();
        }

        Animatable v11 = this.widthAnimatable;
        if(v11 != null) {
            v12_1 = v11.getValue().unbox-impl();
        }

        Placeable v11_1 = arg13.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg14, v0.roundToPx-0680j_4(v12_1), v0.roundToPx-0680j_4(v12_1), 0, 0, 12, null));
        return MeasureScope.layout$default(v0, v11_1.getWidth(), v11_1.getHeight(), null, new TabIndicatorOffsetNode$$ExternalSyntheticLambda1(v11_1, v0, v1_2), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$3(Placeable arg7, MeasureScope arg8, float arg9, PlacementScope arg10) {
        PlacementScope.place$default(arg10, arg7, arg8.roundToPx-0680j_4(arg9), 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public final void setAnimationSpec(FiniteAnimationSpec arg1) {
        this.animationSpec = arg1;
    }

    public final void setFollowContentSize(boolean arg1) {
        this.followContentSize = arg1;
    }

    public final void setSelectedTabIndex(int arg1) {
        this.selectedTabIndex = arg1;
    }

    public final void setTabPositionsState(State arg1) {
        this.tabPositionsState = arg1;
    }
}

