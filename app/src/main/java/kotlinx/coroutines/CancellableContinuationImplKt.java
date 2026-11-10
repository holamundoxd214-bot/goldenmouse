package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u001A\u0019\u0010\f\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u0001H\u0082\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0007\u001A\u00020\u0001*\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t\"\u0019\u0010\n\u001A\u00020\u0001*\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\t\"\u0010\u0010\r\u001A\u00020\u000E8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"UNDECIDED", "", "SUSPENDED", "RESUMED", "DECISION_SHIFT", "INDEX_MASK", "NO_INDEX", "decision", "getDecision", "(I)I", "index", "getIndex", "decisionAndIndex", "RESUME_TOKEN", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CancellableContinuationImplKt {
    private static final int DECISION_SHIFT = 29;
    private static final int INDEX_MASK = 0x1FFFFFFF;
    private static final int NO_INDEX = 0x1FFFFFFF;
    private static final int RESUMED = 2;
    public static final Symbol RESUME_TOKEN = null;
    private static final int SUSPENDED = 1;
    private static final int UNDECIDED;

    static {
        CancellableContinuationImplKt.RESUME_TOKEN = new Symbol("RESUME_TOKEN");
    }

    private static final int decisionAndIndex(int arg0, int arg1) {
        return (arg0 << 29) + arg1;
    }

    private static final int getDecision(int arg0) {
        return arg0 >> 29;
    }

    private static final int getIndex(int arg1) {
        return arg1 & 0x1FFFFFFF;
    }
}

