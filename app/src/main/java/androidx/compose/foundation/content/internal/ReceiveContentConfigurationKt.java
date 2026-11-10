package androidx.compose.foundation.content.internal;

import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A\u000E\u0010\u0005\u001A\u0004\u0018\u00010\u0002*\u00020\u0006H\u0000\"\u001C\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2={"ModifierLocalReceiveContent", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getModifierLocalReceiveContent", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getReceiveContentConfiguration", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ReceiveContentConfigurationKt {
    private static final ProvidableModifierLocal ModifierLocalReceiveContent;

    static {
        ReceiveContentConfigurationKt.ModifierLocalReceiveContent = ModifierLocalKt.modifierLocalOf(new ReceiveContentConfigurationKt$$ExternalSyntheticLambda0());
    }

    static final ReceiveContentConfiguration ModifierLocalReceiveContent$lambda$0() {
        return null;
    }

    public static final ProvidableModifierLocal getModifierLocalReceiveContent() {
        return ReceiveContentConfigurationKt.ModifierLocalReceiveContent;
    }

    public static final ReceiveContentConfiguration getReceiveContentConfiguration(ModifierLocalModifierNode arg1) {
        if(arg1.getNode().isAttached()) {
            return arg1.getCurrent(ReceiveContentConfigurationKt.ModifierLocalReceiveContent);
        }

        return null;
    }
}

