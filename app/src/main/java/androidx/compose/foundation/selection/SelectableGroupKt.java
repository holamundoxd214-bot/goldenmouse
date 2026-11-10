package androidx.compose.foundation.selection;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0007¨\u0006\u0002"}, d2={"selectableGroup", "Landroidx/compose/ui/Modifier;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectableGroupKt {
    public static final Modifier selectableGroup(Modifier arg4) {
        return SemanticsModifierKt.semantics$default(arg4, false, new SelectableGroupKt$$ExternalSyntheticLambda0(), 1, null);
    }

    static final Unit selectableGroup$lambda$0(SemanticsPropertyReceiver arg0) {
        SemanticsPropertiesKt.selectableGroup(arg0);
        return Unit.INSTANCE;
    }
}

