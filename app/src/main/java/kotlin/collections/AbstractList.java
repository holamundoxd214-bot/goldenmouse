package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\'\u0018\u0000  *\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001D\u001E\u001F B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00020\u0007H¦\u0082\u0004¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0096\u0082\u0004J\u0017\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0080\u0004J\u0018\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u000B\u001A\u00020\u0007H\u0096\u0080\u0004J \u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0017\u001A\u00020\u0007H\u0096\u0080\u0004J\u0014\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0096\u0082\u0004J\n\u0010\u001C\u001A\u00020\u0007H\u0096\u0080\u0004R\u0013\u0010\u0006\u001A\u00020\u0007X¦\u0084\b¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006!"}, d2={"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "<init>", "()V", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "iterator", "", "indexOf", "element", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "equals", "", "other", "", "hashCode", "SubList", "IteratorImpl", "ListIteratorImpl", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractList extends AbstractCollection implements List, KMappedMarker {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\tJ\u001F\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\u000BJ\'\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\u000FJ\'\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\u0013J\u001F\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0017\u001A\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\u0018J\u001B\u0010\u0019\u001A\u00020\u00072\n\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u001BH\u0080\u0080\u0004¢\u0006\u0002\b\u001CJ\'\u0010\u001D\u001A\u00020\u001E2\n\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u001B2\n\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030\u001BH\u0080\u0080\u0004¢\u0006\u0002\b R\u000F\u0010\u0014\u001A\u00020\u0007X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"Lkotlin/collections/AbstractList$Companion;", "", "<init>", "()V", "checkElementIndex", "", "index", "", "size", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "checkBoundsIndexes", "startIndex", "endIndex", "checkBoundsIndexes$kotlin_stdlib", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "orderedHashCode", "c", "", "orderedHashCode$kotlin_stdlib", "orderedEquals", "", "other", "orderedEquals$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int arg3, int arg4, int arg5) {
            String v2 = "startIndex: ";
            if(arg3 >= 0 && arg4 <= arg5) {
                if(arg3 <= arg4) {
                    return;
                }
                else {
                    throw new IllegalArgumentException(v2 + arg3 + " > endIndex: " + arg4);
                }
            }

            throw new IndexOutOfBoundsException(v2 + arg3 + ", endIndex: " + arg4 + ", size: " + arg5);
        }

        public final void checkElementIndex$kotlin_stdlib(int arg3, int arg4) {
            if(arg3 >= 0 && arg3 < arg4) {
                return;
            }

            throw new IndexOutOfBoundsException("index: " + arg3 + ", size: " + arg4);
        }

        public final void checkPositionIndex$kotlin_stdlib(int arg3, int arg4) {
            if(arg3 >= 0 && arg3 <= arg4) {
                return;
            }

            throw new IndexOutOfBoundsException("index: " + arg3 + ", size: " + arg4);
        }

        public final void checkRangeIndexes$kotlin_stdlib(int arg3, int arg4, int arg5) {
            String v2 = "fromIndex: ";
            if(arg3 >= 0 && arg4 <= arg5) {
                if(arg3 <= arg4) {
                    return;
                }
                else {
                    throw new IllegalArgumentException(v2 + arg3 + " > toIndex: " + arg4);
                }
            }

            throw new IndexOutOfBoundsException(v2 + arg3 + ", toIndex: " + arg4 + ", size: " + arg5);
        }

        public final int newCapacity$kotlin_stdlib(int arg2, int arg3) {
            arg2 += arg2 >> 1;
            if(arg2 - arg3 < 0) {
                arg2 = arg3;
            }

            int v1 = 0x7FFFFFF7;
            if(arg2 - v1 > 0) {
                if(arg3 > v1) {
                    v1 = 0x7FFFFFFF;
                }

                return v1;
            }

            return arg2;
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection arg3, Collection arg4) {
            Intrinsics.checkNotNullParameter(arg3, "c");
            Intrinsics.checkNotNullParameter(arg4, "other");
            if(arg3.size() != arg4.size()) {
                return 0;
            }

            Iterator v2 = arg4.iterator();
            Iterator v3 = arg3.iterator();
            do {
                if(!v3.hasNext()) {
                    return 1;
                }
            }
            while(Intrinsics.areEqual(v3.next(), v2.next()));

            return 0;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection arg2) {
            Intrinsics.checkNotNullParameter(arg2, "c");
            Iterator v1 = arg2.iterator();
            int v2;
            for(v2 = 1; v1.hasNext(); v2 += v0_1) {
                Object v0 = v1.next();
                v2 *= 0x1F;
                int v0_1 = v0 != null ? v0.hashCode() : 0;
            }

            return v2;
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0092\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001A\u00020\u000BH\u0096\u0082\u0004J\u000F\u0010\f\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\rR\u001B\u0010\u0004\u001A\u00020\u0005X\u0084\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000E"}, d2={"Lkotlin/collections/AbstractList$IteratorImpl;", "", "<init>", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) class IteratorImpl implements Iterator, KMappedMarker {
        private int index;

        public IteratorImpl(AbstractList arg1) {
            AbstractList.this = arg1;
            super();
        }

        protected final int getIndex() {
            return this.index;
        }

        public boolean hasNext() {
            if(this.index < AbstractList.this.size()) {
                return 1;
            }

            return 0;
        }

        public Object next() {
            if(this.hasNext()) {
                AbstractList v0 = AbstractList.this;
                int v1 = this.index;
                this.index = v1 + 1;
                return v0.get(v1);
            }

            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        protected final void setIndex(int arg1) {
            this.index = arg1;
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0092\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\bF\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001A\u00020\tH\u0096\u0080\u0004J\n\u0010\n\u001A\u00020\u0005H\u0096\u0080\u0004J\u000F\u0010\u000B\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\fJ\n\u0010\r\u001A\u00020\u0005H\u0096\u0080\u0004¨\u0006\u000E"}, d2={"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "<init>", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) class ListIteratorImpl extends IteratorImpl implements ListIterator, KMappedMarker {
        public ListIteratorImpl(AbstractList arg2, int arg3) {
            AbstractList.this = arg2;
            super(arg2);
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(arg3, arg2.size());
            this.setIndex(arg3);
        }

        public void add(Object arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            if(this.getIndex() > 0) {
                return 1;
            }

            return 0;
        }

        public int nextIndex() {
            return this.getIndex();
        }

        public Object previous() {
            if(this.hasPrevious()) {
                AbstractList v0 = AbstractList.this;
                this.setIndex(this.getIndex() - 1);
                return v0.get(this.getIndex());
            }

            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.getIndex() - 1;
        }

        public void set(Object arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010 \n\u0000\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\'\bF\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u00028\u00012\u0006\u0010\r\u001A\u00020\u0007H\u0096\u0082\u0004¢\u0006\u0002\u0010\u000EJ \u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0096\u0080\u0004R\u0015\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000B\u001A\u00020\u0007X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000F\u001A\u00020\u00078VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2={"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "<init>", "(Lkotlin/collections/AbstractList;II)V", "_size", "get", "index", "(I)Ljava/lang/Object;", "size", "getSize", "()I", "subList", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class SubList extends AbstractList implements RandomAccess {
        private int _size;
        private final int fromIndex;
        private final AbstractList list;

        public SubList(AbstractList arg2, int arg3, int arg4) {
            Intrinsics.checkNotNullParameter(arg2, "list");
            super();
            this.list = arg2;
            this.fromIndex = arg3;
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(arg3, arg4, arg2.size());
            this._size = arg4 - arg3;
        }

        public Object get(int arg3) {
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this._size);
            return this.list.get(this.fromIndex + arg3);
        }

        public int getSize() {
            return this._size;
        }

        public List subList(int arg3, int arg4) {
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(arg3, arg4, this._size);
            return new SubList(this.list, arg3 + this.fromIndex, this.fromIndex + arg4);
        }
    }

    public static final Companion Companion = null;
    private static final int maxArraySize = 0x7FFFFFF7;

    static {
        AbstractList.Companion = new Companion(null);
    }

    protected AbstractList() {
        super();
    }

    public void add(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int arg1, Collection arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(Object arg2) {
        if((((AbstractList)arg2)) == this) {
            return 1;
        }

        if(!(arg2 instanceof List)) {
            return 0;
        }

        return AbstractList.Companion.orderedEquals$kotlin_stdlib(((Collection)this), ((Collection)arg2));
    }

    public abstract Object get(int arg1);

    public abstract int getSize();

    public int hashCode() {
        return AbstractList.Companion.orderedHashCode$kotlin_stdlib(((Collection)this));
    }

    public int indexOf(Object arg3) {
        Iterator v2 = ((List)this).iterator();
        int v0;
        for(v0 = 0; v2.hasNext(); ++v0) {
            if(Intrinsics.areEqual(v2.next(), arg3)) {
                return v0;
            }
        }

        return -1;
    }

    public Iterator iterator() {
        return new IteratorImpl(this);
    }

    public int lastIndexOf(Object arg2) {
        ListIterator v1 = ((List)this).listIterator(((List)this).size());
        do {
            if(!v1.hasPrevious()) {
                return -1;
            }
        }
        while(!Intrinsics.areEqual(v1.previous(), arg2));

        return v1.nextIndex();
    }

    public ListIterator listIterator() {
        return new ListIteratorImpl(this, 0);
    }

    public ListIterator listIterator(int arg2) {
        return new ListIteratorImpl(this, arg2);
    }

    public Object remove(int arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object set(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List subList(int arg2, int arg3) {
        return new SubList(this, arg2, arg3);
    }
}

