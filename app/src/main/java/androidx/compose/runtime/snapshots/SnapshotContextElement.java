package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "Key", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface SnapshotContextElement extends Element {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        public static Object fold(SnapshotContextElement arg0, Object arg1, Function2 arg2) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.fold(((Element)arg0), arg1, arg2);
        }

        public static Element get(SnapshotContextElement arg0, Key arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.get(((Element)arg0), arg1);
        }

        public static CoroutineContext minusKey(SnapshotContextElement arg0, Key arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.minusKey(((Element)arg0), arg1);
        }

        public static CoroutineContext plus(SnapshotContextElement arg0, CoroutineContext arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.plus(((Element)arg0), arg1);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotContextElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "<init>", "()V", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.compose.runtime.snapshots.SnapshotContextElement$Key implements Key {
        static {
            androidx.compose.runtime.snapshots.SnapshotContextElement$Key.$$INSTANCE = new androidx.compose.runtime.snapshots.SnapshotContextElement$Key();
        }

        private androidx.compose.runtime.snapshots.SnapshotContextElement$Key() {
            super();
        }
    }

    public static final androidx.compose.runtime.snapshots.SnapshotContextElement$Key Key;

    static {
        SnapshotContextElement.Key = androidx.compose.runtime.snapshots.SnapshotContextElement$Key.$$INSTANCE;
    }
}

