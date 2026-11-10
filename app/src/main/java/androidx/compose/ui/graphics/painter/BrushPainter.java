package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0010\u001A\u00020\u0011*\u00020\u0012H\u0014J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\tH\u0014J\u0012\u0010\u0015\u001A\u00020\u00142\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0014J\u0013\u0010\u0016\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001D"}, d2={"Landroidx/compose/ui/graphics/painter/BrushPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "brush", "Landroidx/compose/ui/graphics/Brush;", "<init>", "(Landroidx/compose/ui/graphics/Brush;)V", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "", "applyColorFilter", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BrushPainter extends Painter {
    public static final int $stable = 8;
    private float alpha;
    private final Brush brush;
    private ColorFilter colorFilter;

    static {
    }

    public BrushPainter(Brush arg1) {
        super();
        this.brush = arg1;
        this.alpha = 1f;
    }

    protected boolean applyAlpha(float arg1) {
        this.alpha = arg1;
        return 1;
    }

    protected boolean applyColorFilter(ColorFilter arg1) {
        this.colorFilter = arg1;
        return 1;
    }

    public boolean equals(Object arg4) {
        if(this == (((BrushPainter)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof BrushPainter)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.brush, ((BrushPainter)arg4).brush)) {
            return 0;
        }

        return 1;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public long getIntrinsicSize-NH-jbRc() {
        return this.brush.getIntrinsicSize-NH-jbRc();
    }

    public int hashCode() {
        return this.brush.hashCode();
    }

    protected void onDraw(DrawScope arg13) {
        DrawScope.drawRect-AsUm42w$default(arg13, this.brush, 0, 0, this.alpha, null, this.colorFilter, 0, 86, null);
    }

    public String toString() {
        return "BrushPainter(brush=" + this.brush + ')';
    }
}

