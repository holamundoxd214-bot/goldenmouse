package androidx.compose.ui.layout;

import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001B\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"ModifierLocalBeyondBoundsLayout", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getModifierLocalBeyondBoundsLayout", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BeyondBoundsLayoutKt {
    private static final ProvidableModifierLocal ModifierLocalBeyondBoundsLayout;

    static {
        BeyondBoundsLayoutKt.ModifierLocalBeyondBoundsLayout = ModifierLocalKt.modifierLocalOf(BeyondBoundsLayoutKt$ModifierLocalBeyondBoundsLayout$1.INSTANCE);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Please use DelegatableNode.findNearestBeyondBoundsLayoutAncestor() to access the nearest parent BeyondBoundsLayout.") public static final ProvidableModifierLocal getModifierLocalBeyondBoundsLayout() {
        return BeyondBoundsLayoutKt.ModifierLocalBeyondBoundsLayout;
    }
}

