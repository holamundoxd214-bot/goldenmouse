package androidx.compose.ui.layout;

import androidx.collection.MutableOrderedScatterSet;
import androidx.collection.OrderedScatterSet;
import androidx.collection.OrderedScatterSetKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u001C\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u00012\b\u0010\t\u001A\u0004\u0018\u00010\u0001H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "", "getSlotsToRetain", "", "slotIds", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "areCompatible", "", "slotId", "reusableSlotId", "SlotIdsSet", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SubcomposeSlotReusePolicy {
    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u001E\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001B\b\u0000\u0012\u0010\b\u0002\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0018\u0010\u0011\u001A\u00020\u00102\u000E\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0016J\u0013\u0010\u0013\u001A\u00020\u00102\b\u0010\u0014\u001A\u0004\u0018\u00010\u0002H\u0096\u0002J\u0017\u0010\u0015\u001A\u00020\u00102\b\u0010\u0016\u001A\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0002\b\u0017J\u0011\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0096\u0002J\u0010\u0010\u001A\u001A\u00020\u00102\b\u0010\u0016\u001A\u0004\u0018\u00010\u0002J\u0016\u0010\u001B\u001A\u00020\u00102\u000E\u0010\u001C\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001C\u0010\u001B\u001A\u00020\u00102\u0014\u0010\u001D\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00100\u001EJ\u0016\u0010\u001F\u001A\u00020\u00102\u000E\u0010\u001C\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001C\u0010\u001F\u001A\u00020\u00102\u0014\u0010\u001D\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00100\u001EJ\u0006\u0010 \u001A\u00020!J\u000E\u0010\"\u001A\u00020!2\u0006\u0010#\u001A\u00020\fJ\u001C\u0010$\u001A\u00020!2\u0014\u0010%\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020!0\u001EJ\u001F\u0010&\u001A\u00020!2\u0014\u0010%\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020!0\u001EH\u0086\bR$\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\'"}, d2={"Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "", "", "set", "Landroidx/collection/MutableOrderedScatterSet;", "<init>", "(Landroidx/collection/MutableOrderedScatterSet;)V", "getSet$annotations", "()V", "getSet", "()Landroidx/collection/MutableOrderedScatterSet;", "size", "", "getSize", "()I", "isEmpty", "", "containsAll", "elements", "contains", "element", "add", "slotId", "add$ui", "iterator", "", "remove", "removeAll", "slotIds", "predicate", "Lkotlin/Function1;", "retainAll", "clear", "", "trimToSize", "maxSlotsToRetainForReuse", "forEach", "block", "fastForEach", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SlotIdsSet implements Collection, KMappedMarker {
        public static final int $stable = 8;
        private final MutableOrderedScatterSet set;

        static {
        }

        public SlotIdsSet() {
            this(null, 1, null);
        }

        public SlotIdsSet(MutableOrderedScatterSet arg1, int arg2, DefaultConstructorMarker arg3) {
            if((arg2 & 1) != 0) {
                arg1 = OrderedScatterSetKt.mutableOrderedScatterSetOf();
            }

            this(arg1);
        }

        public SlotIdsSet(MutableOrderedScatterSet arg1) {
            super();
            this.set = arg1;
        }

        public boolean add(Object arg1) {
            return this.add$ui(arg1);
        }

        public final boolean add$ui(Object arg1) {
            return this.set.add(arg1);
        }

        public boolean addAll(Collection arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void clear() {
            this.set.clear();
        }

        public boolean contains(Object arg1) {
            return this.set.contains(arg1);
        }

        public boolean containsAll(Collection arg3) {
            Iterator v3 = ((Iterable)arg3).iterator();
            do {
                if(!v3.hasNext()) {
                    return 1;
                }
            }
            while(this.set.contains(v3.next()));

            return 0;
        }

        public final void fastForEach(Function1 arg7) {
            MutableOrderedScatterSet v6 = this.getSet();
            Object[] v0 = ((OrderedScatterSet)v6).elements;
            long[] v1 = ((OrderedScatterSet)v6).nodes;
            int v6_1;
            for(v6_1 = ((OrderedScatterSet)v6).tail; v6_1 != 0x7FFFFFFF; v6_1 = v2) {
                int v2 = ((int)(v1[v6_1] >> 0x1F & 0x7FFFFFFF));
                arg7.invoke(v0[v6_1]);
            }
        }

        public final void forEach(Function1 arg7) {
            MutableOrderedScatterSet v6 = this.set;
            Object[] v0 = ((OrderedScatterSet)v6).elements;
            long[] v1 = ((OrderedScatterSet)v6).nodes;
            int v6_1;
            for(v6_1 = ((OrderedScatterSet)v6).tail; v6_1 != 0x7FFFFFFF; v6_1 = v2) {
                int v2 = ((int)(v1[v6_1] >> 0x1F & 0x7FFFFFFF));
                arg7.invoke(v0[v6_1]);
            }
        }

        public final MutableOrderedScatterSet getSet() {
            return this.set;
        }

        public static void getSet$annotations() {
        }

        public int getSize() {
            return this.set.getSize();
        }

        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        public Iterator iterator() {
            return this.set.asMutableSet().iterator();
        }

        public final boolean remove(Object arg1) {
            return this.set.remove(arg1);
        }

        public final boolean removeAll(Collection arg1) {
            return this.set.remove(arg1);
        }

        public final boolean removeAll(Function1 arg18) {
            SlotIdsSet v0 = this;
            int v1 = v0.set.getSize();
            MutableOrderedScatterSet v2 = v0.set;
            Object[] v3 = v2.elements;
            long[] v4 = v2.metadata;
            int v5 = v4.length - 2;
            if(v5 >= 0) {
                int v7;
                for(v7 = 0; true; ++v7) {
                    long v8 = v4[v7];
                    if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                        int v11 = 8;
                        int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                        int v12;
                        for(v12 = 0; v12 < v10; ++v12) {
                            if((0xFF & v8) < 0x80) {
                                int v13 = (v7 << 3) + v12;
                                if(arg18.invoke(v3[v13]).booleanValue()) {
                                    v2.removeElementAt(v13);
                                }
                            }

                            v8 >>= v11;
                        }

                        if(v10 != v11) {
                            break;
                        }
                    }

                    if(v7 == v5) {
                        break;
                    }
                }
            }

            if(v1 != v0.set.getSize()) {
                return 1;
            }

            return 0;
        }

        public boolean removeIf(Predicate arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final boolean retainAll(Collection arg1) {
            return this.set.retainAll(arg1);
        }

        public final boolean retainAll(Function1 arg17) {
            MutableOrderedScatterSet v0 = this.set;
            Object[] v1 = v0.elements;
            int v2 = v0.getSize();
            long[] v3 = v0.metadata;
            int v4 = v3.length - 2;
            if(v4 >= 0) {
                int v6;
                for(v6 = 0; true; ++v6) {
                    long v7 = v3[v6];
                    if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                        int v10 = 8;
                        int v9 = 8 - (~(v6 - v4) >>> 0x1F);
                        int v11;
                        for(v11 = 0; v11 < v9; ++v11) {
                            if((0xFF & v7) < 0x80) {
                                int v12 = (v6 << 3) + v11;
                                if(!arg17.invoke(v1[v12]).booleanValue()) {
                                    v0.removeElementAt(v12);
                                }
                            }

                            v7 >>= v10;
                        }

                        if(v9 != v10) {
                            break;
                        }
                    }

                    if(v6 == v4) {
                        break;
                    }
                }
            }

            if(v2 != v0.getSize()) {
                return 1;
            }

            return 0;
        }

        public final int size() {
            return this.getSize();
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(((Collection)this));
        }

        public Object[] toArray(Object[] arg1) {
            return CollectionToArray.toArray(((Collection)this), arg1);
        }

        public final void trimToSize(int arg1) {
            this.set.trimToSize(arg1);
        }
    }

    boolean areCompatible(Object arg1, Object arg2);

    void getSlotsToRetain(SlotIdsSet arg1);
}

