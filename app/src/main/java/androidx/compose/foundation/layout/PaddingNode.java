package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ#\u0010\u001B\u001A\u00020\u001C*\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u001C\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0005\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001C\u0010\u0006\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000FR\u001C\u0010\u0007\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000FR\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006$"}, d2={"Landroidx/compose/foundation/layout/PaddingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM", "()F", "setStart-0680j_4", "(F)V", "F", "getTop-D9Ej5fM", "setTop-0680j_4", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getBottom-D9Ej5fM", "setBottom-0680j_4", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class PaddingNode extends Node implements LayoutModifierNode {
    private float bottom;
    private float end;
    private boolean rtlAware;
    private float start;
    private float top;

    public PaddingNode(float arg1, float arg2, float arg3, float arg4, boolean arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    private PaddingNode(float arg1, float arg2, float arg3, float arg4, boolean arg5) {
        super();
        this.start = arg1;
        this.top = arg2;
        this.end = arg3;
        this.bottom = arg4;
        this.rtlAware = arg5;
    }

    public PaddingNode(float arg9, float arg10, float arg11, float arg12, boolean arg13, int arg14, DefaultConstructorMarker arg15) {
        if((arg14 & 1) != 0) {
            arg9 = Dp.constructor-impl(0f);
        }

        float v2 = arg9;
        if((arg14 & 2) != 0) {
            arg10 = Dp.constructor-impl(0f);
        }

        float v3 = arg10;
        if((arg14 & 4) != 0) {
            arg11 = Dp.constructor-impl(0f);
        }

        float v4 = arg11;
        if((arg14 & 8) != 0) {
            arg12 = Dp.constructor-impl(0f);
        }

        this(v2, v3, v4, arg12, arg13, null);
    }

    public final float getBottom-D9Ej5fM() {
        return this.bottom;
    }

    public final float getEnd-D9Ej5fM() {
        return this.end;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    public final float getStart-D9Ej5fM() {
        return this.start;
    }

    public final float getTop-D9Ej5fM() {
        return this.top;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg11, Measurable arg12, long arg13) {
        int v0 = arg11.roundToPx-0680j_4(this.start) + arg11.roundToPx-0680j_4(this.end);
        int v1 = arg11.roundToPx-0680j_4(this.top) + arg11.roundToPx-0680j_4(this.bottom);
        Placeable v12 = arg12.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(arg13, -v0, -v1));
        return MeasureScope.layout$default(arg11, ConstraintsKt.constrainWidth-K40F9xA(arg13, v12.getWidth() + v0), ConstraintsKt.constrainHeight-K40F9xA(arg13, v12.getHeight() + v1), null, new PaddingNode$$ExternalSyntheticLambda0(this, v12), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(PaddingNode arg7, Placeable arg8, PlacementScope arg9) {
        if(arg7.rtlAware) {
            PlacementScope.placeRelative$default(arg9, arg8, arg9.roundToPx-0680j_4(arg7.start), arg9.roundToPx-0680j_4(arg7.top), 0f, 4, null);
        }
        else {
            PlacementScope.place$default(arg9, arg8, arg9.roundToPx-0680j_4(arg7.start), arg9.roundToPx-0680j_4(arg7.top), 0f, 4, null);
        }

        return Unit.INSTANCE;
    }

    public final void setBottom-0680j_4(float arg1) {
        this.bottom = arg1;
    }

    public final void setEnd-0680j_4(float arg1) {
        this.end = arg1;
    }

    public final void setRtlAware(boolean arg1) {
        this.rtlAware = arg1;
    }

    public final void setStart-0680j_4(float arg1) {
        this.start = arg1;
    }

    public final void setTop-0680j_4(float arg1) {
        this.top = arg1;
    }
}

