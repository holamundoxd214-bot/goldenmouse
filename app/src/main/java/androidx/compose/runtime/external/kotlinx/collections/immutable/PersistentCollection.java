package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableCollection;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0012J\u001B\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0005J\u001C\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\bH&J\u001B\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0005J\u001C\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\bH&J\"\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH&J\u001C\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\bH&J\u000E\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u000E\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "addAll", "elements", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "", "retainAll", "clear", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection$Builder;", "Builder", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface PersistentCollection extends ImmutableCollection {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001F\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000E\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection$Builder;", "E", "", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Builder extends Collection, KMutableCollection {
        PersistentCollection build();
    }

    PersistentCollection add(Object arg1);

    PersistentCollection addAll(Collection arg1);

    Builder builder();

    PersistentCollection clear();

    PersistentCollection remove(Object arg1);

    PersistentCollection removeAll(Collection arg1);

    PersistentCollection removeAll(Function1 arg1);

    PersistentCollection retainAll(Collection arg1);
}

