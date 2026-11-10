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

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0016\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u0003H\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016J\u001C\u0010\u001F\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\u0006\u0010 \u001A\u00020\u000EH\u0016¨\u0006!"}, d2={"Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topLeft", "Landroidx/compose/foundation/shape/CornerSize;", "topRight", "bottomRight", "bottomLeft", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "topStart", "", "topEnd", "bottomEnd", "bottomStart", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "toString", "", "equals", "", "other", "", "hashCode", "", "lerp", "t", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AbsoluteCutCornerShape extends CornerBasedShape {
    public static final int $stable;

    static {
    }

    public AbsoluteCutCornerShape(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    public AbsoluteCutCornerShape copy(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
        return new AbsoluteCutCornerShape(arg1, arg2, arg3, arg4);
    }

    public CornerBasedShape copy(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
        return this.copy(arg1, arg2, arg3, arg4);
    }

    public Outline createOutline-LjSzlW0(long arg3, float arg5, float arg6, float arg7, float arg8, LayoutDirection arg9) {
        if(arg5 + arg6 + arg8 + arg7 == 0f) {
            return new Rectangle(SizeKt.toRect-uvyYCjk(arg3));
        }

        Path v2 = AndroidPath_androidKt.Path();
        v2.moveTo(0f, arg5);
        v2.lineTo(arg5, 0f);
        int v5 = ((int)(arg3 >> 0x20));
        v2.lineTo(Float.intBitsToFloat(v5) - arg6, 0f);
        v2.lineTo(Float.intBitsToFloat(v5), arg6);
        int v3 = ((int)(arg3 & 0xFFFFFFFFL));
        v2.lineTo(Float.intBitsToFloat(v5), Float.intBitsToFloat(v3) - arg7);
        v2.lineTo(Float.intBitsToFloat(v5) - arg7, Float.intBitsToFloat(v3));
        v2.lineTo(arg8, Float.intBitsToFloat(v3));
        v2.lineTo(0f, Float.intBitsToFloat(v3) - arg8);
        v2.close();
        return new Generic(v2);
    }

    public boolean equals(Object arg5) {
        if(this == (((AbsoluteCutCornerShape)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AbsoluteCutCornerShape)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getTopStart(), ((AbsoluteCutCornerShape)arg5).getTopStart())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getTopEnd(), ((AbsoluteCutCornerShape)arg5).getTopEnd())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getBottomEnd(), ((AbsoluteCutCornerShape)arg5).getBottomEnd())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getBottomStart(), ((AbsoluteCutCornerShape)arg5).getBottomStart())) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return ((this.getTopStart().hashCode() * 0x1F + this.getTopEnd().hashCode()) * 0x1F + this.getBottomEnd().hashCode()) * 0x1F + this.getBottomStart().hashCode();
    }

    public Object lerp(Object arg2, float arg3) {
        AbsoluteCutCornerShape v2;
        if((Intrinsics.areEqual(arg2, RectangleShapeKt.getRectangleShape())) || arg2 == null) {
            v2 = AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(0f);
        }

        if((v2 instanceof AbsoluteCutCornerShape)) {
            return AbsoluteCutCornerShapeKt.lerp(this, v2, arg3);
        }

        return null;
    }

    public String toString() {
        return "AbsoluteCutCornerShape(topLeft = " + this.getTopStart() + ", topRight = " + this.getTopEnd() + ", bottomRight = " + this.getBottomEnd() + ", bottomLeft = " + this.getBottomStart() + ')';
    }
}

