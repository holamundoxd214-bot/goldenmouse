package androidx.compose.animation;

import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001C\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"ModifierLocalSharedElementInternalState", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/animation/SharedElementEntry;", "getModifierLocalSharedElementInternalState", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SharedContentNodeKt {
    private static final ProvidableModifierLocal ModifierLocalSharedElementInternalState;

    static {
        SharedContentNodeKt.ModifierLocalSharedElementInternalState = ModifierLocalKt.modifierLocalOf(SharedContentNodeKt$ModifierLocalSharedElementInternalState$1.INSTANCE);
    }

    public static final ProvidableModifierLocal getModifierLocalSharedElementInternalState() {
        return SharedContentNodeKt.ModifierLocalSharedElementInternalState;
    }
}

