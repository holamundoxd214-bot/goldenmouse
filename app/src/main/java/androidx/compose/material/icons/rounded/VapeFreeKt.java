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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_vapeFree", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VapeFree", "Landroidx/compose/material/icons/Icons$Rounded;", "getVapeFree", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VapeFreeKt {
    private static ImageVector _vapeFree;

    static {
    }

    public static final ImageVector getVapeFree(Rounded arg19) {
        ImageVector v0 = VapeFreeKt._vapeFree;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.VapeFree", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.49f, 21.9f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(-2.9f, -2.9f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(5.17f);
        v12.lineTo(2.1f, 4.93f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.reflectiveCurveToRelative(1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(16.969999f, 16.969999f);
        v12.curveTo(20.879999f, 20.879999f, 20.879999f, 21.51f, 20.49f, 21.9f);
        v12.close();
        v12.moveTo(18.83f, 16f);
        v12.horizontalLineToRelative(1.67f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.curveToRelative(0f, 0.46f, -0.21f, 0.87f, -0.53f, 1.14f);
        v12.lineTo(18.83f, 16f);
        v12.close();
        v12.moveTo(10.5f, 17f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f);
        v12.reflectiveCurveTo(10.78f, 17f, 10.5f, 17f);
        v12.close();
        v12.moveTo(18.85f, 7.73f);
        v12.curveToRelative(0.62f, -0.61f, 1f, -1.45f, 1f, -2.38f);
        v12.curveToRelative(0f, -1.51f, -1f, -2.79f, -2.38f, -3.21f);
        v12.curveTo(16.99f, 2f, 16.5f, 2.36f, 16.5f, 2.86f);
        v12.curveToRelative(0f, 0.33f, 0.21f, 0.62f, 0.52f, 0.71f);
        v12.curveToRelative(0.77f, 0.23f, 1.33f, 0.94f, 1.33f, 1.78f);
        v12.curveToRelative(0f, 0.82f, -0.53f, 1.51f, -1.27f, 1.76f);
        v12.curveTo(16.75f, 7.22f, 16.5f, 7.5f, 16.5f, 7.85f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, 0.37f, 0.27f, 0.69f, 0.64f, 0.75f);
        v12.curveToRelative(1.93f, 0.31f, 3.36f, 2f, 3.36f, 4.02f);
        v12.verticalLineToRelative(1.48f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(22f, 14.66f, 22f, 14.25f);
        v12.verticalLineToRelative(-1.49f);
        v12.curveTo(22f, 10.54f, 20.719999f, 8.62f, 18.85f, 7.73f);
        v12.close();
        v12.moveTo(14.48f, 11.65f);
        v12.curveToRelative(0.04f, 0f, 0.09f, 0f, 0.13f, 0f);
        v12.horizontalLineToRelative(1.42f);
        v12.curveToRelative(1.05f, 0f, 1.97f, 0.74f, 1.97f, 2.05f);
        v12.verticalLineToRelative(0.55f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.76f, 0.75f);
        v12.curveToRelative(0.41f, 0f, 0.75f, -0.33f, 0.75f, -0.75f);
        v12.verticalLineToRelative(-0.89f);
        v12.curveToRelative(-0.01f, -1.81f, -1.61f, -3.16f, -3.48f, -3.16f);
        v12.horizontalLineToRelative(-1.3f);
        v12.curveToRelative(-1.02f, 0f, -1.94f, -0.73f, -2.07f, -1.75f);
        v12.curveToRelative(-0.12f, -0.95f, 0.46f, -1.7f, 1.3f, -1.93f);
        v12.curveToRelative(0.32f, -0.09f, 0.54f, -0.38f, 0.54f, -0.72f);
        v12.curveToRelative(0f, -0.49f, -0.46f, -0.86f, -0.93f, -0.72f);
        v12.curveToRelative(-1.41f, 0.41f, -2.43f, 1.71f, -2.42f, 3.24f);
        v12.lineTo(14.48f, 11.65f);
        v12.close();
        v12.moveTo(3f, 18.5f);
        v12.curveToRelative(1.33f, 0f, 2.71f, 0.18f, 4f, 0.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(-1.29f, 0.32f, -2.67f, 0.5f, -4f, 0.5f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveTo(2.45f, 18.5f, 3f, 18.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VapeFreeKt._vapeFree = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

