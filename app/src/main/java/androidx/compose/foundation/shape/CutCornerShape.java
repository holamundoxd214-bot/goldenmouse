package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\r2\u0006\u0010\u0004\u001A\u00020\r2\u0006\u0010\u0005\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u001C\u0010\u001B\u001A\u0004\u0018\u00010\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u001C\u001A\u00020\rH\u0016¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/shape/CutCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "toString", "", "equals", "", "other", "", "hashCode", "", "lerp", "t", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CutCornerShape extends CornerBasedShape {
    public static final int $stable;

    static {
    }

    public CutCornerShape(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    public CornerBasedShape copy(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
        return this.copy(arg1, arg2, arg3, arg4);
    }

    public CutCornerShape copy(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
        return new CutCornerShape(arg1, arg2, arg3, arg4);
    }

    public Outline createOutline-LjSzlW0(long arg5, float arg7, float arg8, float arg9, float arg10, LayoutDirection arg11) {
        if(arg7 + arg8 + arg10 + arg9 == 0f) {
            return new Rectangle(SizeKt.toRect-uvyYCjk(arg5));
        }

        Path v4 = AndroidPath_androidKt.Path();
        float v1 = arg11 == LayoutDirection.Ltr ? arg7 : arg8;
        v4.moveTo(0f, v1);
        v4.lineTo(v1, 0f);
        if(arg11 == LayoutDirection.Ltr) {
            arg7 = arg8;
        }

        int v8 = ((int)(arg5 >> 0x20));
        v4.lineTo(Float.intBitsToFloat(v8) - arg7, 0f);
        v4.lineTo(Float.intBitsToFloat(v8), arg7);
        arg7 = arg11 == LayoutDirection.Ltr ? arg9 : arg10;
        int v5 = ((int)(arg5 & 0xFFFFFFFFL));
        v4.lineTo(Float.intBitsToFloat(v8), Float.intBitsToFloat(v5) - arg7);
        v4.lineTo(Float.intBitsToFloat(v8) - arg7, Float.intBitsToFloat(v5));
        if(arg11 == LayoutDirection.Ltr) {
            arg9 = arg10;
        }

        v4.lineTo(arg9, Float.intBitsToFloat(v5));
        v4.lineTo(0f, Float.intBitsToFloat(v5) - arg9);
        v4.close();
        return new Generic(v4);
    }

    public boolean equals(Object arg5) {
        if(this == (((CutCornerShape)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CutCornerShape)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getTopStart(), ((CutCornerShape)arg5).getTopStart())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getTopEnd(), ((CutCornerShape)arg5).getTopEnd())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getBottomEnd(), ((CutCornerShape)arg5).getBottomEnd())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getBottomStart(), ((CutCornerShape)arg5).getBottomStart())) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return ((this.getTopStart().hashCode() * 0x1F + this.getTopEnd().hashCode()) * 0x1F + this.getBottomEnd().hashCode()) * 0x1F + this.getBottomStart().hashCode();
    }

    public Object lerp(Object arg2, float arg3) {
        CutCornerShape v2;
        if((Intrinsics.areEqual(arg2, RectangleShapeKt.getRectangleShape())) || arg2 == null) {
            v2 = CutCornerShapeKt.CutCornerShape(0f);
        }

        if((v2 instanceof CutCornerShape)) {
            return CutCornerShapeKt.lerp(this, v2, arg3);
        }

        return null;
    }

    public String toString() {
        return "CutCornerShape(topStart = " + this.getTopStart() + ", topEnd = " + this.getTopEnd() + ", bottomEnd = " + this.getBottomEnd() + ", bottomStart = " + this.getBottomStart() + ')';
    }
}

