package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0004H\u0016J\b\u0010\t\u001A\u00020\nH\u0016J\u000E\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\u0004J#\u0010\f\u001A\u00020\r*\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/layout/InsetsPaddingModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "calculateInsets", "ancestorConsumedInsets", "insetsInvalidated", "", "update", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public class InsetsPaddingModifierNode extends InsetsConsumingModifierNode implements LayoutModifierNode {
    public static final int $stable = 8;
    private WindowInsets insets;

    static {
    }

    public InsetsPaddingModifierNode(WindowInsets arg1) {
        super();
        this.insets = arg1;
    }

    public WindowInsets calculateInsets(WindowInsets arg1) {
        return WindowInsetsKt.union(arg1, this.insets);
    }

    public void insetsInvalidated() {
        super.insetsInvalidated();
        LayoutModifierNodeKt.invalidateMeasurement(((LayoutModifierNode)this));
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg15, Measurable arg16, long arg17) {
        int v2 = this.getConsumedInsets().getLeft(arg15, arg15.getLayoutDirection()) - this.getAncestorConsumedInsets().getLeft(arg15, arg15.getLayoutDirection());
        int v4 = this.getConsumedInsets().getTop(arg15) - this.getAncestorConsumedInsets().getTop(arg15);
        int v5 = this.getConsumedInsets().getRight(arg15, arg15.getLayoutDirection()) - this.getAncestorConsumedInsets().getRight(arg15, arg15.getLayoutDirection()) + v2;
        int v6 = this.getConsumedInsets().getBottom(arg15) - this.getAncestorConsumedInsets().getBottom(arg15) + v4;
        Placeable v14 = arg16.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(arg17, -v5, -v6));
        return MeasureScope.layout$default(arg15, ConstraintsKt.constrainWidth-K40F9xA(arg17, v14.getWidth() + v5), ConstraintsKt.constrainHeight-K40F9xA(arg17, v14.getHeight() + v6), null, new InsetsPaddingModifierNode$$ExternalSyntheticLambda0(v14, v2, v4), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg7, int arg8, int arg9, PlacementScope arg10) {
        PlacementScope.place$default(arg10, arg7, arg8, arg9, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public final void update(WindowInsets arg2) {
        if(!Intrinsics.areEqual(arg2, this.insets)) {
            this.insets = arg2;
            this.insetsInvalidated();
        }
    }
}

