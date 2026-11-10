package androidx.compose.material3.internal;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001E\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0002\u0010\u0003\u001A\u0004\b\u0004\u0010\u0005\"\u001E\u0010\u0007\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\b\u0010\u0003\u001A\u0004\b\t\u0010\u0005\"\u0014\u0010\n\u001A\u00020\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r\"\u0014\u0010\u000E\u001A\u00020\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\r¨\u0006\u0010"}, d2={"HorizontalSemanticsBoundsPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalSemanticsBoundsPadding$annotations", "()V", "getHorizontalSemanticsBoundsPadding", "()F", "F", "VerticalSemanticsBoundsPadding", "getVerticalSemanticsBoundsPadding$annotations", "getVerticalSemanticsBoundsPadding", "IncreaseHorizontalSemanticsBounds", "Landroidx/compose/ui/Modifier;", "getIncreaseHorizontalSemanticsBounds", "()Landroidx/compose/ui/Modifier;", "IncreaseVerticalSemanticsBounds", "getIncreaseVerticalSemanticsBounds", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AccessibilityUtilKt {
    private static final float HorizontalSemanticsBoundsPadding;
    private static final Modifier IncreaseHorizontalSemanticsBounds;
    private static final Modifier IncreaseVerticalSemanticsBounds;
    private static final float VerticalSemanticsBoundsPadding;

    static {
        float v1 = Dp.constructor-impl(10f);
        AccessibilityUtilKt.HorizontalSemanticsBoundsPadding = v1;
        float v0 = Dp.constructor-impl(10f);
        AccessibilityUtilKt.VerticalSemanticsBoundsPadding = v0;
        AccessibilityUtilKt.IncreaseHorizontalSemanticsBounds = PaddingKt.padding-VpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(Modifier.Companion, new AccessibilityUtilKt$$ExternalSyntheticLambda1()), true, new AccessibilityUtilKt$$ExternalSyntheticLambda2()), v1, 0f, 2, null);
        AccessibilityUtilKt.IncreaseVerticalSemanticsBounds = PaddingKt.padding-VpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(Modifier.Companion, new AccessibilityUtilKt$$ExternalSyntheticLambda3()), true, new AccessibilityUtilKt$$ExternalSyntheticLambda4()), 0f, v0, 1, null);
    }

    static final MeasureResult IncreaseHorizontalSemanticsBounds$lambda$1(MeasureScope arg8, Measurable arg9, Constraints arg10) {
        int v0 = arg8.roundToPx-0680j_4(AccessibilityUtilKt.HorizontalSemanticsBoundsPadding);
        long v1 = arg10.unbox-impl();
        int v10 = v0 * 2;
        Placeable v9 = arg9.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(v1, v10, 0));
        return MeasureScope.layout$default(arg8, v9.getWidth() - v10, v9.getHeight(), null, new AccessibilityUtilKt$$ExternalSyntheticLambda5(v9, v0), 4, null);
    }

    static final Unit IncreaseHorizontalSemanticsBounds$lambda$1$lambda$0(Placeable arg7, int arg8, PlacementScope arg9) {
        PlacementScope.place$default(arg9, arg7, -arg8, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    static final Unit IncreaseHorizontalSemanticsBounds$lambda$2(SemanticsPropertyReceiver arg0) {
        return Unit.INSTANCE;
    }

    static final MeasureResult IncreaseVerticalSemanticsBounds$lambda$4(MeasureScope arg9, Measurable arg10, Constraints arg11) {
        int v0 = arg9.roundToPx-0680j_4(AccessibilityUtilKt.VerticalSemanticsBoundsPadding);
        long v1 = arg11.unbox-impl();
        int v11 = v0 * 2;
        Placeable v10 = arg10.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(v1, 0, v11));
        return MeasureScope.layout$default(arg9, v10.getWidth(), v10.getHeight() - v11, null, new AccessibilityUtilKt$$ExternalSyntheticLambda0(v10, v0), 4, null);
    }

    static final Unit IncreaseVerticalSemanticsBounds$lambda$4$lambda$3(Placeable arg7, int arg8, PlacementScope arg9) {
        PlacementScope.place$default(arg9, arg7, 0, -arg8, 0f, 4, null);
        return Unit.INSTANCE;
    }

    static final Unit IncreaseVerticalSemanticsBounds$lambda$5(SemanticsPropertyReceiver arg0) {
        return Unit.INSTANCE;
    }

    public static final float getHorizontalSemanticsBoundsPadding() {
        return AccessibilityUtilKt.HorizontalSemanticsBoundsPadding;
    }

    public static void getHorizontalSemanticsBoundsPadding$annotations() {
    }

    public static final Modifier getIncreaseHorizontalSemanticsBounds() {
        return AccessibilityUtilKt.IncreaseHorizontalSemanticsBounds;
    }

    public static final Modifier getIncreaseVerticalSemanticsBounds() {
        return AccessibilityUtilKt.IncreaseVerticalSemanticsBounds;
    }

    public static final float getVerticalSemanticsBoundsPadding() {
        return AccessibilityUtilKt.VerticalSemanticsBoundsPadding;
    }

    public static void getVerticalSemanticsBoundsPadding$annotations() {
    }
}

