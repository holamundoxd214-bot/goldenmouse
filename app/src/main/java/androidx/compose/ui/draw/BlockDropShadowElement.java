package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B(\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0017\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u0010\u001A\u00020\u0002H\u0016J\u0010\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\u0002H\u0016J\f\u0010\u0013\u001A\u00020\b*\u00020\u0014H\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\"\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001B"}, d2={"Landroidx/compose/ui/draw/BlockDropShadowElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/BlockDropShadowNode;", "shape", "Landroidx/compose/ui/graphics/Shape;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/DropShadowScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getBlock", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BlockDropShadowElement extends ModifierNodeElement {
    public static final int $stable;
    private final Function1 block;
    private final Shape shape;

    static {
    }

    public BlockDropShadowElement(Shape arg1, Function1 arg2) {
        super();
        this.shape = arg1;
        this.block = arg2;
    }

    public Node create() {
        return this.create();
    }

    public BlockDropShadowNode create() {
        return new BlockDropShadowNode(this.shape, this.block);
    }

    public boolean equals(Object arg5) {
        if(this == (((BlockDropShadowElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof BlockDropShadowElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.shape, ((BlockDropShadowElement)arg5).shape)) {
            return 0;
        }

        if(this.block != ((BlockDropShadowElement)arg5).block) {
            return 0;
        }

        return 1;
    }

    public final Function1 getBlock() {
        return this.block;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public int hashCode() {
        return this.shape.hashCode() * 0x1F + this.block.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("dropShadow");
        arg4.getProperties().set("shape", this.shape);
        arg4.getProperties().set("block", this.block);
    }

    public void update(Node arg1) {
        this.update(((BlockDropShadowNode)arg1));
    }

    public void update(BlockDropShadowNode arg2) {
        arg2.update(this.shape, this.block);
    }
}

