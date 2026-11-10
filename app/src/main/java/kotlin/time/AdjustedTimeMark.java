package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0002\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\f\u001A\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\nJ\u0019\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0004H\u0096\u0082\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0002\u001A\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001A\u00020\u0004X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\n¨\u0006\u0012"}, d2={"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "mark", "adjustment", "Lkotlin/time/Duration;", "<init>", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMark", "()Lkotlin/time/TimeMark;", "getAdjustment-UwyO8pc", "()J", "J", "elapsedNow", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class AdjustedTimeMark implements TimeMark {
    private final long adjustment;
    private final TimeMark mark;

    public AdjustedTimeMark(TimeMark arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    private AdjustedTimeMark(TimeMark arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "mark");
        super();
        this.mark = arg2;
        this.adjustment = arg3;
    }

    public long elapsedNow-UwyO8pc() {
        return Duration.minus-LRDsOJo(this.mark.elapsedNow-UwyO8pc(), this.adjustment);
    }

    public final long getAdjustment-UwyO8pc() {
        return this.adjustment;
    }

    public final TimeMark getMark() {
        return this.mark;
    }

    public boolean hasNotPassedNow() {
        return DefaultImpls.hasNotPassedNow(((TimeMark)this));
    }

    public boolean hasPassedNow() {
        return DefaultImpls.hasPassedNow(((TimeMark)this));
    }

    public TimeMark minus-LRDsOJo(long arg1) {
        return DefaultImpls.minus-LRDsOJo(((TimeMark)this), arg1);
    }

    public TimeMark plus-LRDsOJo(long arg5) {
        return new AdjustedTimeMark(this.mark, Duration.plus-LRDsOJo(this.adjustment, arg5), null);
    }
}

