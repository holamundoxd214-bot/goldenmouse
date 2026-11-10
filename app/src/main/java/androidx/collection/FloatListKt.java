package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\u001A2\u0010\u0002\u001A\u00020\u00012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0002\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\n\u001A\u00020\u0001\u001A\u0006\u0010\u000B\u001A\u00020\u0001\u001A\u000E\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r\u001A\u0016\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r\u001A\u001E\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r\u001A\u0012\u0010\u000B\u001A\u00020\u00012\n\u0010\u0010\u001A\u00020\u0011\"\u00020\r\u001A\t\u0010\u0012\u001A\u00020\u0005H\u0086\b\u001A\u000E\u0010\u0012\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r\u001A\u0016\u0010\u0012\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r\u001A\u001E\u0010\u0012\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r\u001A\u0015\u0010\u0012\u001A\u00020\u00052\n\u0010\u0010\u001A\u00020\u0011\"\u00020\rH\u0086\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2={"EmptyFloatList", "Landroidx/collection/FloatList;", "buildFloatList", "builderAction", "Lkotlin/Function1;", "Landroidx/collection/MutableFloatList;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyFloatList", "floatListOf", "element1", "", "element2", "element3", "elements", "", "mutableFloatListOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class FloatListKt {
    private static final FloatList EmptyFloatList;

    static {
        FloatListKt.EmptyFloatList = new MutableFloatList(0);
    }

    public static final FloatList buildFloatList(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableFloatList v0 = new MutableFloatList(arg1);
        arg2.invoke(v0);
        return ((FloatList)v0);
    }

    public static final FloatList buildFloatList(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableFloatList v0 = new MutableFloatList(0, 1, null);
        arg4.invoke(v0);
        return ((FloatList)v0);
    }

    public static final FloatList emptyFloatList() {
        return FloatListKt.EmptyFloatList;
    }

    public static final FloatList floatListOf() {
        return FloatListKt.EmptyFloatList;
    }

    public static final FloatList floatListOf(float arg0) {
        return FloatListKt.mutableFloatListOf(arg0);
    }

    public static final FloatList floatListOf(float arg0, float arg1) {
        return FloatListKt.mutableFloatListOf(arg0, arg1);
    }

    public static final FloatList floatListOf(float arg0, float arg1, float arg2) {
        return FloatListKt.mutableFloatListOf(arg0, arg1, arg2);
    }

    public static final FloatList floatListOf(float[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableFloatList v0 = new MutableFloatList(arg2.length);
        v0.addAll(v0._size, arg2);
        return ((FloatList)v0);
    }

    public static final MutableFloatList mutableFloatListOf(float arg2) {
        MutableFloatList v0 = new MutableFloatList(1);
        v0.add(arg2);
        return v0;
    }

    public static final MutableFloatList mutableFloatListOf(float arg2, float arg3) {
        MutableFloatList v0 = new MutableFloatList(2);
        v0.add(arg2);
        v0.add(arg3);
        return v0;
    }

    public static final MutableFloatList mutableFloatListOf(float arg2, float arg3, float arg4) {
        MutableFloatList v0 = new MutableFloatList(3);
        v0.add(arg2);
        v0.add(arg3);
        v0.add(arg4);
        return v0;
    }

    public static final MutableFloatList mutableFloatListOf() {
        return new MutableFloatList(0, 1, null);
    }

    public static final MutableFloatList mutableFloatListOf(float[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableFloatList v0 = new MutableFloatList(arg2.length);
        v0.addAll(v0._size, arg2);
        return v0;
    }
}

