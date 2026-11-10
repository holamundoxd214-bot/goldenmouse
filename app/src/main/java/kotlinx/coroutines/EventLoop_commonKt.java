package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0007H\u0000\u001A\u0010\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u0007H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\u001E\b\u0002\u0010\u000F\u001A\u0004\b\u0000\u0010\u0010\"\b\u0012\u0004\u0012\u0002H\u00100\u00112\b\u0012\u0004\u0012\u0002H\u00100\u0011¨\u0006\u0012"}, d2={"DISPOSED_TASK", "Lkotlinx/coroutines/internal/Symbol;", "SCHEDULE_OK", "", "SCHEDULE_COMPLETED", "SCHEDULE_DISPOSED", "MS_TO_NS", "", "MAX_MS", "MAX_DELAY_NS", "delayToNanos", "timeMillis", "delayNanosToMillis", "timeNanos", "CLOSED_EMPTY", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class EventLoop_commonKt {
    private static final Symbol CLOSED_EMPTY = null;
    private static final Symbol DISPOSED_TASK = null;
    private static final long MAX_DELAY_NS = 0x3FFFFFFFFFFFFFFFL;
    private static final long MAX_MS = 0x8637BD05AF6L;
    private static final long MS_TO_NS = 1000000;
    private static final int SCHEDULE_COMPLETED = 1;
    private static final int SCHEDULE_DISPOSED = 2;
    private static final int SCHEDULE_OK;

    static {
        EventLoop_commonKt.DISPOSED_TASK = new Symbol("REMOVED_TASK");
        EventLoop_commonKt.CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");
    }

    public static final Symbol access$getCLOSED_EMPTY$p() {
        return EventLoop_commonKt.CLOSED_EMPTY;
    }

    public static final Symbol access$getDISPOSED_TASK$p() {
        return EventLoop_commonKt.DISPOSED_TASK;
    }

    public static final long delayNanosToMillis(long arg2) {
        return arg2 / 1000000;
    }

    public static final long delayToNanos(long arg3) {
        long v0 = 0;
        if(arg3 <= v0) {
            return v0;
        }

        if(arg3 >= 0x8637BD05AF6L) {
            return 0x7FFFFFFFFFFFFFFFL;
        }

        return arg3 * 1000000;
    }
}

