package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u001A2\u0010\u0002\u001A\u00020\u00032\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0002\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\n\u001A\u00020\u0003\u001A\u0006\u0010\u000B\u001A\u00020\u0003\u001A\u0016\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F\u001A&\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u000F\u001A6\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u000F\u001AF\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u000F\u001AV\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u000F\u001A\u0006\u0010\u0018\u001A\u00020\u0001\u001A\u0016\u0010\u0018\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F\u001A&\u0010\u0018\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u000F\u001A6\u0010\u0018\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u000F\u001AF\u0010\u0018\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u000F\u001AV\u0010\u0018\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u000F\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2={"EmptyLongFloatMap", "Landroidx/collection/MutableLongFloatMap;", "buildLongFloatMap", "Landroidx/collection/LongFloatMap;", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyLongFloatMap", "longFloatMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableLongFloatMapOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class LongFloatMapKt {
    private static final MutableLongFloatMap EmptyLongFloatMap;

    static {
        LongFloatMapKt.EmptyLongFloatMap = new MutableLongFloatMap(0);
    }

    public static final LongFloatMap buildLongFloatMap(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableLongFloatMap v0 = new MutableLongFloatMap(arg1);
        arg2.invoke(v0);
        return ((LongFloatMap)v0);
    }

    public static final LongFloatMap buildLongFloatMap(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        arg4.invoke(v0);
        return ((LongFloatMap)v0);
    }

    public static final LongFloatMap emptyLongFloatMap() {
        return LongFloatMapKt.EmptyLongFloatMap;
    }

    public static final LongFloatMap longFloatMapOf() {
        return LongFloatMapKt.EmptyLongFloatMap;
    }

    public static final LongFloatMap longFloatMapOf(long arg4, float arg6) {
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        v0.set(arg4, arg6);
        return ((LongFloatMap)v0);
    }

    public static final LongFloatMap longFloatMapOf(long arg4, float arg6, long arg7, float arg9) {
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        return ((LongFloatMap)v0);
    }

    public static final LongFloatMap longFloatMapOf(long arg4, float arg6, long arg7, float arg9, long arg10, float arg12) {
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        return ((LongFloatMap)v0);
    }

    public static final LongFloatMap longFloatMapOf(long arg4, float arg6, long arg7, float arg9, long arg10, float arg12, long arg13, float arg15) {
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        v0.set(arg13, arg15);
        return ((LongFloatMap)v0);
    }

    public static final LongFloatMap longFloatMapOf(long arg4, float arg6, long arg7, float arg9, long arg10, float arg12, long arg13, float arg15, long arg16, float arg18) {
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        v0.set(arg13, arg15);
        v0.set(arg16, arg18);
        return ((LongFloatMap)v0);
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf() {
        return new MutableLongFloatMap(0, 1, null);
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf(long arg4, float arg6) {
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        v0.set(arg4, arg6);
        return v0;
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf(long arg4, float arg6, long arg7, float arg9) {
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        return v0;
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf(long arg4, float arg6, long arg7, float arg9, long arg10, float arg12) {
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        return v0;
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf(long arg4, float arg6, long arg7, float arg9, long arg10, float arg12, long arg13, float arg15) {
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        v0.set(arg13, arg15);
        return v0;
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf(long arg4, float arg6, long arg7, float arg9, long arg10, float arg12, long arg13, float arg15, long arg16, float arg18) {
        MutableLongFloatMap v0 = new MutableLongFloatMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        v0.set(arg13, arg15);
        v0.set(arg16, arg18);
        return v0;
    }
}

