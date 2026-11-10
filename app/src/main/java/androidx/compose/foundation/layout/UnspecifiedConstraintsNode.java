package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001B\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000F\u001A\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001C\u0010\u0018\u001A\u00020\u0019*\u00020\u001A2\u0006\u0010\u0012\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0019H\u0016J\u001C\u0010\u001D\u001A\u00020\u0019*\u00020\u001A2\u0006\u0010\u0012\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0019H\u0016J\u001C\u0010\u001E\u001A\u00020\u0019*\u00020\u001A2\u0006\u0010\u0012\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u0019H\u0016J\u001C\u0010 \u001A\u00020\u0019*\u00020\u001A2\u0006\u0010\u0012\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u0019H\u0016R\u001C\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\f\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001C\u0010\u0005\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\f\u001A\u0004\b\r\u0010\t\"\u0004\b\u000E\u0010\u000B¨\u0006!"}, d2={"Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "F", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class UnspecifiedConstraintsNode extends Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public UnspecifiedConstraintsNode(float arg1, float arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    private UnspecifiedConstraintsNode(float arg1, float arg2) {
        super();
        this.minWidth = arg1;
        this.minHeight = arg2;
    }

    public UnspecifiedConstraintsNode(float arg1, float arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg3 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        this(arg1, arg2, null);
    }

    public final float getMinHeight-D9Ej5fM() {
        return this.minHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return this.minWidth;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        int v2 = arg2.maxIntrinsicHeight(arg3);
        int v0 = !Float.isNaN(this.minHeight) ? arg1.roundToPx-0680j_4(this.minHeight) : 0;
        if(v2 < v0) {
            return v0;
        }

        return v2;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        int v2 = arg2.maxIntrinsicWidth(arg3);
        int v0 = !Float.isNaN(this.minWidth) ? arg1.roundToPx-0680j_4(this.minWidth) : 0;
        if(v2 < v0) {
            return v0;
        }

        return v2;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        int v3;
        int v2;
        int v0;
        int v1 = 0;
        if((Float.isNaN(this.minWidth)) || Constraints.getMinWidth-impl(arg10) != 0) {
            v2 = Constraints.getMinWidth-impl(arg10);
        }
        else {
            v0 = arg8.roundToPx-0680j_4(this.minWidth);
            v2 = Constraints.getMaxWidth-impl(arg10);
            if(v0 < 0) {
                v0 = 0;
            }

            if(v0 > v2) {
                goto label_16;
            }

            v2 = v0;
        }

    label_16:
        v0 = Constraints.getMaxWidth-impl(arg10);
        if((Float.isNaN(this.minHeight)) || Constraints.getMinHeight-impl(arg10) != 0) {
            v3 = Constraints.getMinHeight-impl(arg10);
        }
        else {
            int v7 = arg8.roundToPx-0680j_4(this.minHeight);
            v3 = Constraints.getMaxHeight-impl(arg10);
            if(v7 < 0) {
            }
            else {
                v1 = v7;
            }

            if(v1 > v3) {
                goto label_33;
            }

            v3 = v1;
        }

    label_33:
        Placeable v7_1 = arg9.measure-BRTryo0(ConstraintsKt.Constraints(v2, v0, v3, Constraints.getMaxHeight-impl(arg10)));
        return MeasureScope.layout$default(arg8, v7_1.getWidth(), v7_1.getHeight(), null, new UnspecifiedConstraintsNode$$ExternalSyntheticLambda0(v7_1), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg7, PlacementScope arg8) {
        PlacementScope.placeRelative$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        int v2 = arg2.minIntrinsicHeight(arg3);
        int v0 = !Float.isNaN(this.minHeight) ? arg1.roundToPx-0680j_4(this.minHeight) : 0;
        if(v2 < v0) {
            return v0;
        }

        return v2;
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        int v2 = arg2.minIntrinsicWidth(arg3);
        int v0 = !Float.isNaN(this.minWidth) ? arg1.roundToPx-0680j_4(this.minWidth) : 0;
        if(v2 < v0) {
            return v0;
        }

        return v2;
    }

    public final void setMinHeight-0680j_4(float arg1) {
        this.minHeight = arg1;
    }

    public final void setMinWidth-0680j_4(float arg1) {
        this.minWidth = arg1;
    }
}

