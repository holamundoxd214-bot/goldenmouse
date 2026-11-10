package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0019\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2={"LocalTextContextMenuDropdownProvider", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "getLocalTextContextMenuDropdownProvider", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTextContextMenuToolbarProvider", "getLocalTextContextMenuToolbarProvider", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuProviderKt {
    private static final ProvidableCompositionLocal LocalTextContextMenuDropdownProvider;
    private static final ProvidableCompositionLocal LocalTextContextMenuToolbarProvider;

    static {
        TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider = CompositionLocalKt.compositionLocalOf$default(null, new TextContextMenuProviderKt$$ExternalSyntheticLambda0(), 1, null);
        TextContextMenuProviderKt.LocalTextContextMenuToolbarProvider = CompositionLocalKt.compositionLocalOf$default(null, new TextContextMenuProviderKt$$ExternalSyntheticLambda1(), 1, null);
    }

    static final TextContextMenuProvider LocalTextContextMenuDropdownProvider$lambda$0() {
        return null;
    }

    static final TextContextMenuProvider LocalTextContextMenuToolbarProvider$lambda$0() {
        return null;
    }

    public static final ProvidableCompositionLocal getLocalTextContextMenuDropdownProvider() {
        return TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider;
    }

    public static final ProvidableCompositionLocal getLocalTextContextMenuToolbarProvider() {
        return TextContextMenuProviderKt.LocalTextContextMenuToolbarProvider;
    }
}

