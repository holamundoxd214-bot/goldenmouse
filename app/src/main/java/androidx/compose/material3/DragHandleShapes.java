package androidx.compose.material3;

import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\t¨\u0006\u0011"}, d2={"Landroidx/compose/material3/DragHandleShapes;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "pressedShape", "draggedShape", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getPressedShape", "getDraggedShape", "equals", "", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragHandleShapes {
    public static final int $stable;
    private final Shape draggedShape;
    private final Shape pressedShape;
    private final Shape shape;

    static {
    }

    public DragHandleShapes(Shape arg1, Shape arg2, Shape arg3) {
        super();
        this.shape = arg1;
        this.pressedShape = arg2;
        this.draggedShape = arg3;
    }

    public boolean equals(Object arg5) {
        if(this == (((DragHandleShapes)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(!(arg5 instanceof DragHandleShapes)) {
            }
            else if(!Intrinsics.areEqual(this.shape, ((DragHandleShapes)arg5).shape)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.pressedShape, ((DragHandleShapes)arg5).pressedShape)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.draggedShape, ((DragHandleShapes)arg5).draggedShape)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final Shape getDraggedShape() {
        return this.draggedShape;
    }

    public final Shape getPressedShape() {
        return this.pressedShape;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public int hashCode() {
        return (this.shape.hashCode() * 0x1F + this.pressedShape.hashCode()) * 0x1F + this.draggedShape.hashCode();
    }
}

