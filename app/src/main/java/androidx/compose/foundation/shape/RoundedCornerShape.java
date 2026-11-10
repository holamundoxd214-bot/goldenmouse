package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\r2\u0006\u0010\u0004\u001A\u00020\r2\u0006\u0010\u0005\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u001C\u0010\u001B\u001A\u0004\u0018\u00010\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u001C\u001A\u00020\rH\u0016¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/shape/RoundedCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "toString", "", "equals", "", "other", "", "hashCode", "", "lerp", "t", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RoundedCornerShape extends CornerBasedShape {
    public static final int $stable;

    static {
    }

    public RoundedCornerShape(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    public CornerBasedShape copy(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
        return this.copy(arg1, arg2, arg3, arg4);
    }

    public RoundedCornerShape copy(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
        return new RoundedCornerShape(arg1, arg2, arg3, arg4);
    }

    public Outline createOutline-LjSzlW0(long arg19, float arg21, float arg22, float arg23, float arg24, LayoutDirection arg25) {
        LayoutDirection v0 = arg25;
        if(arg21 + arg22 + arg23 + arg24 == 0f) {
            return new Rectangle(SizeKt.toRect-uvyYCjk(arg19));
        }

        Rect v2 = SizeKt.toRect-uvyYCjk(arg19);
        float v3 = v0 == LayoutDirection.Ltr ? arg21 : arg22;
        long v4 = ((long)Float.floatToRawIntBits(v3));
        long v6 = ((long)Float.floatToRawIntBits(v3));
        int v3_1 = 0x20;
        long v8 = 0xFFFFFFFFL;
        v4 = CornerRadius.constructor-impl(v4 << v3_1 | v6 & v8);
        float v6_1 = v0 == LayoutDirection.Ltr ? arg22 : arg21;
        v6 = CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(v6_1))) & v8 | (((long)Float.floatToRawIntBits(v6_1))) << v3_1);
        float v10 = v0 == LayoutDirection.Ltr ? arg23 : arg24;
        long v10_1 = CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(v10))) << v3_1 | (((long)Float.floatToRawIntBits(v10))) & v8);
        float v0_1 = v0 == LayoutDirection.Ltr ? arg24 : arg23;
        return new Rounded(RoundRectKt.RoundRect-ZAM2FJo(v2, v4, v6, v10_1, CornerRadius.constructor-impl(v8 & (((long)Float.floatToRawIntBits(v0_1))) | (((long)Float.floatToRawIntBits(v0_1))) << v3_1)));
    }

    public boolean equals(Object arg5) {
        if(this == (((RoundedCornerShape)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RoundedCornerShape)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getTopStart(), ((RoundedCornerShape)arg5).getTopStart())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getTopEnd(), ((RoundedCornerShape)arg5).getTopEnd())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getBottomEnd(), ((RoundedCornerShape)arg5).getBottomEnd())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getBottomStart(), ((RoundedCornerShape)arg5).getBottomStart())) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return ((this.getTopStart().hashCode() * 0x1F + this.getTopEnd().hashCode()) * 0x1F + this.getBottomEnd().hashCode()) * 0x1F + this.getBottomStart().hashCode();
    }

    public Object lerp(Object arg2, float arg3) {
        RoundedCornerShape v2;
        if((Intrinsics.areEqual(arg2, RectangleShapeKt.getRectangleShape())) || arg2 == null) {
            v2 = RoundedCornerShapeKt.RoundedCornerShape(0f);
        }

        if((v2 instanceof RoundedCornerShape)) {
            return RoundedCornerShapeKt.lerp(this, v2, arg3);
        }

        return null;
    }

    public String toString() {
        return "RoundedCornerShape(topStart = " + this.getTopStart() + ", topEnd = " + this.getTopEnd() + ", bottomEnd = " + this.getBottomEnd() + ", bottomStart = " + this.getBottomStart() + ')';
    }
}

