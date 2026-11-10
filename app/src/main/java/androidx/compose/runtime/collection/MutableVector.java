package androidx.compose.runtime.collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0003uvwB!\b\u0001\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00028\u0000¢\u0006\u0002\u0010\u001DJ\u001B\u0010\u001A\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00028\u0000¢\u0006\u0002\u0010 J\u001C\u0010!\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u00072\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000#J\u001C\u0010!\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u00072\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0017\u0010!\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000#H\u0086\bJ\u0017\u0010!\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086\bJ\u0019\u0010!\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010$J\u001C\u0010!\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u00072\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010!\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000%J(\u0010&\u001A\u00020\u001B2\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001B0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J(\u0010)\u001A\u00020\u001B2\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001B0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\f\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EJ\u0006\u0010+\u001A\u00020\u001EJ\u0016\u0010,\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001DJ\u0014\u0010-\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000#J\u0014\u0010-\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010-\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010.\u001A\u00020\u001B2\f\u0010/\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0011\u00100\u001A\u00020\u001E2\u0006\u00101\u001A\u00020\u0007H\u0086\bJ\u0010\u00102\u001A\u00020\u001E2\u0006\u00101\u001A\u00020\u0007H\u0001J\u000B\u00103\u001A\u00028\u0000¢\u0006\u0002\u00104J-\u00103\u001A\u00028\u00002\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001B0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00105J\t\u00106\u001A\u000207H\u0081\bJ\u0010\u00106\u001A\u0002072\u0006\u00108\u001A\u000209H\u0001J\u0010\u0010:\u001A\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u00104J/\u0010:\u001A\u0004\u0018\u00018\u00002\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001B0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00105JP\u0010;\u001A\u0002H<\"\u0004\b\u0001\u0010<2\u0006\u0010=\u001A\u0002H<2\'\u0010>\u001A#\u0012\u0013\u0012\u0011H<¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H<0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010CJe\u0010D\u001A\u0002H<\"\u0004\b\u0001\u0010<2\u0006\u0010=\u001A\u0002H<2<\u0010>\u001A8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u001F\u0012\u0013\u0012\u0011H<¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H<0EH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010FJP\u0010G\u001A\u0002H<\"\u0004\b\u0001\u0010<2\u0006\u0010=\u001A\u0002H<2\'\u0010>\u001A#\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H<¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u0002H<0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010CJe\u0010H\u001A\u0002H<\"\u0004\b\u0001\u0010<2\u0006\u0010=\u001A\u0002H<2<\u0010>\u001A8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H<¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u0002H<0EH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010FJ(\u0010I\u001A\u00020\u001E2\u0012\u0010J\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001E0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J.\u0010K\u001A\u00020\u001E2\u0018\u0010J\u001A\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001E0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J(\u0010L\u001A\u00020\u001E2\u0012\u0010J\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001E0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J.\u0010M\u001A\u00020\u001E2\u0018\u0010J\u001A\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001E0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010N\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00020\u0007H\u0086\n¢\u0006\u0002\u0010OJ\u0013\u0010P\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00028\u0000¢\u0006\u0002\u0010QJ(\u0010R\u001A\u00020\u00072\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001B0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J(\u0010S\u001A\u00020\u00072\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001B0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\t\u0010T\u001A\u00020\u001BH\u0086\bJ\t\u0010U\u001A\u00020\u001BH\u0086\bJ\u000B\u0010V\u001A\u00028\u0000¢\u0006\u0002\u00104J-\u0010V\u001A\u00028\u00002\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001B0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00105J\u0013\u0010W\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00028\u0000¢\u0006\u0002\u0010QJ\u0010\u0010X\u001A\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u00104J/\u0010X\u001A\u0004\u0018\u00018\u00002\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001B0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00105J;\u0010Y\u001A\b\u0012\u0004\u0012\u0002H<0\u0005\"\u0006\b\u0001\u0010<\u0018\u00012\u0012\u0010Z\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H<0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010[JP\u0010\\\u001A\b\u0012\u0004\u0012\u0002H<0\u0005\"\u0006\b\u0001\u0010<\u0018\u00012\'\u0010Z\u001A#\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H<0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010]JM\u0010^\u001A\b\u0012\u0004\u0012\u0002H<0\u0000\"\u0006\b\u0001\u0010<\u0018\u00012)\u0010Z\u001A%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H<0?H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J8\u0010_\u001A\b\u0012\u0004\u0012\u0002H<0\u0000\"\u0006\b\u0001\u0010<\u0018\u00012\u0014\u0010Z\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H<0(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010`\u001A\u00020\u001E2\u0006\u0010\u001C\u001A\u00028\u0000H\u0086\n¢\u0006\u0002\u0010aJ\u0016\u0010b\u001A\u00020\u001E2\u0006\u0010\u001C\u001A\u00028\u0000H\u0086\n¢\u0006\u0002\u0010aJ\u0013\u0010c\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00028\u0000¢\u0006\u0002\u0010\u001DJ\u0014\u0010d\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000#J\u0014\u0010d\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010d\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000%J\u0013\u0010e\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00020\u0007¢\u0006\u0002\u0010OJ\u0016\u0010f\u001A\u00020\u001E2\u0006\u0010g\u001A\u00020\u00072\u0006\u0010h\u001A\u00020\u0007J\u0010\u0010i\u001A\u00020\u001E2\u0006\u0010j\u001A\u00020\u0007H\u0001J\u001D\u0010k\u001A\u00020\u001E2\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001B0(H\u0086\bJ\u0014\u0010l\u001A\u00020\u001B2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000%J\u001E\u0010m\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010nJ\u001E\u0010o\u001A\u00020\u001E2\u0016\u0010p\u001A\u0012\u0012\u0004\u0012\u00028\u00000qj\b\u0012\u0004\u0012\u00028\u0000`rJ(\u0010s\u001A\u00020\u00072\u0012\u0010t\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070(H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001R\"\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00058\u0000@\u0000X\u0081\u000E¢\u0006\n\n\u0002\u0010\f\u0012\u0004\b\n\u0010\u000BR\u0016\u0010\r\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001A\u00020\u00078Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001A\u00020\u00158Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006x"}, d2={"Landroidx/compose/runtime/collection/MutableVector;", "T", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "content", "", "size", "", "<init>", "([Ljava/lang/Object;I)V", "getContent$annotations", "()V", "[Ljava/lang/Object;", "list", "", "value", "getSize", "()I", "lastIndex", "getLastIndex", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "getContent", "()[Ljava/lang/Object;", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "([Ljava/lang/Object;)Z", "", "any", "predicate", "Lkotlin/Function1;", "reversedAny", "asMutableList", "clear", "contains", "containsAll", "contentEquals", "other", "ensureCapacity", "capacity", "resizeStorage", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "throwNoSuchElementException", "", "message", "", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "lastOrNull", "map", "transform", "(Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "mapIndexed", "(Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "mapIndexedNotNull", "mapNotNull", "plusAssign", "(Ljava/lang/Object;)V", "minusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "setSize", "newSize", "removeIf", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "sortWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sumBy", "selector", "VectorListIterator", "MutableVectorList", "SubList", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class MutableVector implements RandomAccess {
    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000EJ\u0016\u0010\u000F\u001A\u00020\f2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0016\u0010\u0012\u001A\u00028\u00012\u0006\u0010\u0013\u001A\u00020\bH\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001A\u00020\b2\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001A\u00020\fH\u0016J\u000F\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00010\u0019H\u0096\u0002J\u0015\u0010\u001A\u001A\u00020\b2\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u001B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000EJ\u001D\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001DJ\u001E\u0010\u001E\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\b2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0016\u0010\u001E\u001A\u00020\f2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\b\u0010\u001F\u001A\u00020\u001CH\u0016J\u000E\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0013\u001A\u00020\bH\u0016J\u0015\u0010\"\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000EJ\u0016\u0010#\u001A\u00020\f2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0015\u0010$\u001A\u00028\u00012\u0006\u0010\u0013\u001A\u00020\bH\u0016¢\u0006\u0002\u0010\u0014J\u0016\u0010%\u001A\u00020\f2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u001E\u0010&\u001A\u00028\u00012\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\r\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\'J\u001E\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001A\u00020\b2\u0006\u0010*\u001A\u00020\bH\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006+"}, d2={"Landroidx/compose/runtime/collection/MutableVector$MutableVectorList;", "T", "", "vector", "Landroidx/compose/runtime/collection/MutableVector;", "<init>", "(Landroidx/compose/runtime/collection/MutableVector;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class MutableVectorList implements List, KMutableList {
        private final MutableVector vector;

        public MutableVectorList(MutableVector arg1) {
            super();
            this.vector = arg1;
        }

        public void add(int arg1, Object arg2) {
            this.vector.add(arg1, arg2);
        }

        public boolean add(Object arg1) {
            return this.vector.add(arg1);
        }

        public boolean addAll(int arg1, Collection arg2) {
            return this.vector.addAll(arg1, arg2);
        }

        public boolean addAll(Collection arg1) {
            return this.vector.addAll(arg1);
        }

        public void clear() {
            this.vector.clear();
        }

        public boolean contains(Object arg1) {
            return this.vector.contains(arg1);
        }

        public boolean containsAll(Collection arg1) {
            return this.vector.containsAll(arg1);
        }

        public Object get(int arg2) {
            MutableVectorKt.checkIndex(this, arg2);
            return this.vector.content[arg2];
        }

        public int getSize() {
            return this.vector.getSize();
        }

        public int indexOf(Object arg1) {
            return this.vector.indexOf(arg1);
        }

        public boolean isEmpty() {
            if(this.vector.getSize() == 0) {
                return 1;
            }

            return 0;
        }

        public Iterator iterator() {
            return new VectorListIterator(((List)this), 0);
        }

        public int lastIndexOf(Object arg1) {
            return this.vector.lastIndexOf(arg1);
        }

        public ListIterator listIterator() {
            return new VectorListIterator(((List)this), 0);
        }

        public ListIterator listIterator(int arg2) {
            return new VectorListIterator(((List)this), arg2);
        }

        public final Object remove(int arg1) {
            return this.removeAt(arg1);
        }

        public boolean remove(Object arg1) {
            return this.vector.remove(arg1);
        }

        public boolean removeAll(Collection arg1) {
            return this.vector.removeAll(arg1);
        }

        public Object removeAt(int arg2) {
            MutableVectorKt.checkIndex(this, arg2);
            return this.vector.removeAt(arg2);
        }

        public boolean retainAll(Collection arg1) {
            return this.vector.retainAll(arg1);
        }

        public Object set(int arg2, Object arg3) {
            MutableVectorKt.checkIndex(this, arg2);
            return this.vector.set(arg2, arg3);
        }

        public final int size() {
            return this.getSize();
        }

        public List subList(int arg2, int arg3) {
            MutableVectorKt.checkSubIndex(((List)this), arg2, arg3);
            return new SubList(((List)this), arg2, arg3);
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(((Collection)this));
        }

        public Object[] toArray(Object[] arg1) {
            return CollectionToArray.toArray(((Collection)this), arg1);
        }
    }

    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000FJ\u0016\u0010\u0010\u001A\u00020\r2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0016\u0010\u0013\u001A\u00028\u00012\u0006\u0010\u0014\u001A\u00020\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001A\u00020\rH\u0016J\u000F\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00010\u001AH\u0096\u0002J\u0015\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u001C\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000FJ\u001D\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001EJ\u001E\u0010\u001F\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\u00052\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0016\u0010\u001F\u001A\u00020\r2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\b\u0010 \u001A\u00020\u001DH\u0016J\u000E\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00010\"H\u0016J\u0016\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00010\"2\u0006\u0010\u0014\u001A\u00020\u0005H\u0016J\u0015\u0010#\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000FJ\u0016\u0010$\u001A\u00020\r2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0015\u0010%\u001A\u00028\u00012\u0006\u0010\u0014\u001A\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0015J\u0016\u0010&\u001A\u00020\r2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u001E\u0010\'\u001A\u00028\u00012\u0006\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010(J\u001E\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010*\u001A\u00020\u00052\u0006\u0010+\u001A\u00020\u0005H\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006,"}, d2={"Landroidx/compose/runtime/collection/MutableVector$SubList;", "T", "", "list", "start", "", "end", "<init>", "(Ljava/util/List;II)V", "size", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SubList implements List, KMutableList {
        private int end;
        private final List list;
        private final int start;

        public SubList(List arg1, int arg2, int arg3) {
            super();
            this.list = arg1;
            this.start = arg2;
            this.end = arg3;
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
            this.list.addAll(arg3 + this.start, arg4);
            arg3 = arg4.size();
            this.end += arg3;
            if(arg3 > 0) {
                return 1;
            }

            return 0;
        }

        public boolean addAll(Collection arg3) {
            this.list.addAll(this.end, arg3);
            int v3 = arg3.size();
            this.end += v3;
            if(v3 > 0) {
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
            MutableVectorKt.checkIndex(this, arg2);
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
            return new VectorListIterator(((List)this), 0);
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
            return new VectorListIterator(((List)this), 0);
        }

        public ListIterator listIterator(int arg2) {
            return new VectorListIterator(((List)this), arg2);
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
            MutableVectorKt.checkIndex(this, arg3);
            Object v3 = this.list.remove(arg3 + this.start);
            --this.end;
            return v3;
        }

        public boolean retainAll(Collection arg5) {
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
            MutableVectorKt.checkIndex(this, arg2);
            return this.list.set(arg2 + this.start, arg3);
        }

        public final int size() {
            return this.getSize();
        }

        public List subList(int arg2, int arg3) {
            MutableVectorKt.checkSubIndex(((List)this), arg2, arg3);
            return new SubList(((List)this), arg2, arg3);
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(((Collection)this));
        }

        public Object[] toArray(Object[] arg1) {
            return CollectionToArray.toArray(((Collection)this), arg1);
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\t\u001A\u00020\nH\u0096\u0002J\u000E\u0010\u000B\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\fJ\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\nH\u0016J\b\u0010\u0010\u001A\u00020\u0006H\u0016J\r\u0010\u0011\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\b\u0010\u0012\u001A\u00020\u0006H\u0016J\u0015\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/collection/MutableVector$VectorListIterator;", "T", "", "list", "", "index", "", "<init>", "(Ljava/util/List;I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "hasPrevious", "nextIndex", "previous", "previousIndex", "add", "element", "(Ljava/lang/Object;)V", "set", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class VectorListIterator implements ListIterator, KMutableListIterator {
        private int index;
        private final List list;

        public VectorListIterator(List arg1, int arg2) {
            super();
            this.list = arg1;
            this.index = arg2;
        }

        public void add(Object arg3) {
            this.list.add(this.index, arg3);
            ++this.index;
        }

        public boolean hasNext() {
            if(this.index < this.list.size()) {
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
            List v0 = this.list;
            int v1 = this.index;
            this.index = v1 + 1;
            return v0.get(v1);
        }

        public int nextIndex() {
            return this.index;
        }

        public Object previous() {
            int v0 = this.index - 1;
            this.index = v0;
            return this.list.get(v0);
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public void remove() {
            int v0 = this.index - 1;
            this.index = v0;
            this.list.remove(v0);
        }

        public void set(Object arg2) {
            this.list.set(this.index, arg2);
        }
    }

    public static final int $stable = 8;
    public Object[] content;
    private List list;
    private int size;

    static {
    }

    public MutableVector(Object[] arg1, int arg2) {
        super();
        this.content = arg1;
        this.size = arg2;
    }

    public final boolean add(Object arg4) {
        int v0 = this.size + 1;
        if(this.content.length < v0) {
            this.resizeStorage(v0);
        }

        Object[] v0_1 = this.content;
        int v2 = this.size;
        v0_1[v2] = arg4;
        this.size = v2 + 1;
        return 1;
    }

    public final void add(int arg4, Object arg5) {
        int v0 = this.size + 1;
        if(this.content.length < v0) {
            this.resizeStorage(v0);
        }

        Object[] v0_1 = this.content;
        int v1 = this.size;
        if(arg4 != v1) {
            System.arraycopy(v0_1, arg4, v0_1, arg4 + 1, v1 - arg4);
        }

        v0_1[arg4] = arg5;
        ++this.size;
    }

    public final boolean addAll(int arg7, List arg8) {
        int v1 = 0;
        if(arg8.isEmpty()) {
            return 0;
        }

        int v0 = arg8.size();
        int v2 = this.size + v0;
        if(this.content.length < v2) {
            this.resizeStorage(v2);
        }

        Object[] v2_1 = this.content;
        int v3 = this.size;
        if(arg7 != v3) {
            System.arraycopy(v2_1, arg7, v2_1, arg7 + v0, v3 - arg7);
        }

        v3 = arg8.size();
        while(v1 < v3) {
            v2_1[arg7 + v1] = arg8.get(v1);
            ++v1;
        }

        this.size += v0;
        return 1;
    }

    public final boolean addAll(int arg6, MutableVector arg7) {
        int v0 = arg7.size;
        if(v0 == 0) {
            return 0;
        }

        int v2 = this.size + v0;
        if(this.content.length < v2) {
            this.resizeStorage(v2);
        }

        Object[] v2_1 = this.content;
        int v3 = this.size;
        if(arg6 != v3) {
            System.arraycopy(v2_1, arg6, v2_1, arg6 + v0, v3 - arg6);
        }

        System.arraycopy(arg7.content, 0, v2_1, arg6, v0);
        this.size += v0;
        return 1;
    }

    public final boolean addAll(int arg6, Collection arg7) {
        int v1 = 0;
        if(arg7.isEmpty()) {
            return 0;
        }

        int v0 = arg7.size();
        int v2 = this.size + v0;
        if(this.content.length < v2) {
            this.resizeStorage(v2);
        }

        Object[] v2_1 = this.content;
        int v3 = this.size;
        if(arg6 != v3) {
            System.arraycopy(v2_1, arg6, v2_1, arg6 + v0, v3 - arg6);
        }

        Iterator v7 = ((Iterable)arg7).iterator();
        while(v7.hasNext()) {
            Object v3_1 = v7.next();
            int v4 = v1 + 1;
            if(v1 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            v2_1[v1 + arg6] = v3_1;
            v1 = v4;
        }

        this.size += v0;
        return 1;
    }

    public final boolean addAll(MutableVector arg2) {
        return this.addAll(this.getSize(), arg2);
    }

    public final boolean addAll(Collection arg2) {
        return this.addAll(this.size, arg2);
    }

    public final boolean addAll(List arg2) {
        return this.addAll(this.getSize(), arg2);
    }

    public final boolean addAll(Object[] arg5) {
        int v0 = arg5.length;
        if(v0 == 0) {
            return 0;
        }

        int v2 = this.size + v0;
        if(this.content.length < v2) {
            this.resizeStorage(v2);
        }

        System.arraycopy(arg5, 0, this.content, this.size, v0);
        this.size += v0;
        return 1;
    }

    public final boolean any(Function1 arg5) {
        Object[] v0 = this.content;
        int v4 = this.getSize();
        int v2;
        for(v2 = 0; v2 < v4; ++v2) {
            if(arg5.invoke(v0[v2]).booleanValue()) {
                return 1;
            }
        }

        return 0;
    }

    public final List asMutableList() {
        List v0 = this.list;
        if(v0 == null) {
            MutableVectorList v0_1 = new MutableVectorList(this);
            this.list = ((List)v0_1);
        }

        return v0;
    }

    public final void clear() {
        Object[] v0 = this.content;
        int v1 = this.size;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            v0[v3] = null;
        }

        this.size = 0;
    }

    public final boolean contains(Object arg6) {
        int v0 = this.getSize() - 1;
        if(v0 >= 0) {
            int v3 = 0;
            while(true) {
                if(Intrinsics.areEqual(this.content[v3], arg6)) {
                    return 1;
                }
                else if(v3 != v0) {
                    ++v3;
                    continue;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    public final boolean containsAll(MutableVector arg5) {
        IntRange v0 = RangesKt.until(0, arg5.getSize());
        int v2 = v0.getFirst();
        int v0_1 = v0.getLast();
        if(v2 <= v0_1) {
            while(true) {
                if(!this.contains(arg5.content[v2])) {
                    return 0;
                }
                else if(v2 != v0_1) {
                    ++v2;
                    continue;
                }

                return 1;
            }

            return 0;
        }

        return 1;
    }

    public final boolean containsAll(Collection arg2) {
        Iterator v2 = ((Iterable)arg2).iterator();
        do {
            if(!v2.hasNext()) {
                return 1;
            }
        }
        while(this.contains(v2.next()));

        return 0;
    }

    public final boolean containsAll(List arg5) {
        int v0 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!this.contains(arg5.get(v2))) {
                return 0;
            }
        }

        return 1;
    }

    public final boolean contentEquals(MutableVector arg7) {
        if(arg7.size != this.size) {
            return 0;
        }

        int v0 = this.getSize() - 1;
        if(v0 >= 0) {
            int v3 = 0;
            while(true) {
                if(!Intrinsics.areEqual(arg7.content[v3], this.content[v3])) {
                    return 0;
                }
                else if(v3 != v0) {
                    ++v3;
                    continue;
                }

                return 1;
            }

            return 0;
        }

        return 1;
    }

    public final void ensureCapacity(int arg2) {
        if(this.content.length < arg2) {
            this.resizeStorage(arg2);
        }
    }

    public final Object first() {
        if(this.getSize() != 0) {
            return this.content[0];
        }

        this.throwNoSuchElementException("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }

    public final Object first(Function1 arg6) {
        Object[] v0 = this.content;
        int v1 = this.getSize();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = v0[v2];
            if(arg6.invoke(v3).booleanValue()) {
                return v3;
            }
        }

        this.throwNoSuchElementException("MutableVector contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    public final Object firstOrNull() {
        if(this.getSize() == 0) {
            return null;
        }

        return this.content[0];
    }

    public final Object firstOrNull(Function1 arg5) {
        Object[] v0 = this.content;
        int v4 = this.getSize();
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            Object v2 = v0[v1];
            if(arg5.invoke(v2).booleanValue()) {
                return v2;
            }
        }

        return null;
    }

    public final Object fold(Object arg4, Function2 arg5) {
        Object[] v0 = this.content;
        int v3 = this.getSize();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            arg4 = arg5.invoke(arg4, v0[v1]);
        }

        return arg4;
    }

    public final Object foldIndexed(Object arg5, Function3 arg6) {
        Object[] v0 = this.content;
        int v4 = this.getSize();
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            arg5 = arg6.invoke(Integer.valueOf(v1), arg5, v0[v1]);
        }

        return arg5;
    }

    public final Object foldRight(Object arg3, Function2 arg4) {
        int v0 = this.getSize() - 1;
        Object[] v2 = this.content;
        if(v0 >= v2.length) {
            return arg3;
        }

        while(v0 >= 0) {
            arg3 = arg4.invoke(v2[v0], arg3);
            --v0;
        }

        return arg3;
    }

    public final Object foldRightIndexed(Object arg4, Function3 arg5) {
        int v0 = this.getSize() - 1;
        Object[] v3 = this.content;
        if(v0 >= v3.length) {
            return arg4;
        }

        while(v0 >= 0) {
            arg4 = arg5.invoke(Integer.valueOf(v0), v3[v0], arg4);
            --v0;
        }

        return arg4;
    }

    public final void forEach(Function1 arg4) {
        Object[] v0 = this.content;
        int v3 = this.getSize();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            arg4.invoke(v0[v1]);
        }
    }

    public final void forEachIndexed(Function2 arg5) {
        Object[] v0 = this.content;
        int v4 = this.getSize();
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            arg5.invoke(Integer.valueOf(v1), v0[v1]);
        }
    }

    public final void forEachReversed(Function1 arg3) {
        int v0 = this.getSize() - 1;
        Object[] v2 = this.content;
        if(v0 >= v2.length) {
        }
        else {
            while(v0 >= 0) {
                arg3.invoke(v2[v0]);
                --v0;
            }
        }
    }

    public final void forEachReversedIndexed(Function2 arg4) {
        int v0 = this.getSize() - 1;
        Object[] v3 = this.content;
        if(v0 >= v3.length) {
        }
        else {
            while(v0 >= 0) {
                arg4.invoke(Integer.valueOf(v0), v3[v0]);
                --v0;
            }
        }
    }

    public final Object get(int arg1) {
        return this.content[arg1];
    }

    public final Object[] getContent() {
        return this.content;
    }

    public static void getContent$annotations() {
    }

    public final IntRange getIndices() {
        return RangesKt.until(0, this.getSize());
    }

    public final int getLastIndex() {
        return this.getSize() - 1;
    }

    public final int getSize() {
        return this.size;
    }

    public final int indexOf(Object arg4) {
        Object[] v0 = this.content;
        int v3 = this.size;
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            if(Intrinsics.areEqual(arg4, v0[v1])) {
                return v1;
            }
        }

        return -1;
    }

    public final int indexOfFirst(Function1 arg4) {
        Object[] v0 = this.content;
        int v3 = this.getSize();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            if(arg4.invoke(v0[v1]).booleanValue()) {
                return v1;
            }
        }

        return -1;
    }

    public final int indexOfLast(Function1 arg3) {
        int v0 = this.getSize() - 1;
        Object[] v2 = this.content;
        if(v0 < v2.length) {
            while(v0 >= 0) {
                if(arg3.invoke(v2[v0]).booleanValue()) {
                    return v0;
                }
                else {
                    --v0;
                    continue;
                }

                return -1;
            }
        }

        return -1;
    }

    public final boolean isEmpty() {
        if(this.getSize() == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isNotEmpty() {
        if(this.getSize() != 0) {
            return 1;
        }

        return 0;
    }

    public final Object last() {
        if(this.getSize() != 0) {
            return this.content[this.getSize() - 1];
        }

        this.throwNoSuchElementException("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }

    public final Object last(Function1 arg5) {
        int v0 = this.getSize() - 1;
        Object[] v1 = this.content;
        while(v0 >= 0) {
            Object v2 = v1[v0];
            if(arg5.invoke(v2).booleanValue()) {
                return v2;
            }

            --v0;
        }

        this.throwNoSuchElementException("MutableVector contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    public final int lastIndexOf(Object arg3) {
        int v0 = this.size - 1;
        Object[] v2 = this.content;
        while(v0 >= 0) {
            if(Intrinsics.areEqual(arg3, v2[v0])) {
                return v0;
            }

            --v0;
        }

        return -1;
    }

    public final Object lastOrNull() {
        if(this.getSize() == 0) {
            return null;
        }

        return this.content[this.getSize() - 1];
    }

    public final Object lastOrNull(Function1 arg4) {
        int v0 = this.getSize() - 1;
        Object[] v3 = this.content;
        while(v0 >= 0) {
            Object v1 = v3[v0];
            if(arg4.invoke(v1).booleanValue()) {
                return v1;
            }

            --v0;
        }

        return null;
    }

    public final Object[] map(Function1 arg6) {
        int v0 = this.getSize();
        int v2 = 0;
        Intrinsics.reifiedOperationMarker(0, "R");
        Object[] v1 = new Object[v0];
        while(v2 < v0) {
            v1[v2] = arg6.invoke(this.content[v2]);
            ++v2;
        }

        return v1;
    }

    public final Object[] mapIndexed(Function2 arg7) {
        int v0 = this.getSize();
        int v2 = 0;
        Intrinsics.reifiedOperationMarker(0, "R");
        Object[] v1 = new Object[v0];
        while(v2 < v0) {
            v1[v2] = arg7.invoke(Integer.valueOf(v2), this.content[v2]);
            ++v2;
        }

        return v1;
    }

    public final MutableVector mapIndexedNotNull(Function2 arg7) {
        int v0 = this.getSize();
        int v2 = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] v1 = new Object[v0];
        Object[] v6 = this.content;
        int v3 = 0;
        while(v2 < v0) {
            Object v4 = arg7.invoke(Integer.valueOf(v2), v6[v2]);
            if(v4 != null) {
                v1[v3] = v4;
                ++v3;
            }

            ++v2;
        }

        return new MutableVector(v1, v3);
    }

    public final MutableVector mapNotNull(Function1 arg7) {
        int v0 = this.getSize();
        int v2 = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] v1 = new Object[v0];
        Object[] v6 = this.content;
        int v3 = 0;
        while(v2 < v0) {
            Object v4 = arg7.invoke(v6[v2]);
            if(v4 != null) {
                v1[v3] = v4;
                ++v3;
            }

            ++v2;
        }

        return new MutableVector(v1, v3);
    }

    public final void minusAssign(Object arg1) {
        this.remove(arg1);
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

    public final boolean removeAll(MutableVector arg7) {
        int v0 = this.size;
        int v1 = arg7.getSize() - 1;
        if(v1 >= 0) {
            int v4 = 0;
            while(true) {
                this.remove(arg7.content[v4]);
                if(v4 != v1) {
                    ++v4;
                    continue;
                }

                break;
            }
        }

        if(v0 != this.size) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(Collection arg4) {
        if(arg4.isEmpty()) {
            return 0;
        }

        int v0 = this.size;
        Iterator v4 = ((Iterable)arg4).iterator();
        while(v4.hasNext()) {
            this.remove(v4.next());
        }

        if(v0 != this.size) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(List arg6) {
        int v0 = this.size;
        int v1 = arg6.size();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            this.remove(arg6.get(v3));
        }

        if(v0 != this.size) {
            return 1;
        }

        return 0;
    }

    public final Object removeAt(int arg5) {
        Object[] v0 = this.content;
        Object v1 = v0[arg5];
        if(arg5 != this.getSize() - 1) {
            int v2 = arg5 + 1;
            System.arraycopy(v0, v2, v0, arg5, this.size - v2);
        }

        arg5 = this.size - 1;
        this.size = arg5;
        v0[arg5] = null;
        return v1;
    }

    public final void removeIf(Function1 arg7) {
        Object[] v3;
        int v0 = this.getSize();
        int v1 = 0;
        int v2 = 0;
        while(true) {
            v3 = this.content;
            if(v1 >= v0) {
                break;
            }

            if(arg7.invoke(v3[v1]).booleanValue()) {
                ++v2;
            }
            else if(v2 > 0) {
                this.content[v1 - v2] = this.content[v1];
            }

            ++v1;
        }

        int v7 = v0 - v2;
        ArraysKt.fill(v3, null, v7, v0);
        this.setSize(v7);
    }

    public final void removeRange(int arg4, int arg5) {
        if(arg5 > arg4) {
            int v0 = this.size;
            if(arg5 < v0) {
                System.arraycopy(this.content, arg5, this.content, arg4, v0 - arg5);
            }

            v0 = this.size - (arg5 - arg4);
            arg4 = this.getSize() - 1;
            if(v0 <= arg4) {
                arg5 = v0;
                while(true) {
                    this.content[arg5] = null;
                    if(arg5 != arg4) {
                        ++arg5;
                        continue;
                    }

                    break;
                }
            }

            this.size = v0;
        }
    }

    public final void resizeStorage(int arg4) {
        Object[] v0 = this.content;
        int v1 = v0.length;
        Object[] v4 = new Object[Math.max(arg4, v1 * 2)];
        System.arraycopy(v0, 0, v4, 0, v1);
        this.content = v4;
    }

    public final boolean retainAll(Collection arg5) {
        int v0 = this.size;
        int v1;
        for(v1 = this.getSize() - 1; -1 < v1; --v1) {
            if(!arg5.contains(this.content[v1])) {
                this.removeAt(v1);
            }
        }

        if(v0 != this.size) {
            return 1;
        }

        return 0;
    }

    public final boolean reversedAny(Function1 arg4) {
        Object[] v0 = this.content;
        int v3;
        for(v3 = this.getSize() - 1; v3 >= 0; --v3) {
            if(arg4.invoke(v0[v3]).booleanValue()) {
                return 1;
            }
        }

        return 0;
    }

    public final Object set(int arg2, Object arg3) {
        Object[] v1 = this.content;
        Object v0 = v1[arg2];
        v1[arg2] = arg3;
        return v0;
    }

    public final void setSize(int arg1) {
        this.size = arg1;
    }

    public final void sortWith(Comparator arg3) {
        ArraysKt.sortWith(this.content, arg3, 0, this.size);
    }

    public final int sumBy(Function1 arg5) {
        Object[] v0 = this.content;
        int v1 = 0;
        int v2 = 0;
        while(v1 < this.getSize()) {
            v2 += arg5.invoke(v0[v1]).intValue();
            ++v1;
        }

        return v2;
    }

    public final Void throwNoSuchElementException(String arg1) {
        throw new NoSuchElementException(arg1);
    }

    public final Void throwNoSuchElementException() {
        this.throwNoSuchElementException("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }
}

