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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_interpreterMode", "Landroidx/compose/ui/graphics/vector/ImageVector;", "InterpreterMode", "Landroidx/compose/material/icons/Icons$TwoTone;", "getInterpreterMode", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class InterpreterModeKt {
    private static ImageVector _interpreterMode;

    static {
    }

    public static final ImageVector getInterpreterMode(TwoTone arg19) {
        ImageVector v0 = InterpreterModeKt._interpreterMode;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.InterpreterMode", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.52f, 15.01f);
        v12.curveTo(15.35f, 15f, 15.18f, 15f, 15f, 15f);
        v12.curveToRelative(-2.37f, 0f, -4.29f, 0.73f, -5.48f, 1.34f);
        v12.curveTo(9.2f, 16.5f, 9f, 16.84f, 9f, 17.219999f);
        v12.verticalLineTo(18f);
        v12.lineToRelative(7.17f, 0f);
        v12.curveTo(15.74f, 17.26f, 15.4f, 16.24f, 15.52f, 15.01f);
        v12.close();
        v12.moveTo(13f, 8f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveTo(13f, 6.9f, 13f, 8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20.5f, 16.5f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.verticalLineToRelative(-2.5f);
        v12.curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.verticalLineTo(15f);
        v12.curveTo(22f, 15.83f, 21.33f, 16.5f, 20.5f, 16.5f);
        v12.close();
        v12.moveTo(20f, 20f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0f, 0f, 0f, -1.54f, 0f, -1.54f);
        v12.curveToRelative(1.69f, -0.24f, 3f, -1.7f, 3f, -3.46f);
        v12.horizontalLineToRelative(-1f);
        v12.curveToRelative(0f, 1.38f, -1.12f, 2.5f, -2.5f, 2.5f);
        v12.reflectiveCurveTo(18f, 16.379999f, 18f, 15f);
        v12.horizontalLineToRelative(-1f);
        v12.curveToRelative(0f, 1.76f, 1.31f, 3.22f, 3f, 3.46f);
        v12.curveTo(20f, 18.459999f, 20f, 20f, 20f, 20f);
        v12.close();
        v12.moveTo(9f, 12f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f);
        v12.curveToRelative(0.47f, 0f, 0.92f, 0.08f, 1.34f, 0.23f);
        v12.curveTo(9.5f, 5.26f, 9f, 6.57f, 9f, 8f);
        v12.curveToRelative(0f, 1.43f, 0.5f, 2.74f, 1.34f, 3.77f);
        v12.curveTo(9.92f, 11.92f, 9.47f, 12f, 9f, 12f);
        v12.close();
        v12.moveTo(7.11f, 13.13f);
        v12.curveTo(5.79f, 14.05f, 5f, 15.57f, 5f, 17.219999f);
        v12.verticalLineTo(20f);
        v12.horizontalLineTo(1f);
        v12.verticalLineToRelative(-2.78f);
        v12.curveToRelative(0f, -1.12f, 0.61f, -2.15f, 1.61f, -2.66f);
        v12.curveTo(3.85f, 13.92f, 5.37f, 13.37f, 7.11f, 13.13f);
        v12.close();
        v12.moveTo(11f, 8f);
        v12.curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 2.21f, -1.79f, 4f, -4f, 4f);
        v12.reflectiveCurveTo(11f, 10.21f, 11f, 8f);
        v12.close();
        v12.moveTo(13f, 8f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveTo(13f, 6.9f, 13f, 8f);
        v12.close();
        v12.moveTo(15f, 15f);
        v12.curveToRelative(-2.37f, 0f, -4.29f, 0.73f, -5.48f, 1.34f);
        v12.curveTo(9.2f, 16.5f, 9f, 16.84f, 9f, 17.219999f);
        v12.verticalLineTo(18f);
        v12.lineToRelative(7.17f, 0f);
        v12.curveToRelative(0.5f, 0.86f, 1.25f, 1.56f, 2.15f, 2f);
        v12.lineTo(7f, 20f);
        v12.verticalLineToRelative(-2.78f);
        v12.curveToRelative(0f, -1.12f, 0.61f, -2.15f, 1.61f, -2.66f);
        v12.curveTo(10.29f, 13.7f, 12.47f, 13f, 15f, 13f);
        v12.curveToRelative(0.39f, 0f, 0.77f, 0.02f, 1.14f, 0.05f);
        v12.curveToRelative(-0.33f, 0.59f, -0.55f, 1.26f, -0.62f, 1.96f);
        v12.curveTo(15.35f, 15f, 15.18f, 15f, 15f, 15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        InterpreterModeKt._interpreterMode = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

