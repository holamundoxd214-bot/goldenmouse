package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0013J\u001B\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u001C\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tH&J\u001B\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u001C\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tH&J\"\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000E0\rH&J\u001C\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tH&J\u000E\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u000E\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "addAll", "elements", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "", "retainAll", "clear", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "Builder", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface PersistentSet extends ImmutableSet, PersistentCollection {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u000E\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "E", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection$Builder;", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Builder extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder, Set, KMutableSet {
        PersistentSet build();
    }

    PersistentSet add(Object arg1);

    PersistentSet addAll(Collection arg1);

    Builder builder();

    PersistentSet clear();

    PersistentSet remove(Object arg1);

    PersistentSet removeAll(Collection arg1);

    PersistentSet removeAll(Function1 arg1);

    PersistentSet retainAll(Collection arg1);
}

