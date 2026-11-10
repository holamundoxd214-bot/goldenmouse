package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000F\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b\tJ\u0006\u0010\n\u001A\u00020\bJ\r\u0010\u000B\u001A\u00020\bH\u0000¢\u0006\u0002\b\fJ\u0010\u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u000FH\u0002J\u0010\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0004H\u0002J\'\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u000E\u001A\u00020\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001A\u00020\bH\u0002J\u0010\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u0004H\u0002J\u0010\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0004H\u0002J\u0011\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001CH\u0086\nJ\u0011\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001DH\u0086\nJ\u0011\u0010\u001A\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u000FH\u0086\nJ\u0011\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001EH\u0086\nJ\u0017\u0010\u001F\u001A\u00020\b2\f\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001D\u0010!\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\"\u001A\u00028\u0000¢\u0006\u0002\u0010#J\u0014\u0010$\u001A\u00020\b2\f\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010%\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0002\u0010&J\u001B\u0010%\u001A\u00020\'2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\"\u001A\u00028\u0000¢\u0006\u0002\u0010(J&\u0010)\u001A\u00020\b2\u0018\u0010*\u001A\u0014\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\'0+H\u0086\bø\u0001\u0000J\u0017\u0010,\u001A\u0004\u0018\u00018\u00002\u0006\u0010-\u001A\u00020\u0004H\u0001¢\u0006\u0002\u0010.J\u0015\u0010/\u001A\u00020\b2\u0006\u00100\u001A\u00020\u0004H\u0000¢\u0006\u0002\b1J\u001E\u00102\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\"\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00103J\u0006\u00104\u001A\u00020\u0004R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2={"Landroidx/collection/MutableFloatObjectMap;", "V", "Landroidx/collection/FloatObjectMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "adjustStorage$collection", "clear", "dropDeletes", "dropDeletes$collection", "findAbsoluteInsertIndex", "key", "", "findFirstAvailableSlot", "hash1", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(FLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/FloatList;", "Landroidx/collection/FloatSet;", "", "plusAssign", "from", "put", "value", "(FLjava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(F)Ljava/lang/Object;", "", "(FLjava/lang/Object;)Z", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "resizeStorage$collection", "set", "(FLjava/lang/Object;)V", "trim", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class MutableFloatObjectMap extends FloatObjectMap {
    private int growthLimit;

    public MutableFloatObjectMap(int arg2) {
        super(null);
        int v0 = arg2 >= 0 ? 1 : 0;
        if(v0 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }

        this.initializeStorage(ScatterMapKt.unloadedCapacity(arg2));
    }

    public MutableFloatObjectMap(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 6;
        }

        this(arg1);
    }

    public MutableFloatObjectMap() {
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
        MutableFloatObjectMap v0 = this;
        long[] v1 = v0.metadata;
        int v2 = v0._capacity;
        float[] v3 = v0.keys;
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
            int v8_1 = Float.hashCode(v3[v5]) * 0xCC9E2D51;
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
                v3[v5] = 0f;
                v4[v17] = v4[v5];
                v4[v5] = null;
            }
            else {
                v24 = v10;
                v1[v6] = (((long)(v8_1 & 0x7F))) << v9 | v22 & ~(v13 << v9);
                float v6_1 = v3[v17];
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

    private final int findAbsoluteInsertIndex(float arg20) {
        MutableFloatObjectMap v0 = this;
        int v1 = Float.hashCode(arg20) * 0xCC9E2D51;
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
                if(v0.keys[v15_1] == arg20) {
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

    public final Object getOrPut(float arg2, Function0 arg3) {
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
        this.keys = new float[arg2];
        this.values = new Object[arg2];
    }

    public final void minusAssign(float arg1) {
        this.remove(arg1);
    }

    public final void minusAssign(FloatList arg4) {
        Intrinsics.checkNotNullParameter(arg4, "keys");
        float[] v0 = arg4.content;
        int v4 = arg4._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            this.remove(v0[v1]);
        }
    }

    public final void minusAssign(FloatSet arg14) {
        Intrinsics.checkNotNullParameter(arg14, "keys");
        float[] v0 = arg14.elements;
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

    public final void minusAssign(float[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "keys");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.remove(arg4[v1]);
        }
    }

    public final void plusAssign(FloatObjectMap arg2) {
        Intrinsics.checkNotNullParameter(arg2, "from");
        this.putAll(arg2);
    }

    public final Object put(float arg4, Object arg5) {
        int v0 = this.findAbsoluteInsertIndex(arg4);
        Object v1 = this.values[v0];
        this.keys[v0] = arg4;
        this.values[v0] = arg5;
        return v1;
    }

    public final void putAll(FloatObjectMap arg15) {
        Intrinsics.checkNotNullParameter(arg15, "from");
        float[] v0 = arg15.keys;
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

    public final Object remove(float arg15) {
        int v11_1;
        MutableFloatObjectMap v0 = this;
        int v1 = Float.hashCode(arg15) * 0xCC9E2D51;
        v1 ^= v1 << 16;
        int v2 = v1 & 0x7F;
        int v3 = ((FloatObjectMap)v0)._capacity;
        v1 = v1 >>> 7 & v3;
        int v4 = 0;
        while(true) {
            int v6 = v1 >> 3;
            int v7 = (v1 & 7) << 3;
            long v5 = ((FloatObjectMap)v0).metadata[v6 + 1] << 0x40 - v7 & -(((long)v7)) >> 0x3F | ((FloatObjectMap)v0).metadata[v6] >>> v7;
            long v7_1 = (((long)v2)) * 0x101010101010101L ^ v5;
            long v9 = -9187201950435737472L;
            v7_1 = ~v7_1 & v7_1 - 0x101010101010101L & v9;
            while(true) {
                long v11 = 0;
                if(v7_1 != v11) {
                    v11_1 = (Long.numberOfTrailingZeros(v7_1) >> 3) + v1 & v3;
                    if(((FloatObjectMap)v0).keys[v11_1] == arg15) {
                    }
                    else {
                        v7_1 &= v7_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_57;
            }

            if((v5 & ~v5 << 6 & v9) != v11) {
                v11_1 = -1;
            }
            else {
                goto label_62;
            }

        label_57:
            if(v11_1 >= 0) {
                return this.removeValueAt(v11_1);
            }

            return null;
        label_62:
            v4 += 8;
            v1 = v1 + v4 & v3;
        }
    }

    public final boolean remove(float arg18, Object arg19) {
        int v11;
        MutableFloatObjectMap v0 = this;
        MutableFloatObjectMap v1 = v0;
        int v2 = Float.hashCode(arg18) * 0xCC9E2D51;
        v2 ^= v2 << 16;
        int v3 = v2 & 0x7F;
        int v4 = ((FloatObjectMap)v1)._capacity;
        v2 = v2 >>> 7 & v4;
        int v6 = 0;
        while(true) {
            int v8 = v2 >> 3;
            int v9 = (v2 & 7) << 3;
            long v7 = ((FloatObjectMap)v1).metadata[v8 + 1] << 0x40 - v9 & -(((long)v9)) >> 0x3F | ((FloatObjectMap)v1).metadata[v8] >>> v9;
            long v9_1 = (((long)v3)) * 0x101010101010101L ^ v7;
            long v13 = -9187201950435737472L;
            v9_1 = ~v9_1 & v9_1 - 0x101010101010101L & v13;
            while(true) {
                long v15 = 0;
                if(v9_1 != v15) {
                    v11 = (Long.numberOfTrailingZeros(v9_1) >> 3) + v2 & v4;
                    if(((FloatObjectMap)v1).keys[v11] == arg18) {
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
            if(v11 >= 0 && (Intrinsics.areEqual(v0.values[v11], arg19))) {
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
                            if(arg14.invoke(Float.valueOf(this.keys[v9]), this.values[v9]).booleanValue()) {
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

    public final void resizeStorage$collection(int arg22) {
        long[] v20;
        MutableFloatObjectMap v0 = this;
        long[] v1 = v0.metadata;
        float[] v2 = v0.keys;
        Object[] v3 = v0.values;
        int v4 = v0._capacity;
        this.initializeStorage(arg22);
        long[] v5 = v0.metadata;
        float[] v6 = v0.keys;
        Object[] v7 = v0.values;
        int v8 = v0._capacity;
        int v9 = 0;
        while(v9 < v4) {
            long v12 = 0xFF;
            if((v1[v9 >> 3] >> ((v9 & 7) << 3) & v12) < 0x80) {
                float v10 = v2[v9];
                int v11 = Float.hashCode(v10) * 0xCC9E2D51;
                v11 ^= v11 << 16;
                int v14 = v0.findFirstAvailableSlot(v11 >>> 7);
                long v15 = v12;
                v12 = ((long)(v11 & 0x7F));
                v11 = v14 >> 3;
                int v17 = (v14 & 7) << 3;
                v20 = v1;
                long v0_1 = v5[v11] & ~(v15 << v17) | v12 << v17;
                v5[v11] = v0_1;
                v5[(v14 - 7 & v8) + (v8 & 7) >> 3] = v0_1;
                v6[v14] = v10;
                v7[v14] = v3[v9];
            }
            else {
                v20 = v1;
            }

            ++v9;
            v0 = this;
            v1 = v20;
        }
    }

    public final void set(float arg3, Object arg4) {
        int v0 = this.findAbsoluteInsertIndex(arg3);
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

