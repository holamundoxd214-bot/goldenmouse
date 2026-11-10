package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0015\u001A\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\"\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/lazy/ParentSizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "fraction", "", "widthState", "Landroidx/compose/runtime/State;", "", "heightState", "<init>", "(FLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getFraction", "()F", "setFraction", "(F)V", "getWidthState", "()Landroidx/compose/runtime/State;", "setWidthState", "(Landroidx/compose/runtime/State;)V", "getHeightState", "setHeightState", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ParentSizeNode extends Node implements LayoutModifierNode {
    private float fraction;
    private State heightState;
    private State widthState;

    public ParentSizeNode(float arg1, State arg2, State arg3) {
        super();
        this.fraction = arg1;
        this.widthState = arg2;
        this.heightState = arg3;
    }

    public ParentSizeNode(float arg2, State arg3, State arg4, int arg5, DefaultConstructorMarker arg6) {
        State v0 = null;
        if((arg5 & 2) != 0) {
            arg3 = v0;
        }

        if((arg5 & 4) != 0) {
            arg4 = v0;
        }

        this(arg2, arg3, arg4);
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final State getHeightState() {
        return this.heightState;
    }

    public final State getWidthState() {
        return this.widthState;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        State v0 = this.widthState;
        int v1 = 0x7FFFFFFF;
        int v0_1 = v0 == null || v0.getValue().intValue() == v1 ? v1 : Math.round(v0.getValue().floatValue() * this.fraction);
        State v2 = this.heightState;
        int v7 = v2 == null || v2.getValue().intValue() == v1 ? v1 : Math.round(v2.getValue().floatValue() * this.fraction);
        int v2_1 = v0_1 != v1 ? v0_1 : Constraints.getMinWidth-impl(arg10);
        int v3 = v7 != v1 ? v7 : Constraints.getMinHeight-impl(arg10);
        if(v0_1 != v1) {
        }
        else {
            v0_1 = Constraints.getMaxWidth-impl(arg10);
        }

        if(v7 != v1) {
        }
        else {
            v7 = Constraints.getMaxHeight-impl(arg10);
        }

        Placeable v7_1 = arg9.measure-BRTryo0(ConstraintsKt.Constraints(v2_1, v0_1, v3, v7));
        return MeasureScope.layout$default(arg8, v7_1.getWidth(), v7_1.getHeight(), null, new ParentSizeNode$$ExternalSyntheticLambda0(v7_1), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$2(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public final void setFraction(float arg1) {
        this.fraction = arg1;
    }

    public final void setHeightState(State arg1) {
        this.heightState = arg1;
    }

    public final void setWidthState(State arg1) {
        this.widthState = arg1;
    }
}

