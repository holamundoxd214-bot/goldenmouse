package androidx.compose.foundation.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016J#\u0010\u0010\u001A\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001C\u0010\u0019\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u0013\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001AH\u0016J\u001C\u0010\u001E\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u0013\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001AH\u0016J\u001C\u0010 \u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u0013\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001AH\u0016J\u001C\u0010!\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u0013\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001AH\u0016R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\""}, d2={"Landroidx/compose/foundation/layout/RecalculateWindowInsetsModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "<init>", "()V", "insets", "Landroidx/compose/foundation/layout/ValueInsets;", "getInsets", "()Landroidx/compose/foundation/layout/ValueInsets;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "calculateInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "ancestorConsumedInsets", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class RecalculateWindowInsetsModifierNode extends InsetsConsumingModifierNode implements LayoutModifierNode {
    private final ValueInsets insets;

    public RecalculateWindowInsetsModifierNode() {
        super();
        this.insets = new ValueInsets(new InsetsValues(0, 0, 0, 0), "reset");
    }

    public WindowInsets calculateInsets(WindowInsets arg3) {
        if(this.insets.getValue$foundation_layout().getLeft() == -1) {
            return arg3;
        }

        return this.insets;
    }

    public final ValueInsets getInsets() {
        return this.insets;
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.maxIntrinsicHeight(arg3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.maxIntrinsicWidth(arg3);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg9, Measurable arg10, long arg11) {
        if(Constraints.getHasFixedWidth-impl(arg11)) {
            if(!Constraints.getHasFixedHeight-impl(arg11)) {
            }
            else {
                int v2 = Constraints.getMaxWidth-impl(arg11);
                int v3 = Constraints.getMaxHeight-impl(arg11);
                return MeasureScope.layout$default(arg9, v2, v3, null, new RecalculateWindowInsetsModifierNode$$ExternalSyntheticLambda1(this, arg10, v2, v3), 4, null);
            }
        }

        MeasureScope v0 = arg9;
        int v1 = -1;
        if(this.insets.getValue$foundation_layout().getLeft() != v1) {
            this.insets.setValue$foundation_layout(new InsetsValues(v1, v1, v1, v1));
            this.insetsInvalidated();
        }

        Placeable v8 = arg10.measure-BRTryo0(arg11);
        return MeasureScope.layout$default(v0, v8.getWidth(), v8.getHeight(), null, new RecalculateWindowInsetsModifierNode$$ExternalSyntheticLambda0(v8), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$1(RecalculateWindowInsetsModifierNode arg13, Measurable arg14, int arg15, int arg16, PlacementScope arg17) {
        LayoutCoordinates v0 = arg17.getCoordinates();
        if(v0 != null) {
            long v1 = LayoutCoordinatesKt.positionInRoot(v0);
            long v3 = v0.getSize-YbymL2g();
            v3 = v0.localToRoot-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)(((int)(v3 & 0xFFFFFFFFL))))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)(((int)(v3 >> 0x20))))))) << 0x20));
            long v9 = LayoutCoordinatesKt.findRootCoordinates(v0).getSize-YbymL2g();
            int v0_1 = Math.round(Float.intBitsToFloat(((int)(v1 >> 0x20))));
            int v1_1 = Math.round(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))));
            int v2 = (((int)(v9 >> 0x20))) - Math.round(Float.intBitsToFloat(((int)(v3 >> 0x20))));
            int v5 = (((int)(v9 & 0xFFFFFFFFL))) - Math.round(Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL))));
            InsetsValues v3_1 = arg13.insets.getValue$foundation_layout();
            if(v3_1.getLeft() == v0_1 && v3_1.getTop() == v1_1 && v3_1.getRight() == v2 && v3_1.getBottom() == v5) {
                goto label_60;
            }

            arg13.insets.setValue$foundation_layout(new InsetsValues(v0_1, v1_1, v2, v5));
            arg13.insetsInvalidated();
        }

    label_60:
        PlacementScope.place$default(arg17, arg14.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(arg15, arg16)), 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.minIntrinsicHeight(arg3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.minIntrinsicWidth(arg3);
    }
}

