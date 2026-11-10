package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000B\u001A2\u0010\u0002\u001A\u00020\u00032\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0002\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\n\u001A\u00020\u0003\u001A\u0006\u0010\u000B\u001A\u00020\u0003\u001A\u0016\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r\u001A&\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r\u001A6\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r\u001AF\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r\u001AV\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\r\u001A\u0006\u0010\u0017\u001A\u00020\u0001\u001A\u0016\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r\u001A&\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r\u001A6\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r\u001AF\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r\u001AV\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\r\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2={"EmptyFloatFloatMap", "Landroidx/collection/MutableFloatFloatMap;", "buildFloatFloatMap", "Landroidx/collection/FloatFloatMap;", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyFloatFloatMap", "floatFloatMapOf", "key1", "", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatFloatMapOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class FloatFloatMapKt {
    private static final MutableFloatFloatMap EmptyFloatFloatMap;

    static {
        FloatFloatMapKt.EmptyFloatFloatMap = new MutableFloatFloatMap(0);
    }

    public static final FloatFloatMap buildFloatFloatMap(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(arg1);
        arg2.invoke(v0);
        return ((FloatFloatMap)v0);
    }

    public static final FloatFloatMap buildFloatFloatMap(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        arg4.invoke(v0);
        return ((FloatFloatMap)v0);
    }

    public static final FloatFloatMap emptyFloatFloatMap() {
        return FloatFloatMapKt.EmptyFloatFloatMap;
    }

    public static final FloatFloatMap floatFloatMapOf() {
        return FloatFloatMapKt.EmptyFloatFloatMap;
    }

    public static final FloatFloatMap floatFloatMapOf(float arg4, float arg5) {
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        return ((FloatFloatMap)v0);
    }

    public static final FloatFloatMap floatFloatMapOf(float arg4, float arg5, float arg6, float arg7) {
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        return ((FloatFloatMap)v0);
    }

    public static final FloatFloatMap floatFloatMapOf(float arg4, float arg5, float arg6, float arg7, float arg8, float arg9) {
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        return ((FloatFloatMap)v0);
    }

    public static final FloatFloatMap floatFloatMapOf(float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, float arg11) {
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        return ((FloatFloatMap)v0);
    }

    public static final FloatFloatMap floatFloatMapOf(float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, float arg11, float arg12, float arg13) {
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        v0.set(arg12, arg13);
        return ((FloatFloatMap)v0);
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf() {
        return new MutableFloatFloatMap(0, 1, null);
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float arg4, float arg5) {
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        return v0;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float arg4, float arg5, float arg6, float arg7) {
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        return v0;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float arg4, float arg5, float arg6, float arg7, float arg8, float arg9) {
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        return v0;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, float arg11) {
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        return v0;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, float arg11, float arg12, float arg13) {
        MutableFloatFloatMap v0 = new MutableFloatFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        v0.set(arg12, arg13);
        return v0;
    }
}

