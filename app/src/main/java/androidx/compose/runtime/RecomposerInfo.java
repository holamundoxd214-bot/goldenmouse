package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.CompositionRegistrationObserver;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AJ\u0012\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0017R\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0012\u0010\u000B\u001A\u00020\fX¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\"\u0010\u000F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00108VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001BÀ\u0006\u0001"}, d2={"Landroidx/compose/runtime/RecomposerInfo;", "", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "hasPendingWork", "", "getHasPendingWork", "()Z", "changeCount", "", "getChangeCount", "()J", "errorState", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/compose/runtime/RecomposerErrorInformation;", "getErrorState$annotations", "()V", "getErrorState", "()Lkotlinx/coroutines/flow/StateFlow;", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface RecomposerInfo {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2={"Landroidx/compose/runtime/RecomposerInfo$Companion;", "", "<init>", "()V", "DefaultErrorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/compose/runtime/RecomposerErrorInformation;", "getDefaultErrorStateFlow$annotations", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class Companion {
        private static final StateFlow DefaultErrorStateFlow;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.DefaultErrorStateFlow = StateFlowKt.MutableStateFlow(null);
        }

        private Companion() {
            super();
        }

        public static final StateFlow access$getDefaultErrorStateFlow$p() {
            return Companion.DefaultErrorStateFlow;
        }

        private static void getDefaultErrorStateFlow$annotations() {
        }
    }

    static {
        RecomposerInfo.Companion = Companion.$$INSTANCE;
    }

    long getChangeCount();

    default StateFlow getErrorState() {
        return Companion.access$getDefaultErrorStateFlow$p();
    }

    static void getErrorState$annotations() {
    }

    boolean getHasPendingWork();

    Flow getState();

    default CompositionObserverHandle observe(CompositionRegistrationObserver arg1) {
        return null;
    }
}

