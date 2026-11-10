package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u001A2\u0010\u0006\u001A\u00020\u00072\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A:\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0006\u0010\u000E\u001A\u00020\u0007\u001A\u0006\u0010\u000F\u001A\u00020\u0007\u001A\u000E\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0011\u001A\u0016\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011\u001A\u001E\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0011\u001A\u0012\u0010\u000F\u001A\u00020\u00072\n\u0010\u0014\u001A\u00020\u0001\"\u00020\u0011\u001A\u0011\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u0011H\u0080\b\u001A\u0006\u0010\u0017\u001A\u00020\u0005\u001A\u000E\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0011\u001A\u0016\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011\u001A\u001E\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0011\u001A\u0012\u0010\u0017\u001A\u00020\u00052\n\u0010\u0014\u001A\u00020\u0001\"\u00020\u0011\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2={"EmptyFloatArray", "", "getEmptyFloatArray", "()[F", "EmptyFloatSet", "Landroidx/collection/MutableFloatSet;", "buildFloatSet", "Landroidx/collection/FloatSet;", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyFloatSet", "floatSetOf", "element1", "", "element2", "element3", "elements", "hash", "k", "mutableFloatSetOf", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class FloatSetKt {
    private static final float[] EmptyFloatArray;
    private static final MutableFloatSet EmptyFloatSet;

    static {
        FloatSetKt.EmptyFloatSet = new MutableFloatSet(0);
        FloatSetKt.EmptyFloatArray = new float[0];
    }

    public static final FloatSet buildFloatSet(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableFloatSet v0 = new MutableFloatSet(arg1);
        arg2.invoke(v0);
        return ((FloatSet)v0);
    }

    public static final FloatSet buildFloatSet(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableFloatSet v0 = new MutableFloatSet(0, 1, null);
        arg4.invoke(v0);
        return ((FloatSet)v0);
    }

    public static final FloatSet emptyFloatSet() {
        return FloatSetKt.EmptyFloatSet;
    }

    public static final FloatSet floatSetOf() {
        return FloatSetKt.EmptyFloatSet;
    }

    public static final FloatSet floatSetOf(float arg0) {
        return FloatSetKt.mutableFloatSetOf(arg0);
    }

    public static final FloatSet floatSetOf(float arg0, float arg1) {
        return FloatSetKt.mutableFloatSetOf(arg0, arg1);
    }

    public static final FloatSet floatSetOf(float arg0, float arg1, float arg2) {
        return FloatSetKt.mutableFloatSetOf(arg0, arg1, arg2);
    }

    public static final FloatSet floatSetOf(float[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableFloatSet v0 = new MutableFloatSet(arg2.length);
        v0.plusAssign(arg2);
        return ((FloatSet)v0);
    }

    public static final float[] getEmptyFloatArray() {
        return FloatSetKt.EmptyFloatArray;
    }

    public static final int hash(float arg1) {
        int v1 = Float.hashCode(arg1) * 0xCC9E2D51;
        return v1 ^ v1 << 16;
    }

    public static final MutableFloatSet mutableFloatSetOf(float arg2) {
        MutableFloatSet v0 = new MutableFloatSet(1);
        v0.plusAssign(arg2);
        return v0;
    }

    public static final MutableFloatSet mutableFloatSetOf(float arg2, float arg3) {
        MutableFloatSet v0 = new MutableFloatSet(2);
        v0.plusAssign(arg2);
        v0.plusAssign(arg3);
        return v0;
    }

    public static final MutableFloatSet mutableFloatSetOf(float arg2, float arg3, float arg4) {
        MutableFloatSet v0 = new MutableFloatSet(3);
        v0.plusAssign(arg2);
        v0.plusAssign(arg3);
        v0.plusAssign(arg4);
        return v0;
    }

    public static final MutableFloatSet mutableFloatSetOf() {
        return new MutableFloatSet(0, 1, null);
    }

    public static final MutableFloatSet mutableFloatSetOf(float[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableFloatSet v0 = new MutableFloatSet(arg2.length);
        v0.plusAssign(arg2);
        return v0;
    }
}

