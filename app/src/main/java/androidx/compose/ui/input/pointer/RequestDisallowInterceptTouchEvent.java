package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u0002H\u0096\u0002R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u000E"}, d2={"Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "Lkotlin/Function1;", "", "", "<init>", "()V", "pointerInteropFilter", "Landroidx/compose/ui/input/pointer/PointerInteropFilter;", "getPointerInteropFilter$ui", "()Landroidx/compose/ui/input/pointer/PointerInteropFilter;", "setPointerInteropFilter$ui", "(Landroidx/compose/ui/input/pointer/PointerInteropFilter;)V", "invoke", "disallowIntercept", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RequestDisallowInterceptTouchEvent implements Function1 {
    public static final int $stable = 8;
    private PointerInteropFilter pointerInteropFilter;

    static {
    }

    public RequestDisallowInterceptTouchEvent() {
        super();
    }

    public final PointerInteropFilter getPointerInteropFilter$ui() {
        return this.pointerInteropFilter;
    }

    public Object invoke(Object arg1) {
        this.invoke(((Boolean)arg1).booleanValue());
        return Unit.INSTANCE;
    }

    public void invoke(boolean arg1) {
        PointerInteropFilter v0 = this.pointerInteropFilter;
        if(v0 != null) {
            v0.setDisallowIntercept$ui(arg1);
        }
    }

    public final void setPointerInteropFilter$ui(PointerInteropFilter arg1) {
        this.pointerInteropFilter = arg1;
    }
}

