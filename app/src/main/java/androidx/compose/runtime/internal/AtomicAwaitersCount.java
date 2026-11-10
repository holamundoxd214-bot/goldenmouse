package androidx.compose.runtime.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0083@\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\bH\u0086\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\fH\u0086\b¢\u0006\u0004\b\r\u0010\u000EJ+\u0010\u000F\u001A\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\f0\u0012H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\u0010H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u0019\u001A\u00020\u00102\u0012\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001BH\u0082\b¢\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u001F\u001A\u00020\u0010H\u0002¢\u0006\u0004\b \u0010!J\u000F\u0010%\u001A\u00020&H\u0016¢\u0006\u0004\b\'\u0010(J\u0014\u0010)\u001A\u00020\b2\b\u0010*\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001A\u00020\u0010HÖ\u0081\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001A\u00020\u0010*\u00020\u00108Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0019\u0010\u001F\u001A\u00020\u0010*\u00020\u00108Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b$\u0010#\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006-"}, d2={"Landroidx/compose/runtime/internal/AtomicAwaitersCount;", "", "value", "Landroidx/compose/runtime/internal/AtomicInt;", "constructor-impl", "(Landroidx/compose/runtime/internal/AtomicInt;)Landroidx/compose/runtime/internal/AtomicInt;", "()Landroidx/compose/runtime/internal/AtomicInt;", "hasAwaiters", "", "hasAwaiters-impl", "(Landroidx/compose/runtime/internal/AtomicInt;)Z", "incrementVersionAndResetCount", "", "incrementVersionAndResetCount-impl", "(Landroidx/compose/runtime/internal/AtomicInt;)V", "incrementCountAndGetVersion", "", "ifFirstAwaiter", "Lkotlin/Function0;", "incrementCountAndGetVersion-impl", "(Landroidx/compose/runtime/internal/AtomicInt;Lkotlin/jvm/functions/Function0;)I", "decrementCount", "version", "decrementCount-impl", "(Landroidx/compose/runtime/internal/AtomicInt;I)V", "update", "calculation", "Lkotlin/Function1;", "update-impl", "(Landroidx/compose/runtime/internal/AtomicInt;Lkotlin/jvm/functions/Function1;)I", "pack", "count", "pack-impl", "(Landroidx/compose/runtime/internal/AtomicInt;II)I", "getVersion-impl", "(Landroidx/compose/runtime/internal/AtomicInt;I)I", "getCount-impl", "toString", "", "toString-impl", "(Landroidx/compose/runtime/internal/AtomicInt;)Ljava/lang/String;", "equals", "other", "hashCode", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline final class AtomicAwaitersCount {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/compose/runtime/internal/AtomicAwaitersCount$Companion;", "", "<init>", "()V", "VERSION_BITS", "", "COUNT_BITS", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    private static final int COUNT_BITS = 27;
    public static final Companion Companion = null;
    private static final int VERSION_BITS = 4;
    private final AtomicInt value;

    static {
        AtomicAwaitersCount.Companion = new Companion(null);
    }

    private AtomicAwaitersCount(AtomicInt arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$pack-impl(AtomicInt arg0, int arg1, int arg2) {
        return AtomicAwaitersCount.pack-impl(arg0, arg1, arg2);
    }

    public static final AtomicAwaitersCount box-impl(AtomicInt arg1) {
        return new AtomicAwaitersCount(arg1);
    }

    public static AtomicInt constructor-impl() {
        return AtomicAwaitersCount.constructor-impl(new AtomicInt(0));
    }

    private static AtomicInt constructor-impl(AtomicInt arg0) {
        return arg0;
    }

    public static final void decrementCount-impl(AtomicInt arg2, int arg3) {
        do {
            int v0 = arg2.get();
            int v1 = (v0 >>> 27 & 15) == arg3 ? v0 - 1 : v0;
        }
        while(!arg2.compareAndSet(v0, v1));
    }

    public boolean equals(Object arg1) {
        return AtomicAwaitersCount.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(AtomicInt arg2, Object arg3) {
        if(!(arg3 instanceof AtomicAwaitersCount)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((AtomicAwaitersCount)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(AtomicInt arg0, AtomicInt arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    private static final int getCount-impl(AtomicInt arg0, int arg1) {
        return 0x7FFFFFF & arg1;
    }

    private static final int getVersion-impl(AtomicInt arg0, int arg1) {
        return arg1 >>> 27 & 15;
    }

    public static final boolean hasAwaiters-impl(AtomicInt arg1) {
        if((arg1.get() & 0x7FFFFFF) > 0) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return AtomicAwaitersCount.hashCode-impl(this.value);
    }

    public static int hashCode-impl(AtomicInt arg0) {
        return arg0.hashCode();
    }

    public static final int incrementCountAndGetVersion-impl(AtomicInt arg2, Function0 arg3) {
        int v1;
        do {
            int v0 = arg2.get();
            v1 = v0 + 1;
        }
        while(!arg2.compareAndSet(v0, v1));

        if((0x7FFFFFF & v1) == 1) {
            arg3.invoke();
        }

        return v1 >>> 27 & 15;
    }

    public static final void incrementVersionAndResetCount-impl(AtomicInt arg3) {
        do {
            int v0 = arg3.get();
        }
        while(!arg3.compareAndSet(v0, AtomicAwaitersCount.pack-impl(arg3, (v0 >>> 27 & 15) + 1, 0)));
    }

    private static final int pack-impl(AtomicInt arg0, int arg1, int arg2) {
        return (arg1 & 15) << 27 | 0x7FFFFFF & arg2;
    }

    public String toString() {
        return AtomicAwaitersCount.toString-impl(this.value);
    }

    public static String toString-impl(AtomicInt arg2) {
        int v2 = arg2.get();
        return "AtomicAwaitersCount(version = " + (v2 >>> 27 & 15) + ", count = " + (v2 & 0x7FFFFFF) + ')';
    }

    public final AtomicInt unbox-impl() {
        return this.value;
    }

    private static final int update-impl(AtomicInt arg2, Function1 arg3) {
        int v1;
        do {
            int v0 = arg2.get();
            v1 = arg3.invoke(Integer.valueOf(v0)).intValue();
        }
        while(!arg2.compareAndSet(v0, v1));

        return v1;
    }
}

