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
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001A\u00020\n*\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\nH&¢\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0011\u001A\u00020\u0012*\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u001C\u0010\u0015\u001A\u00020\u0016*\u00020\u00172\u0006\u0010\f\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0016H\u0016J\u001C\u0010\u001A\u001A\u00020\u0016*\u00020\u00172\u0006\u0010\f\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u0016H\u0016J\u001C\u0010\u001C\u001A\u00020\u0016*\u00020\u00172\u0006\u0010\f\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0016H\u0016J\u001C\u0010\u001D\u001A\u00020\u0016*\u00020\u00172\u0006\u0010\f\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u0016H\u0016R\u0012\u0010\u0005\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/layout/IntrinsicSizeModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "enforceIncoming", "", "getEnforceIncoming", "()Z", "calculateContentConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "calculateContentConstraints-l58MMJ0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) abstract class IntrinsicSizeModifier extends Node implements LayoutModifierNode {
    public IntrinsicSizeModifier() {
        super();
    }

    public abstract long calculateContentConstraints-l58MMJ0(MeasureScope arg1, Measurable arg2, long arg3);

    public abstract boolean getEnforceIncoming();

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.maxIntrinsicHeight(arg3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.maxIntrinsicWidth(arg3);
    }

    public final MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        long v0 = this.calculateContentConstraints-l58MMJ0(arg8, arg9, arg10);
        if(this.getEnforceIncoming()) {
            v0 = ConstraintsKt.constrain-N9IONVI(arg10, v0);
        }

        Placeable v7 = arg9.measure-BRTryo0(v0);
        return MeasureScope.layout$default(arg8, v7.getWidth(), v7.getHeight(), null, new IntrinsicSizeModifier$$ExternalSyntheticLambda0(v7), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg8, PlacementScope arg9) {
        PlacementScope.placeRelative-70tqf50$default(arg9, arg8, IntOffset.Companion.getZero-nOcc-ac(), 0f, 2, null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.minIntrinsicHeight(arg3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.minIntrinsicWidth(arg3);
    }
}

