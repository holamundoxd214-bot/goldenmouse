package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR(\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\f\u001A\u0004\u0018\u00010\r@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\u00020\u0007X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\u0019X\u0096\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u001A\u0010\u0003\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2={"Landroidx/compose/ui/input/pointer/PointerInteropFilter;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "<init>", "()V", "onTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "", "getOnTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setOnTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "value", "Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "requestDisallowInterceptTouchEvent", "getRequestDisallowInterceptTouchEvent", "()Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "setRequestDisallowInterceptTouchEvent", "(Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;)V", "disallowIntercept", "getDisallowIntercept$ui", "()Z", "setDisallowIntercept$ui", "(Z)V", "pointerInputFilter", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getPointerInputFilter$annotations", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "DispatchToViewState", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PointerInteropFilter implements PointerInputModifier {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "", "<init>", "(Ljava/lang/String;I)V", "Unknown", "Dispatching", "NotDispatching", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) enum DispatchToViewState {
        public static final enum DispatchToViewState Dispatching;
        public static final enum DispatchToViewState NotDispatching;
        public static final enum DispatchToViewState Unknown;

        private static final DispatchToViewState[] $values() {
            return new DispatchToViewState[]{DispatchToViewState.Unknown, DispatchToViewState.Dispatching, DispatchToViewState.NotDispatching};
        }

        static {
            DispatchToViewState.Unknown = new DispatchToViewState("Unknown", 0);
            DispatchToViewState.Dispatching = new DispatchToViewState("Dispatching", 1);
            DispatchToViewState.NotDispatching = new DispatchToViewState("NotDispatching", 2);
            DispatchToViewState[] v0 = DispatchToViewState.$values();
            DispatchToViewState.$VALUES = v0;
            DispatchToViewState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private DispatchToViewState(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return DispatchToViewState.$ENTRIES;
        }

        public static DispatchToViewState valueOf(String arg1) {
            return Enum.valueOf(DispatchToViewState.class, arg1);
        }

        public static DispatchToViewState[] values() {
            return DispatchToViewState.$VALUES.clone();
        }
    }

    public static final int $stable;
    private boolean disallowIntercept;
    public Function1 onTouchEvent;
    private final PointerInputFilter pointerInputFilter;
    private RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent;

    static {
    }

    public PointerInteropFilter() {
        super();
        this.pointerInputFilter = new PointerInteropFilter$pointerInputFilter$1(this);
    }

    public final boolean getDisallowIntercept$ui() {
        return this.disallowIntercept;
    }

    public final Function1 getOnTouchEvent() {
        Function1 v0 = this.onTouchEvent;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("onTouchEvent");
        return null;
    }

    public PointerInputFilter getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    public static void getPointerInputFilter$annotations() {
    }

    public final RequestDisallowInterceptTouchEvent getRequestDisallowInterceptTouchEvent() {
        return this.requestDisallowInterceptTouchEvent;
    }

    public final void setDisallowIntercept$ui(boolean arg1) {
        this.disallowIntercept = arg1;
    }

    public final void setOnTouchEvent(Function1 arg1) {
        this.onTouchEvent = arg1;
    }

    public final void setRequestDisallowInterceptTouchEvent(RequestDisallowInterceptTouchEvent arg3) {
        RequestDisallowInterceptTouchEvent v0 = this.requestDisallowInterceptTouchEvent;
        if(v0 != null) {
            v0.setPointerInteropFilter$ui(null);
        }

        this.requestDisallowInterceptTouchEvent = arg3;
        if(arg3 != null) {
            arg3.setPointerInteropFilter$ui(this);
        }
    }
}

