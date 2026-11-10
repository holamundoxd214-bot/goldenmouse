package androidx.compose.runtime.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\r\u0010\t\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\f\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0014\u001A\u00020\u00072\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001A\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001A\u00020\u0019HÖ\u0081\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001A"}, d2={"Landroidx/compose/runtime/internal/AtomicBoolean;", "", "wrapped", "Landroidx/compose/runtime/internal/AtomicInt;", "constructor-impl", "(Landroidx/compose/runtime/internal/AtomicInt;)Landroidx/compose/runtime/internal/AtomicInt;", "value", "", "(Z)Landroidx/compose/runtime/internal/AtomicInt;", "get", "get-impl", "(Landroidx/compose/runtime/internal/AtomicInt;)Z", "set", "", "set-impl", "(Landroidx/compose/runtime/internal/AtomicInt;Z)V", "getAndSet", "newValue", "getAndSet-impl", "(Landroidx/compose/runtime/internal/AtomicInt;Z)Z", "equals", "other", "hashCode", "", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class AtomicBoolean {
    private final AtomicInt wrapped;

    private AtomicBoolean(AtomicInt arg1) {
        super();
        this.wrapped = arg1;
    }

    public static final AtomicBoolean box-impl(AtomicInt arg1) {
        return new AtomicBoolean(arg1);
    }

    public static AtomicInt constructor-impl(boolean arg1) {
        return AtomicBoolean.constructor-impl(new AtomicInt(((int)arg1)));
    }

    public static AtomicInt constructor-impl(AtomicInt arg0) {
        return arg0;
    }

    public static AtomicInt constructor-impl$default(AtomicInt arg0, int arg1, DefaultConstructorMarker arg2) {
        if((arg1 & 1) != 0) {
            arg0 = new AtomicInt(0);
        }

        return AtomicBoolean.constructor-impl(arg0);
    }

    public boolean equals(Object arg1) {
        return AtomicBoolean.equals-impl(this.wrapped, arg1);
    }

    public static boolean equals-impl(AtomicInt arg2, Object arg3) {
        if(!(arg3 instanceof AtomicBoolean)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((AtomicBoolean)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(AtomicInt arg0, AtomicInt arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final boolean get-impl(AtomicInt arg0) {
        if(arg0.get() != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean getAndSet-impl(AtomicInt arg1, boolean arg2) {
        return arg1.compareAndSet(1, ((int)arg2));
    }

    public int hashCode() {
        return AtomicBoolean.hashCode-impl(this.wrapped);
    }

    public static int hashCode-impl(AtomicInt arg0) {
        return arg0.hashCode();
    }

    public static final void set-impl(AtomicInt arg0, boolean arg1) {
        arg0.set(((int)arg1));
    }

    public String toString() {
        return AtomicBoolean.toString-impl(this.wrapped);
    }

    public static String toString-impl(AtomicInt arg2) {
        return "AtomicBoolean(wrapped=" + arg2 + ')';
    }

    public final AtomicInt unbox-impl() {
        return this.wrapped;
    }
}

