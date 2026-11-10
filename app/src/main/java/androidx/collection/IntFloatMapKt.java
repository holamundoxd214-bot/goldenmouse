package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\u001A2\u0010\u0002\u001A\u00020\u00032\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0002\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\n\u001A\u00020\u0003\u001A\u0006\u0010\u000B\u001A\u00020\u0003\u001A\u0016\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E\u001A&\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000E\u001A6\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000E\u001AF\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u000E\u001AV\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u000E\u001A\u0006\u0010\u0017\u001A\u00020\u0001\u001A\u0016\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E\u001A&\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000E\u001A6\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000E\u001AF\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u000E\u001AV\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u000E\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2={"EmptyIntFloatMap", "Landroidx/collection/MutableIntFloatMap;", "buildIntFloatMap", "Landroidx/collection/IntFloatMap;", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyIntFloatMap", "intFloatMapOf", "key1", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableIntFloatMapOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class IntFloatMapKt {
    private static final MutableIntFloatMap EmptyIntFloatMap;

    static {
        IntFloatMapKt.EmptyIntFloatMap = new MutableIntFloatMap(0);
    }

    public static final IntFloatMap buildIntFloatMap(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableIntFloatMap v0 = new MutableIntFloatMap(arg1);
        arg2.invoke(v0);
        return ((IntFloatMap)v0);
    }

    public static final IntFloatMap buildIntFloatMap(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        arg4.invoke(v0);
        return ((IntFloatMap)v0);
    }

    public static final IntFloatMap emptyIntFloatMap() {
        return IntFloatMapKt.EmptyIntFloatMap;
    }

    public static final IntFloatMap intFloatMapOf() {
        return IntFloatMapKt.EmptyIntFloatMap;
    }

    public static final IntFloatMap intFloatMapOf(int arg4, float arg5) {
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        return ((IntFloatMap)v0);
    }

    public static final IntFloatMap intFloatMapOf(int arg4, float arg5, int arg6, float arg7) {
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        return ((IntFloatMap)v0);
    }

    public static final IntFloatMap intFloatMapOf(int arg4, float arg5, int arg6, float arg7, int arg8, float arg9) {
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        return ((IntFloatMap)v0);
    }

    public static final IntFloatMap intFloatMapOf(int arg4, float arg5, int arg6, float arg7, int arg8, float arg9, int arg10, float arg11) {
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        return ((IntFloatMap)v0);
    }

    public static final IntFloatMap intFloatMapOf(int arg4, float arg5, int arg6, float arg7, int arg8, float arg9, int arg10, float arg11, int arg12, float arg13) {
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        v0.set(arg12, arg13);
        return ((IntFloatMap)v0);
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf() {
        return new MutableIntFloatMap(0, 1, null);
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int arg4, float arg5) {
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        return v0;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int arg4, float arg5, int arg6, float arg7) {
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        return v0;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int arg4, float arg5, int arg6, float arg7, int arg8, float arg9) {
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        return v0;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int arg4, float arg5, int arg6, float arg7, int arg8, float arg9, int arg10, float arg11) {
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        return v0;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int arg4, float arg5, int arg6, float arg7, int arg8, float arg9, int arg10, float arg11, int arg12, float arg13) {
        MutableIntFloatMap v0 = new MutableIntFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        v0.set(arg12, arg13);
        return v0;
    }
}

