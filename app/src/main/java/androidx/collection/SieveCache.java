package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u001D\n\u0002\u0010\u0015\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002Bà\u0001\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001A\u00020\u0005\u00128\b\u0002\u0010\u0007\u001A2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\b\u0012%\b\u0002\u0010\r\u001A\u001F\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000E\u0012d\b\u0002\u0010\u000F\u001A^\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010¢\u0006\u0002\u0010\u0016J\r\u00103\u001A\u00020\u0015H\u0000¢\u0006\u0002\b4J&\u00105\u001A\u00020\u00132\u0018\u00106\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bH\u0086\bø\u0001\u0000J\u0006\u00107\u001A\u00020\u0013J&\u00107\u001A\u00020\u00132\u0018\u00106\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bH\u0086\bø\u0001\u0000J\u0016\u00108\u001A\u00020\u00132\u0006\u0010\u000B\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00109J\u0013\u0010:\u001A\u00020\u00132\u0006\u0010\u000B\u001A\u00028\u0000¢\u0006\u0002\u00109J\u0013\u0010;\u001A\u00020\u00132\u0006\u0010\f\u001A\u00028\u0001¢\u0006\u0002\u00109J\u0006\u0010\u001E\u001A\u00020\u0005J&\u0010\u001E\u001A\u00020\u00052\u0018\u00106\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bH\u0086\bø\u0001\u0000J\r\u0010<\u001A\u00020\u0015H\u0000¢\u0006\u0002\b=J\u0013\u0010>\u001A\u00020\u00132\b\u0010?\u001A\u0004\u0018\u00010\u0002H\u0096\u0002J\u0006\u0010@\u001A\u00020\u0015J\b\u0010A\u001A\u00020\u0005H\u0002J\u0010\u0010B\u001A\u00020\u00052\u0006\u0010C\u001A\u00020\u0005H\u0002J\u0015\u0010D\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010EJ\u0015\u0010F\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010EJ\u0010\u0010G\u001A\u00020\u00152\u0006\u0010H\u001A\u00020IH\u0002J\u0010\u0010G\u001A\u00020\u00152\u0006\u0010H\u001A\u00020+H\u0002JD\u0010J\u001A\u00020\u001526\u0010K\u001A2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00150\bH\u0086\bø\u0001\u0000J/\u0010L\u001A\u00020\u00152!\u0010K\u001A\u001D\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\u00150\u000EH\u0081\bø\u0001\u0000J/\u0010N\u001A\u00020\u00152!\u0010K\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\u00150\u000EH\u0086\bø\u0001\u0000J/\u0010O\u001A\u00020\u00152!\u0010K\u001A\u001D\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00150\u000EH\u0086\bø\u0001\u0000J\u0018\u0010P\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u000B\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010QJ\b\u0010R\u001A\u00020\u0005H\u0016J\b\u0010S\u001A\u00020\u0015H\u0002J\u0010\u0010T\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u0005H\u0002J\u0010\u0010U\u001A\u00020\u00152\u0006\u0010\u0006\u001A\u00020\u0005H\u0002J\u0006\u0010V\u001A\u00020\u0013J\u0006\u0010W\u001A\u00020\u0013J\u0011\u0010X\u001A\u00020\u00152\u0006\u0010M\u001A\u00020\u0005H\u0082\bJ\u0016\u0010Y\u001A\u00020\u00152\u0006\u0010\u000B\u001A\u00028\u0000H\u0086\n¢\u0006\u0002\u0010ZJ\u0017\u0010Y\u001A\u00020\u00152\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000[H\u0086\nJ\u0017\u0010Y\u001A\u00020\u00152\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\\H\u0086\nJ\u001E\u0010Y\u001A\u00020\u00152\u000E\u0010%\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000&H\u0086\n¢\u0006\u0002\u0010]J\u0017\u0010Y\u001A\u00020\u00152\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000^H\u0086\nJ\u0017\u0010Y\u001A\u00020\u00152\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000_H\u0086\nJ\u0011\u0010`\u001A\u00020\u00152\u0006\u0010M\u001A\u00020\u0005H\u0082\bJ\u0006\u0010a\u001A\u00020\u0013J\u001D\u0010b\u001A\u00020\u00152\u0012\u0010c\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010dH\u0086\nJ\u001D\u0010b\u001A\u00020\u00152\u0012\u0010c\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0086\nJ*\u0010b\u001A\u00020\u00152\u001A\u0010e\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010f0&H\u0086\n¢\u0006\u0002\u0010gJ\u001D\u0010b\u001A\u00020\u00152\u0012\u0010h\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010fH\u0086\nJ#\u0010b\u001A\u00020\u00152\u0018\u0010e\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010f0^H\u0086\nJ\u001D\u0010b\u001A\u00020\u00152\u0012\u0010c\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010iH\u0086\nJ#\u0010b\u001A\u00020\u00152\u0018\u0010e\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010f0_H\u0086\nJ\u001D\u0010j\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010\f\u001A\u00028\u0001¢\u0006\u0002\u0010kJ\u001A\u0010l\u001A\u00020\u00152\u0012\u0010c\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010dJ\u001A\u0010l\u001A\u00020\u00152\u0012\u0010c\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000J\'\u0010l\u001A\u00020\u00152\u001A\u0010e\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010f0&¢\u0006\u0002\u0010gJ \u0010l\u001A\u00020\u00152\u0018\u0010e\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010f0^J\u001A\u0010l\u001A\u00020\u00152\u0012\u0010c\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010iJ \u0010l\u001A\u00020\u00152\u0018\u0010e\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010f0_J\u0015\u0010m\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u000B\u001A\u00028\u0000¢\u0006\u0002\u0010QJ\u001B\u0010m\u001A\u00020\u00132\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010\f\u001A\u00028\u0001¢\u0006\u0002\u0010nJ \u0010o\u001A\u00020\u00152\u0018\u00106\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bJ\u0011\u0010p\u001A\u00020\u00152\u0006\u0010M\u001A\u00020\u0005H\u0082\bJ\u0017\u0010q\u001A\u0004\u0018\u00018\u00012\u0006\u0010M\u001A\u00020\u0005H\u0002¢\u0006\u0002\u0010rJ\u0010\u0010s\u001A\u00020\u00152\b\b\u0001\u0010\u0004\u001A\u00020\u0005J\u0015\u0010t\u001A\u00020\u00152\u0006\u0010u\u001A\u00020\u0005H\u0000¢\u0006\u0002\bvJ\u001E\u0010w\u001A\u00020\u00152\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010\f\u001A\u00028\u0001H\u0086\n¢\u0006\u0002\u0010xJ\b\u0010y\u001A\u00020zH\u0016J\u000E\u0010{\u001A\u00020\u00152\u0006\u0010\u0004\u001A\u00020\u0005R\u000E\u0010\u0017\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u001B\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001E\u001A\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\u001DR+\u0010\r\u001A\u001F\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010%\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020&8\u0000@\u0000X\u0081\u000E¢\u0006\n\n\u0002\u0010(\u0012\u0004\b\'\u0010 R\u0011\u0010\u0004\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b)\u0010\u001DR\u0018\u0010*\u001A\u00020+8\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b,\u0010 R\u000E\u0010-\u001A\u00020+X\u0082\u000E¢\u0006\u0002\n\u0000Rj\u0010\u000F\u001A^\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010.\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b/\u0010\u001DR>\u0010\u0007\u001A2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00100\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u00101\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020&8\u0000@\u0000X\u0081\u000E¢\u0006\n\n\u0002\u0010(\u0012\u0004\b2\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006|"}, d2={"Landroidx/collection/SieveCache;", "K", "", "V", "maxSize", "", "initialCapacity", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "createValueFromKey", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "oldValue", "newValue", "", "evicted", "", "(IILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "_capacity", "_count", "_maxSize", "_size", "capacity", "getCapacity", "()I", "count", "getCount$annotations", "()V", "getCount", "growthLimit", "hand", "head", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "getMaxSize", "metadata", "", "getMetadata$annotations", "nodes", "size", "getSize", "tail", "values", "getValues$annotations", "adjustStorage", "adjustStorage$collection", "all", "predicate", "any", "contains", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "dropDeletes", "dropDeletes$collection", "equals", "other", "evictAll", "findEvictionCandidate", "findFirstAvailableSlot", "hash1", "findInsertIndex", "(Ljava/lang/Object;)I", "findKeyIndex", "fixupNodes", "mapping", "", "forEach", "block", "forEachIndexed", "index", "forEachKey", "forEachValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "initializeGrowth", "initializeMetadata", "initializeStorage", "isEmpty", "isNotEmpty", "markNodeVisited", "minusAssign", "(Ljava/lang/Object;)V", "Landroidx/collection/ObjectList;", "Landroidx/collection/ScatterSet;", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "moveNodeToHead", "none", "plusAssign", "from", "Landroidx/collection/ScatterMap;", "pairs", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "pair", "", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeIf", "removeNode", "removeValueAt", "(I)Ljava/lang/Object;", "resize", "resizeStorage", "newCapacity", "resizeStorage$collection", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "", "trimToSize", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class SieveCache {
    private int _capacity;
    private int _count;
    private int _maxSize;
    private int _size;
    private final Function1 createValueFromKey;
    private int growthLimit;
    private int hand;
    private int head;
    public Object[] keys;
    public long[] metadata;
    private long[] nodes;
    private final Function4 onEntryRemoved;
    private final Function2 sizeOf;
    private int tail;
    public Object[] values;

    public SieveCache(int arg2, int arg3, Function2 arg4, Function1 arg5, Function4 arg6) {
        Intrinsics.checkNotNullParameter(arg4, "sizeOf");
        Intrinsics.checkNotNullParameter(arg5, "createValueFromKey");
        Intrinsics.checkNotNullParameter(arg6, "onEntryRemoved");
        super();
        this.sizeOf = arg4;
        this.createValueFromKey = arg5;
        this.onEntryRemoved = arg6;
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        this.nodes = SieveCacheKt.getEmptyNodes();
        this.head = 0x7FFFFFFF;
        this.tail = 0x7FFFFFFF;
        this.hand = 0x7FFFFFFF;
        int v4 = arg2 > 0 ? 1 : 0;
        if(v4 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("maxSize must be > 0");
        }

        this._maxSize = arg2;
        this.initializeStorage(ScatterMapKt.unloadedCapacity(arg3));
    }

    public SieveCache(int arg7, int arg8, Function2 arg9, Function1 arg10, Function4 arg11, int arg12, DefaultConstructorMarker arg13) {
        androidx.collection.SieveCache$3 v11;
        androidx.collection.SieveCache$2 v10;
        androidx.collection.SieveCache$1 v9;
        if((arg12 & 2) != 0) {
            arg8 = 6;
        }

        int v2 = arg8;
        if((arg12 & 4) != 0) {
            v9 = androidx.collection.SieveCache$1.INSTANCE;
        }

        Function2 v3 = ((Function2)v9);
        if((arg12 & 8) != 0) {
            v10 = androidx.collection.SieveCache$2.INSTANCE;
        }

        Function1 v4 = ((Function1)v10);
        if((arg12 & 16) != 0) {
            v11 = androidx.collection.SieveCache$3.INSTANCE;
        }

        this(arg7, v2, v3, v4, ((Function4)v11));
    }

    public final void adjustStorage$collection() {
        if(this._capacity > 8 && Long.compareUnsigned(ULong.constructor-impl(ULong.constructor-impl(((long)this.getCount())) * 0x20), ULong.constructor-impl(ULong.constructor-impl(((long)this._capacity)) * 25)) <= 0) {
            this.dropDeletes$collection();
            return;
        }

        this.resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
    }

    public final boolean all(Function2 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "predicate");
        Object[] v0 = this.keys;
        Object[] v1 = this.values;
        long[] v14 = this.metadata;
        int v2 = v14.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v14[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            Object v11 = v0[v10];
                            Intrinsics.checkNotNull(v11, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                            Object v10_1 = v1[v10];
                            Intrinsics.checkNotNull(v10_1, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                            if(!arg15.invoke(v11, v10_1).booleanValue()) {
                                return 0;
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return 1;
                    }
                }

                if(v4 == v2) {
                    return 1;
                }
            }
        }

        return 1;
    }

    public final boolean any() {
        if(this._count != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean any(Function2 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "predicate");
        Object[] v0 = this.keys;
        Object[] v1 = this.values;
        long[] v14 = this.metadata;
        int v2 = v14.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v14[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            Object v11 = v0[v10];
                            Intrinsics.checkNotNull(v11, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                            Object v10_1 = v1[v10];
                            Intrinsics.checkNotNull(v10_1, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                            if(arg15.invoke(v11, v10_1).booleanValue()) {
                                return 1;
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return 0;
                    }
                }

                if(v4 == v2) {
                    return 0;
                }
            }
        }

        return 0;
    }

    public final boolean contains(Object arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        if(this.findKeyIndex(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public final boolean containsKey(Object arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        if(this.findKeyIndex(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public final boolean containsValue(Object arg14) {
        Intrinsics.checkNotNullParameter(arg14, "value");
        Object[] v0 = this.values;
        long[] v13 = this.metadata;
        int v1 = v13.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v13[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            Object v9 = v0[(v3 << 3) + v8];
                            Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                            if(Intrinsics.areEqual(arg14, v9)) {
                                return 1;
                            }
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return 0;
                    }
                }

                if(v3 == v1) {
                    return 0;
                }
            }
        }

        return 0;
    }

    public final int count() {
        return this.getSize();
    }

    public final int count(Function2 arg18) {
        Function2 v1 = arg18;
        Intrinsics.checkNotNullParameter(v1, "predicate");
        Object[] v2 = this.keys;
        Object[] v3 = this.values;
        long[] v0 = this.metadata;
        int v4 = v0.length - 2;
        if(v4 >= 0) {
            int v6 = 0;
            int v7 = 0;
            while(true) {
                long v8 = v0[v6];
                if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                    int v11 = 8;
                    int v10 = 8 - (~(v6 - v4) >>> 0x1F);
                    int v12;
                    for(v12 = 0; v12 < v10; ++v12) {
                        if((0xFF & v8) < 0x80) {
                            int v13 = (v6 << 3) + v12;
                            Object v14 = v2[v13];
                            Intrinsics.checkNotNull(v14, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                            Object v13_1 = v3[v13];
                            Intrinsics.checkNotNull(v13_1, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                            if(v1.invoke(v14, v13_1).booleanValue()) {
                                ++v7;
                            }
                        }

                        v8 >>= v11;
                    }

                    if(v10 == v11) {
                        goto label_50;
                    }

                    return v7;
                }

            label_50:
                if(v6 == v4) {
                    return v7;
                }

                ++v6;
            }

            return v7;
        }

        return 0;
    }

    public final void dropDeletes$collection() {
        Object[] v31;
        int v16;
        int v22;
        long v12;
        SieveCache v0 = this;
        long[] v1 = v0.metadata;
        if(v1 == null) {
            return;
        }

        int v2 = v0._capacity;
        Object[] v3 = v0.keys;
        Object[] v4 = v0.values;
        long[] v5 = v0.nodes;
        long[] v6 = new long[v2];
        long v7 = 0x7FFFFFFF7FFFFFFFL;
        int v9 = 0;
        ArraysKt.fill(v6, v7, 0, v2);
        int v10 = v2 + 7 >> 3;
        int v11;
        for(v11 = 0; v11 < v10; ++v11) {
            v12 = v1[v11] & -9187201950435737472L;
            v1[v11] = -72340172838076674L & ~v12 + (v12 >>> 7);
        }

        v10 = ArraysKt.getLastIndex(v1);
        v11 = v10 - 1;
        v1[v11] = v1[v11] & 0xFFFFFFFFFFFFFFL | -72057594037927936L;
        v1[v10] = v1[0];
        v10 = 0;
        while(v10 != v2) {
            v11 = v10 >> 3;
            int v14 = (v10 & 7) << 3;
            long v15 = 0xFF;
            v12 = v1[v11] >> v14 & v15;
            long v17 = 0x80;
            if(v12 != v17) {
                if(v12 != 0xFE) {
                }
                else {
                    goto label_54;
                }
            }

            ++v10;
            continue;
        label_54:
            Object v12_1 = v3[v10];
            int v12_2 = v12_1 != null ? v12_1.hashCode() : v9;
            v12_2 *= 0xCC9E2D51;
            v12_2 ^= v12_2 << 16;
            int v13 = v12_2 >>> 7;
            long v19 = v7;
            int v7_1 = v0.findFirstAvailableSlot(v13);
            int v8 = v13 & v2;
            int v21 = 0x20;
            if((v7_1 - v8 & v2) / 8 == (v10 - v8 & v2) / 8) {
                v22 = v9;
                int v23 = v10;
                v1[v11] = (((long)(v12_2 & 0x7F))) << v14 | ~(v15 << v14) & v1[v11];
                v10 = v23;
                if(Long.compare(v6[v23], v19) == 0) {
                    v7 = ((long)v10);
                    v6[v10] = v7 | v7 << v21;
                }

                v1[v1.length - 1] = v1[v22];
                ++v10;
                v7 = v19;
                v9 = v22;
                continue;
            }

            v22 = v9;
            v8 = v7_1 >> 3;
            long v23_1 = v1[v8];
            v9 = (v7_1 & 7) << 3;
            v13 = Long.compare(v23_1 >> v9 & v15, v17);
            long v25 = v15;
            int v15_1 = 0x7FFFFFFF;
            long v27 = -4294967296L;
            long v29 = 0xFFFFFFFFL;
            if(v13 == 0) {
                v16 = v2;
                v31 = v3;
                v1[v8] = v23_1 & ~(v25 << v9) | (((long)(v12_2 & 0x7F))) << v9;
                v1[v11] = v1[v11] & ~(v25 << v14) | v17 << v14;
                v31[v7_1] = v31[v10];
                v31[v10] = null;
                v4[v7_1] = v4[v10];
                v4[v10] = null;
                v5[v7_1] = v5[v10];
                v5[v10] = 0x3FFFFFFFFFFFFFFFL;
                v2 = ((int)(v6[v10] >> v21 & v29));
                if(v2 != v15_1) {
                    v6[v2] = v6[v2] & v27 | (((long)v7_1));
                    v6[v10] = v6[v10] & v29 | v27;
                }
                else {
                    v6[v10] = 0x7FFFFFFF00000000L | (((long)v7_1));
                }

                v6[v7_1] = (((long)v10)) << v21 | 0x7FFFFFFF;
            }
            else {
                v16 = v2;
                v31 = v3;
                v1[v8] = (((long)(v12_2 & 0x7F))) << v9 | v23_1 & ~(v25 << v9);
                Object v2_1 = v31[v7_1];
                v31[v7_1] = v31[v10];
                v31[v10] = v2_1;
                v2_1 = v4[v7_1];
                v4[v7_1] = v4[v10];
                v4[v10] = v2_1;
                long v2_2 = v5[v7_1];
                v5[v7_1] = v5[v10];
                v5[v10] = v2_2;
                v2 = ((int)(v6[v10] >> v21 & v29));
                if(v2 != v15_1) {
                    long v11_1 = ((long)v7_1);
                    v6[v2] = v6[v2] & v27 | v11_1;
                    v6[v10] = v6[v10] & v29 | v11_1 << v21;
                }
                else {
                    v2_2 = ((long)v7_1);
                    v6[v10] = v2_2 | v2_2 << v21;
                    v2 = v10;
                }

                v6[v7_1] = (((long)v2)) << v21 | (((long)v10));
                --v10;
            }

            v1[v1.length - 1] = v1[v22];
            ++v10;
            v2 = v16;
            v7 = v19;
            v9 = v22;
            v3 = v31;
        }

        v0.initializeGrowth();
        v0.fixupNodes(v6);
    }

    public boolean equals(Object arg18) {
        SieveCache v0 = this;
        Object v1 = arg18;
        if((((SieveCache)v1)) == v0) {
            return 1;
        }

        if(!(v1 instanceof SieveCache)) {
            return 0;
        }

        if(((SieveCache)v1).getSize() == v0.getSize()) {
            if(((SieveCache)v1)._count != v0._count) {
            }
            else {
                Object[] v3 = v0.keys;
                Object[] v5 = v0.values;
                long[] v0_1 = v0.metadata;
                int v6 = v0_1.length - 2;
                if(v6 >= 0) {
                    int v7;
                    for(v7 = 0; true; ++v7) {
                        long v8 = v0_1[v7];
                        if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                            int v11 = 8;
                            int v10 = 8 - (~(v7 - v6) >>> 0x1F);
                            int v12;
                            for(v12 = 0; v12 < v10; ++v12) {
                                if((0xFF & v8) < 0x80) {
                                    int v13 = (v7 << 3) + v12;
                                    Object v14 = v3[v13];
                                    Intrinsics.checkNotNull(v14, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                                    Object v13_1 = v5[v13];
                                    Intrinsics.checkNotNull(v13_1, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                                    if(!Intrinsics.areEqual(v13_1, ((SieveCache)v1).get(v14))) {
                                        return 0;
                                    }
                                }

                                v8 >>= v11;
                            }

                            if(v10 != v11) {
                                return 1;
                            }
                        }

                        if(v7 == v6) {
                            return 1;
                        }
                    }
                }

                return 1;
            }
        }

        return 0;
    }

    public final void evictAll() {
        this.trimToSize(-1);
    }

    private final int findEvictionCandidate() {
        int v5;
        long v3;
        long[] v0 = this.nodes;
        int v1 = this.hand;
        int v2 = 0x7FFFFFFF;
        if(v1 != v2) {
        }
        else {
            v1 = this.tail;
        }

        while(true) {
            v3 = 0x7FFFFFFF;
            v5 = 0x1F;
            if(v1 != v2) {
                long v6 = v0[v1];
                if((((int)(v6 >> 62 & 1))) != 0) {
                    int v3_1 = ((int)(v3 & v6 >> v5));
                    v0[v1] = 0x3FFFFFFFFFFFFFFFL & v6;
                    v1 = v3_1 != v2 ? v3_1 : this.tail;
                    continue;
                }
            }

            break;
        }

        int v0_1 = ((int)(v3 & v0[v1] >> v5));
        if(v0_1 != v2) {
            v2 = v0_1;
        }

        this.hand = v2;
        return v1;
    }

    private final int findFirstAvailableSlot(int arg10) {
        long v2;
        int v0 = this._capacity;
        arg10 &= v0;
        int v1 = 0;
        while(true) {
            int v3 = arg10 >> 3;
            int v4 = (arg10 & 7) << 3;
            v2 = this.metadata[v3 + 1] << 0x40 - v4 & -(((long)v4)) >> 0x3F | this.metadata[v3] >>> v4;
            v2 = v2 & ~v2 << 7 & -9187201950435737472L;
            if(v2 != 0) {
                break;
            }

            v1 += 8;
            arg10 = arg10 + v1 & v0;
        }

        return arg10 + (Long.numberOfTrailingZeros(v2) >> 3) & v0;
    }

    private final int findInsertIndex(Object arg21) {
        SieveCache v0 = this;
        Object v1 = arg21;
        int v3 = v1 != null ? v1.hashCode() : 0;
        v3 *= 0xCC9E2D51;
        v3 ^= v3 << 16;
        int v4 = v3 >>> 7;
        v3 &= 0x7F;
        int v5 = v0._capacity;
        int v6 = v4 & v5;
        int v7 = 0;
        while(true) {
            int v9 = v6 >> 3;
            int v10 = (v6 & 7) << 3;
            long v8 = v0.metadata[v9 + 1] << 0x40 - v10 & -(((long)v10)) >> 0x3F | v0.metadata[v9] >>> v10;
            long v10_1 = ((long)v3);
            int v18 = v3;
            long v2 = v8 ^ v10_1 * 0x101010101010101L;
            long v14 = -9187201950435737472L;
            for(v2 = ~v2 & v2 - 0x101010101010101L & v14; true; v2 &= v2 - 1) {
                long v16 = 0;
                if(v2 == v16) {
                    break;
                }

                int v16_1 = v6 + (Long.numberOfTrailingZeros(v2) >> 3) & v5;
                if(Intrinsics.areEqual(v0.keys[v16_1], v1)) {
                    return v16_1;
                }
            }

            if((~v8 << 6 & v8 & v14) != v16) {
                int v1_1 = v0.findFirstAvailableSlot(v4);
                long v5_1 = 0xFF;
                if(v0.growthLimit == 0) {
                    if((v0.metadata[v1_1 >> 3] >> ((v1_1 & 7) << 3) & v5_1) == 0xFE) {
                    }
                    else {
                        v0.adjustStorage$collection();
                        v1_1 = v0.findFirstAvailableSlot(v4);
                    }
                }

                ++v0._count;
                int v2_1 = v0.growthLimit;
                long[] v3_1 = v0.metadata;
                v4 = v1_1 >> 3;
                long v7_1 = v3_1[v4];
                v9 = (v1_1 & 7) << 3;
                int v19 = (v7_1 >> v9 & v5_1) == 0x80 ? 1 : 0;
                v0.growthLimit = v2_1 - v19;
                int v0_1 = v0._capacity;
                v5_1 = ~(v5_1 << v9) & v7_1 | v10_1 << v9;
                v3_1[v4] = v5_1;
                v3_1[(v1_1 - 7 & v0_1) + (v0_1 & 7) >> 3] = v5_1;
                return ~v1_1;
            }

            v7 += 8;
            v6 = v6 + v7 & v5;
            v3 = v18;
        }
    }

    private final int findKeyIndex(Object arg14) {
        int v0 = 0;
        int v1 = arg14 != null ? arg14.hashCode() : 0;
        v1 *= 0xCC9E2D51;
        v1 ^= v1 << 16;
        int v2 = v1 & 0x7F;
        int v3 = this._capacity;
        v1 >>>= 7;
        while(true) {
            v1 &= v3;
            int v5 = v1 >> 3;
            int v6 = (v1 & 7) << 3;
            long v4 = this.metadata[v5 + 1] << 0x40 - v6 & -(((long)v6)) >> 0x3F | this.metadata[v5] >>> v6;
            long v6_1 = (((long)v2)) * 0x101010101010101L ^ v4;
            long v8 = -9187201950435737472L;
            for(v6_1 = ~v6_1 & v6_1 - 0x101010101010101L & v8; true; v6_1 &= v6_1 - 1) {
                long v10 = 0;
                if(v6_1 == v10) {
                    break;
                }

                int v10_1 = (Long.numberOfTrailingZeros(v6_1) >> 3) + v1 & v3;
                if(Intrinsics.areEqual(this.keys[v10_1], arg14)) {
                    return v10_1;
                }
            }

            if((v4 & ~v4 << 6 & v8) != v10) {
                return -1;
            }

            v0 += 8;
            v1 += v0;
        }
    }

    private final void fixupNodes(int[] arg12) {
        long[] v0 = this.nodes;
        int v1 = v0.length;
        int v2;
        for(v2 = 0; true; ++v2) {
            int v3 = 0x7FFFFFFF;
            if(v2 >= v1) {
                break;
            }

            int v6 = 0x1F;
            int v7 = ((int)(v0[v2] >> v6 & 0x7FFFFFFF));
            int v8 = ((int)(v0[v2] & 0x7FFFFFFF));
            long v4 = v0[v2] & -4611686018427387904L;
            v7 = v7 == v3 ? v3 : arg12[v7];
            v4 = (v4 | (((long)v7))) << v6;
            if(v8 == v3) {
            }
            else {
                v3 = arg12[v8];
            }

            v0[v2] = v4 | (((long)v3));
        }

        int v0_1 = this.head;
        if(v0_1 != v3) {
            this.head = arg12[v0_1];
        }

        v0_1 = this.tail;
        if(v0_1 != v3) {
            this.tail = arg12[v0_1];
        }

        v0_1 = this.hand;
        if(v0_1 != v3) {
            this.hand = arg12[v0_1];
        }
    }

    private final void fixupNodes(long[] arg14) {
        long v3;
        long[] v0 = this.nodes;
        int v1 = v0.length;
        int v2;
        for(v2 = 0; true; ++v2) {
            v3 = 0xFFFFFFFFL;
            int v5 = 0x7FFFFFFF;
            if(v2 >= v1) {
                break;
            }

            int v8 = 0x1F;
            int v9 = ((int)(v0[v2] >> v8 & 0x7FFFFFFF));
            int v10 = ((int)(v0[v2] & 0x7FFFFFFF));
            long v6 = v0[v2] & -4611686018427387904L;
            v9 = v9 == v5 ? v5 : ((int)(arg14[v9] & v3));
            v6 = (v6 | (((long)v9))) << v8;
            if(v10 == v5) {
            }
            else {
                v5 = ((int)(v3 & arg14[v10]));
            }

            v0[v2] = (((long)v5)) | v6;
        }

        int v0_1 = this.head;
        if(v0_1 != v5) {
            this.head = ((int)(arg14[v0_1] & v3));
        }

        v0_1 = this.tail;
        if(v0_1 != v5) {
            this.tail = ((int)(arg14[v0_1] & v3));
        }

        v0_1 = this.hand;
        if(v0_1 != v5) {
            this.hand = ((int)(arg14[v0_1] & v3));
        }
    }

    public final void forEach(Function2 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "block");
        Object[] v0 = this.keys;
        Object[] v1 = this.values;
        long[] v14 = this.metadata;
        int v2 = v14.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v14[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            Object v11 = v0[v10];
                            Intrinsics.checkNotNull(v11, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                            Object v10_1 = v1[v10];
                            Intrinsics.checkNotNull(v10_1, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                            arg15.invoke(v11, v10_1);
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return;
                    }
                }

                if(v4 == v2) {
                    return;
                }
            }
        }
    }

    public final void forEachIndexed(Function1 arg13) {
        Intrinsics.checkNotNullParameter(arg13, "block");
        long[] v12 = this.metadata;
        int v0 = v12.length - 2;
        if(v0 >= 0) {
            int v2;
            for(v2 = 0; true; ++v2) {
                long v3 = v12[v2];
                if((~v3 << 7 & v3 & -9187201950435737472L) != -9187201950435737472L) {
                    int v6 = 8;
                    int v5 = 8 - (~(v2 - v0) >>> 0x1F);
                    int v7;
                    for(v7 = 0; v7 < v5; ++v7) {
                        if((0xFF & v3) < 0x80) {
                            arg13.invoke(Integer.valueOf((v2 << 3) + v7));
                        }

                        v3 >>= v6;
                    }

                    if(v5 == v6) {
                        goto label_36;
                    }

                    return;
                }

            label_36:
                if(v2 == v0) {
                    return;
                }
            }
        }
    }

    public final void forEachKey(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "block");
        Object[] v0 = this.keys;
        long[] v13 = this.metadata;
        int v1 = v13.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v13[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            Object v9 = v0[(v3 << 3) + v8];
                            Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                            arg14.invoke(v9);
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

    public final void forEachValue(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "block");
        Object[] v0 = this.values;
        long[] v13 = this.metadata;
        int v1 = v13.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v13[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            Object v9 = v0[(v3 << 3) + v8];
                            Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                            arg14.invoke(v9);
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

    public final Object get(Object arg6) {
        Intrinsics.checkNotNullParameter(arg6, "key");
        int v0 = this.findKeyIndex(arg6);
        if(v0 >= 0) {
            this.nodes[v0] = this.nodes[v0] & 0x3FFFFFFFFFFFFFFFL | 0x4000000000000000L;
            return this.values[v0];
        }

        Object v0_1 = this.createValueFromKey.invoke(arg6);
        if(v0_1 == null) {
            return null;
        }

        this.put(arg6, v0_1);
        return v0_1;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getCount() {
        return this._count;
    }

    public static void getCount$annotations() {
    }

    public static void getKeys$annotations() {
    }

    public final int getMaxSize() {
        return this._maxSize;
    }

    public static void getMetadata$annotations() {
    }

    public final int getSize() {
        return this._size;
    }

    public static void getValues$annotations() {
    }

    public int hashCode() {
        Object[] v0 = this.keys;
        Object[] v1 = this.values;
        long[] v15 = this.metadata;
        int v2 = v15.length - 2;
        if(v2 >= 0) {
            int v4 = 0;
            int v5 = 0;
            while(true) {
                long v6 = v15[v4];
                if((~v6 << 7 & v6 & -9187201950435737472L) != -9187201950435737472L) {
                    int v9 = 8;
                    int v8 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v10;
                    for(v10 = 0; v10 < v8; ++v10) {
                        if((0xFF & v6) < 0x80) {
                            int v11 = (v4 << 3) + v10;
                            Object v12 = v0[v11];
                            Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                            Object v11_1 = v1[v11];
                            Intrinsics.checkNotNull(v11_1, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                            v5 += v11_1.hashCode() ^ v12.hashCode();
                        }

                        v6 >>= v9;
                    }

                    if(v8 == v9) {
                        goto label_46;
                    }

                    return v5;
                }

            label_46:
                if(v4 == v2) {
                    return v5;
                }

                ++v4;
            }

            return v5;
        }

        return 0;
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this.getCount();
    }

    private final void initializeMetadata(int arg9) {
        long[] v9;
        if(arg9 == 0) {
            v9 = ScatterMapKt.EmptyGroup;
        }
        else {
            long[] v1 = new long[(arg9 + 15 & -8) >> 3];
            ArraysKt.fill$default(v1, -9187201950435737472L, 0, 0, 6, null);
            int v0 = arg9 >> 3;
            long v4 = 0xFF << ((arg9 & 7) << 3);
            v1[v0] = v1[v0] & ~v4 | v4;
            v9 = v1;
        }

        this.metadata = v9;
        this.initializeGrowth();
    }

    private final void initializeStorage(int arg8) {
        long[] v8;
        arg8 = arg8 > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(arg8)) : 0;
        this._capacity = arg8;
        this.initializeMetadata(arg8);
        Object[] v0 = arg8 == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[arg8];
        this.keys = v0;
        v0 = arg8 == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[arg8];
        this.values = v0;
        if(arg8 == 0) {
            v8 = SieveCacheKt.getEmptyNodes();
        }
        else {
            long[] v0_1 = new long[arg8];
            ArraysKt.fill$default(v0_1, 0x3FFFFFFFFFFFFFFFL, 0, 0, 6, null);
            v8 = v0_1;
        }

        this.nodes = v8;
    }

    public final boolean isEmpty() {
        if(this._count == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isNotEmpty() {
        if(this._count != 0) {
            return 1;
        }

        return 0;
    }

    private final void markNodeVisited(int arg5) {
        this.nodes[arg5] = this.nodes[arg5] & 0x3FFFFFFFFFFFFFFFL | 0x4000000000000000L;
    }

    public final void minusAssign(ObjectList arg4) {
        Intrinsics.checkNotNullParameter(arg4, "keys");
        Object[] v0 = arg4.content;
        int v4 = arg4._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            this.remove(v0[v1]);
        }
    }

    public final void minusAssign(ScatterSet arg14) {
        Intrinsics.checkNotNullParameter(arg14, "keys");
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
        Intrinsics.checkNotNullParameter(arg2, "keys");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            this.remove(v2.next());
        }
    }

    public final void minusAssign(Object arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        this.remove(arg2);
    }

    public final void minusAssign(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "keys");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            this.remove(v2.next());
        }
    }

    public final void minusAssign(Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "keys");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.remove(arg4[v1]);
        }
    }

    private final void moveNodeToHead(int arg11) {
        long[] v0 = this.nodes;
        int v1 = this.head;
        long v4 = 0x7FFFFFFF;
        v0[arg11] = (((long)v1)) & v4 | 0x3FFFFFFF80000000L;
        int v2 = 0x7FFFFFFF;
        if(v1 != v2) {
            v0[v1] = ((((long)arg11)) & v4) << 0x1F | v0[v1] & -4611686016279904257L;
        }

        this.head = arg11;
        if(this.tail == v2) {
            this.tail = arg11;
        }
    }

    public final boolean none() {
        if(this._count == 0) {
            return 1;
        }

        return 0;
    }

    public final void plusAssign(ScatterMap arg2) {
        Intrinsics.checkNotNullParameter(arg2, "from");
        this.putAll(arg2);
    }

    public final void plusAssign(SieveCache arg2) {
        Intrinsics.checkNotNullParameter(arg2, "from");
        this.putAll(arg2);
    }

    public final void plusAssign(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        this.putAll(arg2);
    }

    public final void plusAssign(Map arg2) {
        Intrinsics.checkNotNullParameter(arg2, "from");
        this.putAll(arg2);
    }

    public final void plusAssign(Pair arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pair");
        this.put(arg2.getFirst(), arg2.getSecond());
    }

    public final void plusAssign(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        this.putAll(arg2);
    }

    public final void plusAssign(Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        this.putAll(arg2);
    }

    public final Object put(Object arg10, Object arg11) {
        Intrinsics.checkNotNullParameter(arg10, "key");
        Intrinsics.checkNotNullParameter(arg11, "value");
        int v0 = this.findInsertIndex(arg10);
        if(v0 < 0) {
            v0 = ~v0;
        }

        Object[] v1 = this.values;
        Object v2 = v1[v0];
        v1[v0] = arg11;
        this.keys[v0] = arg10;
        int v1_1 = this._size + this.sizeOf.invoke(arg10, arg11).intValue();
        this._size = v1_1;
        if(v2 != null) {
            this._size = v1_1 - this.sizeOf.invoke(arg10, v2).intValue();
            this.onEntryRemoved.invoke(arg10, v2, arg11, Boolean.valueOf(false));
            this.trimToSize(this._maxSize);
            return v2;
        }

        this.trimToSize(this._maxSize);
        long[] v10 = this.nodes;
        int v11 = this.head;
        long v5 = 0x7FFFFFFF;
        v10[v0] = (((long)v11)) & v5 | 0x3FFFFFFF80000000L;
        v1_1 = 0x7FFFFFFF;
        if(v11 != v1_1) {
            v10[v11] = v10[v11] & -4611686016279904257L | (v5 & (((long)v0))) << 0x1F;
        }

        this.head = v0;
        if(this.tail == v1_1) {
            this.tail = v0;
        }

        return v2;
    }

    public final void putAll(ScatterMap arg15) {
        Intrinsics.checkNotNullParameter(arg15, "from");
        Object[] v0 = arg15.keys;
        Object[] v1 = arg15.values;
        long[] v15 = arg15.metadata;
        int v2 = v15.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v15[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            this.put(v0[v10], v1[v10]);
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return;
                    }
                }

                if(v4 == v2) {
                    return;
                }
            }
        }
    }

    public final void putAll(SieveCache arg15) {
        Intrinsics.checkNotNullParameter(arg15, "from");
        Object[] v0 = arg15.keys;
        Object[] v1 = arg15.values;
        long[] v15 = arg15.metadata;
        int v2 = v15.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v15[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            Object v11 = v0[v10];
                            Intrinsics.checkNotNull(v11, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                            Object v10_1 = v1[v10];
                            Intrinsics.checkNotNull(v10_1, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                            this.put(v11, v10_1);
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return;
                    }
                }

                if(v4 == v2) {
                    return;
                }
            }
        }
    }

    public final void putAll(Iterable arg3) {
        Intrinsics.checkNotNullParameter(arg3, "pairs");
        Iterator v3 = arg3.iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            this.put(((Pair)v0).component1(), ((Pair)v0).component2());
        }
    }

    public final void putAll(Map arg3) {
        Intrinsics.checkNotNullParameter(arg3, "from");
        Iterator v3 = arg3.entrySet().iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            this.put(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
        }
    }

    public final void putAll(Sequence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "pairs");
        Iterator v3 = arg3.iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            this.put(((Pair)v0).component1(), ((Pair)v0).component2());
        }
    }

    public final void putAll(Pair[] arg5) {
        Intrinsics.checkNotNullParameter(arg5, "pairs");
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.put(arg5[v1].component1(), arg5[v1].component2());
        }
    }

    public final Object remove(Object arg5) {
        Intrinsics.checkNotNullParameter(arg5, "key");
        int v0 = this.findKeyIndex(arg5);
        Object v1 = null;
        if(v0 >= 0) {
            Object v0_1 = this.removeValueAt(v0);
            if(v0_1 == null) {
                return v1;
            }

            this._size -= this.sizeOf.invoke(arg5, v0_1).intValue();
            this.onEntryRemoved.invoke(arg5, v0_1, v1, Boolean.valueOf(false));
            return v0_1;
        }

        return v1;
    }

    public final boolean remove(Object arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg4, "key");
        Intrinsics.checkNotNullParameter(arg5, "value");
        int v0 = this.findKeyIndex(arg4);
        if(v0 >= 0 && (Intrinsics.areEqual(this.values[v0], arg5))) {
            arg5 = this.removeValueAt(v0);
            if(arg5 == null) {
                return 0;
            }
            else {
                this._size -= this.sizeOf.invoke(arg4, arg5).intValue();
                this.onEntryRemoved.invoke(arg4, arg5, null, Boolean.valueOf(false));
                return 1;
            }
        }

        return 0;
    }

    public final void removeIf(Function2 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "predicate");
        long[] v0 = this.metadata;
        int v1 = v0.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v0[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            int v9 = (v3 << 3) + v8;
                            Object v10 = this.keys[v9];
                            Intrinsics.checkNotNull(v10, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                            Object v11 = this.values[v9];
                            Intrinsics.checkNotNull(v11, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                            if(arg15.invoke(v10, v11).booleanValue()) {
                                Object v9_1 = this.removeValueAt(v9);
                                if(v9_1 == null) {
                                    return;
                                }
                                else {
                                    this._size -= this.sizeOf.invoke(v10, v9_1).intValue();
                                    this.onEntryRemoved.invoke(v10, v9_1, null, Boolean.valueOf(false));
                                }
                            }
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

    private final void removeNode(int arg13) {
        long[] v0 = this.nodes;
        int v3 = 0x1F;
        long v6 = 0x7FFFFFFF;
        int v4 = ((int)(v0[arg13] >> v3 & v6));
        int v1 = ((int)(v0[arg13] & v6));
        int v2 = 0x7FFFFFFF;
        if(v4 != v2) {
            v0[v4] = v0[v4] & -2147483648 | (((long)v1)) & v6;
        }
        else {
            this.head = v1;
        }

        if(v1 != v2) {
            v0[v1] = ((((long)v4)) & v6) << v3 | v0[v1] & -4611686016279904257L;
        }
        else {
            this.tail = v4;
        }

        if(this.hand == arg13) {
            this.hand = v4;
        }

        v0[arg13] = 0x3FFFFFFFFFFFFFFFL;
    }

    private final Object removeValueAt(int arg14) {
        --this._count;
        long[] v0 = this.metadata;
        int v1 = this._capacity;
        int v2 = arg14 >> 3;
        int v3 = (arg14 & 7) << 3;
        long v3_1 = v0[v2] & ~(0xFF << v3) | 0xFE << v3;
        v0[v2] = v3_1;
        v0[(arg14 - 7 & v1) + (v1 & 7) >> 3] = v3_1;
        this.keys[arg14] = null;
        Object[] v0_1 = this.values;
        Object v2_1 = v0_1[arg14];
        v0_1[arg14] = null;
        v0 = this.nodes;
        v1 = 0x1F;
        long v7 = 0x7FFFFFFF;
        int v5 = ((int)(v0[arg14] >> v1 & v7));
        v3 = ((int)(v0[arg14] & v7));
        int v4 = 0x7FFFFFFF;
        if(v5 != v4) {
            v0[v5] = v0[v5] & -2147483648 | (((long)v3)) & v7;
        }
        else {
            this.head = v3;
        }

        if(v3 != v4) {
            v0[v3] = ((((long)v5)) & v7) << v1 | v0[v3] & -4611686016279904257L;
        }
        else {
            this.tail = v5;
        }

        if(this.hand == arg14) {
            this.hand = v5;
        }

        v0[arg14] = 0x3FFFFFFFFFFFFFFFL;
        return v2_1;
    }

    public final void resize(int arg1) {
        this._maxSize = arg1;
        this.trimToSize(arg1);
    }

    public final void resizeStorage$collection(int arg26) {
        Object[] v19;
        long[] v18;
        SieveCache v0 = this;
        long[] v1 = v0.metadata;
        Object[] v2 = v0.keys;
        Object[] v3 = v0.values;
        long[] v4 = v0.nodes;
        int v5 = v0._capacity;
        int[] v6 = new int[v5];
        this.initializeStorage(arg26);
        long[] v7 = v0.metadata;
        Object[] v8 = v0.keys;
        Object[] v9 = v0.values;
        long[] v10 = v0.nodes;
        int v11 = v0._capacity;
        int v13 = 0;
        while(v13 < v5) {
            long v16 = 0xFF;
            if((v1[v13 >> 3] >> ((v13 & 7) << 3) & v16) < 0x80) {
                Object v14 = v2[v13];
                int v15 = v14 != null ? v14.hashCode() : 0;
                v15 *= 0xCC9E2D51;
                v15 ^= v15 << 16;
                int v12 = v0.findFirstAvailableSlot(v15 >>> 7);
                v18 = v1;
                v19 = v2;
                long v1_1 = ((long)(v15 & 0x7F));
                v15 = v12 >> 3;
                int v20 = (v12 & 7) << 3;
                v1_1 = v7[v15] & ~(v16 << v20) | v1_1 << v20;
                v7[v15] = v1_1;
                v7[(v12 - 7 & v11) + (v11 & 7) >> 3] = v1_1;
                v8[v12] = v14;
                v9[v12] = v3[v13];
                v10[v12] = v4[v13];
                v6[v13] = v12;
            }
            else {
                v18 = v1;
                v19 = v2;
            }

            ++v13;
            v1 = v18;
            v2 = v19;
        }

        v0.fixupNodes(v6);
    }

    public final void set(Object arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        this.put(arg2, arg3);
    }

    public String toString() {
        return "SieveCache[maxSize=" + this._maxSize + ", size=" + this._size + ", capacity=" + this._capacity + ", count=" + this._count + ']';
    }

    public final void trimToSize(int arg6) {
        while(this._size > arg6) {
            if(this.getCount() == 0) {
            }
            else {
                int v0 = this.findEvictionCandidate();
                if(v0 == 0x7FFFFFFF) {
                }
                else {
                    Object v1 = this.keys[v0];
                    Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                    Object v0_1 = this.removeValueAt(v0);
                    if(v0_1 == null) {
                    }
                    else {
                        this._size -= this.sizeOf.invoke(v1, v0_1).intValue();
                        this.onEntryRemoved.invoke(v1, v0_1, null, Boolean.valueOf(true));
                    }

                    continue;
                }
            }

            return;
        }
    }
}

