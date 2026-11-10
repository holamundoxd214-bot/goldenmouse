package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u001A2\u0010\u0006\u001A\u00020\u00072\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\u000E\u001A\u00020\u0007\u001A\u0011\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0011H\u0080\b\u001A\u0006\u0010\u0012\u001A\u00020\u0007\u001A\u000E\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0011\u001A\u0016\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0011\u001A\u001E\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0011\u001A\u0012\u0010\u0012\u001A\u00020\u00072\n\u0010\u0016\u001A\u00020\u0001\"\u00020\u0011\u001A\u0006\u0010\u0017\u001A\u00020\u0005\u001A\u000E\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u0011\u001A\u0016\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0011\u001A\u001E\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0011\u001A\u0012\u0010\u0017\u001A\u00020\u00052\n\u0010\u0016\u001A\u00020\u0001\"\u00020\u0011\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2={"EmptyLongArray", "", "getEmptyLongArray", "()[J", "EmptyLongSet", "Landroidx/collection/MutableLongSet;", "buildLongSet", "Landroidx/collection/LongSet;", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyLongSet", "hash", "k", "", "longSetOf", "element1", "element2", "element3", "elements", "mutableLongSetOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class LongSetKt {
    private static final long[] EmptyLongArray;
    private static final MutableLongSet EmptyLongSet;

    static {
        LongSetKt.EmptyLongSet = new MutableLongSet(0);
        LongSetKt.EmptyLongArray = new long[0];
    }

    public static final LongSet buildLongSet(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableLongSet v0 = new MutableLongSet(arg1);
        arg2.invoke(v0);
        return ((LongSet)v0);
    }

    public static final LongSet buildLongSet(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableLongSet v0 = new MutableLongSet(0, 1, null);
        arg4.invoke(v0);
        return ((LongSet)v0);
    }

    public static final LongSet emptyLongSet() {
        return LongSetKt.EmptyLongSet;
    }

    public static final long[] getEmptyLongArray() {
        return LongSetKt.EmptyLongArray;
    }

    public static final int hash(long arg0) {
        int v0 = Long.hashCode(arg0) * 0xCC9E2D51;
        return v0 ^ v0 << 16;
    }

    public static final LongSet longSetOf() {
        return LongSetKt.EmptyLongSet;
    }

    public static final LongSet longSetOf(long arg0) {
        return LongSetKt.mutableLongSetOf(arg0);
    }

    public static final LongSet longSetOf(long arg0, long arg2) {
        return LongSetKt.mutableLongSetOf(arg0, arg2);
    }

    public static final LongSet longSetOf(long arg0, long arg2, long arg4) {
        return LongSetKt.mutableLongSetOf(arg0, arg2, arg4);
    }

    public static final LongSet longSetOf(long[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableLongSet v0 = new MutableLongSet(arg2.length);
        v0.plusAssign(arg2);
        return ((LongSet)v0);
    }

    public static final MutableLongSet mutableLongSetOf(long arg2) {
        MutableLongSet v0 = new MutableLongSet(1);
        v0.plusAssign(arg2);
        return v0;
    }

    public static final MutableLongSet mutableLongSetOf(long arg2, long arg4) {
        MutableLongSet v0 = new MutableLongSet(2);
        v0.plusAssign(arg2);
        v0.plusAssign(arg4);
        return v0;
    }

    public static final MutableLongSet mutableLongSetOf(long arg2, long arg4, long arg6) {
        MutableLongSet v0 = new MutableLongSet(3);
        v0.plusAssign(arg2);
        v0.plusAssign(arg4);
        v0.plusAssign(arg6);
        return v0;
    }

    public static final MutableLongSet mutableLongSetOf() {
        return new MutableLongSet(0, 1, null);
    }

    public static final MutableLongSet mutableLongSetOf(long[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableLongSet v0 = new MutableLongSet(arg2.length);
        v0.plusAssign(arg2);
        return v0;
    }
}

