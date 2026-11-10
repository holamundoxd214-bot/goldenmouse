package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000BB\u0019\b\u0016\u0012\u0006\u0010\f\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u0004\u0010\u000FJ\r\u0010\u0016\u001A\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0005J\u0015\u0010\u0018\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u0019\u0010\u000FJ\u0015\u0010\u001A\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u001B\u0010\u001CJ\u0015\u0010\u001D\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u001E\u0010\u001CJ5\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u0007¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001A\u00020\u0007HÖ\u0001J\t\u0010&\u001A\u00020\'HÖ\u0001R\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0006\u001A\u00020\u00078Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0012\u0010\b\u001A\u00020\u00078Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0012R\u0012\u0010\t\u001A\u00020\u00078Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0012R\u0012\u0010\n\u001A\u00020\u00078Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0012\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006("}, d2={"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "value", "Landroidx/compose/ui/unit/Constraints;", "constructor-impl", "(J)J", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "(IIII)J", "c", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "J", "getMainAxisMin-impl", "(J)I", "getMainAxisMax-impl", "getCrossAxisMin-impl", "getCrossAxisMax-impl", "stretchCrossAxis", "stretchCrossAxis-q4ezo7Y", "toBoxConstraints", "toBoxConstraints-OenEA2s", "maxWidth", "maxWidth-impl", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)I", "maxHeight", "maxHeight-impl", "copy", "copy-yUG9Ft0", "(JIIII)J", "equals", "", "other", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class OrientationIndependentConstraints {
    private final long value;

    private OrientationIndependentConstraints(long arg1) {
        super();
        this.value = arg1;
    }

    public static final OrientationIndependentConstraints box-impl(long arg1) {
        return new OrientationIndependentConstraints(arg1);
    }

    public static long constructor-impl(int arg0, int arg1, int arg2, int arg3) {
        return OrientationIndependentConstraints.constructor-impl(ConstraintsKt.Constraints(arg0, arg1, arg2, arg3));
    }

    public static long constructor-impl(long arg4, LayoutOrientation arg6) {
        int v0 = arg6 == LayoutOrientation.Horizontal ? Constraints.getMinWidth-impl(arg4) : Constraints.getMinHeight-impl(arg4);
        int v1 = arg6 == LayoutOrientation.Horizontal ? Constraints.getMaxWidth-impl(arg4) : Constraints.getMaxHeight-impl(arg4);
        int v2 = arg6 == LayoutOrientation.Horizontal ? Constraints.getMinHeight-impl(arg4) : Constraints.getMinWidth-impl(arg4);
        int v4 = arg6 == LayoutOrientation.Horizontal ? Constraints.getMaxHeight-impl(arg4) : Constraints.getMaxWidth-impl(arg4);
        return OrientationIndependentConstraints.constructor-impl(v0, v1, v2, v4);
    }

    private static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final long copy-yUG9Ft0(long arg0, int arg2, int arg3, int arg4, int arg5) {
        return OrientationIndependentConstraints.constructor-impl(arg2, arg3, arg4, arg5);
    }

    public static long copy-yUG9Ft0$default(long arg6, int arg8, int arg9, int arg10, int arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg8 = Constraints.getMinWidth-impl(arg6);
        }

        int v2 = arg8;
        if((arg12 & 2) != 0) {
            arg9 = Constraints.getMaxWidth-impl(arg6);
        }

        int v3 = arg9;
        if((arg12 & 4) != 0) {
            arg10 = Constraints.getMinHeight-impl(arg6);
        }

        int v4 = arg10;
        if((arg12 & 8) != 0) {
            arg11 = Constraints.getMaxHeight-impl(arg6);
        }

        return OrientationIndependentConstraints.copy-yUG9Ft0(arg6, v2, v3, v4, arg11);
    }

    public boolean equals(Object arg3) {
        return OrientationIndependentConstraints.equals-impl(this.value, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof OrientationIndependentConstraints)) {
            return 0;
        }

        if(!Constraints.equals-impl0(arg4, ((OrientationIndependentConstraints)arg6).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(long arg0, long arg2) {
        return Constraints.equals-impl0(arg0, arg2);
    }

    public static final int getCrossAxisMax-impl(long arg0) {
        return Constraints.getMaxHeight-impl(arg0);
    }

    public static final int getCrossAxisMin-impl(long arg0) {
        return Constraints.getMinHeight-impl(arg0);
    }

    public static final int getMainAxisMax-impl(long arg0) {
        return Constraints.getMaxWidth-impl(arg0);
    }

    public static final int getMainAxisMin-impl(long arg0) {
        return Constraints.getMinWidth-impl(arg0);
    }

    public int hashCode() {
        return OrientationIndependentConstraints.hashCode-impl(this.value);
    }

    public static int hashCode-impl(long arg0) {
        return Constraints.hashCode-impl(arg0);
    }

    public static final int maxHeight-impl(long arg1, LayoutOrientation arg3) {
        if(arg3 == LayoutOrientation.Horizontal) {
            return Constraints.getMaxHeight-impl(arg1);
        }

        return Constraints.getMaxWidth-impl(arg1);
    }

    public static final int maxWidth-impl(long arg1, LayoutOrientation arg3) {
        if(arg3 == LayoutOrientation.Horizontal) {
            return Constraints.getMaxWidth-impl(arg1);
        }

        return Constraints.getMaxHeight-impl(arg1);
    }

    public static final long stretchCrossAxis-q4ezo7Y(long arg4) {
        int v0 = Constraints.getMinWidth-impl(arg4);
        int v1 = Constraints.getMaxWidth-impl(arg4);
        int v2 = Constraints.getMaxHeight-impl(arg4) != 0x7FFFFFFF ? Constraints.getMaxHeight-impl(arg4) : Constraints.getMinHeight-impl(arg4);
        return OrientationIndependentConstraints.constructor-impl(v0, v1, v2, Constraints.getMaxHeight-impl(arg4));
    }

    public static final long toBoxConstraints-OenEA2s(long arg2, LayoutOrientation arg4) {
        if(arg4 == LayoutOrientation.Horizontal) {
            return ConstraintsKt.Constraints(Constraints.getMinWidth-impl(arg2), Constraints.getMaxWidth-impl(arg2), Constraints.getMinHeight-impl(arg2), Constraints.getMaxHeight-impl(arg2));
        }

        return ConstraintsKt.Constraints(Constraints.getMinHeight-impl(arg2), Constraints.getMaxHeight-impl(arg2), Constraints.getMinWidth-impl(arg2), Constraints.getMaxWidth-impl(arg2));
    }

    public String toString() {
        return OrientationIndependentConstraints.toString-impl(this.value);
    }

    public static String toString-impl(long arg2) {
        return "OrientationIndependentConstraints(value=" + Constraints.toString-impl(arg2) + ')';
    }

    public final long unbox-impl() {
        return this.value;
    }
}

