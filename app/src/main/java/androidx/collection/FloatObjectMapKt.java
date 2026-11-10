package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0015\u001AD\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001D\u0010\u0006\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001AL\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\n\u001A\u00020\u000B2\u001D\u0010\u0006\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0012\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001A\u0012\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001A\'\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u0005¢\u0006\u0002\u0010\u0011\u001A7\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u0005¢\u0006\u0002\u0010\u0014\u001AG\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u0005¢\u0006\u0002\u0010\u0017\u001AW\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u00052\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u0002H\u0005¢\u0006\u0002\u0010\u001A\u001Ag\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u00052\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u0002H\u00052\u0006\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u001C\u001A\u0002H\u0005¢\u0006\u0002\u0010\u001D\u001A\u0012\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001A\'\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u0005¢\u0006\u0002\u0010\u001F\u001A7\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u0005¢\u0006\u0002\u0010 \u001AG\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u0005¢\u0006\u0002\u0010!\u001AW\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u00052\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u0002H\u0005¢\u0006\u0002\u0010\"\u001Ag\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u00052\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u0002H\u00052\u0006\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u001C\u001A\u0002H\u0005¢\u0006\u0002\u0010#\"\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2={"EmptyFloatObjectMap", "Landroidx/collection/MutableFloatObjectMap;", "", "buildFloatObjectMap", "Landroidx/collection/FloatObjectMap;", "V", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyFloatObjectMap", "floatObjectMapOf", "key1", "", "value1", "(FLjava/lang/Object;)Landroidx/collection/FloatObjectMap;", "key2", "value2", "(FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/FloatObjectMap;", "key3", "value3", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/FloatObjectMap;", "key4", "value4", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/FloatObjectMap;", "key5", "value5", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/FloatObjectMap;", "mutableFloatObjectMapOf", "(FLjava/lang/Object;)Landroidx/collection/MutableFloatObjectMap;", "(FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/MutableFloatObjectMap;", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/MutableFloatObjectMap;", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/MutableFloatObjectMap;", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/MutableFloatObjectMap;", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class FloatObjectMapKt {
    private static final MutableFloatObjectMap EmptyFloatObjectMap;

    static {
        FloatObjectMapKt.EmptyFloatObjectMap = new MutableFloatObjectMap(0);
    }

    public static final FloatObjectMap buildFloatObjectMap(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(arg1);
        arg2.invoke(v0);
        return ((FloatObjectMap)v0);
    }

    public static final FloatObjectMap buildFloatObjectMap(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        arg4.invoke(v0);
        return ((FloatObjectMap)v0);
    }

    public static final FloatObjectMap emptyFloatObjectMap() {
        MutableFloatObjectMap v0 = FloatObjectMapKt.EmptyFloatObjectMap;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.FloatObjectMap<V of androidx.collection.FloatObjectMapKt.emptyFloatObjectMap>");
        return ((FloatObjectMap)v0);
    }

    public static final FloatObjectMap floatObjectMapOf() {
        MutableFloatObjectMap v0 = FloatObjectMapKt.EmptyFloatObjectMap;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.FloatObjectMap<V of androidx.collection.FloatObjectMapKt.floatObjectMapOf>");
        return ((FloatObjectMap)v0);
    }

    public static final FloatObjectMap floatObjectMapOf(float arg4, Object arg5) {
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        v0.set(arg4, arg5);
        return ((FloatObjectMap)v0);
    }

    public static final FloatObjectMap floatObjectMapOf(float arg4, Object arg5, float arg6, Object arg7) {
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        return ((FloatObjectMap)v0);
    }

    public static final FloatObjectMap floatObjectMapOf(float arg4, Object arg5, float arg6, Object arg7, float arg8, Object arg9) {
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        return ((FloatObjectMap)v0);
    }

    public static final FloatObjectMap floatObjectMapOf(float arg4, Object arg5, float arg6, Object arg7, float arg8, Object arg9, float arg10, Object arg11) {
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        return ((FloatObjectMap)v0);
    }

    public static final FloatObjectMap floatObjectMapOf(float arg4, Object arg5, float arg6, Object arg7, float arg8, Object arg9, float arg10, Object arg11, float arg12, Object arg13) {
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        v0.set(arg12, arg13);
        return ((FloatObjectMap)v0);
    }

    public static final MutableFloatObjectMap mutableFloatObjectMapOf() {
        return new MutableFloatObjectMap(0, 1, null);
    }

    public static final MutableFloatObjectMap mutableFloatObjectMapOf(float arg4, Object arg5) {
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        v0.set(arg4, arg5);
        return v0;
    }

    public static final MutableFloatObjectMap mutableFloatObjectMapOf(float arg4, Object arg5, float arg6, Object arg7) {
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        return v0;
    }

    public static final MutableFloatObjectMap mutableFloatObjectMapOf(float arg4, Object arg5, float arg6, Object arg7, float arg8, Object arg9) {
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        return v0;
    }

    public static final MutableFloatObjectMap mutableFloatObjectMapOf(float arg4, Object arg5, float arg6, Object arg7, float arg8, Object arg9, float arg10, Object arg11) {
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        return v0;
    }

    public static final MutableFloatObjectMap mutableFloatObjectMapOf(float arg4, Object arg5, float arg6, Object arg7, float arg8, Object arg9, float arg10, Object arg11, float arg12, Object arg13) {
        MutableFloatObjectMap v0 = new MutableFloatObjectMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        v0.set(arg12, arg13);
        return v0;
    }
}

