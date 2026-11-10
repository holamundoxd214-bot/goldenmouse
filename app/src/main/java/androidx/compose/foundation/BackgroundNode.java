package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B)\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\f\u0010-\u001A\u00020.*\u00020/H\u0016J\b\u00100\u001A\u00020.H\u0016J\f\u00101\u001A\u00020.*\u00020/H\u0002J\f\u00102\u001A\u00020.*\u00020/H\u0002J\f\u00103\u001A\u00020**\u00020/H\u0002J\f\u00104\u001A\u00020.*\u000205H\u0016R\u001C\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0013\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001A\u0010\u000B\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020!X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020!X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b$\u0010#R\u0010\u0010%\u001A\u00020&X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\'\u001A\u0004\u0018\u00010(X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010)\u001A\u0004\u0018\u00010*X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010+\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010,\u001A\u0004\u0018\u00010*X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00066"}, d2={"Landroidx/compose/foundation/BackgroundNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "lastSize", "Landroidx/compose/ui/geometry/Size;", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastShape", "tmpOutline", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onObservedReadsChanged", "drawRect", "drawOutline", "getOutline", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class BackgroundNode extends Node implements DrawModifierNode, ObserverModifierNode, SemanticsModifierNode {
    private float alpha;
    private Brush brush;
    private long color;
    private final boolean isImportantForBounds;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Shape lastShape;
    private long lastSize;
    private Shape shape;
    private final boolean shouldAutoInvalidate;
    private Outline tmpOutline;

    public BackgroundNode(long arg1, Brush arg3, float arg4, Shape arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg3, arg4, arg5);
    }

    private BackgroundNode(long arg1, Brush arg3, float arg4, Shape arg5) {
        super();
        this.color = arg1;
        this.brush = arg3;
        this.alpha = arg4;
        this.shape = arg5;
        this.lastSize = Size.Companion.getUnspecified-NH-jbRc();
    }

    public void applySemantics(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setShape(arg1, this.shape);
    }

    public void draw(ContentDrawScope arg3) {
        if(this.shape == RectangleShapeKt.getRectangleShape()) {
            this.drawRect(arg3);
        }
        else {
            this.drawOutline(arg3);
        }

        arg3.drawContent();
    }

    private final void drawOutline(ContentDrawScope arg11) {
        Outline v1 = this.getOutline(arg11);
        if(!Color.equals-impl0(this.color, Color.Companion.getUnspecified-0d7_KjU())) {
            OutlineKt.drawOutline-wDX37Ww$default(arg11, v1, this.color, 0f, null, null, 0, 60, null);
        }

        Brush v2 = this.brush;
        if(v2 != null) {
            OutlineKt.drawOutline-hn5TExg$default(arg11, v1, v2, this.alpha, null, null, 0, 56, null);
        }
    }

    private final void drawRect(ContentDrawScope arg28) {
        BackgroundNode v0 = this;
        if(!Color.equals-impl0(v0.color, Color.Companion.getUnspecified-0d7_KjU())) {
            DrawScope.drawRect-n-J9OG0$default(arg28, v0.color, 0, 0, 0f, null, null, 0, 0x7E, null);
        }

        Brush v1 = v0.brush;
        if(v1 != null) {
            DrawScope.drawRect-AsUm42w$default(arg28, v1, 0, 0, v0.alpha, null, null, 0, 0x76, null);
        }
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    private final Outline getOutline(ContentDrawScope arg5) {
        Outline v0;
        if(!Size.equals-impl0(arg5.getSize-NH-jbRc(), this.lastSize) || arg5.getLayoutDirection() != this.lastLayoutDirection || !Intrinsics.areEqual(this.lastShape, this.shape)) {
            ObserverModifierNodeKt.observeReads(this, new BackgroundNode$$ExternalSyntheticLambda0(this, arg5));
            v0 = this.tmpOutline;
            this.tmpOutline = null;
        }
        else {
            v0 = this.lastOutline;
            Intrinsics.checkNotNull(v0);
        }

        this.lastOutline = v0;
        this.lastSize = arg5.getSize-NH-jbRc();
        this.lastLayoutDirection = arg5.getLayoutDirection();
        this.lastShape = this.shape;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    static final Unit getOutline$lambda$0(BackgroundNode arg4, ContentDrawScope arg5) {
        arg4.tmpOutline = arg4.shape.createOutline-Pq9zytI(arg5.getSize-NH-jbRc(), arg5.getLayoutDirection(), ((Density)arg5));
        return Unit.INSTANCE;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public boolean isImportantForBounds() {
        return this.isImportantForBounds;
    }

    public void onObservedReadsChanged() {
        this.lastSize = Size.Companion.getUnspecified-NH-jbRc();
        this.lastLayoutDirection = null;
        this.lastOutline = null;
        this.lastShape = null;
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
    }

    public final void setAlpha(float arg1) {
        this.alpha = arg1;
    }

    public final void setBrush(Brush arg1) {
        this.brush = arg1;
    }

    public final void setColor-8_81llA(long arg1) {
        this.color = arg1;
    }

    public final void setShape(Shape arg1) {
        this.shape = arg1;
    }
}

