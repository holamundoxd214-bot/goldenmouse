package kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000E\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0011\n\u0002\u0010\u000E\n\u0002\b\u0015\b\u0000\u0018\u0000 Q*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0003QRSB\u0013\bF\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0086\u0080\u0004J\n\u0010\u0014\u001A\u00020\u0015H\u0082\u0080\u0004J\n\u0010\u0019\u001A\u00020\u0011H\u0096\u0080\u0004J\u0017\u0010\u001A\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\tH\u0096\u0082\u0004¢\u0006\u0002\u0010\u001CJ\u001F\u0010\u001D\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\t2\u0006\u0010\u001E\u001A\u00028\u0000H\u0096\u0082\b¢\u0006\u0002\u0010\u001FJ\u0017\u0010 \u001A\u00020\t2\u0006\u0010\u001E\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010!J\u0017\u0010\"\u001A\u00020\t2\u0006\u0010\u001E\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010!J\u0010\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00000$H\u0096\u0082\u0004J\u0010\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000&H\u0096\u0080\u0004J\u0018\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000&2\u0006\u0010\u001B\u001A\u00020\tH\u0096\u0080\u0004J\u0017\u0010\'\u001A\u00020\u00112\u0006\u0010\u001E\u001A\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010(J\u001F\u0010\'\u001A\u00020)2\u0006\u0010\u001B\u001A\u00020\t2\u0006\u0010\u001E\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010*J\u0018\u0010+\u001A\u00020\u00112\f\u0010,\u001A\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0080\bJ \u0010+\u001A\u00020\u00112\u0006\u0010\u001B\u001A\u00020\t2\f\u0010,\u001A\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0080\bJ\n\u0010.\u001A\u00020)H\u0096\u0080\u0004J\u0017\u0010/\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\tH\u0097\u0080\b¢\u0006\u0002\u0010\u001CJ\u0017\u00100\u001A\u00020\u00112\u0006\u0010\u001E\u001A\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010(J\u0018\u00101\u001A\u00020\u00112\f\u0010,\u001A\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0080\bJ\u0018\u00102\u001A\u00020\u00112\f\u0010,\u001A\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0080\bJ \u00103\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u00104\u001A\u00020\t2\u0006\u00105\u001A\u00020\tH\u0096\u0080\u0004J\'\u00106\u001A\b\u0012\u0004\u0012\u0002H70\r\"\u0004\b\u0001\u001072\f\u00108\u001A\b\u0012\u0004\u0012\u0002H70\rH\u0016¢\u0006\u0002\u00109J\u0015\u00106\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\rH\u0016¢\u0006\u0002\u0010:J\u0014\u0010;\u001A\u00020\u00112\b\u0010<\u001A\u0004\u0018\u00010\u0015H\u0096\u0082\u0004J\n\u0010=\u001A\u00020\tH\u0096\u0080\u0004J\n\u0010>\u001A\u00020?H\u0096\u0080\u0004J\n\u0010@\u001A\u00020)H\u0082\u0080\u0004J\n\u0010A\u001A\u00020)H\u0082\u0080\u0004J\u0012\u0010B\u001A\u00020)2\u0006\u0010C\u001A\u00020\tH\u0082\u0080\u0004J\u0012\u0010D\u001A\u00020)2\u0006\u0010E\u001A\u00020\tH\u0082\u0080\u0004J\u0016\u0010F\u001A\u00020\u00112\n\u0010<\u001A\u0006\u0012\u0002\b\u00030\u0013H\u0082\u0080\u0004J\u001A\u0010G\u001A\u00020)2\u0006\u0010H\u001A\u00020\t2\u0006\u0010C\u001A\u00020\tH\u0082\u0080\u0004J\u001F\u0010I\u001A\u00020)2\u0006\u0010H\u001A\u00020\t2\u0006\u0010\u001E\u001A\u00028\u0000H\u0082\u0080\u0004¢\u0006\u0002\u0010*J(\u0010J\u001A\u00020)2\u0006\u0010H\u001A\u00020\t2\f\u0010,\u001A\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010C\u001A\u00020\tH\u0082\u0080\u0004J\u0017\u0010K\u001A\u00028\u00002\u0006\u0010H\u001A\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010\u001CJ\u001A\u0010L\u001A\u00020)2\u0006\u0010M\u001A\u00020\t2\u0006\u0010N\u001A\u00020\tH\u0082\u0080\u0004J0\u0010O\u001A\u00020\t2\u0006\u0010M\u001A\u00020\t2\u0006\u0010N\u001A\u00020\t2\f\u0010,\u001A\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010P\u001A\u00020\u0011H\u0082\u0080\u0004R\u0017\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\u000ER\u000F\u0010\u000F\u001A\u00020\tX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0010\u001A\u00020\u0011X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0016\u001A\u00020\t8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006T"}, d2={"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initialCapacity", "", "<init>", "(I)V", "backing", "", "[Ljava/lang/Object;", "length", "isReadOnly", "", "build", "", "writeReplace", "", "size", "getSize", "()I", "isEmpty", "get", "index", "(I)Ljava/lang/Object;", "set", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "iterator", "", "listIterator", "", "add", "(Ljava/lang/Object;)Z", "", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "removeAt", "remove", "removeAll", "retainAll", "subList", "fromIndex", "toIndex", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "registerModification", "checkIsMutable", "ensureExtraCapacity", "n", "ensureCapacityInternal", "minCapacity", "contentEquals", "insertAtInternal", "i", "addAtInternal", "addAllInternal", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainOrRemoveAllInternal", "retain", "Companion", "Itr", "BuilderSubList", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class ListBuilder extends AbstractMutableList implements Serializable, List, RandomAccess, KMutableList {
    @Metadata(d1={"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\b\u0011\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001TBE\bF\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\u000E\u0010\r\u001A\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00010\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0013\u001A\u00020\u0014H\u0082\u0080\u0004J\u0012\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0082\u0080\u0004J\n\u0010\u001C\u001A\u00020\u001DH\u0096\u0080\u0004J\u0017\u0010\u001E\u001A\u00028\u00012\u0006\u0010\u001F\u001A\u00020\u000BH\u0096\u0082\u0004¢\u0006\u0002\u0010 J\u001F\u0010!\u001A\u00028\u00012\u0006\u0010\u001F\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00028\u0001H\u0096\u0082\b¢\u0006\u0002\u0010#J\u0017\u0010$\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010%J\u0017\u0010&\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010%J\u0010\u0010\'\u001A\b\u0012\u0004\u0012\u00028\u00010(H\u0096\u0082\u0004J\u0010\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010*H\u0096\u0080\u0004J\u0018\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010*2\u0006\u0010\u001F\u001A\u00020\u000BH\u0096\u0080\u0004J\u0017\u0010+\u001A\u00020\u001D2\u0006\u0010\"\u001A\u00028\u0001H\u0096\u0080\b¢\u0006\u0002\u0010,J\u001F\u0010+\u001A\u00020\u00162\u0006\u0010\u001F\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010-J\u0018\u0010.\u001A\u00020\u001D2\f\u0010/\u001A\b\u0012\u0004\u0012\u00028\u000100H\u0096\u0080\bJ \u0010.\u001A\u00020\u001D2\u0006\u0010\u001F\u001A\u00020\u000B2\f\u0010/\u001A\b\u0012\u0004\u0012\u00028\u000100H\u0096\u0080\bJ\n\u00101\u001A\u00020\u0016H\u0096\u0080\u0004J\u0017\u00102\u001A\u00028\u00012\u0006\u0010\u001F\u001A\u00020\u000BH\u0097\u0080\b¢\u0006\u0002\u0010 J\u0017\u00103\u001A\u00020\u001D2\u0006\u0010\"\u001A\u00028\u0001H\u0096\u0080\b¢\u0006\u0002\u0010,J\u0018\u00104\u001A\u00020\u001D2\f\u0010/\u001A\b\u0012\u0004\u0012\u00028\u000100H\u0096\u0080\bJ\u0018\u00105\u001A\u00020\u001D2\f\u0010/\u001A\b\u0012\u0004\u0012\u00028\u000100H\u0096\u0080\bJ \u00106\u001A\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u00107\u001A\u00020\u000B2\u0006\u00108\u001A\u00020\u000BH\u0096\u0080\u0004J\'\u00109\u001A\b\u0012\u0004\u0012\u0002H:0\t\"\u0004\b\u0002\u0010:2\f\u0010;\u001A\b\u0012\u0004\u0012\u0002H:0\tH\u0016¢\u0006\u0002\u0010<J\u0015\u00109\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\tH\u0016¢\u0006\u0002\u0010=J\u0014\u0010>\u001A\u00020\u001D2\b\u0010?\u001A\u0004\u0018\u00010\u0014H\u0096\u0082\u0004J\n\u0010@\u001A\u00020\u000BH\u0096\u0080\u0004J\n\u0010A\u001A\u00020BH\u0096\u0080\u0004J\n\u0010C\u001A\u00020\u0016H\u0082\u0080\u0004J\n\u0010D\u001A\u00020\u0016H\u0082\u0080\u0004J\n\u0010E\u001A\u00020\u0016H\u0082\u0080\u0004J\u0016\u0010H\u001A\u00020\u001D2\n\u0010?\u001A\u0006\u0012\u0002\b\u00030IH\u0082\u0080\u0004J\u001F\u0010J\u001A\u00020\u00162\u0006\u0010K\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00028\u0001H\u0082\u0080\u0004¢\u0006\u0002\u0010-J(\u0010L\u001A\u00020\u00162\u0006\u0010K\u001A\u00020\u000B2\f\u0010/\u001A\b\u0012\u0004\u0012\u00028\u0001002\u0006\u0010M\u001A\u00020\u000BH\u0082\u0080\u0004J\u0017\u0010N\u001A\u00028\u00012\u0006\u0010K\u001A\u00020\u000BH\u0082\u0080\u0004¢\u0006\u0002\u0010 J\u001A\u0010O\u001A\u00020\u00162\u0006\u0010P\u001A\u00020\u000B2\u0006\u0010Q\u001A\u00020\u000BH\u0082\u0080\u0004J0\u0010R\u001A\u00020\u000B2\u0006\u0010P\u001A\u00020\u000B2\u0006\u0010Q\u001A\u00020\u000B2\f\u0010/\u001A\b\u0012\u0004\u0012\u00028\u0001002\u0006\u0010S\u001A\u00020\u001DH\u0082\u0080\u0004R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00010\tX\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\u0012R\u000F\u0010\n\u001A\u00020\u000BX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\f\u001A\u00020\u000BX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001A\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00010\u000FX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0019\u001A\u00020\u000B8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0015\u0010F\u001A\u00020\u001D8BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\bF\u0010G¨\u0006U"}, d2={"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "backing", "", "offset", "", "length", "parent", "root", "Lkotlin/collections/builders/ListBuilder;", "<init>", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "writeReplace", "", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "size", "getSize", "()I", "isEmpty", "", "get", "index", "(I)Ljava/lang/Object;", "set", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "iterator", "", "listIterator", "", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "removeAt", "remove", "removeAll", "retainAll", "subList", "fromIndex", "toIndex", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "registerModification", "checkForComodification", "checkIsMutable", "isReadOnly", "()Z", "contentEquals", "", "addAtInternal", "i", "addAllInternal", "n", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainOrRemoveAllInternal", "retain", "Itr", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class BuilderSubList extends AbstractMutableList implements Serializable, List, RandomAccess, KMutableList {
        @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001F\bF\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000B\u001A\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001A\u00020\fH\u0096\u0082\u0004J\n\u0010\u000E\u001A\u00020\u0006H\u0096\u0080\u0004J\n\u0010\u000F\u001A\u00020\u0006H\u0096\u0080\u0004J\u000F\u0010\u0010\u001A\u00028\u0002H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0011J\u000F\u0010\u0012\u001A\u00028\u0002H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00028\u0002H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00028\u0002H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0016J\n\u0010\u0018\u001A\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0019\u001A\u00020\u0014H\u0082\u0080\u0004R\u0015\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0005\u001A\u00020\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\t\u001A\u00020\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Lkotlin/collections/builders/ListBuilder$BuilderSubList$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "index", "", "<init>", "(Lkotlin/collections/builders/ListBuilder$BuilderSubList;I)V", "lastIndex", "expectedModCount", "hasPrevious", "", "hasNext", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "set", "", "element", "(Ljava/lang/Object;)V", "add", "remove", "checkForComodification", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Itr implements ListIterator, KMutableListIterator {
            private int expectedModCount;
            private int index;
            private int lastIndex;
            private final BuilderSubList list;

            public Itr(BuilderSubList arg2, int arg3) {
                Intrinsics.checkNotNullParameter(arg2, "list");
                super();
                this.list = arg2;
                this.index = arg3;
                this.lastIndex = -1;
                this.expectedModCount = arg2.modCount;
            }

            public void add(Object arg4) {
                this.checkForComodification();
                BuilderSubList v0 = this.list;
                int v1 = this.index;
                this.index = v1 + 1;
                v0.add(v1, arg4);
                this.lastIndex = -1;
                this.expectedModCount = this.list.modCount;
            }

            private final void checkForComodification() {
                if(this.list.root.modCount == this.expectedModCount) {
                    return;
                }

                throw new ConcurrentModificationException();
            }

            public boolean hasNext() {
                if(this.index < this.list.length) {
                    return 1;
                }

                return 0;
            }

            public boolean hasPrevious() {
                if(this.index > 0) {
                    return 1;
                }

                return 0;
            }

            public Object next() {
                this.checkForComodification();
                if(this.index < this.list.length) {
                    int v0 = this.index;
                    this.index = v0 + 1;
                    this.lastIndex = v0;
                    return this.list.backing[this.list.offset + this.lastIndex];
                }

                throw new NoSuchElementException();
            }

            public int nextIndex() {
                return this.index;
            }

            public Object previous() {
                this.checkForComodification();
                int v0 = this.index;
                if(v0 > 0) {
                    --v0;
                    this.index = v0;
                    this.lastIndex = v0;
                    return this.list.backing[this.list.offset + this.lastIndex];
                }

                throw new NoSuchElementException();
            }

            public int previousIndex() {
                return this.index - 1;
            }

            public void remove() {
                this.checkForComodification();
                int v0 = this.lastIndex;
                int v1 = -1;
                if(v0 != v1) {
                    this.list.removeAt(v0);
                    this.index = this.lastIndex;
                    this.lastIndex = v1;
                    this.expectedModCount = this.list.modCount;
                    return;
                }

                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }

            public void set(Object arg3) {
                this.checkForComodification();
                int v0 = this.lastIndex;
                if(v0 != -1) {
                    this.list.set(v0, arg3);
                    return;
                }

                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
        }

        private Object[] backing;
        private int length;
        private final int offset;
        private final BuilderSubList parent;
        private final ListBuilder root;

        public BuilderSubList(Object[] arg2, int arg3, int arg4, BuilderSubList arg5, ListBuilder arg6) {
            Intrinsics.checkNotNullParameter(arg2, "backing");
            Intrinsics.checkNotNullParameter(arg6, "root");
            super();
            this.backing = arg2;
            this.offset = arg3;
            this.length = arg4;
            this.parent = arg5;
            this.root = arg6;
            this.modCount = arg6.modCount;
        }

        public static final Object[] access$getBacking$p(BuilderSubList arg0) {
            return arg0.backing;
        }

        public static final int access$getLength$p(BuilderSubList arg0) {
            return arg0.length;
        }

        public static final int access$getModCount$p$s1462993667(BuilderSubList arg0) {
            return arg0.modCount;
        }

        public static final int access$getOffset$p(BuilderSubList arg0) {
            return arg0.offset;
        }

        public static final ListBuilder access$getRoot$p(BuilderSubList arg0) {
            return arg0.root;
        }

        public void add(int arg3, Object arg4) {
            this.checkIsMutable();
            this.checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(arg3, this.length);
            this.addAtInternal(this.offset + arg3, arg4);
        }

        public boolean add(Object arg3) {
            this.checkIsMutable();
            this.checkForComodification();
            this.addAtInternal(this.offset + this.length, arg3);
            return 1;
        }

        public boolean addAll(int arg3, Collection arg4) {
            Intrinsics.checkNotNullParameter(arg4, "elements");
            this.checkIsMutable();
            this.checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(arg3, this.length);
            int v0 = arg4.size();
            this.addAllInternal(this.offset + arg3, arg4, v0);
            if(v0 > 0) {
                return 1;
            }

            return 0;
        }

        public boolean addAll(Collection arg4) {
            Intrinsics.checkNotNullParameter(arg4, "elements");
            this.checkIsMutable();
            this.checkForComodification();
            int v0 = arg4.size();
            this.addAllInternal(this.offset + this.length, arg4, v0);
            if(v0 > 0) {
                return 1;
            }

            return 0;
        }

        private final void addAllInternal(int arg2, Collection arg3, int arg4) {
            this.registerModification();
            BuilderSubList v0 = this.parent;
            if(v0 != null) {
                v0.addAllInternal(arg2, arg3, arg4);
            }
            else {
                this.root.addAllInternal(arg2, arg3, arg4);
            }

            this.backing = this.root.backing;
            this.length += arg4;
        }

        private final void addAtInternal(int arg2, Object arg3) {
            this.registerModification();
            BuilderSubList v0 = this.parent;
            if(v0 != null) {
                v0.addAtInternal(arg2, arg3);
            }
            else {
                this.root.addAtInternal(arg2, arg3);
            }

            this.backing = this.root.backing;
            ++this.length;
        }

        private final void checkForComodification() {
            if(this.root.modCount == this.modCount) {
                return;
            }

            throw new ConcurrentModificationException();
        }

        private final void checkIsMutable() {
            if(!this.isReadOnly()) {
                return;
            }

            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.checkIsMutable();
            this.checkForComodification();
            this.removeRangeInternal(this.offset, this.length);
        }

        private final boolean contentEquals(List arg3) {
            return ListBuilderKt.access$subarrayContentEquals(this.backing, this.offset, this.length, arg3);
        }

        public boolean equals(Object arg2) {
            this.checkForComodification();
            if((((BuilderSubList)arg2)) != this && (!(arg2 instanceof List) || !this.contentEquals(((List)arg2)))) {
                return 0;
            }

            return 1;
        }

        public Object get(int arg3) {
            this.checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this.length);
            return this.backing[this.offset + arg3];
        }

        public int getSize() {
            this.checkForComodification();
            return this.length;
        }

        public int hashCode() {
            this.checkForComodification();
            return ListBuilderKt.access$subarrayContentHashCode(this.backing, this.offset, this.length);
        }

        public int indexOf(Object arg4) {
            this.checkForComodification();
            int v0;
            for(v0 = 0; v0 < this.length; ++v0) {
                if(Intrinsics.areEqual(this.backing[this.offset + v0], arg4)) {
                    return v0;
                }
            }

            return -1;
        }

        public boolean isEmpty() {
            this.checkForComodification();
            if(this.length == 0) {
                return 1;
            }

            return 0;
        }

        private final boolean isReadOnly() {
            return this.root.isReadOnly;
        }

        public Iterator iterator() {
            return this.listIterator(0);
        }

        public int lastIndexOf(Object arg4) {
            this.checkForComodification();
            int v0;
            for(v0 = this.length - 1; v0 >= 0; --v0) {
                if(Intrinsics.areEqual(this.backing[this.offset + v0], arg4)) {
                    return v0;
                }
            }

            return -1;
        }

        public ListIterator listIterator(int arg3) {
            this.checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(arg3, this.length);
            return new Itr(this, arg3);
        }

        public ListIterator listIterator() {
            return this.listIterator(0);
        }

        private final void readObject(ObjectInputStream arg1) {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final void registerModification() {
            ++this.modCount;
        }

        public boolean remove(Object arg1) {
            this.checkIsMutable();
            this.checkForComodification();
            int v1 = this.indexOf(arg1);
            if(v1 >= 0) {
                this.removeAt(v1);
            }

            if(v1 >= 0) {
                return 1;
            }

            return 0;
        }

        public boolean removeAll(Collection arg4) {
            Intrinsics.checkNotNullParameter(arg4, "elements");
            this.checkIsMutable();
            this.checkForComodification();
            if(this.retainOrRemoveAllInternal(this.offset, this.length, arg4, false) > 0) {
                return 1;
            }

            return 0;
        }

        @IgnorableReturnValue public Object removeAt(int arg3) {
            this.checkIsMutable();
            this.checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this.length);
            return this.removeAtInternal(this.offset + arg3);
        }

        private final Object removeAtInternal(int arg2) {
            this.registerModification();
            BuilderSubList v0 = this.parent;
            Object v2 = v0 != null ? v0.removeAtInternal(arg2) : this.root.removeAtInternal(arg2);
            --this.length;
            return v2;
        }

        private final void removeRangeInternal(int arg2, int arg3) {
            if(arg3 > 0) {
                this.registerModification();
            }

            BuilderSubList v0 = this.parent;
            if(v0 != null) {
                v0.removeRangeInternal(arg2, arg3);
            }
            else {
                this.root.removeRangeInternal(arg2, arg3);
            }

            this.length -= arg3;
        }

        public boolean retainAll(Collection arg4) {
            Intrinsics.checkNotNullParameter(arg4, "elements");
            this.checkIsMutable();
            this.checkForComodification();
            if(this.retainOrRemoveAllInternal(this.offset, this.length, arg4, true) > 0) {
                return 1;
            }

            return 0;
        }

        private final int retainOrRemoveAllInternal(int arg2, int arg3, Collection arg4, boolean arg5) {
            BuilderSubList v0 = this.parent;
            arg2 = v0 != null ? v0.retainOrRemoveAllInternal(arg2, arg3, arg4, arg5) : this.root.retainOrRemoveAllInternal(arg2, arg3, arg4, arg5);
            if(arg2 > 0) {
                this.registerModification();
            }

            this.length -= arg2;
            return arg2;
        }

        public Object set(int arg3, Object arg4) {
            this.checkIsMutable();
            this.checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this.length);
            Object[] v0 = this.backing;
            int v2 = this.offset;
            Object v1 = v0[v2 + arg3];
            v0[v2 + arg3] = arg4;
            return v1;
        }

        public List subList(int arg9, int arg10) {
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(arg9, arg10, this.length);
            return new BuilderSubList(this.backing, this.offset + arg9, arg10 - arg9, this, this.root);
        }

        public Object[] toArray() {
            this.checkForComodification();
            return ArraysKt.copyOfRange(this.backing, this.offset, this.length + this.offset);
        }

        public Object[] toArray(Object[] arg5) {
            Intrinsics.checkNotNullParameter(arg5, "array");
            this.checkForComodification();
            int v0 = arg5.length;
            int v1 = this.length;
            Object[] v2 = this.backing;
            if(v0 < v1) {
                Object[] v4 = Arrays.copyOfRange(v2, this.offset, v1 + this.offset, arg5.getClass());
                Intrinsics.checkNotNullExpressionValue(v4, "copyOfRange(...)");
                return v4;
            }

            ArraysKt.copyInto(v2, arg5, 0, this.offset, v1 + this.offset);
            return CollectionsKt.terminateCollectionToArray(this.length, arg5);
        }

        public String toString() {
            this.checkForComodification();
            return ListBuilderKt.access$subarrayContentToString(this.backing, this.offset, this.length, ((Collection)this));
        }

        private final Object writeReplace() {
            if(this.isReadOnly()) {
                return new SerializedCollection(((Collection)this), 0);
            }

            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }
    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Lkotlin/collections/builders/ListBuilder$Companion;", "", "<init>", "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001F\bF\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000B\u001A\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001A\u00020\fH\u0096\u0082\u0004J\n\u0010\u000E\u001A\u00020\u0006H\u0096\u0080\u0004J\n\u0010\u000F\u001A\u00020\u0006H\u0096\u0080\u0004J\u000F\u0010\u0010\u001A\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0011J\u000F\u0010\u0012\u001A\u00028\u0001H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0016J\n\u0010\u0018\u001A\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0019\u001A\u00020\u0014H\u0082\u0080\u0004R\u0015\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0005\u001A\u00020\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\t\u001A\u00020\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "<init>", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "expectedModCount", "hasPrevious", "", "hasNext", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "set", "", "element", "(Ljava/lang/Object;)V", "add", "remove", "checkForComodification", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class kotlin.collections.builders.ListBuilder$Itr implements ListIterator, KMutableListIterator {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder list;

        public kotlin.collections.builders.ListBuilder$Itr(ListBuilder arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg2, "list");
            super();
            this.list = arg2;
            this.index = arg3;
            this.lastIndex = -1;
            this.expectedModCount = arg2.modCount;
        }

        public void add(Object arg4) {
            this.checkForComodification();
            ListBuilder v0 = this.list;
            int v1 = this.index;
            this.index = v1 + 1;
            v0.add(v1, arg4);
            this.lastIndex = -1;
            this.expectedModCount = this.list.modCount;
        }

        private final void checkForComodification() {
            if(this.list.modCount == this.expectedModCount) {
                return;
            }

            throw new ConcurrentModificationException();
        }

        public boolean hasNext() {
            if(this.index < this.list.length) {
                return 1;
            }

            return 0;
        }

        public boolean hasPrevious() {
            if(this.index > 0) {
                return 1;
            }

            return 0;
        }

        public Object next() {
            this.checkForComodification();
            if(this.index < this.list.length) {
                int v0 = this.index;
                this.index = v0 + 1;
                this.lastIndex = v0;
                return this.list.backing[this.lastIndex];
            }

            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.index;
        }

        public Object previous() {
            this.checkForComodification();
            int v0 = this.index;
            if(v0 > 0) {
                --v0;
                this.index = v0;
                this.lastIndex = v0;
                return this.list.backing[this.lastIndex];
            }

            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public void remove() {
            this.checkForComodification();
            int v0 = this.lastIndex;
            int v1 = -1;
            if(v0 != v1) {
                this.list.removeAt(v0);
                this.index = this.lastIndex;
                this.lastIndex = v1;
                this.expectedModCount = this.list.modCount;
                return;
            }

            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        public void set(Object arg3) {
            this.checkForComodification();
            int v0 = this.lastIndex;
            if(v0 != -1) {
                this.list.set(v0, arg3);
                return;
            }

            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private static final Companion Companion;
    private static final ListBuilder Empty;
    private Object[] backing;
    private boolean isReadOnly;
    private int length;

    static {
        ListBuilder.Companion = new Companion(null);
        ListBuilder v0 = new ListBuilder(0);
        v0.isReadOnly = true;
        ListBuilder.Empty = v0;
    }

    public ListBuilder(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 10;
        }

        this(arg1);
    }

    public ListBuilder(int arg1) {
        super();
        this.backing = ListBuilderKt.arrayOfUninitializedElements(arg1);
    }

    public ListBuilder() {
        this(0, 1, null);
    }

    public static final void access$addAllInternal(ListBuilder arg0, int arg1, Collection arg2, int arg3) {
        arg0.addAllInternal(arg1, arg2, arg3);
    }

    public static final void access$addAtInternal(ListBuilder arg0, int arg1, Object arg2) {
        arg0.addAtInternal(arg1, arg2);
    }

    public static final Object[] access$getBacking$p(ListBuilder arg0) {
        return arg0.backing;
    }

    public static final int access$getLength$p(ListBuilder arg0) {
        return arg0.length;
    }

    public static final int access$getModCount$p$s-2084097795(ListBuilder arg0) {
        return arg0.modCount;
    }

    public static final boolean access$isReadOnly$p(ListBuilder arg0) {
        return arg0.isReadOnly;
    }

    public static final Object access$removeAtInternal(ListBuilder arg0, int arg1) {
        return arg0.removeAtInternal(arg1);
    }

    public static final void access$removeRangeInternal(ListBuilder arg0, int arg1, int arg2) {
        arg0.removeRangeInternal(arg1, arg2);
    }

    public static final int access$retainOrRemoveAllInternal(ListBuilder arg0, int arg1, int arg2, Collection arg3, boolean arg4) {
        return arg0.retainOrRemoveAllInternal(arg1, arg2, arg3, arg4);
    }

    public void add(int arg3, Object arg4) {
        this.checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(arg3, this.length);
        this.addAtInternal(arg3, arg4);
    }

    public boolean add(Object arg2) {
        this.checkIsMutable();
        this.addAtInternal(this.length, arg2);
        return 1;
    }

    public boolean addAll(int arg3, Collection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        this.checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(arg3, this.length);
        int v0 = arg4.size();
        this.addAllInternal(arg3, arg4, v0);
        if(v0 > 0) {
            return 1;
        }

        return 0;
    }

    public boolean addAll(Collection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "elements");
        this.checkIsMutable();
        int v0 = arg3.size();
        this.addAllInternal(this.length, arg3, v0);
        if(v0 > 0) {
            return 1;
        }

        return 0;
    }

    private final void addAllInternal(int arg5, Collection arg6, int arg7) {
        this.registerModification();
        this.insertAtInternal(arg5, arg7);
        Iterator v6 = arg6.iterator();
        int v0;
        for(v0 = 0; v0 < arg7; ++v0) {
            this.backing[arg5 + v0] = v6.next();
        }
    }

    private final void addAtInternal(int arg2, Object arg3) {
        this.registerModification();
        this.insertAtInternal(arg2, 1);
        this.backing[arg2] = arg3;
    }

    public final List build() {
        this.checkIsMutable();
        this.isReadOnly = true;
        if(this.length > 0) {
            return this;
        }

        return ListBuilder.Empty;
    }

    private final void checkIsMutable() {
        if(!this.isReadOnly) {
            return;
        }

        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.checkIsMutable();
        this.removeRangeInternal(0, this.length);
    }

    private final boolean contentEquals(List arg3) {
        return ListBuilderKt.access$subarrayContentEquals(this.backing, 0, this.length, arg3);
    }

    private final void ensureCapacityInternal(int arg3) {
        if(arg3 >= 0) {
            if(arg3 > this.backing.length) {
                this.backing = ListBuilderKt.copyOfUninitializedElements(this.backing, AbstractList.Companion.newCapacity$kotlin_stdlib(this.backing.length, arg3));
            }

            return;
        }

        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int arg2) {
        this.ensureCapacityInternal(this.length + arg2);
    }

    public boolean equals(Object arg2) {
        if((((ListBuilder)arg2)) != this && (!(arg2 instanceof List) || !this.contentEquals(((List)arg2)))) {
            return 0;
        }

        return 1;
    }

    public Object get(int arg3) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this.length);
        return this.backing[arg3];
    }

    public int getSize() {
        return this.length;
    }

    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.backing, 0, this.length);
    }

    public int indexOf(Object arg3) {
        int v0;
        for(v0 = 0; v0 < this.length; ++v0) {
            if(Intrinsics.areEqual(this.backing[v0], arg3)) {
                return v0;
            }
        }

        return -1;
    }

    private final void insertAtInternal(int arg4, int arg5) {
        this.ensureExtraCapacity(arg5);
        ArraysKt.copyInto(this.backing, this.backing, arg4 + arg5, arg4, this.length);
        this.length += arg5;
    }

    public boolean isEmpty() {
        if(this.length == 0) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return this.listIterator(0);
    }

    public int lastIndexOf(Object arg3) {
        int v0;
        for(v0 = this.length - 1; v0 >= 0; --v0) {
            if(Intrinsics.areEqual(this.backing[v0], arg3)) {
                return v0;
            }
        }

        return -1;
    }

    public ListIterator listIterator(int arg3) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(arg3, this.length);
        return new kotlin.collections.builders.ListBuilder$Itr(this, arg3);
    }

    public ListIterator listIterator() {
        return this.listIterator(0);
    }

    private final void registerModification() {
        ++this.modCount;
    }

    public boolean remove(Object arg1) {
        this.checkIsMutable();
        int v1 = this.indexOf(arg1);
        if(v1 >= 0) {
            this.removeAt(v1);
        }

        if(v1 >= 0) {
            return 1;
        }

        return 0;
    }

    public boolean removeAll(Collection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "elements");
        this.checkIsMutable();
        if(this.retainOrRemoveAllInternal(0, this.length, arg3, false) > 0) {
            return 1;
        }

        return 0;
    }

    @IgnorableReturnValue public Object removeAt(int arg3) {
        this.checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this.length);
        return this.removeAtInternal(arg3);
    }

    private final Object removeAtInternal(int arg5) {
        this.registerModification();
        Object[] v0 = this.backing;
        Object v1 = v0[arg5];
        ArraysKt.copyInto(v0, v0, arg5, arg5 + 1, this.length);
        ListBuilderKt.resetAt(this.backing, this.length - 1);
        --this.length;
        return v1;
    }

    private final void removeRangeInternal(int arg4, int arg5) {
        if(arg5 > 0) {
            this.registerModification();
        }

        ArraysKt.copyInto(this.backing, this.backing, arg4, arg4 + arg5, this.length);
        ListBuilderKt.resetRange(this.backing, this.length - arg5, this.length);
        this.length -= arg5;
    }

    public boolean retainAll(Collection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        this.checkIsMutable();
        if(this.retainOrRemoveAllInternal(0, this.length, arg4, true) > 0) {
            return 1;
        }

        return 0;
    }

    private final int retainOrRemoveAllInternal(int arg6, int arg7, Collection arg8, boolean arg9) {
        Object[] v2;
        int v0 = 0;
        int v1 = 0;
        while(true) {
            v2 = this.backing;
            if(v0 >= arg7) {
                break;
            }

            int v3 = arg6 + v0;
            if(arg8.contains(v2[v3]) == arg9) {
                ++v0;
                this.backing[v1 + arg6] = this.backing[v3];
                ++v1;
                continue;
            }

            ++v0;
        }

        int v8 = arg7 - v1;
        ArraysKt.copyInto(v2, v2, arg6 + v1, arg7 + arg6, this.length);
        ListBuilderKt.resetRange(this.backing, this.length - v8, this.length);
        if(v8 > 0) {
            this.registerModification();
        }

        this.length -= v8;
        return v8;
    }

    public Object set(int arg3, Object arg4) {
        this.checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this.length);
        Object[] v2 = this.backing;
        Object v0 = v2[arg3];
        v2[arg3] = arg4;
        return v0;
    }

    public List subList(int arg9, int arg10) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(arg9, arg10, this.length);
        return new BuilderSubList(this.backing, arg9, arg10 - arg9, null, this);
    }

    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.backing, 0, this.length);
    }

    public Object[] toArray(Object[] arg5) {
        Intrinsics.checkNotNullParameter(arg5, "array");
        int v0 = arg5.length;
        int v1 = this.length;
        Object[] v2 = this.backing;
        if(v0 < v1) {
            Object[] v4 = Arrays.copyOfRange(v2, 0, v1, arg5.getClass());
            Intrinsics.checkNotNullExpressionValue(v4, "copyOfRange(...)");
            return v4;
        }

        ArraysKt.copyInto(v2, arg5, 0, 0, v1);
        return CollectionsKt.terminateCollectionToArray(this.length, arg5);
    }

    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.backing, 0, this.length, ((Collection)this));
    }

    private final Object writeReplace() {
        if(this.isReadOnly) {
            return new SerializedCollection(((Collection)this), 0);
        }

        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }
}

