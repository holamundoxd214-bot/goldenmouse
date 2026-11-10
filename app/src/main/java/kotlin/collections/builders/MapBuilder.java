package kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap$Entry;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001F\n\u0002\b\u0003\n\u0002\u0010\'\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b#\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u0084\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\f\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001BG\bB\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010B\t\bV¢\u0006\u0004\b\u000F\u0010\u0011B\u0011\bV\u0012\u0006\u0010\u0012\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0013J\u0016\u0010%\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&H\u0086\u0080\u0004J\n\u0010\'\u001A\u00020(H\u0082\u0080\u0004J\u0012\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,H\u0082\u0080\u0004J\n\u0010-\u001A\u00020!H\u0096\u0080\u0004J\u0017\u0010.\u001A\u00020!2\u0006\u0010/\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u00100J\u0017\u00101\u001A\u00020!2\u0006\u0010\u0017\u001A\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u00100J\u0019\u00102\u001A\u0004\u0018\u00018\u00012\u0006\u0010/\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u00103J!\u00104\u001A\u0004\u0018\u00018\u00012\u0006\u0010/\u001A\u00028\u00002\u0006\u0010\u0017\u001A\u00028\u0001H\u0096\u0080\b¢\u0006\u0002\u00105J \u00106\u001A\u00020*2\u0014\u00107\u001A\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&H\u0096\u0080\u0004J\u0019\u00108\u001A\u0004\u0018\u00018\u00012\u0006\u0010/\u001A\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u00103J\n\u00109\u001A\u00020*H\u0096\u0080\u0004J\u0014\u0010E\u001A\u00020!2\b\u0010F\u001A\u0004\u0018\u00010(H\u0096\u0082\u0004J\n\u0010G\u001A\u00020\rH\u0096\u0080\u0004J\n\u0010H\u001A\u00020IH\u0096\u0080\u0004J\n\u0010N\u001A\u00020*H\u0082\u0080\u0004J\u000F\u0010O\u001A\u00020*H\u0080\u0080\u0004¢\u0006\u0002\bPJ\u0012\u0010Q\u001A\u00020*2\u0006\u0010R\u001A\u00020\rH\u0082\u0080\u0004J\u0012\u0010S\u001A\u00020!2\u0006\u0010T\u001A\u00020\rH\u0082\u0080\u0004J\u0012\u0010U\u001A\u00020*2\u0006\u0010V\u001A\u00020\rH\u0082\u0080\u0004J\u0015\u0010W\u001A\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0082\u0080\u0004¢\u0006\u0002\u0010XJ\u0017\u0010Y\u001A\u00020\r2\u0006\u0010/\u001A\u00028\u0000H\u0082\u0080\u0004¢\u0006\u0002\u0010ZJ\u0012\u0010[\u001A\u00020*2\u0006\u0010\\\u001A\u00020!H\u0082\u0080\u0004J\u0012\u0010]\u001A\u00020*2\u0006\u0010^\u001A\u00020\rH\u0082\u0080\u0004J\u0012\u0010_\u001A\u00020!2\u0006\u0010`\u001A\u00020\rH\u0082\u0080\u0004J\u0017\u0010a\u001A\u00020\r2\u0006\u0010/\u001A\u00028\u0000H\u0082\u0080\u0004¢\u0006\u0002\u0010ZJ\u0017\u0010b\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00028\u0001H\u0082\u0080\u0004¢\u0006\u0002\u0010ZJ\u0019\u0010c\u001A\u00020\r2\u0006\u0010/\u001A\u00028\u0000H\u0080\u0080\u0004¢\u0006\u0004\bd\u0010ZJ\u0019\u0010e\u001A\u00020!2\u0006\u0010/\u001A\u00028\u0000H\u0080\u0080\u0004¢\u0006\u0004\bf\u00100J\u0012\u0010g\u001A\u00020*2\u0006\u0010h\u001A\u00020\rH\u0082\u0080\u0004J\u0012\u0010i\u001A\u00020*2\u0006\u0010j\u001A\u00020\rH\u0082\u0080\u0004J#\u0010k\u001A\u00020!2\u0012\u0010l\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010mH\u0080\u0080\u0004¢\u0006\u0002\bnJ\u001A\u0010o\u001A\u00020!2\u000E\u0010F\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030&H\u0082\u0080\u0004J\u001B\u0010p\u001A\u00020!2\n\u0010q\u001A\u0006\u0012\u0002\b\u00030rH\u0080\u0080\u0004¢\u0006\u0002\bsJ\u001E\u0010t\u001A\u00020!2\u0012\u0010l\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010mH\u0082\u0080\u0004J$\u0010u\u001A\u00020!2\u0018\u00107\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010m0rH\u0083\u0080\bJ#\u0010v\u001A\u00020!2\u0012\u0010l\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010mH\u0080\u0080\u0004¢\u0006\u0002\bwJ\u0019\u0010x\u001A\u00020!2\u0006\u0010y\u001A\u00028\u0001H\u0080\u0080\u0004¢\u0006\u0004\bz\u00100J\u001B\u0010{\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010|H\u0080\u0080\u0004¢\u0006\u0002\b}J\u001C\u0010~\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u007FH\u0080\u0080\u0004¢\u0006\u0003\b\u0080\u0001J\u001E\u0010\u0081\u0001\u001A\u000F\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0082\u0001H\u0080\u0080\u0004¢\u0006\u0003\b\u0083\u0001R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\b\u001A\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007X\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\u0014R\u000F\u0010\t\u001A\u00020\nX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000B\u001A\u00020\nX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\f\u001A\u00020\rX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000E\u001A\u00020\rX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0015\u001A\u00020\rX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0016\u001A\u00020\rX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u001F\u0010\u0018\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\r@RX\u0096\u008E\b¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0017\u0010\u001B\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001CX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0017\u0010\u001D\u001A\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001EX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u001D\u0010\u001F\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010 X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u001F\u0010\"\u001A\u00020!2\u0006\u0010\u0017\u001A\u00020!@BX\u0080\u008E\b¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$R\u001B\u0010:\u001A\b\u0012\u0004\u0012\u00028\u00000;8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b<\u0010=R\u001B\u0010>\u001A\b\u0012\u0004\u0012\u00028\u00010?8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b@\u0010AR\'\u0010B\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0;8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\bD\u0010=R\u0015\u0010J\u001A\u00020\r8@X\u0080\u0084\b¢\u0006\u0006\u001A\u0004\bK\u0010\u001AR\u0015\u0010L\u001A\u00020\r8BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\bM\u0010\u001A¨\u0006\u008A\u0001"}, d2={"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "", "length", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "()V", "initialCapacity", "(I)V", "[Ljava/lang/Object;", "hashShift", "modCount", "value", "size", "getSize", "()I", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "", "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "build", "", "writeReplace", "", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "isEmpty", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "clear", "keys", "", "getKeys", "()Ljava/util/Set;", "values", "", "getValues", "()Ljava/util/Collection;", "entries", "", "getEntries", "equals", "other", "hashCode", "toString", "", "capacity", "getCapacity$kotlin_stdlib", "hashSize", "getHashSize", "registerModification", "checkIsMutable", "checkIsMutable$kotlin_stdlib", "ensureExtraCapacity", "n", "shouldCompact", "extraCapacity", "ensureCapacity", "minCapacity", "allocateValuesArray", "()[Ljava/lang/Object;", "hash", "(Ljava/lang/Object;)I", "compact", "updateHashArray", "rehash", "newHashSize", "putRehash", "i", "findKey", "findValue", "addKey", "addKey$kotlin_stdlib", "removeKey", "removeKey$kotlin_stdlib", "removeEntryAt", "index", "removeHashAt", "removedHash", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "contentEquals", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "putEntry", "putAllEntries", "removeEntry", "removeEntry$kotlin_stdlib", "removeValue", "element", "removeValue$kotlin_stdlib", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "Companion", "Itr", "KeysItr", "ValuesItr", "EntriesItr", "EntryRef", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class MapBuilder implements Serializable, Map, KMutableMap {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0005H\u0082\u0080\u0004J\u0012\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u0005H\u0082\u0080\u0004R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\b\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R!\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B0\nX\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0012"}, d2={"Lkotlin/collections/builders/MapBuilder$Companion;", "", "<init>", "()V", "MAGIC", "", "INITIAL_CAPACITY", "INITIAL_MAX_PROBE_DISTANCE", "TOMBSTONE", "Empty", "Lkotlin/collections/builders/MapBuilder;", "", "getEmpty$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final int access$computeHashSize(Companion arg0, int arg1) {
            return arg0.computeHashSize(arg1);
        }

        public static final int access$computeShift(Companion arg0, int arg1) {
            return arg0.computeShift(arg1);
        }

        private final int computeHashSize(int arg1) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(arg1, 1) * 3);
        }

        private final int computeShift(int arg1) {
            return Integer.numberOfLeadingZeros(arg1) + 1;
        }

        public final MapBuilder getEmpty$kotlin_stdlib() {
            return MapBuilder.Empty;
        }
    }

    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010\'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u001D\bF\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000BH\u0096\u0082\u0004J\u000F\u0010\f\u001A\u00020\rH\u0080\u0080\u0004¢\u0006\u0002\b\u000EJ\u0016\u0010\u000F\u001A\u00020\u00102\n\u0010\u0011\u001A\u00060\u0012j\u0002`\u0013H\u0086\u0080\u0004¨\u0006\u0014"}, d2={"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class EntriesItr extends Itr implements Iterator, KMutableIterator {
        public EntriesItr(MapBuilder arg2) {
            Intrinsics.checkNotNullParameter(arg2, "map");
            super(arg2);
        }

        public Object next() {
            return this.next();
        }

        public EntryRef next() {
            this.checkForComodification$kotlin_stdlib();
            if(this.getIndex$kotlin_stdlib() < this.getMap$kotlin_stdlib().length) {
                int v0 = this.getIndex$kotlin_stdlib();
                this.setIndex$kotlin_stdlib(v0 + 1);
                this.setLastIndex$kotlin_stdlib(v0);
                EntryRef v0_1 = new EntryRef(this.getMap$kotlin_stdlib(), this.getLastIndex$kotlin_stdlib());
                this.initNext$kotlin_stdlib();
                return v0_1;
            }

            throw new NoSuchElementException();
        }

        public final void nextAppendString(StringBuilder arg4) {
            Intrinsics.checkNotNullParameter(arg4, "sb");
            if(this.getIndex$kotlin_stdlib() < this.getMap$kotlin_stdlib().length) {
                int v0 = this.getIndex$kotlin_stdlib();
                this.setIndex$kotlin_stdlib(v0 + 1);
                this.setLastIndex$kotlin_stdlib(v0);
                Object v0_1 = this.getMap$kotlin_stdlib().keysArray[this.getLastIndex$kotlin_stdlib()];
                String v2 = "(this Map)";
                if(v0_1 == this.getMap$kotlin_stdlib()) {
                    arg4.append(v2);
                }
                else {
                    arg4.append(v0_1);
                }

                arg4.append('=');
                Object[] v0_2 = this.getMap$kotlin_stdlib().valuesArray;
                Intrinsics.checkNotNull(v0_2);
                v0_1 = v0_2[this.getLastIndex$kotlin_stdlib()];
                if(v0_1 == this.getMap$kotlin_stdlib()) {
                    arg4.append(v2);
                }
                else {
                    arg4.append(v0_1);
                }

                this.initNext$kotlin_stdlib();
                return;
            }

            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if(this.getIndex$kotlin_stdlib() < this.getMap$kotlin_stdlib().length) {
                int v0 = this.getIndex$kotlin_stdlib();
                this.setIndex$kotlin_stdlib(v0 + 1);
                this.setLastIndex$kotlin_stdlib(v0);
                Object v0_1 = this.getMap$kotlin_stdlib().keysArray[this.getLastIndex$kotlin_stdlib()];
                int v1 = 0;
                v0 = v0_1 != null ? v0_1.hashCode() : 0;
                Object[] v2 = this.getMap$kotlin_stdlib().valuesArray;
                Intrinsics.checkNotNull(v2);
                Object v2_1 = v2[this.getLastIndex$kotlin_stdlib()];
                if(v2_1 != null) {
                    v1 = v2_1.hashCode();
                }

                this.initNext$kotlin_stdlib();
                return v0 ^ v1;
            }

            throw new NoSuchElementException();
        }
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B%\bF\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0010\u001A\u00028\u00032\u0006\u0010\u0011\u001A\u00028\u0003H\u0096\u0080\b¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001A\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0018\u001A\u00020\u0019H\u0096\u0080\u0004J\n\u0010\u001A\u001A\u00020\u001BH\u0082\u0080\u0004R\u001B\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000B\u001A\u00028\u00028VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0015\u0010\u000E\u001A\u00028\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u000F\u0010\r¨\u0006\u001C"}, d2={"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", "expectedModCount", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "", "hashCode", "toString", "", "checkForComodification", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class EntryRef implements Map$Entry, Entry {
        private final int expectedModCount;
        private final int index;
        private final MapBuilder map;

        public EntryRef(MapBuilder arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg2, "map");
            super();
            this.map = arg2;
            this.index = arg3;
            this.expectedModCount = arg2.modCount;
        }

        private final void checkForComodification() {
            if(this.map.modCount == this.expectedModCount) {
                return;
            }

            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }

        public boolean equals(Object arg3) {
            if(((arg3 instanceof Map$Entry)) && (Intrinsics.areEqual(((Map$Entry)arg3).getKey(), this.getKey())) && (Intrinsics.areEqual(((Map$Entry)arg3).getValue(), this.getValue()))) {
                return 1;
            }

            return 0;
        }

        public Object getKey() {
            this.checkForComodification();
            return this.map.keysArray[this.index];
        }

        public Object getValue() {
            this.checkForComodification();
            Object[] v0 = this.map.valuesArray;
            Intrinsics.checkNotNull(v0);
            return v0[this.index];
        }

        public int hashCode() {
            Object v0 = this.getKey();
            int v1 = 0;
            int v0_1 = v0 != null ? v0.hashCode() : 0;
            Object v2 = this.getValue();
            if(v2 != null) {
                v1 = v2.hashCode();
            }

            return v0_1 ^ v1;
        }

        public Object setValue(Object arg3) {
            this.checkForComodification();
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] v0 = this.map.allocateValuesArray();
            int v2 = this.index;
            Object v1 = v0[v2];
            v0[v2] = arg3;
            return v1;
        }

        public String toString() {
            return this.getKey() + '=' + this.getValue();
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001D\bF\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\u0014\u001A\u00020\u0015H\u0080\u0080\u0004¢\u0006\u0002\b\u0016J\n\u0010\u0017\u001A\u00020\u0018H\u0086\u0080\u0004J\n\u0010\u0019\u001A\u00020\u0015H\u0086\u0080\u0004J\u000F\u0010\u001A\u001A\u00020\u0015H\u0080\u0080\u0004¢\u0006\u0002\b\u001BR!\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001B\u0010\n\u001A\u00020\u000BX\u0080\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001B\u0010\u0010\u001A\u00020\u000BX\u0080\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u000F\u0010\u0013\u001A\u00020\u000BX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "index", "", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "expectedModCount", "initNext", "", "initNext$kotlin_stdlib", "hasNext", "", "remove", "checkForComodification", "checkForComodification$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public class Itr {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final MapBuilder map;

        public Itr(MapBuilder arg2) {
            Intrinsics.checkNotNullParameter(arg2, "map");
            super();
            this.map = arg2;
            this.lastIndex = -1;
            this.expectedModCount = arg2.modCount;
            this.initNext$kotlin_stdlib();
        }

        public final void checkForComodification$kotlin_stdlib() {
            if(this.map.modCount == this.expectedModCount) {
                return;
            }

            throw new ConcurrentModificationException();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        public final MapBuilder getMap$kotlin_stdlib() {
            return this.map;
        }

        public final boolean hasNext() {
            if(this.index < this.map.length) {
                return 1;
            }

            return 0;
        }

        public final void initNext$kotlin_stdlib() {
            while(this.index < this.map.length) {
                int[] v0 = this.map.presenceArray;
                int v1 = this.index;
                if(v0[v1] >= 0) {
                    return;
                }

                this.index = v1 + 1;
            }
        }

        public final void remove() {
            this.checkForComodification$kotlin_stdlib();
            int v1 = -1;
            if(this.lastIndex != v1) {
                this.map.checkIsMutable$kotlin_stdlib();
                this.map.removeEntryAt(this.lastIndex);
                this.lastIndex = v1;
                this.expectedModCount = this.map.modCount;
                return;
            }

            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }

        public final void setIndex$kotlin_stdlib(int arg1) {
            this.index = arg1;
        }

        public final void setLastIndex$kotlin_stdlib(int arg1) {
            this.lastIndex = arg1;
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u001D\bF\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00028\u0002H\u0096\u0082\u0004¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class KeysItr extends Itr implements Iterator, KMutableIterator {
        public KeysItr(MapBuilder arg2) {
            Intrinsics.checkNotNullParameter(arg2, "map");
            super(arg2);
        }

        public Object next() {
            this.checkForComodification$kotlin_stdlib();
            if(this.getIndex$kotlin_stdlib() < this.getMap$kotlin_stdlib().length) {
                int v0 = this.getIndex$kotlin_stdlib();
                this.setIndex$kotlin_stdlib(v0 + 1);
                this.setLastIndex$kotlin_stdlib(v0);
                Object v0_1 = this.getMap$kotlin_stdlib().keysArray[this.getLastIndex$kotlin_stdlib()];
                this.initNext$kotlin_stdlib();
                return v0_1;
            }

            throw new NoSuchElementException();
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u001D\bF\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00028\u0003H\u0096\u0082\u0004¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class ValuesItr extends Itr implements Iterator, KMutableIterator {
        public ValuesItr(MapBuilder arg2) {
            Intrinsics.checkNotNullParameter(arg2, "map");
            super(arg2);
        }

        public Object next() {
            this.checkForComodification$kotlin_stdlib();
            if(this.getIndex$kotlin_stdlib() < this.getMap$kotlin_stdlib().length) {
                int v0 = this.getIndex$kotlin_stdlib();
                this.setIndex$kotlin_stdlib(v0 + 1);
                this.setLastIndex$kotlin_stdlib(v0);
                Object[] v0_1 = this.getMap$kotlin_stdlib().valuesArray;
                Intrinsics.checkNotNull(v0_1);
                Object v0_2 = v0_1[this.getLastIndex$kotlin_stdlib()];
                this.initNext$kotlin_stdlib();
                return v0_2;
            }

            throw new NoSuchElementException();
        }
    }

    public static final Companion Companion = null;
    private static final MapBuilder Empty = null;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;
    private MapBuilderEntries entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private Object[] keysArray;
    private MapBuilderKeys keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private Object[] valuesArray;
    private MapBuilderValues valuesView;

    static {
        MapBuilder.Companion = new Companion(null);
        MapBuilder v0 = new MapBuilder(0);
        v0.isReadOnly = true;
        MapBuilder.Empty = v0;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int arg8) {
        this(ListBuilderKt.arrayOfUninitializedElements(arg8), null, new int[arg8], new int[Companion.access$computeHashSize(MapBuilder.Companion, arg8)], 2, 0);
    }

    private MapBuilder(Object[] arg1, Object[] arg2, int[] arg3, int[] arg4, int arg5, int arg6) {
        super();
        this.keysArray = arg1;
        this.valuesArray = arg2;
        this.presenceArray = arg3;
        this.hashArray = arg4;
        this.maxProbeDistance = arg5;
        this.length = arg6;
        this.hashShift = Companion.access$computeShift(MapBuilder.Companion, this.getHashSize());
    }

    public static final Object[] access$allocateValuesArray(MapBuilder arg0) {
        return arg0.allocateValuesArray();
    }

    public static final MapBuilder access$getEmpty$cp() {
        return MapBuilder.Empty;
    }

    public static final Object[] access$getKeysArray$p(MapBuilder arg0) {
        return arg0.keysArray;
    }

    public static final int access$getLength$p(MapBuilder arg0) {
        return arg0.length;
    }

    public static final int access$getModCount$p(MapBuilder arg0) {
        return arg0.modCount;
    }

    public static final int[] access$getPresenceArray$p(MapBuilder arg0) {
        return arg0.presenceArray;
    }

    public static final Object[] access$getValuesArray$p(MapBuilder arg0) {
        return arg0.valuesArray;
    }

    public static final void access$removeEntryAt(MapBuilder arg0, int arg1) {
        arg0.removeEntryAt(arg1);
    }

    public final int addKey$kotlin_stdlib(Object arg8) {
        int v3;
        int v2;
        int v1;
        int v0;
        this.checkIsMutable$kotlin_stdlib();
        while(true) {
        label_1:
            v0 = this.hash(arg8);
            v1 = RangesKt.coerceAtMost(this.maxProbeDistance * 2, this.getHashSize() / 2);
            v2 = 0;
            while(true) {
                v3 = this.hashArray[v0];
                if(v3 == 0) {
                    break;
                }

                if(Intrinsics.areEqual(this.keysArray[v3 - 1], arg8)) {
                    return -v3;
                }

                ++v2;
                if(v2 > v1) {
                    this.rehash(this.getHashSize() * 2);
                    goto label_1;
                }

                v3 = v0 - 1;
                if(v0 == 0) {
                    v0 = this.getHashSize() - 1;
                    continue;
                }

                v0 = v3;
            }

            if(this.length < this.getCapacity$kotlin_stdlib()) {
                break;
            }

            this.ensureExtraCapacity(1);
        }

        v1 = this.length;
        v3 = v1 + 1;
        this.length = v3;
        this.keysArray[v1] = arg8;
        this.presenceArray[v1] = v0;
        this.hashArray[v0] = v3;
        this.size = this.size() + 1;
        this.registerModification();
        if(v2 > this.maxProbeDistance) {
            this.maxProbeDistance = v2;
        }

        return v1;
    }

    private final Object[] allocateValuesArray() {
        Object[] v0 = this.valuesArray;
        if(v0 != null) {
            return v0;
        }

        v0 = ListBuilderKt.arrayOfUninitializedElements(this.getCapacity$kotlin_stdlib());
        this.valuesArray = v0;
        return v0;
    }

    public final Map build() {
        this.checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if(this.size() > 0) {
            return this;
        }

        this = MapBuilder.Empty;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return ((Map)this);
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if(!this.isReadOnly) {
            return;
        }

        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.checkIsMutable$kotlin_stdlib();
        int v0 = this.length - 1;
        if(v0 >= 0) {
            int v2;
            for(v2 = 0; true; ++v2) {
                int[] v3 = this.presenceArray;
                int v4 = v3[v2];
                if(v4 >= 0) {
                    this.hashArray[v4] = 0;
                    v3[v2] = -1;
                }

                if(v2 == v0) {
                    break;
                }
            }
        }

        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        Object[] v0_1 = this.valuesArray;
        if(v0_1 != null) {
            ListBuilderKt.resetRange(v0_1, 0, this.length);
        }

        this.size = 0;
        this.length = 0;
        this.registerModification();
    }

    private final void compact(boolean arg8) {
        int v3;
        Object[] v0 = this.valuesArray;
        int v1 = 0;
        int v2 = 0;
        while(true) {
            v3 = this.length;
            if(v1 >= v3) {
                break;
            }

            int[] v3_1 = this.presenceArray;
            int v4 = v3_1[v1];
            if(v4 >= 0) {
                this.keysArray[v2] = this.keysArray[v1];
                if(v0 != null) {
                    v0[v2] = v0[v1];
                }

                if(arg8) {
                    v3_1[v2] = v4;
                    this.hashArray[v4] = v2 + 1;
                }

                ++v2;
            }

            ++v1;
        }

        ListBuilderKt.resetRange(this.keysArray, v2, v3);
        if(v0 != null) {
            ListBuilderKt.resetRange(v0, v2, this.length);
        }

        this.length = v2;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "m");
        Iterator v3 = arg3.iterator();
        do {
            if(!v3.hasNext()) {
                return 1;
            }

            Object v0 = v3.next();
            if(v0 != null) {
                try {
                    if(this.containsEntry$kotlin_stdlib(((Map$Entry)v0))) {
                        continue;
                    }

                    return 0;
                }
                catch(ClassCastException ) {
                    return 0;
                }
            }

            return 0;
        }
        while(true);

        return 1;
    }

    public final boolean containsEntry$kotlin_stdlib(Map$Entry arg2) {
        Intrinsics.checkNotNullParameter(arg2, "entry");
        int v0 = this.findKey(arg2.getKey());
        if(v0 < 0) {
            return 0;
        }

        Object[] v1 = this.valuesArray;
        Intrinsics.checkNotNull(v1);
        return Intrinsics.areEqual(v1[v0], arg2.getValue());
    }

    public boolean containsKey(Object arg1) {
        if(this.findKey(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    public boolean containsValue(Object arg1) {
        if(this.findValue(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    private final boolean contentEquals(Map arg3) {
        if(this.size() == arg3.size() && (this.containsAllEntries$kotlin_stdlib(arg3.entrySet()))) {
            return 1;
        }

        return 0;
    }

    private final void ensureCapacity(int arg3) {
        if(arg3 >= 0) {
            if(arg3 > this.getCapacity$kotlin_stdlib()) {
                arg3 = AbstractList.Companion.newCapacity$kotlin_stdlib(this.getCapacity$kotlin_stdlib(), arg3);
                this.keysArray = ListBuilderKt.copyOfUninitializedElements(this.keysArray, arg3);
                Object[] v0 = this.valuesArray;
                v0 = v0 != null ? ListBuilderKt.copyOfUninitializedElements(v0, arg3) : null;
                this.valuesArray = v0;
                int[] v0_1 = Arrays.copyOf(this.presenceArray, arg3);
                Intrinsics.checkNotNullExpressionValue(v0_1, "copyOf(...)");
                this.presenceArray = v0_1;
                arg3 = Companion.access$computeHashSize(MapBuilder.Companion, arg3);
                if(arg3 <= this.getHashSize()) {
                    return;
                }

                this.rehash(arg3);
            }

            return;
        }

        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int arg2) {
        if(this.shouldCompact(arg2)) {
            this.compact(true);
            return;
        }

        this.ensureCapacity(this.length + arg2);
    }

    public final EntriesItr entriesIterator$kotlin_stdlib() {
        return new EntriesItr(this);
    }

    public final Set entrySet() {
        return this.getEntries();
    }

    public boolean equals(Object arg2) {
        if((((MapBuilder)arg2)) != this && (!(arg2 instanceof Map) || !this.contentEquals(((Map)arg2)))) {
            return 0;
        }

        return 1;
    }

    private final int findKey(Object arg6) {
        int v3;
        int v0 = this.hash(arg6);
        int v1 = this.maxProbeDistance;
        while(true) {
            int v2 = this.hashArray[v0];
            v3 = -1;
            if(v2 == 0) {
                return v3;
            }

            --v2;
            if(Intrinsics.areEqual(this.keysArray[v2], arg6)) {
                return v2;
            }

            v1 += v3;
            if(v1 < 0) {
                return v3;
            }

            v2 = v0 - 1;
            if(v0 == 0) {
                v0 = this.getHashSize() - 1;
                continue;
            }

            v0 = v2;
        }

        return v3;
    }

    private final int findValue(Object arg3) {
        int v0 = this.length;
        do {
        label_1:
            int v1 = -1;
            v0 += v1;
            if(v0 < 0) {
                return v1;
            }

            if(this.presenceArray[v0] < 0) {
                goto label_1;
            }

            Object[] v1_1 = this.valuesArray;
            Intrinsics.checkNotNull(v1_1);
        }
        while(!Intrinsics.areEqual(v1_1[v0], arg3));

        return v0;
    }

    public Object get(Object arg1) {
        int v1 = this.findKey(arg1);
        if(v1 < 0) {
            return null;
        }

        Object[] v0 = this.valuesArray;
        Intrinsics.checkNotNull(v0);
        return v0[v1];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    public Set getEntries() {
        MapBuilderEntries v0 = this.entriesView;
        if(v0 == null) {
            v0 = new MapBuilderEntries(this);
            this.entriesView = v0;
            return ((Set)v0);
        }

        return ((Set)v0);
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    public Set getKeys() {
        MapBuilderKeys v0 = this.keysView;
        if(v0 == null) {
            v0 = new MapBuilderKeys(this);
            this.keysView = v0;
            return ((Set)v0);
        }

        return ((Set)v0);
    }

    public int getSize() {
        return this.size;
    }

    public Collection getValues() {
        MapBuilderValues v0 = this.valuesView;
        if(v0 == null) {
            v0 = new MapBuilderValues(this);
            this.valuesView = v0;
            return ((Collection)v0);
        }

        return ((Collection)v0);
    }

    private final int hash(Object arg2) {
        int v2 = arg2 != null ? arg2.hashCode() : 0;
        return v2 * -1640531527 >>> this.hashShift;
    }

    public int hashCode() {
        EntriesItr v2 = this.entriesIterator$kotlin_stdlib();
        int v0;
        for(v0 = 0; v2.hasNext(); v0 += v2.nextHashCode$kotlin_stdlib()) {
        }

        return v0;
    }

    public boolean isEmpty() {
        if(this.size() == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    public final Set keySet() {
        return this.getKeys();
    }

    public final KeysItr keysIterator$kotlin_stdlib() {
        return new KeysItr(this);
    }

    public Object put(Object arg2, Object arg3) {
        this.checkIsMutable$kotlin_stdlib();
        int v2 = this.addKey$kotlin_stdlib(arg2);
        Object[] v1 = this.allocateValuesArray();
        if(v2 < 0) {
            v2 = -v2 - 1;
            Object v0 = v1[v2];
            v1[v2] = arg3;
            return v0;
        }

        v1[v2] = arg3;
        return null;
    }

    public void putAll(Map arg2) {
        Intrinsics.checkNotNullParameter(arg2, "from");
        this.checkIsMutable$kotlin_stdlib();
        this.putAllEntries(arg2.entrySet());
    }

    @IgnorableReturnValue private final boolean putAllEntries(Collection arg3) {
        boolean v1 = false;
        if(arg3.isEmpty()) {
            return 0;
        }

        this.ensureExtraCapacity(arg3.size());
        Iterator v3 = arg3.iterator();
        while(v3.hasNext()) {
            if(!this.putEntry(v3.next())) {
                continue;
            }

            v1 = true;
        }

        return v1;
    }

    private final boolean putEntry(Map$Entry arg5) {
        int v0 = this.addKey$kotlin_stdlib(arg5.getKey());
        Object[] v4 = this.allocateValuesArray();
        if(v0 >= 0) {
            v4[v0] = arg5.getValue();
            return 1;
        }

        v0 = -v0 - 1;
        if(!Intrinsics.areEqual(arg5.getValue(), v4[v0])) {
            v4[v0] = arg5.getValue();
            return 1;
        }

        return 0;
    }

    private final boolean putRehash(int arg6) {
        int[] v2;
        int v0 = this.hash(this.keysArray[arg6]);
        int v1 = this.maxProbeDistance;
        while(true) {
            v2 = this.hashArray;
            if(v2[v0] == 0) {
                break;
            }

            --v1;
            if(v1 < 0) {
                return 0;
            }

            int v2_1 = v0 - 1;
            if(v0 == 0) {
                v0 = this.getHashSize() - 1;
                continue;
            }

            v0 = v2_1;
        }

        v2[v0] = arg6 + 1;
        this.presenceArray[arg6] = v0;
        return 1;
    }

    private final void readObject(ObjectInputStream arg1) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final void registerModification() {
        ++this.modCount;
    }

    private final void rehash(int arg4) {
        this.registerModification();
        int v2 = 0;
        if(this.length > this.size()) {
            this.compact(false);
        }

        this.hashArray = new int[arg4];
        this.hashShift = Companion.access$computeShift(MapBuilder.Companion, arg4);
        while(true) {
            if(v2 >= this.length) {
                return;
            }

            arg4 = v2 + 1;
            if(!this.putRehash(v2)) {
                break;
            }

            v2 = arg4;
        }

        throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
    }

    public Object remove(Object arg2) {
        this.checkIsMutable$kotlin_stdlib();
        int v2 = this.findKey(arg2);
        if(v2 < 0) {
            return null;
        }

        Object[] v0 = this.valuesArray;
        Intrinsics.checkNotNull(v0);
        Object v0_1 = v0[v2];
        this.removeEntryAt(v2);
        return v0_1;
    }

    public final boolean removeEntry$kotlin_stdlib(Map$Entry arg4) {
        Intrinsics.checkNotNullParameter(arg4, "entry");
        this.checkIsMutable$kotlin_stdlib();
        int v0 = this.findKey(arg4.getKey());
        if(v0 < 0) {
            return 0;
        }

        Object[] v2 = this.valuesArray;
        Intrinsics.checkNotNull(v2);
        if(!Intrinsics.areEqual(v2[v0], arg4.getValue())) {
            return 0;
        }

        this.removeEntryAt(v0);
        return 1;
    }

    private final void removeEntryAt(int arg3) {
        ListBuilderKt.resetAt(this.keysArray, arg3);
        Object[] v0 = this.valuesArray;
        if(v0 != null) {
            ListBuilderKt.resetAt(v0, arg3);
        }

        this.removeHashAt(this.presenceArray[arg3]);
        this.presenceArray[arg3] = -1;
        this.size = this.size() - 1;
        this.registerModification();
    }

    private final void removeHashAt(int arg8) {
        int v5;
        int v4;
        while(true) {
            int v1 = arg8;
            int v2 = 0;
            do {
                int v3 = arg8 - 1;
                arg8 = arg8 == 0 ? this.getHashSize() - 1 : v3;
                int[] v3_1 = this.hashArray;
                v4 = v3_1[arg8];
                ++v2;
                if(v2 > this.maxProbeDistance) {
                    v3_1[v1] = 0;
                    return;
                }

                if(v4 == 0) {
                    v3_1[v1] = 0;
                    return;
                }

                v5 = v4 - 1;
            }
            while((this.hash(this.keysArray[v5]) - arg8 & this.getHashSize() - 1) < v2);

            this.hashArray[v1] = v4;
            this.presenceArray[v5] = v1;
        }
    }

    public final boolean removeKey$kotlin_stdlib(Object arg1) {
        this.checkIsMutable$kotlin_stdlib();
        int v1 = this.findKey(arg1);
        if(v1 < 0) {
            return 0;
        }

        this.removeEntryAt(v1);
        return 1;
    }

    public final boolean removeValue$kotlin_stdlib(Object arg1) {
        this.checkIsMutable$kotlin_stdlib();
        int v1 = this.findValue(arg1);
        if(v1 < 0) {
            return 0;
        }

        this.removeEntryAt(v1);
        return 1;
    }

    private final boolean shouldCompact(int arg4) {
        int v0 = this.getCapacity$kotlin_stdlib() - this.length;
        int v1 = this.length - this.size();
        if(v0 < arg4 && v0 + v1 >= arg4 && v1 >= this.getCapacity$kotlin_stdlib() / 4) {
            return 1;
        }

        return 0;
    }

    public final int size() {
        return this.getSize();
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(this.size() * 3 + 2);
        v0.append("{");
        EntriesItr v3 = this.entriesIterator$kotlin_stdlib();
        int v1;
        for(v1 = 0; v3.hasNext(); ++v1) {
            if(v1 > 0) {
                v0.append(", ");
            }

            v3.nextAppendString(v0);
        }

        v0.append("}");
        String v3_1 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v3_1, "toString(...)");
        return v3_1;
    }

    public final Collection values() {
        return this.getValues();
    }

    public final ValuesItr valuesIterator$kotlin_stdlib() {
        return new ValuesItr(this);
    }

    private final Object writeReplace() {
        if(this.isReadOnly) {
            return new SerializedMap(((Map)this));
        }

        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }
}

