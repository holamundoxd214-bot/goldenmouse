package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0016\u001A\u00020\u0004HÂ\u0003J\u0010\u0010\u0017\u001A\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\nJ$\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001A\u0010\u001BJ\u0015\u0010\u001C\u001A\u00020\u001D*\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001FH\u0097\u0001J\u0013\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001A\u00020%HÖ\u0001J\r\u0010&\u001A\u00020\u001D*\u00020\u001DH\u0097\u0001J\t\u0010\'\u001A\u00020(HÖ\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000FR\u0014\u0010\u0012\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000FR\u0014\u0010\u0014\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u000F¨\u0006)"}, d2={"Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/foundation/layout/BoxScope;", "density", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "minWidth", "Landroidx/compose/ui/unit/Dp;", "getMinWidth-D9Ej5fM", "()F", "maxWidth", "getMaxWidth-D9Ej5fM", "minHeight", "getMinHeight-D9Ej5fM", "maxHeight", "getMaxHeight-D9Ej5fM", "component1", "component2", "component2-msEJaDk", "copy", "copy-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "equals", "", "other", "", "hashCode", "", "matchParentSize", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class BoxWithConstraintsScopeImpl implements BoxScope, BoxWithConstraintsScope {
    private final long constraints;
    private final Density density;

    public BoxWithConstraintsScopeImpl(Density arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    private BoxWithConstraintsScopeImpl(Density arg2, long arg3) {
        super();
        this.$$delegate_0 = BoxScopeInstance.INSTANCE;
        this.density = arg2;
        this.constraints = arg3;
    }

    public Modifier align(Modifier arg1, Alignment arg2) {
        return this.$$delegate_0.align(arg1, arg2);
    }

    private final Density component1() {
        return this.density;
    }

    public final long component2-msEJaDk() {
        return this.constraints;
    }

    public final BoxWithConstraintsScopeImpl copy-0kLqBqw(Density arg2, long arg3) {
        return new BoxWithConstraintsScopeImpl(arg2, arg3, null);
    }

    public static BoxWithConstraintsScopeImpl copy-0kLqBqw$default(BoxWithConstraintsScopeImpl arg0, Density arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.density;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.constraints;
        }

        return arg0.copy-0kLqBqw(arg1, arg2);
    }

    public boolean equals(Object arg6) {
        if(this == (((BoxWithConstraintsScopeImpl)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof BoxWithConstraintsScopeImpl)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.density, ((BoxWithConstraintsScopeImpl)arg6).density)) {
            return 0;
        }

        if(!Constraints.equals-impl0(this.constraints, ((BoxWithConstraintsScopeImpl)arg6).constraints)) {
            return 0;
        }

        return 1;
    }

    public long getConstraints-msEJaDk() {
        return this.constraints;
    }

    public float getMaxHeight-D9Ej5fM() {
        Density v0 = this.density;
        if(Constraints.getHasBoundedHeight-impl(this.getConstraints-msEJaDk())) {
            return v0.toDp-u2uoSUM(Constraints.getMaxHeight-impl(this.getConstraints-msEJaDk()));
        }

        return Dp.Companion.getInfinity-D9Ej5fM();
    }

    public float getMaxWidth-D9Ej5fM() {
        Density v0 = this.density;
        if(Constraints.getHasBoundedWidth-impl(this.getConstraints-msEJaDk())) {
            return v0.toDp-u2uoSUM(Constraints.getMaxWidth-impl(this.getConstraints-msEJaDk()));
        }

        return Dp.Companion.getInfinity-D9Ej5fM();
    }

    public float getMinHeight-D9Ej5fM() {
        return this.density.toDp-u2uoSUM(Constraints.getMinHeight-impl(this.getConstraints-msEJaDk()));
    }

    public float getMinWidth-D9Ej5fM() {
        return this.density.toDp-u2uoSUM(Constraints.getMinWidth-impl(this.getConstraints-msEJaDk()));
    }

    public int hashCode() {
        return this.density.hashCode() * 0x1F + Constraints.hashCode-impl(this.constraints);
    }

    public Modifier matchParentSize(Modifier arg1) {
        return this.$$delegate_0.matchParentSize(arg1);
    }

    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + Constraints.toString-impl(this.constraints) + ')';
    }
}

