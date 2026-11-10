package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016J!\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/BorderStroke;", "", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "<init>", "(FLandroidx/compose/ui/graphics/Brush;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWidth-D9Ej5fM", "()F", "F", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "equals", "", "other", "hashCode", "", "toString", "", "copy", "copy-D5KLDUw", "(FLandroidx/compose/ui/graphics/Brush;)Landroidx/compose/foundation/BorderStroke;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BorderStroke {
    public static final int $stable;
    private final Brush brush;
    private final float width;

    static {
    }

    private BorderStroke(float arg1, Brush arg2) {
        super();
        this.width = arg1;
        this.brush = arg2;
    }

    public BorderStroke(float arg1, Brush arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public final BorderStroke copy-D5KLDUw(float arg2, Brush arg3) {
        return new BorderStroke(arg2, arg3, null);
    }

    public static BorderStroke copy-D5KLDUw$default(BorderStroke arg0, float arg1, Brush arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.width;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.brush;
        }

        return arg0.copy-D5KLDUw(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((BorderStroke)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof BorderStroke)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.width, ((BorderStroke)arg5).width)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.brush, ((BorderStroke)arg5).brush)) {
            return 0;
        }

        return 1;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final float getWidth-D9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return Dp.hashCode-impl(this.width) * 0x1F + this.brush.hashCode();
    }

    public String toString() {
        return "BorderStroke(width=" + Dp.toString-impl(this.width) + ", brush=" + this.brush + ')';
    }
}

