package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001C\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\fH\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", "", "replayExpiration", "<init>", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "toString", "", "equals", "", "other", "", "hashCode", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class StartedWhileSubscribed implements SharingStarted {
    private final long replayExpiration;
    private final long stopTimeout;

    public StartedWhileSubscribed(long arg4, long arg6) {
        super();
        this.stopTimeout = arg4;
        this.replayExpiration = arg6;
        long v0 = 0;
        String v2 = " ms) cannot be negative";
        if(Long.compare(arg4, v0) >= 0) {
            if(arg6 >= v0) {
                return;
            }

            throw new IllegalArgumentException("replayExpiration(" + arg6 + v2.toString());
        }

        throw new IllegalArgumentException("stopTimeout(" + arg4 + v2.toString());
    }

    public static final long access$getReplayExpiration$p(StartedWhileSubscribed arg2) {
        return arg2.replayExpiration;
    }

    public static final long access$getStopTimeout$p(StartedWhileSubscribed arg2) {
        return arg2.stopTimeout;
    }

    public Flow command(StateFlow arg3) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(((Flow)arg3), new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(Object arg5) {
        if(((arg5 instanceof StartedWhileSubscribed)) && this.stopTimeout == ((StartedWhileSubscribed)arg5).stopTimeout && this.replayExpiration == ((StartedWhileSubscribed)arg5).replayExpiration) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return Long.hashCode(this.stopTimeout) * 0x1F + Long.hashCode(this.replayExpiration);
    }

    public String toString() {
        List v0 = CollectionsKt.createListBuilder(2);
        String v2 = "ms";
        if(Long.compare(this.stopTimeout, 0) > 0) {
            v0.add("stopTimeout=" + this.stopTimeout + v2);
        }

        if(this.replayExpiration < 0x7FFFFFFFFFFFFFFFL) {
            v0.add("replayExpiration=" + this.replayExpiration + v2);
        }

        return "SharingStarted.WhileSubscribed(" + CollectionsKt.joinToString$default(CollectionsKt.build(v0), null, null, null, 0, null, null, 0x3F, null) + ')';
    }
}

