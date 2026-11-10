package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000F\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010\u000B\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rJ\u0014\u0010\u000B\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u000B\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EJ\u001B\u0010\u000B\u001A\u00020\b2\u000E\u0010\f\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000F¢\u0006\u0002\u0010\u0010J\u0014\u0010\u000B\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0014\u0010\u000B\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012J\r\u0010\u0013\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0006\u0010\u0018\u001A\u00020\u0014J\r\u0010\u0019\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\u001AJ\u0015\u0010\u001B\u001A\u00020\u00042\u0006\u0010\t\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004H\u0002J\u0010\u0010\u001F\u001A\u00020\u00142\u0006\u0010 \u001A\u00020!H\u0002J\u0010\u0010\u001F\u001A\u00020\u00142\u0006\u0010 \u001A\u00020\"H\u0002J\b\u0010#\u001A\u00020\u0014H\u0002J\u0010\u0010$\u001A\u00020\u00142\u0006\u0010%\u001A\u00020\u0004H\u0002J\u0010\u0010&\u001A\u00020\u00142\u0006\u0010\u0003\u001A\u00020\u0004H\u0002J\u0016\u0010\'\u001A\u00020\u00142\u0006\u0010\t\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010(J\u0017\u0010\'\u001A\u00020\u00142\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0086\u0002J\u0017\u0010\'\u001A\u00020\u00142\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\'\u001A\u00020\u00142\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0086\u0002J\u001E\u0010\'\u001A\u00020\u00142\u000E\u0010\f\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000FH\u0086\u0002¢\u0006\u0002\u0010)J\u0017\u0010\'\u001A\u00020\u00142\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\u0002J\u0017\u0010\'\u001A\u00020\u00142\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\u0002J\u0011\u0010*\u001A\u00020\u00142\u0006\u0010+\u001A\u00020\u0004H\u0082\bJ\u0016\u0010,\u001A\u00020\u00142\u0006\u0010\t\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010(J\u0017\u0010,\u001A\u00020\u00142\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0086\u0002J\u0017\u0010,\u001A\u00020\u00142\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010,\u001A\u00020\u00142\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0086\u0002J\u001E\u0010,\u001A\u00020\u00142\u000E\u0010\f\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000FH\u0086\u0002¢\u0006\u0002\u0010)J\u0017\u0010,\u001A\u00020\u00142\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\u0002J\u0017\u0010,\u001A\u00020\u00142\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\u0002J\u0013\u0010-\u001A\u00020\b2\u0006\u0010\t\u001A\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010.\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rJ\u0014\u0010.\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010.\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EJ\u001B\u0010.\u001A\u00020\b2\u000E\u0010\f\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000F¢\u0006\u0002\u0010\u0010J\u0014\u0010.\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0014\u0010.\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0010\u0010/\u001A\u00020\u00142\u0006\u0010+\u001A\u00020\u0004H\u0001J \u00100\u001A\u00020\u00142\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b02H\u0086\bø\u0001\u0000J\u0011\u00103\u001A\u00020\u00142\u0006\u0010+\u001A\u00020\u0004H\u0082\bJ\u0015\u00104\u001A\u00020\u00142\u0006\u00105\u001A\u00020\u0004H\u0000¢\u0006\u0002\b6J \u00107\u001A\u00020\b2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b02H\u0086\bø\u0001\u0000J\u0014\u00107\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u00107\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EJ\u0014\u00107\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u000008J\b\u00109\u001A\u00020\u0004H\u0007J\u000E\u0010:\u001A\u00020\u00142\u0006\u0010;\u001A\u00020\u0004R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006<"}, d2={"Landroidx/collection/MutableOrderedScatterSet;", "E", "Landroidx/collection/OrderedScatterSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "Landroidx/collection/ObjectList;", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "adjustStorage", "", "adjustStorage$collection", "asMutableSet", "", "clear", "dropDeletes", "dropDeletes$collection", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "fixupNodes", "mapping", "", "", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "moveNodeToHead", "index", "plusAssign", "remove", "removeAll", "removeElementAt", "removeIf", "predicate", "Lkotlin/Function1;", "removeNode", "resizeStorage", "newCapacity", "resizeStorage$collection", "retainAll", "", "trim", "trimToSize", "maxSize", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class MutableOrderedScatterSet extends OrderedScatterSet {
    private int growthLimit;

    public MutableOrderedScatterSet() {
        this(0, 1, null);
    }

    public MutableOrderedScatterSet(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 6;
        }

        this(arg1);
    }

    public MutableOrderedScatterSet(int arg2) {
        super(null);
        int v0 = arg2 >= 0 ? 1 : 0;
        if(v0 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }

        this.initializeStorage(ScatterMapKt.unloadedCapacity(arg2));
    }

    public final boolean add(Object arg12) {
        int v0 = this.getSize();
        int v1 = this.findAbsoluteInsertIndex(arg12);
        this.elements[v1] = arg12;
        long v4 = 0x7FFFFFFF;
        this.nodes[v1] = (((long)this.head)) & v4 | 0x3FFFFFFF80000000L;
        int v2 = 0x7FFFFFFF;
        if(this.head != v2) {
            this.nodes[this.head] = (v4 & (((long)v1))) << 0x1F | this.nodes[this.head] & -4611686016279904257L;
        }

        this.head = v1;
        if(this.tail == v2) {
            this.tail = v1;
        }

        if(this.getSize() != v0) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(ObjectList arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.plusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(OrderedScatterSet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.plusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(ScatterSet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.plusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.plusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.plusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.plusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final void adjustStorage$collection() {
        if(this._capacity > 8 && Long.compareUnsigned(ULong.constructor-impl(ULong.constructor-impl(((long)this._size)) * 0x20), ULong.constructor-impl(ULong.constructor-impl(((long)this._capacity)) * 25)) <= 0) {
            this.dropDeletes$collection();
            return;
        }

        this.resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
    }

    public final Set asMutableSet() {
        return new MutableOrderedSetWrapper(this);
    }

    public final void clear() {
        this._size = 0;
        if(this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, 0, 0, 6, null);
            long[] v1 = this.metadata;
            int v3 = this._capacity >> 3;
            long v6 = 0xFF << ((this._capacity & 7) << 3);
            v1[v3] = v1[v3] & ~v6 | v6;
        }

        ArraysKt.fill(this.elements, null, 0, this._capacity);
        ArraysKt.fill$default(this.nodes, 0x3FFFFFFFFFFFFFFFL, 0, 0, 6, null);
        this.head = 0x7FFFFFFF;
        this.tail = 0x7FFFFFFF;
        this.initializeGrowth();
    }

    public final void dropDeletes$collection() {
        long v11;
        MutableOrderedScatterSet v0 = this;
        long[] v1 = v0.metadata;
        if(v1 == null) {
            return;
        }

        int v2 = v0._capacity;
        Object[] v3 = v0.elements;
        long[] v4 = v0.nodes;
        long[] v5 = new long[v2];
        long v6 = 0x7FFFFFFF7FFFFFFFL;
        int v8 = 0;
        ArraysKt.fill(v5, v6, 0, v2);
        int v9 = v2 + 7 >> 3;
        int v10;
        for(v10 = 0; v10 < v9; ++v10) {
            v11 = v1[v10] & -9187201950435737472L;
            v1[v10] = -72340172838076674L & ~v11 + (v11 >>> 7);
        }

        v9 = ArraysKt.getLastIndex(v1);
        v10 = v9 - 1;
        v1[v10] = v1[v10] & 0xFFFFFFFFFFFFFFL | -72057594037927936L;
        v1[v9] = v1[0];
        v9 = 0;
        while(v9 != v2) {
            v10 = v9 >> 3;
            int v13 = (v9 & 7) << 3;
            long v14 = 0xFF;
            v11 = v1[v10] >> v13 & v14;
            long v16 = 0x80;
            if(v11 != v16) {
                if(v11 != 0xFE) {
                }
                else {
                    goto label_53;
                }
            }

            ++v9;
            continue;
        label_53:
            Object v11_1 = v3[v9];
            int v11_2 = v11_1 != null ? v11_1.hashCode() : v8;
            v11_2 *= 0xCC9E2D51;
            v11_2 ^= v11_2 << 16;
            int v12 = v11_2 >>> 7;
            long v18 = v6;
            int v6_1 = v0.findFirstAvailableSlot(v12);
            int v7 = v12 & v2;
            int v20 = 0x20;
            if((v6_1 - v7 & v2) / 8 == (v9 - v7 & v2) / 8) {
                v1[v10] = (((long)(v11_2 & 0x7F))) << v13 | v1[v10] & ~(v14 << v13);
                if(v5[v9] == v18) {
                    v6 = ((long)v9);
                    v5[v9] = v6 | v6 << v20;
                }

                v1[v1.length - 1] = v1[v8];
                ++v9;
                v6 = v18;
                continue;
            }

            v7 = v6_1 >> 3;
            long v21 = v1[v7];
            v12 = (v6_1 & 7) << 3;
            int v24 = v8;
            long v25 = -4294967296L;
            long v27 = 0xFFFFFFFFL;
            if(Long.compare(v21 >> v12 & v14, v16) == 0) {
                int v23 = v9;
                v1[v7] = v21 & ~(v14 << v12) | (((long)(v11_2 & 0x7F))) << v12;
                v1[v10] = v1[v10] & ~(v14 << v13) | v16 << v13;
                v3[v6_1] = v3[v23];
                v3[v23] = null;
                v4[v6_1] = v4[v23];
                v4[v23] = 0x3FFFFFFFFFFFFFFFL;
                v7 = ((int)(v5[v23] >> v20 & v27));
                if(v7 != 0x7FFFFFFF) {
                    v5[v7] = v5[v7] & v25 | (((long)v6_1));
                    v5[v23] = v5[v23] & v27 | v25;
                }
                else {
                    v5[v23] = 0x7FFFFFFF00000000L | (((long)v6_1));
                }

                v9 = v23;
                v5[v6_1] = (((long)v9)) << v20 | 0x7FFFFFFF;
            }
            else {
                v1[v7] = (((long)(v11_2 & 0x7F))) << v12 | v21 & ~(v14 << v12);
                Object v7_1 = v3[v6_1];
                v3[v6_1] = v3[v9];
                v3[v9] = v7_1;
                long v7_2 = v4[v6_1];
                v4[v6_1] = v4[v9];
                v4[v9] = v7_2;
                v7 = ((int)(v5[v9] >> v20 & v27));
                if(v7 != 0x7FFFFFFF) {
                    long v12_1 = ((long)v6_1);
                    v5[v7] = v5[v7] & v25 | v12_1;
                    v5[v9] = v5[v9] & v27 | v12_1 << v20;
                }
                else {
                    v7_2 = ((long)v6_1);
                    v5[v9] = v7_2 | v7_2 << v20;
                    v7 = v9;
                }

                v5[v6_1] = (((long)v7)) << v20 | (((long)v9));
                --v9;
            }

            v1[v1.length - 1] = v1[v24];
            ++v9;
            v6 = v18;
            v8 = v24;
        }

        v0.initializeGrowth();
        v0.fixupNodes(v5);
    }

    private final int findAbsoluteInsertIndex(Object arg21) {
        MutableOrderedScatterSet v0 = this;
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
                if(Intrinsics.areEqual(v0.elements[v16_1], v1)) {
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

                ++v0._size;
                int v2_1 = v0.growthLimit;
                v4 = v1_1 >> 3;
                v3 = (v1_1 & 7) << 3;
                int v19 = (v0.metadata[v4] >> v3 & v5_1) == 0x80 ? 1 : 0;
                v0.growthLimit = v2_1 - v19;
                long[] v2_2 = v0.metadata;
                int v0_1 = v0._capacity;
                v5_1 = ~(v5_1 << v3) & v2_2[v4] | v10_1 << v3;
                v2_2[v4] = v5_1;
                v2_2[(v1_1 - 7 & v0_1) + (v0_1 & 7) >> 3] = v5_1;
                return v1_1;
            }

            v7 += 8;
            v6 = v6 + v7 & v5;
            v3 = v18;
        }
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

        if(this.head != v3) {
            this.head = arg12[this.head];
        }

        if(this.tail != v3) {
            this.tail = arg12[this.tail];
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

        if(this.head != v5) {
            this.head = ((int)(arg14[this.head] & v3));
        }

        if(this.tail != v5) {
            this.tail = ((int)(arg14[this.tail] & v3));
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(this.getCapacity()) - this._size;
    }

    private final void initializeMetadata(int arg9) {
        long[] v1;
        long[] v0;
        if(arg9 == 0) {
            v0 = ScatterMapKt.EmptyGroup;
        }
        else {
            v1 = new long[(arg9 + 15 & -8) >> 3];
            ArraysKt.fill$default(v1, -9187201950435737472L, 0, 0, 6, null);
            v0 = v1;
        }

        this.metadata = v0;
        int v1_1 = arg9 >> 3;
        long v4 = 0xFF << ((arg9 & 7) << 3);
        this.metadata[((int)v1)] = this.metadata[((int)v1)] & ~v4 | v4;
        this.initializeGrowth();
    }

    private final void initializeStorage(int arg8) {
        long[] v8;
        arg8 = arg8 > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(arg8)) : 0;
        this._capacity = arg8;
        this.initializeMetadata(arg8);
        Object[] v0 = arg8 == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[arg8];
        this.elements = v0;
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

    public final void minusAssign(ObjectList arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        Object[] v0 = arg4.content;
        int v4 = arg4._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            this.minusAssign(v0[v1]);
        }
    }

    public final void minusAssign(Object arg15) {
        int v11_1;
        MutableOrderedScatterSet v0 = this;
        int v1 = 0;
        int v2 = arg15 != null ? arg15.hashCode() : 0;
        v2 *= 0xCC9E2D51;
        v2 ^= v2 << 16;
        int v3 = v2 & 0x7F;
        int v4 = ((OrderedScatterSet)v0)._capacity;
        v2 >>>= 7;
        while(true) {
            v2 &= v4;
            int v6 = v2 >> 3;
            int v7 = (v2 & 7) << 3;
            long v5 = ((OrderedScatterSet)v0).metadata[v6 + 1] << 0x40 - v7 & -(((long)v7)) >> 0x3F | ((OrderedScatterSet)v0).metadata[v6] >>> v7;
            long v7_1 = (((long)v3)) * 0x101010101010101L ^ v5;
            long v9 = -9187201950435737472L;
            v7_1 = ~v7_1 & v7_1 - 0x101010101010101L & v9;
            while(true) {
                long v11 = 0;
                if(v7_1 != v11) {
                    v11_1 = (Long.numberOfTrailingZeros(v7_1) >> 3) + v2 & v4;
                    if(Intrinsics.areEqual(((OrderedScatterSet)v0).elements[v11_1], arg15)) {
                    }
                    else {
                        v7_1 &= v7_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_61;
            }

            if((v5 & ~v5 << 6 & v9) != v11) {
                v11_1 = -1;
            }
            else {
                goto label_64;
            }

        label_61:
            if(v11_1 >= 0) {
                this.removeElementAt(v11_1);
            }

            return;
        label_64:
            v1 += 8;
            v2 += v1;
        }
    }

    public final void minusAssign(OrderedScatterSet arg7) {
        Intrinsics.checkNotNullParameter(arg7, "elements");
        Object[] v0 = arg7.elements;
        long[] v1 = arg7.nodes;
        int v7;
        for(v7 = arg7.tail; v7 != 0x7FFFFFFF; v7 = v2) {
            int v2 = ((int)(v1[v7] >> 0x1F & 0x7FFFFFFF));
            this.minusAssign(v0[v7]);
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
                            this.minusAssign(v0[(v3 << 3) + v8]);
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
            this.minusAssign(v2.next());
        }
    }

    public final void minusAssign(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            this.minusAssign(v2.next());
        }
    }

    public final void minusAssign(Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.minusAssign(arg4[v1]);
        }
    }

    private final void moveNodeToHead(int arg11) {
        long v3 = 0x7FFFFFFF;
        this.nodes[arg11] = (((long)this.head)) & v3 | 0x3FFFFFFF80000000L;
        int v1 = 0x7FFFFFFF;
        if(this.head != v1) {
            this.nodes[this.head] = (v3 & (((long)arg11))) << 0x1F | this.nodes[this.head] & -4611686016279904257L;
        }

        this.head = arg11;
        if(this.tail == v1) {
            this.tail = arg11;
        }
    }

    public final void plusAssign(ObjectList arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        Object[] v0 = arg4.content;
        int v4 = arg4._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            this.plusAssign(v0[v1]);
        }
    }

    public final void plusAssign(OrderedScatterSet arg7) {
        Intrinsics.checkNotNullParameter(arg7, "elements");
        Object[] v0 = arg7.elements;
        long[] v1 = arg7.nodes;
        int v7;
        for(v7 = arg7.tail; v7 != 0x7FFFFFFF; v7 = v2) {
            int v2 = ((int)(v1[v7] >> 0x1F & 0x7FFFFFFF));
            this.plusAssign(v0[v7]);
        }
    }

    public final void plusAssign(ScatterSet arg14) {
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
                            this.plusAssign(v0[(v3 << 3) + v8]);
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

    public final void plusAssign(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            this.plusAssign(v2.next());
        }
    }

    public final void plusAssign(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            this.plusAssign(v2.next());
        }
    }

    public final void plusAssign(Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.plusAssign(arg4[v1]);
        }
    }

    public final void plusAssign(Object arg11) {
        int v0 = this.findAbsoluteInsertIndex(arg11);
        this.elements[v0] = arg11;
        long v3 = 0x7FFFFFFF;
        this.nodes[v0] = (((long)this.head)) & v3 | 0x3FFFFFFF80000000L;
        int v1 = 0x7FFFFFFF;
        if(this.head != v1) {
            this.nodes[this.head] = (v3 & (((long)v0))) << 0x1F | this.nodes[this.head] & -4611686016279904257L;
        }

        this.head = v0;
        if(this.tail == v1) {
            this.tail = v0;
        }
    }

    public final boolean remove(Object arg19) {
        int v12;
        MutableOrderedScatterSet v0 = this;
        Object v1 = arg19;
        MutableOrderedScatterSet v2 = v0;
        int v4 = v1 != null ? v1.hashCode() : 0;
        v4 *= 0xCC9E2D51;
        v4 ^= v4 << 16;
        int v5 = v4 & 0x7F;
        int v6 = ((OrderedScatterSet)v2)._capacity;
        v4 = v4 >>> 7 & v6;
        int v7 = 0;
        while(true) {
            int v9 = v4 >> 3;
            int v10 = (v4 & 7) << 3;
            long v8 = ((OrderedScatterSet)v2).metadata[v9 + 1] << 0x40 - v10 & -(((long)v10)) >> 0x3F | ((OrderedScatterSet)v2).metadata[v9] >>> v10;
            long v10_1 = (((long)v5)) * 0x101010101010101L ^ v8;
            long v14 = -9187201950435737472L;
            v10_1 = ~v10_1 & v10_1 - 0x101010101010101L & v14;
            while(true) {
                long v16 = 0;
                if(v10_1 != v16) {
                    v12 = (Long.numberOfTrailingZeros(v10_1) >> 3) + v4 & v6;
                    if(Intrinsics.areEqual(((OrderedScatterSet)v2).elements[v12], v1)) {
                    }
                    else {
                        v10_1 &= v10_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_64;
            }

            if((v8 & ~v8 << 6 & v14) != v16) {
                v12 = -1;
            }
            else {
                goto label_71;
            }

        label_64:
            boolean v3 = v12 >= 0 ? true : false;
            if(v3) {
                v0.removeElementAt(v12);
            }

            return v3;
        label_71:
            v7 += 8;
            v4 = v4 + v7 & v6;
        }
    }

    public final boolean removeAll(ObjectList arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.minusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(OrderedScatterSet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.minusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(ScatterSet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.minusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.minusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.minusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this.getSize();
        this.minusAssign(arg2);
        if(v0 != this.getSize()) {
            return 1;
        }

        return 0;
    }

    public final void removeElementAt(int arg13) {
        --this._size;
        long[] v0 = this.metadata;
        int v1 = this._capacity;
        int v2 = arg13 >> 3;
        int v3 = (arg13 & 7) << 3;
        long v3_1 = v0[v2] & ~(0xFF << v3) | 0xFE << v3;
        v0[v2] = v3_1;
        v0[(arg13 - 7 & v1) + (v1 & 7) >> 3] = v3_1;
        this.elements[arg13] = null;
        v0 = this.nodes;
        v3 = 0x1F;
        long v6 = 0x7FFFFFFF;
        int v4 = ((int)(v0[arg13] >> v3 & v6));
        v1 = ((int)(v0[arg13] & v6));
        v2 = 0x7FFFFFFF;
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

        v0[arg13] = 0x3FFFFFFFFFFFFFFFL;
    }

    public final void removeIf(Function1 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "predicate");
        Object[] v0 = this.elements;
        long[] v1 = this.metadata;
        int v2 = v1.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v1[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            if(arg15.invoke(v0[v10]).booleanValue()) {
                                this.removeElementAt(v10);
                            }
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

        v0[arg13] = 0x3FFFFFFFFFFFFFFFL;
    }

    public final void resizeStorage$collection(int arg24) {
        Object[] v22;
        long[] v21;
        MutableOrderedScatterSet v0 = this;
        long[] v1 = v0.metadata;
        Object[] v2 = v0.elements;
        long[] v3 = v0.nodes;
        int v4 = v0._capacity;
        int[] v5 = new int[v4];
        this.initializeStorage(arg24);
        long[] v6 = v0.metadata;
        Object[] v7 = v0.elements;
        long[] v8 = v0.nodes;
        int v9 = v0._capacity;
        int v11 = 0;
        while(v11 < v4) {
            long v14 = 0xFF;
            if((v1[v11 >> 3] >> ((v11 & 7) << 3) & v14) < 0x80) {
                Object v12 = v2[v11];
                int v13 = v12 != null ? v12.hashCode() : 0;
                v13 *= 0xCC9E2D51;
                v13 ^= v13 << 16;
                int v10 = v0.findFirstAvailableSlot(v13 >>> 7);
                long v16 = v14;
                v14 = ((long)(v13 & 0x7F));
                v13 = v10 >> 3;
                int v18 = (v10 & 7) << 3;
                v21 = v1;
                v22 = v2;
                long v1_1 = v6[v13] & ~(v16 << v18) | v14 << v18;
                v6[v13] = v1_1;
                v6[(v10 - 7 & v9) + (v9 & 7) >> 3] = v1_1;
                v7[v10] = v12;
                v8[v10] = v3[v11];
                v5[v11] = v10;
            }
            else {
                v21 = v1;
                v22 = v2;
            }

            ++v11;
            v1 = v21;
            v2 = v22;
        }

        v0.fixupNodes(v5);
    }

    public final boolean retainAll(OrderedScatterSet arg18) {
        MutableOrderedScatterSet v0 = this;
        OrderedScatterSet v1 = arg18;
        Intrinsics.checkNotNullParameter(v1, "elements");
        Object[] v2 = v0.elements;
        int v3 = v0._size;
        long[] v4 = v0.metadata;
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
                            if(!v1.contains(v2[v13])) {
                                v0.removeElementAt(v13);
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

        if(v3 != v0._size) {
            return 1;
        }

        return 0;
    }

    public final boolean retainAll(ScatterSet arg18) {
        MutableOrderedScatterSet v0 = this;
        ScatterSet v1 = arg18;
        Intrinsics.checkNotNullParameter(v1, "elements");
        Object[] v2 = v0.elements;
        int v3 = v0._size;
        long[] v4 = v0.metadata;
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
                            if(!v1.contains(v2[v13])) {
                                v0.removeElementAt(v13);
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

        if(v3 != v0._size) {
            return 1;
        }

        return 0;
    }

    public final boolean retainAll(Collection arg18) {
        MutableOrderedScatterSet v0 = this;
        Collection v1 = arg18;
        Intrinsics.checkNotNullParameter(v1, "elements");
        Object[] v2 = v0.elements;
        int v3 = v0._size;
        long[] v4 = v0.metadata;
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
                            if(!CollectionsKt.contains(v1, v2[v13])) {
                                v0.removeElementAt(v13);
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

        if(v3 != v0._size) {
            return 1;
        }

        return 0;
    }

    public final boolean retainAll(Function1 arg18) {
        MutableOrderedScatterSet v0 = this;
        Function1 v1 = arg18;
        Intrinsics.checkNotNullParameter(v1, "predicate");
        Object[] v2 = v0.elements;
        int v3 = v0.getSize();
        long[] v4 = v0.metadata;
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
                            if(!v1.invoke(v2[v13]).booleanValue()) {
                                v0.removeElementAt(v13);
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

        if(v3 != v0.getSize()) {
            return 1;
        }

        return 0;
    }

    public final int trim() {
        int v0 = this._capacity;
        int v1 = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if(v1 < v0) {
            this.resizeStorage$collection(v1);
            return v0 - this._capacity;
        }

        return 0;
    }

    public final void trimToSize(int arg7) {
        long[] v0 = this.nodes;
        int v1;
        for(v1 = this.head; v1 != 0x7FFFFFFF; v1 = v2) {
            if(this._size <= arg7) {
                return;
            }

            if(this._size == 0) {
                return;
            }

            int v2 = ((int)(v0[v1] & 0x7FFFFFFF));
            this.removeElementAt(v1);
        }
    }
}

