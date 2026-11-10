package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bç\u0080\u0001\u0018\u00002\u00020\u0001J/\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b\n\u0010\u000BJ(\u0010\f\u001A\u00020\r*\u00020\u000E2\u0012\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000F0\u00060\u00062\u0006\u0010\u0010\u001A\u00020\rH\u0016J(\u0010\u0011\u001A\u00020\r*\u00020\u000E2\u0012\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000F0\u00060\u00062\u0006\u0010\u0012\u001A\u00020\rH\u0016J(\u0010\u0013\u001A\u00020\r*\u00020\u000E2\u0012\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000F0\u00060\u00062\u0006\u0010\u0010\u001A\u00020\rH\u0016J(\u0010\u0014\u001A\u00020\r*\u00020\u000E2\u0012\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000F0\u00060\u00062\u0006\u0010\u0012\u001A\u00020\rH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2={"Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface MultiContentMeasurePolicy {
    default int maxIntrinsicHeight(IntrinsicMeasureScope arg16, List arg17, int arg18) {
        List v0 = arg17;
        ArrayList v1 = new ArrayList(v0.size());
        int v2 = v0.size();
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            Object v5 = v0.get(v4);
            ArrayList v6 = v1;
            ArrayList v7 = new ArrayList(((List)v5).size());
            int v8 = v5.size();
            int v9;
            for(v9 = 0; v9 < v8; ++v9) {
                v7.add(new DefaultIntrinsicMeasurable(((List)v5).get(v9), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
            }

            ((Collection)v6).add(v7);
        }

        return this.measure-3p2s80s(new IntrinsicsMeasureScope(arg16, arg16.getLayoutDirection()), ((List)v1), ConstraintsKt.Constraints$default(0, arg18, 0, 0, 13, null)).getHeight();
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope arg16, List arg17, int arg18) {
        List v0 = arg17;
        ArrayList v1 = new ArrayList(v0.size());
        int v2 = v0.size();
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            Object v5 = v0.get(v4);
            ArrayList v6 = v1;
            ArrayList v7 = new ArrayList(((List)v5).size());
            int v8 = v5.size();
            int v9;
            for(v9 = 0; v9 < v8; ++v9) {
                v7.add(new DefaultIntrinsicMeasurable(((List)v5).get(v9), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
            }

            ((Collection)v6).add(v7);
        }

        return this.measure-3p2s80s(new IntrinsicsMeasureScope(arg16, arg16.getLayoutDirection()), ((List)v1), ConstraintsKt.Constraints$default(0, 0, 0, arg18, 7, null)).getWidth();
    }

    MeasureResult measure-3p2s80s(MeasureScope arg1, List arg2, long arg3);

    default int minIntrinsicHeight(IntrinsicMeasureScope arg16, List arg17, int arg18) {
        List v0 = arg17;
        ArrayList v1 = new ArrayList(v0.size());
        int v2 = v0.size();
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            Object v5 = v0.get(v4);
            ArrayList v6 = v1;
            ArrayList v7 = new ArrayList(((List)v5).size());
            int v8 = v5.size();
            int v9;
            for(v9 = 0; v9 < v8; ++v9) {
                v7.add(new DefaultIntrinsicMeasurable(((List)v5).get(v9), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
            }

            ((Collection)v6).add(v7);
        }

        return this.measure-3p2s80s(new IntrinsicsMeasureScope(arg16, arg16.getLayoutDirection()), ((List)v1), ConstraintsKt.Constraints$default(0, arg18, 0, 0, 13, null)).getHeight();
    }

    default int minIntrinsicWidth(IntrinsicMeasureScope arg16, List arg17, int arg18) {
        List v0 = arg17;
        ArrayList v1 = new ArrayList(v0.size());
        int v2 = v0.size();
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            Object v5 = v0.get(v4);
            ArrayList v6 = v1;
            ArrayList v7 = new ArrayList(((List)v5).size());
            int v8 = v5.size();
            int v9;
            for(v9 = 0; v9 < v8; ++v9) {
                v7.add(new DefaultIntrinsicMeasurable(((List)v5).get(v9), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
            }

            ((Collection)v6).add(v7);
        }

        return this.measure-3p2s80s(new IntrinsicsMeasureScope(arg16, arg16.getLayoutDirection()), ((List)v1), ConstraintsKt.Constraints$default(0, 0, 0, arg18, 7, null)).getWidth();
    }
}

