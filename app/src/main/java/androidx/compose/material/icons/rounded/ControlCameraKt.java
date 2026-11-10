package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_controlCamera", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ControlCamera", "Landroidx/compose/material/icons/Icons$Rounded;", "getControlCamera", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ControlCameraKt {
    private static ImageVector _controlCamera;

    static {
    }

    public static final ImageVector getControlCamera(Rounded arg20) {
        ImageVector v0 = ControlCameraKt._controlCamera;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ControlCamera", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.65f, 9.35f);
        v12.lineTo(2.7f, 11.3f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(1.95f, 1.95f);
        v12.curveToRelative(0.49f, 0.49f, 1.28f, 0.49f, 1.77f, 0f);
        v12.curveToRelative(0.48f, -0.49f, 0.48f, -1.27f, 0f, -1.76f);
        v12.lineToRelative(-0.88f, -0.9f);
        v12.lineToRelative(0.88f, -0.89f);
        v12.curveToRelative(0.48f, -0.49f, 0.48f, -1.27f, 0f, -1.76f);
        v12.reflectiveCurveToRelative(-1.28f, -0.49f, -1.77f, 0f);
        v12.close();
        v12.moveTo(17.58f, 9.35f);
        v12.curveToRelative(-0.48f, 0.49f, -0.48f, 1.27f, 0f, 1.76f);
        v12.lineToRelative(0.88f, 0.89f);
        v12.lineToRelative(-0.88f, 0.89f);
        v12.curveToRelative(-0.48f, 0.49f, -0.48f, 1.27f, 0f, 1.76f);
        v12.curveToRelative(0.49f, 0.49f, 1.28f, 0.49f, 1.77f, 0f);
        v12.lineToRelative(1.95f, -1.95f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-1.95f, -1.95f);
        v12.curveToRelative(-0.49f, -0.48f, -1.29f, -0.48f, -1.77f, 0.01f);
        v12.close();
        v12.moveTo(12f, 18.459999f);
        v12.lineToRelative(-0.89f, -0.88f);
        v12.curveToRelative(-0.49f, -0.48f, -1.27f, -0.48f, -1.76f, 0f);
        v12.curveToRelative(-0.49f, 0.49f, -0.49f, 1.28f, 0f, 1.77f);
        v12.lineToRelative(1.95f, 1.95f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(1.95f, -1.95f);
        v12.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0f, -1.77f);
        v12.curveToRelative(-0.49f, -0.48f, -1.27f, -0.48f, -1.76f, 0f);
        v12.lineToRelative(-0.9f, 0.88f);
        v12.close();
        v12.moveTo(9.35f, 6.42f);
        v12.curveToRelative(0.49f, 0.48f, 1.27f, 0.48f, 1.76f, 0f);
        v12.lineToRelative(0.89f, -0.88f);
        v12.lineToRelative(0.89f, 0.88f);
        v12.curveToRelative(0.49f, 0.48f, 1.27f, 0.48f, 1.76f, 0f);
        v12.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0f, -1.77f);
        v12.lineTo(12.7f, 2.7f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineTo(9.35f, 4.65f);
        v12.curveToRelative(-0.49f, 0.49f, -0.49f, 1.29f, 0f, 1.77f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 12f);
        v12.moveToRelative(-3f, 0f);
        v12.arcToRelative(3f, 3f, 0f, true, true, 6f, 0f);
        v12.arcToRelative(3f, 3f, 0f, true, true, -6f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ControlCameraKt._controlCamera = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

