package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0011\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0010\u001A\u00020\b2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00028\u00008F¢\u0006\f\u0012\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0003¨\u0006\u0016"}, d2={"Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "segment", "getSegment$annotations", "()V", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "equals", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class SegmentOrClosed {
    private final Object value;

    private SegmentOrClosed(Object arg1) {
        super();
        this.value = arg1;
    }

    public static final SegmentOrClosed box-impl(Object arg1) {
        return new SegmentOrClosed(arg1);
    }

    public static Object constructor-impl(Object arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return SegmentOrClosed.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(Object arg2, Object arg3) {
        if(!(arg3 instanceof SegmentOrClosed)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((SegmentOrClosed)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Object arg0, Object arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static void getSegment$annotations() {
    }

    public static final Segment getSegment-impl(Object arg1) {
        if(arg1 != ConcurrentLinkedListKt.CLOSED) {
            Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return arg1;
        }

        throw new IllegalStateException("Does not contain segment".toString());
    }

    public int hashCode() {
        return SegmentOrClosed.hashCode-impl(this.value);
    }

    public static int hashCode-impl(Object arg0) {
        if(arg0 == null) {
            return 0;
        }

        return arg0.hashCode();
    }

    public static final boolean isClosed-impl(Object arg1) {
        if(arg1 == ConcurrentLinkedListKt.CLOSED) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return SegmentOrClosed.toString-impl(this.value);
    }

    public static String toString-impl(Object arg2) {
        return "SegmentOrClosed(value=" + arg2 + ')';
    }

    public final Object unbox-impl() {
        return this.value;
    }
}

