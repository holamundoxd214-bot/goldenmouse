package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0007\u001A\u0012\u0010\u0002\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001A\u00020\u0001¨\u0006\u0004"}, d2={"BringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "bringIntoViewRequester", "Landroidx/compose/ui/Modifier;", "foundation"}, k=5, mv={2, 0, 0}, xi=0x30, xs="androidx/compose/foundation/relocation/BringIntoViewRequesterKt") final class BringIntoViewRequesterKt__BringIntoViewRequesterKt {
    public static final BringIntoViewRequester BringIntoViewRequester() {
        return new BringIntoViewRequesterImpl();
    }

    public static final Modifier bringIntoViewRequester(Modifier arg1, BringIntoViewRequester arg2) {
        return arg1.then(new BringIntoViewRequesterElement(arg2));
    }
}

