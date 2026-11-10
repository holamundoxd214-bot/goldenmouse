package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u001C\u0010\u000B\u001A\u00020\f*\u00020\r2\u0006\u0010\u0005\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\fH\u0016J\u001C\u0010\u0010\u001A\u00020\f*\u00020\r2\u0006\u0010\u0005\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\fH\u0016J\u001C\u0010\u0012\u001A\u00020\f*\u00020\r2\u0006\u0010\u0005\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\fH\u0016J\u001C\u0010\u0013\u001A\u00020\f*\u00020\r2\u0006\u0010\u0005\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2={"Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/Modifier$Element;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LayoutModifier extends Element {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean all(LayoutModifier arg0, Function1 arg1) {
            return arg0.all(arg1);
        }

        @Deprecated public static boolean any(LayoutModifier arg0, Function1 arg1) {
            return arg0.any(arg1);
        }

        @Deprecated public static Object foldIn(LayoutModifier arg0, Object arg1, Function2 arg2) {
            return arg0.foldIn(arg1, arg2);
        }

        @Deprecated public static Object foldOut(LayoutModifier arg0, Object arg1, Function2 arg2) {
            return arg0.foldOut(arg1, arg2);
        }

        @Deprecated public static int maxIntrinsicHeight(LayoutModifier arg0, IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
            return arg0.maxIntrinsicHeight(arg1, arg2, arg3);
        }

        @Deprecated public static int maxIntrinsicWidth(LayoutModifier arg0, IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
            return arg0.maxIntrinsicWidth(arg1, arg2, arg3);
        }

        @Deprecated public static int minIntrinsicHeight(LayoutModifier arg0, IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
            return arg0.minIntrinsicHeight(arg1, arg2, arg3);
        }

        @Deprecated public static int minIntrinsicWidth(LayoutModifier arg0, IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
            return arg0.minIntrinsicWidth(arg1, arg2, arg3);
        }

        @Deprecated public static Modifier then(LayoutModifier arg0, Modifier arg1) {
            return arg0.then(arg1);
        }
    }

    static boolean access$all$jd(LayoutModifier arg0, Function1 arg1) {
        return super.all(arg1);
    }

    static boolean access$any$jd(LayoutModifier arg0, Function1 arg1) {
        return super.any(arg1);
    }

    static Object access$foldIn$jd(LayoutModifier arg0, Object arg1, Function2 arg2) {
        return super.foldIn(arg1, arg2);
    }

    static Object access$foldOut$jd(LayoutModifier arg0, Object arg1, Function2 arg2) {
        return super.foldOut(arg1, arg2);
    }

    static int access$maxIntrinsicHeight$jd(LayoutModifier arg0, IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return super.maxIntrinsicHeight(arg1, arg2, arg3);
    }

    static int access$maxIntrinsicWidth$jd(LayoutModifier arg0, IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return super.maxIntrinsicWidth(arg1, arg2, arg3);
    }

    static int access$minIntrinsicHeight$jd(LayoutModifier arg0, IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return super.minIntrinsicHeight(arg1, arg2, arg3);
    }

    static int access$minIntrinsicWidth$jd(LayoutModifier arg0, IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return super.minIntrinsicWidth(arg1, arg2, arg3);
    }

    static Modifier access$then$jd(LayoutModifier arg0, Modifier arg1) {
        return super.then(arg1);
    }

    default int maxIntrinsicHeight(IntrinsicMeasureScope arg2, IntrinsicMeasurable arg3, int arg4) {
        return MeasuringIntrinsics.INSTANCE.maxHeight(this, arg2, arg3, arg4);
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope arg2, IntrinsicMeasurable arg3, int arg4) {
        return MeasuringIntrinsics.INSTANCE.maxWidth(this, arg2, arg3, arg4);
    }

    MeasureResult measure-3p2s80s(MeasureScope arg1, Measurable arg2, long arg3);

    default int minIntrinsicHeight(IntrinsicMeasureScope arg2, IntrinsicMeasurable arg3, int arg4) {
        return MeasuringIntrinsics.INSTANCE.minHeight(this, arg2, arg3, arg4);
    }

    default int minIntrinsicWidth(IntrinsicMeasureScope arg2, IntrinsicMeasurable arg3, int arg4) {
        return MeasuringIntrinsics.INSTANCE.minWidth(this, arg2, arg3, arg4);
    }
}

