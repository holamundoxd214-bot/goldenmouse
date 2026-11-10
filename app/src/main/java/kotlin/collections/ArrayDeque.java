package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \\*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\\B\u0011\bV\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\bV¢\u0006\u0004\b\u0005\u0010\u0007B\u0017\bV\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u0005\u0010\nJ\u0012\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0004H\u0082\u0080\u0004J\u0012\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0004H\u0082\u0080\u0004J\u0017\u0010\u0019\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00020\u0004H\u0083\u0088\u0004¢\u0006\u0002\u0010\u001BJ\u0012\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u0004H\u0082\u0080\u0004J\u0012\u0010\u001E\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u0004H\u0082\u0080\u0004J\u0012\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u0004H\u0083\u0088\u0004J\u0012\u0010\u001F\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u0004H\u0082\u0080\u0004J\u0012\u0010 \u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u0004H\u0082\u0080\u0004J\n\u0010!\u001A\u00020\"H\u0096\u0080\u0004J\u000F\u0010#\u001A\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010$J\u0011\u0010%\u001A\u0004\u0018\u00018\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010$J\u000F\u0010&\u001A\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010$J\u0011\u0010\'\u001A\u0004\u0018\u00018\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010$J\u0017\u0010(\u001A\u00020\u00152\u0006\u0010)\u001A\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010*J\u0017\u0010+\u001A\u00020\u00152\u0006\u0010)\u001A\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010*J\u000F\u0010,\u001A\u00028\u0000H\u0087\u0080\b¢\u0006\u0002\u0010$J\u0011\u0010-\u001A\u0004\u0018\u00018\u0000H\u0087\u0080\b¢\u0006\u0002\u0010$J\u000F\u0010.\u001A\u00028\u0000H\u0087\u0080\b¢\u0006\u0002\u0010$J\u0011\u0010/\u001A\u0004\u0018\u00018\u0000H\u0087\u0080\b¢\u0006\u0002\u0010$J\u0017\u00100\u001A\u00020\"2\u0006\u0010)\u001A\u00028\u0000H\u0097\u0080\b¢\u0006\u0002\u00101J\u001F\u00100\u001A\u00020\u00152\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010)\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u00102J \u00103\u001A\u00020\u00152\u0006\u0010\u001A\u001A\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tH\u0082\u0080\u0004J\u0018\u00104\u001A\u00020\"2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bJ \u00104\u001A\u00020\"2\u0006\u0010\u001D\u001A\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bJ\u0017\u00105\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00020\u0004H\u0096\u0082\u0004¢\u0006\u0002\u0010\u001BJ\u001F\u00106\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010)\u001A\u00028\u0000H\u0097\u0082\b¢\u0006\u0002\u00107J\u0017\u00108\u001A\u00020\"2\u0006\u0010)\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u00101J\u0017\u00109\u001A\u00020\u00042\u0006\u0010)\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010:J\u0017\u0010;\u001A\u00020\u00042\u0006\u0010)\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010:J\u0017\u0010<\u001A\u00020\"2\u0006\u0010)\u001A\u00028\u0000H\u0097\u0080\b¢\u0006\u0002\u00101J\u0017\u0010=\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00020\u0004H\u0097\u0080\b¢\u0006\u0002\u0010\u001BJ\u0018\u0010>\u001A\u00020\"2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bJ\u0018\u0010?\u001A\u00020\"2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bJ\u001E\u0010@\u001A\u00020\"2\u0012\u0010A\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\"0BH\u0082\u0088\u0004J\n\u0010C\u001A\u00020\u0015H\u0096\u0080\u0004J)\u0010D\u001A\b\u0012\u0004\u0012\u0002HE0\r\"\u0004\b\u0001\u0010E2\f\u0010F\u001A\b\u0012\u0004\u0012\u0002HE0\rH\u0096\u0080\u0004¢\u0006\u0002\u0010GJ\u0017\u0010D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\rH\u0096\u0080\u0004¢\u0006\u0002\u0010HJ\u001A\u0010I\u001A\u00020\u00152\u0006\u0010J\u001A\u00020\u00042\u0006\u0010K\u001A\u00020\u0004H\u0094\u0080\u0004J\u001A\u0010L\u001A\u00020\u00152\u0006\u0010J\u001A\u00020\u00042\u0006\u0010K\u001A\u00020\u0004H\u0082\u0080\u0004J\u001A\u0010M\u001A\u00020\u00152\u0006\u0010J\u001A\u00020\u00042\u0006\u0010K\u001A\u00020\u0004H\u0082\u0080\u0004J\u001A\u0010N\u001A\u00020\u00152\u0006\u0010O\u001A\u00020\u00042\u0006\u0010P\u001A\u00020\u0004H\u0082\u0080\u0004J\n\u0010Q\u001A\u00020\u0015H\u0082\u0080\u0004J+\u0010R\u001A\b\u0012\u0004\u0012\u0002HE0\r\"\u0004\b\u0001\u0010E2\f\u0010F\u001A\b\u0012\u0004\u0012\u0002HE0\rH\u0080\u0080\u0004¢\u0006\u0004\bS\u0010GJ\u0019\u0010R\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\rH\u0080\u0080\u0004¢\u0006\u0004\bS\u0010HJ\u001F\u0010T\u001A\u00020\u00152\u0006\u0010J\u001A\u00020\u00042\u0006\u0010K\u001A\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\bUJO\u0010V\u001A\u00020\u00152>\u0010W\u001A:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\bY\u0012\b\bZ\u0012\u0004\b\b(\u000B\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\r¢\u0006\f\bY\u0012\b\bZ\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00150XH\u0080\u0080\u0004¢\u0006\u0002\b[R\u000F\u0010\u000B\u001A\u00020\u0004X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\rX\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\u000FR\u001F\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u0004@RX\u0096\u008E\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006]"}, d2={"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "<init>", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "head", "elementData", "", "", "[Ljava/lang/Object;", "value", "size", "getSize", "()I", "ensureCapacity", "", "minCapacity", "copyElements", "newCapacity", "internalGet", "internalIndex", "(I)Ljava/lang/Object;", "positiveMod", "index", "negativeMod", "incremented", "decremented", "isEmpty", "", "first", "()Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "addFirst", "element", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "copyCollectionElements", "addAll", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "filterInPlace", "predicate", "Lkotlin/Function1;", "clear", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "removeRange", "fromIndex", "toIndex", "removeRangeShiftPreceding", "removeRangeShiftSucceeding", "nullifyNonEmpty", "internalFromIndex", "internalToIndex", "registerModification", "testToArray", "testToArray$kotlin_stdlib", "testRemoveRange", "testRemoveRange$kotlin_stdlib", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class ArrayDeque extends AbstractMutableList {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000F\u0010\u0007\u001A\u00020\bX\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Lkotlin/collections/ArrayDeque$Companion;", "", "<init>", "()V", "emptyElementData", "", "[Ljava/lang/Object;", "defaultMinCapacity", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    private static final int defaultMinCapacity = 10;
    private Object[] elementData;
    private static final Object[] emptyElementData;
    private int head;
    private int size;

    static {
        ArrayDeque.Companion = new Companion(null);
        ArrayDeque.emptyElementData = new Object[0];
    }

    public ArrayDeque() {
        super();
        this.elementData = ArrayDeque.emptyElementData;
    }

    public ArrayDeque(int arg3) {
        Object[] v3;
        super();
        if(arg3 == 0) {
            v3 = ArrayDeque.emptyElementData;
        }
        else if(arg3 > 0) {
            v3 = new Object[arg3];
        }
        else {
            goto label_8;
        }

        this.elementData = v3;
        return;
    label_8:
        throw new IllegalArgumentException("Illegal Capacity: " + arg3);
    }

    public ArrayDeque(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        super();
        Object[] v2 = arg2.toArray(new Object[0]);
        this.elementData = v2;
        this.size = v2.length;
        if(v2.length == 0) {
            this.elementData = ArrayDeque.emptyElementData;
        }
    }

    public void add(int arg8, Object arg9) {
        Object[] v2_1;
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(arg8, this.size());
        if(arg8 == this.size()) {
            this.addLast(arg9);
            return;
        }

        if(arg8 == 0) {
            this.addFirst(arg9);
            return;
        }

        this.registerModification();
        this.ensureCapacity(this.size() + 1);
        int v0 = this.positiveMod(this.head + arg8);
        if(arg8 < this.size() + 1 >> 1) {
            arg8 = this.decremented(v0);
            v0 = this.decremented(this.head);
            int v2 = this.head;
            Object[] v4 = this.elementData;
            if(arg8 >= v2) {
                v4[v0] = v4[v2];
                ArraysKt.copyInto(v4, v4, v2, v2 + 1, arg8 + 1);
            }
            else {
                ArraysKt.copyInto(v4, v4, v2 - 1, v2, v4.length);
                v2_1 = this.elementData;
                ((Object[])v2)[((Object[])v2).length - 1] = ((Object[])v2)[0];
                ArraysKt.copyInto(v2_1, v2_1, 0, 1, arg8 + 1);
            }

            this.elementData[arg8] = arg9;
            this.head = v0;
        }
        else {
            arg8 = this.positiveMod(this.head + this.size());
            v2_1 = this.elementData;
            if(v0 < arg8) {
                ArraysKt.copyInto(v2_1, v2_1, v0 + 1, v0, arg8);
            }
            else {
                ArraysKt.copyInto(v2_1, v2_1, 1, 0, arg8);
                Object[] v8 = this.elementData;
                v8[0] = v8[v8.length - 1];
                ArraysKt.copyInto(v8, v8, v0 + 1, v0, v8.length - 1);
            }

            this.elementData[v0] = arg9;
        }

        this.size = this.size() + 1;
    }

    @IgnorableReturnValue public boolean add(Object arg1) {
        this.addLast(arg1);
        return 1;
    }

    @IgnorableReturnValue public boolean addAll(int arg9, Collection arg10) {
        Object[] v4;
        Intrinsics.checkNotNullParameter(arg10, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(arg9, this.size());
        if(arg10.isEmpty()) {
            return 0;
        }

        if(arg9 == this.size()) {
            return this.addAll(arg10);
        }

        this.registerModification();
        this.ensureCapacity(this.size() + arg10.size());
        int v0 = this.positiveMod(this.head + this.size());
        int v2 = this.positiveMod(this.head + arg9);
        int v3 = arg10.size();
        if(arg9 < this.size() + 1 >> 1) {
            arg9 = this.head;
            v0 = arg9 - v3;
            if(v2 >= arg9) {
                v4 = this.elementData;
                if(v0 >= 0) {
                    ArraysKt.copyInto(v4, v4, v0, arg9, v2);
                }
                else {
                    v0 += v4.length;
                    int v7 = v4.length - v0;
                    if(v7 >= v2 - arg9) {
                        ArraysKt.copyInto(v4, v4, v0, arg9, v2);
                    }
                    else {
                        ArraysKt.copyInto(v4, v4, v0, arg9, arg9 + v7);
                        ArraysKt.copyInto(this.elementData, this.elementData, 0, this.head + v7, v2);
                    }
                }
            }
            else {
                ArraysKt.copyInto(this.elementData, this.elementData, v0, arg9, this.elementData.length);
                Object[] v9 = this.elementData;
                if(v3 >= v2) {
                    ArraysKt.copyInto(v9, v9, v9.length - v3, 0, v2);
                }
                else {
                    ArraysKt.copyInto(v9, v9, v9.length - v3, 0, v3);
                    ArraysKt.copyInto(this.elementData, this.elementData, 0, v3, v2);
                }
            }

            this.head = v0;
            this.copyCollectionElements(this.negativeMod(v2 - v3), arg10);
        }
        else {
            arg9 = v2 + v3;
            v4 = this.elementData;
            if(v2 < v0) {
                v3 += v0;
                if(v3 <= v4.length) {
                    ArraysKt.copyInto(v4, v4, arg9, v2, v0);
                }
                else if(arg9 >= v4.length) {
                    ArraysKt.copyInto(v4, v4, arg9 - v4.length, v2, v0);
                }
                else {
                    v3 = v0 - (v3 - v4.length);
                    ArraysKt.copyInto(v4, v4, 0, v3, v0);
                    ArraysKt.copyInto(this.elementData, this.elementData, arg9, v2, v3);
                }
            }
            else {
                ArraysKt.copyInto(v4, v4, v3, 0, v0);
                Object[] v0_1 = this.elementData;
                if(arg9 >= v0_1.length) {
                    ArraysKt.copyInto(v0_1, v0_1, arg9 - v0_1.length, v2, v0_1.length);
                }
                else {
                    ArraysKt.copyInto(v0_1, v0_1, 0, v0_1.length - v3, v0_1.length);
                    ArraysKt.copyInto(this.elementData, this.elementData, arg9, v2, this.elementData.length - v3);
                }
            }

            this.copyCollectionElements(v2, arg10);
        }

        return 1;
    }

    @IgnorableReturnValue public boolean addAll(Collection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "elements");
        if(arg3.isEmpty()) {
            return 0;
        }

        this.registerModification();
        this.ensureCapacity(this.size() + arg3.size());
        this.copyCollectionElements(this.positiveMod(this.head + this.size()), arg3);
        return 1;
    }

    public final void addFirst(Object arg3) {
        this.registerModification();
        this.ensureCapacity(this.size() + 1);
        int v0 = this.decremented(this.head);
        this.head = v0;
        this.elementData[v0] = arg3;
        this.size = this.size() + 1;
    }

    public final void addLast(Object arg4) {
        this.registerModification();
        this.ensureCapacity(this.size() + 1);
        this.elementData[this.positiveMod(this.head + this.size())] = arg4;
        this.size = this.size() + 1;
    }

    public void clear() {
        if(!this.isEmpty()) {
            this.registerModification();
            this.nullifyNonEmpty(this.head, this.positiveMod(this.head + this.size()));
        }

        this.head = 0;
        this.size = 0;
    }

    public boolean contains(Object arg1) {
        if(this.indexOf(arg1) != -1) {
            return 1;
        }

        return 0;
    }

    private final void copyCollectionElements(int arg5, Collection arg6) {
        Iterator v0 = arg6.iterator();
        int v1 = this.elementData.length;
        while(arg5 < v1) {
            if(!v0.hasNext()) {
                break;
            }

            this.elementData[arg5] = v0.next();
            ++arg5;
        }

        arg5 = this.head;
        for(v1 = 0; v1 < arg5; ++v1) {
            if(!v0.hasNext()) {
                break;
            }

            this.elementData[v1] = v0.next();
        }

        this.size = this.size() + arg6.size();
    }

    private final void copyElements(int arg5) {
        Object[] v5 = new Object[arg5];
        ArraysKt.copyInto(this.elementData, v5, 0, this.head, this.elementData.length);
        ArraysKt.copyInto(this.elementData, v5, this.elementData.length - this.head, 0, this.head);
        this.head = 0;
        this.elementData = v5;
    }

    private final int decremented(int arg1) {
        if(arg1 == 0) {
            return ArraysKt.getLastIndex(this.elementData);
        }

        return arg1 - 1;
    }

    private final void ensureCapacity(int arg3) {
        if(arg3 >= 0) {
            Object[] v0 = this.elementData;
            if(arg3 <= v0.length) {
                return;
            }

            if(v0 == ArrayDeque.emptyElementData) {
                this.elementData = new Object[RangesKt.coerceAtLeast(arg3, 10)];
                return;
            }

            this.copyElements(AbstractList.Companion.newCapacity$kotlin_stdlib(this.elementData.length, arg3));
            return;
        }

        throw new IllegalStateException("Deque is too big.");
    }

    private final boolean filterInPlace(Function1 arg12) {
        boolean v1_1;
        Object v6_1;
        Object[] v6;
        int v5;
        int v1 = 0;
        if(!this.isEmpty()) {
            if(this.elementData.length == 0) {
            }
            else {
                int v0 = this.positiveMod(this.head + this.size());
                int v2 = this.head;
                Object v3 = null;
                if(v2 < v0) {
                    v5 = v2;
                    while(true) {
                        v6 = this.elementData;
                        if(v2 >= v0) {
                            break;
                        }

                        v6_1 = v6[v2];
                        if(arg12.invoke(v6_1).booleanValue()) {
                            this.elementData[v5] = v6_1;
                            ++v5;
                        }
                        else {
                            v1_1 = true;
                        }

                        ++v2;
                    }

                    ArraysKt.fill(v6, v3, v5, v0);
                }
                else {
                    v5 = this.elementData.length;
                    boolean v7 = false;
                    int v6_2 = v2;
                    while(v2 < v5) {
                        Object[] v8 = this.elementData;
                        Object v9 = v8[v2];
                        v8[v2] = v3;
                        if(arg12.invoke(v9).booleanValue()) {
                            this.elementData[v6_2] = v9;
                            ++v6_2;
                        }
                        else {
                            v7 = true;
                        }

                        ++v2;
                    }

                    v5 = this.positiveMod(v6_2);
                    while(v1 < v0) {
                        Object[] v2_1 = this.elementData;
                        v6_1 = v2_1[v1];
                        v2_1[v1] = v3;
                        if(arg12.invoke(v6_1).booleanValue()) {
                            this.elementData[v5] = v6_1;
                            v5 = this.incremented(v5);
                        }
                        else {
                            v7 = true;
                        }

                        ++v1;
                    }

                    v1_1 = v7;
                }

                if((((int)v1_1)) == 0) {
                    return v1_1;
                }

                this.registerModification();
                this.size = this.negativeMod(v5 - this.head);
            }
        }

        return v1_1;
    }

    public final Object first() {
        if(!this.isEmpty()) {
            return this.elementData[this.head];
        }

        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object firstOrNull() {
        if(this.isEmpty()) {
            return null;
        }

        return this.elementData[this.head];
    }

    public Object get(int arg3) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this.size());
        return this.elementData[this.positiveMod(this.head + arg3)];
    }

    public int getSize() {
        return this.size;
    }

    private final int incremented(int arg1) {
        if(arg1 == ArraysKt.getLastIndex(this.elementData)) {
            return 0;
        }

        return arg1 + 1;
    }

    public int indexOf(Object arg5) {
        int v4;
        int v0 = this.positiveMod(this.head + this.size());
        int v1 = this.head;
        if(v1 < v0) {
            while(v1 < v0) {
                if(Intrinsics.areEqual(arg5, this.elementData[v1])) {
                    v4 = this.head;
                    goto label_12;
                }
                else {
                    ++v1;
                    continue;
                }
            }
        }
        else if(!this.isEmpty()) {
            v1 = this.head;
            if(v1 >= v0) {
                int v2 = this.elementData.length;
                while(true) {
                    if(v1 >= v2) {
                        break;
                    }
                    else if(Intrinsics.areEqual(arg5, this.elementData[v1])) {
                        v4 = this.head;
                        goto label_12;
                    }
                    else {
                        ++v1;
                        continue;
                    }
                }

                v1 = 0;
                while(true) {
                    if(v1 < v0) {
                        if(Intrinsics.areEqual(arg5, this.elementData[v1])) {
                            v1 += this.elementData.length;
                            v4 = this.head;
                            break;
                        }
                        else {
                            ++v1;
                            continue;
                        }
                    }

                    return -1;
                }

            label_12:
                return v1 - v4;
            }
        }

        return -1;
    }

    private final Object internalGet(int arg1) {
        return this.elementData[arg1];
    }

    private final int internalIndex(int arg2) {
        return this.positiveMod(this.head + arg2);
    }

    public final void internalStructure$kotlin_stdlib(Function2 arg3) {
        int v1;
        Intrinsics.checkNotNullParameter(arg3, "structure");
        int v0 = this.positiveMod(this.head + this.size());
        if(!this.isEmpty()) {
            v1 = this.head;
            if(v1 < v0) {
                goto label_15;
            }
            else {
                v1 -= this.elementData.length;
            }
        }
        else {
        label_15:
            v1 = this.head;
        }

        arg3.invoke(Integer.valueOf(v1), this.toArray());
    }

    public boolean isEmpty() {
        if(this.size() == 0) {
            return 1;
        }

        return 0;
    }

    public final Object last() {
        if(!this.isEmpty()) {
            return this.elementData[this.positiveMod(this.head + CollectionsKt.getLastIndex(this))];
        }

        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public int lastIndexOf(Object arg5) {
        Object[] v1_1;
        int v4;
        int v0 = this.positiveMod(this.head + this.size());
        int v1 = this.head;
        int v2 = -1;
        if(v1 < v0) {
            --v0;
            if(v1 > v0) {
                return v2;
            }

            while(!Intrinsics.areEqual(arg5, this.elementData[v0])) {
                if(v0 == v1) {
                    return v2;
                }

                --v0;
            }

            v4 = this.head;
            goto label_14;
        }
        else {
            if(this.isEmpty()) {
                return v2;
            }

            if(this.head < v0) {
                return v2;
            }

            --v0;
            while(true) {
                v1_1 = this.elementData;
                if(v2 >= v0) {
                    break;
                }

                if(Intrinsics.areEqual(arg5, v1_1[v0])) {
                    v0 += this.elementData.length;
                    v4 = this.head;
                    goto label_14;
                }

                --v0;
            }

            v0 = ArraysKt.getLastIndex(v1_1);
            v1 = this.head;
            if(v1 > v0) {
                return v2;
            }

            while(!Intrinsics.areEqual(arg5, this.elementData[v0])) {
                if(v0 == v1) {
                    return v2;
                }

                --v0;
            }

            v4 = this.head;
        label_14:
            return v0 - v4;
        }

        return v2;
    }

    public final Object lastOrNull() {
        if(this.isEmpty()) {
            return null;
        }

        return this.elementData[this.positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    private final int negativeMod(int arg1) {
        if(arg1 < 0) {
            arg1 += this.elementData.length;
        }

        return arg1;
    }

    private final void nullifyNonEmpty(int arg4, int arg5) {
        Object[] v0 = this.elementData;
        Object v1 = null;
        if(arg4 < arg5) {
            ArraysKt.fill(v0, v1, arg4, arg5);
            return;
        }

        ArraysKt.fill(v0, v1, arg4, v0.length);
        ArraysKt.fill(this.elementData, v1, 0, arg5);
    }

    private final int positiveMod(int arg2) {
        Object[] v1 = this.elementData;
        if(arg2 >= v1.length) {
            arg2 -= v1.length;
        }

        return arg2;
    }

    private final void registerModification() {
        ++this.modCount;
    }

    @IgnorableReturnValue public boolean remove(Object arg2) {
        int v2 = this.indexOf(arg2);
        if(v2 == -1) {
            return 0;
        }

        this.removeAt(v2);
        return 1;
    }

    @IgnorableReturnValue public boolean removeAll(Collection arg12) {
        boolean v1_1;
        Object v6_1;
        Object[] v6;
        int v5;
        Intrinsics.checkNotNullParameter(arg12, "elements");
        int v1 = 0;
        if(!this.isEmpty()) {
            if(this.elementData.length == 0) {
            }
            else {
                int v0 = this.positiveMod(this.head + this.size());
                int v2 = this.head;
                Object v3 = null;
                if(v2 < v0) {
                    v5 = v2;
                    while(true) {
                        v6 = this.elementData;
                        if(v2 >= v0) {
                            break;
                        }

                        v6_1 = v6[v2];
                        if(!arg12.contains(v6_1)) {
                            this.elementData[v5] = v6_1;
                            ++v5;
                        }
                        else {
                            v1_1 = true;
                        }

                        ++v2;
                    }

                    ArraysKt.fill(v6, v3, v5, v0);
                }
                else {
                    v5 = this.elementData.length;
                    boolean v7 = false;
                    int v6_2 = v2;
                    while(v2 < v5) {
                        Object[] v8 = this.elementData;
                        Object v9 = v8[v2];
                        v8[v2] = v3;
                        if(!arg12.contains(v9)) {
                            this.elementData[v6_2] = v9;
                            ++v6_2;
                        }
                        else {
                            v7 = true;
                        }

                        ++v2;
                    }

                    v5 = this.positiveMod(v6_2);
                    while(v1 < v0) {
                        Object[] v2_1 = this.elementData;
                        v6_1 = v2_1[v1];
                        v2_1[v1] = v3;
                        if(!arg12.contains(v6_1)) {
                            this.elementData[v5] = v6_1;
                            v5 = this.incremented(v5);
                        }
                        else {
                            v7 = true;
                        }

                        ++v1;
                    }

                    v1_1 = v7;
                }

                if((((int)v1_1)) == 0) {
                    return v1_1;
                }

                this.registerModification();
                this.size = this.negativeMod(v5 - this.head);
            }
        }

        return v1_1;
    }

    @IgnorableReturnValue public Object removeAt(int arg9) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg9, this.size());
        ArrayDeque v0 = this;
        if(arg9 == CollectionsKt.getLastIndex(((List)v0))) {
            return this.removeLast();
        }

        if(arg9 == 0) {
            return this.removeFirst();
        }

        this.registerModification();
        int v1 = this.positiveMod(this.head + arg9);
        Object v2 = this.elementData[v1];
        int v3 = this.size() >> 1;
        int v5 = this.head;
        Object v6 = null;
        if(arg9 < v3) {
            Object[] v9 = this.elementData;
            if(v1 >= v5) {
                ArraysKt.copyInto(v9, v9, v5 + 1, v5, v1);
            }
            else {
                ArraysKt.copyInto(v9, v9, 1, 0, v1);
                v9 = this.elementData;
                v9[0] = v9[v9.length - 1];
                ArraysKt.copyInto(v9, v9, this.head + 1, this.head, v9.length - 1);
            }

            v9 = this.elementData;
            int v0_1 = this.head;
            v9[v0_1] = v6;
            this.head = this.incremented(v0_1);
        }
        else {
            arg9 = this.positiveMod(v5 + CollectionsKt.getLastIndex(((List)v0)));
            Object[] v0_2 = this.elementData;
            if(v1 <= arg9) {
                ArraysKt.copyInto(v0_2, v0_2, v1, v1 + 1, arg9 + 1);
            }
            else {
                ArraysKt.copyInto(v0_2, v0_2, v1, v1 + 1, v0_2.length);
                v0_2 = this.elementData;
                v0_2[v0_2.length - 1] = v0_2[0];
                ArraysKt.copyInto(v0_2, v0_2, 0, 1, arg9 + 1);
            }

            this.elementData[arg9] = v6;
        }

        this.size = this.size() - 1;
        return v2;
    }

    @IgnorableReturnValue public final Object removeFirst() {
        if(!this.isEmpty()) {
            this.registerModification();
            Object[] v0 = this.elementData;
            int v1 = this.head;
            Object v2 = v0[v1];
            v0[v1] = null;
            this.head = this.incremented(v1);
            this.size = this.size() - 1;
            return v2;
        }

        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @IgnorableReturnValue public final Object removeFirstOrNull() {
        if(this.isEmpty()) {
            return null;
        }

        return this.removeFirst();
    }

    @IgnorableReturnValue public final Object removeLast() {
        if(!this.isEmpty()) {
            this.registerModification();
            int v0 = this.positiveMod(this.head + CollectionsKt.getLastIndex(this));
            Object[] v1 = this.elementData;
            Object v2 = v1[v0];
            v1[v0] = null;
            this.size = this.size() - 1;
            return v2;
        }

        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @IgnorableReturnValue public final Object removeLastOrNull() {
        if(this.isEmpty()) {
            return null;
        }

        return this.removeLast();
    }

    protected void removeRange(int arg3, int arg4) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(arg3, arg4, this.size());
        int v0 = arg4 - arg3;
        if(v0 == 0) {
            return;
        }

        if(v0 == this.size()) {
            this.clear();
            return;
        }

        if(v0 == 1) {
            this.removeAt(arg3);
            return;
        }

        this.registerModification();
        if(arg3 < this.size() - arg4) {
            this.removeRangeShiftPreceding(arg3, arg4);
            arg3 = this.positiveMod(this.head + v0);
            this.nullifyNonEmpty(this.head, arg3);
            this.head = arg3;
        }
        else {
            this.removeRangeShiftSucceeding(arg3, arg4);
            arg3 = this.positiveMod(this.head + this.size());
            this.nullifyNonEmpty(this.negativeMod(arg3 - v0), arg3);
        }

        this.size = this.size() - v0;
    }

    private final void removeRangeShiftPreceding(int arg7, int arg8) {
        int v0 = this.positiveMod(this.head + (arg7 - 1));
        arg8 = this.positiveMod(this.head + (arg8 - 1));
        while(arg7 > 0) {
            int v1 = v0 + 1;
            int v2 = Math.min(arg7, Math.min(v1, arg8 + 1));
            arg8 -= v2;
            v0 -= v2;
            ArraysKt.copyInto(this.elementData, this.elementData, arg8 + 1, v0 + 1, v1);
            v0 = this.negativeMod(v0);
            arg8 = this.negativeMod(arg8);
            arg7 -= v2;
        }
    }

    private final void removeRangeShiftSucceeding(int arg5, int arg6) {
        int v0 = this.positiveMod(this.head + arg6);
        arg5 = this.positiveMod(this.head + arg5);
        int v1 = this.size();
        while(true) {
            v1 -= arg6;
            if(v1 <= 0) {
                return;
            }

            arg6 = Math.min(v1, Math.min(this.elementData.length - v0, this.elementData.length - arg5));
            int v3 = v0 + arg6;
            ArraysKt.copyInto(this.elementData, this.elementData, arg5, v0, v3);
            v0 = this.positiveMod(v3);
            arg5 = this.positiveMod(arg5 + arg6);
        }
    }

    @IgnorableReturnValue public boolean retainAll(Collection arg12) {
        boolean v1_1;
        Object v6_1;
        Object[] v6;
        int v5;
        Intrinsics.checkNotNullParameter(arg12, "elements");
        int v1 = 0;
        if(!this.isEmpty()) {
            if(this.elementData.length == 0) {
            }
            else {
                int v0 = this.positiveMod(this.head + this.size());
                int v2 = this.head;
                Object v3 = null;
                if(v2 < v0) {
                    v5 = v2;
                    while(true) {
                        v6 = this.elementData;
                        if(v2 >= v0) {
                            break;
                        }

                        v6_1 = v6[v2];
                        if(arg12.contains(v6_1)) {
                            this.elementData[v5] = v6_1;
                            ++v5;
                        }
                        else {
                            v1_1 = true;
                        }

                        ++v2;
                    }

                    ArraysKt.fill(v6, v3, v5, v0);
                }
                else {
                    v5 = this.elementData.length;
                    boolean v7 = false;
                    int v6_2 = v2;
                    while(v2 < v5) {
                        Object[] v8 = this.elementData;
                        Object v9 = v8[v2];
                        v8[v2] = v3;
                        if(arg12.contains(v9)) {
                            this.elementData[v6_2] = v9;
                            ++v6_2;
                        }
                        else {
                            v7 = true;
                        }

                        ++v2;
                    }

                    v5 = this.positiveMod(v6_2);
                    while(v1 < v0) {
                        Object[] v2_1 = this.elementData;
                        v6_1 = v2_1[v1];
                        v2_1[v1] = v3;
                        if(arg12.contains(v6_1)) {
                            this.elementData[v5] = v6_1;
                            v5 = this.incremented(v5);
                        }
                        else {
                            v7 = true;
                        }

                        ++v1;
                    }

                    v1_1 = v7;
                }

                if(v1 == 0) {
                    goto label_73;
                }

                this.registerModification();
                this.size = this.negativeMod(v5 - this.head);
            }
        }

    label_73:
        return ((boolean)v1);
    }

    @IgnorableReturnValue public Object set(int arg3, Object arg4) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this.size());
        arg3 = this.positiveMod(this.head + arg3);
        Object[] v2 = this.elementData;
        Object v0 = v2[arg3];
        v2[arg3] = arg4;
        return v0;
    }

    public final void testRemoveRange$kotlin_stdlib(int arg1, int arg2) {
        this.removeRange(arg1, arg2);
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return this.toArray();
    }

    public final Object[] testToArray$kotlin_stdlib(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "array");
        return this.toArray(arg2);
    }

    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }

    public Object[] toArray(Object[] arg8) {
        Intrinsics.checkNotNullParameter(arg8, "array");
        if(arg8.length >= this.size()) {
        }
        else {
            arg8 = ArraysKt.arrayOfNulls(arg8, this.size());
        }

        Object[] v1 = arg8;
        int v4 = this.positiveMod(this.head + this.size());
        int v3 = this.head;
        if(v3 < v4) {
            ArraysKt.copyInto$default(this.elementData, v1, 0, v3, v4, 2, null);
        }
        else if(!this.isEmpty()) {
            ArraysKt.copyInto(this.elementData, v1, 0, this.head, this.elementData.length);
            ArraysKt.copyInto(this.elementData, v1, this.elementData.length - this.head, 0, v4);
        }

        return CollectionsKt.terminateCollectionToArray(this.size(), v1);
    }
}

