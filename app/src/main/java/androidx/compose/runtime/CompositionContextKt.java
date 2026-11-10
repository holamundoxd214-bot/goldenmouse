package androidx.compose.runtime;

import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2={"EmptyPersistentCompositionLocalMap", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CompositionContextKt {
    private static final PersistentCompositionLocalMap EmptyPersistentCompositionLocalMap;

    static {
        CompositionContextKt.EmptyPersistentCompositionLocalMap = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    }

    public static final PersistentCompositionLocalMap access$getEmptyPersistentCompositionLocalMap$p() {
        return CompositionContextKt.EmptyPersistentCompositionLocalMap;
    }
}

