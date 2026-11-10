package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\f\u0010\u0015\u001A\u00020\u0016*\u00020\u0017H\u0014J\u0010\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u000B\u001A\u00020\fH\u0014J\u0012\u0010\u001A\u001A\u00020\u00192\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u001B\u001A\u00020\u00192\u0006\u0010\r\u001A\u00020\u000EH\u0014R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u001C"}, d2={"Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "shape", "Landroidx/compose/ui/graphics/Shape;", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "renderCreator", "Landroidx/compose/ui/graphics/shadow/DropShadowRendererProvider;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/shadow/DropShadowRendererProvider;)V", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;)V", "alpha", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "", "applyColorFilter", "applyLayoutDirection", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DropShadowPainter extends Painter {
    public static final int $stable = 8;
    private float alpha;
    private ColorFilter colorFilter;
    private LayoutDirection layoutDirection;
    private final DropShadowRendererProvider renderCreator;
    private final Shadow shadow;
    private final Shape shape;

    static {
    }

    public DropShadowPainter(Shape arg2, Shadow arg3) {
        this(arg2, arg3, DropShadowRendererProvider.Companion.getDefault());
    }

    public DropShadowPainter(Shape arg1, Shadow arg2, DropShadowRendererProvider arg3) {
        super();
        this.shape = arg1;
        this.shadow = arg2;
        this.renderCreator = arg3;
        this.alpha = 1f;
        this.layoutDirection = LayoutDirection.Ltr;
    }

    protected boolean applyAlpha(float arg1) {
        this.alpha = arg1;
        return 1;
    }

    protected boolean applyColorFilter(ColorFilter arg1) {
        this.colorFilter = arg1;
        return 1;
    }

    protected boolean applyLayoutDirection(LayoutDirection arg1) {
        this.layoutDirection = arg1;
        return 1;
    }

    public long getIntrinsicSize-NH-jbRc() {
        return Size.Companion.getUnspecified-NH-jbRc();
    }

    protected void onDraw(DrawScope arg14) {
        DropShadowRenderer v2 = this.renderCreator.obtainDropShadowRenderer-eZhPAX0(this.shape, arg14.getSize-NH-jbRc(), arg14.getLayoutDirection(), arg14, this.shadow);
        float v10 = arg14.toPx-0680j_4(DpOffset.getX-D9Ej5fM(this.shadow.getOffset-RKDOV3M()));
        float v11 = arg14.toPx-0680j_4(DpOffset.getY-D9Ej5fM(this.shadow.getOffset-RKDOV3M()));
        arg14.getDrawContext().getTransform().translate(v10, v11);
        DropShadowRenderer v3 = v2;
        try {
            v3.drawShadow-erFMhIw(arg14, this.colorFilter, arg14.getSize-NH-jbRc(), v3.getShadow().getColor-0d7_KjU(), v3.getShadow().getBrush(), RangesKt.coerceIn(this.alpha * v3.getShadow().getAlpha(), 0f, 1f), v3.getShadow().getBlendMode-0nO6VwU());
        }
        catch(Throwable v0) {
            arg14.getDrawContext().getTransform().translate(-v10, -v11);
            throw v0;
        }

        arg14.getDrawContext().getTransform().translate(-v10, -v11);
    }
}

