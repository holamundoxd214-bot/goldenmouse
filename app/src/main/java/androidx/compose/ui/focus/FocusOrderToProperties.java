package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B \u0012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\rH\u0016R\"\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000E"}, d2={"Landroidx/compose/ui/focus/FocusOrderToProperties;", "Landroidx/compose/ui/focus/FocusPropertiesScope;", "focusOrderReceiver", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusOrder;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getFocusOrderReceiver", "()Lkotlin/jvm/functions/Function1;", "apply", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusOrderToProperties implements FocusPropertiesScope {
    public static final int $stable;
    private final Function1 focusOrderReceiver;

    static {
    }

    public FocusOrderToProperties(Function1 arg1) {
        super();
        this.focusOrderReceiver = arg1;
    }

    public void apply(FocusProperties arg2) {
        this.focusOrderReceiver.invoke(new FocusOrder(arg2));
    }

    public final Function1 getFocusOrderReceiver() {
        return this.focusOrderReceiver;
    }
}

