package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001A\u00020\u0002H\u0016J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0002H\u0016J\f\u0010\u0016\u001A\u00020\u0014*\u00020\u0017H\u0016J\u0010\u0010\u0018\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\fJ\t\u0010\u001A\u001A\u00020\u0006HÆ\u0003J\t\u0010\u001B\u001A\u00020\bHÆ\u0003J.\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001¢\u0006\u0004\b\u001D\u0010\u001EJ\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001A\u00020$HÖ\u0001J\t\u0010%\u001A\u00020&HÖ\u0001R\u0013\u0010\u0003\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\'"}, d2={"Landroidx/compose/foundation/BorderModifierNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/BorderModifierNode;", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "shape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWidth-D9Ej5fM", "()F", "F", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/foundation/BorderModifierNodeElement;", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BorderModifierNodeElement extends ModifierNodeElement {
    public static final int $stable;
    private final Brush brush;
    private final Shape shape;
    private final float width;

    static {
    }

    public BorderModifierNodeElement(float arg1, Brush arg2, Shape arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    private BorderModifierNodeElement(float arg1, Brush arg2, Shape arg3) {
        super();
        this.width = arg1;
        this.brush = arg2;
        this.shape = arg3;
    }

    public final float component1-D9Ej5fM() {
        return this.width;
    }

    public final Brush component2() {
        return this.brush;
    }

    public final Shape component3() {
        return this.shape;
    }

    public final BorderModifierNodeElement copy-8Feqmps(float arg2, Brush arg3, Shape arg4) {
        return new BorderModifierNodeElement(arg2, arg3, arg4, null);
    }

    public static BorderModifierNodeElement copy-8Feqmps$default(BorderModifierNodeElement arg0, float arg1, Brush arg2, Shape arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.width;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.brush;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.shape;
        }

        return arg0.copy-8Feqmps(arg1, arg2, arg3);
    }

    public BorderModifierNode create() {
        return new BorderModifierNode(this.width, this.brush, this.shape, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((BorderModifierNodeElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof BorderModifierNodeElement)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.width, ((BorderModifierNodeElement)arg5).width)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.brush, ((BorderModifierNodeElement)arg5).brush)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.shape, ((BorderModifierNodeElement)arg5).shape)) {
            return 0;
        }

        return 1;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final float getWidth-D9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.hashCode-impl(this.width) * 0x1F + this.brush.hashCode()) * 0x1F + this.shape.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("border");
        arg4.getProperties().set("width", Dp.box-impl(this.width));
        if((this.brush instanceof SolidColor)) {
            arg4.getProperties().set("color", Color.box-impl(this.brush.getValue-0d7_KjU()));
            arg4.setValue(Color.box-impl(this.brush.getValue-0d7_KjU()));
        }
        else {
            arg4.getProperties().set("brush", this.brush);
        }

        arg4.getProperties().set("shape", this.shape);
    }

    public String toString() {
        return "BorderModifierNodeElement(width=" + Dp.toString-impl(this.width) + ", brush=" + this.brush + ", shape=" + this.shape + ')';
    }

    public void update(BorderModifierNode arg2) {
        arg2.setWidth-0680j_4(this.width);
        arg2.setBrush(this.brush);
        arg2.setShape(this.shape);
    }

    public void update(Node arg1) {
        this.update(((BorderModifierNode)arg1));
    }
}

