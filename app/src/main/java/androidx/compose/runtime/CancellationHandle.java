package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2={"Landroidx/compose/runtime/CancellationHandle;", "", "cancel", "", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface CancellationHandle {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/runtime/CancellationHandle$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/runtime/CancellationHandle;", "getEmpty$runtime", "()Landroidx/compose/runtime/CancellationHandle;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        private static final CancellationHandle Empty;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.Empty = new CancellationHandle$Companion$$ExternalSyntheticLambda0();
        }

        private Companion() {
            super();
        }

        static final void Empty$lambda$0() {
        }

        public final CancellationHandle getEmpty$runtime() {
            return Companion.Empty;
        }
    }

    public static final Companion Companion;

    static {
        CancellationHandle.Companion = Companion.$$INSTANCE;
    }

    void cancel();
}

