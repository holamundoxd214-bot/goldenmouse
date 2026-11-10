package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\u001A2\u0010\u0002\u001A\u00020\u00012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0002\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\n\u001A\u00020\u0001\u001A\u0006\u0010\u000B\u001A\u00020\u0001\u001A\u000E\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\t\u001A\u0016\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\t\u001A\u001E\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\t\u001A\u0012\u0010\u000B\u001A\u00020\u00012\n\u0010\u000F\u001A\u00020\u0010\"\u00020\t\u001A\t\u0010\u0011\u001A\u00020\u0005H\u0086\b\u001A\u000E\u0010\u0011\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\t\u001A\u0016\u0010\u0011\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\t\u001A\u001E\u0010\u0011\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\t\u001A\u0015\u0010\u0011\u001A\u00020\u00052\n\u0010\u000F\u001A\u00020\u0010\"\u00020\tH\u0086\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2={"EmptyIntList", "Landroidx/collection/IntList;", "buildIntList", "builderAction", "Lkotlin/Function1;", "Landroidx/collection/MutableIntList;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyIntList", "intListOf", "element1", "element2", "element3", "elements", "", "mutableIntListOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class IntListKt {
    private static final IntList EmptyIntList;

    static {
        IntListKt.EmptyIntList = new MutableIntList(0);
    }

    public static final IntList buildIntList(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableIntList v0 = new MutableIntList(arg1);
        arg2.invoke(v0);
        return ((IntList)v0);
    }

    public static final IntList buildIntList(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableIntList v0 = new MutableIntList(0, 1, null);
        arg4.invoke(v0);
        return ((IntList)v0);
    }

    public static final IntList emptyIntList() {
        return IntListKt.EmptyIntList;
    }

    public static final IntList intListOf() {
        return IntListKt.EmptyIntList;
    }

    public static final IntList intListOf(int arg0) {
        return IntListKt.mutableIntListOf(arg0);
    }

    public static final IntList intListOf(int arg0, int arg1) {
        return IntListKt.mutableIntListOf(arg0, arg1);
    }

    public static final IntList intListOf(int arg0, int arg1, int arg2) {
        return IntListKt.mutableIntListOf(arg0, arg1, arg2);
    }

    public static final IntList intListOf(int[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableIntList v0 = new MutableIntList(arg2.length);
        v0.addAll(v0._size, arg2);
        return ((IntList)v0);
    }

    public static final MutableIntList mutableIntListOf(int arg2) {
        MutableIntList v0 = new MutableIntList(1);
        v0.add(arg2);
        return v0;
    }

    public static final MutableIntList mutableIntListOf(int arg2, int arg3) {
        MutableIntList v0 = new MutableIntList(2);
        v0.add(arg2);
        v0.add(arg3);
        return v0;
    }

    public static final MutableIntList mutableIntListOf(int arg2, int arg3, int arg4) {
        MutableIntList v0 = new MutableIntList(3);
        v0.add(arg2);
        v0.add(arg3);
        v0.add(arg4);
        return v0;
    }

    public static final MutableIntList mutableIntListOf() {
        return new MutableIntList(0, 1, null);
    }

    public static final MutableIntList mutableIntListOf(int[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableIntList v0 = new MutableIntList(arg2.length);
        v0.addAll(v0._size, arg2);
        return v0;
    }
}

