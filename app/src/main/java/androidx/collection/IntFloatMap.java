package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J&\u0010\u0016\u001A\u00020\u00172\u0018\u0010\u0018\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000J\u0006\u0010\u001B\u001A\u00020\u0017J&\u0010\u001B\u001A\u00020\u00172\u0018\u0010\u0018\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000J\u0011\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u001D\u001A\u00020\u0004H\u0086\nJ\u000E\u0010\u001E\u001A\u00020\u00172\u0006\u0010\u001D\u001A\u00020\u0004J\u000E\u0010\u001F\u001A\u00020\u00172\u0006\u0010 \u001A\u00020\u001AJ\u0006\u0010!\u001A\u00020\u0004J&\u0010!\u001A\u00020\u00042\u0018\u0010\u0018\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000J\u0013\u0010\"\u001A\u00020\u00172\b\u0010#\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010$\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u0004H\u0001JD\u0010%\u001A\u00020&26\u0010\'\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001D\u0012\u0013\u0012\u00110\u001A¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0004\u0012\u00020&0\u0019H\u0086\bø\u0001\u0000J/\u0010*\u001A\u00020&2!\u0010\'\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020&0+H\u0081\bø\u0001\u0000J/\u0010-\u001A\u00020&2!\u0010\'\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001D\u0012\u0004\u0012\u00020&0+H\u0086\bø\u0001\u0000J/\u0010.\u001A\u00020&2!\u0010\'\u001A\u001D\u0012\u0013\u0012\u00110\u001A¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0004\u0012\u00020&0+H\u0086\bø\u0001\u0000J\u0011\u0010/\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u0004H\u0086\u0002J\u0016\u00100\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u00101\u001A\u00020\u001AJ\"\u00102\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u00042\f\u00101\u001A\b\u0012\u0004\u0012\u00020\u001A03H\u0086\bø\u0001\u0000J\b\u00104\u001A\u00020\u0004H\u0016J\u0006\u00105\u001A\u00020\u0017J\u0006\u00106\u001A\u00020\u0017J:\u00107\u001A\u0002082\b\b\u0002\u00109\u001A\u00020:2\b\b\u0002\u0010;\u001A\u00020:2\b\b\u0002\u0010<\u001A\u00020:2\b\b\u0002\u0010=\u001A\u00020\u00042\b\b\u0002\u0010>\u001A\u00020:H\u0007Jx\u00107\u001A\u0002082\b\b\u0002\u00109\u001A\u00020:2\b\b\u0002\u0010;\u001A\u00020:2\b\b\u0002\u0010<\u001A\u00020:2\b\b\u0002\u0010=\u001A\u00020\u00042\b\b\u0002\u0010>\u001A\u00020:28\b\u0004\u0010?\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001D\u0012\u0013\u0012\u00110\u001A¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0004\u0012\u00020:0\u0019H\u0087\bø\u0001\u0000J\u0006\u0010@\u001A\u00020\u0017J\b\u0010A\u001A\u000208H\u0016R\u0018\u0010\u0003\u001A\u00020\u00048\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0018\u0010\u0006\u001A\u00020\u00048\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0011\u0010\b\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0018\u0010\u000B\u001A\u00020\f8\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0018\u0010\u000E\u001A\u00020\u000F8\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0002R\u0011\u0010\u0011\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\nR\u0018\u0010\u0013\u001A\u00020\u00148\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u0082\u0001\u0001B\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006C"}, d2={"Landroidx/collection/IntFloatMap;", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "all", "", "predicate", "Lkotlin/Function2;", "", "any", "contains", "key", "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableIntFloatMap;", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public abstract class IntFloatMap {
    public int _capacity;
    public int _size;
    public int[] keys;
    public long[] metadata;
    public float[] values;

    private IntFloatMap() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = FloatSetKt.getEmptyFloatArray();
    }

    public IntFloatMap(DefaultConstructorMarker arg1) {
        this();
    }

    public final boolean all(Function2 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "predicate");
        int[] v0 = this.keys;
        float[] v1 = this.values;
        long[] v14 = this.metadata;
        int v2 = v14.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v14[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            if(!arg15.invoke(Integer.valueOf(v0[v10]), Float.valueOf(v1[v10])).booleanValue()) {
                                return 0;
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return 1;
                    }
                }

                if(v4 == v2) {
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

    public final boolean any(Function2 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "predicate");
        int[] v0 = this.keys;
        float[] v1 = this.values;
        long[] v14 = this.metadata;
        int v2 = v14.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v14[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            if(arg15.invoke(Integer.valueOf(v0[v10]), Float.valueOf(v1[v10])).booleanValue()) {
                                return 1;
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return 0;
                    }
                }

                if(v4 == v2) {
                    return 0;
                }
            }
        }

        return 0;
    }

    public final boolean contains(int arg1) {
        return this.containsKey(arg1);
    }

    public final boolean containsKey(int arg1) {
        if(this.findKeyIndex(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    public final boolean containsValue(float arg14) {
        float[] v0 = this.values;
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
                        if((0xFF & v4) < 0x80 && arg14 == v0[(v3 << 3) + v8]) {
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

    public final int count() {
        return this.getSize();
    }

    public final int count(Function2 arg18) {
        Function2 v1 = arg18;
        Intrinsics.checkNotNullParameter(v1, "predicate");
        int[] v2 = this.keys;
        float[] v3 = this.values;
        long[] v0 = this.metadata;
        int v4 = v0.length - 2;
        if(v4 >= 0) {
            int v6 = 0;
            int v7 = 0;
            while(true) {
                long v8 = v0[v6];
                if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                    int v11 = 8;
                    int v10 = 8 - (~(v6 - v4) >>> 0x1F);
                    int v12;
                    for(v12 = 0; v12 < v10; ++v12) {
                        if((0xFF & v8) < 0x80) {
                            int v13 = (v6 << 3) + v12;
                            if(v1.invoke(Integer.valueOf(v2[v13]), Float.valueOf(v3[v13])).booleanValue()) {
                                ++v7;
                            }
                        }

                        v8 >>= v11;
                    }

                    if(v10 == v11) {
                        goto label_48;
                    }

                    return v7;
                }

            label_48:
                if(v6 == v4) {
                    return v7;
                }

                ++v6;
            }

            return v7;
        }

        return 0;
    }

    public boolean equals(Object arg18) {
        IntFloatMap v0 = this;
        Object v1 = arg18;
        if((((IntFloatMap)v1)) == v0) {
            return 1;
        }

        if(!(v1 instanceof IntFloatMap)) {
            return 0;
        }

        if(((IntFloatMap)v1).getSize() != v0.getSize()) {
            return 0;
        }

        int[] v3 = v0.keys;
        float[] v5 = v0.values;
        long[] v0_1 = v0.metadata;
        int v6 = v0_1.length - 2;
        if(v6 >= 0) {
            int v7;
            for(v7 = 0; true; ++v7) {
                long v8 = v0_1[v7];
                if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                    int v11 = 8;
                    int v10 = 8 - (~(v7 - v6) >>> 0x1F);
                    int v12;
                    for(v12 = 0; v12 < v10; ++v12) {
                        if((0xFF & v8) < 0x80) {
                            int v13 = (v7 << 3) + v12;
                            int v14 = v3[v13];
                            float v13_1 = v5[v13];
                            v14 = ((IntFloatMap)v1).findKeyIndex(v14);
                            if(v14 >= 0 && v13_1 == ((IntFloatMap)v1).values[v14]) {
                                goto label_50;
                            }

                            return 0;
                        }

                    label_50:
                        v8 >>= v11;
                    }

                    if(v10 != v11) {
                        return 1;
                    }
                }

                if(v7 == v6) {
                    return 1;
                }
            }
        }

        return 1;
    }

    public final int findKeyIndex(int arg14) {
        int v0 = Integer.hashCode(arg14) * 0xCC9E2D51;
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
                if(this.keys[v10_1] == arg14) {
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

    public final void forEach(Function2 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "block");
        int[] v0 = this.keys;
        float[] v1 = this.values;
        long[] v14 = this.metadata;
        int v2 = v14.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v14[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            arg15.invoke(Integer.valueOf(v0[v10]), Float.valueOf(v1[v10]));
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

    public final void forEachIndexed(Function1 arg13) {
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

    public final void forEachKey(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "block");
        int[] v0 = this.keys;
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
                            arg14.invoke(Integer.valueOf(v0[(v3 << 3) + v8]));
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

    public final void forEachValue(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "block");
        float[] v0 = this.values;
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
                            arg14.invoke(Float.valueOf(v0[(v3 << 3) + v8]));
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

    public final float get(int arg4) {
        int v0 = this.findKeyIndex(arg4);
        if(v0 < 0) {
            RuntimeHelpersKt.throwNoSuchElementException("Cannot find value for key " + arg4);
        }

        return this.values[v0];
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public static void getKeys$annotations() {
    }

    public static void getMetadata$annotations() {
    }

    public final float getOrDefault(int arg1, float arg2) {
        arg1 = this.findKeyIndex(arg1);
        if(arg1 >= 0) {
            return this.values[arg1];
        }

        return arg2;
    }

    public final float getOrElse(int arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        arg2 = this.findKeyIndex(arg2);
        if(arg2 < 0) {
            return arg3.invoke().floatValue();
        }

        return this.values[arg2];
    }

    public final int getSize() {
        return this._size;
    }

    public static void getValues$annotations() {
    }

    public static void get_capacity$collection$annotations() {
    }

    public static void get_size$collection$annotations() {
    }

    public int hashCode() {
        int[] v0 = this.keys;
        float[] v1 = this.values;
        long[] v15 = this.metadata;
        int v2 = v15.length - 2;
        if(v2 >= 0) {
            int v4 = 0;
            int v5 = 0;
            while(true) {
                long v6 = v15[v4];
                if((~v6 << 7 & v6 & -9187201950435737472L) != -9187201950435737472L) {
                    int v9 = 8;
                    int v8 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v10;
                    for(v10 = 0; v10 < v8; ++v10) {
                        if((0xFF & v6) < 0x80) {
                            int v11 = (v4 << 3) + v10;
                            v5 += Float.hashCode(v1[v11]) ^ Integer.hashCode(v0[v11]);
                        }

                        v6 >>= v9;
                    }

                    if(v8 == v9) {
                        goto label_42;
                    }

                    return v5;
                }

            label_42:
                if(v4 == v2) {
                    return v5;
                }

                ++v4;
            }

            return v5;
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

    public final String joinToString(CharSequence arg21, CharSequence arg22, CharSequence arg23, int arg24, CharSequence arg25) {
        long[] v16_1;
        int v22;
        CharSequence v1 = arg21;
        CharSequence v3 = arg23;
        CharSequence v4 = arg25;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg22, "prefix");
        Intrinsics.checkNotNullParameter(v3, "postfix");
        Intrinsics.checkNotNullParameter(v4, "truncated");
        StringBuilder v5 = new StringBuilder();
        v5.append(arg22);
        int[] v2 = this.keys;
        float[] v6 = this.values;
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
                            int v16 = (v9 << 3) + v15;
                            int v8 = v2[v16];
                            v22 = v14;
                            float v14_1 = v6[v16];
                            v16_1 = v0;
                            if(v10 == arg24) {
                                v5.append(v4);
                                goto label_81;
                            }
                            else {
                                if(v10 != 0) {
                                    v5.append(v1);
                                }

                                v5.append(v8);
                                v5.append('=');
                                v5.append(v14_1);
                                ++v10;
                            }
                        }
                        else {
                            v16_1 = v0;
                            v22 = v14;
                        }

                        v11 >>= v22;
                        ++v15;
                        v14 = v22;
                        v0 = v16_1;
                    }

                    v16_1 = v0;
                    if(v13 != v14) {
                        goto label_80;
                    }
                }
                else {
                    v16_1 = v0;
                }

                if(v9 == v7) {
                    goto label_80;
                }

                ++v9;
                v0 = v16_1;
            }
        }
        else {
        label_80:
            v5.append(v3);
        }

    label_81:
        String v0_1 = v5.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString() {
        return IntFloatMap.joinToString$default(this, null, null, null, 0, null, 0x1F, null);
    }

    public final String joinToString(CharSequence arg10) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        return IntFloatMap.joinToString$default(this, arg10, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence arg10, CharSequence arg11) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        Intrinsics.checkNotNullParameter(arg11, "prefix");
        return IntFloatMap.joinToString$default(this, arg10, arg11, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence arg10, CharSequence arg11, CharSequence arg12) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        Intrinsics.checkNotNullParameter(arg11, "prefix");
        Intrinsics.checkNotNullParameter(arg12, "postfix");
        return IntFloatMap.joinToString$default(this, arg10, arg11, arg12, 0, null, 24, null);
    }

    public final String joinToString(CharSequence arg10, CharSequence arg11, CharSequence arg12, int arg13) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        Intrinsics.checkNotNullParameter(arg11, "prefix");
        Intrinsics.checkNotNullParameter(arg12, "postfix");
        return IntFloatMap.joinToString$default(this, arg10, arg11, arg12, arg13, null, 16, null);
    }

    public final String joinToString(CharSequence arg21, CharSequence arg22, CharSequence arg23, int arg24, CharSequence arg25, Function2 arg26) {
        long[] v18;
        int v22;
        CharSequence v1 = arg21;
        CharSequence v3 = arg23;
        CharSequence v4 = arg25;
        Function2 v5 = arg26;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg22, "prefix");
        Intrinsics.checkNotNullParameter(v3, "postfix");
        Intrinsics.checkNotNullParameter(v4, "truncated");
        Intrinsics.checkNotNullParameter(v5, "transform");
        StringBuilder v6 = new StringBuilder();
        v6.append(arg22);
        int[] v2 = this.keys;
        float[] v7 = this.values;
        long[] v0 = this.metadata;
        int v8 = v0.length - 2;
        if(v8 >= 0) {
            int v10 = 0;
            int v11 = 0;
            while(true) {
                long v12 = v0[v10];
                if((~v12 << 7 & v12 & -9187201950435737472L) != -9187201950435737472L) {
                    int v15 = 8;
                    int v14 = 8 - (~(v10 - v8) >>> 0x1F);
                    int v9 = 0;
                    while(v9 < v14) {
                        if((v12 & 0xFF) < 0x80) {
                            int v16 = (v10 << 3) + v9;
                            int v17 = v2[v16];
                            float v16_1 = v7[v16];
                            v22 = v15;
                            if(v11 == arg24) {
                                v6.append(v4);
                                goto label_86;
                            }
                            else {
                                if(v11 != 0) {
                                    v6.append(v1);
                                }

                                v18 = v0;
                                v6.append(v5.invoke(Integer.valueOf(v17), Float.valueOf(v16_1)));
                                ++v11;
                            }
                        }
                        else {
                            v18 = v0;
                            v22 = v15;
                        }

                        v12 >>= v22;
                        ++v9;
                        v1 = arg21;
                        v15 = v22;
                        v0 = v18;
                    }

                    v18 = v0;
                    if(v14 != v15) {
                        goto label_85;
                    }
                }
                else {
                    v18 = v0;
                }

                if(v10 == v8) {
                    goto label_85;
                }

                ++v10;
                v1 = arg21;
                v0 = v18;
            }
        }
        else {
        label_85:
            v6.append(v3);
        }

    label_86:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString(CharSequence arg21, CharSequence arg22, CharSequence arg23, int arg24, Function2 arg25) {
        long[] v18;
        int v22;
        CharSequence v1 = arg21;
        CharSequence v3 = arg23;
        Function2 v4 = arg25;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg22, "prefix");
        Intrinsics.checkNotNullParameter(v3, "postfix");
        Intrinsics.checkNotNullParameter(v4, "transform");
        String v5 = "...";
        StringBuilder v6 = new StringBuilder();
        v6.append(arg22);
        int[] v2 = this.keys;
        float[] v7 = this.values;
        long[] v0 = this.metadata;
        int v8 = v0.length - 2;
        if(v8 >= 0) {
            int v10 = 0;
            int v11 = 0;
            while(true) {
                long v12 = v0[v10];
                if((~v12 << 7 & v12 & -9187201950435737472L) != -9187201950435737472L) {
                    int v15 = 8;
                    int v14 = 8 - (~(v10 - v8) >>> 0x1F);
                    int v9 = 0;
                    while(v9 < v14) {
                        if((v12 & 0xFF) < 0x80) {
                            int v16 = (v10 << 3) + v9;
                            int v17 = v2[v16];
                            float v16_1 = v7[v16];
                            v22 = v15;
                            if(v11 == arg24) {
                                v6.append(((CharSequence)v5));
                                goto label_84;
                            }
                            else {
                                if(v11 != 0) {
                                    v6.append(v1);
                                }

                                v18 = v0;
                                v6.append(v4.invoke(Integer.valueOf(v17), Float.valueOf(v16_1)));
                                ++v11;
                            }
                        }
                        else {
                            v18 = v0;
                            v22 = v15;
                        }

                        v12 >>= v22;
                        ++v9;
                        v1 = arg21;
                        v15 = v22;
                        v0 = v18;
                    }

                    v18 = v0;
                    if(v14 != v15) {
                        goto label_83;
                    }
                }
                else {
                    v18 = v0;
                }

                if(v10 == v8) {
                    goto label_83;
                }

                ++v10;
                v1 = arg21;
                v0 = v18;
            }
        }
        else {
        label_83:
            v6.append(v3);
        }

    label_84:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString(CharSequence arg21, CharSequence arg22, CharSequence arg23, Function2 arg24) {
        long[] v17_1;
        int v22;
        CharSequence v1 = arg21;
        CharSequence v3 = arg23;
        Function2 v4 = arg24;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg22, "prefix");
        Intrinsics.checkNotNullParameter(v3, "postfix");
        Intrinsics.checkNotNullParameter(v4, "transform");
        String v5 = "...";
        StringBuilder v6 = new StringBuilder();
        v6.append(arg22);
        int[] v2 = this.keys;
        float[] v7 = this.values;
        long[] v0 = this.metadata;
        int v8 = v0.length - 2;
        if(v8 >= 0) {
            int v10 = 0;
            int v11 = 0;
            while(true) {
                long v12 = v0[v10];
                if((~v12 << 7 & v12 & -9187201950435737472L) != -9187201950435737472L) {
                    int v15 = 8;
                    int v14 = 8 - (~(v10 - v8) >>> 0x1F);
                    int v9 = 0;
                    while(v9 < v14) {
                        if((v12 & 0xFF) < 0x80) {
                            int v16 = (v10 << 3) + v9;
                            int v17 = v2[v16];
                            float v16_1 = v7[v16];
                            v22 = v15;
                            if(v11 == -1) {
                                v6.append(((CharSequence)v5));
                                goto label_79;
                            }
                            else {
                                if(v11 != 0) {
                                    v6.append(v1);
                                }

                                Integer v15_1 = Integer.valueOf(v17);
                                v17_1 = v0;
                                v6.append(v4.invoke(v15_1, Float.valueOf(v16_1)));
                                ++v11;
                            }
                        }
                        else {
                            v17_1 = v0;
                            v22 = v15;
                        }

                        v12 >>= v22;
                        ++v9;
                        v15 = v22;
                        v0 = v17_1;
                    }

                    v17_1 = v0;
                    if(v14 != v15) {
                        goto label_78;
                    }
                }
                else {
                    v17_1 = v0;
                }

                if(v10 == v8) {
                    goto label_78;
                }

                ++v10;
                v0 = v17_1;
            }
        }
        else {
        label_78:
            v6.append(v3);
        }

    label_79:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString(CharSequence arg21, CharSequence arg22, Function2 arg23) {
        long[] v17_1;
        int v22;
        CharSequence v1 = arg21;
        Function2 v3 = arg23;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg22, "prefix");
        Intrinsics.checkNotNullParameter(v3, "transform");
        String v4 = "";
        String v5 = "...";
        StringBuilder v6 = new StringBuilder();
        v6.append(arg22);
        int[] v2 = this.keys;
        float[] v7 = this.values;
        long[] v0 = this.metadata;
        int v8 = v0.length - 2;
        if(v8 >= 0) {
            int v10 = 0;
            int v11 = 0;
            while(true) {
                long v12 = v0[v10];
                if((~v12 << 7 & v12 & -9187201950435737472L) != -9187201950435737472L) {
                    int v15 = 8;
                    int v14 = 8 - (~(v10 - v8) >>> 0x1F);
                    int v9 = 0;
                    while(v9 < v14) {
                        if((v12 & 0xFF) < 0x80) {
                            int v16 = (v10 << 3) + v9;
                            int v17 = v2[v16];
                            float v16_1 = v7[v16];
                            v22 = v15;
                            if(v11 == -1) {
                                v6.append(((CharSequence)v5));
                                goto label_77;
                            }
                            else {
                                if(v11 != 0) {
                                    v6.append(v1);
                                }

                                Integer v15_1 = Integer.valueOf(v17);
                                v17_1 = v0;
                                v6.append(v3.invoke(v15_1, Float.valueOf(v16_1)));
                                ++v11;
                            }
                        }
                        else {
                            v17_1 = v0;
                            v22 = v15;
                        }

                        v12 >>= v22;
                        ++v9;
                        v15 = v22;
                        v0 = v17_1;
                    }

                    v17_1 = v0;
                    if(v14 != v15) {
                        goto label_76;
                    }
                }
                else {
                    v17_1 = v0;
                }

                if(v10 == v8) {
                    goto label_76;
                }

                ++v10;
                v0 = v17_1;
            }
        }
        else {
        label_76:
            v6.append(((CharSequence)v4));
        }

    label_77:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString(CharSequence arg21, Function2 arg22) {
        long[] v17_1;
        int v18;
        CharSequence v1 = arg21;
        Function2 v2 = arg22;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(v2, "transform");
        String v3 = "";
        String v5 = "...";
        StringBuilder v6 = new StringBuilder();
        v6.append(v3);
        int[] v4 = this.keys;
        float[] v7 = this.values;
        long[] v0 = this.metadata;
        int v8 = v0.length - 2;
        if(v8 >= 0) {
            int v10 = 0;
            int v11 = 0;
            while(true) {
                long v12 = v0[v10];
                if((~v12 << 7 & v12 & -9187201950435737472L) != -9187201950435737472L) {
                    int v15 = 8;
                    int v14 = 8 - (~(v10 - v8) >>> 0x1F);
                    int v9 = 0;
                    while(v9 < v14) {
                        if((v12 & 0xFF) < 0x80) {
                            int v16 = (v10 << 3) + v9;
                            int v17 = v4[v16];
                            float v16_1 = v7[v16];
                            v18 = v15;
                            if(v11 == -1) {
                                v6.append(((CharSequence)v5));
                                goto label_75;
                            }
                            else {
                                if(v11 != 0) {
                                    v6.append(v1);
                                }

                                Integer v15_1 = Integer.valueOf(v17);
                                v17_1 = v0;
                                v6.append(v2.invoke(v15_1, Float.valueOf(v16_1)));
                                ++v11;
                            }
                        }
                        else {
                            v17_1 = v0;
                            v18 = v15;
                        }

                        v12 >>= v18;
                        ++v9;
                        v0 = v17_1;
                        v15 = v18;
                    }

                    v17_1 = v0;
                    if(v14 != v15) {
                        goto label_74;
                    }
                }
                else {
                    v17_1 = v0;
                }

                if(v10 == v8) {
                    goto label_74;
                }

                ++v10;
                v0 = v17_1;
            }
        }
        else {
        label_74:
            v6.append(((CharSequence)v3));
        }

    label_75:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public final String joinToString(Function2 arg21) {
        long[] v17_1;
        int v18;
        Function2 v1 = arg21;
        Intrinsics.checkNotNullParameter(v1, "transform");
        String v2 = ", ";
        String v3 = "";
        String v5 = "...";
        StringBuilder v6 = new StringBuilder();
        v6.append(v3);
        int[] v4 = this.keys;
        float[] v7 = this.values;
        long[] v0 = this.metadata;
        int v8 = v0.length - 2;
        if(v8 >= 0) {
            int v10 = 0;
            int v11 = 0;
            while(true) {
                long v12 = v0[v10];
                if((~v12 << 7 & v12 & -9187201950435737472L) != -9187201950435737472L) {
                    int v15 = 8;
                    int v14 = 8 - (~(v10 - v8) >>> 0x1F);
                    int v9 = 0;
                    while(v9 < v14) {
                        if((v12 & 0xFF) < 0x80) {
                            int v16 = (v10 << 3) + v9;
                            int v17 = v4[v16];
                            float v16_1 = v7[v16];
                            v18 = v15;
                            if(v11 == -1) {
                                v6.append(((CharSequence)v5));
                                goto label_73;
                            }
                            else {
                                if(v11 != 0) {
                                    v6.append(((CharSequence)v2));
                                }

                                Integer v15_1 = Integer.valueOf(v17);
                                v17_1 = v0;
                                v6.append(v1.invoke(v15_1, Float.valueOf(v16_1)));
                                ++v11;
                            }
                        }
                        else {
                            v17_1 = v0;
                            v18 = v15;
                        }

                        v12 >>= v18;
                        ++v9;
                        v0 = v17_1;
                        v15 = v18;
                    }

                    v17_1 = v0;
                    if(v14 != v15) {
                        goto label_72;
                    }
                }
                else {
                    v17_1 = v0;
                }

                if(v10 == v8) {
                    goto label_72;
                }

                ++v10;
                v0 = v17_1;
            }
        }
        else {
        label_72:
            v6.append(((CharSequence)v3));
        }

    label_73:
        String v0_1 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }

    public static String joinToString$default(IntFloatMap arg1, CharSequence arg2, CharSequence arg3, CharSequence arg4, int arg5, CharSequence arg6, int arg7, Object arg8) {
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

    public static String joinToString$default(IntFloatMap arg20, CharSequence arg21, CharSequence arg22, CharSequence arg23, int arg24, CharSequence arg25, Function2 arg26, int arg27, Object arg28) {
        long[] v17_1;
        int v22;
        int v10;
        String v6;
        String v3;
        CharSequence v2_1;
        IntFloatMap v0 = arg20;
        Function2 v1 = arg26;
        if(arg28 == null) {
            if((arg27 & 1) != 0) {
                String v2 = ", ";
            }
            else {
                v2_1 = arg21;
            }

            String v4 = "";
            if((arg27 & 2) != 0) {
                v3 = v4;
            }
            else {
                CharSequence v3_1 = arg22;
            }

            if((arg27 & 4) != 0) {
            }
            else {
                CharSequence v4_1 = arg23;
            }

            int v5 = (arg27 & 8) != 0 ? -1 : arg24;
            if((arg27 & 16) != 0) {
                v6 = "...";
            }
            else {
                CharSequence v6_1 = arg25;
            }

            Intrinsics.checkNotNullParameter(v2_1, "separator");
            Intrinsics.checkNotNullParameter(v3, "prefix");
            Intrinsics.checkNotNullParameter(v4, "postfix");
            Intrinsics.checkNotNullParameter(v6, "truncated");
            Intrinsics.checkNotNullParameter(v1, "transform");
            StringBuilder v7 = new StringBuilder();
            v7.append(((CharSequence)v3));
            int[] v3_2 = v0.keys;
            float[] v8 = v0.values;
            long[] v0_1 = v0.metadata;
            int v9 = v0_1.length - 2;
            if(v9 >= 0) {
                int v11 = 0;
                int v12 = 0;
                while(true) {
                    long v13 = v0_1[v11];
                    int v21 = v11;
                    if((~v13 << 7 & v13 & -9187201950435737472L) != -9187201950435737472L) {
                        v11 = 8;
                        v10 = 8 - (~(v21 - v9) >>> 0x1F);
                        int v15 = 0;
                        while(v15 < v10) {
                            if((v13 & 0xFF) < 0x80) {
                                int v16 = (v21 << 3) + v15;
                                int v17 = v3_2[v16];
                                float v16_1 = v8[v16];
                                if(v12 == v5) {
                                    v7.append(((CharSequence)v6));
                                    goto label_104;
                                }
                                else {
                                    if(v12 != 0) {
                                        v7.append(v2_1);
                                    }

                                    v22 = v11;
                                    Integer v11_1 = Integer.valueOf(v17);
                                    v17_1 = v0_1;
                                    v7.append(v1.invoke(v11_1, Float.valueOf(v16_1)));
                                    ++v12;
                                }
                            }
                            else {
                                v17_1 = v0_1;
                                v22 = v11;
                            }

                            v13 >>= v22;
                            ++v15;
                            v11 = v22;
                            v0_1 = v17_1;
                        }

                        v17_1 = v0_1;
                        if(v10 != v11) {
                            goto label_103;
                        }
                    }
                    else {
                        v17_1 = v0_1;
                    }

                    v10 = v21;
                    if(v10 == v9) {
                        goto label_103;
                    }

                    v11 = v10 + 1;
                    v0_1 = v17_1;
                }
            }
            else {
            label_103:
                v7.append(((CharSequence)v4));
            }

        label_104:
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
        IntFloatMap v0 = this;
        if(v0.isEmpty()) {
            return "{}";
        }

        StringBuilder v1 = new StringBuilder("{");
        int[] v2 = v0.keys;
        float[] v3 = v0.values;
        long[] v4 = v0.metadata;
        int v5 = v4.length - 2;
        if(v5 >= 0) {
            int v7 = 0;
            int v8 = 0;
            while(true) {
                long v9 = v4[v7];
                if((~v9 << 7 & v9 & -9187201950435737472L) != -9187201950435737472L) {
                    int v12 = 8;
                    int v11 = 8 - (~(v7 - v5) >>> 0x1F);
                    int v13;
                    for(v13 = 0; v13 < v11; ++v13) {
                        if((0xFF & v9) < 0x80) {
                            int v14 = (v7 << 3) + v13;
                            int v15 = v2[v14];
                            float v14_1 = v3[v14];
                            v1.append(v15);
                            v1.append("=");
                            v1.append(v14_1);
                            ++v8;
                            if(v8 < v0._size) {
                                v1.append(", ");
                            }
                        }

                        v9 >>= v12;
                    }

                    if(v11 != v12) {
                        break;
                    }
                }

                if(v7 == v5) {
                    break;
                }

                ++v7;
            }
        }

        String v0_1 = v1.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        return v0_1;
    }
}

