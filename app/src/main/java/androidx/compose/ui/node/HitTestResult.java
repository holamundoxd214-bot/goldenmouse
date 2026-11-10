package androidx.compose.ui.node;

import androidx.collection.MutableLongList;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.Modifier$Node;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u001E\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002<=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u000F\u001A\u00020\u0010J\u0006\u0010\u0011\u001A\u00020\u0012J\u0016\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0010J\u000F\u0010\u0017\u001A\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u00102\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00120\u001EH\u0086\bJ/\u0010\u001F\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00102\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00120\u001EH\u0086\bJ7\u0010\u001F\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\u00102\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00120\u001EH\u0086\bJ$\u0010!\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u00102\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00120\u001EJ,\u0010\"\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00102\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00120\u001EJ\u0010\u0010#\u001A\u00020\u00122\u0006\u0010$\u001A\u00020\u000BH\u0002J\u0018\u0010%\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\u000B2\u0006\u0010\'\u001A\u00020\u000BH\u0002J\u0017\u0010(\u001A\u00020\u00122\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\u00120\u001EH\u0086\bJ\u0011\u0010*\u001A\u00020\u00102\u0006\u0010+\u001A\u00020\u0002H\u0096\u0002J\u0016\u0010,\u001A\u00020\u00102\f\u0010-\u001A\b\u0012\u0004\u0012\u00020\u00020.H\u0016J\u0011\u0010/\u001A\u00020\u00022\u0006\u00100\u001A\u00020\u000BH\u0096\u0002J\u0010\u00101\u001A\u00020\u000B2\u0006\u0010+\u001A\u00020\u0002H\u0016J\b\u00102\u001A\u00020\u0010H\u0016J\u000F\u00103\u001A\b\u0012\u0004\u0012\u00020\u000204H\u0096\u0002J\u0010\u00105\u001A\u00020\u000B2\u0006\u0010+\u001A\u00020\u0002H\u0016J\u000E\u00106\u001A\b\u0012\u0004\u0012\u00020\u000207H\u0016J\u0016\u00106\u001A\b\u0012\u0004\u0012\u00020\u0002072\u0006\u00100\u001A\u00020\u000BH\u0016J\u001E\u00108\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u00109\u001A\u00020\u000B2\u0006\u0010:\u001A\u00020\u000BH\u0016J\u0006\u0010;\u001A\u00020\u0012R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006>"}, d2={"Landroidx/compose/ui/node/HitTestResult;", "", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "values", "Landroidx/collection/MutableObjectList;", "", "distanceFromEdgeAndFlags", "Landroidx/collection/MutableLongList;", "hitDepth", "", "size", "getSize", "()I", "hasHit", "", "acceptHits", "", "isHitInMinimumTouchTargetBetter", "distanceFromEdge", "", "isInLayer", "findBestHitDistance", "Landroidx/compose/ui/node/DistanceAndFlags;", "findBestHitDistance-fn2tFes", "()J", "hit", "node", "childHitTest", "Lkotlin/Function0;", "hitInMinimumTouchTarget", "isInExpandedBounds", "hitExpandedTouchBounds", "speculativeHit", "removeNodeAtDepth", "depth", "removeNodesInRange", "startDepth", "endDepth", "siblingHits", "block", "contains", "element", "containsAll", "elements", "", "get", "index", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "clear", "HitTestResultIterator", "SubList", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HitTestResult implements List, KMappedMarker {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000F\u001A\u00020\u0010H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0010H\u0016J\t\u0010\u0012\u001A\u00020\u0002H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0004H\u0016J\b\u0010\u0014\u001A\u00020\u0002H\u0016J\b\u0010\u0015\u001A\u00020\u0004H\u0016R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\n¨\u0006\u0016"}, d2={"Landroidx/compose/ui/node/HitTestResult$HitTestResultIterator;", "", "Landroidx/compose/ui/Modifier$Node;", "index", "", "minIndex", "maxIndex", "<init>", "(Landroidx/compose/ui/node/HitTestResult;III)V", "getIndex", "()I", "setIndex", "(I)V", "getMinIndex", "getMaxIndex", "hasNext", "", "hasPrevious", "next", "nextIndex", "previous", "previousIndex", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class HitTestResultIterator implements ListIterator, KMappedMarker {
        private int index;
        private final int maxIndex;
        private final int minIndex;

        public HitTestResultIterator(HitTestResult arg2, int arg3, int arg4, int arg5, int arg6, DefaultConstructorMarker arg7) {
            if((arg6 & 4) != 0) {
                arg5 = arg2.size();
            }

            this(arg2, 0, 0, arg5);
        }

        public HitTestResultIterator(HitTestResult arg1, int arg2, int arg3, int arg4) {
            HitTestResult.this = arg1;
            super();
            this.index = arg2;
            this.minIndex = arg3;
            this.maxIndex = arg4;
        }

        public void add(Node arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void add(Object arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final int getIndex() {
            return this.index;
        }

        public final int getMaxIndex() {
            return this.maxIndex;
        }

        public final int getMinIndex() {
            return this.minIndex;
        }

        public boolean hasNext() {
            if(this.index < this.maxIndex) {
                return 1;
            }

            return 0;
        }

        public boolean hasPrevious() {
            if(this.index > this.minIndex) {
                return 1;
            }

            return 0;
        }

        public Node next() {
            MutableObjectList v0 = HitTestResult.this.values;
            int v1 = this.index;
            this.index = v1 + 1;
            Object v3 = v0.get(v1);
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return ((Node)v3);
        }

        public Object next() {
            return this.next();
        }

        public int nextIndex() {
            return this.index - this.minIndex;
        }

        public Node previous() {
            MutableObjectList v0 = HitTestResult.this.values;
            int v1 = this.index - 1;
            this.index = v1;
            Object v2 = v0.get(v1);
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return ((Node)v2);
        }

        public Object previous() {
            return this.previous();
        }

        public int previousIndex() {
            return this.index - this.minIndex - 1;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void set(Node arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void set(Object arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int arg1) {
            this.index = arg1;
        }
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0002H\u0096\u0002J\u0016\u0010\u0010\u001A\u00020\u000E2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\u0011\u0010\u0013\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u0004H\u0096\u0002J\u0010\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u0002H\u0016J\b\u0010\u0016\u001A\u00020\u000EH\u0016J\u000F\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002J\u0010\u0010\u0019\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u0002H\u0016J\u000E\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00020\u001BH\u0016J\u0016\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00020\u001B2\u0006\u0010\u0014\u001A\u00020\u0004H\u0016J\u001E\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0014\u0010\u000B\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\t¨\u0006\u001F"}, d2={"Landroidx/compose/ui/node/HitTestResult$SubList;", "", "Landroidx/compose/ui/Modifier$Node;", "minIndex", "", "maxIndex", "<init>", "(Landroidx/compose/ui/node/HitTestResult;II)V", "getMinIndex", "()I", "getMaxIndex", "size", "getSize", "contains", "", "element", "containsAll", "elements", "", "get", "index", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class SubList implements List, KMappedMarker {
        private final int maxIndex;
        private final int minIndex;

        public SubList(HitTestResult arg1, int arg2, int arg3) {
            HitTestResult.this = arg1;
            super();
            this.minIndex = arg2;
            this.maxIndex = arg3;
        }

        public void add(int arg1, Node arg2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void add(int arg1, Object arg2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean add(Node arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean add(Object arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean addAll(int arg1, Collection arg2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean addAll(Collection arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void addFirst(Node arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void addFirst(Object arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void addLast(Node arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void addLast(Object arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean contains(Node arg1) {
            if(this.indexOf(arg1) != -1) {
                return 1;
            }

            return 0;
        }

        public final boolean contains(Object arg2) {
            if(!(arg2 instanceof Node)) {
                return 0;
            }

            return this.contains(((Node)arg2));
        }

        public boolean containsAll(Collection arg2) {
            Iterator v2 = ((Iterable)arg2).iterator();
            do {
                if(!v2.hasNext()) {
                    return 1;
                }
            }
            while(this.contains(v2.next()));

            return 0;
        }

        public Node get(int arg2) {
            Object v1 = HitTestResult.this.values.get(arg2 + this.minIndex);
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return ((Node)v1);
        }

        public Object get(int arg1) {
            return this.get(arg1);
        }

        public final int getMaxIndex() {
            return this.maxIndex;
        }

        public final int getMinIndex() {
            return this.minIndex;
        }

        public int getSize() {
            return this.maxIndex - this.minIndex;
        }

        public final int indexOf(Object arg2) {
            if(!(arg2 instanceof Node)) {
                return -1;
            }

            return this.indexOf(((Node)arg2));
        }

        public int indexOf(Node arg4) {
            int v0 = this.minIndex;
            int v1 = this.maxIndex;
            if(v0 <= v1) {
                while(true) {
                    if(Intrinsics.areEqual(HitTestResult.this.values.get(v0), arg4)) {
                        break;
                    }
                    else if(v0 != v1) {
                        ++v0;
                        continue;
                    }

                    return -1;
                }

                return v0 - this.minIndex;
            }

            return -1;
        }

        public boolean isEmpty() {
            if(this.size() == 0) {
                return 1;
            }

            return 0;
        }

        public Iterator iterator() {
            return new HitTestResultIterator(HitTestResult.this, this.minIndex, this.minIndex, this.maxIndex);
        }

        public int lastIndexOf(Node arg4) {
            int v0 = this.maxIndex;
            int v1 = this.minIndex;
            if(v1 <= v0) {
                while(true) {
                    if(Intrinsics.areEqual(HitTestResult.this.values.get(v0), arg4)) {
                        break;
                    }
                    else if(v0 != v1) {
                        --v0;
                        continue;
                    }

                    return -1;
                }

                return v0 - this.minIndex;
            }

            return -1;
        }

        public final int lastIndexOf(Object arg2) {
            if(!(arg2 instanceof Node)) {
                return -1;
            }

            return this.lastIndexOf(((Node)arg2));
        }

        public ListIterator listIterator() {
            return new HitTestResultIterator(HitTestResult.this, this.minIndex, this.minIndex, this.maxIndex);
        }

        public ListIterator listIterator(int arg4) {
            return new HitTestResultIterator(HitTestResult.this, arg4 + this.minIndex, this.minIndex, this.maxIndex);
        }

        public Node remove(int arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Object remove(int arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean remove(Object arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean removeAll(Collection arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Node removeFirst() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Object removeFirst() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Node removeLast() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Object removeLast() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void replaceAll(UnaryOperator arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean retainAll(Collection arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Node set(int arg1, Node arg2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Object set(int arg1, Object arg2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final int size() {
            return this.getSize();
        }

        public void sort(Comparator arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public List subList(int arg3, int arg4) {
            return new SubList(HitTestResult.this, arg3 + this.minIndex, this.minIndex + arg4);
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(((Collection)this));
        }

        public Object[] toArray(Object[] arg1) {
            return CollectionToArray.toArray(((Collection)this), arg1);
        }
    }

    public static final int $stable = 8;
    private MutableLongList distanceFromEdgeAndFlags;
    private int hitDepth;
    private MutableObjectList values;

    static {
    }

    public HitTestResult() {
        super();
        this.values = new MutableObjectList(16);
        this.distanceFromEdgeAndFlags = new MutableLongList(16);
        this.hitDepth = -1;
    }

    public final void acceptHits() {
        this.hitDepth = this.size() - 1;
    }

    public static final MutableLongList access$getDistanceFromEdgeAndFlags$p(HitTestResult arg0) {
        return arg0.distanceFromEdgeAndFlags;
    }

    public static final int access$getHitDepth$p(HitTestResult arg0) {
        return arg0.hitDepth;
    }

    public static final MutableObjectList access$getValues$p(HitTestResult arg0) {
        return arg0.values;
    }

    public static final void access$removeNodesInRange(HitTestResult arg0, int arg1, int arg2) {
        arg0.removeNodesInRange(arg1, arg2);
    }

    public static final void access$setHitDepth$p(HitTestResult arg0, int arg1) {
        arg0.hitDepth = arg1;
    }

    public void add(int arg1, Node arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Node arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int arg1, Collection arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(Node arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(Node arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        this.hitDepth = -1;
        this.values.clear();
        this.distanceFromEdgeAndFlags.clear();
    }

    public boolean contains(Node arg1) {
        if(this.indexOf(arg1) != -1) {
            return 1;
        }

        return 0;
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof Node)) {
            return 0;
        }

        return this.contains(((Node)arg2));
    }

    public boolean containsAll(Collection arg2) {
        Iterator v2 = ((Iterable)arg2).iterator();
        do {
            if(!v2.hasNext()) {
                return 1;
            }
        }
        while(this.contains(v2.next()));

        return 0;
    }

    private final long findBestHitDistance-fn2tFes() {
        long v0 = HitTestResultKt.DistanceAndFlags$default(Infinityf, false, false, 4, null);
        int v2 = this.hitDepth + 1;
        int v3 = CollectionsKt.getLastIndex(this);
        if(v2 <= v3) {
            while(true) {
                long v4 = DistanceAndFlags.constructor-impl(this.distanceFromEdgeAndFlags.get(v2));
                if(DistanceAndFlags.compareTo-9YPOF3E(v4, v0) < 0) {
                    v0 = v4;
                }

                if(DistanceAndFlags.getDistance-impl(v0) < 0f && (DistanceAndFlags.isInLayer-impl(v0))) {
                    return v0;
                }

                if(v2 == v3) {
                    return v0;
                }

                ++v2;
            }
        }

        return v0;
    }

    public Node get(int arg1) {
        Object v0 = this.values.get(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return ((Node)v0);
    }

    public Object get(int arg1) {
        return this.get(arg1);
    }

    public int getSize() {
        return this.values.getSize();
    }

    public final boolean hasHit() {
        long v0 = this.findBestHitDistance-fn2tFes();
        if(DistanceAndFlags.getDistance-impl(v0) < 0f && (DistanceAndFlags.isInLayer-impl(v0)) && !DistanceAndFlags.isInExpandedBounds-impl(v0)) {
            return 1;
        }

        return 0;
    }

    public final void hit(Node arg4, boolean arg5, Function0 arg6) {
        int v0 = this.hitDepth;
        this.removeNodesInRange(this.hitDepth + 1, this.size());
        ++this.hitDepth;
        this.values.add(arg4);
        this.distanceFromEdgeAndFlags.add(HitTestResultKt.access$DistanceAndFlags(-1f, arg5, false));
        arg6.invoke();
        this.hitDepth = v0;
    }

    public final void hitExpandedTouchBounds(Node arg8, boolean arg9, Function0 arg10) {
        int v0;
        HitTestResult v1 = this;
        if(this.hitDepth == CollectionsKt.getLastIndex(((List)v1))) {
            v0 = this.hitDepth;
            this.removeNodesInRange(this.hitDepth + 1, this.size());
            ++this.hitDepth;
            this.values.add(arg8);
            this.distanceFromEdgeAndFlags.add(HitTestResultKt.access$DistanceAndFlags(0f, arg9, true));
            arg10.invoke();
            this.hitDepth = v0;
            return;
        }

        long v5 = this.findBestHitDistance-fn2tFes();
        v0 = this.hitDepth;
        if(DistanceAndFlags.isInExpandedBounds-impl(v5)) {
            this.hitDepth = CollectionsKt.getLastIndex(((List)v1));
            int v1_1 = this.hitDepth;
            this.removeNodesInRange(this.hitDepth + 1, this.size());
            ++this.hitDepth;
            this.values.add(arg8);
            this.distanceFromEdgeAndFlags.add(HitTestResultKt.access$DistanceAndFlags(0f, arg9, true));
            arg10.invoke();
            this.hitDepth = v1_1;
            if(DistanceAndFlags.getDistance-impl(this.findBestHitDistance-fn2tFes()) < 0f) {
                this.removeNodesInRange(v0 + 1, this.hitDepth + 1);
            }

            this.hitDepth = v0;
            return;
        }

        if(DistanceAndFlags.getDistance-impl(v5) > 0f) {
            v0 = this.hitDepth;
            this.removeNodesInRange(this.hitDepth + 1, this.size());
            ++this.hitDepth;
            this.values.add(arg8);
            this.distanceFromEdgeAndFlags.add(HitTestResultKt.access$DistanceAndFlags(0f, arg9, true));
            arg10.invoke();
            this.hitDepth = v0;
        }
    }

    public final void hitInMinimumTouchTarget(Node arg4, float arg5, boolean arg6, Function0 arg7) {
        int v0 = this.hitDepth;
        this.removeNodesInRange(this.hitDepth + 1, this.size());
        ++this.hitDepth;
        this.values.add(arg4);
        this.distanceFromEdgeAndFlags.add(HitTestResultKt.access$DistanceAndFlags(arg5, arg6, false));
        arg7.invoke();
        this.hitDepth = v0;
    }

    public final void hitInMinimumTouchTarget(Node arg4, float arg5, boolean arg6, boolean arg7, Function0 arg8) {
        int v0 = this.hitDepth;
        this.removeNodesInRange(this.hitDepth + 1, this.size());
        ++this.hitDepth;
        this.values.add(arg4);
        this.distanceFromEdgeAndFlags.add(HitTestResultKt.access$DistanceAndFlags(arg5, arg6, arg7));
        arg8.invoke();
        this.hitDepth = v0;
    }

    public final int indexOf(Object arg2) {
        if(!(arg2 instanceof Node)) {
            return -1;
        }

        return this.indexOf(((Node)arg2));
    }

    public int indexOf(Node arg4) {
        int v0 = CollectionsKt.getLastIndex(this);
        if(v0 >= 0) {
            int v1 = 0;
            while(true) {
                if(Intrinsics.areEqual(this.values.get(v1), arg4)) {
                    return v1;
                }
                else if(v1 != v0) {
                    ++v1;
                    continue;
                }

                return -1;
            }

            return v1;
        }

        return -1;
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public final boolean isHitInMinimumTouchTargetBetter(float arg5, boolean arg6) {
        if(this.hitDepth == CollectionsKt.getLastIndex(this)) {
            return 1;
        }

        if(DistanceAndFlags.compareTo-9YPOF3E(this.findBestHitDistance-fn2tFes(), HitTestResultKt.DistanceAndFlags$default(arg5, arg6, false, 4, null)) > 0) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, null);
    }

    public int lastIndexOf(Node arg3) {
        int v1;
        int v0;
        for(v0 = CollectionsKt.getLastIndex(this); true; --v0) {
            v1 = -1;
            if(v1 >= v0) {
                return v1;
            }

            if(Intrinsics.areEqual(this.values.get(v0), arg3)) {
                return v0;
            }
        }

        return v1;
    }

    public final int lastIndexOf(Object arg2) {
        if(!(arg2 instanceof Node)) {
            return -1;
        }

        return this.lastIndexOf(((Node)arg2));
    }

    public ListIterator listIterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, null);
    }

    public ListIterator listIterator(int arg8) {
        return new HitTestResultIterator(this, arg8, 0, 0, 6, null);
    }

    public Node remove(int arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(int arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Node removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Node removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private final void removeNodeAtDepth(int arg2) {
        this.values.removeAt(arg2);
        this.distanceFromEdgeAndFlags.removeAt(arg2);
    }

    private final void removeNodesInRange(int arg2, int arg3) {
        if(arg2 >= arg3) {
            return;
        }

        this.values.removeRange(arg2, arg3);
        this.distanceFromEdgeAndFlags.removeRange(arg2, arg3);
    }

    public void replaceAll(UnaryOperator arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Node set(int arg1, Node arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object set(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void siblingHits(Function0 arg2) {
        int v0 = this.hitDepth;
        arg2.invoke();
        this.hitDepth = v0;
    }

    public final int size() {
        return this.getSize();
    }

    public void sort(Comparator arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void speculativeHit(Node arg9, float arg10, boolean arg11, Function0 arg12) {
        int v0;
        HitTestResult v1 = this;
        if(this.hitDepth == CollectionsKt.getLastIndex(((List)v1))) {
            v0 = this.hitDepth;
            this.removeNodesInRange(this.hitDepth + 1, this.size());
            ++this.hitDepth;
            this.values.add(arg9);
            this.distanceFromEdgeAndFlags.add(HitTestResultKt.access$DistanceAndFlags(arg10, arg11, false));
            arg12.invoke();
            this.hitDepth = v0;
            if(this.hitDepth + 1 != CollectionsKt.getLastIndex(((List)v1))) {
                if(DistanceAndFlags.isInExpandedBounds-impl(this.findBestHitDistance-fn2tFes())) {
                }
                else {
                    return;
                }
            }

            this.removeNodeAtDepth(this.hitDepth + 1);
            return;
        }

        long v4 = this.findBestHitDistance-fn2tFes();
        v0 = this.hitDepth;
        this.hitDepth = CollectionsKt.getLastIndex(((List)v1));
        int v2 = this.hitDepth;
        this.removeNodesInRange(this.hitDepth + 1, this.size());
        ++this.hitDepth;
        this.values.add(arg9);
        this.distanceFromEdgeAndFlags.add(HitTestResultKt.access$DistanceAndFlags(arg10, arg11, false));
        arg12.invoke();
        this.hitDepth = v2;
        long v9 = this.findBestHitDistance-fn2tFes();
        if(this.hitDepth + 1 >= CollectionsKt.getLastIndex(((List)v1)) || DistanceAndFlags.compareTo-9YPOF3E(v4, v9) <= 0) {
            this.removeNodesInRange(this.hitDepth + 1, this.size());
        }
        else {
            int v11 = v0 + 1;
            boolean v9_1 = DistanceAndFlags.isInExpandedBounds-impl(v9);
            int v10 = this.hitDepth;
            if(v9_1) {
                v10 += 2;
            }
            else {
                ++v10;
            }

            this.removeNodesInRange(v11, v10);
        }

        this.hitDepth = v0;
    }

    public List subList(int arg2, int arg3) {
        return new SubList(this, arg2, arg3);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg1) {
        return CollectionToArray.toArray(((Collection)this), arg1);
    }
}

