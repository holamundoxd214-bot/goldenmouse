package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001C\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\t"}, d2={"Lkotlinx/coroutines/flow/SharingStarted;", "", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "Companion", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface SharingStarted {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/flow/SharingStarted$Companion;", "", "<init>", "()V", "Eagerly", "Lkotlinx/coroutines/flow/SharingStarted;", "getEagerly", "()Lkotlinx/coroutines/flow/SharingStarted;", "Lazily", "getLazily", "WhileSubscribed", "stopTimeoutMillis", "", "replayExpirationMillis", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        private static final SharingStarted Eagerly;
        private static final SharingStarted Lazily;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.Eagerly = new StartedEagerly();
            Companion.Lazily = new StartedLazily();
        }

        private Companion() {
            super();
        }

        public final SharingStarted WhileSubscribed(long arg1, long arg3) {
            return new StartedWhileSubscribed(arg1, arg3);
        }

        public static SharingStarted WhileSubscribed$default(Companion arg0, long arg1, long arg3, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = 0;
            }

            if((arg5 & 2) != 0) {
                arg3 = 0x7FFFFFFFFFFFFFFFL;
            }

            return arg0.WhileSubscribed(arg1, arg3);
        }

        public final SharingStarted getEagerly() {
            return Companion.Eagerly;
        }

        public final SharingStarted getLazily() {
            return Companion.Lazily;
        }
    }

    public static final Companion Companion;

    static {
        SharingStarted.Companion = Companion.$$INSTANCE;
    }

    Flow command(StateFlow arg1);
}

