package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\b\u001A\u00020\t*\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0012\u001A\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001A\u00020\u0005HÂ\u0003J\u001D\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00052\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/foundation/layout/BoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "alignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "<init>", "(Landroidx/compose/ui/Alignment;Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class BoxMeasurePolicy implements MeasurePolicy {
    private final Alignment alignment;
    private final boolean propagateMinConstraints;

    public BoxMeasurePolicy(Alignment arg1, boolean arg2) {
        super();
        this.alignment = arg1;
        this.propagateMinConstraints = arg2;
    }

    private final Alignment component1() {
        return this.alignment;
    }

    private final boolean component2() {
        return this.propagateMinConstraints;
    }

    public final BoxMeasurePolicy copy(Alignment arg1, boolean arg2) {
        return new BoxMeasurePolicy(arg1, arg2);
    }

    public static BoxMeasurePolicy copy$default(BoxMeasurePolicy arg0, Alignment arg1, boolean arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.alignment;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.propagateMinConstraints;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((BoxMeasurePolicy)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof BoxMeasurePolicy)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.alignment, ((BoxMeasurePolicy)arg5).alignment)) {
            return 0;
        }

        if(this.propagateMinConstraints != ((BoxMeasurePolicy)arg5).propagateMinConstraints) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return this.alignment.hashCode() * 0x1F + Boolean.hashCode(this.propagateMinConstraints);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg16, List arg17, long arg18) {
        int v3;
        int v1;
        Placeable v0_1;
        List v2 = arg17;
        if(v2.isEmpty()) {
            return MeasureScope.layout$default(arg16, Constraints.getMinWidth-impl(arg18), Constraints.getMinHeight-impl(arg18), null, new BoxMeasurePolicy$$ExternalSyntheticLambda0(), 4, null);
        }

        long v0 = this.propagateMinConstraints ? arg18 : Constraints.constructor-impl(arg18 & -8589934589L);
        if(v2.size() == 1) {
            Object v2_1 = v2.get(0);
            if(!BoxKt.getMatchesParentSize(((Measurable)v2_1))) {
                v0_1 = ((Measurable)v2_1).measure-BRTryo0(v0);
                v1 = Math.max(Constraints.getMinWidth-impl(arg18), v0_1.getWidth());
                v3 = Math.max(Constraints.getMinHeight-impl(arg18), v0_1.getHeight());
            }
            else {
                v1 = Constraints.getMinWidth-impl(arg18);
                v3 = Constraints.getMinHeight-impl(arg18);
                v0_1 = ((Measurable)v2_1).measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(Constraints.getMinWidth-impl(arg18), Constraints.getMinHeight-impl(arg18)));
            }

            return MeasureScope.layout$default(arg16, v1, v3, null, new BoxMeasurePolicy$$ExternalSyntheticLambda1(v0_1, ((Measurable)v2_1), arg16, v1, v3, this), 4, null);
        }

        Placeable[] v3_1 = new Placeable[v2.size()];
        IntRef v4 = new IntRef();
        v4.element = Constraints.getMinWidth-impl(arg18);
        int v7 = 0;
        IntRef v5 = new IntRef();
        v5.element = Constraints.getMinHeight-impl(arg18);
        List v8 = v2;
        int v9 = ((Collection)v8).size();
        int v10 = 0;
        int v11 = 0;
        while(v10 < v9) {
            Object v12 = v2.get(v10);
            if(!BoxKt.getMatchesParentSize(((Measurable)v12))) {
                Placeable v12_1 = ((Measurable)v12).measure-BRTryo0(v0);
                v3_1[v10] = v12_1;
                v4.element = Math.max(v4.element, v12_1.getWidth());
                v5.element = Math.max(v5.element, v12_1.getHeight());
            }
            else {
                v11 = 1;
            }

            ++v10;
        }

        if(v11 != 0) {
            v1 = 0x7FFFFFFF;
            int v0_2 = v4.element != v1 ? v4.element : 0;
            v1 = v5.element != v1 ? v5.element : 0;
            v0 = ConstraintsKt.Constraints(v0_2, v4.element, v1, v5.element);
            int v6 = ((Collection)v8).size();
            while(v7 < v6) {
                Object v8_1 = v2.get(v7);
                if(BoxKt.getMatchesParentSize(((Measurable)v8_1))) {
                    v3_1[v7] = ((Measurable)v8_1).measure-BRTryo0(v0);
                }

                ++v7;
            }
        }

        return MeasureScope.layout$default(arg16, v4.element, v5.element, null, new BoxMeasurePolicy$$ExternalSyntheticLambda2(v3_1, v2, arg16, v4, v5, this), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$1(Placeable arg1, Measurable arg2, MeasureScope arg3, int arg4, int arg5, BoxMeasurePolicy arg6, PlacementScope arg7) {
        BoxKt.placeInBox(arg7, arg1, arg2, arg3.getLayoutDirection(), arg4, arg5, arg6.alignment);
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$4(Placeable[] arg13, List arg14, MeasureScope arg15, IntRef arg16, IntRef arg17, BoxMeasurePolicy arg18, PlacementScope arg19) {
        int v0 = arg13.length;
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < v0; ++v2) {
            Placeable v4 = arg13[v1];
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
            BoxKt.placeInBox(arg19, v4, arg14.get(v2), arg15.getLayoutDirection(), arg16.element, arg17.element, arg18.alignment);
            ++v1;
        }

        return Unit.INSTANCE;
    }

    public String toString() {
        return "BoxMeasurePolicy(alignment=" + this.alignment + ", propagateMinConstraints=" + this.propagateMinConstraints + ')';
    }
}

