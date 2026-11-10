package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"androidx/compose/foundation/relocation/BringIntoViewRequesterKt__BringIntoViewRequesterKt", "androidx/compose/foundation/relocation/BringIntoViewRequesterKt__BringIntoViewResponderKt"}, k=4, mv={2, 0, 0}, xi=0x30) public final class BringIntoViewRequesterKt {
    public static final BringIntoViewRequester BringIntoViewRequester() {
        return BringIntoViewRequesterKt__BringIntoViewRequesterKt.BringIntoViewRequester();
    }

    public static final Modifier bringIntoViewRequester(Modifier arg0, BringIntoViewRequester arg1) {
        return BringIntoViewRequesterKt__BringIntoViewRequesterKt.bringIntoViewRequester(arg0, arg1);
    }

    @Deprecated(message="Use BringIntoViewModifierNode instead") public static final Modifier bringIntoViewResponder(Modifier arg0, BringIntoViewResponder arg1) {
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.bringIntoViewResponder(arg0, arg1);
    }
}

