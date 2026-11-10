package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u001D\u0010\u0005\u001A\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u0004H\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J-\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0003\u001A\u00020\u00042\u001D\u0010\u0005\u001A\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tJ#\u0010\u0012\u001A\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R%\u0010\u0005\u001A\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/layout/DerivedHeightModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "heightCalc", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;)V", "heightInsets", "calculateInsets", "ancestorConsumedInsets", "insetsInvalidated", "", "update", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class DerivedHeightModifierNode extends InsetsConsumingModifierNode implements LayoutModifierNode {
    private Function2 heightCalc;
    private WindowInsets heightInsets;
    private WindowInsets insets;

    public DerivedHeightModifierNode(WindowInsets arg1, Function2 arg2) {
        super();
        this.insets = arg1;
        this.heightCalc = arg2;
        this.heightInsets = WindowInsetsKt.WindowInsets();
    }

    public WindowInsets calculateInsets(WindowInsets arg1) {
        return arg1;
    }

    public void insetsInvalidated() {
        this.heightInsets = WindowInsetsKt.exclude(this.insets, this.getAncestorConsumedInsets());
        super.insetsInvalidated();
        LayoutModifierNodeKt.invalidateMeasurement(((LayoutModifierNode)this));
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg11, Measurable arg12, long arg13) {
        int v2 = this.heightCalc.invoke(this.heightInsets, arg11).intValue();
        if(v2 == 0) {
            return MeasureScope.layout$default(arg11, 0, 0, null, new DerivedHeightModifierNode$$ExternalSyntheticLambda0(), 4, null);
        }

        MeasureScope v10 = arg11;
        Placeable v11 = arg12.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg13, 0, 0, v2, v2, 3, null));
        return MeasureScope.layout$default(v10, v11.getWidth(), v2, null, new DerivedHeightModifierNode$$ExternalSyntheticLambda1(v11), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$1(Placeable arg7, PlacementScope arg8) {
        PlacementScope.placeRelative$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public final void update(WindowInsets arg2, Function2 arg3) {
        if(Intrinsics.areEqual(this.insets, arg2)) {
            if(arg3 != this.heightCalc) {
            }
            else {
                return;
            }
        }

        this.insets = arg2;
        this.heightCalc = arg3;
        this.heightInsets = WindowInsetsKt.exclude(arg2, this.getAncestorConsumedInsets());
        LayoutModifierNodeKt.invalidateMeasurement(((LayoutModifierNode)this));
    }
}

