package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\tR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\f\u0010\t¨\u0006\u0012"}, d2={"Landroidx/compose/material3/DragHandleColors;", "", "color", "Landroidx/compose/ui/graphics/Color;", "pressedColor", "draggedColor", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getPressedColor-0d7_KjU", "getDraggedColor-0d7_KjU", "equals", "", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragHandleColors {
    public static final int $stable;
    private final long color;
    private final long draggedColor;
    private final long pressedColor;

    static {
    }

    private DragHandleColors(long arg1, long arg3, long arg5) {
        super();
        this.color = arg1;
        this.pressedColor = arg3;
        this.draggedColor = arg5;
    }

    public DragHandleColors(long arg1, long arg3, long arg5, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg5);
    }

    public boolean equals(Object arg7) {
        if(this == (((DragHandleColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof DragHandleColors)) {
            }
            else if(!Color.equals-impl0(this.color, ((DragHandleColors)arg7).color)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.pressedColor, ((DragHandleColors)arg7).pressedColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.draggedColor, ((DragHandleColors)arg7).draggedColor)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    public final long getDraggedColor-0d7_KjU() {
        return this.draggedColor;
    }

    public final long getPressedColor-0d7_KjU() {
        return this.pressedColor;
    }

    public int hashCode() {
        return (Color.hashCode-impl(this.color) * 0x1F + Color.hashCode-impl(this.pressedColor)) * 0x1F + Color.hashCode-impl(this.draggedColor);
    }
}

