package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u001C\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000F\b\u0004\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0016\u001A\u00020\u0017J:\u0010\u0016\u001A\u00020\u00172!\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000E\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u001EH&J\u0016\u0010\u001F\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u0014\u0010!\u001A\u00020\u00172\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0019\u0010!\u001A\u00020\u00172\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010#J\u0014\u0010!\u001A\u00020\u00172\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000$J\u0014\u0010!\u001A\u00020\u00172\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u001EJ\u0006\u0010%\u001A\u00020\u0004J:\u0010%\u001A\u00020\u00042!\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0015\u0010&\u001A\u00028\u00002\b\b\u0001\u0010\'\u001A\u00020\u0004¢\u0006\u0002\u0010(J>\u0010)\u001A\u00028\u00002\b\b\u0001\u0010\'\u001A\u00020\u00042!\u0010*\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\'\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010+J\u0013\u0010,\u001A\u00020\u00172\b\u0010-\u001A\u0004\u0018\u00010\u0002H\u0096\u0002J\u000B\u0010.\u001A\u00028\u0000¢\u0006\u0002\u0010/J?\u0010.\u001A\u00028\u00002!\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0010\u00101\u001A\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u0010/JA\u00101\u001A\u0004\u0018\u00018\u00002!\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100Jb\u00102\u001A\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001A\u0002H326\u00105\u001A2\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(7\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u0002H306H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00108Jw\u00109\u001A\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001A\u0002H32K\u00105\u001AG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\'\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(7\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u0002H30:H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010;Jb\u0010<\u001A\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001A\u0002H326\u00105\u001A2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002H306H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00108Jw\u0010=\u001A\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001A\u0002H32K\u00105\u001AG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\'\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002H30:H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010;J:\u0010>\u001A\u00020?2!\u0010@\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020?0\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010A\u001A\u00020?26\u0010@\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\'\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020?06H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010B\u001A\u00020?2!\u0010@\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020?0\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010C\u001A\u00020?26\u0010@\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\'\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020?06H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0018\u0010D\u001A\u00028\u00002\b\b\u0001\u0010\'\u001A\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010(J\b\u0010E\u001A\u00020\u0004H\u0016J\u0013\u0010F\u001A\u00020\u00042\u0006\u0010\u001C\u001A\u00028\u0000¢\u0006\u0002\u0010GJ:\u0010H\u001A\u00020\u00042!\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010I\u001A\u00020\u00042!\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010J\u001A\u00020\u0017J\u0006\u0010K\u001A\u00020\u0017JR\u0010L\u001A\u00020M2\b\b\u0002\u0010N\u001A\u00020O2\b\b\u0002\u0010P\u001A\u00020O2\b\b\u0002\u0010Q\u001A\u00020O2\b\b\u0002\u0010R\u001A\u00020\u00042\b\b\u0002\u0010S\u001A\u00020O2\u0016\b\u0002\u0010T\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020O\u0018\u00010\u0019H\u0007J\u000B\u0010U\u001A\u00028\u0000¢\u0006\u0002\u0010/J?\u0010U\u001A\u00028\u00002!\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0013\u0010V\u001A\u00020\u00042\u0006\u0010\u001C\u001A\u00028\u0000¢\u0006\u0002\u0010GJ\u0010\u0010W\u001A\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u0010/JA\u0010W\u001A\u0004\u0018\u00018\u00002!\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0006\u0010X\u001A\u00020\u0017J:\u0010Y\u001A\u00020\u00172!\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0015\u0010Z\u001A\u00020?2\u0006\u0010\'\u001A\u00020\u0004H\u0000¢\u0006\u0002\b[J\b\u0010\\\u001A\u00020MH\u0016R\u0018\u0010\u0006\u001A\u00020\u00048\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\bR\"\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0000@\u0000X\u0081\u000E¢\u0006\n\n\u0002\u0010\f\u0012\u0004\b\u000B\u0010\bR\u0012\u0010\r\u001A\u00020\u000E8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0012\u0010\u0011\u001A\u00020\u00048Ç\u0002¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\u00048G¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0013\u0082\u0001\u0001]\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006^"}, d2={"Landroidx/collection/ObjectList;", "E", "", "initialCapacity", "", "(I)V", "_size", "get_size$annotations", "()V", "content", "", "getContent$annotations", "[Ljava/lang/Object;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "size", "getSize", "any", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "asList", "", "contains", "(Ljava/lang/Object;)Z", "containsAll", "elements", "([Ljava/lang/Object;)Z", "", "count", "elementAt", "index", "(I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "equals", "other", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "last", "lastIndexOf", "lastOrNull", "none", "reversedAny", "throwIndexOutOfBoundsExclusiveException", "throwIndexOutOfBoundsExclusiveException$collection", "toString", "Landroidx/collection/MutableObjectList;", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public abstract class ObjectList {
    public int _size;
    public Object[] content;

    private ObjectList(int arg1) {
        super();
        Object[] v1 = arg1 == 0 ? ObjectListKt.access$getEmptyArray$p() : new Object[arg1];
        this.content = v1;
    }

    public ObjectList(int arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public final boolean any() {
        return this.isNotEmpty();
    }

    public final boolean any(Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "predicate");
        Object[] v0 = this.content;
        int v4 = this._size;
        int v2;
        for(v2 = 0; v2 < v4; ++v2) {
            if(arg5.invoke(v0[v2]).booleanValue()) {
                return 1;
            }
        }

        return 0;
    }

    public abstract List asList();

    public final boolean contains(Object arg1) {
        if(this.indexOf(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    public final boolean containsAll(ObjectList arg5) {
        Intrinsics.checkNotNullParameter(arg5, "elements");
        Object[] v0 = arg5.content;
        int v5 = arg5._size;
        int v2;
        for(v2 = 0; v2 < v5; ++v2) {
            if(!this.contains(v0[v2])) {
                return 0;
            }
        }

        return 1;
    }

    public final boolean containsAll(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        Iterator v2 = arg2.iterator();
        do {
            if(!v2.hasNext()) {
                return 1;
            }
        }
        while(this.contains(v2.next()));

        return 0;
    }

    public final boolean containsAll(List arg5) {
        Intrinsics.checkNotNullParameter(arg5, "elements");
        int v0 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!this.contains(arg5.get(v2))) {
                return 0;
            }
        }

        return 1;
    }

    public final boolean containsAll(Object[] arg5) {
        Intrinsics.checkNotNullParameter(arg5, "elements");
        int v0 = arg5.length;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!this.contains(arg5[v2])) {
                return 0;
            }
        }

        return 1;
    }

    public final int count() {
        return this._size;
    }

    public final int count(Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "predicate");
        Object[] v0 = this.content;
        int v4 = this._size;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v4) {
            if(arg5.invoke(v0[v1]).booleanValue()) {
                ++v2;
            }

            ++v1;
        }

        return v2;
    }

    public final Object elementAt(int arg2) {
        if(arg2 < 0 || arg2 >= this._size) {
            this.throwIndexOutOfBoundsExclusiveException$collection(arg2);
        }
        else {
        }

        return this.content[arg2];
    }

    public final Object elementAtOrElse(int arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        if(arg2 >= 0 && arg2 < this._size) {
            return this.content[arg2];
        }

        return arg3.invoke(Integer.valueOf(arg2));
    }

    public boolean equals(Object arg6) {
        if((arg6 instanceof ObjectList)) {
            int v0 = ((ObjectList)arg6)._size;
            int v2 = this._size;
            if(v0 != v2) {
            }
            else {
                Object[] v5 = this.content;
                Object[] v6 = ((ObjectList)arg6).content;
                IntRange v0_1 = RangesKt.until(0, v2);
                v2 = v0_1.getFirst();
                v0 = v0_1.getLast();
                if(v2 <= v0) {
                    while(true) {
                        if(!Intrinsics.areEqual(v5[v2], v6[v2])) {
                            return 0;
                        }
                        else if(v2 != v0) {
                            ++v2;
                            continue;
                        }

                        return 1;
                    }

                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public final Object first() {
        if(this.isEmpty()) {
            RuntimeHelpersKt.throwNoSuchElementException("ObjectList is empty.");
        }

        return this.content[0];
    }

    public final Object first(Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "predicate");
        Object[] v0 = this.content;
        int v4 = this._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            Object v2 = v0[v1];
            if(arg5.invoke(v2).booleanValue()) {
                return v2;
            }
        }

        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final Object firstOrNull() {
        if(this.isEmpty()) {
            return null;
        }

        return this.get(0);
    }

    public final Object firstOrNull(Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "predicate");
        Object[] v0 = this.content;
        int v4 = this._size;
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
        Intrinsics.checkNotNullParameter(arg5, "operation");
        Object[] v0 = this.content;
        int v3 = this._size;
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            arg4 = arg5.invoke(arg4, v0[v1]);
        }

        return arg4;
    }

    public final Object foldIndexed(Object arg5, Function3 arg6) {
        Intrinsics.checkNotNullParameter(arg6, "operation");
        Object[] v0 = this.content;
        int v4 = this._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            arg5 = arg6.invoke(Integer.valueOf(v1), arg5, v0[v1]);
        }

        return arg5;
    }

    public final Object foldRight(Object arg3, Function2 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "operation");
        Object[] v0 = this.content;
        int v2;
        for(v2 = this._size - 1; -1 < v2; --v2) {
            arg3 = arg4.invoke(v0[v2], arg3);
        }

        return arg3;
    }

    public final Object foldRightIndexed(Object arg4, Function3 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "operation");
        Object[] v0 = this.content;
        int v3;
        for(v3 = this._size - 1; -1 < v3; --v3) {
            arg4 = arg5.invoke(Integer.valueOf(v3), v0[v3], arg4);
        }

        return arg4;
    }

    public final void forEach(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "block");
        Object[] v0 = this.content;
        int v3 = this._size;
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            arg4.invoke(v0[v1]);
        }
    }

    public final void forEachIndexed(Function2 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "block");
        Object[] v0 = this.content;
        int v4 = this._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            arg5.invoke(Integer.valueOf(v1), v0[v1]);
        }
    }

    public final void forEachReversed(Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "block");
        Object[] v0 = this.content;
        int v2;
        for(v2 = this._size - 1; -1 < v2; --v2) {
            arg3.invoke(v0[v2]);
        }
    }

    public final void forEachReversedIndexed(Function2 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "block");
        Object[] v0 = this.content;
        int v3;
        for(v3 = this._size - 1; -1 < v3; --v3) {
            arg4.invoke(Integer.valueOf(v3), v0[v3]);
        }
    }

    public final Object get(int arg2) {
        if(arg2 < 0 || arg2 >= this._size) {
            this.throwIndexOutOfBoundsExclusiveException$collection(arg2);
        }
        else {
        }

        return this.content[arg2];
    }

    public static void getContent$annotations() {
    }

    public final IntRange getIndices() {
        return RangesKt.until(0, this._size);
    }

    public final int getLastIndex() {
        return this._size - 1;
    }

    public final int getSize() {
        return this._size;
    }

    public static void get_size$annotations() {
    }

    public int hashCode() {
        Object[] v0 = this.content;
        int v5 = this._size;
        int v2 = 0;
        int v3 = 0;
        while(v2 < v5) {
            Object v4 = v0[v2];
            int v4_1 = v4 != null ? v4.hashCode() : 0;
            v3 += v4_1 * 0x1F;
            ++v2;
        }

        return v3;
    }

    public final int indexOf(Object arg4) {
        int v3;
        Object[] v0 = this.content;
        int v1 = 0;
        if(arg4 == null) {
            v3 = this._size;
            while(v1 < v3) {
                if(v0[v1] == null) {
                    return v1;
                }
                else {
                    ++v1;
                    continue;
                }

                return -1;
            }
        }
        else {
            v3 = this._size;
            while(v1 < v3) {
                if(arg4.equals(v0[v1])) {
                    return v1;
                }
                else {
                    ++v1;
                    continue;
                }

                return -1;
            }
        }

        return -1;
    }

    public final int indexOfFirst(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        Object[] v0 = this.content;
        int v3 = this._size;
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            if(arg4.invoke(v0[v1]).booleanValue()) {
                return v1;
            }
        }

        return -1;
    }

    public final int indexOfLast(Function1 arg3) {
        int v1;
        Intrinsics.checkNotNullParameter(arg3, "predicate");
        Object[] v0 = this.content;
        int v2;
        for(v2 = this._size - 1; true; --v2) {
            v1 = -1;
            if(v1 >= v2) {
                return v1;
            }

            if(arg3.invoke(v0[v2]).booleanValue()) {
                return v2;
            }
        }

        return v1;
    }

    public final boolean isEmpty() {
        if(this._size == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isNotEmpty() {
        if(this._size != 0) {
            return 1;
        }

        return 0;
    }

    public final String joinToString(CharSequence arg4, CharSequence arg5, CharSequence arg6, int arg7, CharSequence arg8, Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg4, "separator");
        Intrinsics.checkNotNullParameter(arg5, "prefix");
        Intrinsics.checkNotNullParameter(arg6, "postfix");
        Intrinsics.checkNotNullParameter(arg8, "truncated");
        StringBuilder v0 = new StringBuilder();
        v0.append(arg5);
        Object[] v5 = this.content;
        int v3 = this._size;
        int v1 = 0;
        while(true) {
            if(v1 < v3) {
                Object v2 = v5[v1];
                if(v1 == arg7) {
                    v0.append(arg8);
                }
                else {
                    if(v1 != 0) {
                        v0.append(arg4);
                    }

                    if(arg9 == null) {
                        v0.append(v2);
                    }
                    else {
                        v0.append(arg9.invoke(v2));
                    }

                    ++v1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_29;
        }

        v0.append(arg6);
    label_29:
        String v3_1 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v3_1, "toString(...)");
        return v3_1;
    }

    public final String joinToString() {
        return ObjectList.joinToString$default(this, null, null, null, 0, null, null, 0x3F, null);
    }

    public final String joinToString(CharSequence arg11) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        return ObjectList.joinToString$default(this, arg11, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        return ObjectList.joinToString$default(this, arg11, arg12, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12, CharSequence arg13) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        Intrinsics.checkNotNullParameter(arg13, "postfix");
        return ObjectList.joinToString$default(this, arg11, arg12, arg13, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12, CharSequence arg13, int arg14) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        Intrinsics.checkNotNullParameter(arg13, "postfix");
        return ObjectList.joinToString$default(this, arg11, arg12, arg13, arg14, null, null, 0x30, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12, CharSequence arg13, int arg14, CharSequence arg15) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        Intrinsics.checkNotNullParameter(arg13, "postfix");
        Intrinsics.checkNotNullParameter(arg15, "truncated");
        return ObjectList.joinToString$default(this, arg11, arg12, arg13, arg14, arg15, null, 0x20, null);
    }

    public static String joinToString$default(ObjectList arg1, CharSequence arg2, CharSequence arg3, CharSequence arg4, int arg5, CharSequence arg6, Function1 arg7, int arg8, Object arg9) {
        String v6;
        String v4;
        String v3;
        String v2;
        if(arg9 == null) {
            if((arg8 & 1) != 0) {
                v2 = ", ";
            }

            String v0 = "";
            if((arg8 & 2) != 0) {
                v3 = v0;
            }

            if((arg8 & 4) != 0) {
                v4 = v0;
            }

            if((arg8 & 8) != 0) {
                arg5 = -1;
            }

            if((arg8 & 16) != 0) {
                v6 = "...";
            }

            if((arg8 & 0x20) != 0) {
                arg7 = null;
            }

            return arg1.joinToString(((CharSequence)v2), ((CharSequence)v3), ((CharSequence)v4), arg5, ((CharSequence)v6), arg7);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final Object last() {
        if(this.isEmpty()) {
            RuntimeHelpersKt.throwNoSuchElementException("ObjectList is empty.");
        }

        return this.content[this._size - 1];
    }

    public final Object last(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        Object[] v0 = this.content;
        int v3;
        for(v3 = this._size - 1; -1 < v3; --v3) {
            Object v1 = v0[v3];
            if(arg4.invoke(v1).booleanValue()) {
                return v1;
            }
        }

        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final int lastIndexOf(Object arg4) {
        int v3;
        Object[] v0 = this.content;
        int v1 = -1;
        if(arg4 == null) {
            v3 = this._size - 1;
            while(v1 < v3) {
                if(v0[v3] == null) {
                    return v3;
                }
                else {
                    --v3;
                    continue;
                }

                return v1;
            }
        }
        else {
            v3 = this._size - 1;
            while(v1 < v3) {
                if(arg4.equals(v0[v3])) {
                    return v3;
                }
                else {
                    --v3;
                    continue;
                }

                return v1;
            }
        }

        return v1;
    }

    public final Object lastOrNull() {
        if(this.isEmpty()) {
            return null;
        }

        return this.content[this._size - 1];
    }

    public final Object lastOrNull(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        Object[] v0 = this.content;
        int v3;
        for(v3 = this._size - 1; -1 < v3; --v3) {
            Object v1 = v0[v3];
            if(arg4.invoke(v1).booleanValue()) {
                return v1;
            }
        }

        return null;
    }

    public final boolean none() {
        return this.isEmpty();
    }

    public final boolean reversedAny(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        Object[] v0 = this.content;
        int v3;
        for(v3 = this._size - 1; -1 < v3; --v3) {
            if(arg4.invoke(v0[v3]).booleanValue()) {
                return 1;
            }
        }

        return 0;
    }

    public final void throwIndexOutOfBoundsExclusiveException$collection(int arg3) {
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index " + arg3 + " must be in 0.." + (this._size - 1));
    }

    public String toString() {
        return ObjectList.joinToString$default(this, null, "[", "]", 0, null, new ObjectList$toString$1(this), 25, null);
    }
}

