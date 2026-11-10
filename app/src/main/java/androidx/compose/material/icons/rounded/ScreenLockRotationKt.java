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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_screenLockRotation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScreenLockRotation", "Landroidx/compose/material/icons/Icons$Rounded;", "getScreenLockRotation", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScreenLockRotationKt {
    private static ImageVector _screenLockRotation;

    static {
    }

    public static final ImageVector getScreenLockRotation(Rounded arg19) {
        ImageVector v0 = ScreenLockRotationKt._screenLockRotation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ScreenLockRotation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.41f, 11.36f);
        v12.lineToRelative(-0.35f, -0.35f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(19f, 12.77f);
        v12.lineToRelative(-4.24f, 4.24f);
        v12.lineTo(6.98f, 9.23f);
        v12.lineToRelative(4.24f, -4.24f);
        v12.lineToRelative(0.35f, 0.35f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-0.35f, -0.36f);
        v12.curveToRelative(-0.79f, -0.79f, -2.03f, -0.79f, -2.82f, 0f);
        v12.lineTo(5.57f, 7.82f);
        v12.curveToRelative(-0.78f, 0.78f, -0.78f, 2.05f, 0f, 2.83f);
        v12.lineToRelative(7.78f, 7.78f);
        v12.curveToRelative(0.79f, 0.79f, 2.03f, 0.79f, 2.82f, 0f);
        v12.lineToRelative(4.24f, -4.24f);
        v12.curveTo(21.200001f, 13.41f, 21.200001f, 12.14f, 20.41f, 11.36f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(10.85f, 17.85f);
        v12.curveTo(10.54f, 17.540001f, 10f, 17.76f, 10f, 18.209999f);
        v12.verticalLineToRelative(1.53f);
        v12.curveToRelative(-3.17f, -0.82f, -5.59f, -3.54f, -5.95f, -6.86f);
        v12.curveTo(3.99f, 12.37f, 3.56f, 12f, 3.06f, 12f);
        v12.curveToRelative(-0.6f, 0f, -1.07f, 0.53f, -1f, 1.12f);
        v12.curveTo(2.62f, 18.110001f, 6.87f, 22f, 12f, 22f);
        v12.curveToRelative(0.59f, 0f, 1.17f, -0.06f, 1.73f, -0.16f);
        v12.curveToRelative(0.4f, -0.07f, 0.55f, -0.56f, 0.27f, -0.85f);
        v12.lineTo(10.85f, 17.85f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16f, 9f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(5f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.verticalLineTo(3.11f);
        v12.curveToRelative(0f, -1f, -0.68f, -1.92f, -1.66f, -2.08f);
        v12.curveTo(17.08f, 0.82f, 16f, 1.79f, 16f, 3f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(15f, 8.55f, 15.45f, 9f, 16f, 9f);
        v12.close();
        v12.moveTo(17f, 3f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScreenLockRotationKt._screenLockRotation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

