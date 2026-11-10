package androidx.compose.runtime.retain.impl;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterMap;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0081@\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u00010\u00022\u00020\u0002:\u00017B\u001D\u0012\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00028\u0001¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000E\u001A\u00020\t¢\u0006\u0004\b\u000F\u0010\u0010J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\n\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001A\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001A\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001A\u001A\u0004\u0018\u00018\u00012\u0006\u0010\n\u001A\u00028\u0000¢\u0006\u0004\b\u001B\u0010\u001CJ\u001F\u0010\u001A\u001A\u0004\u0018\u00018\u00012\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00028\u0001¢\u0006\u0004\b\u001B\u0010\u001EJ\u001F\u0010\u001F\u001A\u0004\u0018\u00018\u00012\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00028\u0001¢\u0006\u0004\b \u0010\u001EJ\u0013\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00010\"¢\u0006\u0004\b#\u0010$J;\u0010%\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u00002!\u0010&\u001A\u001D\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\t0\'H\u0086\b¢\u0006\u0004\b*\u0010+J3\u0010%\u001A\u00020\t2!\u0010&\u001A\u001D\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\t0\'H\u0086\b¢\u0006\u0004\b*\u0010,J\u0015\u0010-\u001A\u00020\u0002*\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b.\u0010\u001CJ\u0016\u0010/\u001A\u00028\u0001*\u0004\u0018\u00010\u0002H\u0080\b¢\u0006\u0004\b0\u0010\u001CJ\u0014\u00101\u001A\u00020\u00122\b\u00102\u001A\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u00103\u001A\u000204HÖ\u0081\u0004J\n\u00105\u001A\u000206HÖ\u0081\u0004R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¨\u00068"}, d2={"Landroidx/compose/runtime/retain/impl/SafeMultiValueMap;", "K", "", "V", "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "add", "", "key", "value", "add-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "clear", "clear-impl", "(Landroidx/collection/MutableScatterMap;)V", "contains", "", "contains-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "isEmpty", "isEmpty-impl", "(Landroidx/collection/MutableScatterMap;)Z", "isNotEmpty", "isNotEmpty-impl", "removeLast", "removeLast-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "defaultIfAbsent", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "removeFirst", "removeFirst-impl", "values", "Landroidx/collection/ObjectList;", "values-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/ObjectList;", "forEachValue", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachValue-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function1;)V", "safeWrapIfNecessary", "safeWrapIfNecessary-impl$runtime_retain", "unwrapSafeValue", "unwrapSafeValue-impl$runtime_retain", "equals", "other", "hashCode", "", "toString", "", "ValueSafetyWrapper", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class SafeMultiValueMap {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/runtime/retain/impl/SafeMultiValueMap$ValueSafetyWrapper;", "", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ValueSafetyWrapper {
        public static final int $stable = 8;
        private final Object value;

        static {
        }

        public ValueSafetyWrapper(Object arg1) {
            super();
            this.value = arg1;
        }

        public final Object getValue() {
            return this.value;
        }
    }

    private final MutableScatterMap map;

    private SafeMultiValueMap(MutableScatterMap arg1) {
        super();
        this.map = arg1;
    }

    public static final void add-impl(MutableScatterMap arg5, Object arg6, Object arg7) {
        if(arg6 == null) {
            arg6 = SafeMultiValueMapKt.access$getNULL_SENTINEL$p();
        }

        int v0 = arg5.findInsertIndex(arg6);
        int v1 = v0 < 0 ? 1 : 0;
        Object v2 = null;
        Object v3 = v1 != 0 ? v2 : arg5.values[v0];
        if(v3 == null) {
            arg7 = SafeMultiValueMap.safeWrapIfNecessary-impl$runtime_retain(arg5, arg7);
        }
        else if((v3 instanceof MutableObjectList)) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type androidx.collection.MutableObjectList<kotlin.Any?>");
            v3.add(arg7);
            arg7 = v3;
        }
        else {
            if((v3 instanceof ValueSafetyWrapper)) {
                v2 = ((ValueSafetyWrapper)v3).getValue();
            }
            else if(v3 == SafeMultiValueMapKt.access$getNULL_SENTINEL$p()) {
            }
            else {
                v2 = v3;
            }

            MutableObjectList v7 = ObjectListKt.mutableObjectListOf(v2, arg7);
        }

        if(v1 != 0) {
            v0 = ~v0;
            arg5.keys[v0] = arg6;
            arg5.values[v0] = arg7;
            return;
        }

        arg5.values[v0] = arg7;
    }

    public static final SafeMultiValueMap box-impl(MutableScatterMap arg1) {
        return new SafeMultiValueMap(arg1);
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

        return SafeMultiValueMap.constructor-impl(arg1);
    }

    public static final boolean contains-impl(MutableScatterMap arg0, Object arg1) {
        if(arg1 == null) {
            arg1 = SafeMultiValueMapKt.access$getNULL_SENTINEL$p();
        }

        return arg0.contains(arg1);
    }

    public boolean equals(Object arg1) {
        return SafeMultiValueMap.equals-impl(this.map, arg1);
    }

    public static boolean equals-impl(MutableScatterMap arg2, Object arg3) {
        if(!(arg3 instanceof SafeMultiValueMap)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((SafeMultiValueMap)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(MutableScatterMap arg0, MutableScatterMap arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final void forEachValue-impl(MutableScatterMap arg2, Object arg3, Function1 arg4) {
        if(arg3 == null) {
            arg3 = SafeMultiValueMapKt.access$getNULL_SENTINEL$p();
        }

        Object v2 = arg2.get(arg3);
        if(v2 != null) {
            if((v2 instanceof MutableObjectList)) {
                Object[] v3 = ((ObjectList)v2).content;
                int v2_1 = ((ObjectList)v2)._size;
                int v0;
                for(v0 = 0; v0 < v2_1; ++v0) {
                    arg4.invoke(v3[v0]);
                }
            }
            else {
                if((v2 instanceof ValueSafetyWrapper)) {
                    v2 = ((ValueSafetyWrapper)v2).getValue();
                }
                else if(v2 == SafeMultiValueMapKt.access$getNULL_SENTINEL$p()) {
                    v2 = null;
                }

                arg4.invoke(v2);
            }
        }
    }

    public static final void forEachValue-impl(MutableScatterMap arg13, Function1 arg14) {
        Object[] v0 = ((ScatterMap)arg13).values;
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
                            Object v9 = v0[(v3 << 3) + v8];
                            if((v9 instanceof MutableObjectList)) {
                                Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.retain.impl.SafeMultiValueMap>");
                                Object[] v10 = ((ObjectList)v9).content;
                                int v9_1 = ((ObjectList)v9)._size;
                                int v11;
                                for(v11 = 0; v11 < v9_1; ++v11) {
                                    arg14.invoke(v10[v11]);
                                }
                            }
                            else {
                                arg14.invoke(v9);
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

    public int hashCode() {
        return SafeMultiValueMap.hashCode-impl(this.map);
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

    public static final Object removeFirst-impl(MutableScatterMap arg3, Object arg4, Object arg5) {
        if(arg4 == null) {
            arg4 = SafeMultiValueMapKt.access$getNULL_SENTINEL$p();
        }

        Object v0 = arg3.get(arg4);
        if(v0 == null) {
            return arg5;
        }

        if((v0 instanceof MutableObjectList)) {
            arg5 = ((MutableObjectList)v0).removeAt(0);
            if(((MutableObjectList)v0).isEmpty()) {
                arg3.remove(arg4);
            }

            if(((MutableObjectList)v0).getSize() == 1) {
                arg3.set(arg4, SafeMultiValueMap.safeWrapIfNecessary-impl$runtime_retain(arg3, ((MutableObjectList)v0).first()));
            }

            return arg5;
        }

        Object v3 = arg3.remove(arg4);
        if((v3 instanceof ValueSafetyWrapper)) {
            return ((ValueSafetyWrapper)v3).getValue();
        }

        if(v3 == SafeMultiValueMapKt.access$getNULL_SENTINEL$p()) {
            v3 = null;
        }

        return v3;
    }

    public static final Object removeLast-impl(MutableScatterMap arg3, Object arg4, Object arg5) {
        if(arg4 == null) {
            arg4 = SafeMultiValueMapKt.access$getNULL_SENTINEL$p();
        }

        Object v0 = arg3.get(arg4);
        if(v0 == null) {
            return arg5;
        }

        if((v0 instanceof MutableObjectList)) {
            arg5 = ((MutableObjectList)v0).removeAt(((MutableObjectList)v0).getSize() - 1);
            if(((MutableObjectList)v0).isEmpty()) {
                arg3.remove(arg4);
            }

            if(((MutableObjectList)v0).getSize() == 1) {
                arg3.set(arg4, SafeMultiValueMap.safeWrapIfNecessary-impl$runtime_retain(arg3, ((MutableObjectList)v0).first()));
            }

            return arg5;
        }

        arg3.remove(arg4);
        if((v0 instanceof ValueSafetyWrapper)) {
            return ((ValueSafetyWrapper)v0).getValue();
        }

        if(v0 == SafeMultiValueMapKt.access$getNULL_SENTINEL$p()) {
            return null;
        }

        return v0;
    }

    public static final Object removeLast-impl(MutableScatterMap arg4, Object arg5) {
        if(arg5 == null) {
            arg5 = SafeMultiValueMapKt.access$getNULL_SENTINEL$p();
        }

        Object v0 = arg4.get(arg5);
        Object v1 = null;
        if(v0 == null) {
            return v1;
        }

        if((v0 instanceof MutableObjectList)) {
            v1 = ((MutableObjectList)v0).removeAt(((MutableObjectList)v0).getSize() - 1);
            if(((MutableObjectList)v0).getSize() == 1) {
                arg4.set(arg5, SafeMultiValueMap.safeWrapIfNecessary-impl$runtime_retain(arg4, ((MutableObjectList)v0).first()));
            }

            return v1;
        }

        arg4.remove(arg5);
        if((v0 instanceof ValueSafetyWrapper)) {
            return ((ValueSafetyWrapper)v0).getValue();
        }

        if(v0 == SafeMultiValueMapKt.access$getNULL_SENTINEL$p()) {
            return v1;
        }

        return v0;
    }

    public static final Object safeWrapIfNecessary-impl$runtime_retain(MutableScatterMap arg0, Object arg1) {
        if((arg1 instanceof MutableObjectList)) {
            return new ValueSafetyWrapper(arg1);
        }

        if(arg1 == null) {
            return SafeMultiValueMapKt.access$getNULL_SENTINEL$p();
        }

        return arg1;
    }

    public String toString() {
        return SafeMultiValueMap.toString-impl(this.map);
    }

    public static String toString-impl(MutableScatterMap arg2) {
        return "SafeMultiValueMap(map=" + arg2 + ')';
    }

    public final MutableScatterMap unbox-impl() {
        return this.map;
    }

    public static final Object unwrapSafeValue-impl$runtime_retain(MutableScatterMap arg0, Object arg1) {
        if((arg1 instanceof ValueSafetyWrapper)) {
            return ((ValueSafetyWrapper)arg1).getValue();
        }

        if(arg1 == SafeMultiValueMapKt.access$getNULL_SENTINEL$p()) {
            return null;
        }

        return arg1;
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
                                Intrinsics.checkNotNull(v10, "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.retain.impl.SafeMultiValueMap>");
                                v0.addAll(((ObjectList)v10));
                            }
                            else {
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

