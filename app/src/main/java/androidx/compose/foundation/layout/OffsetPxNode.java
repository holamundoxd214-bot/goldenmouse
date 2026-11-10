package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B(\u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\u0016\u001A\u00020\u00172\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00072\u0006\u0010\b\u001A\u00020\tJ#\u0010\u0018\u001A\u00020\u0019*\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0016¢\u0006\u0004\b\u001F\u0010 R+\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0011¨\u0006!"}, d2={"Landroidx/compose/foundation/layout/OffsetPxNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "offset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "rtlAware", "", "<init>", "(Lkotlin/jvm/functions/Function1;Z)V", "getOffset", "()Lkotlin/jvm/functions/Function1;", "setOffset", "(Lkotlin/jvm/functions/Function1;)V", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "update", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class OffsetPxNode extends Node implements LayoutModifierNode {
    private Function1 offset;
    private boolean rtlAware;
    private final boolean shouldAutoInvalidate;

    public OffsetPxNode(Function1 arg1, boolean arg2) {
        super();
        this.offset = arg1;
        this.rtlAware = arg2;
    }

    public final Function1 getOffset() {
        return this.offset;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v9 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v9.getWidth(), v9.getHeight(), null, new OffsetPxNode$$ExternalSyntheticLambda0(this, v9), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(OffsetPxNode arg10, Placeable arg11, PlacementScope arg12) {
        long v3 = arg10.offset.invoke(arg12).unbox-impl();
        if(arg10.rtlAware) {
            PlacementScope.placeRelativeWithLayer$default(arg12, arg11, IntOffset.getX-impl(v3), IntOffset.getY-impl(v3), 0f, null, 12, null);
        }
        else {
            PlacementScope.placeWithLayer$default(arg12, arg11, IntOffset.getX-impl(v3), IntOffset.getY-impl(v3), 0f, null, 12, null);
        }

        return Unit.INSTANCE;
    }

    public final void setOffset(Function1 arg1) {
        this.offset = arg1;
    }

    public final void setRtlAware(boolean arg1) {
        this.rtlAware = arg1;
    }

    public final void update(Function1 arg2, boolean arg3) {
        if(this.offset != arg2 || this.rtlAware != arg3) {
            LayoutModifierNodeKt.invalidatePlacement(this);
        }

        this.offset = arg2;
        this.rtlAware = arg3;
    }
}

