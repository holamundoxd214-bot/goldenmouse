package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\bF\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\u000E\u001A\u00028\u0000HÆ\u0083\u0004¢\u0006\u0002\u0010\tJ\u0011\u0010\u000F\u001A\u00020\u0005HÆ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\fJ+\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001A\u00028\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0081\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0017\u001A\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001A\u00020\u001AHÖ\u0081\u0004R\u0017\u0010\u0003\u001A\u00028\u0000X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\f¨\u0006\u001B"}, d2={"Lkotlin/time/TimedValue;", "T", "", "value", "duration", "Lkotlin/time/Duration;", "<init>", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDuration-UwyO8pc", "()J", "J", "component1", "component2", "component2-UwyO8pc", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TimedValue {
    private final long duration;
    private final Object value;

    public TimedValue(Object arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    private TimedValue(Object arg1, long arg2) {
        super();
        this.value = arg1;
        this.duration = arg2;
    }

    public final Object component1() {
        return this.value;
    }

    public final long component2-UwyO8pc() {
        return this.duration;
    }

    public final TimedValue copy-RFiDyg4(Object arg2, long arg3) {
        return new TimedValue(arg2, arg3, null);
    }

    public static TimedValue copy-RFiDyg4$default(TimedValue arg0, Object arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.value;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.duration;
        }

        return arg0.copy-RFiDyg4(arg1, arg2);
    }

    public boolean equals(Object arg6) {
        if(this == (((TimedValue)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof TimedValue)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.value, ((TimedValue)arg6).value)) {
            return 0;
        }

        if(!Duration.equals-impl0(this.duration, ((TimedValue)arg6).duration)) {
            return 0;
        }

        return 1;
    }

    public final long getDuration-UwyO8pc() {
        return this.duration;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object v0 = this.value;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        return v0_1 * 0x1F + Duration.hashCode-impl(this.duration);
    }

    public String toString() {
        return "TimedValue(value=" + this.value + ", duration=" + Duration.toString-impl(this.duration) + ')';
    }
}

