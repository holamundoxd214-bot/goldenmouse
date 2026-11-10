package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000F\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b\tJ\u0006\u0010\n\u001A\u00020\bJ\r\u0010\u000B\u001A\u00020\bH\u0000¢\u0006\u0002\b\fJ\u0010\u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u000FH\u0002J\u0010\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0004H\u0002J\'\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u000E\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001A\u00020\bH\u0002J\u0010\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u0004H\u0002J\u0010\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0004H\u0002J\u0011\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001CH\u0086\nJ\u0011\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001DH\u0086\nJ\u0011\u0010\u001A\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u000FH\u0086\nJ\u0011\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001EH\u0086\nJ\u0017\u0010\u001F\u001A\u00020\b2\f\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001D\u0010!\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\"\u001A\u00028\u0000¢\u0006\u0002\u0010#J\u0014\u0010$\u001A\u00020\b2\f\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010%\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0002\u0010&J\u001B\u0010%\u001A\u00020\'2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\"\u001A\u00028\u0000¢\u0006\u0002\u0010(J&\u0010)\u001A\u00020\b2\u0018\u0010*\u001A\u0014\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\'0+H\u0086\bø\u0001\u0000J\u0017\u0010,\u001A\u0004\u0018\u00018\u00002\u0006\u0010-\u001A\u00020\u0004H\u0001¢\u0006\u0002\u0010.J\u0015\u0010/\u001A\u00020\b2\u0006\u00100\u001A\u00020\u0004H\u0000¢\u0006\u0002\b1J\u001E\u00102\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\"\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00103J\u0006\u00104\u001A\u00020\u0004R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2={"Landroidx/collection/MutableLongObjectMap;", "V", "Landroidx/collection/LongObjectMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "adjustStorage$collection", "clear", "dropDeletes", "dropDeletes$collection", "findAbsoluteInsertIndex", "key", "", "findFirstAvailableSlot", "hash1", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/LongList;", "Landroidx/collection/LongSet;", "", "plusAssign", "from", "put", "value", "(JLjava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(J)Ljava/lang/Object;", "", "(JLjava/lang/Object;)Z", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "resizeStorage$collection", "set", "(JLjava/lang/Object;)V", "trim", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class MutableLongObjectMap extends LongObjectMap {
    private int growthLimit;

    public MutableLongObjectMap(int arg2) {
        super(null);
        int v0 = arg2 >= 0 ? 1 : 0;
        if(v0 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }

        this.initializeStorage(ScatterMapKt.unloadedCapacity(arg2));
    }

    public MutableLongObjectMap(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 6;
        }

        this(arg1);
    }

    public MutableLongObjectMap() {
        this(0, 1, null);
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

        ArraysKt.fill(this.values, null, 0, this._capacity);
        this.initializeGrowth();
    }

    public final void dropDeletes$collection() {
        long v24;
        long v8;
        MutableLongObjectMap v0 = this;
        long[] v1 = v0.metadata;
        int v2 = v0._capacity;
        long[] v3 = v0.keys;
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
            int v8_1 = Long.hashCode(v3[v5]) * 0xCC9E2D51;
            v8_1 ^= v8_1 << 16;
            int v9 = v8_1 >>> 7;
            int v17 = v0.findFirstAvailableSlot(v9);
            v9 &= v2;
            int v19 = v6;
            long v20 = -9223372036854775808L;
            if((v17 - v9 & v2) / 8 == (v5 - v9 & v2) / 8) {
                v1[v7] = (((long)(v8_1 & 0x7F))) << v12 | ~(v13 << v12) & v1[v7];
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
                v1[v6] = (((long)(v8_1 & 0x7F))) << v9 | v22 & ~(v13 << v9);
                v1[v7] = v1[v7] & ~(v13 << v12) | v15 << v12;
                v3[v17] = v3[v5];
                v3[v5] = 0;
                v4[v17] = v4[v5];
                v4[v5] = null;
            }
            else {
                v24 = v10;
                v1[v6] = (((long)(v8_1 & 0x7F))) << v9 | v22 & ~(v13 << v9);
                long v6_1 = v3[v17];
                v3[v17] = v3[v5];
                v3[v5] = v6_1;
                Object v6_2 = v4[v17];
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

    private final int findAbsoluteInsertIndex(long arg22) {
        MutableLongObjectMap v0 = this;
        int v1 = Long.hashCode(arg22) * 0xCC9E2D51;
        v1 ^= v1 << 16;
        int v2 = v1 >>> 7;
        v1 &= 0x7F;
        int v3 = v0._capacity;
        int v4 = v2 & v3;
        int v6 = 0;
        while(true) {
            int v8 = v4 >> 3;
            int v9 = (v4 & 7) << 3;
            long v7 = v0.metadata[v8 + 1] << 0x40 - v9 & -(((long)v9)) >> 0x3F | v0.metadata[v8] >>> v9;
            long v9_1 = ((long)v1);
            int v17 = v6;
            long v5 = v7 ^ v9_1 * 0x101010101010101L;
            long v13 = -9187201950435737472L;
            for(v5 = ~v5 & v5 - 0x101010101010101L & v13; true; v5 &= v5 - 1) {
                long v15 = 0;
                if(v5 == v15) {
                    break;
                }

                int v15_1 = (Long.numberOfTrailingZeros(v5) >> 3) + v4 & v3;
                if(v0.keys[v15_1] == arg22) {
                    return v15_1;
                }
            }

            if((~v7 << 6 & v7 & v13) != v15) {
                v1 = v0.findFirstAvailableSlot(v2);
                long v4_1 = 0xFF;
                if(v0.growthLimit == 0) {
                    if((v0.metadata[v1 >> 3] >> ((v1 & 7) << 3) & v4_1) == 0xFE) {
                    }
                    else {
                        v0.adjustStorage$collection();
                        v1 = v0.findFirstAvailableSlot(v2);
                    }
                }

                ++v0._size;
                v2 = v0.growthLimit;
                v6 = v1 >> 3;
                v3 = (v1 & 7) << 3;
                int v18 = (v0.metadata[v6] >> v3 & v4_1) == 0x80 ? 1 : 0;
                v0.growthLimit = v2 - v18;
                long[] v2_1 = v0.metadata;
                int v0_1 = v0._capacity;
                long v3_1 = ~(v4_1 << v3) & v2_1[v6] | v9_1 << v3;
                v2_1[v6] = v3_1;
                v2_1[(v1 - 7 & v0_1) + (v0_1 & 7) >> 3] = v3_1;
                return v1;
            }

            v6 = v17 + 8;
            v4 = v4 + v6 & v3;
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

    public final Object getOrPut(long arg2, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "defaultValue");
        Object v0 = this.get(arg2);
        if(v0 == null) {
            Object v4 = arg4.invoke();
            this.set(arg2, v4);
            return v4;
        }

        return v0;
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(this.getCapacity()) - this._size;
    }

    private final void initializeMetadata(int arg9) {
        long[] v0;
        if(arg9 == 0) {
            v0 = ScatterMapKt.EmptyGroup;
        }
        else {
            long[] v1 = new long[(arg9 + 15 & -8) >> 3];
            ArraysKt.fill$default(v1, -9187201950435737472L, 0, 0, 6, null);
            v0 = v1;
        }

        this.metadata = v0;
        int v1_1 = arg9 >> 3;
        long v4 = 0xFF << ((arg9 & 7) << 3);
        this.metadata[v1_1] = this.metadata[v1_1] & ~v4 | v4;
        this.initializeGrowth();
    }

    private final void initializeStorage(int arg2) {
        arg2 = arg2 > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(arg2)) : 0;
        this._capacity = arg2;
        this.initializeMetadata(arg2);
        this.keys = new long[arg2];
        this.values = new Object[arg2];
    }

    public final void minusAssign(long arg1) {
        this.remove(arg1);
    }

    public final void minusAssign(LongList arg5) {
        Intrinsics.checkNotNullParameter(arg5, "keys");
        long[] v0 = arg5.content;
        int v5 = arg5._size;
        int v1;
        for(v1 = 0; v1 < v5; ++v1) {
            this.remove(v0[v1]);
        }
    }

    public final void minusAssign(LongSet arg14) {
        Intrinsics.checkNotNullParameter(arg14, "keys");
        long[] v0 = arg14.elements;
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

    public final void minusAssign(long[] arg5) {
        Intrinsics.checkNotNullParameter(arg5, "keys");
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.remove(arg5[v1]);
        }
    }

    public final void plusAssign(LongObjectMap arg2) {
        Intrinsics.checkNotNullParameter(arg2, "from");
        this.putAll(arg2);
    }

    public final Object put(long arg4, Object arg6) {
        int v0 = this.findAbsoluteInsertIndex(arg4);
        Object v1 = this.values[v0];
        this.keys[v0] = arg4;
        this.values[v0] = arg6;
        return v1;
    }

    public final void putAll(LongObjectMap arg15) {
        Intrinsics.checkNotNullParameter(arg15, "from");
        long[] v0 = arg15.keys;
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

    public final Object remove(long arg17) {
        int v12_1;
        MutableLongObjectMap v0 = this;
        MutableLongObjectMap v1 = v0;
        int v2 = Long.hashCode(arg17) * 0xCC9E2D51;
        v2 ^= v2 << 16;
        int v3 = v2 & 0x7F;
        int v4 = ((LongObjectMap)v1)._capacity;
        v2 = v2 >>> 7 & v4;
        int v5 = 0;
        while(true) {
            int v7 = v2 >> 3;
            int v8 = (v2 & 7) << 3;
            long v6 = ((LongObjectMap)v1).metadata[v7 + 1] << 0x40 - v8 & -(((long)v8)) >> 0x3F | ((LongObjectMap)v1).metadata[v7] >>> v8;
            long v8_1 = (((long)v3)) * 0x101010101010101L ^ v6;
            long v10 = -9187201950435737472L;
            v8_1 = ~v8_1 & v8_1 - 0x101010101010101L & v10;
            while(true) {
                long v12 = 0;
                if(v8_1 != v12) {
                    v12_1 = (Long.numberOfTrailingZeros(v8_1) >> 3) + v2 & v4;
                    if(((LongObjectMap)v1).keys[v12_1] == arg17) {
                    }
                    else {
                        v8_1 &= v8_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_58;
            }

            if((v6 & ~v6 << 6 & v10) != v12) {
                v12_1 = -1;
            }
            else {
                goto label_63;
            }

        label_58:
            if(v12_1 >= 0) {
                return v0.removeValueAt(v12_1);
            }

            return null;
        label_63:
            v5 += 8;
            v2 = v2 + v5 & v4;
        }
    }

    public final boolean remove(long arg19, Object arg21) {
        int v11;
        MutableLongObjectMap v0 = this;
        MutableLongObjectMap v1 = v0;
        int v2 = Long.hashCode(arg19) * 0xCC9E2D51;
        v2 ^= v2 << 16;
        int v3 = v2 & 0x7F;
        int v4 = ((LongObjectMap)v1)._capacity;
        v2 = v2 >>> 7 & v4;
        int v6 = 0;
        while(true) {
            int v8 = v2 >> 3;
            int v9 = (v2 & 7) << 3;
            long v7 = ((LongObjectMap)v1).metadata[v8 + 1] << 0x40 - v9 & -(((long)v9)) >> 0x3F | ((LongObjectMap)v1).metadata[v8] >>> v9;
            long v9_1 = (((long)v3)) * 0x101010101010101L ^ v7;
            long v13 = -9187201950435737472L;
            v9_1 = ~v9_1 & v9_1 - 0x101010101010101L & v13;
            while(true) {
                long v15 = 0;
                if(v9_1 != v15) {
                    v11 = (Long.numberOfTrailingZeros(v9_1) >> 3) + v2 & v4;
                    if(((LongObjectMap)v1).keys[v11] == arg19) {
                    }
                    else {
                        v9_1 &= v9_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_60;
            }

            if((v7 & ~v7 << 6 & v13) != v15) {
                v11 = -1;
            }
            else {
                goto label_69;
            }

        label_60:
            if(v11 >= 0 && (Intrinsics.areEqual(v0.values[v11], arg21))) {
                v0.removeValueAt(v11);
                return 1;
            }

            return 0;
        label_69:
            v6 += 8;
            v2 = v2 + v6 & v4;
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
                            if(arg14.invoke(Long.valueOf(this.keys[v9]), this.values[v9]).booleanValue()) {
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
        Object v0_1 = this.values[arg9];
        this.values[arg9] = null;
        return v0_1;
    }

    public final void resizeStorage$collection(int arg23) {
        long[] v21;
        MutableLongObjectMap v0 = this;
        long[] v1 = v0.metadata;
        long[] v2 = v0.keys;
        Object[] v3 = v0.values;
        int v4 = v0._capacity;
        this.initializeStorage(arg23);
        long[] v5 = v0.metadata;
        long[] v6 = v0.keys;
        Object[] v7 = v0.values;
        int v8 = v0._capacity;
        int v9 = 0;
        while(v9 < v4) {
            long v12 = 0xFF;
            if((v1[v9 >> 3] >> ((v9 & 7) << 3) & v12) < 0x80) {
                long v10 = v2[v9];
                int v14 = Long.hashCode(v10) * 0xCC9E2D51;
                v14 ^= v14 << 16;
                int v15 = v0.findFirstAvailableSlot(v14 >>> 7);
                long v16 = v12;
                v12 = ((long)(v14 & 0x7F));
                v14 = v15 >> 3;
                int v18 = (v15 & 7) << 3;
                v21 = v1;
                long v0_1 = v5[v14] & ~(v16 << v18) | v12 << v18;
                v5[v14] = v0_1;
                v5[(v15 - 7 & v8) + (v8 & 7) >> 3] = v0_1;
                v6[v15] = v10;
                v7[v15] = v3[v9];
            }
            else {
                v21 = v1;
            }

            ++v9;
            v0 = this;
            v1 = v21;
        }
    }

    public final void set(long arg3, Object arg5) {
        int v0 = this.findAbsoluteInsertIndex(arg3);
        this.keys[v0] = arg3;
        this.values[v0] = arg5;
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

