package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.time.Duration;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A%\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"WhileSubscribed", "Lkotlinx/coroutines/flow/SharingStarted;", "Lkotlinx/coroutines/flow/SharingStarted$Companion;", "stopTimeout", "Lkotlin/time/Duration;", "replayExpiration", "WhileSubscribed-5qebJ5I", "(Lkotlinx/coroutines/flow/SharingStarted$Companion;JJ)Lkotlinx/coroutines/flow/SharingStarted;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SharingStartedKt {
    public static final SharingStarted WhileSubscribed-5qebJ5I(Companion arg0, long arg1, long arg3) {
        return new StartedWhileSubscribed(Duration.getInWholeMilliseconds-impl(arg1), Duration.getInWholeMilliseconds-impl(arg3));
    }

    public static SharingStarted WhileSubscribed-5qebJ5I$default(Companion arg0, long arg1, long arg3, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = Duration.Companion.getZERO-UwyO8pc();
        }

        if((arg5 & 2) != 0) {
            arg3 = Duration.Companion.getINFINITE-UwyO8pc();
        }

        return SharingStartedKt.WhileSubscribed-5qebJ5I(arg0, arg1, arg3);
    }
}

