package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\b\'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\t\bD¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\nH¦\u0082\u0004J\u0017\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u000EJ\u0018\u0010\u000F\u001A\u00020\f2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0080\u0004J\n\u0010\u0011\u001A\u00020\fH\u0096\u0080\u0004J\n\u0010\u0012\u001A\u00020\u0013H\u0096\u0080\u0004J\u0017\u0010\u0014\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0095\u0080\u0004¢\u0006\u0002\u0010\u0017J)\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00180\u0015\"\u0004\b\u0001\u0010\u00182\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u0015H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001AR\u0013\u0010\u0005\u001A\u00020\u0006X¦\u0084\b¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u001B"}, d2={"Lkotlin/collections/AbstractCollection;", "E", "", "<init>", "()V", "size", "", "getSize", "()I", "iterator", "", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "toString", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractCollection implements Collection, KMappedMarker {
    protected AbstractCollection() {
        super();
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object arg3) {
        if(((this instanceof Collection)) && (this.isEmpty())) {
            return 0;
        }

        Iterator v2 = ((Iterable)this).iterator();
        do {
            if(!v2.hasNext()) {
                return 0;
            }
        }
        while(!Intrinsics.areEqual(v2.next(), arg3));

        return 1;
    }

    public boolean containsAll(Collection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "elements");
        if(arg3.isEmpty()) {
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

    public abstract int getSize();

    public boolean isEmpty() {
        if(this.size() == 0) {
            return 1;
        }

        return 0;
    }

    public abstract Iterator iterator();

    public boolean remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.getSize();
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "array");
        return CollectionToArray.toArray(((Collection)this), arg2);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this, ", ", "[", "]", 0, null, new AbstractCollection$$ExternalSyntheticLambda0(this), 24, null);
    }

    static final CharSequence toString$lambda$0(AbstractCollection arg0, Object arg1) {
        String v0 = (((AbstractCollection)arg1)) == arg0 ? "(this Collection)" : String.valueOf(arg1);
        return ((CharSequence)v0);
    }
}

