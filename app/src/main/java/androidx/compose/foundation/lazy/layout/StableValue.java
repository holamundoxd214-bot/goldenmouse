package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0083@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\f\u001A\u00020\rHÖ\u0001J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001R\u0013\u0010\u0003\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0003¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/lazy/layout/StableValue;", "T", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline final class StableValue {
    private final Object value;

    private StableValue(Object arg1) {
        super();
        this.value = arg1;
    }

    public static final StableValue box-impl(Object arg1) {
        return new StableValue(arg1);
    }

    public static Object constructor-impl(Object arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return StableValue.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(Object arg2, Object arg3) {
        if(!(arg3 instanceof StableValue)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((StableValue)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Object arg0, Object arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return StableValue.hashCode-impl(this.value);
    }

    public static int hashCode-impl(Object arg0) {
        if(arg0 == null) {
            return 0;
        }

        return arg0.hashCode();
    }

    public String toString() {
        return StableValue.toString-impl(this.value);
    }

    public static String toString-impl(Object arg2) {
        return "StableValue(value=" + arg2 + ')';
    }

    public final Object unbox-impl() {
        return this.value;
    }
}

