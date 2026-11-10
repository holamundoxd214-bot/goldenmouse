package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001A \u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¨\u0006\u0005"}, d2={"onSizeChanged", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OnRemeasuredModifierKt {
    public static final Modifier onSizeChanged(Modifier arg1, Function1 arg2) {
        return arg1.then(new OnSizeChangedModifier(arg2));
    }
}

