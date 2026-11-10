package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001AJ#\u0010\u001B\u001A\u00020\u001C*\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u001C\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u000E\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001C\u0010\u0005\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u000E\u001A\u0004\b\u000F\u0010\u000B\"\u0004\b\u0010\u0010\rR\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0012¨\u0006$"}, d2={"Landroidx/compose/foundation/layout/OffsetNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "rtlAware", "", "<init>", "(FFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getX-D9Ej5fM", "()F", "setX-0680j_4", "(F)V", "F", "getY-D9Ej5fM", "setY-0680j_4", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "update", "", "update-Md-fbLM", "(FFZ)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class OffsetNode extends Node implements LayoutModifierNode {
    private boolean rtlAware;
    private final boolean shouldAutoInvalidate;
    private float x;
    private float y;

    public OffsetNode(float arg1, float arg2, boolean arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    private OffsetNode(float arg1, float arg2, boolean arg3) {
        super();
        this.x = arg1;
        this.y = arg2;
        this.rtlAware = arg3;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public final float getX-D9Ej5fM() {
        return this.x;
    }

    public final float getY-D9Ej5fM() {
        return this.y;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v9 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v9.getWidth(), v9.getHeight(), null, new OffsetNode$$ExternalSyntheticLambda0(this, v9), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(OffsetNode arg7, Placeable arg8, PlacementScope arg9) {
        if(arg7.rtlAware) {
            PlacementScope.placeRelative$default(arg9, arg8, arg9.roundToPx-0680j_4(arg7.x), arg9.roundToPx-0680j_4(arg7.y), 0f, 4, null);
        }
        else {
            PlacementScope.place$default(arg9, arg8, arg9.roundToPx-0680j_4(arg7.x), arg9.roundToPx-0680j_4(arg7.y), 0f, 4, null);
        }

        return Unit.INSTANCE;
    }

    public final void setRtlAware(boolean arg1) {
        this.rtlAware = arg1;
    }

    public final void setX-0680j_4(float arg1) {
        this.x = arg1;
    }

    public final void setY-0680j_4(float arg1) {
        this.y = arg1;
    }

    public final void update-Md-fbLM(float arg2, float arg3, boolean arg4) {
        if(!Dp.equals-impl0(this.x, arg2) || !Dp.equals-impl0(this.y, arg3) || this.rtlAware != arg4) {
            LayoutModifierNodeKt.invalidatePlacement(this);
        }

        this.x = arg2;
        this.y = arg3;
        this.rtlAware = arg4;
    }
}

