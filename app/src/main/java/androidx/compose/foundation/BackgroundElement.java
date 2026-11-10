package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BF\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0017\u0010\u000B\u001A\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001A\u00020\u0002H\u0016J\u0010\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u0002H\u0016J\f\u0010\u0016\u001A\u00020\u000E*\u00020\rH\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002R\u0010\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001F\u0010\u000B\u001A\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/BackgroundElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/BackgroundNode;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "create", "update", "node", "inspectableProperties", "hashCode", "", "equals", "", "other", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class BackgroundElement extends ModifierNodeElement {
    private final float alpha;
    private final Brush brush;
    private final long color;
    private final Function1 inspectorInfo;
    private final Shape shape;

    private BackgroundElement(long arg1, Brush arg3, float arg4, Shape arg5, Function1 arg6) {
        super();
        this.color = arg1;
        this.brush = arg3;
        this.alpha = arg4;
        this.shape = arg5;
        this.inspectorInfo = arg6;
    }

    public BackgroundElement(long arg9, Brush arg11, float arg12, Shape arg13, Function1 arg14, int arg15, DefaultConstructorMarker arg16) {
        if((arg15 & 1) != 0) {
            arg9 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v1 = arg9;
        if((arg15 & 2) != 0) {
            arg11 = null;
        }

        this(v1, arg11, arg12, arg13, arg14, null);
    }

    public BackgroundElement(long arg1, Brush arg3, float arg4, Shape arg5, Function1 arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg4, arg5, arg6);
    }

    public BackgroundNode create() {
        return new BackgroundNode(this.color, this.brush, this.alpha, this.shape, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg6) {
        if((arg6 instanceof BackgroundElement)) {
        }
        else {
            BackgroundElement v6 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if((Color.equals-impl0(this.color, v6.color)) && (Intrinsics.areEqual(this.brush, v6.brush)) && this.alpha == v6.alpha && (Intrinsics.areEqual(this.shape, v6.shape))) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        int v0 = Color.hashCode-impl(this.color) * 0x1F;
        Brush v1 = this.brush;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return ((v0 + v1_1) * 0x1F + Float.hashCode(this.alpha)) * 0x1F + this.shape.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(BackgroundNode arg3) {
        arg3.setColor-8_81llA(this.color);
        arg3.setBrush(this.brush);
        arg3.setAlpha(this.alpha);
        if(!Intrinsics.areEqual(arg3.getShape(), this.shape)) {
            arg3.setShape(this.shape);
            SemanticsModifierNodeKt.invalidateSemantics(arg3);
        }

        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)arg3));
    }

    public void update(Node arg1) {
        this.update(((BackgroundNode)arg1));
    }
}

