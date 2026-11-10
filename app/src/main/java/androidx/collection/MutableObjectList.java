package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\u0010\u001C\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u000B\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003;<=B\u000F\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0000¢\u0006\u0002\u0010\u000EJ\u001D\u0010\u000B\u001A\u00020\u000F2\b\b\u0001\u0010\u0010\u001A\u00020\u00042\u0006\u0010\r\u001A\u00028\u0000¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u0012\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014J\u0019\u0010\u0012\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u001E\u0010\u0012\u001A\u00020\f2\b\b\u0001\u0010\u0010\u001A\u00020\u00042\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002J#\u0010\u0012\u001A\u00020\f2\b\b\u0001\u0010\u0010\u001A\u00020\u00042\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0017J\u001E\u0010\u0012\u001A\u00020\f2\b\b\u0001\u0010\u0010\u001A\u00020\u00042\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u0012\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u0012\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u001AJ\u0014\u0010\u0012\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u001BJ\u000E\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u001AH\u0016J\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u001EJ\u0006\u0010\u001F\u001A\u00020\u000FJ\u0011\u0010 \u001A\u00020\u000F2\u0006\u0010\u0006\u001A\u00020\u0004H\u0086\bJ\u0016\u0010!\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\"J\u0017\u0010!\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010!\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\u0002J\u001C\u0010!\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010#J\u0017\u0010!\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010!\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u001AH\u0086\u0002J\u0017\u0010!\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u001BH\u0086\u0002J\u0016\u0010$\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\"J\u0017\u0010$\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010$\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\u0002J\u001C\u0010$\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010#J\u0017\u0010$\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010$\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u001AH\u0086\u0002J\u0017\u0010$\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u001BH\u0086\u0002J\u0013\u0010%\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0000¢\u0006\u0002\u0010\u000EJ\u0014\u0010&\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010&\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014J\u0019\u0010&\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010&\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010&\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u001AJ\u0014\u0010&\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u001BJ\u0015\u0010\'\u001A\u00028\u00002\b\b\u0001\u0010\u0010\u001A\u00020\u0004¢\u0006\u0002\u0010(J/\u0010)\u001A\u00020\u000F2!\u0010*\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\f0+H\u0086\bø\u0001\u0000J\u001A\u0010.\u001A\u00020\u000F2\b\b\u0001\u0010/\u001A\u00020\u00042\b\b\u0001\u00100\u001A\u00020\u0004J%\u00101\u001A\u00020\u000F2\u0006\u0010\u0006\u001A\u00020\u00042\u000E\u00102\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001030\u0015H\u0001¢\u0006\u0002\u00104J\u0014\u00105\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0019\u00105\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u00105\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u00105\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u00105\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u001BJ \u00106\u001A\u00028\u00002\b\b\u0001\u0010\u0010\u001A\u00020\u00042\u0006\u0010\r\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00107J\u0010\u00108\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0004H\u0002J\u0010\u00109\u001A\u00020\u000F2\b\b\u0002\u0010:\u001A\u00020\u0004R\u0012\u0010\u0006\u001A\u00020\u00048Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006>"}, d2={"Landroidx/collection/MutableObjectList;", "E", "Landroidx/collection/ObjectList;", "initialCapacity", "", "(I)V", "capacity", "getCapacity", "()I", "list", "Landroidx/collection/MutableObjectList$ObjectListMutableList;", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)Z", "(I[Ljava/lang/Object;)Z", "", "", "", "Lkotlin/sequences/Sequence;", "asList", "asMutableList", "", "clear", "ensureCapacity", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeAt", "(I)Ljava/lang/Object;", "removeIf", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "removeRange", "start", "end", "resizeStorage", "oldContent", "", "(I[Ljava/lang/Object;)V", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "throwIndexOutOfBoundsInclusiveException", "trim", "minCapacity", "MutableObjectListIterator", "ObjectListMutableList", "SubList", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class MutableObjectList extends ObjectList {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001B\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001A\u00020\u000EH\u0096\u0002J\b\u0010\u000F\u001A\u00020\u000EH\u0016J\u000E\u0010\u0010\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001A\u00020\u0006H\u0016J\r\u0010\u0013\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001A\u00020\u0006H\u0016J\b\u0010\u0015\u001A\u00020\nH\u0016J\u0015\u0010\u0016\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/collection/MutableObjectList$MutableObjectListIterator;", "T", "", "list", "", "index", "", "(Ljava/util/List;I)V", "prevIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) final class MutableObjectListIterator implements ListIterator, KMutableListIterator {
        private final List list;
        private int prevIndex;

        public MutableObjectListIterator(List arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg2, "list");
            super();
            this.list = arg2;
            this.prevIndex = arg3 - 1;
        }

        public void add(Object arg3) {
            List v0 = this.list;
            int v1 = this.prevIndex + 1;
            this.prevIndex = v1;
            v0.add(v1, arg3);
        }

        public boolean hasNext() {
            if(this.prevIndex < this.list.size() - 1) {
                return 1;
            }

            return 0;
        }

        public boolean hasPrevious() {
            if(this.prevIndex >= 0) {
                return 1;
            }

            return 0;
        }

        public Object next() {
            List v0 = this.list;
            int v1 = this.prevIndex + 1;
            this.prevIndex = v1;
            return v0.get(v1);
        }

        public int nextIndex() {
            return this.prevIndex + 1;
        }

        public Object previous() {
            List v0 = this.list;
            int v1 = this.prevIndex;
            this.prevIndex = v1 - 1;
            return v0.get(v1);
        }

        public int previousIndex() {
            return this.prevIndex;
        }

        public void remove() {
            this.list.remove(this.prevIndex);
            --this.prevIndex;
        }

        public void set(Object arg2) {
            this.list.set(this.prevIndex, arg2);
        }
    }

    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u001D\u0010\n\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00072\u0006\u0010\f\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u001E\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00072\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0011\u001A\u00020\u000B2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\b\u0010\u0014\u001A\u00020\u000EH\u0016J\u0016\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\rJ\u0016\u0010\u0016\u001A\u00020\u000B2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0017\u001A\u00028\u00012\u0006\u0010\u000F\u001A\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001A\u00020\u00072\u0006\u0010\f\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001AJ\b\u0010\u001B\u001A\u00020\u000BH\u0016J\u000F\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00010\u001DH\u0096\u0002J\u0015\u0010\u001E\u001A\u00020\u00072\u0006\u0010\f\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001AJ\u000E\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010\u000F\u001A\u00020\u0007H\u0016J\u0015\u0010!\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\"\u001A\u00020\u000B2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0015\u0010#\u001A\u00028\u00012\u0006\u0010\u000F\u001A\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001A\u00020\u000B2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u001E\u0010%\u001A\u00028\u00012\u0006\u0010\u000F\u001A\u00020\u00072\u0006\u0010\f\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010&J\u001E\u0010\'\u001A\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010(\u001A\u00020\u00072\u0006\u0010)\u001A\u00020\u0007H\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006*"}, d2={"Landroidx/collection/MutableObjectList$ObjectListMutableList;", "T", "", "objectList", "Landroidx/collection/MutableObjectList;", "(Landroidx/collection/MutableObjectList;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) final class ObjectListMutableList implements List, KMutableList {
        private final MutableObjectList objectList;

        public ObjectListMutableList(MutableObjectList arg2) {
            Intrinsics.checkNotNullParameter(arg2, "objectList");
            super();
            this.objectList = arg2;
        }

        public void add(int arg1, Object arg2) {
            this.objectList.add(arg1, arg2);
        }

        public boolean add(Object arg1) {
            return this.objectList.add(arg1);
        }

        public boolean addAll(int arg2, Collection arg3) {
            Intrinsics.checkNotNullParameter(arg3, "elements");
            return this.objectList.addAll(arg2, arg3);
        }

        public boolean addAll(Collection arg2) {
            Intrinsics.checkNotNullParameter(arg2, "elements");
            return this.objectList.addAll(((Iterable)arg2));
        }

        public void clear() {
            this.objectList.clear();
        }

        public boolean contains(Object arg1) {
            return this.objectList.contains(arg1);
        }

        public boolean containsAll(Collection arg2) {
            Intrinsics.checkNotNullParameter(arg2, "elements");
            return this.objectList.containsAll(((Iterable)arg2));
        }

        public Object get(int arg2) {
            ObjectListKt.access$checkIndex(this, arg2);
            return this.objectList.get(arg2);
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        public int indexOf(Object arg1) {
            return this.objectList.indexOf(arg1);
        }

        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        public Iterator iterator() {
            return new MutableObjectListIterator(((List)this), 0);
        }

        public int lastIndexOf(Object arg1) {
            return this.objectList.lastIndexOf(arg1);
        }

        public ListIterator listIterator() {
            return new MutableObjectListIterator(((List)this), 0);
        }

        public ListIterator listIterator(int arg2) {
            return new MutableObjectListIterator(((List)this), arg2);
        }

        public final Object remove(int arg1) {
            return this.removeAt(arg1);
        }

        public boolean remove(Object arg1) {
            return this.objectList.remove(arg1);
        }

        public boolean removeAll(Collection arg2) {
            Intrinsics.checkNotNullParameter(arg2, "elements");
            return this.objectList.removeAll(((Iterable)arg2));
        }

        public Object removeAt(int arg2) {
            ObjectListKt.access$checkIndex(this, arg2);
            return this.objectList.removeAt(arg2);
        }

        public boolean retainAll(Collection arg2) {
            Intrinsics.checkNotNullParameter(arg2, "elements");
            return this.objectList.retainAll(arg2);
        }

        public Object set(int arg2, Object arg3) {
            ObjectListKt.access$checkIndex(this, arg2);
            return this.objectList.set(arg2, arg3);
        }

        public final int size() {
            return this.getSize();
        }

        public List subList(int arg2, int arg3) {
            ObjectListKt.access$checkSubIndex(((List)this), arg2, arg3);
            return new SubList(((List)this), arg2, arg3);
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(((Collection)this));
        }

        public Object[] toArray(Object[] arg2) {
            Intrinsics.checkNotNullParameter(arg2, "array");
            return CollectionToArray.toArray(((Collection)this), arg2);
        }
    }

    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000EJ\u001D\u0010\u000B\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u001E\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u00052\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0012\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u000FH\u0016J\u0016\u0010\u0016\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000EJ\u0016\u0010\u0017\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0018\u001A\u00028\u00012\u0006\u0010\u0010\u001A\u00020\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001A\u001A\u00020\u00052\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001BJ\b\u0010\u001C\u001A\u00020\fH\u0016J\u000F\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00010\u001EH\u0096\u0002J\u0015\u0010\u001F\u001A\u00020\u00052\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001BJ\u000E\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0010\u001A\u00020\u0005H\u0016J\u0015\u0010\"\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000EJ\u0016\u0010#\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010$\u001A\u00028\u00012\u0006\u0010\u0010\u001A\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010%\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u001E\u0010&\u001A\u00028\u00012\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\r\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\'J\u001E\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001A\u00020\u00052\u0006\u0010*\u001A\u00020\u0005H\u0016R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2={"Landroidx/collection/MutableObjectList$SubList;", "T", "", "list", "start", "", "end", "(Ljava/util/List;II)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) final class SubList implements List, KMutableList {
        private int end;
        private final List list;
        private final int start;

        public SubList(List arg2, int arg3, int arg4) {
            Intrinsics.checkNotNullParameter(arg2, "list");
            super();
            this.list = arg2;
            this.start = arg3;
            this.end = arg4;
        }

        public void add(int arg3, Object arg4) {
            this.list.add(arg3 + this.start, arg4);
            ++this.end;
        }

        public boolean add(Object arg4) {
            List v0 = this.list;
            int v1 = this.end;
            this.end = v1 + 1;
            v0.add(v1, arg4);
            return 1;
        }

        public boolean addAll(int arg3, Collection arg4) {
            Intrinsics.checkNotNullParameter(arg4, "elements");
            this.list.addAll(arg3 + this.start, arg4);
            this.end += arg4.size();
            if(arg4.size() > 0) {
                return 1;
            }

            return 0;
        }

        public boolean addAll(Collection arg3) {
            Intrinsics.checkNotNullParameter(arg3, "elements");
            this.list.addAll(this.end, arg3);
            this.end += arg3.size();
            if(arg3.size() > 0) {
                return 1;
            }

            return 0;
        }

        public void clear() {
            int v0 = this.end - 1;
            int v1 = this.start;
            if(v1 <= v0) {
                while(true) {
                    this.list.remove(v0);
                    if(v0 != v1) {
                        --v0;
                        continue;
                    }

                    break;
                }
            }

            this.end = this.start;
        }

        public boolean contains(Object arg4) {
            int v0 = this.start;
            int v1 = this.end;
            while(v0 < v1) {
                if(Intrinsics.areEqual(this.list.get(v0), arg4)) {
                    return 1;
                }

                ++v0;
            }

            return 0;
        }

        public boolean containsAll(Collection arg2) {
            Intrinsics.checkNotNullParameter(arg2, "elements");
            Iterator v2 = ((Iterable)arg2).iterator();
            do {
                if(!v2.hasNext()) {
                    return 1;
                }
            }
            while(this.contains(v2.next()));

            return 0;
        }

        public Object get(int arg2) {
            ObjectListKt.access$checkIndex(this, arg2);
            return this.list.get(arg2 + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        public int indexOf(Object arg4) {
            int v0 = this.start;
            int v1 = this.end;
            while(v0 < v1) {
                if(Intrinsics.areEqual(this.list.get(v0), arg4)) {
                    return v0 - this.start;
                }

                ++v0;
            }

            return -1;
        }

        public boolean isEmpty() {
            if(this.end == this.start) {
                return 1;
            }

            return 0;
        }

        public Iterator iterator() {
            return new MutableObjectListIterator(((List)this), 0);
        }

        public int lastIndexOf(Object arg4) {
            int v0 = this.end - 1;
            int v1 = this.start;
            if(v1 <= v0) {
                while(true) {
                    if(Intrinsics.areEqual(this.list.get(v0), arg4)) {
                        break;
                    }
                    else if(v0 != v1) {
                        --v0;
                        continue;
                    }

                    return -1;
                }

                return v0 - this.start;
            }

            return -1;
        }

        public ListIterator listIterator() {
            return new MutableObjectListIterator(((List)this), 0);
        }

        public ListIterator listIterator(int arg2) {
            return new MutableObjectListIterator(((List)this), arg2);
        }

        public final Object remove(int arg1) {
            return this.removeAt(arg1);
        }

        public boolean remove(Object arg4) {
            int v0 = this.start;
            int v1 = this.end;
            while(v0 < v1) {
                if(Intrinsics.areEqual(this.list.get(v0), arg4)) {
                    this.list.remove(v0);
                    --this.end;
                    return 1;
                }

                ++v0;
            }

            return 0;
        }

        public boolean removeAll(Collection arg3) {
            Intrinsics.checkNotNullParameter(arg3, "elements");
            int v0 = this.end;
            Iterator v3 = ((Iterable)arg3).iterator();
            while(v3.hasNext()) {
                this.remove(v3.next());
            }

            if(v0 != this.end) {
                return 1;
            }

            return 0;
        }

        public Object removeAt(int arg3) {
            ObjectListKt.access$checkIndex(this, arg3);
            Object v3 = this.list.remove(arg3 + this.start);
            --this.end;
            return v3;
        }

        public boolean retainAll(Collection arg5) {
            Intrinsics.checkNotNullParameter(arg5, "elements");
            int v0 = this.end;
            int v1 = v0 - 1;
            int v2 = this.start;
            if(v2 <= v1) {
                while(true) {
                    if(!arg5.contains(this.list.get(v1))) {
                        this.list.remove(v1);
                        --this.end;
                    }

                    if(v1 == v2) {
                        break;
                    }

                    --v1;
                }
            }

            if(v0 != this.end) {
                return 1;
            }

            return 0;
        }

        public Object set(int arg2, Object arg3) {
            ObjectListKt.access$checkIndex(this, arg2);
            return this.list.set(arg2 + this.start, arg3);
        }

        public final int size() {
            return this.getSize();
        }

        public List subList(int arg2, int arg3) {
            ObjectListKt.access$checkSubIndex(((List)this), arg2, arg3);
            return new SubList(((List)this), arg2, arg3);
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(((Collection)this));
        }

        public Object[] toArray(Object[] arg2) {
            Intrinsics.checkNotNullParameter(arg2, "array");
            return CollectionToArray.toArray(((Collection)this), arg2);
        }
    }

    private ObjectListMutableList list;

    public MutableObjectList() {
        this(0, 1, null);
    }

    public MutableObjectList(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 16;
        }

        this(arg1);
    }

    public MutableObjectList(int arg2) {
        super(arg2, null);
    }

    public final void add(int arg4, Object arg5) {
        if(arg4 < 0 || arg4 > this._size) {
            this.throwIndexOutOfBoundsInclusiveException(arg4);
        }
        else {
        }

        int v0 = this._size + 1;
        Object[] v1 = this.content;
        if(v1.length < v0) {
            this.resizeStorage(v0, v1);
        }

        Object[] v0_1 = this.content;
        if(arg4 != this._size) {
            ArraysKt.copyInto(v0_1, v0_1, arg4 + 1, arg4, this._size);
        }

        v0_1[arg4] = arg5;
        ++this._size;
    }

    public final boolean add(Object arg5) {
        int v0 = this._size + 1;
        Object[] v2 = this.content;
        if(v2.length < v0) {
            this.resizeStorage(v0, v2);
        }

        this.content[this._size] = arg5;
        ++this._size;
        return 1;
    }

    public final boolean addAll(int arg5, ObjectList arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        if(arg5 < 0 || arg5 > this._size) {
            this.throwIndexOutOfBoundsInclusiveException(arg5);
        }
        else {
        }

        if(arg6.isEmpty()) {
            return 0;
        }

        int v0 = this._size + arg6._size;
        Object[] v2 = this.content;
        if(v2.length < v0) {
            this.resizeStorage(v0, v2);
        }

        Object[] v0_1 = this.content;
        if(arg5 != this._size) {
            ArraysKt.copyInto(v0_1, v0_1, arg6._size + arg5, arg5, this._size);
        }

        ArraysKt.copyInto(arg6.content, v0_1, arg5, 0, arg6._size);
        this._size += arg6._size;
        return 1;
    }

    public final boolean addAll(int arg6, Collection arg7) {
        Intrinsics.checkNotNullParameter(arg7, "elements");
        if(arg6 < 0 || arg6 > this._size) {
            this.throwIndexOutOfBoundsInclusiveException(arg6);
        }
        else {
        }

        int v1 = 0;
        if(arg7.isEmpty()) {
            return 0;
        }

        int v0 = this._size + arg7.size();
        Object[] v2 = this.content;
        if(v2.length < v0) {
            this.resizeStorage(v0, v2);
        }

        Object[] v0_1 = this.content;
        if(arg6 != this._size) {
            ArraysKt.copyInto(v0_1, v0_1, arg7.size() + arg6, arg6, this._size);
        }

        Iterator v2_1 = arg7.iterator();
        while(v2_1.hasNext()) {
            Object v3 = v2_1.next();
            int v4 = v1 + 1;
            if(v1 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            v0_1[v1 + arg6] = v3;
            v1 = v4;
        }

        this._size += arg7.size();
        return 1;
    }

    public final boolean addAll(int arg11, Object[] arg12) {
        Intrinsics.checkNotNullParameter(arg12, "elements");
        if(arg11 < 0 || arg11 > this._size) {
            this.throwIndexOutOfBoundsInclusiveException(arg11);
        }
        else {
        }

        if(arg12.length == 0) {
            return 0;
        }

        int v0 = this._size + arg12.length;
        Object[] v1 = this.content;
        if(v1.length < v0) {
            this.resizeStorage(v0, v1);
        }

        Object[] v4 = this.content;
        if(arg11 != this._size) {
            ArraysKt.copyInto(v4, v4, arg12.length + arg11, arg11, this._size);
        }

        ArraysKt.copyInto$default(arg12, v4, arg11, 0, 0, 12, null);
        this._size += arg12.length;
        return 1;
    }

    public final boolean addAll(ObjectList arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.plusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(ScatterSet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.plusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.plusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(List arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.plusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.plusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.plusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public List asList() {
        return this.asMutableList();
    }

    public final List asMutableList() {
        ObjectListMutableList v0 = this.list;
        if(v0 != null) {
            return ((List)v0);
        }

        v0 = new ObjectListMutableList(this);
        this.list = v0;
        return ((List)v0);
    }

    public final void clear() {
        ArraysKt.fill(this.content, null, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int arg3) {
        Object[] v0 = this.content;
        if(v0.length < arg3) {
            this.resizeStorage(arg3, v0);
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(ObjectList arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        Object[] v0 = arg4.content;
        int v4 = arg4._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            this.remove(v0[v1]);
        }
    }

    public final void minusAssign(ScatterSet arg14) {
        Intrinsics.checkNotNullParameter(arg14, "elements");
        Object[] v0 = arg14.elements;
        long[] v14 = arg14.metadata;
        int v1 = v14.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v14[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            this.remove(v0[(v3 << 3) + v8]);
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return;
                    }
                }

                if(v3 == v1) {
                    return;
                }
            }
        }
    }

    public final void minusAssign(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            this.remove(v2.next());
        }
    }

    public final void minusAssign(Object arg1) {
        this.remove(arg1);
    }

    public final void minusAssign(List arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.remove(arg4.get(v1));
        }
    }

    public final void minusAssign(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            this.remove(v2.next());
        }
    }

    public final void minusAssign(Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.remove(arg4[v1]);
        }
    }

    public final void plusAssign(ObjectList arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        if(arg6.isEmpty()) {
            return;
        }

        int v0 = this._size + arg6._size;
        Object[] v1 = this.content;
        if(v1.length < v0) {
            this.resizeStorage(v0, v1);
        }

        ArraysKt.copyInto(arg6.content, this.content, this._size, 0, arg6._size);
        this._size += arg6._size;
    }

    public final void plusAssign(ScatterSet arg14) {
        Intrinsics.checkNotNullParameter(arg14, "elements");
        if(arg14.isEmpty()) {
        }
        else {
            int v0 = this._size + arg14.getSize();
            Object[] v1 = this.content;
            if(v1.length < v0) {
                this.resizeStorage(v0, v1);
            }

            Object[] v0_1 = arg14.elements;
            long[] v14 = arg14.metadata;
            int v1_1 = v14.length - 2;
            if(v1_1 < 0) {
                return;
            }

            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v14[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1_1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            this.add(v0_1[(v3 << 3) + v8]);
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return;
                    }
                }

                if(v3 == v1_1) {
                    return;
                }
            }
        }
    }

    public final void plusAssign(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            this.add(v2.next());
        }
    }

    public final void plusAssign(List arg7) {
        Intrinsics.checkNotNullParameter(arg7, "elements");
        if(arg7.isEmpty()) {
            return;
        }

        int v0 = this._size;
        int v1 = arg7.size() + v0;
        Object[] v2 = this.content;
        if(v2.length < v1) {
            this.resizeStorage(v1, v2);
        }

        Object[] v1_1 = this.content;
        int v2_1 = arg7.size();
        int v3;
        for(v3 = 0; v3 < v2_1; ++v3) {
            v1_1[v3 + v0] = arg7.get(v3);
        }

        this._size += arg7.size();
    }

    public final void plusAssign(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            this.add(v2.next());
        }
    }

    public final void plusAssign(Object[] arg11) {
        Intrinsics.checkNotNullParameter(arg11, "elements");
        if(arg11.length == 0) {
            return;
        }

        int v0 = this._size + arg11.length;
        Object[] v1 = this.content;
        if(v1.length < v0) {
            this.resizeStorage(v0, v1);
        }

        ArraysKt.copyInto$default(arg11, this.content, this._size, 0, 0, 12, null);
        this._size += arg11.length;
    }

    public final void plusAssign(Object arg1) {
        this.add(arg1);
    }

    public final boolean remove(Object arg1) {
        int v1 = this.indexOf(arg1);
        if(v1 >= 0) {
            this.removeAt(v1);
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(ObjectList arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.minusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(ScatterSet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.minusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.minusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(List arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.minusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.minusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(Object[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        int v0 = this._size;
        int v1 = arg6.length;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            this.remove(arg6[v3]);
        }

        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final Object removeAt(int arg5) {
        if(arg5 < 0 || arg5 >= this._size) {
            this.throwIndexOutOfBoundsExclusiveException$collection(arg5);
        }
        else {
        }

        Object[] v0 = this.content;
        Object v1 = v0[arg5];
        if(arg5 != this._size - 1) {
            ArraysKt.copyInto(v0, v0, arg5, arg5 + 1, this._size);
        }

        --this._size;
        v0[this._size] = null;
        return v1;
    }

    public final void removeIf(Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg8, "predicate");
        int v0 = this._size;
        Object[] v1 = this.content;
        int v3 = 0;
        IntRange v2 = RangesKt.until(0, this._size);
        int v4 = v2.getFirst();
        int v2_1 = v2.getLast();
        if(v4 <= v2_1) {
            while(true) {
                v1[v4 - v3] = v1[v4];
                if(arg8.invoke(v1[v4]).booleanValue()) {
                    ++v3;
                }

                if(v4 == v2_1) {
                    break;
                }

                ++v4;
            }
        }

        ArraysKt.fill(v1, null, v0 - v3, v0);
        this._size -= v3;
    }

    public final void removeRange(int arg4, int arg5) {
        String v0 = "Start (";
        if(arg4 < 0 || arg4 > this._size || arg5 < 0 || arg5 > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException(v0 + arg4 + ") and end (" + arg5 + ") must be in 0.." + this._size);
        }
        else {
        }

        if(arg5 < arg4) {
            RuntimeHelpersKt.throwIllegalArgumentException(v0 + arg4 + ") is more than end (" + arg5 + ')');
        }

        if(arg5 != arg4) {
            if(arg5 < this._size) {
                ArraysKt.copyInto(this.content, this.content, arg4, arg5, this._size);
            }

            int v0_1 = this._size - (arg5 - arg4);
            ArraysKt.fill(this.content, null, v0_1, this._size);
            this._size = v0_1;
        }
    }

    public final void resizeStorage(int arg3, Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "oldContent");
        this.content = ArraysKt.copyInto(arg4, new Object[Math.max(arg3, arg4.length * 3 / 2)], 0, 0, arg4.length);
    }

    public final boolean retainAll(ObjectList arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        int v0 = this._size;
        Object[] v1 = this.content;
        int v2;
        for(v2 = this._size - 1; -1 < v2; --v2) {
            if(!arg6.contains(v1[v2])) {
                this.removeAt(v2);
            }
        }

        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean retainAll(Iterable arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        int v0 = this._size;
        Object[] v1 = this.content;
        int v2;
        for(v2 = this._size - 1; -1 < v2; --v2) {
            if(!CollectionsKt.contains(arg6, v1[v2])) {
                this.removeAt(v2);
            }
        }

        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean retainAll(Collection arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        int v0 = this._size;
        Object[] v1 = this.content;
        int v2;
        for(v2 = this._size - 1; -1 < v2; --v2) {
            if(!arg6.contains(v1[v2])) {
                this.removeAt(v2);
            }
        }

        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean retainAll(Sequence arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        int v0 = this._size;
        Object[] v1 = this.content;
        int v2;
        for(v2 = this._size - 1; -1 < v2; --v2) {
            if(!SequencesKt.contains(arg6, v1[v2])) {
                this.removeAt(v2);
            }
        }

        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean retainAll(Object[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        int v0 = this._size;
        Object[] v1 = this.content;
        int v2;
        for(v2 = this._size - 1; -1 < v2; --v2) {
            if(ArraysKt.indexOf(arg6, v1[v2]) < 0) {
                this.removeAt(v2);
            }
        }

        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final Object set(int arg2, Object arg3) {
        if(arg2 < 0 || arg2 >= this._size) {
            this.throwIndexOutOfBoundsExclusiveException$collection(arg2);
        }
        else {
        }

        Object[] v1 = this.content;
        Object v0 = v1[arg2];
        v1[arg2] = arg3;
        return v0;
    }

    private final void throwIndexOutOfBoundsInclusiveException(int arg3) {
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index " + arg3 + " must be in 0.." + this._size);
    }

    public final void trim(int arg2) {
        arg2 = Math.max(arg2, this._size);
        if(this.content.length > arg2) {
            Object[] v2 = Arrays.copyOf(this.content, arg2);
            Intrinsics.checkNotNullExpressionValue(v2, "copyOf(...)");
            this.content = v2;
        }
    }

    public static void trim$default(MutableObjectList arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0._size;
        }

        arg0.trim(arg1);
    }
}

