package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u001A2\u0010\u0006\u001A\u00020\u00072\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\u000E\u001A\u00020\u0007\u001A\u0011\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\rH\u0080\b\u001A\u0006\u0010\u0011\u001A\u00020\u0007\u001A\u000E\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\r\u001A\u0016\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r\u001A\u001E\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r\u001A\u0012\u0010\u0011\u001A\u00020\u00072\n\u0010\u0015\u001A\u00020\u0001\"\u00020\r\u001A\u0006\u0010\u0016\u001A\u00020\u0005\u001A\u000E\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\r\u001A\u0016\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r\u001A\u001E\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r\u001A\u0012\u0010\u0016\u001A\u00020\u00052\n\u0010\u0015\u001A\u00020\u0001\"\u00020\r\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2={"EmptyIntArray", "", "getEmptyIntArray", "()[I", "EmptyIntSet", "Landroidx/collection/MutableIntSet;", "buildIntSet", "Landroidx/collection/IntSet;", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyIntSet", "hash", "k", "intSetOf", "element1", "element2", "element3", "elements", "mutableIntSetOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class IntSetKt {
    private static final int[] EmptyIntArray;
    private static final MutableIntSet EmptyIntSet;

    static {
        IntSetKt.EmptyIntSet = new MutableIntSet(0);
        IntSetKt.EmptyIntArray = new int[0];
    }

    public static final IntSet buildIntSet(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableIntSet v0 = new MutableIntSet(arg1);
        arg2.invoke(v0);
        return ((IntSet)v0);
    }

    public static final IntSet buildIntSet(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableIntSet v0 = new MutableIntSet(0, 1, null);
        arg4.invoke(v0);
        return ((IntSet)v0);
    }

    public static final IntSet emptyIntSet() {
        return IntSetKt.EmptyIntSet;
    }

    public static final int[] getEmptyIntArray() {
        return IntSetKt.EmptyIntArray;
    }

    public static final int hash(int arg1) {
        arg1 = Integer.hashCode(arg1) * 0xCC9E2D51;
        return arg1 ^ arg1 << 16;
    }

    public static final IntSet intSetOf() {
        return IntSetKt.EmptyIntSet;
    }

    public static final IntSet intSetOf(int arg0) {
        return IntSetKt.mutableIntSetOf(arg0);
    }

    public static final IntSet intSetOf(int arg0, int arg1) {
        return IntSetKt.mutableIntSetOf(arg0, arg1);
    }

    public static final IntSet intSetOf(int arg0, int arg1, int arg2) {
        return IntSetKt.mutableIntSetOf(arg0, arg1, arg2);
    }

    public static final IntSet intSetOf(int[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableIntSet v0 = new MutableIntSet(arg2.length);
        v0.plusAssign(arg2);
        return ((IntSet)v0);
    }

    public static final MutableIntSet mutableIntSetOf(int arg2) {
        MutableIntSet v0 = new MutableIntSet(1);
        v0.plusAssign(arg2);
        return v0;
    }

    public static final MutableIntSet mutableIntSetOf(int arg2, int arg3) {
        MutableIntSet v0 = new MutableIntSet(2);
        v0.plusAssign(arg2);
        v0.plusAssign(arg3);
        return v0;
    }

    public static final MutableIntSet mutableIntSetOf(int arg2, int arg3, int arg4) {
        MutableIntSet v0 = new MutableIntSet(3);
        v0.plusAssign(arg2);
        v0.plusAssign(arg3);
        v0.plusAssign(arg4);
        return v0;
    }

    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }

    public static final MutableIntSet mutableIntSetOf(int[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableIntSet v0 = new MutableIntSet(arg2.length);
        v0.plusAssign(arg2);
        return v0;
    }
}

