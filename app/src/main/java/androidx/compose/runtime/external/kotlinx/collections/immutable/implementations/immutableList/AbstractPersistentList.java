package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractList;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0000\b!\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016J\u001C\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J$\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000E\u001A\u00020\t2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u001B\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0011\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\u001C\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u001C\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u000E\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u0016\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0011\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001A\u00020\u00172\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u000F\u0010\u001A\u001A\b\u0012\u0004\u0012\u00028\u00000\u001BH\u0096\u0002J\u000E\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0016¨\u0006\u001E"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Lkotlin/collections/AbstractList;", "<init>", "()V", "subList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "fromIndex", "", "toIndex", "addAll", "elements", "", "index", "c", "remove", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "removeAll", "retainAll", "clear", "contains", "", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "", "listIterator", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class AbstractPersistentList extends AbstractList implements PersistentList {
    public static final int $stable = 8;

    static {
    }

    public AbstractPersistentList() {
        super();
    }

    public PersistentCollection addAll(Collection arg1) {
        return this.addAll(arg1);
    }

    public PersistentList addAll(Collection arg2) {
        Builder v1 = ((PersistentList)this).builder();
        v1.addAll(arg2);
        return v1.build();
    }

    public PersistentList addAll(int arg2, Collection arg3) {
        Builder v1 = ((PersistentList)this).builder();
        v1.addAll(arg2, arg3);
        return v1.build();
    }

    public PersistentCollection clear() {
        return this.clear();
    }

    public PersistentList clear() {
        return UtilsKt.persistentVectorOf();
    }

    public boolean contains(Object arg1) {
        if(this.indexOf(arg1) != -1) {
            return 1;
        }

        return 0;
    }

    public boolean containsAll(Collection arg3) {
        if(((arg3 instanceof Collection)) && (arg3.isEmpty())) {
            return 1;
        }

        Iterator v3 = ((Iterable)arg3).iterator();
        do {
            if(!v3.hasNext()) {
                return 1;
            }
        }
        while(this.contains(v3.next()));

        return 0;
    }

    public Iterator iterator() {
        return this.listIterator();
    }

    public ListIterator listIterator() {
        return this.listIterator(0);
    }

    public PersistentCollection remove(Object arg1) {
        return this.remove(arg1);
    }

    public PersistentList remove(Object arg2) {
        int v2 = this.indexOf(arg2);
        if(v2 != -1) {
            return this.removeAt(v2);
        }

        return this;
    }

    public PersistentCollection removeAll(Collection arg1) {
        return this.removeAll(arg1);
    }

    public PersistentList removeAll(Collection arg2) {
        return this.removeAll(new AbstractPersistentList$$ExternalSyntheticLambda1(arg2));
    }

    static final boolean removeAll$lambda$0(Collection arg0, Object arg1) {
        return arg0.contains(arg1);
    }

    public PersistentCollection retainAll(Collection arg1) {
        return this.retainAll(arg1);
    }

    public PersistentList retainAll(Collection arg2) {
        return this.removeAll(new AbstractPersistentList$$ExternalSyntheticLambda0(arg2));
    }

    static final boolean retainAll$lambda$0(Collection arg0, Object arg1) {
        return arg0.contains(arg1) ^ 1;
    }

    public ImmutableList subList(int arg1, int arg2) {
        return PersistentList.super.subList(arg1, arg2);
    }

    public List subList(int arg1, int arg2) {
        return this.subList(arg1, arg2);
    }
}

