package androidx.compose.ui.layout;

import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0012\u001A\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0013H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0016\u0010\u000E\u001A\u0004\u0018\u00010\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0018¨\u0006\u001B"}, d2={"Landroidx/compose/ui/layout/LookaheadCapablePlacementScope;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "within", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "<init>", "(Landroidx/compose/ui/node/LookaheadCapablePlaceable;)V", "parentWidth", "", "getParentWidth", "()I", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "current", "", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "density", "getDensity", "()F", "fontScale", "getFontScale", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class LookaheadCapablePlacementScope extends PlacementScope {
    private final LookaheadCapablePlaceable within;

    public LookaheadCapablePlacementScope(LookaheadCapablePlaceable arg1) {
        super();
        this.within = arg1;
    }

    public float current(Ruler arg2, float arg3) {
        if(arg2.getCalculate$ui() != null) {
            return arg2.getCalculate$ui().invoke(this, Float.valueOf(arg3)).floatValue();
        }

        return this.within.findRulerValue(arg2, arg3);
    }

    public LayoutCoordinates getCoordinates() {
        LayoutCoordinates v0 = this.within.isPlacingForAlignment$ui() ? null : this.within.getCoordinates();
        if(v0 == null) {
            this.within.getLayoutNode().getLayoutDelegate$ui().onCoordinatesUsed();
        }

        return v0;
    }

    public float getDensity() {
        return this.within.getDensity();
    }

    public float getFontScale() {
        return this.within.getFontScale();
    }

    protected LayoutDirection getParentLayoutDirection() {
        return this.within.getLayoutDirection();
    }

    protected int getParentWidth() {
        return this.within.getMeasuredWidth();
    }
}

