package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000B\u001A2\u0010\u0002\u001A\u00020\u00032\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0002\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\n\u001A\u00020\u0003\u001A\u0006\u0010\u000B\u001A\u00020\u0003\u001A\u0016\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r\u001A&\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r\u001A6\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r\u001AF\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r\u001AV\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\r\u001A\u0006\u0010\u0017\u001A\u00020\u0001\u001A\u0016\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r\u001A&\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r\u001A6\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r\u001AF\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r\u001AV\u0010\u0017\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\r\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2={"EmptyLongLongMap", "Landroidx/collection/MutableLongLongMap;", "buildLongLongMap", "Landroidx/collection/LongLongMap;", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyLongLongMap", "longLongMapOf", "key1", "", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableLongLongMapOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class LongLongMapKt {
    private static final MutableLongLongMap EmptyLongLongMap;

    static {
        LongLongMapKt.EmptyLongLongMap = new MutableLongLongMap(0);
    }

    public static final LongLongMap buildLongLongMap(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableLongLongMap v0 = new MutableLongLongMap(arg1);
        arg2.invoke(v0);
        return ((LongLongMap)v0);
    }

    public static final LongLongMap buildLongLongMap(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        arg4.invoke(v0);
        return ((LongLongMap)v0);
    }

    public static final LongLongMap emptyLongLongMap() {
        return LongLongMapKt.EmptyLongLongMap;
    }

    public static final LongLongMap longLongMapOf() {
        return LongLongMapKt.EmptyLongLongMap;
    }

    public static final LongLongMap longLongMapOf(long arg4, long arg6) {
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        v0.set(arg4, arg6);
        return ((LongLongMap)v0);
    }

    public static final LongLongMap longLongMapOf(long arg4, long arg6, long arg8, long arg10) {
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg8, arg10);
        return ((LongLongMap)v0);
    }

    public static final LongLongMap longLongMapOf(long arg4, long arg6, long arg8, long arg10, long arg12, long arg14) {
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg8, arg10);
        v0.set(arg12, arg14);
        return ((LongLongMap)v0);
    }

    public static final LongLongMap longLongMapOf(long arg4, long arg6, long arg8, long arg10, long arg12, long arg14, long arg16, long arg18) {
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg8, arg10);
        v0.set(arg12, arg14);
        v0.set(arg16, arg18);
        return ((LongLongMap)v0);
    }

    public static final LongLongMap longLongMapOf(long arg4, long arg6, long arg8, long arg10, long arg12, long arg14, long arg16, long arg18, long arg20, long arg22) {
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg8, arg10);
        v0.set(arg12, arg14);
        v0.set(arg16, arg18);
        v0.set(arg20, arg22);
        return ((LongLongMap)v0);
    }

    public static final MutableLongLongMap mutableLongLongMapOf() {
        return new MutableLongLongMap(0, 1, null);
    }

    public static final MutableLongLongMap mutableLongLongMapOf(long arg4, long arg6) {
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        v0.set(arg4, arg6);
        return v0;
    }

    public static final MutableLongLongMap mutableLongLongMapOf(long arg4, long arg6, long arg8, long arg10) {
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg8, arg10);
        return v0;
    }

    public static final MutableLongLongMap mutableLongLongMapOf(long arg4, long arg6, long arg8, long arg10, long arg12, long arg14) {
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg8, arg10);
        v0.set(arg12, arg14);
        return v0;
    }

    public static final MutableLongLongMap mutableLongLongMapOf(long arg4, long arg6, long arg8, long arg10, long arg12, long arg14, long arg16, long arg18) {
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg8, arg10);
        v0.set(arg12, arg14);
        v0.set(arg16, arg18);
        return v0;
    }

    public static final MutableLongLongMap mutableLongLongMapOf(long arg4, long arg6, long arg8, long arg10, long arg12, long arg14, long arg16, long arg18, long arg20, long arg22) {
        MutableLongLongMap v0 = new MutableLongLongMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg8, arg10);
        v0.set(arg12, arg14);
        v0.set(arg16, arg18);
        v0.set(arg20, arg22);
        return v0;
    }
}

