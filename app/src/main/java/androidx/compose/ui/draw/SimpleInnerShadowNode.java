package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.shadow.InnerShadowPainter;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001A\u00020\r2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\b\u0010\u000E\u001A\u00020\u000BH\u0002J\f\u0010\u000F\u001A\u00020\r*\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\rH\u0016J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/ui/draw/SimpleInnerShadowNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "shape", "Landroidx/compose/ui/graphics/Shape;", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;)V", "innerShadowPainter", "Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "update", "", "obtainPainter", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onObservedReadsChanged", "equals", "", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SimpleInnerShadowNode extends Node implements DrawModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private InnerShadowPainter innerShadowPainter;
    private Shadow shadow;
    private Shape shape;

    static {
    }

    public SimpleInnerShadowNode(Shape arg1, Shadow arg2) {
        super();
        this.shape = arg1;
        this.shadow = arg2;
    }

    public void draw(ContentDrawScope arg9) {
        Painter.draw-x_KDEd0$default(this.obtainPainter(), arg9, arg9.getSize-NH-jbRc(), 0f, null, 6, null);
        arg9.drawContent();
    }

    public boolean equals(Object arg5) {
        if(this == (((SimpleInnerShadowNode)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(!Intrinsics.areEqual(this.shape, ((SimpleInnerShadowNode)arg5).shape)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.shadow, ((SimpleInnerShadowNode)arg5).shadow)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public int hashCode() {
        return this.shape.hashCode() * 0x1F + this.shadow.hashCode();
    }

    private final InnerShadowPainter obtainPainter() {
        InnerShadowPainter v0 = this.innerShadowPainter;
        if(v0 == null) {
            v0 = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createInnerShadowPainter(this.shape, this.shadow);
            this.innerShadowPainter = v0;
        }

        return v0;
    }

    public void onObservedReadsChanged() {
        this.innerShadowPainter = null;
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
    }

    public final void update(Shape arg2, Shadow arg3) {
        if(!Intrinsics.areEqual(this.shape, arg2) || !Intrinsics.areEqual(this.shadow, arg3)) {
            this.innerShadowPainter = null;
        }

        this.shape = arg2;
        this.shadow = arg3;
    }
}

