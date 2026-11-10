package androidx.compose.material3;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0007\"\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001A\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t\"\"\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0017\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2={"minimumInteractiveComponentSize", "Landroidx/compose/ui/Modifier;", "MinimumInteractiveTopAlignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "getMinimumInteractiveTopAlignmentLine", "()Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "MinimumInteractiveLeftAlignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "getMinimumInteractiveLeftAlignmentLine", "()Landroidx/compose/ui/layout/VerticalAlignmentLine;", "LocalMinimumInteractiveComponentEnforcement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalMinimumInteractiveComponentEnforcement$annotations", "()V", "getLocalMinimumInteractiveComponentEnforcement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalMinimumInteractiveComponentSize", "Landroidx/compose/ui/unit/Dp;", "getLocalMinimumInteractiveComponentSize", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InteractiveComponentSizeKt {
    private static final ProvidableCompositionLocal LocalMinimumInteractiveComponentEnforcement;
    private static final ProvidableCompositionLocal LocalMinimumInteractiveComponentSize;
    private static final VerticalAlignmentLine MinimumInteractiveLeftAlignmentLine;
    private static final HorizontalAlignmentLine MinimumInteractiveTopAlignmentLine;

    static {
        InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine = new HorizontalAlignmentLine(InteractiveComponentSizeKt$MinimumInteractiveTopAlignmentLine$1.INSTANCE);
        InteractiveComponentSizeKt.MinimumInteractiveLeftAlignmentLine = new VerticalAlignmentLine(InteractiveComponentSizeKt$MinimumInteractiveLeftAlignmentLine$1.INSTANCE);
        InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement = CompositionLocalKt.staticCompositionLocalOf(new InteractiveComponentSizeKt$$ExternalSyntheticLambda0());
        InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize = CompositionLocalKt.staticCompositionLocalOf(new InteractiveComponentSizeKt$$ExternalSyntheticLambda1());
    }

    static final boolean LocalMinimumInteractiveComponentEnforcement$lambda$0() {
        return 1;
    }

    static final Dp LocalMinimumInteractiveComponentSize$lambda$1() {
        return Dp.box-impl(Dp.constructor-impl(48f));
    }

    public static final ProvidableCompositionLocal getLocalMinimumInteractiveComponentEnforcement() {
        return InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use LocalMinimumInteractiveComponentSize with 0.dp to turn off enforcement instead.", replaceWith="<_subannotation>") public static void getLocalMinimumInteractiveComponentEnforcement$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalMinimumInteractiveComponentSize() {
        return InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize;
    }

    public static final VerticalAlignmentLine getMinimumInteractiveLeftAlignmentLine() {
        return InteractiveComponentSizeKt.MinimumInteractiveLeftAlignmentLine;
    }

    public static final HorizontalAlignmentLine getMinimumInteractiveTopAlignmentLine() {
        return InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
    }

    public static final Modifier minimumInteractiveComponentSize(Modifier arg1) {
        return arg1.then(MinimumInteractiveModifier.INSTANCE);
    }
}

