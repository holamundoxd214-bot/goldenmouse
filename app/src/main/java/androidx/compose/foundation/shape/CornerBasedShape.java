package androidx.compose.foundation.shape;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\b\'\u0018\u00002\u00020\u00012\u00020\u0002B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J?\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0003\u001A\u00020\u00192\u0006\u0010\u0005\u001A\u00020\u00192\u0006\u0010\u0006\u001A\u00020\u00192\u0006\u0010\u0007\u001A\u00020\u00192\u0006\u0010\u0013\u001A\u00020\u0014H&¢\u0006\u0004\b\u001A\u0010\u001BJ0\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0004H&J\u001C\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\u0006\u0010 \u001A\u00020\u0019H\u0016J\u000E\u0010\u001C\u001A\u00020\u00002\u0006\u0010!\u001A\u00020\u0004R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0007\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000B¨\u0006\""}, d2={"Landroidx/compose/foundation/shape/CornerBasedShape;", "Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/ui/graphics/Interpolatable;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "getTopStart", "()Landroidx/compose/foundation/shape/CornerSize;", "getTopEnd", "getBottomEnd", "getBottomStart", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "lerp", "", "other", "t", "all", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class CornerBasedShape implements Interpolatable, Shape {
    public static final int $stable;
    private final CornerSize bottomEnd;
    private final CornerSize bottomStart;
    private final CornerSize topEnd;
    private final CornerSize topStart;

    static {
    }

    public CornerBasedShape(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
        super();
        this.topStart = arg1;
        this.topEnd = arg2;
        this.bottomEnd = arg3;
        this.bottomStart = arg4;
    }

    public abstract CornerBasedShape copy(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4);

    public final CornerBasedShape copy(CornerSize arg1) {
        return this.copy(arg1, arg1, arg1, arg1);
    }

    public static CornerBasedShape copy$default(CornerBasedShape arg0, CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.topStart;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.topEnd;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.bottomEnd;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.bottomStart;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    public abstract Outline createOutline-LjSzlW0(long arg1, float arg2, float arg3, float arg4, float arg5, LayoutDirection arg6);

    public final Outline createOutline-Pq9zytI(long arg11, LayoutDirection arg13, Density arg14) {
        float v4 = this.topStart.toPx-TmRCtEA(arg11, arg14);
        float v5 = this.topEnd.toPx-TmRCtEA(arg11, arg14);
        float v6 = this.bottomEnd.toPx-TmRCtEA(arg11, arg14);
        float v3 = this.bottomStart.toPx-TmRCtEA(arg11, arg14);
        float v7 = Size.getMinDimension-impl(arg11);
        float v8 = v4 + v3;
        if(v8 > v7) {
            v8 = v7 / v8;
            v4 *= v8;
            v3 *= v8;
        }

        v8 = v5 + v6;
        if(v8 > v7) {
            v7 /= v8;
            v5 *= v7;
            v6 *= v7;
        }

        int v7_1 = v4 < 0f || v5 < 0f || v6 < 0f || v3 < 0f ? 0 : 1;
        if(v7_1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Corner size in Px can\'t be negative(topStart = " + v4 + ", topEnd = " + v5 + ", bottomEnd = " + v6 + ", bottomStart = " + v3 + ")!");
        }

        return this.createOutline-LjSzlW0(arg11, v4, v5, v6, v3, arg13);
    }

    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    public final CornerSize getTopStart() {
        return this.topStart;
    }

    public Object lerp(Object arg1, float arg2) {
        return null;
    }
}

