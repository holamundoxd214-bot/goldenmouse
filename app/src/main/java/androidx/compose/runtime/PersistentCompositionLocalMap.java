package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u001E\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u00052\u00020\u0006:\u0001\u0010J(\u0010\u0007\u001A\u00020\u00002\u000E\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000E\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004H&J\b\u0010\u000E\u001A\u00020\u000FH&R$\u0010\n\u001A\u0002H\u000B\"\u0004\b\u0000\u0010\u000B*\b\u0012\u0004\u0012\u0002H\u000B0\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2={"Landroidx/compose/runtime/PersistentCompositionLocalMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "Landroidx/compose/runtime/CompositionLocalMap;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "putValue", "key", "value", "currentValue", "T", "getCurrentValue", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/PersistentCompositionLocalMap$Builder;", "Builder", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface PersistentCompositionLocalMap extends CompositionLocalAccessorScope, CompositionLocalMap, PersistentMap {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u001E\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u0001J\b\u0010\u0005\u001A\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/runtime/PersistentCompositionLocalMap$Builder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "build", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Builder extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder {
        PersistentCompositionLocalMap build();
    }

    Builder builder();

    default Object getCurrentValue(CompositionLocal arg1) {
        return CompositionLocalMapKt.read(this, arg1);
    }

    PersistentCompositionLocalMap putValue(CompositionLocal arg1, ValueHolder arg2);
}

