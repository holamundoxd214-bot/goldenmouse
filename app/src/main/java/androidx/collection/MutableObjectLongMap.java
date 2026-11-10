package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000F\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b\tJ\u0006\u0010\n\u001A\u00020\bJ\r\u0010\u000B\u001A\u00020\bH\u0000¢\u0006\u0002\b\fJ\u0010\u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u0004H\u0002J\u0015\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0011J\'\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0010\u001A\u00028\u00002\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001A\u00020\bH\u0002J\u0010\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\u0004H\u0002J\u0010\u0010\u001A\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0004H\u0002J\u0016\u0010\u001B\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\u001CJ\u0017\u0010\u001B\u001A\u00020\b2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u001EH\u0086\nJ\u001E\u0010\u001B\u001A\u00020\b2\u000E\u0010\u001D\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001FH\u0086\n¢\u0006\u0002\u0010 J\u0017\u0010\u001B\u001A\u00020\b2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000!H\u0086\nJ\u0017\u0010\u001B\u001A\u00020\b2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\"H\u0086\nJ\u0017\u0010#\u001A\u00020\b2\f\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001B\u0010%\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00028\u00002\u0006\u0010&\u001A\u00020\u0013¢\u0006\u0002\u0010\'J#\u0010%\u001A\u00020\u00132\u0006\u0010\u0010\u001A\u00028\u00002\u0006\u0010&\u001A\u00020\u00132\u0006\u0010(\u001A\u00020\u0013¢\u0006\u0002\u0010)J\u0014\u0010*\u001A\u00020\b2\f\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0013\u0010+\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00028\u0000¢\u0006\u0002\u0010\u001CJ\u001B\u0010+\u001A\u00020,2\u0006\u0010\u0010\u001A\u00028\u00002\u0006\u0010&\u001A\u00020\u0013¢\u0006\u0002\u0010-J&\u0010.\u001A\u00020\b2\u0018\u0010/\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020,00H\u0086\bø\u0001\u0000J\u0010\u00101\u001A\u00020\b2\u0006\u00102\u001A\u00020\u0004H\u0001J\u0015\u00103\u001A\u00020\b2\u0006\u00104\u001A\u00020\u0004H\u0000¢\u0006\u0002\b5J\u001E\u00106\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00028\u00002\u0006\u0010&\u001A\u00020\u0013H\u0086\u0002¢\u0006\u0002\u0010\'J\u0006\u00107\u001A\u00020\u0004R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00068"}, d2={"Landroidx/collection/MutableObjectLongMap;", "K", "Landroidx/collection/ObjectLongMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "adjustStorage$collection", "clear", "dropDeletes", "dropDeletes$collection", "findFirstAvailableSlot", "hash1", "findIndex", "key", "(Ljava/lang/Object;)I", "getOrPut", "", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)J", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "keys", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "plusAssign", "from", "put", "value", "(Ljava/lang/Object;J)V", "default", "(Ljava/lang/Object;JJ)J", "putAll", "remove", "", "(Ljava/lang/Object;J)Z", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", "resizeStorage$collection", "set", "trim", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class MutableObjectLongMap extends ObjectLongMap {
    private int growthLimit;

    public MutableObjectLongMap() {
        this(0, 1, null);
    }

    public MutableObjectLongMap(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 6;
        }

        this(arg1);
    }

    public MutableObjectLongMap(int arg2) {
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

    public final void clear() {
        this._size = 0;
        if(this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, 0, 0, 6, null);
            long[] v1 = this.metadata;
            int v3 = this._capacity >> 3;
            long v6 = 0xFF << ((this._capacity & 7) << 3);
            v1[v3] = v1[v3] & ~v6 | v6;
        }

        ArraysKt.fill(this.keys, null, 0, this._capacity);
        this.initializeGrowth();
    }

    public final void dropDeletes$collection() {
        long v24;
        long v8;
        MutableObjectLongMap v0 = this;
        long[] v1 = v0.metadata;
        int v2 = v0._capacity;
        Object[] v3 = v0.keys;
        long[] v4 = v0.values;
        int v5 = v2 + 7 >> 3;
        int v6 = 0;
        int v7;
        for(v7 = 0; v7 < v5; ++v7) {
            v8 = v1[v7] & -9187201950435737472L;
            v1[v7] = -72340172838076674L & ~v8 + (v8 >>> 7);
        }

        v5 = ArraysKt.getLastIndex(v1);
        v7 = v5 - 1;
        long v10 = 0xFFFFFFFFFFFFFFL;
        v1[v7] = v1[v7] & v10 | -72057594037927936L;
        v1[v5] = v1[0];
        v5 = 0;
        while(v5 != v2) {
            v7 = v5 >> 3;
            int v12 = (v5 & 7) << 3;
            long v13 = 0xFF;
            v8 = v1[v7] >> v12 & v13;
            long v15 = 0x80;
            if(v8 != v15) {
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
            int v17 = v0.findFirstAvailableSlot(v9);
            v9 &= v2;
            int v19 = v6;
            long v20 = -9223372036854775808L;
            if((v17 - v9 & v2) / 8 == (v5 - v9 & v2) / 8) {
                v1[v7] = (((long)(v8_2 & 0x7F))) << v12 | ~(v13 << v12) & v1[v7];
                v1[ArraysKt.getLastIndex(v1)] = v1[v19] & v10 | v20;
                ++v5;
                v6 = v19;
                continue;
            }

            v6 = v17 >> 3;
            long v22 = v1[v6];
            v9 = (v17 & 7) << 3;
            if((v22 >> v9 & v13) == v15) {
                v24 = v10;
                v1[v6] = (((long)(v8_2 & 0x7F))) << v9 | v22 & ~(v13 << v9);
                v1[v7] = v1[v7] & ~(v13 << v12) | v15 << v12;
                v3[v17] = v3[v5];
                v3[v5] = null;
                v4[v17] = v4[v5];
                v4[v5] = 0;
            }
            else {
                v24 = v10;
                v1[v6] = (((long)(v8_2 & 0x7F))) << v9 | v22 & ~(v13 << v9);
                Object v6_1 = v3[v17];
                v3[v17] = v3[v5];
                v3[v5] = v6_1;
                long v6_2 = v4[v17];
                v4[v17] = v4[v5];
                v4[v5] = v6_2;
                --v5;
            }

            v1[ArraysKt.getLastIndex(v1)] = v1[v19] & v24 | v20;
            ++v5;
            v6 = v19;
            v10 = v24;
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

    private final int findIndex(Object arg21) {
        MutableObjectLongMap v0 = this;
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

    public final long getOrPut(Object arg3, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "defaultValue");
        int v0 = this.findKeyIndex(arg3);
        if(v0 >= 0) {
            return this.values[v0];
        }

        long v0_1 = arg4.invoke().longValue();
        this.set(arg3, v0_1);
        return v0_1;
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

    private final void initializeStorage(int arg2) {
        arg2 = arg2 > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(arg2)) : 0;
        this._capacity = arg2;
        this.initializeMetadata(arg2);
        this.keys = new Object[arg2];
        this.values = new long[arg2];
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

    public final void plusAssign(ObjectLongMap arg2) {
        Intrinsics.checkNotNullParameter(arg2, "from");
        this.putAll(arg2);
    }

    public final long put(Object arg4, long arg5, long arg7) {
        int v0 = this.findIndex(arg4);
        if(v0 < 0) {
            v0 = ~v0;
        }
        else {
            arg7 = this.values[v0];
        }

        this.keys[v0] = arg4;
        this.values[v0] = arg5;
        return arg7;
    }

    public final void put(Object arg1, long arg2) {
        this.set(arg1, arg2);
    }

    public final void putAll(ObjectLongMap arg15) {
        Intrinsics.checkNotNullParameter(arg15, "from");
        Object[] v0 = arg15.keys;
        long[] v1 = arg15.values;
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

    public final void remove(Object arg1) {
        int v1 = this.findKeyIndex(arg1);
        if(v1 >= 0) {
            this.removeValueAt(v1);
        }
    }

    public final boolean remove(Object arg4, long arg5) {
        int v4 = this.findKeyIndex(arg4);
        if(v4 >= 0 && this.values[v4] == arg5) {
            this.removeValueAt(v4);
            return 1;
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
                            if(arg15.invoke(this.keys[v9], Long.valueOf(this.values[v9])).booleanValue()) {
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

    public final void removeValueAt(int arg9) {
        --this._size;
        long[] v0 = this.metadata;
        int v1 = this._capacity;
        int v2 = arg9 >> 3;
        int v3 = (arg9 & 7) << 3;
        long v3_1 = v0[v2] & ~(0xFF << v3) | 0xFE << v3;
        v0[v2] = v3_1;
        v0[(arg9 - 7 & v1) + (v1 & 7) >> 3] = v3_1;
        this.keys[arg9] = null;
    }

    public final void resizeStorage$collection(int arg21) {
        int v16;
        MutableObjectLongMap v0 = this;
        long[] v1 = v0.metadata;
        Object[] v2 = v0.keys;
        long[] v3 = v0.values;
        int v4 = v0._capacity;
        this.initializeStorage(arg21);
        long[] v5 = v0.metadata;
        Object[] v6 = v0.keys;
        long[] v7 = v0.values;
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

    public final void set(Object arg3, long arg4) {
        int v0 = this.findIndex(arg3);
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

