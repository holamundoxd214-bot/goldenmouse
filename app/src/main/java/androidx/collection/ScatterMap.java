package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J&\u0010\u0016\u001A\u00020\u00172\u0018\u0010\u0018\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000J\u0006\u0010\u001A\u001A\u00020\u0017J&\u0010\u001A\u001A\u00020\u00172\u0018\u0010\u0018\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000J\r\u0010\u001B\u001A\u00020\u001CH\u0000¢\u0006\u0002\b\u001DJ\u0012\u0010\u001E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001FJ\u0016\u0010 \u001A\u00020\u00172\u0006\u0010!\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\"J\u0013\u0010#\u001A\u00020\u00172\u0006\u0010!\u001A\u00028\u0000¢\u0006\u0002\u0010\"J\u0013\u0010$\u001A\u00020\u00172\u0006\u0010%\u001A\u00028\u0001¢\u0006\u0002\u0010\"J\u0006\u0010&\u001A\u00020\u0006J&\u0010&\u001A\u00020\u00062\u0018\u0010\u0018\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000J\u0013\u0010\'\u001A\u00020\u00172\b\u0010(\u001A\u0004\u0018\u00010\u0003H\u0096\u0002J\u0018\u0010)\u001A\u00020\u00062\u0006\u0010!\u001A\u00028\u0000H\u0080\b¢\u0006\u0004\b*\u0010+JD\u0010,\u001A\u00020-26\u0010.\u001A2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(!\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020-0\u0019H\u0086\bø\u0001\u0000J/\u00101\u001A\u00020-2!\u0010.\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020-02H\u0081\bø\u0001\u0000J/\u00104\u001A\u00020-2!\u0010.\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020-02H\u0086\bø\u0001\u0000J/\u00105\u001A\u00020-2!\u0010.\u001A\u001D\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020-02H\u0086\bø\u0001\u0000J\u0018\u00106\u001A\u0004\u0018\u00018\u00012\u0006\u0010!\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00107J\u001B\u00108\u001A\u00028\u00012\u0006\u0010!\u001A\u00028\u00002\u0006\u00109\u001A\u00028\u0001¢\u0006\u0002\u0010:J\'\u0010;\u001A\u00028\u00012\u0006\u0010!\u001A\u00028\u00002\f\u00109\u001A\b\u0012\u0004\u0012\u00028\u00010<H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010=J\b\u0010>\u001A\u00020\u0006H\u0016J\u0006\u0010?\u001A\u00020\u0017J\u0006\u0010@\u001A\u00020\u0017Jv\u0010A\u001A\u00020\u001C2\b\b\u0002\u0010B\u001A\u00020C2\b\b\u0002\u0010D\u001A\u00020C2\b\b\u0002\u0010E\u001A\u00020C2\b\b\u0002\u0010F\u001A\u00020\u00062\b\b\u0002\u0010G\u001A\u00020C2:\b\u0002\u0010H\u001A4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(!\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020C\u0018\u00010\u0019H\u0007J\u0006\u0010I\u001A\u00020\u0017J\b\u0010J\u001A\u00020\u001CH\u0016R\u0012\u0010\u0005\u001A\u00020\u00068\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001A\u00020\u00068\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\"\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f8\u0000@\u0000X\u0081\u000E¢\u0006\n\n\u0002\u0010\u000E\u0012\u0004\b\r\u0010\u0004R\u0018\u0010\u000F\u001A\u00020\u00108\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0004R\u0011\u0010\u0012\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\nR\"\u0010\u0014\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f8\u0000@\u0000X\u0081\u000E¢\u0006\n\n\u0002\u0010\u000E\u0012\u0004\b\u0015\u0010\u0004\u0082\u0001\u0001K\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006L"}, d2={"Landroidx/collection/ScatterMap;", "K", "V", "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "getValues$annotations", "all", "", "predicate", "Lkotlin/Function2;", "any", "asDebugString", "", "asDebugString$collection", "asMap", "", "contains", "key", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "findKeyIndex$collection", "(Ljava/lang/Object;)I", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableScatterMap;", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public abstract class ScatterMap {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public Object[] values;

    private ScatterMap() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public ScatterMap(DefaultConstructorMarker arg1) {
        this();
    }

    public final boolean all(Function2 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "predicate");
        Object[] v0 = this.keys;
        Object[] v1 = this.values;
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
                            if(!arg15.invoke(v0[v10], v1[v10]).booleanValue()) {
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
        Object[] v0 = this.keys;
        Object[] v1 = this.values;
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
                            if(arg15.invoke(v0[v10], v1[v10]).booleanValue()) {
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

    public final String asDebugString$collection() {
        String v4;
        StringBuilder v0 = new StringBuilder("{metadata=[");
        int v1 = this.getCapacity();
        int v2 = 0;
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = ", ";
            if(v3 >= v1) {
                break;
            }

            long v5 = this.metadata[v3 >> 3] >> ((v3 & 7) << 3) & 0xFF;
            if(v5 == 0x80) {
                v0.append("Empty");
            }
            else if(v5 == 0xFE) {
                v0.append("Deleted");
            }
            else {
                v0.append(v5);
            }

            v0.append(v4);
        }

        v0.append("], keys=[");
        v1 = this.keys.length;
        for(v3 = 0; v3 < v1; ++v3) {
            v0.append(this.keys[v3]);
            v0.append(v4);
        }

        v0.append("], values=[");
        v1 = this.values.length;
        while(v2 < v1) {
            v0.append(this.values[v2]);
            v0.append(v4);
            ++v2;
        }

        v0.append("]}");
        String v9 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v9, "toString(...)");
        return v9;
    }

    public final Map asMap() {
        return new MapWrapper(this);
    }

    public final boolean contains(Object arg18) {
        int v11;
        ScatterMap v0 = this;
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
                    if(Intrinsics.areEqual(v0.keys[v11], v1)) {
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

    public final boolean containsKey(Object arg18) {
        int v11;
        ScatterMap v0 = this;
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
                    if(Intrinsics.areEqual(v0.keys[v11], v1)) {
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

    public final boolean containsValue(Object arg14) {
        Object[] v0 = this.values;
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
                        if((0xFF & v4) < 0x80 && (Intrinsics.areEqual(arg14, v0[(v3 << 3) + v8]))) {
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
        Object[] v2 = this.keys;
        Object[] v3 = this.values;
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
                            if(v1.invoke(v2[v13], v3[v13]).booleanValue()) {
                                ++v7;
                            }
                        }

                        v8 >>= v11;
                    }

                    if(v10 == v11) {
                        goto label_46;
                    }

                    return v7;
                }

            label_46:
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
        ScatterMap v0 = this;
        Object v1 = arg18;
        if((((ScatterMap)v1)) == v0) {
            return 1;
        }

        if(!(v1 instanceof ScatterMap)) {
            return 0;
        }

        if(((ScatterMap)v1).getSize() != v0.getSize()) {
            return 0;
        }

        Object[] v3 = v0.keys;
        Object[] v5 = v0.values;
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
                            Object v14 = v3[v13];
                            Object v13_1 = v5[v13];
                            if(v13_1 == null) {
                                if(((ScatterMap)v1).get(v14) == null && (((ScatterMap)v1).containsKey(v14))) {
                                    goto label_53;
                                }

                                return 0;
                            }
                            else {
                                if(Intrinsics.areEqual(v13_1, ((ScatterMap)v1).get(v14))) {
                                    goto label_53;
                                }

                                return 0;
                            }
                        }

                    label_53:
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

    public final int findKeyIndex$collection(Object arg14) {
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
                if(Intrinsics.areEqual(this.keys[v10_1], arg14)) {
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

    public final void forEach(Function2 arg15) {
        Intrinsics.checkNotNullParameter(arg15, "block");
        Object[] v0 = this.keys;
        Object[] v1 = this.values;
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
                            arg15.invoke(v0[v10], v1[v10]);
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
        Object[] v0 = this.keys;
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

    public final void forEachValue(Function1 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "block");
        Object[] v0 = this.values;
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

    public final Object get(Object arg14) {
        int v10_1;
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
            v6_1 = ~v6_1 & v6_1 - 0x101010101010101L & v8;
            while(true) {
                long v10 = 0;
                if(v6_1 != v10) {
                    v10_1 = (Long.numberOfTrailingZeros(v6_1) >> 3) + v1 & v3;
                    if(Intrinsics.areEqual(this.keys[v10_1], arg14)) {
                    }
                    else {
                        v6_1 &= v6_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_60;
            }

            if((v4 & ~v4 << 6 & v8) != v10) {
                v10_1 = -1;
            }
            else {
                goto label_66;
            }

        label_60:
            if(v10_1 >= 0) {
                return this.values[v10_1];
            }

            return null;
        label_66:
            v0 += 8;
            v1 += v0;
        }
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public static void getKeys$annotations() {
    }

    public static void getMetadata$annotations() {
    }

    public final Object getOrDefault(Object arg14, Object arg15) {
        int v10_1;
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
            v6_1 = ~v6_1 & v6_1 - 0x101010101010101L & v8;
            while(true) {
                long v10 = 0;
                if(v6_1 != v10) {
                    v10_1 = (Long.numberOfTrailingZeros(v6_1) >> 3) + v1 & v3;
                    if(Intrinsics.areEqual(this.keys[v10_1], arg14)) {
                    }
                    else {
                        v6_1 &= v6_1 - 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_60;
            }

            if((v4 & ~v4 << 6 & v8) != v10) {
                v10_1 = -1;
            }
            else {
                goto label_65;
            }

        label_60:
            if(v10_1 >= 0) {
                return this.values[v10_1];
            }

            return arg15;
        label_65:
            v0 += 8;
            v1 += v0;
        }
    }

    public final Object getOrElse(Object arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        Object v1 = this.get(arg2);
        if(v1 == null) {
            v1 = arg3.invoke();
        }

        return v1;
    }

    public final int getSize() {
        return this._size;
    }

    public static void getValues$annotations() {
    }

    public int hashCode() {
        Object[] v0 = this.keys;
        Object[] v1 = this.values;
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
                            Object v12 = v0[v11];
                            Object v11_1 = v1[v11];
                            int v12_1 = v12 != null ? v12.hashCode() : 0;
                            v11 = v11_1 != null ? v11_1.hashCode() : 0;
                            v5 += v11 ^ v12_1;
                        }

                        v6 >>= v9;
                    }

                    if(v8 == v9) {
                        goto label_48;
                    }

                    return v5;
                }

            label_48:
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

    public final String joinToString(CharSequence arg21, CharSequence arg22, CharSequence arg23, int arg24, CharSequence arg25, Function2 arg26) {
        Object[] v16_1;
        long[] v17;
        int v22;
        CharSequence v1 = arg21;
        CharSequence v3 = arg23;
        CharSequence v4 = arg25;
        Function2 v5 = arg26;
        Intrinsics.checkNotNullParameter(v1, "separator");
        Intrinsics.checkNotNullParameter(arg22, "prefix");
        Intrinsics.checkNotNullParameter(v3, "postfix");
        Intrinsics.checkNotNullParameter(v4, "truncated");
        StringBuilder v6 = new StringBuilder();
        v6.append(arg22);
        Object[] v2 = this.keys;
        Object[] v7 = this.values;
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
                            v22 = v15;
                            Object v15_1 = v2[v16];
                            v17 = v0;
                            Object v0_1 = v7[v16];
                            v16_1 = v2;
                            if(v11 == arg24) {
                                v6.append(v4);
                                goto label_92;
                            }
                            else {
                                if(v11 != 0) {
                                    v6.append(v1);
                                }

                                if(v5 == null) {
                                    v6.append(v15_1);
                                    v6.append('=');
                                    v6.append(v0_1);
                                }
                                else {
                                    v6.append(v5.invoke(v15_1, v0_1));
                                }

                                ++v11;
                            }
                        }
                        else {
                            v17 = v0;
                            v16_1 = v2;
                            v22 = v15;
                        }

                        v12 >>= v22;
                        ++v9;
                        v15 = v22;
                        v2 = v16_1;
                        v0 = v17;
                    }

                    v17 = v0;
                    v16_1 = v2;
                    if(v14 != v15) {
                        goto label_91;
                    }
                }
                else {
                    v17 = v0;
                    v16_1 = v2;
                }

                if(v10 == v8) {
                    goto label_91;
                }

                ++v10;
                v2 = v16_1;
                v0 = v17;
            }
        }
        else {
        label_91:
            v6.append(v3);
        }

    label_92:
        String v0_2 = v6.toString();
        Intrinsics.checkNotNullExpressionValue(v0_2, "toString(...)");
        return v0_2;
    }

    public final String joinToString() {
        return ScatterMap.joinToString$default(this, null, null, null, 0, null, null, 0x3F, null);
    }

    public final String joinToString(CharSequence arg11) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        return ScatterMap.joinToString$default(this, arg11, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        return ScatterMap.joinToString$default(this, arg11, arg12, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12, CharSequence arg13) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        Intrinsics.checkNotNullParameter(arg13, "postfix");
        return ScatterMap.joinToString$default(this, arg11, arg12, arg13, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12, CharSequence arg13, int arg14) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        Intrinsics.checkNotNullParameter(arg13, "postfix");
        return ScatterMap.joinToString$default(this, arg11, arg12, arg13, arg14, null, null, 0x30, null);
    }

    public final String joinToString(CharSequence arg11, CharSequence arg12, CharSequence arg13, int arg14, CharSequence arg15) {
        Intrinsics.checkNotNullParameter(arg11, "separator");
        Intrinsics.checkNotNullParameter(arg12, "prefix");
        Intrinsics.checkNotNullParameter(arg13, "postfix");
        Intrinsics.checkNotNullParameter(arg15, "truncated");
        return ScatterMap.joinToString$default(this, arg11, arg12, arg13, arg14, arg15, null, 0x20, null);
    }

    public static String joinToString$default(ScatterMap arg1, CharSequence arg2, CharSequence arg3, CharSequence arg4, int arg5, CharSequence arg6, Function2 arg7, int arg8, Object arg9) {
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

    public final boolean none() {
        if(this._size == 0) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        String v15_1;
        ScatterMap v0 = this;
        if(v0.isEmpty()) {
            return "{}";
        }

        StringBuilder v1 = new StringBuilder("{");
        Object[] v2 = v0.keys;
        Object[] v3 = v0.values;
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
                            Object v15 = v2[v14];
                            Object v14_1 = v3[v14];
                            String v16 = "(this)";
                            if((((ScatterMap)v15)) == v0) {
                                v15_1 = v16;
                            }

                            v1.append(v15_1);
                            v1.append("=");
                            if((((ScatterMap)v14_1)) == v0) {
                                String v14_2 = v16;
                            }

                            v1.append(v14_1);
                            ++v8;
                            if(v8 >= v0._size) {
                                goto label_54;
                            }

                            v1.append(", ");
                        }

                    label_54:
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

