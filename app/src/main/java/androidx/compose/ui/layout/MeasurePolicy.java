package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bç\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001A\u00020\tH&J\"\u0010\n\u001A\u00020\u000B*\u00020\f2\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000E\u001A\u00020\u000BH\u0016J\"\u0010\u000F\u001A\u00020\u000B*\u00020\f2\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0010\u001A\u00020\u000BH\u0016J\"\u0010\u0011\u001A\u00020\u000B*\u00020\f2\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000E\u001A\u00020\u000BH\u0016J\"\u0010\u0012\u001A\u00020\u000B*\u00020\f2\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0010\u001A\u00020\u000BH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0003"}, d2={"Landroidx/compose/ui/layout/MeasurePolicy;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface MeasurePolicy {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static int maxIntrinsicHeight(MeasurePolicy arg0, IntrinsicMeasureScope arg1, List arg2, int arg3) {
            return arg0.maxIntrinsicHeight(arg1, arg2, arg3);
        }

        @Deprecated public static int maxIntrinsicWidth(MeasurePolicy arg0, IntrinsicMeasureScope arg1, List arg2, int arg3) {
            return arg0.maxIntrinsicWidth(arg1, arg2, arg3);
        }

        @Deprecated public static int minIntrinsicHeight(MeasurePolicy arg0, IntrinsicMeasureScope arg1, List arg2, int arg3) {
            return arg0.minIntrinsicHeight(arg1, arg2, arg3);
        }

        @Deprecated public static int minIntrinsicWidth(MeasurePolicy arg0, IntrinsicMeasureScope arg1, List arg2, int arg3) {
            return arg0.minIntrinsicWidth(arg1, arg2, arg3);
        }
    }

    static int access$maxIntrinsicHeight$jd(MeasurePolicy arg0, IntrinsicMeasureScope arg1, List arg2, int arg3) {
        return super.maxIntrinsicHeight(arg1, arg2, arg3);
    }

    static int access$maxIntrinsicWidth$jd(MeasurePolicy arg0, IntrinsicMeasureScope arg1, List arg2, int arg3) {
        return super.maxIntrinsicWidth(arg1, arg2, arg3);
    }

    static int access$minIntrinsicHeight$jd(MeasurePolicy arg0, IntrinsicMeasureScope arg1, List arg2, int arg3) {
        return super.minIntrinsicHeight(arg1, arg2, arg3);
    }

    static int access$minIntrinsicWidth$jd(MeasurePolicy arg0, IntrinsicMeasureScope arg1, List arg2, int arg3) {
        return super.minIntrinsicWidth(arg1, arg2, arg3);
    }

    default int maxIntrinsicHeight(IntrinsicMeasureScope arg9, List arg10, int arg11) {
        ArrayList v0 = new ArrayList(arg10.size());
        int v1 = arg10.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(new DefaultIntrinsicMeasurable(arg10.get(v2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
        }

        return this.measure-3p2s80s(new IntrinsicsMeasureScope(arg9, arg9.getLayoutDirection()), ((List)v0), ConstraintsKt.Constraints$default(0, arg11, 0, 0, 13, null)).getHeight();
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope arg9, List arg10, int arg11) {
        ArrayList v0 = new ArrayList(arg10.size());
        int v1 = arg10.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(new DefaultIntrinsicMeasurable(arg10.get(v2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
        }

        return this.measure-3p2s80s(new IntrinsicsMeasureScope(arg9, arg9.getLayoutDirection()), ((List)v0), ConstraintsKt.Constraints$default(0, 0, 0, arg11, 7, null)).getWidth();
    }

    MeasureResult measure-3p2s80s(MeasureScope arg1, List arg2, long arg3);

    default int minIntrinsicHeight(IntrinsicMeasureScope arg9, List arg10, int arg11) {
        ArrayList v0 = new ArrayList(arg10.size());
        int v1 = arg10.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(new DefaultIntrinsicMeasurable(arg10.get(v2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
        }

        return this.measure-3p2s80s(new IntrinsicsMeasureScope(arg9, arg9.getLayoutDirection()), ((List)v0), ConstraintsKt.Constraints$default(0, arg11, 0, 0, 13, null)).getHeight();
    }

    default int minIntrinsicWidth(IntrinsicMeasureScope arg9, List arg10, int arg11) {
        ArrayList v0 = new ArrayList(arg10.size());
        int v1 = arg10.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(new DefaultIntrinsicMeasurable(arg10.get(v2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
        }

        return this.measure-3p2s80s(new IntrinsicsMeasureScope(arg9, arg9.getLayoutDirection()), ((List)v0), ConstraintsKt.Constraints$default(0, 0, 0, arg11, 7, null)).getWidth();
    }
}

