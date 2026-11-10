package androidx.compose.ui.autofill;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001A\u00020\u0002¨\u0006\u0003"}, d2={"contentType", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/autofill/ContentType;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AutofillModifierKt {
    public static final Modifier contentType(Modifier arg3, ContentType arg4) {
        return SemanticsModifierKt.semantics$default(arg3, false, new AutofillModifierKt$contentType$1(arg4), 1, null);
    }
}

