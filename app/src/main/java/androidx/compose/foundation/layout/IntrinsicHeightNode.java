package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0010\u001A\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001C\u0010\u0018\u001A\u00020\u0019*\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0019H\u0016J\u001C\u0010\u001D\u001A\u00020\u0019*\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0019H\u0016R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\u00020\u0005X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/layout/IntrinsicHeightNode;", "Landroidx/compose/foundation/layout/IntrinsicSizeModifier;", "height", "Landroidx/compose/foundation/layout/IntrinsicSize;", "enforceIncoming", "", "<init>", "(Landroidx/compose/foundation/layout/IntrinsicSize;Z)V", "getHeight", "()Landroidx/compose/foundation/layout/IntrinsicSize;", "setHeight", "(Landroidx/compose/foundation/layout/IntrinsicSize;)V", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "calculateContentConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "calculateContentConstraints-l58MMJ0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)J", "minIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicHeight", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class IntrinsicHeightNode extends IntrinsicSizeModifier {
    private boolean enforceIncoming;
    private IntrinsicSize height;

    public IntrinsicHeightNode(IntrinsicSize arg1, boolean arg2) {
        super();
        this.height = arg1;
        this.enforceIncoming = arg2;
    }

    public long calculateContentConstraints-l58MMJ0(MeasureScope arg1, Measurable arg2, long arg3) {
        int v0 = this.height == IntrinsicSize.Min ? arg2.minIntrinsicHeight(Constraints.getMaxWidth-impl(arg3)) : arg2.maxIntrinsicHeight(Constraints.getMaxWidth-impl(arg3));
        if(v0 < 0) {
            v0 = 0;
        }

        return Constraints.Companion.fixedHeight-OenEA2s(v0);
    }

    public boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final IntrinsicSize getHeight() {
        return this.height;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        if(this.height == IntrinsicSize.Min) {
            return arg2.minIntrinsicHeight(arg3);
        }

        return arg2.maxIntrinsicHeight(arg3);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        if(this.height == IntrinsicSize.Min) {
            return arg2.minIntrinsicHeight(arg3);
        }

        return arg2.maxIntrinsicHeight(arg3);
    }

    public void setEnforceIncoming(boolean arg1) {
        this.enforceIncoming = arg1;
    }

    public final void setHeight(IntrinsicSize arg1) {
        this.height = arg1;
    }
}

