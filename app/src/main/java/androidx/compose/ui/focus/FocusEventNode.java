package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001B\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0003\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u0005H\u0016R&\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\b¨\u0006\r"}, d2={"Landroidx/compose/ui/focus/FocusEventNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onFocusEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnFocusEvent", "()Lkotlin/jvm/functions/Function1;", "setOnFocusEvent", "focusState", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusEventNode extends Node implements FocusEventModifierNode {
    private Function1 onFocusEvent;

    public FocusEventNode(Function1 arg1) {
        super();
        this.onFocusEvent = arg1;
    }

    public final Function1 getOnFocusEvent() {
        return this.onFocusEvent;
    }

    public void onFocusEvent(FocusState arg1) {
        this.onFocusEvent.invoke(arg1);
    }

    public final void setOnFocusEvent(Function1 arg1) {
        this.onFocusEvent = arg1;
    }
}

