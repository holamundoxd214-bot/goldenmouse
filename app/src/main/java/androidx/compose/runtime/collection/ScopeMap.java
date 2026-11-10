package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u001D\u0012\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000E\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u000F\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001D\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00028\u00002\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001AJ\u001D\u0010\u001B\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u001C\u001A\u00028\u0001¢\u0006\u0004\b\u001D\u0010\u0016J\u0018\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00028\u0000H\u0086\u0002¢\u0006\u0004\b!\u0010\"J0\u0010#\u001A\u00020\u00132!\u0010$\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0004\b(\u0010)J;\u0010*\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00028\u00002!\u0010$\u001A\u001D\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00130%H\u0086\b¢\u0006\u0004\b+\u0010,J;\u0010-\u001A\u00020\u001F2\u0006\u0010\u000F\u001A\u00028\u00002!\u0010$\u001A\u001D\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u001F0%H\u0086\b¢\u0006\u0004\b.\u0010/J\r\u00100\u001A\u00020\u0013¢\u0006\u0004\b1\u00102J\r\u00103\u001A\u00020\u001F¢\u0006\u0004\b4\u00105J\r\u00106\u001A\u00020\u001F¢\u0006\u0004\b7\u00105JH\u00108\u001A\u00020\u001326\u0010$\u001A2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u001309H\u0086\b¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u000F\u001A\u00028\u0000¢\u0006\u0004\b=\u0010\u0011J\u001D\u0010<\u001A\u00020\u001F2\u0006\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0001¢\u0006\u0004\b=\u0010>J5\u0010?\u001A\u00020\u00132#\b\u0004\u0010@\u001A\u001D\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u001F0%H\u0086\b¢\u0006\u0004\bA\u0010)J*\u0010B\u001A\u00020\u00132\u0018\u0010@\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001F09H\u0086\b¢\u0006\u0004\bC\u0010;J\u0015\u0010D\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00028\u0001¢\u0006\u0004\bE\u0010FJ\u001F\u0010G\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010I0H¢\u0006\u0004\bJ\u0010KJ\u0014\u0010L\u001A\u00020\u001F2\b\u0010M\u001A\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010N\u001A\u00020\u000BHÖ\u0081\u0004J\n\u0010O\u001A\u00020PHÖ\u0081\u0004R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\f\u0010\r\u0088\u0001\u0004¨\u0006Q"}, d2={"Landroidx/compose/runtime/collection/ScopeMap;", "Key", "", "Scope", "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize-impl", "(Landroidx/collection/MutableScatterMap;)I", "get", "key", "get-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "add", "", "scope", "add-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "addAll", "Landroidx/collection/ScatterSet;", "addAll-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Landroidx/collection/ScatterSet;)V", "set", "value", "set-impl", "contains", "", "element", "contains-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "forEachKey", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachKey-impl", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function1;)V", "forEachScopeOf", "forEachScopeOf-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "anyScopeOf", "anyScopeOf-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "clear", "clear-impl", "(Landroidx/collection/MutableScatterMap;)V", "isEmpty", "isEmpty-impl", "(Landroidx/collection/MutableScatterMap;)Z", "isNotEmpty", "isNotEmpty-impl", "forEach", "Lkotlin/Function2;", "forEach-impl", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;)V", "remove", "remove-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScopeIf", "predicate", "removeScopeIf-impl", "removeIf", "removeIf-impl", "removeScope", "removeScope-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)V", "asMap", "", "", "asMap-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/util/Map;", "equals", "other", "hashCode", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class ScopeMap {
    private final MutableScatterMap map;

    private ScopeMap(MutableScatterMap arg1) {
        super();
        this.map = arg1;
    }

    public static final void add-impl(MutableScatterMap arg7, Object arg8, Object arg9) {
        int v0 = arg7.findInsertIndex(arg8);
        int v3 = v0 < 0 ? 1 : 0;
        DefaultConstructorMarker v4 = null;
        Object v5 = v3 != 0 ? v4 : arg7.values[v0];
        if(v5 == null) {
        }
        else {
            if((v5 instanceof MutableScatterSet)) {
                Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                v5.add(arg9);
            }
            else if(v5 != arg9) {
                MutableScatterSet v6 = new MutableScatterSet(0, 1, v4);
                Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                v6.add(v5);
                v6.add(arg9);
                MutableScatterSet v9 = v6;
                goto label_32;
            }

            arg9 = v5;
        }

    label_32:
        if(v3 != 0) {
            v0 = ~v0;
            arg7.keys[v0] = arg8;
            arg7.values[v0] = arg9;
            return;
        }

        arg7.values[v0] = arg9;
    }

    public static final void addAll-impl(MutableScatterMap arg5, Object arg6, ScatterSet arg7) {
        MutableScatterSet v3_1;
        int v0 = arg5.findInsertIndex(arg6);
        int v2 = v0 < 0 ? 1 : 0;
        Object v3 = v2 != 0 ? null : arg5.values[v0];
        if(v3 == null) {
            v3_1 = ScatterSetKt.mutableScatterSetOf();
            v3_1.addAll(arg7);
        }
        else if((v3 instanceof MutableScatterSet)) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
            ((MutableScatterSet)v3).addAll(arg7);
        }
        else {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
            if(arg7.getSize() == 1 && (arg7.contains(v3))) {
                goto label_32;
            }

            MutableScatterSet v1 = ScatterSetKt.mutableScatterSetOf();
            v1.addAll(arg7);
            v1.add(v3);
            v3_1 = v1;
        }

    label_32:
        if(v2 != 0) {
            int v7 = ~v0;
            arg5.keys[v7] = arg6;
            arg5.values[v7] = v3_1;
            return;
        }

        arg5.values[v0] = v3_1;
    }

    public static final boolean anyScopeOf-impl(MutableScatterMap arg13, Object arg14, Function1 arg15) {
        Object v13 = arg13.get(arg14);
        if(v13 != null) {
            if((v13 instanceof MutableScatterSet)) {
                Object[] v0 = ((ScatterSet)v13).elements;
                long[] v13_1 = ((ScatterSet)v13).metadata;
                int v2 = v13_1.length - 2;
                if(v2 >= 0) {
                    int v3;
                    for(v3 = 0; true; ++v3) {
                        long v4 = v13_1[v3];
                        if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                            int v7 = 8;
                            int v6 = 8 - (~(v3 - v2) >>> 0x1F);
                            int v8;
                            for(v8 = 0; v8 < v6; ++v8) {
                                if((0xFF & v4) < 0x80 && (arg15.invoke(v0[(v3 << 3) + v8]).booleanValue())) {
                                    return 1;
                                }

                                v4 >>= v7;
                            }

                            if(v6 != v7) {
                                return 0;
                            }
                        }

                        if(v3 == v2) {
                            return 0;
                        }
                    }
                }
            }
            else {
                if(!arg15.invoke(v13).booleanValue()) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public static final Map asMap-impl(MutableScatterMap arg15) {
        Set v11_2;
        HashMap v0 = new HashMap();
        Object[] v1 = ((ScatterMap)arg15).keys;
        Object[] v2 = ((ScatterMap)arg15).values;
        long[] v15 = ((ScatterMap)arg15).metadata;
        int v3 = v15.length - 2;
        if(v3 >= 0) {
            int v5;
            for(v5 = 0; true; ++v5) {
                long v6 = v15[v5];
                if((~v6 << 7 & v6 & -9187201950435737472L) != -9187201950435737472L) {
                    int v9 = 8;
                    int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                    int v10;
                    for(v10 = 0; v10 < v8; ++v10) {
                        if((0xFF & v6) < 0x80) {
                            int v11 = (v5 << 3) + v10;
                            Object v12 = v1[v11];
                            Object v11_1 = v2[v11];
                            HashMap v13 = v0;
                            Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                            if((v11_1 instanceof MutableScatterSet)) {
                                Intrinsics.checkNotNull(v11_1, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                v11_2 = ((MutableScatterSet)v11_1).asSet();
                            }
                            else {
                                Intrinsics.checkNotNull(v11_1, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                v11_2 = SetsKt.mutableSetOf(new Object[]{v11_1});
                            }

                            ((Map)v13).put(v12, v11_2);
                        }

                        v6 >>= v9;
                    }

                    if(v8 != v9) {
                        break;
                    }
                }

                if(v5 == v3) {
                    break;
                }
            }
        }

        return ((Map)v0);
    }

    public static final ScopeMap box-impl(MutableScatterMap arg1) {
        return new ScopeMap(arg1);
    }

    public static final void clear-impl(MutableScatterMap arg0) {
        arg0.clear();
    }

    public static MutableScatterMap constructor-impl(MutableScatterMap arg0) {
        return arg0;
    }

    public static MutableScatterMap constructor-impl$default(MutableScatterMap arg0, int arg1, DefaultConstructorMarker arg2) {
        if((arg1 & 1) != 0) {
            arg0 = ScatterMapKt.mutableScatterMapOf();
        }

        return ScopeMap.constructor-impl(arg0);
    }

    public static final boolean contains-impl(MutableScatterMap arg0, Object arg1) {
        return arg0.containsKey(arg1);
    }

    public boolean equals(Object arg1) {
        return ScopeMap.equals-impl(this.map, arg1);
    }

    public static boolean equals-impl(MutableScatterMap arg2, Object arg3) {
        if(!(arg3 instanceof ScopeMap)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((ScopeMap)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(MutableScatterMap arg0, MutableScatterMap arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final void forEach-impl(MutableScatterMap arg14, Function2 arg15) {
        Object[] v0 = ((ScatterMap)arg14).keys;
        Object[] v1 = ((ScatterMap)arg14).values;
        long[] v14 = ((ScatterMap)arg14).metadata;
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
                            Object v11 = v0[v10];
                            Object v10_1 = v1[v10];
                            Intrinsics.checkNotNull(v11, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                            arg15.invoke(v11, v10_1);
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

    public static final void forEachKey-impl(MutableScatterMap arg13, Function1 arg14) {
        Intrinsics.checkNotNull(arg14, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        Object v14 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg14, 1);
        Object[] v0 = ((ScatterMap)arg13).keys;
        long[] v13 = ((ScatterMap)arg13).metadata;
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
                            ((Function1)v14).invoke(v0[(v3 << 3) + v8]);
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

    public static final void forEachScopeOf-impl(MutableScatterMap arg12, Object arg13, Function1 arg14) {
        Object v12 = arg12.get(arg13);
        if(v12 != null) {
            if((v12 instanceof MutableScatterSet)) {
                Object[] v13 = ((ScatterSet)v12).elements;
                long[] v12_1 = ((ScatterSet)v12).metadata;
                int v0 = v12_1.length - 2;
                if(v0 >= 0) {
                    int v2;
                    for(v2 = 0; true; ++v2) {
                        long v3 = v12_1[v2];
                        if((~v3 << 7 & v3 & -9187201950435737472L) != -9187201950435737472L) {
                            int v6 = 8;
                            int v5 = 8 - (~(v2 - v0) >>> 0x1F);
                            int v7;
                            for(v7 = 0; v7 < v5; ++v7) {
                                if((0xFF & v3) < 0x80) {
                                    arg14.invoke(v13[(v2 << 3) + v7]);
                                }

                                v3 >>= v6;
                            }

                            if(v5 != v6) {
                                return;
                            }
                        }

                        if(v2 == v0) {
                            return;
                        }
                    }
                }
            }
            else {
                arg14.invoke(v12);
            }
        }
    }

    public static final Object get-impl(MutableScatterMap arg0, Object arg1) {
        return arg0.get(arg1);
    }

    public final MutableScatterMap getMap() {
        return this.map;
    }

    public static final int getSize-impl(MutableScatterMap arg0) {
        return arg0.getSize();
    }

    public int hashCode() {
        return ScopeMap.hashCode-impl(this.map);
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

    public static final boolean remove-impl(MutableScatterMap arg3, Object arg4, Object arg5) {
        Object v0 = arg3.get(arg4);
        if(v0 == null) {
            return 0;
        }

        if((v0 instanceof MutableScatterSet)) {
            boolean v5 = ((MutableScatterSet)v0).remove(arg5);
            if((v5) && (((MutableScatterSet)v0).isEmpty())) {
                arg3.remove(arg4);
            }

            return v5;
        }

        if(Intrinsics.areEqual(v0, arg5)) {
            arg3.remove(arg4);
            return 1;
        }

        return 0;
    }

    public static final Object remove-impl(MutableScatterMap arg0, Object arg1) {
        return arg0.remove(arg1);
    }

    public static final void removeIf-impl(MutableScatterMap arg33, Function2 arg34) {
        boolean v2_2;
        long v31;
        int v2_1;
        long[] v30;
        int v27;
        long v25;
        long v20;
        int v16;
        MutableScatterMap v0 = arg33;
        Function2 v1 = arg34;
        long[] v2 = v0.metadata;
        int v3 = v2.length - 2;
        if(v3 >= 0) {
            int v5 = 0;
            while(true) {
                long v6 = v2[v5];
                int v10 = 7;
                long v11 = -9187201950435737472L;
                if((~v6 << v10 & v6 & v11) != v11) {
                    int v9 = 8;
                    int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                    int v13 = 0;
                    while(v13 < v8) {
                        long v14 = 0xFF;
                        long v18 = 0x80;
                        if((v6 & v14) < v18) {
                            int v4 = (v5 << 3) + v13;
                            v16 = v10;
                            Object v10_1 = v0.keys[v4];
                            v20 = v11;
                            Object v11_1 = v0.values[v4];
                            Intrinsics.checkNotNull(v10_1, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                            if((v11_1 instanceof MutableScatterSet)) {
                                Intrinsics.checkNotNull(v11_1, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                Object[] v12 = ((MutableScatterSet)v11_1).elements;
                                long v22 = v14;
                                long[] v14_1 = v11_1.metadata;
                                int v15 = v14_1.length - 2;
                                if(v15 >= 0) {
                                    v25 = v6;
                                    int v24 = v9;
                                    v9 = 0;
                                    while(true) {
                                        v6 = v14_1[v9];
                                        Object[] v28 = v12;
                                        v27 = v13;
                                        if((~v6 << v16 & v6 & v20) != v20) {
                                            int v12_1 = 8 - (~(v9 - v15) >>> 0x1F);
                                            v13 = 0;
                                            while(v13 < v12_1) {
                                                if((v6 & v22) < v18) {
                                                    v30 = v2;
                                                    v2_1 = (v9 << 3) + v13;
                                                    v31 = v6;
                                                    if(v1.invoke(v10_1, v28[v2_1]).booleanValue()) {
                                                        ((MutableScatterSet)v11_1).removeElementAt(v2_1);
                                                    }
                                                }
                                                else {
                                                    v30 = v2;
                                                    v31 = v6;
                                                }

                                                v6 = v31 >> v24;
                                                ++v13;
                                                v2 = v30;
                                            }

                                            v30 = v2;
                                            if(v12_1 != v24) {
                                                break;
                                            }
                                        }
                                        else {
                                            v30 = v2;
                                        }

                                        if(v9 == v15) {
                                            break;
                                        }

                                        ++v9;
                                        v13 = v27;
                                        v12 = v28;
                                        v2 = v30;
                                        v24 = 8;
                                    }
                                }
                                else {
                                    v30 = v2;
                                    v25 = v6;
                                    v27 = v13;
                                }

                                v2_2 = ((MutableScatterSet)v11_1).isEmpty();
                            }
                            else {
                                v30 = v2;
                                v25 = v6;
                                v27 = v13;
                                Intrinsics.checkNotNull(v11_1, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                v2_2 = v1.invoke(v10_1, v11_1).booleanValue();
                            }

                            if(v2_2) {
                                v0.removeValueAt(v4);
                            }

                            v2_1 = 8;
                        }
                        else {
                            v30 = v2;
                            v25 = v6;
                            v16 = v10;
                            v20 = v11;
                            v27 = v13;
                            v2_1 = v9;
                        }

                        v6 = v25 >> v2_1;
                        v13 = v27 + 1;
                        v9 = v2_1;
                        v10 = v16;
                        v11 = v20;
                        v2 = v30;
                    }

                    v30 = v2;
                    if(v8 != v9) {
                        return;
                    }
                }
                else {
                    v30 = v2;
                }

                if(v5 == v3) {
                    return;
                }

                ++v5;
                v2 = v30;
            }
        }
    }

    public static final void removeScope-impl(MutableScatterMap arg13, Object arg14) {
        boolean v10_1;
        long[] v0 = arg13.metadata;
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
                            Object v10 = arg13.values[v9];
                            if((v10 instanceof MutableScatterSet)) {
                                Intrinsics.checkNotNull(v10, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                ((MutableScatterSet)v10).remove(arg14);
                                v10_1 = ((MutableScatterSet)v10).isEmpty();
                            }
                            else if(v10 == arg14) {
                                v10_1 = true;
                            }
                            else {
                                v10_1 = false;
                            }

                            if(!v10_1) {
                                goto label_45;
                            }

                            arg13.removeValueAt(v9);
                        }

                    label_45:
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

    public static final void removeScopeIf-impl(MutableScatterMap arg30, Function1 arg31) {
        boolean v2_2;
        Object v7_1;
        int v28;
        int v2_1;
        long[] v29;
        long v26;
        long v20;
        int v16;
        MutableScatterMap v0 = arg30;
        Function1 v1 = arg31;
        long[] v2 = v0.metadata;
        int v3 = v2.length - 2;
        if(v3 >= 0) {
            int v5 = 0;
            while(true) {
                long v6 = v2[v5];
                int v10 = 7;
                long v11 = -9187201950435737472L;
                if((~v6 << v10 & v6 & v11) != v11) {
                    int v9 = 8;
                    int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                    int v13 = 0;
                    while(v13 < v8) {
                        long v14 = 0xFF;
                        long v18 = 0x80;
                        if((v6 & v14) < v18) {
                            int v4 = (v5 << 3) + v13;
                            v16 = v10;
                            Object v10_1 = v0.values[v4];
                            v20 = v11;
                            if((v10_1 instanceof MutableScatterSet)) {
                                Intrinsics.checkNotNull(v10_1, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                Object[] v11_1 = ((MutableScatterSet)v10_1).elements;
                                long[] v12 = v10_1.metadata;
                                long v22 = v14;
                                int v14_1 = v12.length - 2;
                                if(v14_1 >= 0) {
                                    int v24 = v9;
                                    Object v25 = v10_1;
                                    int v15 = 0;
                                    while(true) {
                                        long v9_1 = v12[v15];
                                        v26 = v6;
                                        if((~v9_1 << v16 & v9_1 & v20) != v20) {
                                            int v6_1 = 8 - (~(v15 - v14_1) >>> 0x1F);
                                            int v7 = 0;
                                            while(v7 < v6_1) {
                                                if((v9_1 & v22) < v18) {
                                                    v29 = v2;
                                                    v2_1 = (v15 << 3) + v7;
                                                    v28 = v7;
                                                    if(v1.invoke(v11_1[v2_1]).booleanValue()) {
                                                        v7_1 = v25;
                                                        ((MutableScatterSet)v7_1).removeElementAt(v2_1);
                                                    }
                                                    else {
                                                        goto label_77;
                                                    }
                                                }
                                                else {
                                                    v29 = v2;
                                                    v28 = v7;
                                                label_77:
                                                    v7_1 = v25;
                                                }

                                                v9_1 >>= v24;
                                                v25 = v7_1;
                                                v7 = v28 + 1;
                                                v2 = v29;
                                            }

                                            v29 = v2;
                                            v7_1 = v25;
                                            if(v6_1 != v24) {
                                                break;
                                            }
                                        }
                                        else {
                                            v29 = v2;
                                            v7_1 = v25;
                                        }

                                        if(v15 == v14_1) {
                                            break;
                                        }

                                        ++v15;
                                        v25 = v7_1;
                                        v6 = v26;
                                        v2 = v29;
                                        v24 = 8;
                                    }
                                }
                                else {
                                    v29 = v2;
                                    v26 = v6;
                                    v7_1 = v10_1;
                                }

                                v2_2 = ((MutableScatterSet)v7_1).isEmpty();
                            }
                            else {
                                v29 = v2;
                                v26 = v6;
                                Intrinsics.checkNotNull(v10_1, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                v2_2 = v1.invoke(v10_1).booleanValue();
                            }

                            if(v2_2) {
                                v0.removeValueAt(v4);
                            }

                            v2_1 = 8;
                        }
                        else {
                            v29 = v2;
                            v26 = v6;
                            v16 = v10;
                            v20 = v11;
                            v2_1 = v9;
                        }

                        v6 = v26 >> v2_1;
                        ++v13;
                        v9 = v2_1;
                        v10 = v16;
                        v11 = v20;
                        v2 = v29;
                    }

                    v29 = v2;
                    if(v8 != v9) {
                        return;
                    }
                }
                else {
                    v29 = v2;
                }

                if(v5 == v3) {
                    return;
                }

                ++v5;
                v2 = v29;
            }
        }
    }

    public static final void set-impl(MutableScatterMap arg0, Object arg1, Object arg2) {
        arg0.set(arg1, arg2);
    }

    public String toString() {
        return ScopeMap.toString-impl(this.map);
    }

    public static String toString-impl(MutableScatterMap arg2) {
        return "ScopeMap(map=" + arg2 + ')';
    }

    public final MutableScatterMap unbox-impl() {
        return this.map;
    }
}

