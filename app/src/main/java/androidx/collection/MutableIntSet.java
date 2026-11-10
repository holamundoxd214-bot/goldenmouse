package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000F\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0003J\u000E\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0001J\u000E\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BJ\r\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0002\b\u000EJ\u0006\u0010\u000F\u001A\u00020\rJ\r\u0010\u0010\u001A\u00020\rH\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u0003H\u0002J\u0010\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u0003H\u0002J\b\u0010\u0015\u001A\u00020\rH\u0002J\u0010\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u0003H\u0002J\u0010\u0010\u0018\u001A\u00020\r2\u0006\u0010\u0002\u001A\u00020\u0003H\u0002J\u0011\u0010\u0019\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u0001H\u0086\u0002J\u0011\u0010\u0019\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u0003H\u0086\u0002J\u0011\u0010\u0019\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u000BH\u0086\u0002J\u0011\u0010\u001A\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u0001H\u0086\u0002J\u0011\u0010\u001A\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u0003H\u0086\u0002J\u0011\u0010\u001A\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u000BH\u0086\u0002J\u000E\u0010\u001B\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0003J\u000E\u0010\u001C\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0001J\u000E\u0010\u001C\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BJ\u0010\u0010\u001D\u001A\u00020\r2\u0006\u0010\u001E\u001A\u00020\u0003H\u0002J\u0015\u0010\u001F\u001A\u00020\r2\u0006\u0010 \u001A\u00020\u0003H\u0000¢\u0006\u0002\b!J\b\u0010\"\u001A\u00020\u0003H\u0007R\u000E\u0010\u0005\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/collection/MutableIntSet;", "Landroidx/collection/IntSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "addAll", "elements", "", "adjustStorage", "", "adjustStorage$collection", "clear", "dropDeletes", "dropDeletes$collection", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "plusAssign", "remove", "removeAll", "removeElementAt", "index", "resizeStorage", "newCapacity", "resizeStorage$collection", "trim", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class MutableIntSet extends IntSet {
    private int growthLimit;

    public MutableIntSet(int arg2) {
        super(null);
        int v0 = arg2 >= 0 ? 1 : 0;
        if(v0 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }

        this.initializeStorage(ScatterMapKt.unloadedCapacity(arg2));
    }

    public MutableIntSet(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 6;
        }

        this(arg1);
    }

    public MutableIntSet() {
        this(0, 1, null);
    }

    public final boolean add(int arg4) {
        int v0 = this._size;
        this.elements[this.findAbsoluteInsertIndex(arg4)] = arg4;
        if(this._size != v0) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(IntSet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.plusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean addAll(int[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.plusAssign(arg2);
        if(v0 != this._size) {
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

    public final void clear() {
        this._size = 0;
        if(this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, 0, 0, 6, null);
            long[] v0 = this.metadata;
            int v2 = this._capacity >> 3;
            long v5 = 0xFF << ((this._capacity & 7) << 3);
            v0[v2] = v0[v2] & ~v5 | v5;
        }

        this.initializeGrowth();
    }

    public final void dropDeletes$collection() {
        long v23;
        long v7;
        MutableIntSet v0 = this;
        long[] v1 = v0.metadata;
        int v2 = v0._capacity;
        int[] v3 = v0.elements;
        int v4 = v2 + 7 >> 3;
        int v5 = 0;
        int v6;
        for(v6 = 0; v6 < v4; ++v6) {
            v7 = v1[v6] & -9187201950435737472L;
            v1[v6] = -72340172838076674L & ~v7 + (v7 >>> 7);
        }

        v4 = ArraysKt.getLastIndex(v1);
        v6 = v4 - 1;
        long v9 = 0xFFFFFFFFFFFFFFL;
        v1[v6] = v1[v6] & v9 | -72057594037927936L;
        v1[v4] = v1[0];
        v4 = 0;
        while(v4 != v2) {
            v6 = v4 >> 3;
            int v11 = (v4 & 7) << 3;
            long v12 = 0xFF;
            v7 = v1[v6] >> v11 & v12;
            long v14 = 0x80;
            if(v7 != v14) {
                if(v7 != 0xFE) {
                }
                else {
                    goto label_47;
                }
            }

            ++v4;
            continue;
        label_47:
            int v7_1 = Integer.hashCode(v3[v4]) * 0xCC9E2D51;
            v7_1 ^= v7_1 << 16;
            int v8 = v7_1 >>> 7;
            int v16 = v0.findFirstAvailableSlot(v8);
            v8 &= v2;
            int v18 = v5;
            long v19 = -9223372036854775808L;
            if((v16 - v8 & v2) / 8 == (v4 - v8 & v2) / 8) {
                v1[v6] = (((long)(v7_1 & 0x7F))) << v11 | ~(v12 << v11) & v1[v6];
                v1[ArraysKt.getLastIndex(v1)] = v1[v18] & v9 | v19;
                ++v4;
                v5 = v18;
                continue;
            }

            v5 = v16 >> 3;
            long v21 = v1[v5];
            v8 = (v16 & 7) << 3;
            if((v21 >> v8 & v12) == v14) {
                v23 = v9;
                v1[v5] = (((long)(v7_1 & 0x7F))) << v8 | v21 & ~(v12 << v8);
                v1[v6] = v1[v6] & ~(v12 << v11) | v14 << v11;
                v3[v16] = v3[v4];
                v3[v4] = v18;
            }
            else {
                v23 = v9;
                v1[v5] = (((long)(v7_1 & 0x7F))) << v8 | v21 & ~(v12 << v8);
                v5 = v3[v16];
                v3[v16] = v3[v4];
                v3[v4] = v5;
                --v4;
            }

            v1[ArraysKt.getLastIndex(v1)] = v1[v18] & v23 | v19;
            ++v4;
            v5 = v18;
            v9 = v23;
        }

        v0.initializeGrowth();
    }

    private final int findAbsoluteInsertIndex(int arg21) {
        int v19;
        MutableIntSet v0 = this;
        int v1 = Integer.hashCode(arg21) * 0xCC9E2D51;
        v1 ^= v1 << 16;
        int v2 = v1 >>> 7;
        v1 &= 0x7F;
        int v3 = v0._capacity;
        int v4 = v2 & v3;
        int v6 = 0;
        while(true) {
            int v8 = v4 >> 3;
            int v9 = (v4 & 7) << 3;
            int v12 = 1;
            long v7 = v0.metadata[v8 + 1] << 0x40 - v9 & -(((long)v9)) >> 0x3F | v0.metadata[v8] >>> v9;
            long v9_1 = ((long)v1);
            int v17 = v6;
            long v5 = v7 ^ v9_1 * 0x101010101010101L;
            long v13 = -9187201950435737472L;
            v5 = ~v5 & v5 - 0x101010101010101L & v13;
            while(true) {
                long v15 = 0;
                if(v5 == v15) {
                    break;
                }

                int v15_1 = (Long.numberOfTrailingZeros(v5) >> 3) + v4 & v3;
                v19 = v12;
                if(v0.elements[v15_1] == arg21) {
                    return v15_1;
                }

                v5 &= v5 - 1;
                v12 = v19;
            }

            v19 = v12;
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
                int v18 = (v0.metadata[v6] >> v3 & v4_1) == 0x80 ? v19 : 0;
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
        this.elements = new int[arg2];
    }

    public final void minusAssign(int arg15) {
        int v11_1;
        MutableIntSet v0 = this;
        int v1 = Integer.hashCode(arg15) * 0xCC9E2D51;
        v1 ^= v1 << 16;
        int v2 = v1 & 0x7F;
        int v3 = ((IntSet)v0)._capacity;
        v1 = v1 >>> 7 & v3;
        int v4 = 0;
        while(true) {
            int v6 = v1 >> 3;
            int v7 = (v1 & 7) << 3;
            long v5 = ((IntSet)v0).metadata[v6 + 1] << 0x40 - v7 & -(((long)v7)) >> 0x3F | ((IntSet)v0).metadata[v6] >>> v7;
            long v7_1 = (((long)v2)) * 0x101010101010101L ^ v5;
            long v9 = -9187201950435737472L;
            v7_1 = ~v7_1 & v7_1 - 0x101010101010101L & v9;
            while(true) {
                long v11 = 0;
                if(v7_1 != v11) {
                    v11_1 = (Long.numberOfTrailingZeros(v7_1) >> 3) + v1 & v3;
                    if(((IntSet)v0).elements[v11_1] == arg15) {
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
                goto label_60;
            }

        label_57:
            if(v11_1 >= 0) {
                this.removeElementAt(v11_1);
            }

            return;
        label_60:
            v4 += 8;
            v1 = v1 + v4 & v3;
        }
    }

    public final void minusAssign(IntSet arg14) {
        Intrinsics.checkNotNullParameter(arg14, "elements");
        int[] v0 = arg14.elements;
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

    public final void minusAssign(int[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.minusAssign(arg4[v1]);
        }
    }

    public final void plusAssign(int[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.plusAssign(arg4[v1]);
        }
    }

    public final void plusAssign(int arg2) {
        this.elements[this.findAbsoluteInsertIndex(arg2)] = arg2;
    }

    public final void plusAssign(IntSet arg14) {
        Intrinsics.checkNotNullParameter(arg14, "elements");
        int[] v0 = arg14.elements;
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

    public final boolean remove(int arg18) {
        int v11;
        MutableIntSet v0 = this;
        MutableIntSet v1 = v0;
        int v2 = Integer.hashCode(arg18) * 0xCC9E2D51;
        v2 ^= v2 << 16;
        int v3 = v2 & 0x7F;
        int v4 = ((IntSet)v1)._capacity;
        v2 = v2 >>> 7 & v4;
        int v6 = 0;
        while(true) {
            int v8 = v2 >> 3;
            int v9 = (v2 & 7) << 3;
            long v7 = ((IntSet)v1).metadata[v8 + 1] << 0x40 - v9 & -(((long)v9)) >> 0x3F | ((IntSet)v1).metadata[v8] >>> v9;
            long v9_1 = (((long)v3)) * 0x101010101010101L ^ v7;
            long v13 = -9187201950435737472L;
            v9_1 = ~v9_1 & v9_1 - 0x101010101010101L & v13;
            while(true) {
                long v15 = 0;
                if(v9_1 != v15) {
                    v11 = (Long.numberOfTrailingZeros(v9_1) >> 3) + v2 & v4;
                    if(((IntSet)v1).elements[v11] == arg18) {
                    }
                    else {
                        v9_1 &= v9_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_61;
            }

            if((v7 & ~v7 << 6 & v13) != v15) {
                v11 = -1;
            }
            else {
                goto label_68;
            }

        label_61:
            boolean v5 = v11 >= 0 ? true : false;
            if(v5) {
                v0.removeElementAt(v11);
            }

            return v5;
        label_68:
            v6 += 8;
            v2 = v2 + v6 & v4;
        }
    }

    public final boolean removeAll(IntSet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.minusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(int[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = this._size;
        this.minusAssign(arg2);
        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    private final void removeElementAt(int arg8) {
        --this._size;
        long[] v0 = this.metadata;
        int v7 = this._capacity;
        int v1 = arg8 >> 3;
        int v2 = (arg8 & 7) << 3;
        long v2_1 = v0[v1] & ~(0xFF << v2) | 0xFE << v2;
        v0[v1] = v2_1;
        v0[(arg8 - 7 & v7) + (v7 & 7) >> 3] = v2_1;
    }

    public final void resizeStorage$collection(int arg19) {
        MutableIntSet v0 = this;
        long[] v1 = v0.metadata;
        int[] v2 = v0.elements;
        int v3 = v0._capacity;
        this.initializeStorage(arg19);
        long[] v4 = v0.metadata;
        int[] v5 = v0.elements;
        int v6 = v0._capacity;
        int v7;
        for(v7 = 0; v7 < v3; ++v7) {
            long v10 = 0xFF;
            if((v1[v7 >> 3] >> ((v7 & 7) << 3) & v10) < 0x80) {
                int v8 = v2[v7];
                int v9 = Integer.hashCode(v8) * 0xCC9E2D51;
                v9 ^= v9 << 16;
                int v12 = v0.findFirstAvailableSlot(v9 >>> 7);
                long v13 = ((long)(v9 & 0x7F));
                v9 = v12 >> 3;
                int v15 = (v12 & 7) << 3;
                v10 = v4[v9] & ~(v10 << v15) | v13 << v15;
                v4[v9] = v10;
                v4[(v12 - 7 & v6) + (v6 & 7) >> 3] = v10;
                v5[v12] = v8;
            }
        }
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

