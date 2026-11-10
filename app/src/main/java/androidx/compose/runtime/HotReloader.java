package androidx.compose.runtime;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2={"Landroidx/compose/runtime/HotReloader;", "", "<init>", "()V", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class HotReloader {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0002J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0001H\u0002J\u0015\u0010\t\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u0001H\u0001¢\u0006\u0002\b\nJ\u0010\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0001J\u000E\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FH\u0001J\u000E\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\u000FH\u0001J\b\u0010\u0013\u001A\u00020\u0007H\u0001¨\u0006\u0014"}, d2={"Landroidx/compose/runtime/HotReloader$Companion;", "", "<init>", "()V", "saveStateAndDispose", "context", "loadStateAndCompose", "", "token", "simulateHotReload", "simulateHotReload$runtime", "invalidateGroupsWithKey", "key", "", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getRecomposerErrors", "Landroidx/compose/runtime/RecomposerErrorInformation;", "clearErrors", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final void clearErrors() {
            Recomposer.Companion.clearErrors$runtime();
        }

        @Deprecated(message="`getCurrentErrors` only exists for backwards compatibility. Use `getRecomposerErrors` instead", replaceWith="<_subannotation>") public final List getCurrentErrors() {
            return Recomposer.Companion.getCurrentErrors$runtime();
        }

        public final List getRecomposerErrors() {
            return Recomposer.Companion.getRecomposerErrors$runtime();
        }

        public final void invalidateGroupsWithKey(int arg1) {
            Recomposer.Companion.invalidateGroupsWithKey$runtime(arg1);
        }

        private final void loadStateAndCompose(Object arg1) {
            Recomposer.Companion.loadStateAndComposeForHotReload$runtime(arg1);
        }

        private final Object saveStateAndDispose(Object arg1) {
            return Recomposer.Companion.saveStateAndDisposeForHotReload$runtime();
        }

        public final void simulateHotReload$runtime(Object arg1) {
            this.loadStateAndCompose(this.saveStateAndDispose(arg1));
        }
    }

    public static final Companion Companion;

    static {
        HotReloader.Companion = new Companion(null);
    }

    public HotReloader() {
        super();
    }
}

