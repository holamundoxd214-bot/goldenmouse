package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\u001A2\u0010\u0002\u001A\u00020\u00012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0002\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\n\u001A\u00020\u0001\u001A\u0006\u0010\u000B\u001A\u00020\u0001\u001A\u000E\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r\u001A\u0016\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r\u001A\u001E\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r\u001A\u0012\u0010\u000B\u001A\u00020\u00012\n\u0010\u0010\u001A\u00020\u0011\"\u00020\r\u001A\t\u0010\u0012\u001A\u00020\u0005H\u0086\b\u001A\u000E\u0010\u0012\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r\u001A\u0016\u0010\u0012\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r\u001A\u001E\u0010\u0012\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r\u001A\u0015\u0010\u0012\u001A\u00020\u00052\n\u0010\u0010\u001A\u00020\u0011\"\u00020\rH\u0086\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2={"EmptyLongList", "Landroidx/collection/LongList;", "buildLongList", "builderAction", "Lkotlin/Function1;", "Landroidx/collection/MutableLongList;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyLongList", "longListOf", "element1", "", "element2", "element3", "elements", "", "mutableLongListOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class LongListKt {
    private static final LongList EmptyLongList;

    static {
        LongListKt.EmptyLongList = new MutableLongList(0);
    }

    public static final LongList buildLongList(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableLongList v0 = new MutableLongList(arg1);
        arg2.invoke(v0);
        return ((LongList)v0);
    }

    public static final LongList buildLongList(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableLongList v0 = new MutableLongList(0, 1, null);
        arg4.invoke(v0);
        return ((LongList)v0);
    }

    public static final LongList emptyLongList() {
        return LongListKt.EmptyLongList;
    }

    public static final LongList longListOf() {
        return LongListKt.EmptyLongList;
    }

    public static final LongList longListOf(long arg0) {
        return LongListKt.mutableLongListOf(arg0);
    }

    public static final LongList longListOf(long arg0, long arg2) {
        return LongListKt.mutableLongListOf(arg0, arg2);
    }

    public static final LongList longListOf(long arg0, long arg2, long arg4) {
        return LongListKt.mutableLongListOf(arg0, arg2, arg4);
    }

    public static final LongList longListOf(long[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableLongList v0 = new MutableLongList(arg2.length);
        v0.addAll(v0._size, arg2);
        return ((LongList)v0);
    }

    public static final MutableLongList mutableLongListOf(long arg2) {
        MutableLongList v0 = new MutableLongList(1);
        v0.add(arg2);
        return v0;
    }

    public static final MutableLongList mutableLongListOf(long arg2, long arg4) {
        MutableLongList v0 = new MutableLongList(2);
        v0.add(arg2);
        v0.add(arg4);
        return v0;
    }

    public static final MutableLongList mutableLongListOf(long arg2, long arg4, long arg6) {
        MutableLongList v0 = new MutableLongList(3);
        v0.add(arg2);
        v0.add(arg4);
        v0.add(arg6);
        return v0;
    }

    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, null);
    }

    public static final MutableLongList mutableLongListOf(long[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableLongList v0 = new MutableLongList(arg2.length);
        v0.addAll(v0._size, arg2);
        return v0;
    }
}

