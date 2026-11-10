package androidx.compose.runtime;

import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\"\u0010\u0002\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0005H¦\u0002¢\u0006\u0002\u0010\u0006\u0082\u0001\u0001\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2={"Landroidx/compose/runtime/CompositionLocalMap;", "", "get", "T", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "Companion", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface CompositionLocalMap {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/runtime/CompositionLocalMap$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/runtime/CompositionLocalMap;", "getEmpty", "()Landroidx/compose/runtime/CompositionLocalMap;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        private static final CompositionLocalMap Empty;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.Empty = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        }

        private Companion() {
            super();
        }

        public final CompositionLocalMap getEmpty() {
            return Companion.Empty;
        }
    }

    public static final Companion Companion;

    static {
        CompositionLocalMap.Companion = Companion.$$INSTANCE;
    }

    Object get(CompositionLocal arg1);
}

