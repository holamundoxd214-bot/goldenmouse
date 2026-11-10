package androidx.compose.ui.draganddrop;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View$DragShadowBuilder;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u000B\u0010\fJ\u0018\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0016J\u0010\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u0014H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001F\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/ui/draganddrop/ComposeDragShadowBuilder;", "Landroid/view/View$DragShadowBuilder;", "density", "Landroidx/compose/ui/unit/Density;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "onProvideShadowMetrics", "outShadowSize", "Landroid/graphics/Point;", "outShadowTouchPoint", "onDrawShadow", "canvas", "Landroid/graphics/Canvas;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ComposeDragShadowBuilder extends View$DragShadowBuilder {
    public static final int $stable = 8;
    private final long decorationSize;
    private final Density density;
    private final Function1 drawDragDecoration;

    static {
    }

    private ComposeDragShadowBuilder(Density arg1, long arg2, Function1 arg4) {
        super();
        this.density = arg1;
        this.decorationSize = arg2;
        this.drawDragDecoration = arg4;
    }

    public ComposeDragShadowBuilder(Density arg1, long arg2, Function1 arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg4);
    }

    public void onDrawShadow(Canvas arg12) {
        CanvasDrawScope v0 = new CanvasDrawScope();
        Density v1 = this.density;
        long v2 = this.decorationSize;
        LayoutDirection v4 = LayoutDirection.Ltr;
        androidx.compose.ui.graphics.Canvas v12 = AndroidCanvas_androidKt.Canvas(arg12);
        Function1 v11 = this.drawDragDecoration;
        DrawParams v5 = v0.getDrawParams();
        Density v6 = v5.component1();
        LayoutDirection v7 = v5.component2();
        androidx.compose.ui.graphics.Canvas v8 = v5.component3();
        long v9 = v5.component4-NH-jbRc();
        v5 = v0.getDrawParams();
        v5.setDensity(v1);
        v5.setLayoutDirection(v4);
        v5.setCanvas(v12);
        v5.setSize-uvyYCjk(v2);
        v12.save();
        v11.invoke(v0);
        v12.restore();
        DrawParams v11_1 = v0.getDrawParams();
        v11_1.setDensity(v6);
        v11_1.setLayoutDirection(v7);
        v11_1.setCanvas(v8);
        v11_1.setSize-uvyYCjk(v9);
    }

    public void onProvideShadowMetrics(Point arg7, Point arg8) {
        arg7.set(this.density.roundToPx-0680j_4(this.density.toDp-u2uoSUM(Float.intBitsToFloat(((int)(this.decorationSize >> 0x20))))), this.density.roundToPx-0680j_4(this.density.toDp-u2uoSUM(Float.intBitsToFloat(((int)(this.decorationSize & 0xFFFFFFFFL))))));
        arg8.set(arg7.x / 2, arg7.y / 2);
    }
}

