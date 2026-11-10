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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B4\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012#\u0010\u0005\u001A\u001F\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\b\n¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u0004H\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J3\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0003\u001A\u00020\u00042#\u0010\u0005\u001A\u001F\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\b\nJ#\u0010\u0013\u001A\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010\u0005\u001A\u001F\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\b\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/foundation/layout/DerivedWidthModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "widthCalc", "Lkotlin/Function3;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;)V", "widthInsets", "calculateInsets", "ancestorConsumedInsets", "insetsInvalidated", "", "update", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class DerivedWidthModifierNode extends InsetsConsumingModifierNode implements LayoutModifierNode {
    private WindowInsets insets;
    private Function3 widthCalc;
    private WindowInsets widthInsets;

    public DerivedWidthModifierNode(WindowInsets arg1, Function3 arg2) {
        super();
        this.insets = arg1;
        this.widthCalc = arg2;
        this.widthInsets = WindowInsetsKt.WindowInsets();
    }

    public WindowInsets calculateInsets(WindowInsets arg1) {
        return arg1;
    }

    public void insetsInvalidated() {
        this.widthInsets = WindowInsetsKt.exclude(this.insets, this.getAncestorConsumedInsets());
        super.insetsInvalidated();
        LayoutModifierNodeKt.invalidateMeasurement(((LayoutModifierNode)this));
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg10, Measurable arg11, long arg12) {
        int v1 = this.widthCalc.invoke(this.widthInsets, arg10.getLayoutDirection(), arg10).intValue();
        if(v1 == 0) {
            return MeasureScope.layout$default(arg10, 0, 0, null, new DerivedWidthModifierNode$$ExternalSyntheticLambda0(), 4, null);
        }

        MeasureScope v9 = arg10;
        Placeable v10 = arg11.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg12, v1, v1, 0, 0, 12, null));
        return MeasureScope.layout$default(v9, v1, v10.getHeight(), null, new DerivedWidthModifierNode$$ExternalSyntheticLambda1(v10), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$1(Placeable arg7, PlacementScope arg8) {
        PlacementScope.placeRelative$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public final void update(WindowInsets arg2, Function3 arg3) {
        if(Intrinsics.areEqual(this.insets, arg2)) {
            if(arg3 != this.widthCalc) {
            }
            else {
                return;
            }
        }

        this.insets = arg2;
        this.widthCalc = arg3;
        this.widthInsets = WindowInsetsKt.exclude(arg2, this.getAncestorConsumedInsets());
        LayoutModifierNodeKt.invalidateMeasurement(((LayoutModifierNode)this));
    }
}

