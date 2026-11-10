package androidx.compose.runtime.collection;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u001D\u0012\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00028\u0001¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000E\u001A\u00020\t¢\u0006\u0004\b\u000F\u0010\u0010J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\n\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001E\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00010\u00162\u0006\u0010\n\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\u0012¢\u0006\u0004\b\u001A\u0010\u001BJ\r\u0010\u001C\u001A\u00020\u0012¢\u0006\u0004\b\u001D\u0010\u001BJ\u0017\u0010\u001E\u001A\u0004\u0018\u00018\u00012\u0006\u0010\n\u001A\u00028\u0000¢\u0006\u0004\b\u001F\u0010 J\u0017\u0010!\u001A\u0004\u0018\u00018\u00012\u0006\u0010\n\u001A\u00028\u0000¢\u0006\u0004\b\"\u0010 J\u0013\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00010\u0016¢\u0006\u0004\b$\u0010%J;\u0010&\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u00002!\u0010\'\u001A\u001D\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\t0(H\u0086\b¢\u0006\u0004\b+\u0010,J3\u0010&\u001A\u00020\t2!\u0010\'\u001A\u001D\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\t0(H\u0086\b¢\u0006\u0004\b+\u0010-J8\u0010.\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u00002!\u0010/\u001A\u001D\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0004\b0\u0010,J\u0014\u00101\u001A\u00020\u00122\b\u00102\u001A\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u00103\u001A\u000204HÖ\u0081\u0004J\n\u00105\u001A\u000206HÖ\u0081\u0004R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¨\u00067"}, d2={"Landroidx/compose/runtime/collection/MultiValueMap;", "K", "", "V", "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "add", "", "key", "value", "add-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "clear", "clear-impl", "(Landroidx/collection/MutableScatterMap;)V", "contains", "", "contains-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "get", "Landroidx/collection/ObjectList;", "get-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "isEmpty", "isEmpty-impl", "(Landroidx/collection/MutableScatterMap;)Z", "isNotEmpty", "isNotEmpty-impl", "removeLast", "removeLast-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "removeFirst", "removeFirst-impl", "values", "values-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/ObjectList;", "forEachValue", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachValue-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function1;)V", "removeValueIf", "condition", "removeValueIf-impl", "equals", "other", "hashCode", "", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class MultiValueMap {
    private final MutableScatterMap map;

    private MultiValueMap(MutableScatterMap arg1) {
        super();
        this.map = arg1;
    }

    public static final void add-impl(MutableScatterMap arg4, Object arg5, Object arg6) {
        int v0 = arg4.findInsertIndex(arg5);
        int v1 = v0 < 0 ? 1 : 0;
        Object v2 = v1 != 0 ? null : arg4.values[v0];
        TypeIntrinsics.isMutableList(v2);
        if(v2 == null) {
        }
        else if((v2 instanceof MutableObjectList)) {
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.collection.MutableObjectList<kotlin.Any>");
            ((MutableObjectList)v2).add(arg6);
            arg6 = v2;
        }
        else {
            MutableObjectList v6 = ObjectListKt.mutableObjectListOf(v2, arg6);
        }

        if(v1 != 0) {
            v0 = ~v0;
            arg4.keys[v0] = arg5;
            arg4.values[v0] = arg6;
            return;
        }

        arg4.values[v0] = arg6;
    }

    public static final MultiValueMap box-impl(MutableScatterMap arg1) {
        return new MultiValueMap(arg1);
    }

    public static final void clear-impl(MutableScatterMap arg0) {
        arg0.clear();
    }

    public static MutableScatterMap constructor-impl(MutableScatterMap arg0) {
        return arg0;
    }

    public static MutableScatterMap constructor-impl$default(MutableScatterMap arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new MutableScatterMap(0, 1, null);
        }

        return MultiValueMap.constructor-impl(arg1);
    }

    public static final boolean contains-impl(MutableScatterMap arg0, Object arg1) {
        return arg0.contains(arg1);
    }

    public boolean equals(Object arg1) {
        return MultiValueMap.equals-impl(this.map, arg1);
    }

    public static boolean equals-impl(MutableScatterMap arg2, Object arg3) {
        if(!(arg3 instanceof MultiValueMap)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((MultiValueMap)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(MutableScatterMap arg0, MutableScatterMap arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final void forEachValue-impl(MutableScatterMap arg3, Object arg4, Function1 arg5) {
        Object v3 = arg3.get(arg4);
        if(v3 != null) {
            if((v3 instanceof MutableObjectList)) {
                Object[] v4 = ((ObjectList)v3).content;
                int v3_1 = ((ObjectList)v3)._size;
                int v0;
                for(v0 = 0; v0 < v3_1; ++v0) {
                    Object v1 = v4[v0];
                    Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                    arg5.invoke(v1);
                }
            }
            else {
                arg5.invoke(v3);
            }
        }
    }

    public static final void forEachValue-impl(MutableScatterMap arg14, Function1 arg15) {
        Object[] v0 = ((ScatterMap)arg14).values;
        long[] v14 = ((ScatterMap)arg14).metadata;
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
                            Object v9 = v0[(v3 << 3) + v8];
                            String v11 = "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap";
                            if((v9 instanceof MutableObjectList)) {
                                Object[] v10 = ((ObjectList)v9).content;
                                int v9_1 = ((ObjectList)v9)._size;
                                int v12;
                                for(v12 = 0; v12 < v9_1; ++v12) {
                                    Object v13 = v10[v12];
                                    Intrinsics.checkNotNull(v13, v11);
                                    arg15.invoke(v13);
                                }
                            }
                            else {
                                Intrinsics.checkNotNull(v9, v11);
                                arg15.invoke(v9);
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

    public static final ObjectList get-impl(MutableScatterMap arg0, Object arg1) {
        Object v0 = arg0.get(arg1);
        if(v0 == null) {
            return ObjectListKt.emptyObjectList();
        }

        if((v0 instanceof MutableObjectList)) {
            return ((ObjectList)v0);
        }

        return ObjectListKt.objectListOf(v0);
    }

    public int hashCode() {
        return MultiValueMap.hashCode-impl(this.map);
    }

    public static int hashCode-impl(MutableScatterMap arg0) {
        return arg0.hashCode();
    }

    public static final boolean isEmpty-impl(MutableScatterMap arg0) {
        return arg0.isEmpty();
    }

    public static final boolean isNotEmpty-impl(MutableScatterMap arg0) {
        return arg0.isNotEmpty();
    }

    public static final Object removeFirst-impl(MutableScatterMap arg4, Object arg5) {
        Object v0 = arg4.get(arg5);
        if(v0 == null) {
            return null;
        }

        if((v0 instanceof MutableObjectList)) {
            Object v1 = ((MutableObjectList)v0).removeAt(0);
            if(((MutableObjectList)v0).isEmpty()) {
                arg4.remove(arg5);
            }

            if(((MutableObjectList)v0).getSize() == 1) {
                arg4.set(arg5, ((MutableObjectList)v0).first());
            }

            return v1;
        }

        arg4.remove(arg5);
        return v0;
    }

    public static final Object removeLast-impl(MutableScatterMap arg4, Object arg5) {
        Object v0 = arg4.get(arg5);
        if(v0 == null) {
            return null;
        }

        if((v0 instanceof MutableObjectList)) {
            Object v1 = ExtensionsKt.removeLast(((MutableObjectList)v0));
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
            if(((MutableObjectList)v0).isEmpty()) {
                arg4.remove(arg5);
            }

            if(((MutableObjectList)v0).getSize() == 1) {
                arg4.set(arg5, ((MutableObjectList)v0).first());
            }

            return v1;
        }

        arg4.remove(arg5);
        return v0;
    }

    public static final void removeValueIf-impl(MutableScatterMap arg8, Object arg9, Function1 arg10) {
        Object v0 = arg8.get(arg9);
        if(v0 != null) {
            if((v0 instanceof MutableObjectList)) {
                int v1 = ((MutableObjectList)v0)._size;
                Object[] v2 = ((MutableObjectList)v0).content;
                int v4 = 0;
                IntRange v3 = RangesKt.until(0, v0._size);
                int v5 = v3.getFirst();
                int v3_1 = v3.getLast();
                if(v5 <= v3_1) {
                    while(true) {
                        v2[v5 - v4] = v2[v5];
                        if(arg10.invoke(v2[v5]).booleanValue()) {
                            ++v4;
                        }

                        if(v5 == v3_1) {
                            break;
                        }

                        ++v5;
                    }
                }

                ArraysKt.fill(v2, null, v1 - v4, v1);
                ((MutableObjectList)v0)._size -= v4;
                if(((MutableObjectList)v0).isEmpty()) {
                    arg8.remove(arg9);
                }

                if(((MutableObjectList)v0).getSize() != 0) {
                    return;
                }

                arg8.set(arg9, ((MutableObjectList)v0).first());
                return;
            }
            else {
                if(!arg10.invoke(v0).booleanValue()) {
                    return;
                }

                arg8.remove(arg9);
            }
        }
    }

    public String toString() {
        return MultiValueMap.toString-impl(this.map);
    }

    public static String toString-impl(MutableScatterMap arg2) {
        return "MultiValueMap(map=" + arg2 + ')';
    }

    public final MutableScatterMap unbox-impl() {
        return this.map;
    }

    public static final ObjectList values-impl(MutableScatterMap arg14) {
        if(arg14.isEmpty()) {
            return ObjectListKt.emptyObjectList();
        }

        MutableObjectList v0 = new MutableObjectList(0, 1, null);
        Object[] v1 = ((ScatterMap)arg14).values;
        long[] v14 = ((ScatterMap)arg14).metadata;
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
                        if((0xFF & v5) < 0x80) {
                            Object v10 = v1[(v4 << 3) + v9];
                            if((v10 instanceof MutableObjectList)) {
                                Intrinsics.checkNotNull(v10, "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.collection.MultiValueMap>");
                                v0.addAll(((ObjectList)v10));
                            }
                            else {
                                Intrinsics.checkNotNull(v10, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                                v0.add(v10);
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        break;
                    }
                }

                if(v4 == v3) {
                    break;
                }
            }
        }

        return ((ObjectList)v0);
    }
}

