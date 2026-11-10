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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u000F\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0002\b\nJ\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fJ\u0006\u0010\r\u001A\u00020\tJS\u0010\u000E\u001A\u00028\u00012\u0006\u0010\u000F\u001A\u00028\u000028\u0010\u0010\u001A4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000F\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00028\u00010\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015J\r\u0010\u0016\u001A\u00020\tH\u0000¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u0005H\u0002J\u0015\u0010\u001A\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00028\u0000H\u0001¢\u0006\u0002\u0010\u001BJ\'\u0010\u001C\u001A\u00028\u00012\u0006\u0010\u000F\u001A\u00028\u00002\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00010\u001EH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001FJ\b\u0010 \u001A\u00020\tH\u0002J\u0010\u0010!\u001A\u00020\t2\u0006\u0010\"\u001A\u00020\u0005H\u0002J\u0010\u0010#\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\u0005H\u0002J\u0016\u0010$\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00028\u0000H\u0086\n¢\u0006\u0002\u0010%J\u0017\u0010$\u001A\u00020\t2\f\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000\'H\u0086\nJ\u0017\u0010$\u001A\u00020\t2\f\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000(H\u0086\nJ\u001E\u0010$\u001A\u00020\t2\u000E\u0010&\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000)H\u0086\n¢\u0006\u0002\u0010*J\u0017\u0010$\u001A\u00020\t2\f\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000+H\u0086\nJ\u0017\u0010$\u001A\u00020\t2\f\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000,H\u0086\nJ\u001D\u0010-\u001A\u00020\t2\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\nJ*\u0010-\u001A\u00020\t2\u001A\u0010/\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001000)H\u0086\n¢\u0006\u0002\u00101J\u001D\u0010-\u001A\u00020\t2\u0012\u00102\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0086\nJ#\u0010-\u001A\u00020\t2\u0018\u0010/\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001000+H\u0086\nJ\u001D\u0010-\u001A\u00020\t2\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000103H\u0086\nJ#\u0010-\u001A\u00020\t2\u0018\u0010/\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001000,H\u0086\nJ\u001D\u00104\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0001¢\u0006\u0002\u00105J\u001A\u00106\u001A\u00020\t2\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J\'\u00106\u001A\u00020\t2\u001A\u0010/\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001000)¢\u0006\u0002\u00101J \u00106\u001A\u00020\t2\u0018\u0010/\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001000+J\u001A\u00106\u001A\u00020\t2\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000103J \u00106\u001A\u00020\t2\u0018\u0010/\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001000,J\u0015\u00107\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u000F\u001A\u00028\u0000¢\u0006\u0002\u00108J\u001B\u00107\u001A\u0002092\u0006\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0001¢\u0006\u0002\u0010:J&\u0010;\u001A\u00020\t2\u0018\u0010<\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002090\u0011H\u0086\bø\u0001\u0000J\u0017\u0010=\u001A\u0004\u0018\u00018\u00012\u0006\u0010>\u001A\u00020\u0005H\u0001¢\u0006\u0002\u0010?J\u0015\u0010@\u001A\u00020\t2\u0006\u0010A\u001A\u00020\u0005H\u0000¢\u0006\u0002\bBJ\u001E\u0010C\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010DJ\u0006\u0010E\u001A\u00020\u0005R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2={"Landroidx/collection/MutableScatterMap;", "K", "V", "Landroidx/collection/ScatterMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "adjustStorage$collection", "asMutableMap", "", "clear", "compute", "key", "computeBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "dropDeletes", "dropDeletes$collection", "findFirstAvailableSlot", "hash1", "findInsertIndex", "(Ljava/lang/Object;)I", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "keys", "Landroidx/collection/ObjectList;", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "plusAssign", "from", "pairs", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "pair", "", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeIf", "predicate", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "resizeStorage$collection", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "trim", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class MutableScatterMap extends ScatterMap {
    private int growthLimit;

    public MutableScatterMap() {
        this(0, 1, null);
    }

    public MutableScatterMap(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 6;
        }

        this(arg1);
    }

    public MutableScatterMap(int arg2) {
        super(null);
        int v0 = arg2 >= 0 ? 1 : 0;
        if(v0 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }

        this.initializeStorage(ScatterMapKt.unloadedCapacity(arg2));
    }

    public final void adjustStorage$collection() {
        if(this._capacity > 8 && Long.compareUnsigned(ULong.constructor-impl(ULong.constructor-impl(((long)this._size)) * 0x20), ULong.constructor-impl(ULong.constructor-impl(((long)this._capacity)) * 25)) <= 0) {
            this.dropDeletes$collection();
            return;
        }

        this.resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
    }

    public final Map asMutableMap() {
        return new MutableMapWrapper(this);
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

        ArraysKt.fill(this.values, null, 0, this._capacity);
        ArraysKt.fill(this.keys, null, 0, this._capacity);
        this.initializeGrowth();
    }

    public final Object compute(Object arg4, Function2 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "computeBlock");
        int v0 = this.findInsertIndex(arg4);
        int v1 = v0 < 0 ? 1 : 0;
        Object v2 = v1 != 0 ? null : this.values[v0];
        Object v5 = arg5.invoke(arg4, v2);
        if(v1 != 0) {
            v0 = ~v0;
            this.keys[v0] = arg4;
            this.values[v0] = v5;
            return v5;
        }

        this.values[v0] = v5;
        return v5;
    }

    public final void dropDeletes$collection() {
        long v8;
        MutableScatterMap v0 = this;
        long[] v1 = v0.metadata;
        int v2 = v0._capacity;
        Object[] v3 = v0.keys;
        Object[] v4 = v0.values;
        int v5 = v2 + 7 >> 3;
        int v6 = 0;
        int v7;
        for(v7 = 0; v7 < v5; ++v7) {
            v8 = v1[v7] & -9187201950435737472L;
            v1[v7] = -72340172838076674L & ~v8 + (v8 >>> 7);
        }

        v5 = ArraysKt.getLastIndex(v1);
        v7 = v5 - 1;
        v1[v7] = v1[v7] & 0xFFFFFFFFFFFFFFL | -72057594037927936L;
        v1[v5] = v1[0];
        v5 = 0;
        while(v5 != v2) {
            v7 = v5 >> 3;
            int v10 = (v5 & 7) << 3;
            long v11 = 0xFF;
            v8 = v1[v7] >> v10 & v11;
            long v13 = 0x80;
            if(v8 != v13) {
                if(v8 != 0xFE) {
                }
                else {
                    goto label_48;
                }
            }

            ++v5;
            continue;
        label_48:
            Object v8_1 = v3[v5];
            int v8_2 = v8_1 != null ? v8_1.hashCode() : v6;
            v8_2 *= 0xCC9E2D51;
            v8_2 ^= v8_2 << 16;
            int v9 = v8_2 >>> 7;
            int v15 = v0.findFirstAvailableSlot(v9);
            v9 &= v2;
            int v17 = v6;
            if((v15 - v9 & v2) / 8 == (v5 - v9 & v2) / 8) {
                v1[v7] = (((long)(v8_2 & 0x7F))) << v10 | ~(v11 << v10) & v1[v7];
                v1[ArraysKt.getLastIndex(v1)] = v1[v17];
            }
            else {
                v6 = v15 >> 3;
                long v18 = v1[v6];
                v9 = (v15 & 7) << 3;
                if((v18 >> v9 & v11) == v13) {
                    v1[v6] = (((long)(v8_2 & 0x7F))) << v9 | v18 & ~(v11 << v9);
                    v1[v7] = v1[v7] & ~(v11 << v10) | v13 << v10;
                    v3[v15] = v3[v5];
                    v3[v5] = null;
                    v4[v15] = v4[v5];
                    v4[v5] = null;
                }
                else {
                    v1[v6] = (((long)(v8_2 & 0x7F))) << v9 | v18 & ~(v11 << v9);
                    Object v6_1 = v3[v15];
                    v3[v15] = v3[v5];
                    v3[v5] = v6_1;
                    v6_1 = v4[v15];
                    v4[v15] = v4[v5];
                    v4[v5] = v6_1;
                    --v5;
                }

                v1[ArraysKt.getLastIndex(v1)] = v1[v17];
            }

            ++v5;
            v6 = v17;
        }

        v0.initializeGrowth();
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

    public final int findInsertIndex(Object arg21) {
        MutableScatterMap v0 = this;
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
                return ~v1_1;
            }

            v7 += 8;
            v6 = v6 + v7 & v5;
            v3 = v18;
        }
    }

    public final Object getOrPut(Object arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        Object v0 = this.get(arg2);
        if(v0 == null) {
            Object v3 = arg3.invoke();
            this.set(arg2, v3);
            return v3;
        }

        return v0;
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(this.getCapacity()) - this._size;
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

    private final void initializeStorage(int arg2) {
        arg2 = arg2 > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(arg2)) : 0;
        this._capacity = arg2;
        this.initializeMetadata(arg2);
        Object[] v0 = arg2 == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[arg2];
        this.keys = v0;
        Object[] v2 = arg2 == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[arg2];
        this.values = v2;
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

    public final void minusAssign(Object arg1) {
        this.remove(arg1);
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

    public final void plusAssign(ScatterMap arg2) {
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
        this.set(arg2.getFirst(), arg2.getSecond());
    }

    public final void plusAssign(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        this.putAll(arg2);
    }

    public final void plusAssign(Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        this.putAll(arg2);
    }

    public final Object put(Object arg4, Object arg5) {
        int v0 = this.findInsertIndex(arg4);
        if(v0 < 0) {
            v0 = ~v0;
        }

        Object v1 = this.values[v0];
        this.keys[v0] = arg4;
        this.values[v0] = arg5;
        return v1;
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
                            this.set(v0[v10], v1[v10]);
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
            this.set(((Pair)v0).component1(), ((Pair)v0).component2());
        }
    }

    public final void putAll(Map arg3) {
        Intrinsics.checkNotNullParameter(arg3, "from");
        Iterator v3 = arg3.entrySet().iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            this.set(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
        }
    }

    public final void putAll(Sequence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "pairs");
        Iterator v3 = arg3.iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            this.set(((Pair)v0).component1(), ((Pair)v0).component2());
        }
    }

    public final void putAll(Pair[] arg5) {
        Intrinsics.checkNotNullParameter(arg5, "pairs");
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.set(arg5[v1].component1(), arg5[v1].component2());
        }
    }

    public final Object remove(Object arg15) {
        int v11_1;
        MutableScatterMap v0 = this;
        int v1 = 0;
        int v2 = arg15 != null ? arg15.hashCode() : 0;
        v2 *= 0xCC9E2D51;
        v2 ^= v2 << 16;
        int v3 = v2 & 0x7F;
        int v4 = ((ScatterMap)v0)._capacity;
        v2 >>>= 7;
        while(true) {
            v2 &= v4;
            int v6 = v2 >> 3;
            int v7 = (v2 & 7) << 3;
            long v5 = ((ScatterMap)v0).metadata[v6 + 1] << 0x40 - v7 & -(((long)v7)) >> 0x3F | ((ScatterMap)v0).metadata[v6] >>> v7;
            long v7_1 = (((long)v3)) * 0x101010101010101L ^ v5;
            long v9 = -9187201950435737472L;
            v7_1 = ~v7_1 & v7_1 - 0x101010101010101L & v9;
            while(true) {
                long v11 = 0;
                if(v7_1 != v11) {
                    v11_1 = (Long.numberOfTrailingZeros(v7_1) >> 3) + v2 & v4;
                    if(Intrinsics.areEqual(((ScatterMap)v0).keys[v11_1], arg15)) {
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
                goto label_66;
            }

        label_61:
            if(v11_1 >= 0) {
                return this.removeValueAt(v11_1);
            }

            return null;
        label_66:
            v1 += 8;
            v2 += v1;
        }
    }

    public final boolean remove(Object arg20, Object arg21) {
        boolean v18;
        int v12;
        MutableScatterMap v0 = this;
        Object v1 = arg20;
        MutableScatterMap v2 = v0;
        int v4 = v1 != null ? v1.hashCode() : 0;
        v4 *= 0xCC9E2D51;
        v4 ^= v4 << 16;
        int v5 = v4 & 0x7F;
        int v6 = ((ScatterMap)v2)._capacity;
        v4 = v4 >>> 7 & v6;
        int v7 = 0;
        while(true) {
            int v9 = v4 >> 3;
            int v10 = (v4 & 7) << 3;
            long v8 = ((ScatterMap)v2).metadata[v9 + 1] << 0x40 - v10 & -(((long)v10)) >> 0x3F | ((ScatterMap)v2).metadata[v9] >>> v10;
            long v10_1 = (((long)v5)) * 0x101010101010101L ^ v8;
            long v14 = -9187201950435737472L;
            v10_1 = ~v10_1 & v10_1 - 0x101010101010101L & v14;
            while(true) {
                long v16 = 0;
                if(v10_1 != v16) {
                    v12 = (Long.numberOfTrailingZeros(v10_1) >> 3) + v4 & v6;
                    v18 = false;
                    if(Intrinsics.areEqual(((ScatterMap)v2).keys[v12], v1)) {
                    }
                    else {
                        v10_1 &= v10_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_66;
            }

            v18 = false;
            if((v8 & ~v8 << 6 & v14) != v16) {
                v12 = -1;
            }
            else {
                goto label_75;
            }

        label_66:
            if(v12 >= 0 && (Intrinsics.areEqual(v0.values[v12], arg21))) {
                v0.removeValueAt(v12);
                return 1;
            }

            return v18;
        label_75:
            v7 += 8;
            v4 = v4 + v7 & v6;
        }
    }

    public final void removeIf(Function2 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "predicate");
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
                            if(arg14.invoke(this.keys[v9], this.values[v9]).booleanValue()) {
                                this.removeValueAt(v9);
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

    public final Object removeValueAt(int arg9) {
        --this._size;
        long[] v0 = this.metadata;
        int v1 = this._capacity;
        int v2 = arg9 >> 3;
        int v3 = (arg9 & 7) << 3;
        long v3_1 = v0[v2] & ~(0xFF << v3) | 0xFE << v3;
        v0[v2] = v3_1;
        v0[(arg9 - 7 & v1) + (v1 & 7) >> 3] = v3_1;
        this.keys[arg9] = null;
        Object v0_1 = this.values[arg9];
        this.values[arg9] = null;
        return v0_1;
    }

    public final void resizeStorage$collection(int arg21) {
        int v16;
        MutableScatterMap v0 = this;
        long[] v1 = v0.metadata;
        Object[] v2 = v0.keys;
        Object[] v3 = v0.values;
        int v4 = v0._capacity;
        this.initializeStorage(arg21);
        long[] v5 = v0.metadata;
        Object[] v6 = v0.keys;
        Object[] v7 = v0.values;
        int v8 = v0._capacity;
        int v10;
        for(v10 = 0; v10 < v4; v10 = v16 + 1) {
            long v13 = 0xFF;
            if((v1[v10 >> 3] >> ((v10 & 7) << 3) & v13) < 0x80) {
                Object v11 = v2[v10];
                int v12 = v11 != null ? v11.hashCode() : 0;
                v12 *= 0xCC9E2D51;
                v12 ^= v12 << 16;
                int v15 = v0.findFirstAvailableSlot(v12 >>> 7);
                v16 = v10;
                long v9 = ((long)(v12 & 0x7F));
                v12 = v15 >> 3;
                int v17 = (v15 & 7) << 3;
                v9 = v9 << v17 | v5[v12] & ~(v13 << v17);
                v5[v12] = v9;
                v5[(v15 - 7 & v8) + (v8 & 7) >> 3] = v9;
                v6[v15] = v11;
                v7[v15] = v3[v16];
            }
            else {
                v16 = v10;
            }
        }
    }

    public final void set(Object arg3, Object arg4) {
        int v0 = this.findInsertIndex(arg3);
        if(v0 < 0) {
            v0 = ~v0;
        }

        this.keys[v0] = arg3;
        this.values[v0] = arg4;
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
}

