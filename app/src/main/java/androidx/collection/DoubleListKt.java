package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0003\u001A2\u0010\u0002\u001A\u00020\u00012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0002\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\n\u001A\u00020\u0001\u001A\u000E\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\f\u001A\u0016\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f\u001A\u001E\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f\u001A\u0012\u0010\n\u001A\u00020\u00012\n\u0010\u000F\u001A\u00020\u0010\"\u00020\f\u001A\u0006\u0010\u0011\u001A\u00020\u0001\u001A\t\u0010\u0012\u001A\u00020\u0005H\u0086\b\u001A\u000E\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f\u001A\u0016\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f\u001A\u001E\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f\u001A\u0015\u0010\u0012\u001A\u00020\u00052\n\u0010\u000F\u001A\u00020\u0010\"\u00020\fH\u0086\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2={"EmptyDoubleList", "Landroidx/collection/DoubleList;", "buildDoubleList", "builderAction", "Lkotlin/Function1;", "Landroidx/collection/MutableDoubleList;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "doubleListOf", "element1", "", "element2", "element3", "elements", "", "emptyDoubleList", "mutableDoubleListOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class DoubleListKt {
    private static final DoubleList EmptyDoubleList;

    static {
        DoubleListKt.EmptyDoubleList = new MutableDoubleList(0);
    }

    public static final DoubleList buildDoubleList(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableDoubleList v0 = new MutableDoubleList(arg1);
        arg2.invoke(v0);
        return ((DoubleList)v0);
    }

    public static final DoubleList buildDoubleList(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableDoubleList v0 = new MutableDoubleList(0, 1, null);
        arg4.invoke(v0);
        return ((DoubleList)v0);
    }

    public static final DoubleList doubleListOf() {
        return DoubleListKt.EmptyDoubleList;
    }

    public static final DoubleList doubleListOf(double arg0) {
        return DoubleListKt.mutableDoubleListOf(arg0);
    }

    public static final DoubleList doubleListOf(double arg0, double arg2) {
        return DoubleListKt.mutableDoubleListOf(arg0, arg2);
    }

    public static final DoubleList doubleListOf(double arg0, double arg2, double arg4) {
        return DoubleListKt.mutableDoubleListOf(arg0, arg2, arg4);
    }

    public static final DoubleList doubleListOf(double[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableDoubleList v0 = new MutableDoubleList(arg2.length);
        v0.addAll(v0._size, arg2);
        return ((DoubleList)v0);
    }

    public static final DoubleList emptyDoubleList() {
        return DoubleListKt.EmptyDoubleList;
    }

    public static final MutableDoubleList mutableDoubleListOf(double arg2) {
        MutableDoubleList v0 = new MutableDoubleList(1);
        v0.add(arg2);
        return v0;
    }

    public static final MutableDoubleList mutableDoubleListOf(double arg2, double arg4) {
        MutableDoubleList v0 = new MutableDoubleList(2);
        v0.add(arg2);
        v0.add(arg4);
        return v0;
    }

    public static final MutableDoubleList mutableDoubleListOf(double arg2, double arg4, double arg6) {
        MutableDoubleList v0 = new MutableDoubleList(3);
        v0.add(arg2);
        v0.add(arg4);
        v0.add(arg6);
        return v0;
    }

    public static final MutableDoubleList mutableDoubleListOf() {
        return new MutableDoubleList(0, 1, null);
    }

    public static final MutableDoubleList mutableDoubleListOf(double[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableDoubleList v0 = new MutableDoubleList(arg2.length);
        v0.addAll(v0._size, arg2);
        return v0;
    }
}

