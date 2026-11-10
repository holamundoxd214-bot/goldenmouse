package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
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

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001A\u00020\u000B*\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class PaddingValuesModifier extends Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public PaddingValuesModifier(PaddingValues arg1) {
        super();
        this.paddingValues = arg1;
    }

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg12, Measurable arg13, long arg14) {
        float v0 = this.paddingValues.calculateLeftPadding-u2uoSUM(arg12.getLayoutDirection());
        float v1 = this.paddingValues.calculateTopPadding-D9Ej5fM();
        float v2 = this.paddingValues.calculateRightPadding-u2uoSUM(arg12.getLayoutDirection());
        float v11 = this.paddingValues.calculateBottomPadding-D9Ej5fM();
        int v5 = 1;
        int v4 = Dp.compareTo-0680j_4(v0, Dp.constructor-impl(0f)) >= 0 ? 1 : 0;
        int v7 = Dp.compareTo-0680j_4(v1, Dp.constructor-impl(0f)) >= 0 ? 1 : 0;
        v4 &= v7;
        v7 = Dp.compareTo-0680j_4(v2, Dp.constructor-impl(0f)) >= 0 ? 1 : 0;
        v4 &= v7;
        if(Dp.compareTo-0680j_4(v11, Dp.constructor-impl(0f)) >= 0) {
        }
        else {
            v5 = 0;
        }

        if((v4 & v5) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }

        int v0_1 = arg12.roundToPx-0680j_4(v0);
        int v2_1 = arg12.roundToPx-0680j_4(v2) + v0_1;
        int v1_1 = arg12.roundToPx-0680j_4(v1);
        int v11_1 = arg12.roundToPx-0680j_4(v11) + v1_1;
        Placeable v13 = arg13.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(arg14, -v2_1, -v11_1));
        return MeasureScope.layout$default(arg12, ConstraintsKt.constrainWidth-K40F9xA(arg14, v13.getWidth() + v2_1), ConstraintsKt.constrainHeight-K40F9xA(arg14, v13.getHeight() + v11_1), null, new PaddingValuesModifier$$ExternalSyntheticLambda0(v13, v0_1, v1_1), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$1(Placeable arg7, int arg8, int arg9, PlacementScope arg10) {
        PlacementScope.place$default(arg10, arg7, arg8, arg9, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public final void setPaddingValues(PaddingValues arg1) {
        this.paddingValues = arg1;
    }
}

