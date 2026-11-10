package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0012\u001A\u00020\u000FH\u0016J\"\u0010\u0013\u001A\u00020\u000F*\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0012\u001A\u00020\u000FH\u0016J\"\u0010\u0014\u001A\u00020\u000F*\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0015\u001A\u00020\u000FH\u0016J\"\u0010\u0016\u001A\u00020\u000F*\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0015\u001A\u00020\u000FH\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/material3/ChipLayoutMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicHeight", "minIntrinsicWidth", "height", "maxIntrinsicWidth", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ChipLayoutMeasurePolicy implements MeasurePolicy {
    public ChipLayoutMeasurePolicy() {
        super();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg5, List arg6, int arg7) {
        Integer v4;
        if(arg6.isEmpty()) {
            v4 = null;
        }
        else {
            v4 = Integer.valueOf(arg6.get(0).maxIntrinsicHeight(arg7));
            int v0 = CollectionsKt.getLastIndex(arg6);
            int v1 = 1;
            if(1 > v0) {
                goto label_20;
            }

            while(true) {
                Integer v2 = Integer.valueOf(arg6.get(v1).maxIntrinsicHeight(arg7));
                if(((Comparable)v2).compareTo(v4) > 0) {
                    v4 = v2;
                }

                if(v1 == v0) {
                    break;
                }

                ++v1;
            }
        }

    label_20:
        if(v4 != null) {
            return v4.intValue();
        }

        return 0;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg3, List arg4, int arg5) {
        int v2 = arg4.size();
        int v3 = 0;
        int v0 = 0;
        while(v3 < v2) {
            v0 += arg4.get(v3).maxIntrinsicWidth(arg5);
            ++v3;
        }

        return v0;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg20, List arg21, long arg22) {
        Object v9;
        Object v6;
        Placeable v5;
        List v0 = arg21;
        List v1 = v0;
        int v2 = ((Collection)v1).size();
        int v3 = 0;
        int v4 = 0;
        while(true) {
            v5 = null;
            if(v4 < v2) {
                v6 = v0.get(v4);
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v6), "leadingIcon")) {
                }
                else {
                    ++v4;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_17;
        }

        v6 = v5;
    label_17:
        Placeable v7 = v6 != null ? ((Measurable)v6).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg22, 0, 0, 0, 0, 10, null)) : v5;
        v2 = LayoutUtilKt.getWidthOrZero(v7);
        int v8 = LayoutUtilKt.getHeightOrZero(v7);
        v4 = ((Collection)v1).size();
        int v6_1 = 0;
        while(true) {
            if(v6_1 < v4) {
                v9 = v0.get(v6_1);
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v9), "trailingIcon")) {
                }
                else {
                    ++v6_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_45;
        }

        v9 = v5;
    label_45:
        if(v9 != null) {
            v5 = ((Measurable)v9).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg22, 0, 0, 0, 0, 10, null));
        }

        v4 = LayoutUtilKt.getWidthOrZero(v5);
        v6_1 = LayoutUtilKt.getHeightOrZero(v5);
        int v1_1 = ((Collection)v1).size();
        while(v3 < v1_1) {
            v9 = v0.get(v3);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v9)), "label")) {
                Placeable v10 = ((Measurable)v9).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(arg22, -(v2 + v4), 0, 2, null));
                int v0_1 = v10.getWidth() + v2 + v4;
                int v9_1 = Math.max(v8, Math.max(v10.getHeight(), v6_1));
                return MeasureScope.layout$default(arg20, v0_1, v9_1, null, new ChipLayoutMeasurePolicy$$ExternalSyntheticLambda0(v7, v8, v9_1, v10, v2, v5, v6_1), 4, null);
            }

            ++v3;
        }

        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    static final Unit measure_3p2s80s$lambda$3(Placeable arg16, int arg17, int arg18, Placeable arg19, int arg20, Placeable arg21, int arg22, PlacementScope arg23) {
        int v0 = arg18;
        if(arg16 != null) {
            PlacementScope.placeRelative$default(arg23, arg16, 0, Alignment.Companion.getCenterVertically().align(arg17, v0), 0f, 4, null);
        }

        PlacementScope.placeRelative$default(arg23, arg19, arg20, 0, 0f, 4, null);
        if(arg21 != null) {
            PlacementScope.placeRelative$default(arg23, arg21, arg20 + arg19.getWidth(), Alignment.Companion.getCenterVertically().align(arg22, v0), 0f, 4, null);
        }

        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg5, List arg6, int arg7) {
        Integer v4;
        if(arg6.isEmpty()) {
            v4 = null;
        }
        else {
            v4 = Integer.valueOf(arg6.get(0).minIntrinsicHeight(arg7));
            int v0 = CollectionsKt.getLastIndex(arg6);
            int v1 = 1;
            if(1 > v0) {
                goto label_20;
            }

            while(true) {
                Integer v2 = Integer.valueOf(arg6.get(v1).minIntrinsicHeight(arg7));
                if(((Comparable)v2).compareTo(v4) > 0) {
                    v4 = v2;
                }

                if(v1 == v0) {
                    break;
                }

                ++v1;
            }
        }

    label_20:
        if(v4 != null) {
            return v4.intValue();
        }

        return 0;
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg3, List arg4, int arg5) {
        int v2 = arg4.size();
        int v3 = 0;
        int v0 = 0;
        while(v3 < v2) {
            v0 += arg4.get(v3).minIntrinsicWidth(arg5);
            ++v3;
        }

        return v0;
    }
}

