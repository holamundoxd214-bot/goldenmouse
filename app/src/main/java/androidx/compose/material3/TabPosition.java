package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001A\u00020\u0013H\u0016J\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\tR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\f\u0010\tR\u0011\u0010\r\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\t¨\u0006\u0016"}, d2={"Landroidx/compose/material3/TabPosition;", "", "left", "Landroidx/compose/ui/unit/Dp;", "width", "contentWidth", "<init>", "(FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM", "()F", "F", "getWidth-D9Ej5fM", "getContentWidth-D9Ej5fM", "right", "getRight-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TabPosition {
    public static final int $stable;
    private final float contentWidth;
    private final float left;
    private final float width;

    static {
    }

    private TabPosition(float arg1, float arg2, float arg3) {
        super();
        this.left = arg1;
        this.width = arg2;
        this.contentWidth = arg3;
    }

    public TabPosition(float arg1, float arg2, float arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((TabPosition)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TabPosition)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.left, ((TabPosition)arg5).left)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.width, ((TabPosition)arg5).width)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.contentWidth, ((TabPosition)arg5).contentWidth)) {
            return 0;
        }

        return 1;
    }

    public final float getContentWidth-D9Ej5fM() {
        return this.contentWidth;
    }

    public final float getLeft-D9Ej5fM() {
        return this.left;
    }

    public final float getRight-D9Ej5fM() {
        return Dp.constructor-impl(this.left + this.width);
    }

    public final float getWidth-D9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.hashCode-impl(this.left) * 0x1F + Dp.hashCode-impl(this.width)) * 0x1F + Dp.hashCode-impl(this.contentWidth);
    }

    public String toString() {
        return "TabPosition(left=" + Dp.toString-impl(this.left) + ", right=" + Dp.toString-impl(this.getRight-D9Ej5fM()) + ", width=" + Dp.toString-impl(this.width) + ", contentWidth=" + Dp.toString-impl(this.contentWidth) + ')';
    }
}

