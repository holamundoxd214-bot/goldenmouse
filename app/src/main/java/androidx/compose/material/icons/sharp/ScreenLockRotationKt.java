package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_screenLockRotation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScreenLockRotation", "Landroidx/compose/material/icons/Icons$Sharp;", "getScreenLockRotation", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScreenLockRotationKt {
    private static ImageVector _screenLockRotation;

    static {
    }

    public static final ImageVector getScreenLockRotation(Sharp arg19) {
        ImageVector v0 = ScreenLockRotationKt._screenLockRotation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.ScreenLockRotation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.52f, 21.48f);
        v12.curveTo(4.25f, 19.940001f, 1.91f, 16.76f, 1.55f, 13f);
        v12.lineTo(0.05f, 13f);
        v12.curveTo(0.56f, 19.16f, 5.71f, 24f, 12f, 24f);
        v12.lineToRelative(0.66f, -0.03f);
        v12.lineToRelative(-3.81f, -3.82f);
        v12.lineToRelative(-1.33f, 1.33f);
        v12.close();
        v12.moveTo(20.049999f, 4f);
        v12.verticalLineToRelative(-0.36f);
        v12.curveToRelative(0f, -1.31f, -0.94f, -2.5f, -2.24f, -2.63f);
        v12.curveToRelative(-1.5f, -0.15f, -2.76f, 1.02f, -2.76f, 2.49f);
        v12.lineTo(15.05f, 4f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(7f);
        v12.lineTo(21.049999f, 4f);
        v12.horizontalLineToRelative(-1f);
        v12.close();
        v12.moveTo(19.25f, 4f);
        v12.horizontalLineToRelative(-3.4f);
        v12.verticalLineToRelative(-0.5f);
        v12.curveToRelative(0f, -0.94f, 0.76f, -1.7f, 1.7f, -1.7f);
        v12.reflectiveCurveToRelative(1.7f, 0.76f, 1.7f, 1.7f);
        v12.lineTo(19.25f, 4f);
        v12.close();
        v12.moveTo(19.73f, 11.2f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(2.22f, 2.22f);
        v12.lineToRelative(-5.66f, 5.66f);
        v12.lineTo(3.56f, 9.17f);
        v12.lineToRelative(5.66f, -5.66f);
        v12.lineToRelative(2.1f, 2.1f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(9.22f, 0.69f);
        v12.lineTo(0.74f, 9.17f);
        v12.lineToRelative(14.14f, 14.14f);
        v12.lineToRelative(8.48f, -8.48f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScreenLockRotationKt._screenLockRotation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

