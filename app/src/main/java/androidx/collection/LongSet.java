package androidx.collection;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J:\u0010\u0010\u001A\u00020\u00112!\u0010\u0012\u001A\u001D\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0018\u001A\u00020\u0011J:\u0010\u0018\u001A\u00020\u00112!\u0010\u0012\u001A\u001D\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0011\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0014H\u0086\u0002J\b\u0010\u001A\u001A\u00020\u0004H\u0007J:\u0010\u001A\u001A\u00020\u00042!\u0010\u0012\u001A\u001D\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u0010\u001B\u001A\u00020\u00112\b\u0010\u001C\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\u0016\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u0014H\u0080\b¢\u0006\u0002\b\u001EJ\t\u0010\u001F\u001A\u00020\u0014H\u0086\bJ:\u0010\u001F\u001A\u00020\u00142!\u0010\u0012\u001A\u001D\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010 \u001A\u00020!2!\u0010\"\u001A\u001D\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020!0\u0013H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010#\u001A\u00020!2!\u0010\"\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b($\u0012\u0004\u0012\u00020!0\u0013H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010%\u001A\u00020\u0004H\u0016J\u0006\u0010&\u001A\u00020\u0011J\u0006\u0010\'\u001A\u00020\u0011J:\u0010(\u001A\u00020)2\b\b\u0002\u0010*\u001A\u00020+2\b\b\u0002\u0010,\u001A\u00020+2\b\b\u0002\u0010-\u001A\u00020+2\b\b\u0002\u0010.\u001A\u00020\u00042\b\b\u0002\u0010/\u001A\u00020+H\u0007JT\u0010(\u001A\u00020)2\b\b\u0002\u0010*\u001A\u00020+2\b\b\u0002\u0010,\u001A\u00020+2\b\b\u0002\u0010-\u001A\u00020+2\b\b\u0002\u0010.\u001A\u00020\u00042\b\b\u0002\u0010/\u001A\u00020+2\u0014\b\u0004\u00100\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020+0\u0013H\u0087\bø\u0001\u0000J\u0006\u00101\u001A\u00020\u0011J\b\u00102\u001A\u00020)H\u0016R\u0012\u0010\u0003\u001A\u00020\u00048\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001A\u00020\u00048\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00048G¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001A\u00020\n8\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u000B\u0010\u0002R\u0018\u0010\f\u001A\u00020\n8\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0011\u0010\u000E\u001A\u00020\u00048G¢\u0006\u0006\u001A\u0004\b\u000F\u0010\b\u0082\u0001\u00013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, d2={"Landroidx/collection/LongSet;", "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "elements", "", "getElements$annotations", "metadata", "getMetadata$annotations", "size", "getSize", "all", "", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "element", "any", "contains", "count", "equals", "other", "findElementIndex", "findElementIndex$collection", "first", "forEach", "", "block", "forEachIndex", "index", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableLongSet;", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public abstract class LongSet {
    public int _capacity;
    public int _size;
    public long[] elements;
    public long[] metadata;

    private LongSet() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = LongSetKt.getEmptyLongArray();
    }

    public LongSet(DefaultConstructorMarker arg1) {
        this();
    }

    public final boolean all(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "predicate");
        long[] v0 = this.elements;
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
                        if((0xFF & v4) < 0x80 && !arg14.invoke(Long.valueOf(v0[(v3 << 3) + v8])).booleanValue()) {
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
        long[] v0 = this.elements;
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
                        if((0xFF & v4) < 0x80 && (arg14.invoke(Long.valueOf(v0[(v3 << 3) + v8])).booleanValue())) {
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

    public final boolean contains(long arg18) {
        int v10;
        LongSet v0 = this;
        int v1 = Long.hashCode(arg18) * 0xCC9E2D51;
        v1 ^= v1 << 16;
        int v2 = v1 & 0x7F;
        int v3 = v0._capacity;
        v1 = v1 >>> 7 & v3;
        int v5 = 0;
        while(true) {
            int v7 = v1 >> 3;
            int v8 = (v1 & 7) << 3;
            long v6 = v0.metadata[v7 + 1] << 0x40 - v8 & -(((long)v8)) >> 0x3F | v0.metadata[v7] >>> v8;
            long v8_1 = (((long)v2)) * 0x101010101010101L ^ v6;
            long v12 = -9187201950435737472L;
            v8_1 = ~v8_1 & v8_1 - 0x101010101010101L & v12;
            while(true) {
                long v14 = 0;
                if(v8_1 != v14) {
                    v10 = (Long.numberOfTrailingZeros(v8_1) >> 3) + v1 & v3;
                    if(v0.elements[v10] == arg18) {
                    }
                    else {
                        v8_1 &= v8_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_59;
            }

            if((v6 & ~v6 << 6 & v12) != v14) {
                v10 = -1;
            }
            else {
                goto label_62;
            }

        label_59:
            if(v10 >= 0) {
                return 1;
            }

            return 0;
        label_62:
            v5 += 8;
            v1 = v1 + v5 & v3;
        }
    }

    public final int count() {
        return this._size;
    }

    public final int count(Function1 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "predicate");
        long[] v0 = this.elements;
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
                        if((0xFF & v5) < 0x80 && (arg15.invoke(Long.valueOf(v0[(v3 << 3) + v9])).booleanValue())) {
                            ++v4;
                        }

                        v5 >>= v8;
                    }

                    if(v7 == v8) {
                        goto label_43;
                    }

                    return v4;
                }

            label_43:
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
        if((((LongSet)arg15)) == this) {
            return 1;
        }

        if(!(arg15 instanceof LongSet)) {
            return 0;
        }

        if(((LongSet)arg15)._size != this._size) {
            return 0;
        }

        long[] v1 = this.elements;
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
                        if((0xFF & v5) < 0x80 && !((LongSet)arg15).contains(v1[(v4 << 3) + v9])) {
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

    public final int findElementIndex$collection(long arg15) {
        int v0 = Long.hashCode(arg15) * 0xCC9E2D51;
        v0 ^= v0 << 16;
        int v1 = v0 & 0x7F;
        int v2 = this._capacity;
        v0 = v0 >>> 7 & v2;
        int v3 = 0;
        while(true) {
            int v5 = v0 >> 3;
            int v6 = (v0 & 7) << 3;
            long v4 = this.metadata[v5 + 1] << 0x40 - v6 & -(((long)v6)) >> 0x3F | this.metadata[v5] >>> v6;
            long v6_1 = (((long)v1)) * 0x101010101010101L ^ v4;
            long v8 = -9187201950435737472L;
            for(v6_1 = ~v6_1 & v6_1 - 0x101010101010101L & v8; true; v6_1 &= v6_1 - 1) {
                long v10 = 0;
                if(v6_1 == v10) {
                    break;
                }

                int v10_1 = (Long.numberOfTrailingZeros(v6_1) >> 3) + v0 & v2;
                if(this.elements[v10_1] == arg15) {
                    return v10_1;
                }
            }

            if((v4 & ~v4 << 6 & v8) != v10) {
                return -1;
            }

            v3 += 8;
            v0 = v0 + v3 & v2;
        }
    }

    public final long first() {
        long[] v0 = this.elements;
        long[] v13 = this.metadata;
        int v1 = v13.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v13[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8 = 0;
                    while(true) {
                        if(v8 >= v6) {
                            break;
                        }
                        else if((0xFF & v4) < 0x80) {
                            return v0[(v3 << 3) + v8];
                        }
                        else {
                            v4 >>= v7;
                            ++v8;
                            continue;
                        }

                        goto label_34;
                    }

                    if(v6 == v7) {
                        goto label_34;
                    }

                    break;
                }

            label_34:
                if(v3 == v1) {
                    break;
                }
            }
        }

        throw new NoSuchElementException("The LongSet is empty");
    }

    public final long first(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "predicate");
        long[] v0 = this.elements;
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
                            long v9 = v0[(v3 << 3) + v8];
                            if(arg14.invoke(Long.valueOf(v9)).booleanValue()) {
                                return v9;
                            }
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        break;
                    }
                }

                if(v3 == v1) {
                    break;
                }
            }
        }

        throw new NoSuchElementException("Could not find a match");
    }

    public final void forEach(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "block");
        long[] v0 = this.elements;
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
                            arg14.invoke(Long.valueOf(v0[(v3 << 3) + v8]));
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

    public final void forEachIndex(Function1 arg13) {
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

    public final int getCapacity() {
        return this._capacity;
    }

    public static void getElements$annotations() {
    }

    public static void getMetadata$annotations() {
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        long[] v0 = this.elements;
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
                        if((0xFF & v5) < 0x80) {
                            v4 += Long.hashCode(v0[(v3 << 3) + v9]);
                        }

                        v5 >>= v8;
                    }

                    if(v7 == v8) {
                        goto label_38;
                    }

                    return v4;
                }

            label_38:
                if(v3 == v1) {
                    return v4;
                }

                ++v3;
            }

            return v4;
        }

        return 0;
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

    public final String joinToString(CharSequence arg20, CharSequence arg21, CharSequence arg22, int arg23, CharSequence arg24) {
        int v7_1;
        int v21;
        CharSequence v1 = arg20;
        CharSequence v3 = arg22;
        CharSequence v4 = arg24;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg21, "prefix");
        Intrinsics.checkNotNullParameter(v3, "postfix");
        Intrinsics.checkNotNullParameter(v4, "truncated");
        StringBuilder v5 = new StringBuilder();
        v5.append(arg21);
        long[] v2 = this.elements;
        long[] v0 = this.metadata;
        int v6 = v0.length - 2;
        if(v6 >= 0) {
            int v8 = 0;
            int v9 = 0;
            while(true) {
                long v10 = v0[v8];
                if((~v10 << 7 & v10 & -9187201950435737472L) != -9187201950435737472L) {
                    int v13 = 8;
                    int v12 = 8 - (~(v8 - v6) >>> 0x1F);
                    int v14 = 0;
                    while(v14 < v12) {
                        if((0xFF & v10) < 0x80) {
                            v21 = v8;
                            long v7 = v2[(v8 << 3) + v14];
                            if(v9 == arg23) {
                                v5.append(v4);
                                goto label_72;
                            }
                            else {
                                if(v9 != 0) {
                                    v5.append(v1);
                                }

                                v5.append(v7);
                                ++v9;
                            }
                        }
                        else {
                            v21 = v8;
                        }

                        v10 >>= v13;
                        ++v14;
                        v8 = v21;
                    }

                    v21 = v8;
                    if(v12 != v13) {
                        goto label_71;
                    }

                    v7_1 = v21;
                }
                else {
                    v7_1 = v8;
                }

                if(v7_1 == v6) {
                    goto label_71;
                }

                v8 = v7_1 + 1;
            }
        }
        else {
        label_71:
            v5.append(v3);
        }

    label_72:
        String v0_1 = v5.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString() {
        return LongSet.joinToString$default(this, null, null, null, 0, null, 0x1F, null);
    }

    public final String joinToString(CharSequence arg10) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        return LongSet.joinToString$default(this, arg10, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence arg10, CharSequence arg11) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        Intrinsics.checkNotNullParameter(arg11, "prefix");
        return LongSet.joinToString$default(this, arg10, arg11, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence arg10, CharSequence arg11, CharSequence arg12) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        Intrinsics.checkNotNullParameter(arg11, "prefix");
        Intrinsics.checkNotNullParameter(arg12, "postfix");
        return LongSet.joinToString$default(this, arg10, arg11, arg12, 0, null, 24, null);
    }

    public final String joinToString(CharSequence arg10, CharSequence arg11, CharSequence arg12, int arg13) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        Intrinsics.checkNotNullParameter(arg11, "prefix");
        Intrinsics.checkNotNullParameter(arg12, "postfix");
        return LongSet.joinToString$default(this, arg10, arg11, arg12, arg13, null, 16, null);
    }

    public final String joinToString(CharSequence arg21, CharSequence arg22, CharSequence arg23, int arg24, CharSequence arg25, Function1 arg26) {
        int v22;
        CharSequence v1 = arg21;
        CharSequence v3 = arg23;
        CharSequence v4 = arg25;
        Function1 v5 = arg26;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg22, "prefix");
        Intrinsics.checkNotNullParameter(v3, "postfix");
        Intrinsics.checkNotNullParameter(v4, "truncated");
        Intrinsics.checkNotNullParameter(v5, "transform");
        StringBuilder v6 = new StringBuilder();
        v6.append(arg22);
        long[] v2 = this.elements;
        long[] v0 = this.metadata;
        int v7 = v0.length - 2;
        if(v7 >= 0) {
            int v9 = 0;
            int v10 = 0;
            while(true) {
                long v11 = v0[v9];
                if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                    int v14 = 8;
                    int v13 = 8 - (~(v9 - v7) >>> 0x1F);
                    int v15 = 0;
                    while(v15 < v13) {
                        if((v11 & 0xFF) < 0x80) {
                            long v16 = v2[(v9 << 3) + v15];
                            if(v10 == arg24) {
                                v6.append(v4);
                                goto label_75;
                            }
                            else {
                                if(v10 != 0) {
                                    v6.append(v1);
                                }

                                v22 = v14;
                                v6.append(v5.invoke(Long.valueOf(v16)));
                                ++v10;
                            }
                        }
                        else {
                            v22 = v14;
                        }

                        v11 >>= v22;
                        ++v15;
                        v14 = v22;
                    }

                    if(v13 != v14) {
                        goto label_74;
                    }
                }

                if(v9 == v7) {
                    goto label_74;
                }

                ++v9;
            }
        }
        else {
        label_74:
            v6.append(v3);
        }

    label_75:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString(CharSequence arg21, CharSequence arg22, CharSequence arg23, int arg24, Function1 arg25) {
        int v22;
        CharSequence v1 = arg21;
        CharSequence v3 = arg23;
        Function1 v4 = arg25;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg22, "prefix");
        Intrinsics.checkNotNullParameter(v3, "postfix");
        Intrinsics.checkNotNullParameter(v4, "transform");
        String v5 = "...";
        StringBuilder v6 = new StringBuilder();
        v6.append(arg22);
        long[] v2 = this.elements;
        long[] v0 = this.metadata;
        int v7 = v0.length - 2;
        if(v7 >= 0) {
            int v9 = 0;
            int v10 = 0;
            while(true) {
                long v11 = v0[v9];
                if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                    int v14 = 8;
                    int v13 = 8 - (~(v9 - v7) >>> 0x1F);
                    int v15 = 0;
                    while(v15 < v13) {
                        if((v11 & 0xFF) < 0x80) {
                            long v16 = v2[(v9 << 3) + v15];
                            if(v10 == arg24) {
                                v6.append(((CharSequence)v5));
                                goto label_73;
                            }
                            else {
                                if(v10 != 0) {
                                    v6.append(v1);
                                }

                                v22 = v14;
                                v6.append(v4.invoke(Long.valueOf(v16)));
                                ++v10;
                            }
                        }
                        else {
                            v22 = v14;
                        }

                        v11 >>= v22;
                        ++v15;
                        v14 = v22;
                    }

                    if(v13 != v14) {
                        goto label_72;
                    }
                }

                if(v9 == v7) {
                    goto label_72;
                }

                ++v9;
            }
        }
        else {
        label_72:
            v6.append(v3);
        }

    label_73:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString(CharSequence arg21, CharSequence arg22, CharSequence arg23, Function1 arg24) {
        CharSequence v1 = arg21;
        CharSequence v3 = arg23;
        Function1 v4 = arg24;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg22, "prefix");
        Intrinsics.checkNotNullParameter(v3, "postfix");
        Intrinsics.checkNotNullParameter(v4, "transform");
        String v5 = "...";
        StringBuilder v6 = new StringBuilder();
        v6.append(arg22);
        long[] v2 = this.elements;
        long[] v0 = this.metadata;
        int v7 = v0.length - 2;
        if(v7 >= 0) {
            int v9 = 0;
            int v10 = 0;
            while(true) {
                long v11 = v0[v9];
                if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                    int v14 = 8;
                    int v13 = 8 - (~(v9 - v7) >>> 0x1F);
                    int v15;
                    for(v15 = 0; v15 < v13; ++v15) {
                        if((v11 & 0xFF) < 0x80) {
                            long v16 = v2[(v9 << 3) + v15];
                            if(v10 == -1) {
                                v6.append(((CharSequence)v5));
                                goto label_64;
                            }
                            else {
                                if(v10 != 0) {
                                    v6.append(v1);
                                }

                                v6.append(v4.invoke(Long.valueOf(v16)));
                                ++v10;
                            }
                        }

                        v11 >>= v14;
                    }

                    if(v13 != v14) {
                        goto label_63;
                    }
                }

                if(v9 == v7) {
                    goto label_63;
                }

                ++v9;
            }
        }
        else {
        label_63:
            v6.append(v3);
        }

    label_64:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString(CharSequence arg21, CharSequence arg22, Function1 arg23) {
        CharSequence v1 = arg21;
        Function1 v3 = arg23;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg22, "prefix");
        Intrinsics.checkNotNullParameter(v3, "transform");
        String v4 = "";
        String v5 = "...";
        StringBuilder v6 = new StringBuilder();
        v6.append(arg22);
        long[] v2 = this.elements;
        long[] v0 = this.metadata;
        int v7 = v0.length - 2;
        if(v7 >= 0) {
            int v9 = 0;
            int v10 = 0;
            while(true) {
                long v11 = v0[v9];
                if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                    int v14 = 8;
                    int v13 = 8 - (~(v9 - v7) >>> 0x1F);
                    int v15;
                    for(v15 = 0; v15 < v13; ++v15) {
                        if((v11 & 0xFF) < 0x80) {
                            long v16 = v2[(v9 << 3) + v15];
                            if(v10 == -1) {
                                v6.append(((CharSequence)v5));
                                goto label_62;
                            }
                            else {
                                if(v10 != 0) {
                                    v6.append(v1);
                                }

                                v6.append(v3.invoke(Long.valueOf(v16)));
                                ++v10;
                            }
                        }

                        v11 >>= v14;
                    }

                    if(v13 != v14) {
                        goto label_61;
                    }
                }

                if(v9 == v7) {
                    goto label_61;
                }

                ++v9;
            }
        }
        else {
        label_61:
            v6.append(((CharSequence)v4));
        }

    label_62:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString(CharSequence arg21, Function1 arg22) {
        CharSequence v1 = arg21;
        Function1 v2 = arg22;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(v2, "transform");
        String v3 = "";
        String v5 = "...";
        StringBuilder v6 = new StringBuilder();
        v6.append(v3);
        long[] v4 = this.elements;
        long[] v0 = this.metadata;
        int v7 = v0.length - 2;
        if(v7 >= 0) {
            int v9 = 0;
            int v10 = 0;
            while(true) {
                long v11 = v0[v9];
                if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                    int v14 = 8;
                    int v13 = 8 - (~(v9 - v7) >>> 0x1F);
                    int v15;
                    for(v15 = 0; v15 < v13; ++v15) {
                        if((v11 & 0xFF) < 0x80) {
                            long v16 = v4[(v9 << 3) + v15];
                            if(v10 == -1) {
                                v6.append(((CharSequence)v5));
                                goto label_60;
                            }
                            else {
                                if(v10 != 0) {
                                    v6.append(v1);
                                }

                                v6.append(v2.invoke(Long.valueOf(v16)));
                                ++v10;
                            }
                        }

                        v11 >>= v14;
                    }

                    if(v13 != v14) {
                        goto label_59;
                    }
                }

                if(v9 == v7) {
                    goto label_59;
                }

                ++v9;
            }
        }
        else {
        label_59:
            v6.append(((CharSequence)v3));
        }

    label_60:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString(Function1 arg21) {
        Function1 v1 = arg21;
        Intrinsics.checkNotNullParameter(v1, "transform");
        String v2 = ", ";
        String v3 = "";
        String v5 = "...";
        StringBuilder v6 = new StringBuilder();
        v6.append(v3);
        long[] v4 = this.elements;
        long[] v0 = this.metadata;
        int v7 = v0.length - 2;
        if(v7 >= 0) {
            int v9 = 0;
            int v10 = 0;
            while(true) {
                long v11 = v0[v9];
                if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                    int v14 = 8;
                    int v13 = 8 - (~(v9 - v7) >>> 0x1F);
                    int v15;
                    for(v15 = 0; v15 < v13; ++v15) {
                        if((v11 & 0xFF) < 0x80) {
                            long v16 = v4[(v9 << 3) + v15];
                            if(v10 == -1) {
                                v6.append(((CharSequence)v5));
                                goto label_58;
                            }
                            else {
                                if(v10 != 0) {
                                    v6.append(((CharSequence)v2));
                                }

                                v6.append(v1.invoke(Long.valueOf(v16)));
                                ++v10;
                            }
                        }

                        v11 >>= v14;
                    }

                    if(v13 != v14) {
                        goto label_57;
                    }
                }

                if(v9 == v7) {
                    goto label_57;
                }

                ++v9;
            }
        }
        else {
        label_57:
            v6.append(((CharSequence)v3));
        }

    label_58:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public static String joinToString$default(LongSet arg1, CharSequence arg2, CharSequence arg3, CharSequence arg4, int arg5, CharSequence arg6, int arg7, Object arg8) {
        String v6;
        String v4;
        String v3;
        String v2;
        if(arg8 == null) {
            if((arg7 & 1) != 0) {
                v2 = ", ";
            }

            String v0 = "";
            if((arg7 & 2) != 0) {
                v3 = v0;
            }

            if((arg7 & 4) != 0) {
                v4 = v0;
            }

            if((arg7 & 8) != 0) {
                arg5 = -1;
            }

            if((arg7 & 16) != 0) {
                v6 = "...";
            }

            return arg1.joinToString(((CharSequence)v2), ((CharSequence)v3), ((CharSequence)v4), arg5, ((CharSequence)v6));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public static String joinToString$default(LongSet arg20, CharSequence arg21, CharSequence arg22, CharSequence arg23, int arg24, CharSequence arg25, Function1 arg26, int arg27, Object arg28) {
        int v21;
        CharSequence v6_1;
        CharSequence v4_1;
        CharSequence v3_1;
        String v2;
        LongSet v0 = arg20;
        Function1 v1 = arg26;
        if(arg28 == null) {
            if((arg27 & 1) != 0) {
                v2 = ", ";
            }
            else {
                CharSequence v2_1 = arg21;
            }

            String v4 = "";
            if((arg27 & 2) != 0) {
                String v3 = v4;
            }
            else {
                v3_1 = arg22;
            }

            if((arg27 & 4) != 0) {
            }
            else {
                v4_1 = arg23;
            }

            int v5 = (arg27 & 8) != 0 ? -1 : arg24;
            if((arg27 & 16) != 0) {
                String v6 = "...";
            }
            else {
                v6_1 = arg25;
            }

            Intrinsics.checkNotNullParameter(v2, "separator");
            Intrinsics.checkNotNullParameter(v3_1, "prefix");
            Intrinsics.checkNotNullParameter(v4_1, "postfix");
            Intrinsics.checkNotNullParameter(v6_1, "truncated");
            Intrinsics.checkNotNullParameter(v1, "transform");
            StringBuilder v7 = new StringBuilder();
            v7.append(v3_1);
            long[] v3_2 = v0.elements;
            long[] v0_1 = v0.metadata;
            int v8 = v0_1.length - 2;
            if(v8 >= 0) {
                int v10 = 0;
                int v11 = 0;
                while(true) {
                    long v12 = v0_1[v10];
                    if((~v12 << 7 & v12 & -9187201950435737472L) != -9187201950435737472L) {
                        int v15 = 8;
                        int v14 = 8 - (~(v10 - v8) >>> 0x1F);
                        int v9 = 0;
                        while(v9 < v14) {
                            if((v12 & 0xFF) < 0x80) {
                                long v16 = v3_2[(v10 << 3) + v9];
                                if(v11 == v5) {
                                    v7.append(v6_1);
                                    goto label_92;
                                }
                                else {
                                    if(v11 != 0) {
                                        v7.append(((CharSequence)v2));
                                    }

                                    v21 = v15;
                                    v7.append(v1.invoke(Long.valueOf(v16)));
                                    ++v11;
                                }
                            }
                            else {
                                v21 = v15;
                            }

                            v12 >>= v21;
                            ++v9;
                            v15 = v21;
                        }

                        if(v14 != v15) {
                            goto label_91;
                        }
                    }

                    if(v10 == v8) {
                        goto label_91;
                    }

                    ++v10;
                }
            }
            else {
            label_91:
                v7.append(v4_1);
            }

        label_92:
            String v0_2 = v7.toString();
            Intrinsics.checkNotNullExpressionValue(v0_2, "toString(...)");
            return v0_2;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean none() {
        if(this._size == 0) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return LongSet.joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }
}

