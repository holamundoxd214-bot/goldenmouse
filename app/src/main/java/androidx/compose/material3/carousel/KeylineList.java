package androidx.compose.material3.carousel;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0006\b\u0001\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B\u0017\b\u0000\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001F\u001A\u00020 J\u000E\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020#J\u000E\u0010$\u001A\u00020\u00072\u0006\u0010%\u001A\u00020#J\u000E\u0010&\u001A\u00020\u00072\u0006\u0010%\u001A\u00020#J\u000E\u0010\'\u001A\u00020\u00022\u0006\u0010(\u001A\u00020#J\u000E\u0010)\u001A\u00020\u00022\u0006\u0010(\u001A\u00020#J\u0013\u0010*\u001A\u00020 2\b\u0010+\u001A\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001A\u00020\u0007H\u0016J\u0011\u0010.\u001A\u00020 2\u0006\u0010/\u001A\u00020\u0002H\u0096\u0003J\u0017\u00100\u001A\u00020 2\f\u00101\u001A\b\u0012\u0004\u0012\u00020\u000202H\u0096\u0001J\u0011\u00103\u001A\u00020\u00022\u0006\u00104\u001A\u00020\u0007H\u0096\u0003J\u0011\u00105\u001A\u00020\u00072\u0006\u0010/\u001A\u00020\u0002H\u0096\u0001J\t\u00106\u001A\u00020 H\u0096\u0001J\u000F\u00107\u001A\b\u0012\u0004\u0012\u00020\u000208H\u0096\u0003J\u0011\u00109\u001A\u00020\u00072\u0006\u0010/\u001A\u00020\u0002H\u0096\u0001J\u000F\u0010:\u001A\b\u0012\u0004\u0012\u00020\u00020;H\u0096\u0001J\u0017\u0010:\u001A\b\u0012\u0004\u0012\u00020\u00020;2\u0006\u00104\u001A\u00020\u0007H\u0096\u0001J\u001F\u0010<\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010=\u001A\u00020\u00072\u0006\u0010>\u001A\u00020\u0007H\u0096\u0001R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\tR\u0011\u0010\u000F\u001A\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\tR\u0011\u0010\u0013\u001A\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\tR\u0011\u0010\u0017\u001A\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\tR\u0011\u0010\u001B\u001A\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\fR\u0011\u0010\u001D\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\tR\u0012\u0010%\u001A\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001A\u0004\b?\u0010\t¨\u0006A"}, d2={"Landroidx/compose/material3/carousel/KeylineList;", "", "Landroidx/compose/material3/carousel/Keyline;", "keylines", "<init>", "(Ljava/util/List;)V", "pivotIndex", "", "getPivotIndex", "()I", "pivot", "getPivot", "()Landroidx/compose/material3/carousel/Keyline;", "firstNonAnchorIndex", "getFirstNonAnchorIndex", "firstNonAnchor", "getFirstNonAnchor", "lastNonAnchorIndex", "getLastNonAnchorIndex", "lastNonAnchor", "getLastNonAnchor", "firstFocalIndex", "getFirstFocalIndex", "firstFocal", "getFirstFocal", "lastFocalIndex", "getLastFocalIndex", "lastFocal", "getLastFocal", "focalCount", "getFocalCount", "isFirstFocalItemAtStartOfContainer", "", "isLastFocalItemAtEndOfContainer", "carouselMainAxisSize", "", "firstIndexAfterFocalRangeWithSize", "size", "lastIndexBeforeFocalRangeWithSize", "getKeylineBefore", "unadjustedOffset", "getKeylineAfter", "equals", "other", "", "hashCode", "contains", "element", "containsAll", "elements", "", "get", "index", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "getSize", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class KeylineList implements List, KMappedMarker {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/material3/carousel/KeylineList$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/material3/carousel/KeylineList;", "getEmpty", "()Landroidx/compose/material3/carousel/KeylineList;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final KeylineList getEmpty() {
            return KeylineList.Empty;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final KeylineList Empty;
    private final int firstFocalIndex;
    private final int firstNonAnchorIndex;
    private final int focalCount;
    private final int lastFocalIndex;
    private final int lastNonAnchorIndex;
    private final int pivotIndex;

    static {
        KeylineList.Companion = new Companion(null);
        KeylineList.$stable = 8;
        KeylineList.Empty = new KeylineList(CollectionsKt.emptyList());
    }

    public KeylineList(List arg6) {
        int v4;
        super();
        this.$$delegate_0 = arg6;
        KeylineList v6 = this;
        Iterator v0 = ((List)v6).iterator();
        int v1 = 0;
        int v2 = 0;
        while(true) {
            v4 = -1;
            if(!v0.hasNext()) {
                break;
            }
            else if(v0.next().isPivot()) {
            }
            else {
                ++v2;
                continue;
            }

            goto label_16;
        }

        v2 = v4;
    label_16:
        this.pivotIndex = v2;
        v0 = ((List)v6).iterator();
        v2 = 0;
        while(true) {
            if(!v0.hasNext()) {
                break;
            }
            else if(!v0.next().isAnchor()) {
            }
            else {
                ++v2;
                continue;
            }

            goto label_28;
        }

        v2 = v4;
    label_28:
        this.firstNonAnchorIndex = v2;
        ListIterator v0_1 = ((List)v6).listIterator(((List)v6).size());
        do {
            if(v0_1.hasPrevious()) {
                if(v0_1.previous().isAnchor()) {
                    continue;
                }

                break;
            }
            else {
                goto label_38;
            }
        }
        while(true);

        int v0_2 = v0_1.nextIndex();
        goto label_39;
    label_38:
        v0_2 = v4;
    label_39:
        this.lastNonAnchorIndex = v0_2;
        v0 = ((List)v6).iterator();
        while(true) {
            if(!v0.hasNext()) {
                break;
            }
            else if(v0.next().isFocal()) {
            }
            else {
                ++v1;
                continue;
            }

            goto label_50;
        }

        v1 = v4;
    label_50:
        this.firstFocalIndex = v1;
        ListIterator v6_1 = ((List)v6).listIterator(((List)v6).size());
        do {
            if(v6_1.hasPrevious()) {
                if(!v6_1.previous().isFocal()) {
                    continue;
                }

                break;
            }

            goto label_59;
        }
        while(true);

        v4 = v6_1.nextIndex();
    label_59:
        this.lastFocalIndex = v4;
        this.focalCount = v4 - this.firstFocalIndex + 1;
    }

    public static final KeylineList access$getEmpty$cp() {
        return KeylineList.Empty;
    }

    public void add(int arg1, Keyline arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Keyline arg1) {
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

    public void addFirst(Keyline arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(Keyline arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Keyline arg1) {
        return this.$$delegate_0.contains(arg1);
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof Keyline)) {
            return 0;
        }

        return this.contains(((Keyline)arg2));
    }

    public boolean containsAll(Collection arg1) {
        return this.$$delegate_0.containsAll(arg1);
    }

    public boolean equals(Object arg7) {
        if(this == (((KeylineList)arg7))) {
            return 1;
        }

        if(!(arg7 instanceof KeylineList)) {
            return 0;
        }

        if(this.size() != ((KeylineList)arg7).size()) {
            return 0;
        }

        int v1 = this.size();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            if(!Intrinsics.areEqual(((List)this).get(v3), ((KeylineList)arg7).get(v3))) {
                return 0;
            }
        }

        return 1;
    }

    public final int firstIndexAfterFocalRangeWithSize(float arg5) {
        Object v2;
        KeylineList v1 = this;
        Iterator v0 = new IntRange(this.lastFocalIndex, CollectionsKt.getLastIndex(((List)v1))).iterator();
        do {
            if(v0.hasNext()) {
                v2 = v0.next();
                if(this.get(v2.intValue()).getSize() != arg5) {
                    continue;
                }

                break;
            }
            else {
                goto label_15;
            }
        }
        while(true);

        goto label_16;
    label_15:
        v2 = null;
    label_16:
        if(v2 != null) {
            return ((Integer)v2).intValue();
        }

        return CollectionsKt.getLastIndex(((List)v1));
    }

    public Keyline get(int arg1) {
        return this.$$delegate_0.get(arg1);
    }

    public Object get(int arg1) {
        return this.get(arg1);
    }

    public final Keyline getFirstFocal() {
        Object v1 = CollectionsKt.getOrNull(this, this.firstFocalIndex);
        if(v1 != null) {
            return ((Keyline)v1);
        }

        throw new NoSuchElementException("All KeylineLists must have at least one focal keyline");
    }

    public final int getFirstFocalIndex() {
        return this.firstFocalIndex;
    }

    public final Keyline getFirstNonAnchor() {
        return this.get(this.firstNonAnchorIndex);
    }

    public final int getFirstNonAnchorIndex() {
        return this.firstNonAnchorIndex;
    }

    public final int getFocalCount() {
        return this.focalCount;
    }

    public final Keyline getKeylineAfter(float arg5) {
        Object v2;
        int v0 = this.size();
        int v1 = 0;
        while(true) {
            if(v1 < v0) {
                v2 = ((List)this).get(v1);
                if(v2.getUnadjustedOffset() >= arg5) {
                }
                else {
                    ++v1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_12;
        }

        v2 = null;
    label_12:
        if(v2 == null) {
            return CollectionsKt.last(((List)this));
        }

        return ((Keyline)v2);
    }

    public final Keyline getKeylineBefore(float arg4) {
        Keyline v0_1;
        int v0 = this.size() - 1;
        if(v0 >= 0) {
            while(true) {
                int v1 = v0 - 1;
                v0_1 = this.get(v0);
                if(v0_1.getUnadjustedOffset() < arg4) {
                    return v0_1;
                }
                else if(v1 < 0) {
                }
                else {
                    v0 = v1;
                    continue;
                }

                goto label_13;
            }

            return v0_1;
        }

    label_13:
        return CollectionsKt.first(((List)this));
    }

    public final Keyline getLastFocal() {
        Object v1 = CollectionsKt.getOrNull(this, this.lastFocalIndex);
        if(v1 != null) {
            return ((Keyline)v1);
        }

        throw new NoSuchElementException("All KeylineLists must have at least one focal keyline");
    }

    public final int getLastFocalIndex() {
        return this.lastFocalIndex;
    }

    public final Keyline getLastNonAnchor() {
        return this.get(this.lastNonAnchorIndex);
    }

    public final int getLastNonAnchorIndex() {
        return this.lastNonAnchorIndex;
    }

    public final Keyline getPivot() {
        return this.get(this.pivotIndex);
    }

    public final int getPivotIndex() {
        return this.pivotIndex;
    }

    public int getSize() {
        return this.$$delegate_0.size();
    }

    public int hashCode() {
        int v0 = this.size();
        int v1 = 0;
        int v2 = 0;
        while(v1 < v0) {
            v2 += ((List)this).get(v1).hashCode() * 0x1F;
            ++v1;
        }

        return v2;
    }

    public int indexOf(Keyline arg1) {
        return this.$$delegate_0.indexOf(arg1);
    }

    public final int indexOf(Object arg2) {
        if(!(arg2 instanceof Keyline)) {
            return -1;
        }

        return this.indexOf(((Keyline)arg2));
    }

    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    public final boolean isFirstFocalItemAtStartOfContainer() {
        if(this.getFirstFocal().getOffset() - this.getFirstFocal().getSize() / 2f >= 0f && (Intrinsics.areEqual(this.getFirstFocal(), this.getFirstNonAnchor()))) {
            return 1;
        }

        return 0;
    }

    public final boolean isLastFocalItemAtEndOfContainer(float arg4) {
        if(this.getLastFocal().getOffset() + this.getLastFocal().getSize() / 2f <= arg4 && (Intrinsics.areEqual(this.getLastFocal(), this.getLastNonAnchor()))) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return this.$$delegate_0.iterator();
    }

    public final int lastIndexBeforeFocalRangeWithSize(float arg5) {
        Object v2;
        Iterator v0 = RangesKt.downTo(this.firstFocalIndex - 1, 0).iterator();
        do {
            if(v0.hasNext()) {
                v2 = v0.next();
                if(this.get(v2.intValue()).getSize() != arg5) {
                    continue;
                }

                break;
            }
            else {
                goto label_14;
            }
        }
        while(true);

        goto label_15;
    label_14:
        v2 = null;
    label_15:
        if(v2 != null) {
            return ((Integer)v2).intValue();
        }

        return 0;
    }

    public int lastIndexOf(Keyline arg1) {
        return this.$$delegate_0.lastIndexOf(arg1);
    }

    public final int lastIndexOf(Object arg2) {
        if(!(arg2 instanceof Keyline)) {
            return -1;
        }

        return this.lastIndexOf(((Keyline)arg2));
    }

    public ListIterator listIterator() {
        return this.$$delegate_0.listIterator();
    }

    public ListIterator listIterator(int arg1) {
        return this.$$delegate_0.listIterator(arg1);
    }

    public Keyline remove(int arg1) {
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

    public Keyline removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Keyline removeLast() {
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

    public Keyline set(int arg1, Keyline arg2) {
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

    public List subList(int arg1, int arg2) {
        return this.$$delegate_0.subList(arg1, arg2);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg1) {
        return CollectionToArray.toArray(((Collection)this), arg1);
    }
}

