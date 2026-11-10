package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001R\u001D\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t\u0088\u0001\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "", "handler", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/KeyCommand;", "", "constructor-impl", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ClipboardKeyCommandsHandler {
    private final Function1 handler;

    private ClipboardKeyCommandsHandler(Function1 arg1) {
        super();
        this.handler = arg1;
    }

    public static final ClipboardKeyCommandsHandler box-impl(Function1 arg1) {
        return new ClipboardKeyCommandsHandler(arg1);
    }

    public static Function1 constructor-impl(Function1 arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ClipboardKeyCommandsHandler.equals-impl(this.handler, arg1);
    }

    public static boolean equals-impl(Function1 arg2, Object arg3) {
        if(!(arg3 instanceof ClipboardKeyCommandsHandler)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((ClipboardKeyCommandsHandler)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Function1 arg0, Function1 arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public final Function1 getHandler() {
        return this.handler;
    }

    public int hashCode() {
        return ClipboardKeyCommandsHandler.hashCode-impl(this.handler);
    }

    public static int hashCode-impl(Function1 arg0) {
        return arg0.hashCode();
    }

    public String toString() {
        return ClipboardKeyCommandsHandler.toString-impl(this.handler);
    }

    public static String toString-impl(Function1 arg2) {
        return "ClipboardKeyCommandsHandler(handler=" + arg2 + ')';
    }

    public final Function1 unbox-impl() {
        return this.handler;
    }
}

