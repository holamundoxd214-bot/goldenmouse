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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_air", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Air", "Landroidx/compose/material/icons/Icons$Rounded;", "getAir", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AirKt {
    private static ImageVector _air;

    static {
    }

    public static final ImageVector getAir(Rounded arg19) {
        ImageVector v0 = AirKt._air;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Air", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.35f, 17.950001f);
        v12.curveToRelative(-0.28f, 0.89f, -1.01f, 1.62f, -1.9f, 1.9f);
        v12.curveToRelative(-1.51f, 0.48f, -2.94f, -0.23f, -3.59f, -1.42f);
        v12.curveTo(8.51f, 17.780001f, 9.03f, 17f, 9.77f, 17f);
        v12.horizontalLineToRelative(0.01f);
        v12.curveToRelative(0.34f, 0f, 0.68f, 0.16f, 0.84f, 0.46f);
        v12.curveToRelative(0.17f, 0.32f, 0.5f, 0.54f, 0.89f, 0.54f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(8.5f);
        v12.curveTo(13.46f, 14f, 15f, 15.9f, 14.35f, 17.950001f);
        v12.close();
        v12.moveTo(18.91f, 5.67f);
        v12.curveToRelative(-0.29f, -1.26f, -1.32f, -2.29f, -2.58f, -2.58f);
        v12.curveToRelative(-1.76f, -0.4f, -3.37f, 0.53f, -4.02f, 1.98f);
        v12.curveTo(12f, 5.74f, 12.48f, 6.5f, 13.21f, 6.5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.39f, 0f, 0.75f, -0.22f, 0.9f, -0.57f);
        v12.curveTo(14.34f, 5.38f, 14.87f, 5f, 15.5f, 5f);
        v12.curveTo(16.33f, 5f, 17f, 5.67f, 17f, 6.5f);
        v12.reflectiveCurveTo(16.33f, 8f, 15.5f, 8f);
        v12.horizontalLineTo(3f);
        v12.curveTo(2.45f, 8f, 2f, 8.45f, 2f, 9f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(12.5f);
        v12.curveTo(17.700001f, 10f, 19.43f, 7.96f, 18.91f, 5.67f);
        v12.close();
        v12.moveTo(18.4f, 11f);
        v12.lineTo(3f, 11f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(15.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.curveToRelative(0f, 0.63f, -0.38f, 1.16f, -0.93f, 1.39f);
        v12.curveToRelative(-0.36f, 0.15f, -0.57f, 0.51f, -0.57f, 0.9f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.73f, 0.76f, 1.21f, 1.43f, 0.91f);
        v12.curveToRelative(1.43f, -0.64f, 2.35f, -2.21f, 2f, -3.93f);
        v12.curveTo(21.59f, 12.13f, 20.07f, 11f, 18.4f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AirKt._air = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

