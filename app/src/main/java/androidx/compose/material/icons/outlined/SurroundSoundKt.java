package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_surroundSound", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SurroundSound", "Landroidx/compose/material/icons/Icons$Outlined;", "getSurroundSound", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SurroundSoundKt {
    private static ImageVector _surroundSound;

    static {
    }

    public static final ImageVector getSurroundSound(Outlined arg19) {
        ImageVector v0 = SurroundSoundKt._surroundSound;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SurroundSound", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 4f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 4f, 2f, 4.9f, 2f, 6f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveTo(22f, 4.9f, 21.1f, 4f, 20f, 4f);
        v12.close();
        v12.moveTo(20f, 18f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(18f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8.29f, 15.71f);
        v12.curveTo(7.27f, 14.69f, 6.75f, 13.35f, 6.75f, 12f);
        v12.curveToRelative(0f, -1.35f, 0.52f, -2.69f, 1.53f, -3.72f);
        v12.lineTo(7.05f, 7.05f);
        v12.curveTo(5.68f, 8.41f, 5f, 10.21f, 5f, 12f);
        v12.reflectiveCurveToRelative(0.68f, 3.59f, 2.06f, 4.94f);
        v12.lineTo(8.29f, 15.71f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 15.5f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.curveToRelative(0f, -1.93f, -1.57f, -3.5f, -3.5f, -3.5f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, 1.57f, -3.5f, 3.5f);
        v12.curveTo(8.5f, 13.93f, 10.07f, 15.5f, 12f, 15.5f);
        v12.close();
        v12.moveTo(12f, 10.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f);
        v12.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(11.17f, 10.5f, 12f, 10.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15.72f, 15.72f);
        v12.lineToRelative(1.23f, 1.23f);
        v12.curveTo(18.32f, 15.59f, 19f, 13.79f, 19f, 12f);
        v12.reflectiveCurveToRelative(-0.68f, -3.59f, -2.06f, -4.94f);
        v12.lineToRelative(-1.23f, 1.23f);
        v12.curveToRelative(1.02f, 1.02f, 1.54f, 2.36f, 1.54f, 3.71f);
        v12.curveTo(17.25f, 13.35f, 16.73f, 14.69f, 15.72f, 15.72f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SurroundSoundKt._surroundSound = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

