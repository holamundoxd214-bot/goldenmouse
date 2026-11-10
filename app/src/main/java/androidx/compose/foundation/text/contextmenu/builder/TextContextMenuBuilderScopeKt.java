package androidx.compose.foundation.text.contextmenu.builder;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u001A\u0010\u0000\u001A\u00020\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2={"isSeparator", "", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuComponent;", "(Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuComponent;)Z", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuBuilderScopeKt {
    public static final boolean isSeparator(TextContextMenuComponent arg1) {
        if(arg1 == TextContextMenuSeparator.INSTANCE) {
            return 1;
        }

        return 0;
    }
}

