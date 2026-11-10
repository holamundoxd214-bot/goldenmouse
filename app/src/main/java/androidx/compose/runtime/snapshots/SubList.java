package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\t\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001A\u00020\u00132\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0019\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001BJ\u0015\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001DJ\b\u0010\u001E\u001A\u00020\u0013H\u0016J\u000F\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000 H\u0096\u0002J\u0015\u0010!\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001DJ\u0015\u0010\"\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u001D\u0010\"\u001A\u00020#2\u0006\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010$J\u001E\u0010%\u001A\u00020\u00132\u0006\u0010\u001A\u001A\u00020\u00062\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010%\u001A\u00020\u00132\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\b\u0010&\u001A\u00020#H\u0016J\u000E\u0010\'\u001A\b\u0012\u0004\u0012\u00028\u00000(H\u0016J\u0016\u0010\'\u001A\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010\u001A\u001A\u00020\u0006H\u0016J\u0015\u0010)\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u0016\u0010*\u001A\u00020\u00132\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0015\u0010+\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00020\u0006H\u0016¢\u0006\u0002\u0010\u001BJ\u0016\u0010,\u001A\u00020\u00132\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u001E\u0010-\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010.J\u001E\u0010/\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0016J\b\u00100\u001A\u00020#H\u0002R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\f\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0006@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u00061"}, d2={"Landroidx/compose/runtime/snapshots/SubList;", "T", "", "parentList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "fromIndex", "", "toIndex", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;II)V", "getParentList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "offset", "structure", "value", "size", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "validateModification", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SubList implements List, KMutableList {
    public static final int $stable = 8;
    private final int offset;
    private final SnapshotStateList parentList;
    private int size;
    private int structure;

    static {
    }

    public SubList(SnapshotStateList arg1, int arg2, int arg3) {
        super();
        this.parentList = arg1;
        this.offset = arg2;
        this.structure = SnapshotStateListKt.getStructure(arg1);
        this.size = arg3 - arg2;
    }

    public void add(int arg3, Object arg4) {
        this.validateModification();
        this.parentList.add(this.offset + arg3, arg4);
        this.size = this.size() + 1;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
    }

    public boolean add(Object arg4) {
        this.validateModification();
        this.parentList.add(this.offset + this.size(), arg4);
        this.size = this.size() + 1;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        return 1;
    }

    public boolean addAll(int arg3, Collection arg4) {
        this.validateModification();
        boolean v3 = this.parentList.addAll(arg3 + this.offset, arg4);
        if(v3) {
            this.size = this.size() + arg4.size();
            this.structure = SnapshotStateListKt.getStructure(this.parentList);
        }

        return v3;
    }

    public boolean addAll(Collection arg2) {
        return this.addAll(this.size(), arg2);
    }

    public void clear() {
        if(this.size() > 0) {
            this.validateModification();
            this.parentList.removeRange(this.offset, this.size() + this.offset);
            this.size = 0;
            this.structure = SnapshotStateListKt.getStructure(this.parentList);
        }
    }

    public boolean contains(Object arg1) {
        if(this.indexOf(arg1) >= 0) {
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

    public Object get(int arg2) {
        this.validateModification();
        SnapshotStateListKt.validateRange(arg2, this.size());
        return this.parentList.get(this.offset + arg2);
    }

    public final SnapshotStateList getParentList() {
        return this.parentList;
    }

    public int getSize() {
        return this.size;
    }

    public int indexOf(Object arg4) {
        int v1;
        this.validateModification();
        Iterator v0 = RangesKt.until(this.offset, this.size() + this.offset).iterator();
        do {
            if(!v0.hasNext()) {
                return -1;
            }

            v1 = v0.nextInt();
        }
        while(!Intrinsics.areEqual(arg4, this.parentList.get(v1)));

        return v1 - this.offset;
    }

    public boolean isEmpty() {
        if(this.size() == 0) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return this.listIterator();
    }

    public int lastIndexOf(Object arg3) {
        this.validateModification();
        int v0;
        for(v0 = this.offset + this.size() - 1; v0 >= this.offset; --v0) {
            if(Intrinsics.areEqual(arg3, this.parentList.get(v0))) {
                return v0 - this.offset;
            }
        }

        return -1;
    }

    public ListIterator listIterator() {
        return this.listIterator(0);
    }

    public ListIterator listIterator(int arg2) {
        this.validateModification();
        IntRef v0 = new IntRef();
        v0.element = arg2 - 1;
        return new SubList$listIterator$1(v0, this);
    }

    public final Object remove(int arg1) {
        return this.removeAt(arg1);
    }

    public boolean remove(Object arg1) {
        int v1 = this.indexOf(arg1);
        if(v1 >= 0) {
            this.remove(v1);
            return 1;
        }

        return 0;
    }

    public boolean removeAll(Collection arg4) {
        boolean v1;
        Iterator v4 = arg4.iterator();
        do {
        label_2:
            v1 = false;
            while(true) {
            label_3:
                if(!v4.hasNext()) {
                    return v1;
                }

                if(!this.remove(v4.next()) && !v1) {
                    goto label_2;
                }

                break;
            }
        }
        while(true);

        v1 = true;
        goto label_3;
        return v1;
    }

    public Object removeAt(int arg3) {
        this.validateModification();
        Object v3 = this.parentList.remove(this.offset + arg3);
        this.size = this.size() - 1;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        return v3;
    }

    public boolean retainAll(Collection arg4) {
        this.validateModification();
        int v4 = this.parentList.retainAllInRange$runtime(arg4, this.offset, this.size() + this.offset);
        if(v4 > 0) {
            this.structure = SnapshotStateListKt.getStructure(this.parentList);
            this.size = this.size() - v4;
        }

        if(v4 > 0) {
            return 1;
        }

        return 0;
    }

    public Object set(int arg3, Object arg4) {
        SnapshotStateListKt.validateRange(arg3, this.size());
        this.validateModification();
        Object v3 = this.parentList.set(arg3 + this.offset, arg4);
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        return v3;
    }

    public final int size() {
        return this.getSize();
    }

    public List subList(int arg3, int arg4) {
        int v0 = arg3 < 0 || arg3 > arg4 || arg4 > this.size() ? 0 : 1;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }

        this.validateModification();
        return new SubList(this.parentList, arg3 + this.offset, arg4 + this.offset);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg1) {
        return CollectionToArray.toArray(((Collection)this), arg1);
    }

    private final void validateModification() {
        if(SnapshotStateListKt.getStructure(this.parentList) == this.structure) {
            return;
        }

        throw new ConcurrentModificationException();
    }
}

