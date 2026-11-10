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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ#\u0010 \u001A\u00020!*\u00020\"2\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020\u001CH\u0016¢\u0006\u0004\b&\u0010\'J\u001C\u0010(\u001A\u00020)*\u00020*2\u0006\u0010#\u001A\u00020+2\u0006\u0010,\u001A\u00020)H\u0016J\u001C\u0010-\u001A\u00020)*\u00020*2\u0006\u0010#\u001A\u00020+2\u0006\u0010.\u001A\u00020)H\u0016J\u001C\u0010/\u001A\u00020)*\u00020*2\u0006\u0010#\u001A\u00020+2\u0006\u0010,\u001A\u00020)H\u0016J\u001C\u00100\u001A\u00020)*\u00020*2\u0006\u0010#\u001A\u00020+2\u0006\u0010.\u001A\u00020)H\u0016R\u001C\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0005\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001C\u0010\u0006\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000FR\u001C\u0010\u0007\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000FR\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u0018\u0010\u001B\u001A\u00020\u001C*\u00020\u001D8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001F¨\u00061"}, d2={"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "F", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMaxHeight-D9Ej5fM", "setMaxHeight-0680j_4", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class SizeNode extends Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public SizeNode(float arg1, float arg2, float arg3, float arg4, boolean arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    private SizeNode(float arg1, float arg2, float arg3, float arg4, boolean arg5) {
        super();
        this.minWidth = arg1;
        this.minHeight = arg2;
        this.maxWidth = arg3;
        this.maxHeight = arg4;
        this.enforceIncoming = arg5;
    }

    public SizeNode(float arg8, float arg9, float arg10, float arg11, boolean arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 1) != 0) {
            arg8 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        float v1 = arg8;
        if((arg13 & 2) != 0) {
            arg9 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        float v2 = arg9;
        if((arg13 & 4) != 0) {
            arg10 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        float v3 = arg10;
        if((arg13 & 8) != 0) {
            arg11 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        this(v1, v2, v3, arg11, arg12, null);
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final float getMaxHeight-D9Ej5fM() {
        return this.maxHeight;
    }

    public final float getMaxWidth-D9Ej5fM() {
        return this.maxWidth;
    }

    public final float getMinHeight-D9Ej5fM() {
        return this.minHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return this.minWidth;
    }

    private final long getTargetConstraints-OenEA2s(Density arg7) {
        int v4;
        int v3;
        int v0;
        int v1 = 0x7FFFFFFF;
        int v2 = 0;
        if(!Float.isNaN(this.maxWidth)) {
            v0 = arg7.roundToPx-0680j_4(this.maxWidth);
            if(v0 < 0) {
                v0 = 0;
            }
        }
        else {
            v0 = v1;
        }

        if(!Float.isNaN(this.maxHeight)) {
            v3 = arg7.roundToPx-0680j_4(this.maxHeight);
            if(v3 < 0) {
                v3 = 0;
            }
        }
        else {
            v3 = v1;
        }

        if(!Float.isNaN(this.minWidth)) {
            v4 = arg7.roundToPx-0680j_4(this.minWidth);
            if(v4 < 0) {
                v4 = 0;
            }

            if(v4 > v0) {
                v4 = v0;
            }

            if(v4 == v1) {
                goto label_31;
            }
        }
        else {
        label_31:
            v4 = 0;
        }

        if(!Float.isNaN(this.minHeight)) {
            int v6 = arg7.roundToPx-0680j_4(this.minHeight);
            if(v6 < 0) {
                v6 = 0;
            }

            if(v6 > v3) {
                v6 = v3;
            }

            if(v6 == v1) {
                goto label_43;
            }

            v2 = v6;
        }

    label_43:
        return ConstraintsKt.Constraints(v4, v0, v2, v3);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        long v0 = this.getTargetConstraints-OenEA2s(((Density)arg3));
        if(Constraints.getHasFixedHeight-impl(v0)) {
            return Constraints.getMaxHeight-impl(v0);
        }

        if(this.enforceIncoming) {
        }
        else {
            arg5 = ConstraintsKt.constrainWidth-K40F9xA(v0, arg5);
        }

        return ConstraintsKt.constrainHeight-K40F9xA(v0, arg4.maxIntrinsicHeight(arg5));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        long v0 = this.getTargetConstraints-OenEA2s(((Density)arg3));
        if(Constraints.getHasFixedWidth-impl(v0)) {
            return Constraints.getMaxWidth-impl(v0);
        }

        if(this.enforceIncoming) {
        }
        else {
            arg5 = ConstraintsKt.constrainHeight-K40F9xA(v0, arg5);
        }

        return ConstraintsKt.constrainWidth-K40F9xA(v0, arg4.maxIntrinsicWidth(arg5));
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        int v7;
        int v4;
        int v3;
        int v2;
        long v0 = this.getTargetConstraints-OenEA2s(arg8);
        if(this.enforceIncoming) {
            arg10 = ConstraintsKt.constrain-N9IONVI(arg10, v0);
        }
        else {
            if(!Float.isNaN(this.minWidth)) {
                v2 = Constraints.getMinWidth-impl(v0);
            }
            else {
                v2 = Constraints.getMinWidth-impl(arg10);
                v3 = Constraints.getMaxWidth-impl(v0);
                if(v2 > v3) {
                    v2 = v3;
                }
            }

            if(!Float.isNaN(this.maxWidth)) {
                v3 = Constraints.getMaxWidth-impl(v0);
            }
            else {
                v3 = Constraints.getMaxWidth-impl(arg10);
                v4 = Constraints.getMinWidth-impl(v0);
                if(v3 < v4) {
                    v3 = v4;
                }
            }

            if(!Float.isNaN(this.minHeight)) {
                v4 = Constraints.getMinHeight-impl(v0);
            }
            else {
                v4 = Constraints.getMinHeight-impl(arg10);
                int v5 = Constraints.getMaxHeight-impl(v0);
                if(v4 > v5) {
                    v4 = v5;
                }
            }

            if(!Float.isNaN(this.maxHeight)) {
                v7 = Constraints.getMaxHeight-impl(v0);
            }
            else {
                v7 = Constraints.getMaxHeight-impl(arg10);
                int v10 = Constraints.getMinHeight-impl(v0);
                if(v7 < v10) {
                    v7 = v10;
                }
            }

            arg10 = ConstraintsKt.Constraints(v2, v3, v4, v7);
        }

        Placeable v7_1 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v7_1.getWidth(), v7_1.getHeight(), null, new SizeNode$$ExternalSyntheticLambda0(v7_1), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$1(Placeable arg7, PlacementScope arg8) {
        PlacementScope.placeRelative$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        long v0 = this.getTargetConstraints-OenEA2s(((Density)arg3));
        if(Constraints.getHasFixedHeight-impl(v0)) {
            return Constraints.getMaxHeight-impl(v0);
        }

        if(this.enforceIncoming) {
        }
        else {
            arg5 = ConstraintsKt.constrainWidth-K40F9xA(v0, arg5);
        }

        return ConstraintsKt.constrainHeight-K40F9xA(v0, arg4.minIntrinsicHeight(arg5));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        long v0 = this.getTargetConstraints-OenEA2s(((Density)arg3));
        if(Constraints.getHasFixedWidth-impl(v0)) {
            return Constraints.getMaxWidth-impl(v0);
        }

        if(this.enforceIncoming) {
        }
        else {
            arg5 = ConstraintsKt.constrainHeight-K40F9xA(v0, arg5);
        }

        return ConstraintsKt.constrainWidth-K40F9xA(v0, arg4.minIntrinsicWidth(arg5));
    }

    public final void setEnforceIncoming(boolean arg1) {
        this.enforceIncoming = arg1;
    }

    public final void setMaxHeight-0680j_4(float arg1) {
        this.maxHeight = arg1;
    }

    public final void setMaxWidth-0680j_4(float arg1) {
        this.maxWidth = arg1;
    }

    public final void setMinHeight-0680j_4(float arg1) {
        this.minHeight = arg1;
    }

    public final void setMinWidth-0680j_4(float arg1) {
        this.minWidth = arg1;
    }
}

