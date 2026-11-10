package androidx.lifecycle;

import androidx.collection.MutableScatterMap;
import java.util.Map$Entry;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0001!B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000EJ\u001D\u0010\u000F\u001A\u0004\u0018\u00018\u00012\u0006\u0010\r\u001A\u00028\u00002\u0006\u0010\u0010\u001A\u00028\u0001¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001A\u0004\u0018\u00018\u00012\u0006\u0010\r\u001A\u00028\u0000¢\u0006\u0002\u0010\u0013J!\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00152\u0006\u0010\r\u001A\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015J\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015J\u0014\u0010\u0019\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0015J\u0006\u0010\u001A\u001A\u00020\u001BJ&\u0010\u001C\u001A\u00020\u001D2\u001E\u0010\u001E\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0004\u0012\u00020\u001D0\u001FJ&\u0010 \u001A\u00020\u001D2\u001E\u0010\u001E\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0004\u0012\u00020\u001D0\u001FR&\u0010\u0006\u001A\u001A\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\t\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\n\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\""}, d2={"Landroidx/lifecycle/FastSafeIterableMap;", "K", "", "V", "<init>", "()V", "map", "Landroidx/collection/MutableScatterMap;", "Landroidx/lifecycle/FastSafeIterableMap$Entry;", "head", "tail", "contains", "", "key", "(Ljava/lang/Object;)Z", "putIfAbsent", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "ceil", "", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "first", "last", "lastOrNull", "size", "", "forEachWithAdditions", "", "action", "Lkotlin/Function1;", "forEachReversed", "Entry", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class FastSafeIterableMap {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00028\u0002\u0012\u0006\u0010\u0005\u001A\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0017\u001A\u00020\u0018J\u000E\u0010\u0019\u001A\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\tJ\u000E\u0010\u001A\u001A\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0004\u001A\u00028\u00022\b\b\u0002\u0010\u0005\u001A\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\u001CJ\u0014\u0010\u001D\u001A\u00020\u00142\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FHÖ\u0083\u0004J\n\u0010 \u001A\u00020!HÖ\u0081\u0004J\n\u0010\"\u001A\u00020#HÖ\u0081\u0004R\u0016\u0010\u0004\u001A\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001A\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\tR(\u0010\f\u001A\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R(\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010R\u001E\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0005\u001A\u00020\u0014@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2={"Landroidx/lifecycle/FastSafeIterableMap$Entry;", "K", "V", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "next", "getNext", "()Landroidx/lifecycle/FastSafeIterableMap$Entry;", "setNext", "(Landroidx/lifecycle/FastSafeIterableMap$Entry;)V", "prev", "getPrev", "setPrev", "", "isRemoved", "()Z", "markRemoved", "", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/lifecycle/FastSafeIterableMap$Entry;", "equals", "other", "", "hashCode", "", "toString", "", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class Entry implements Map$Entry, KMappedMarker {
        private boolean isRemoved;
        private final Object key;
        private Entry next;
        private Entry prev;
        private final Object value;

        public Entry(Object arg1, Object arg2) {
            super();
            this.key = arg1;
            this.value = arg2;
        }

        public final Object component1() {
            return this.key;
        }

        public final Object component2() {
            return this.value;
        }

        public final Entry copy(Object arg1, Object arg2) {
            return new Entry(arg1, arg2);
        }

        public static Entry copy$default(Entry arg0, Object arg1, Object arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.key;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.value;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Entry)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Entry)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.key, ((Entry)arg5).key)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.value, ((Entry)arg5).value)) {
                return 0;
            }

            return 1;
        }

        public Object getKey() {
            return this.key;
        }

        public final Entry getNext() {
            return this.next;
        }

        public final Entry getPrev() {
            return this.prev;
        }

        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            Object v0 = this.key;
            int v1 = 0;
            int v0_1 = v0 == null ? 0 : v0.hashCode();
            v0_1 *= 0x1F;
            Object v2 = this.value;
            if(v2 == null) {
            }
            else {
                v1 = v2.hashCode();
            }

            return v0_1 + v1;
        }

        public final boolean isRemoved() {
            return this.isRemoved;
        }

        public final void markRemoved() {
            this.isRemoved = true;
        }

        public final void setNext(Entry arg1) {
            this.next = arg1;
        }

        public final void setPrev(Entry arg1) {
            this.prev = arg1;
        }

        public Object setValue(Object arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public String toString() {
            return "Entry(key=" + this.key + ", value=" + this.value + ")";
        }
    }

    private Entry head;
    private final MutableScatterMap map;
    private Entry tail;

    public FastSafeIterableMap() {
        super();
        this.map = new MutableScatterMap(0, 1, null);
    }

    public final Map$Entry ceil(Object arg2) {
        Map$Entry v1_2;
        Intrinsics.checkNotNullParameter(arg2, "key");
        Object v1 = this.map.get(arg2);
        if(v1 != null) {
            Entry v1_1 = ((Entry)v1).getPrev();
        }
        else {
            v1_2 = null;
        }

        return v1_2;
    }

    public final boolean contains(Object arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.map.containsKey(arg2);
    }

    public final Map$Entry first() {
        Entry v1 = this.head;
        if(v1 != null) {
            return ((Map$Entry)v1);
        }

        throw new NoSuchElementException("Collection is empty.");
    }

    public final void forEachReversed(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "action");
        Entry v1;
        for(v1 = this.tail; v1 != null; v1 = v1.getPrev()) {
            if(!v1.isRemoved()) {
                arg2.invoke(v1);
            }
        }
    }

    public final void forEachWithAdditions(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "action");
        Entry v1;
        for(v1 = this.head; v1 != null; v1 = v1.getNext()) {
            if(!v1.isRemoved()) {
                arg2.invoke(v1);
            }
        }
    }

    public final Map$Entry last() {
        Entry v1 = this.tail;
        if(v1 != null) {
            return ((Map$Entry)v1);
        }

        throw new NoSuchElementException("Collection is empty.");
    }

    public final Map$Entry lastOrNull() {
        return this.tail;
    }

    public final Object putIfAbsent(Object arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        Object v0 = this.map.get(arg2);
        if(v0 != null) {
            return ((Entry)v0).getValue();
        }

        Entry v0_1 = new Entry(arg2, arg3);
        this.map.set(arg2, v0_1);
        Entry v2 = this.tail;
        if(v2 == null) {
            this.head = v0_1;
            this.tail = v0_1;
        }
        else {
            if(v2 != null) {
                v2.setNext(v0_1);
            }

            v0_1.setPrev(this.tail);
            this.tail = v0_1;
        }

        return null;
    }

    public final Object remove(Object arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        arg3 = this.map.remove(arg3);
        if(arg3 == null) {
            return null;
        }

        if(((Entry)arg3).getPrev() == null) {
            this.head = ((Entry)arg3).getNext();
        }
        else {
            Entry v0 = ((Entry)arg3).getPrev();
            if(v0 != null) {
                v0.setNext(((Entry)arg3).getNext());
            }
        }

        if(((Entry)arg3).getNext() == null) {
            this.tail = ((Entry)arg3).getPrev();
        }
        else {
            Entry v2 = ((Entry)arg3).getNext();
            if(v2 != null) {
                v2.setPrev(((Entry)arg3).getPrev());
            }
        }

        ((Entry)arg3).markRemoved();
        return ((Entry)arg3).getValue();
    }

    public final int size() {
        return this.map.getSize();
    }
}

