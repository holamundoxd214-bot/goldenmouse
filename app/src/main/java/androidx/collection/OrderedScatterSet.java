package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J:\u0010\u0019\u001A\u00020\u001A2!\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010 \u001A\u00020\u001AJ:\u0010 \u001A\u00020\u001A2!\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\f\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\"J\u0016\u0010#\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001A\u00020\u0005H\u0007J:\u0010%\u001A\u00020\u00052!\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u0010&\u001A\u00020\u001A2\b\u0010\'\u001A\u0004\u0018\u00010\u0002H\u0096\u0002J\u0018\u0010(\u001A\u00020\u00052\u0006\u0010\u001F\u001A\u00028\u0000H\u0080\b¢\u0006\u0004\b)\u0010*J\u000B\u0010+\u001A\u00028\u0000¢\u0006\u0002\u0010,J?\u0010+\u001A\u00028\u00002!\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010-JA\u0010.\u001A\u0004\u0018\u00018\u00002!\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010-J:\u0010/\u001A\u0002002!\u00101\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u0002000\u001CH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J?\u00102\u001A\u0002002!\u00101\u001A\u001D\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(3\u0012\u0004\u0012\u0002000\u001CH\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\b4J:\u00105\u001A\u0002002!\u00101\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u0002000\u001CH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u00106\u001A\u00020\u0005H\u0016J\u0006\u00107\u001A\u00020\u001AJ\u0006\u00108\u001A\u00020\u001AJR\u00109\u001A\u00020:2\b\b\u0002\u0010;\u001A\u00020<2\b\b\u0002\u0010=\u001A\u00020<2\b\b\u0002\u0010>\u001A\u00020<2\b\b\u0002\u0010?\u001A\u00020\u00052\b\b\u0002\u0010@\u001A\u00020<2\u0016\b\u0002\u0010A\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020<\u0018\u00010\u001CH\u0007J\u000B\u0010B\u001A\u00028\u0000¢\u0006\u0002\u0010,J?\u0010B\u001A\u00028\u00002!\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010-JA\u0010C\u001A\u0004\u0018\u00018\u00002!\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010-J\u0006\u0010D\u001A\u00020\u001AJ\u000F\u0010E\u001A\b\u0012\u0004\u0012\u00028\u00000FH\u0086\bJ\b\u0010G\u001A\u00020:H\u0016J:\u0010H\u001A\u0002002!\u00101\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u0002000\u001CH\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010I\u001A\u0002002!\u00101\u001A\u001D\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(3\u0012\u0004\u0012\u0002000\u001CH\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001R\u0012\u0010\u0004\u001A\u00020\u00058\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u00020\u00058\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\"\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000B8\u0000@\u0000X\u0081\u000E¢\u0006\n\n\u0002\u0010\r\u0012\u0004\b\f\u0010\u0003R\u0018\u0010\u000E\u001A\u00020\u00058\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u000F\u0010\u0003R\u0018\u0010\u0010\u001A\u00020\u00118\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u0018\u0010\u0013\u001A\u00020\u00118\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003R\u0011\u0010\u0015\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0016\u0010\tR\u0018\u0010\u0017\u001A\u00020\u00058\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0003\u0082\u0001\u0001J\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006K"}, d2={"Landroidx/collection/OrderedScatterSet;", "E", "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "elements", "", "getElements$annotations", "[Ljava/lang/Object;", "head", "getHead$annotations", "metadata", "", "getMetadata$annotations", "nodes", "getNodes$annotations", "size", "getSize", "tail", "getTail$annotations", "all", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "any", "asSet", "", "contains", "(Ljava/lang/Object;)Z", "count", "equals", "other", "findElementIndex", "findElementIndex$collection", "(Ljava/lang/Object;)I", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "forEach", "", "block", "forEachIndex", "index", "forEachIndex$collection", "forEachReverse", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "last", "lastOrNull", "none", "toList", "", "toString", "unorderedForEach", "unorderedForEachIndex", "Landroidx/collection/MutableOrderedScatterSet;", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public abstract class OrderedScatterSet {
    public int _capacity;
    public int _size;
    public Object[] elements;
    public int head;
    public long[] metadata;
    public long[] nodes;
    public int tail;

    private OrderedScatterSet() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = ContainerHelpersKt.EMPTY_OBJECTS;
        this.nodes = SieveCacheKt.getEmptyNodes();
        this.head = 0x7FFFFFFF;
        this.tail = 0x7FFFFFFF;
    }

    public OrderedScatterSet(DefaultConstructorMarker arg1) {
        this();
    }

    public final boolean all(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "predicate");
        Object[] v0 = this.elements;
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
                        if((0xFF & v4) < 0x80 && !arg14.invoke(v0[(v3 << 3) + v8]).booleanValue()) {
                            return 0;
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return 1;
                    }
                }

                if(v3 == v1) {
                    return 1;
                }
            }
        }

        return 1;
    }

    public final boolean any() {
        if(this._size != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean any(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "predicate");
        Object[] v0 = this.elements;
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
                        if((0xFF & v4) < 0x80 && (arg14.invoke(v0[(v3 << 3) + v8]).booleanValue())) {
                            return 1;
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

    public final Set asSet() {
        return new OrderedSetWrapper(this);
    }

    public final boolean contains(Object arg18) {
        int v11;
        OrderedScatterSet v0 = this;
        Object v1 = arg18;
        int v3 = v1 != null ? v1.hashCode() : 0;
        v3 *= 0xCC9E2D51;
        v3 ^= v3 << 16;
        int v4 = v3 & 0x7F;
        int v5 = v0._capacity;
        v3 = v3 >>> 7 & v5;
        int v6 = 0;
        while(true) {
            int v8 = v3 >> 3;
            int v9 = (v3 & 7) << 3;
            long v7 = v0.metadata[v8 + 1] << 0x40 - v9 & -(((long)v9)) >> 0x3F | v0.metadata[v8] >>> v9;
            long v9_1 = (((long)v4)) * 0x101010101010101L ^ v7;
            long v13 = -9187201950435737472L;
            v9_1 = ~v9_1 & v9_1 - 0x101010101010101L & v13;
            while(true) {
                long v15 = 0;
                if(v9_1 != v15) {
                    v11 = (Long.numberOfTrailingZeros(v9_1) >> 3) + v3 & v5;
                    if(Intrinsics.areEqual(v0.elements[v11], v1)) {
                    }
                    else {
                        v9_1 &= v9_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_64;
            }

            if((v7 & ~v7 << 6 & v13) != v15) {
                v11 = -1;
            }
            else {
                goto label_67;
            }

        label_64:
            if(v11 >= 0) {
                return 1;
            }

            return 0;
        label_67:
            v6 += 8;
            v3 = v3 + v6 & v5;
        }
    }

    public final int count() {
        return this.getSize();
    }

    public final int count(Function1 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "predicate");
        Object[] v0 = this.elements;
        long[] v14 = this.metadata;
        int v1 = v14.length - 2;
        if(v1 >= 0) {
            int v3 = 0;
            int v4 = 0;
            while(true) {
                long v5 = v14[v3];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80 && (arg15.invoke(v0[(v3 << 3) + v9]).booleanValue())) {
                            ++v4;
                        }

                        v5 >>= v8;
                    }

                    if(v7 == v8) {
                        goto label_42;
                    }

                    return v4;
                }

            label_42:
                if(v3 == v1) {
                    return v4;
                }

                ++v3;
            }

            return v4;
        }

        return 0;
    }

    public boolean equals(Object arg15) {
        if((((OrderedScatterSet)arg15)) == this) {
            return 1;
        }

        if(!(arg15 instanceof OrderedScatterSet)) {
            return 0;
        }

        if(((OrderedScatterSet)arg15).getSize() != this.getSize()) {
            return 0;
        }

        Object[] v1 = this.elements;
        long[] v14 = this.metadata;
        int v3 = v14.length - 2;
        if(v3 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v14[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v3) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80 && !((OrderedScatterSet)arg15).contains(v1[(v4 << 3) + v9])) {
                            return 0;
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return 1;
                    }
                }

                if(v4 == v3) {
                    return 1;
                }
            }
        }

        return 1;
    }

    public final int findElementIndex$collection(Object arg14) {
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
                if(Intrinsics.areEqual(this.elements[v10_1], arg14)) {
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

    public final Object first() {
        Object[] v0 = this.elements;
        long[] v1 = this.nodes;
        int v4 = this.tail;
        if(v4 != 0x7FFFFFFF) {
            return v0[v4];
        }

        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("The OrderedScatterSet is empty");
        throw new KotlinNothingValueException();
    }

    public final Object first(Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "predicate");
        Object[] v0 = this.elements;
        long[] v1 = this.nodes;
        int v6;
        for(v6 = this.tail; v6 != 0x7FFFFFFF; v6 = v2) {
            int v2 = ((int)(v1[v6] >> 0x1F & 0x7FFFFFFF));
            Object v6_1 = v0[v6];
            if(arg7.invoke(v6_1).booleanValue()) {
                return v6_1;
            }
        }

        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("Could not find a match");
        throw new KotlinNothingValueException();
    }

    public final Object firstOrNull(Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "predicate");
        Object[] v0 = this.elements;
        long[] v1 = this.nodes;
        int v6;
        for(v6 = this.tail; v6 != 0x7FFFFFFF; v6 = v2) {
            int v2 = ((int)(v1[v6] >> 0x1F & 0x7FFFFFFF));
            Object v6_1 = v0[v6];
            if(arg7.invoke(v6_1).booleanValue()) {
                return v6_1;
            }
        }

        return null;
    }

    public final void forEach(Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "block");
        Object[] v0 = this.elements;
        long[] v1 = this.nodes;
        int v6;
        for(v6 = this.tail; v6 != 0x7FFFFFFF; v6 = v2) {
            int v2 = ((int)(v1[v6] >> 0x1F & 0x7FFFFFFF));
            arg7.invoke(v0[v6]);
        }
    }

    public final void forEachIndex$collection(Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg6, "block");
        long[] v0 = this.nodes;
        int v5;
        for(v5 = this.tail; v5 != 0x7FFFFFFF; v5 = v1) {
            int v1 = ((int)(v0[v5] >> 0x1F & 0x7FFFFFFF));
            arg6.invoke(Integer.valueOf(v5));
        }
    }

    public final void forEachReverse(Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "block");
        Object[] v0 = this.elements;
        long[] v1 = this.nodes;
        int v6;
        for(v6 = this.head; v6 != 0x7FFFFFFF; v6 = v2) {
            int v2 = ((int)(v1[v6] & 0x7FFFFFFF));
            arg7.invoke(v0[v6]);
        }
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public static void getElements$annotations() {
    }

    public static void getHead$annotations() {
    }

    public static void getMetadata$annotations() {
    }

    public static void getNodes$annotations() {
    }

    public final int getSize() {
        return this._size;
    }

    public static void getTail$annotations() {
    }

    public int hashCode() {
        int v0 = this._capacity * 0x1F + this._size;
        Object[] v1 = this.elements;
        long[] v2 = this.metadata;
        int v3 = v2.length - 2;
        if(v3 >= 0) {
            int v5;
            for(v5 = 0; true; ++v5) {
                long v6 = v2[v5];
                if((~v6 << 7 & v6 & -9187201950435737472L) != -9187201950435737472L) {
                    int v9 = 8;
                    int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                    int v10;
                    for(v10 = 0; v10 < v8; ++v10) {
                        if((0xFF & v6) < 0x80) {
                            Object v11 = v1[(v5 << 3) + v10];
                            if(!Intrinsics.areEqual(v11, this)) {
                                int v11_1 = v11 != null ? v11.hashCode() : 0;
                                v0 += v11_1;
                            }
                        }

                        v6 >>= v9;
                    }

                    if(v8 == v9) {
                        goto label_46;
                    }

                    return v0;
                }

            label_46:
                if(v5 == v3) {
                    return v0;
                }
            }
        }

        return v0;
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

    public final String joinToString(CharSequence arg8, CharSequence arg9, CharSequence arg10, int arg11, CharSequence arg12, Function1 arg13) {
        Intrinsics.checkNotNullParameter(arg8, "separator");
        Intrinsics.checkNotNullParameter(arg9, "prefix");
        Intrinsics.checkNotNullParameter(arg10, "postfix");
        Intrinsics.checkNotNullParameter(arg12, "truncated");
        StringBuilder v0 = new StringBuilder();
        v0.append(arg9);
        Object[] v9 = this.elements;
        long[] v1 = this.nodes;
        int v7 = this.tail;
        int v2 = 0;
        while(true) {
            if(v7 != 0x7FFFFFFF) {
                int v3 = ((int)(v1[v7] >> 0x1F & 0x7FFFFFFF));
                Object v7_1 = v9[v7];
                if(v2 == arg11) {
                    v0.append(arg12);
                }
                else {
                    if(v2 != 0) {
                        v0.append(arg8);
                    }

                    if(arg13 == null) {
                        v0.append(v7_1);
                    }
                    else {
                        v0.append(arg13.invoke(v7_1));
                    }

                    ++v2;
                    v7 = v3;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_38;
        }

        v0.append(arg10);
    label_38:
        String v7_2 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v7_2, "toString(...)");
        return v7_2;
    }

    public final String joinToString() {
        return OrderedScatterSet.joinToString$default(this, null, null, null, 0, null, null, 0x3F, null);
    }

    public final String joinToString(CharSequence arg11) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        return OrderedScatterSet.joinToString$default(this, arg11, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        return OrderedScatterSet.joinToString$default(this, arg11, arg12, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12, CharSequence arg13) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        Intrinsics.checkNotNullParameter(arg13, "postfix");
        return OrderedScatterSet.joinToString$default(this, arg11, arg12, arg13, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12, CharSequence arg13, int arg14) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        Intrinsics.checkNotNullParameter(arg13, "postfix");
        return OrderedScatterSet.joinToString$default(this, arg11, arg12, arg13, arg14, null, null, 0x30, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12, CharSequence arg13, int arg14, CharSequence arg15) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        Intrinsics.checkNotNullParameter(arg13, "postfix");
        Intrinsics.checkNotNullParameter(arg15, "truncated");
        return OrderedScatterSet.joinToString$default(this, arg11, arg12, arg13, arg14, arg15, null, 0x20, null);
    }

    public static String joinToString$default(OrderedScatterSet arg1, CharSequence arg2, CharSequence arg3, CharSequence arg4, int arg5, CharSequence arg6, Function1 arg7, int arg8, Object arg9) {
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
        Object[] v0 = this.elements;
        long[] v1 = this.nodes;
        int v4 = this.head;
        if(v4 != 0x7FFFFFFF) {
            return v0[v4];
        }

        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("The OrderedScatterSet is empty");
        throw new KotlinNothingValueException();
    }

    public final Object last(Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "predicate");
        Object[] v0 = this.elements;
        long[] v1 = this.nodes;
        int v6;
        for(v6 = this.head; v6 != 0x7FFFFFFF; v6 = v2) {
            int v2 = ((int)(v1[v6] & 0x7FFFFFFF));
            Object v6_1 = v0[v6];
            if(arg7.invoke(v6_1).booleanValue()) {
                return v6_1;
            }
        }

        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("Could not find a match");
        throw new KotlinNothingValueException();
    }

    public final Object lastOrNull(Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "predicate");
        Object[] v0 = this.elements;
        long[] v1 = this.nodes;
        int v6;
        for(v6 = this.head; v6 != 0x7FFFFFFF; v6 = v2) {
            int v2 = ((int)(v1[v6] & 0x7FFFFFFF));
            Object v6_1 = v0[v6];
            if(arg7.invoke(v6_1).booleanValue()) {
                return v6_1;
            }
        }

        return null;
    }

    public final boolean none() {
        if(this._size == 0) {
            return 1;
        }

        return 0;
    }

    public final List toList() {
        ArrayList v0 = new ArrayList(this.getSize());
        Object[] v1 = this.elements;
        long[] v2 = this.nodes;
        int v7;
        for(v7 = this.tail; v7 != 0x7FFFFFFF; v7 = v3) {
            int v3 = ((int)(v2[v7] >> 0x1F & 0x7FFFFFFF));
            v0.add(v1[v7]);
        }

        return ((List)v0);
    }

    public String toString() {
        return OrderedScatterSet.joinToString$default(this, null, "[", "]", 0, null, new OrderedScatterSet$toString$1(this), 25, null);
    }

    public final void unorderedForEach(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "block");
        Object[] v0 = this.elements;
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
                            arg14.invoke(v0[(v3 << 3) + v8]);
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

    public final void unorderedForEachIndex(Function1 arg13) {
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
}

