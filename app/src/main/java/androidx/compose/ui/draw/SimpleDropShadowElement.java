package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001A\u00020\u0002H\u0016J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0002H\u0016J\f\u0010\u0011\u001A\u00020\u000F*\u00020\u0012H\u0016J\t\u0010\u0013\u001A\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0006HÆ\u0003J\u001D\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u001E"}, d2={"Landroidx/compose/ui/draw/SimpleDropShadowElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/SimpleDropShadowNode;", "shape", "Landroidx/compose/ui/graphics/Shape;", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getShadow", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SimpleDropShadowElement extends ModifierNodeElement {
    public static final int $stable;
    private final Shadow shadow;
    private final Shape shape;

    static {
    }

    public SimpleDropShadowElement(Shape arg1, Shadow arg2) {
        super();
        this.shape = arg1;
        this.shadow = arg2;
    }

    public final Shape component1() {
        return this.shape;
    }

    public final Shadow component2() {
        return this.shadow;
    }

    public final SimpleDropShadowElement copy(Shape arg1, Shadow arg2) {
        return new SimpleDropShadowElement(arg1, arg2);
    }

    public static SimpleDropShadowElement copy$default(SimpleDropShadowElement arg0, Shape arg1, Shadow arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.shape;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.shadow;
        }

        return arg0.copy(arg1, arg2);
    }

    public Node create() {
        return this.create();
    }

    public SimpleDropShadowNode create() {
        return new SimpleDropShadowNode(this.shape, this.shadow);
    }

    public boolean equals(Object arg5) {
        if(this == (((SimpleDropShadowElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SimpleDropShadowElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.shape, ((SimpleDropShadowElement)arg5).shape)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.shadow, ((SimpleDropShadowElement)arg5).shadow)) {
            return 0;
        }

        return 1;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public int hashCode() {
        return this.shape.hashCode() * 0x1F + this.shadow.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg5) {
        arg5.setName("dropShadow");
        arg5.getProperties().set("shape", this.shape);
        arg5.getProperties().set("dropShadow", this.shadow);
    }

    public String toString() {
        return "SimpleDropShadowElement(shape=" + this.shape + ", shadow=" + this.shadow + ')';
    }

    public void update(Node arg1) {
        this.update(((SimpleDropShadowNode)arg1));
    }

    public void update(SimpleDropShadowNode arg2) {
        arg2.update(this.shape, this.shadow);
    }
}

