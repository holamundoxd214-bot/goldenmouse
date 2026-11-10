package androidx.compose.foundation.layout;

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

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0011\u001A\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/layout/FillNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "<init>", "(Landroidx/compose/foundation/layout/Direction;F)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getFraction", "()F", "setFraction", "(F)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class FillNode extends Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    public FillNode(Direction arg1, float arg2) {
        super();
        this.direction = arg1;
        this.fraction = arg2;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg9, Measurable arg10, long arg11) {
        int v11;
        int v8;
        int v2;
        int v1;
        int v0;
        if(!Constraints.getHasBoundedWidth-impl(arg11) || this.direction == Direction.Vertical) {
            v2 = Constraints.getMinWidth-impl(arg11);
            v0 = Constraints.getMaxWidth-impl(arg11);
        }
        else {
            v0 = Math.round((((float)Constraints.getMaxWidth-impl(arg11))) * this.fraction);
            v1 = Constraints.getMinWidth-impl(arg11);
            v2 = Constraints.getMaxWidth-impl(arg11);
            if(v0 < v1) {
                v0 = v1;
            }

            if(v0 > v2) {
            }
            else {
                v2 = v0;
            }

            v0 = v2;
        }

        if(!Constraints.getHasBoundedHeight-impl(arg11) || this.direction == Direction.Horizontal) {
            v8 = Constraints.getMinHeight-impl(arg11);
            int v7 = Constraints.getMaxHeight-impl(arg11);
            v11 = v8;
            v8 = v7;
        }
        else {
            v8 = Math.round((((float)Constraints.getMaxHeight-impl(arg11))) * this.fraction);
            v1 = Constraints.getMinHeight-impl(arg11);
            v11 = Constraints.getMaxHeight-impl(arg11);
            if(v8 < v1) {
                v8 = v1;
            }

            if(v8 > v11) {
            }
            else {
                v11 = v8;
            }

            v8 = v11;
        }

        Placeable v8_1 = arg10.measure-BRTryo0(ConstraintsKt.Constraints(v2, v0, v11, v8));
        return MeasureScope.layout$default(arg9, v8_1.getWidth(), v8_1.getHeight(), null, new FillNode$$ExternalSyntheticLambda0(v8_1), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg7, PlacementScope arg8) {
        PlacementScope.placeRelative$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public final void setDirection(Direction arg1) {
        this.direction = arg1;
    }

    public final void setFraction(float arg1) {
        this.fraction = arg1;
    }
}

