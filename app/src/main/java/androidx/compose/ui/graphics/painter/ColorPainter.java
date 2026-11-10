package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\r\u001A\u00020\u000E*\u00020\u000FH\u0014J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\t\u001A\u00020\nH\u0014J\u0012\u0010\u0012\u001A\u00020\u00112\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0014J\u0013\u0010\u0013\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u001A\u001A\u00020\u001BX\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001C\u0010\u0007¨\u0006\u001D"}, d2={"Landroidx/compose/ui/graphics/painter/ColorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "", "applyColorFilter", "equals", "other", "", "hashCode", "", "toString", "", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ColorPainter extends Painter {
    public static final int $stable = 8;
    private float alpha;
    private final long color;
    private ColorFilter colorFilter;
    private final long intrinsicSize;

    static {
    }

    private ColorPainter(long arg1) {
        super();
        this.color = arg1;
        this.alpha = 1f;
        this.intrinsicSize = Size.Companion.getUnspecified-NH-jbRc();
    }

    public ColorPainter(long arg1, DefaultConstructorMarker arg3) {
        this(arg1);
    }

    protected boolean applyAlpha(float arg1) {
        this.alpha = arg1;
        return 1;
    }

    protected boolean applyColorFilter(ColorFilter arg1) {
        this.colorFilter = arg1;
        return 1;
    }

    public boolean equals(Object arg6) {
        if(this == (((ColorPainter)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof ColorPainter)) {
            return 0;
        }

        if(!Color.equals-impl0(this.color, ((ColorPainter)arg6).color)) {
            return 0;
        }

        return 1;
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    public long getIntrinsicSize-NH-jbRc() {
        return this.intrinsicSize;
    }

    public int hashCode() {
        return Color.hashCode-impl(this.color);
    }

    protected void onDraw(DrawScope arg14) {
        DrawScope.drawRect-n-J9OG0$default(arg14, this.color, 0, 0, this.alpha, null, this.colorFilter, 0, 86, null);
    }

    public String toString() {
        return "ColorPainter(color=" + Color.toString-impl(this.color) + ')';
    }
}

