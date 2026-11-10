package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\b!\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0002*\u0004\b\u0001\u0010\u0003*\u0004\b\u0002\u0010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000BJ\u001C\u0010\f\u001A\u00020\t2\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0002H&J\u0013\u0010\r\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u0000¢\u0006\u0002\u0010\u000BJ\u001C\u0010\u000E\u001A\u00020\t2\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0002H&¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/AbstractMapBuilderEntries;", "E", "", "K", "V", "Lkotlin/collections/AbstractMutableSet;", "<init>", "()V", "contains", "", "element", "(Ljava/util/Map$Entry;)Z", "containsEntry", "remove", "removeEntry", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class AbstractMapBuilderEntries extends AbstractMutableSet {
    public static final int $stable = 8;

    static {
    }

    public AbstractMapBuilderEntries() {
        super();
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof Map$Entry)) {
            return 0;
        }

        return this.contains(((Map$Entry)arg2));
    }

    public final boolean contains(Map$Entry arg2) {
        Map$Entry v0 = (arg2 instanceof Object) ? arg2 : null;
        if(!(v0 instanceof Map$Entry)) {
            return 0;
        }

        return this.containsEntry(arg2);
    }

    public abstract boolean containsEntry(Map$Entry arg1);

    public final boolean remove(Object arg2) {
        if(!(arg2 instanceof Map$Entry)) {
            return 0;
        }

        return this.remove(((Map$Entry)arg2));
    }

    public final boolean remove(Map$Entry arg2) {
        Map$Entry v0 = (arg2 instanceof Object) ? arg2 : null;
        if(!(v0 instanceof Map$Entry)) {
            return 0;
        }

        return this.removeEntry(arg2);
    }

    public abstract boolean removeEntry(Map$Entry arg1);
}

