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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_copyright", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Copyright", "Landroidx/compose/material/icons/Icons$Sharp;", "getCopyright", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CopyrightKt {
    private static ImageVector _copyright;

    static {
    }

    public static final ImageVector getCopyright(Sharp arg19) {
        ImageVector v0 = CopyrightKt._copyright;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Copyright", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.08f, 10.86f);
        v12.curveToRelative(0.05f, -0.33f, 0.16f, -0.62f, 0.3f, -0.87f);
        v12.reflectiveCurveToRelative(0.34f, -0.46f, 0.59f, -0.62f);
        v12.curveToRelative(0.24f, -0.15f, 0.54f, -0.22f, 0.91f, -0.23f);
        v12.curveToRelative(0.23f, 0.01f, 0.44f, 0.05f, 0.63f, 0.13f);
        v12.curveToRelative(0.2f, 0.09f, 0.38f, 0.21f, 0.52f, 0.36f);
        v12.reflectiveCurveToRelative(0.25f, 0.33f, 0.34f, 0.53f);
        v12.reflectiveCurveToRelative(0.13f, 0.42f, 0.14f, 0.64f);
        v12.horizontalLineToRelative(1.79f);
        v12.curveToRelative(-0.02f, -0.47f, -0.11f, -0.9f, -0.28f, -1.29f);
        v12.reflectiveCurveToRelative(-0.4f, -0.73f, -0.7f, -1.01f);
        v12.reflectiveCurveToRelative(-0.66f, -0.5f, -1.08f, -0.66f);
        v12.reflectiveCurveToRelative(-0.88f, -0.23f, -1.39f, -0.23f);
        v12.curveToRelative(-0.65f, 0f, -1.22f, 0.11f, -1.7f, 0.34f);
        v12.reflectiveCurveToRelative(-0.88f, 0.53f, -1.2f, 0.92f);
        v12.reflectiveCurveToRelative(-0.56f, 0.84f, -0.71f, 1.36f);
        v12.reflectiveCurveTo(8f, 11.29f, 8f, 11.87f);
        v12.verticalLineToRelative(0.27f);
        v12.curveToRelative(0f, 0.58f, 0.08f, 1.12f, 0.23f, 1.64f);
        v12.reflectiveCurveToRelative(0.39f, 0.97f, 0.71f, 1.35f);
        v12.reflectiveCurveToRelative(0.72f, 0.69f, 1.2f, 0.91f);
        v12.curveToRelative(0.48f, 0.22f, 1.05f, 0.34f, 1.7f, 0.34f);
        v12.curveToRelative(0.47f, 0f, 0.91f, -0.08f, 1.32f, -0.23f);
        v12.reflectiveCurveToRelative(0.77f, -0.36f, 1.08f, -0.63f);
        v12.reflectiveCurveToRelative(0.56f, -0.58f, 0.74f, -0.94f);
        v12.reflectiveCurveToRelative(0.29f, -0.74f, 0.3f, -1.15f);
        v12.horizontalLineToRelative(-1.79f);
        v12.curveToRelative(-0.01f, 0.21f, -0.06f, 0.4f, -0.15f, 0.58f);
        v12.reflectiveCurveToRelative(-0.21f, 0.33f, -0.36f, 0.46f);
        v12.reflectiveCurveToRelative(-0.32f, 0.23f, -0.52f, 0.3f);
        v12.curveToRelative(-0.19f, 0.07f, -0.39f, 0.09f, -0.6f, 0.1f);
        v12.curveToRelative(-0.36f, -0.01f, -0.66f, -0.08f, -0.89f, -0.23f);
        v12.curveToRelative(-0.25f, -0.16f, -0.45f, -0.37f, -0.59f, -0.62f);
        v12.reflectiveCurveToRelative(-0.25f, -0.55f, -0.3f, -0.88f);
        v12.reflectiveCurveToRelative(-0.08f, -0.67f, -0.08f, -1f);
        v12.verticalLineToRelative(-0.27f);
        v12.curveToRelative(0f, -0.35f, 0.03f, -0.68f, 0.08f, -1.01f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.41f, 0f, -8f, -3.59f, -8f, -8f);
        v12.reflectiveCurveToRelative(3.59f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.59f, 8f, 8f);
        v12.reflectiveCurveToRelative(-3.59f, 8f, -8f, 8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CopyrightKt._copyright = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

