package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_screenLockRotation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScreenLockRotation", "Landroidx/compose/material/icons/Icons$TwoTone;", "getScreenLockRotation", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScreenLockRotationKt {
    private static ImageVector _screenLockRotation;

    static {
    }

    public static final ImageVector getScreenLockRotation(TwoTone arg19) {
        ImageVector v0 = ScreenLockRotationKt._screenLockRotation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.ScreenLockRotation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22.299999f, 13.77f);
        v12.lineToRelative(-2.57f, -2.57f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(2.22f, 2.22f);
        v12.lineToRelative(-5.66f, 5.66f);
        v12.lineTo(3.56f, 9.17f);
        v12.lineToRelative(5.66f, -5.66f);
        v12.lineToRelative(2.1f, 2.1f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(-2.45f, -2.45f);
        v12.curveToRelative(-0.59f, -0.59f, -1.54f, -0.59f, -2.12f, 0f);
        v12.lineTo(1.8f, 8.11f);
        v12.curveToRelative(-0.59f, 0.59f, -0.59f, 1.54f, 0f, 2.12f);
        v12.lineToRelative(12.02f, 12.02f);
        v12.curveToRelative(0.59f, 0.59f, 1.54f, 0.59f, 2.12f, 0f);
        v12.lineToRelative(6.36f, -6.36f);
        v12.curveToRelative(0.59f, -0.59f, 0.59f, -1.54f, 0f, -2.12f);
        v12.close();
        v12.moveTo(7.52f, 21.48f);
        v12.curveTo(4.25f, 19.940001f, 1.91f, 16.76f, 1.55f, 13f);
        v12.lineTo(0.05f, 13f);
        v12.curveTo(0.56f, 19.16f, 5.71f, 24f, 12f, 24f);
        v12.lineToRelative(0.66f, -0.03f);
        v12.lineToRelative(-3.81f, -3.82f);
        v12.lineToRelative(-1.33f, 1.33f);
        v12.close();
        v12.moveTo(15.05f, 10f);
        v12.horizontalLineToRelative(5f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.lineTo(21.049999f, 5f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.verticalLineToRelative(-0.5f);
        v12.curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        v12.reflectiveCurveToRelative(-2.5f, 1.12f, -2.5f, 2.5f);
        v12.lineTo(15.05f, 4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.close();
        v12.moveTo(15.85f, 3.5f);
        v12.curveToRelative(0f, -0.94f, 0.76f, -1.7f, 1.7f, -1.7f);
        v12.reflectiveCurveToRelative(1.7f, 0.76f, 1.7f, 1.7f);
        v12.lineTo(19.25f, 4f);
        v12.horizontalLineToRelative(-3.4f);
        v12.verticalLineToRelative(-0.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScreenLockRotationKt._screenLockRotation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

