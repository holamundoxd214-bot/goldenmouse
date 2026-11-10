package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0000\u001A\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0000\"\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001A\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0011\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"boxIncomplete", "", "unboxState", "COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_WAITING_CHILDREN", "COMPLETING_RETRY", "TOO_LATE_TO_CANCEL", "RETRY", "", "FALSE", "TRUE", "SEALED", "EMPTY_NEW", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE", "LIST_ON_COMPLETION_PERMISSION", "LIST_CHILD_PERMISSION", "LIST_CANCELLATION_PERMISSION", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class JobSupportKt {
    private static final Symbol COMPLETING_ALREADY = null;
    private static final Symbol COMPLETING_RETRY = null;
    public static final Symbol COMPLETING_WAITING_CHILDREN = null;
    private static final Empty EMPTY_ACTIVE = null;
    private static final Empty EMPTY_NEW = null;
    private static final int FALSE = 0;
    private static final int LIST_CANCELLATION_PERMISSION = 4;
    private static final int LIST_CHILD_PERMISSION = 2;
    private static final int LIST_ON_COMPLETION_PERMISSION = 1;
    private static final int RETRY = -1;
    private static final Symbol SEALED = null;
    private static final Symbol TOO_LATE_TO_CANCEL = null;
    private static final int TRUE = 1;

    static {
        JobSupportKt.COMPLETING_ALREADY = new Symbol("COMPLETING_ALREADY");
        JobSupportKt.COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");
        JobSupportKt.COMPLETING_RETRY = new Symbol("COMPLETING_RETRY");
        JobSupportKt.TOO_LATE_TO_CANCEL = new Symbol("TOO_LATE_TO_CANCEL");
        JobSupportKt.SEALED = new Symbol("SEALED");
        JobSupportKt.EMPTY_NEW = new Empty(false);
        JobSupportKt.EMPTY_ACTIVE = new Empty(true);
    }

    public static final Symbol access$getCOMPLETING_ALREADY$p() {
        return JobSupportKt.COMPLETING_ALREADY;
    }

    public static final Symbol access$getCOMPLETING_RETRY$p() {
        return JobSupportKt.COMPLETING_RETRY;
    }

    public static final Empty access$getEMPTY_ACTIVE$p() {
        return JobSupportKt.EMPTY_ACTIVE;
    }

    public static final Empty access$getEMPTY_NEW$p() {
        return JobSupportKt.EMPTY_NEW;
    }

    public static final Symbol access$getSEALED$p() {
        return JobSupportKt.SEALED;
    }

    public static final Symbol access$getTOO_LATE_TO_CANCEL$p() {
        return JobSupportKt.TOO_LATE_TO_CANCEL;
    }

    public static final Object boxIncomplete(Object arg1) {
        if((arg1 instanceof Incomplete)) {
            return new IncompleteStateBox(((Incomplete)arg1));
        }

        return arg1;
    }

    public static final Object unboxState(Object arg1) {
        Object v0 = (arg1 instanceof IncompleteStateBox) ? arg1 : null;
        if(v0 != null) {
            Incomplete v0_1 = ((IncompleteStateBox)v0).state;
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return arg1;
    }
}

