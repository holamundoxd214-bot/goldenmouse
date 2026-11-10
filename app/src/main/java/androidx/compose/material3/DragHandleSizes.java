package androidx.compose.material3;

import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\tR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\f\u0010\t¨\u0006\u0012"}, d2={"Landroidx/compose/material3/DragHandleSizes;", "", "size", "Landroidx/compose/ui/unit/DpSize;", "pressedSize", "draggedSize", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSize-MYxV2XQ", "()J", "J", "getPressedSize-MYxV2XQ", "getDraggedSize-MYxV2XQ", "equals", "", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragHandleSizes {
    public static final int $stable;
    private final long draggedSize;
    private final long pressedSize;
    private final long size;

    static {
    }

    private DragHandleSizes(long arg1, long arg3, long arg5) {
        super();
        this.size = arg1;
        this.pressedSize = arg3;
        this.draggedSize = arg5;
    }

    public DragHandleSizes(long arg1, long arg3, long arg5, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg5);
    }

    public boolean equals(Object arg7) {
        if(this == (((DragHandleSizes)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof DragHandleSizes)) {
            }
            else if(!DpSize.equals-impl0(this.size, ((DragHandleSizes)arg7).size)) {
                return 0;
            }
            else if(!DpSize.equals-impl0(this.pressedSize, ((DragHandleSizes)arg7).pressedSize)) {
                return 0;
            }
            else if(!DpSize.equals-impl0(this.draggedSize, ((DragHandleSizes)arg7).draggedSize)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getDraggedSize-MYxV2XQ() {
        return this.draggedSize;
    }

    public final long getPressedSize-MYxV2XQ() {
        return this.pressedSize;
    }

    public final long getSize-MYxV2XQ() {
        return this.size;
    }

    public int hashCode() {
        return (DpSize.hashCode-impl(this.size) * 0x1F + DpSize.hashCode-impl(this.pressedSize)) * 0x1F + DpSize.hashCode-impl(this.draggedSize);
    }
}

