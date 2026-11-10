package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0007\u001A\u0012\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001A\u0012\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001A\u001F\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001A\u0002H\u0005¢\u0006\u0002\u0010\b\u001A\'\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001A\u0002H\u00052\u0006\u0010\t\u001A\u0002H\u0005¢\u0006\u0002\u0010\n\u001A/\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001A\u0002H\u00052\u0006\u0010\t\u001A\u0002H\u00052\u0006\u0010\u000B\u001A\u0002H\u0005¢\u0006\u0002\u0010\f\u001A+\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0012\u0010\r\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u000E\"\u0002H\u0005¢\u0006\u0002\u0010\u000F\u001A\u0012\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001A\u001F\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001A\u0002H\u0005¢\u0006\u0002\u0010\u0011\u001A\'\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001A\u0002H\u00052\u0006\u0010\t\u001A\u0002H\u0005¢\u0006\u0002\u0010\u0012\u001A/\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001A\u0002H\u00052\u0006\u0010\t\u001A\u0002H\u00052\u0006\u0010\u000B\u001A\u0002H\u0005¢\u0006\u0002\u0010\u0013\u001A+\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\r\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u000E\"\u0002H\u0005¢\u0006\u0002\u0010\u0014\"\u0016\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"EmptyScatterSet", "Landroidx/collection/MutableScatterSet;", "", "emptyScatterSet", "Landroidx/collection/ScatterSet;", "E", "mutableScatterSetOf", "element1", "(Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "element2", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "element3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "elements", "", "([Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "scatterSetOf", "(Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "([Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class ScatterSetKt {
    private static final MutableScatterSet EmptyScatterSet;

    static {
        ScatterSetKt.EmptyScatterSet = new MutableScatterSet(0);
    }

    public static final ScatterSet emptyScatterSet() {
        MutableScatterSet v0 = ScatterSetKt.EmptyScatterSet;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.emptyScatterSet>");
        return ((ScatterSet)v0);
    }

    public static final MutableScatterSet mutableScatterSetOf() {
        return new MutableScatterSet(0, 1, null);
    }

    public static final MutableScatterSet mutableScatterSetOf(Object arg2) {
        MutableScatterSet v0 = new MutableScatterSet(1);
        v0.plusAssign(arg2);
        return v0;
    }

    public static final MutableScatterSet mutableScatterSetOf(Object arg2, Object arg3) {
        MutableScatterSet v0 = new MutableScatterSet(2);
        v0.plusAssign(arg2);
        v0.plusAssign(arg3);
        return v0;
    }

    public static final MutableScatterSet mutableScatterSetOf(Object arg2, Object arg3, Object arg4) {
        MutableScatterSet v0 = new MutableScatterSet(3);
        v0.plusAssign(arg2);
        v0.plusAssign(arg3);
        v0.plusAssign(arg4);
        return v0;
    }

    public static final MutableScatterSet mutableScatterSetOf(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableScatterSet v0 = new MutableScatterSet(arg2.length);
        v0.plusAssign(arg2);
        return v0;
    }

    public static final ScatterSet scatterSetOf() {
        MutableScatterSet v0 = ScatterSetKt.EmptyScatterSet;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.scatterSetOf>");
        return ((ScatterSet)v0);
    }

    public static final ScatterSet scatterSetOf(Object arg0) {
        return ScatterSetKt.mutableScatterSetOf(arg0);
    }

    public static final ScatterSet scatterSetOf(Object arg0, Object arg1) {
        return ScatterSetKt.mutableScatterSetOf(arg0, arg1);
    }

    public static final ScatterSet scatterSetOf(Object arg0, Object arg1, Object arg2) {
        return ScatterSetKt.mutableScatterSetOf(arg0, arg1, arg2);
    }

    public static final ScatterSet scatterSetOf(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableScatterSet v0 = new MutableScatterSet(arg2.length);
        v0.plusAssign(arg2);
        return ((ScatterSet)v0);
    }
}

