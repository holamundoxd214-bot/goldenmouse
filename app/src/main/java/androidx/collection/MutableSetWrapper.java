package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0016\u0010\u000B\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\u000F\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0096\u0002J\u0015\u0010\u0012\u001A\u00020\b2\u0006\u0010\t\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0016\u0010\u0013\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0016\u0010\u0014\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/collection/MutableSetWrapper;", "E", "Landroidx/collection/SetWrapper;", "", "parent", "Landroidx/collection/MutableScatterSet;", "(Landroidx/collection/MutableScatterSet;)V", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "iterator", "", "remove", "removeAll", "retainAll", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) final class MutableSetWrapper extends SetWrapper implements Set, KMutableSet {
    private final MutableScatterSet parent;

    public MutableSetWrapper(MutableScatterSet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        super(arg2);
        this.parent = arg2;
    }

    public static final MutableScatterSet access$getParent$p(MutableSetWrapper arg0) {
        return arg0.parent;
    }

    public boolean add(Object arg1) {
        return this.parent.add(arg1);
    }

    public boolean addAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return this.parent.addAll(((Iterable)arg2));
    }

    public void clear() {
        this.parent.clear();
    }

    public Iterator iterator() {
        return new MutableSetWrapper$iterator$1(this);
    }

    public boolean remove(Object arg1) {
        return this.parent.remove(arg1);
    }

    public boolean removeAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return this.parent.removeAll(((Iterable)arg2));
    }

    public boolean retainAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return this.parent.retainAll(arg2);
    }
}

