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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_socialDistance", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SocialDistance", "Landroidx/compose/material/icons/Icons$Rounded;", "getSocialDistance", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SocialDistanceKt {
    private static ImageVector _socialDistance;

    static {
    }

    public static final ImageVector getSocialDistance(Rounded arg19) {
        ImageVector v0 = SocialDistanceKt._socialDistance;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SocialDistance", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 5f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(4f, 6.1f, 4f, 5f);
        v12.close();
        v12.moveTo(8.78f, 8.58f);
        v12.curveTo(7.93f, 8.21f, 6.99f, 8f, 6f, 8f);
        v12.reflectiveCurveTo(4.07f, 8.21f, 3.22f, 8.58f);
        v12.curveTo(2.48f, 8.9f, 2f, 9.62f, 2f, 10.43f);
        v12.lineTo(2f, 11f);
        v12.horizontalLineToRelative(8f);
        v12.lineToRelative(0f, -0.57f);
        v12.curveTo(10f, 9.62f, 9.52f, 8.9f, 8.78f, 8.58f);
        v12.close();
        v12.moveTo(18f, 7f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.curveTo(16f, 6.1f, 16.9f, 7f, 18f, 7f);
        v12.close();
        v12.moveTo(20.780001f, 8.58f);
        v12.curveTo(19.93f, 8.21f, 18.99f, 8f, 18f, 8f);
        v12.curveToRelative(-0.99f, 0f, -1.93f, 0.21f, -2.78f, 0.58f);
        v12.curveTo(14.48f, 8.9f, 14f, 9.62f, 14f, 10.43f);
        v12.lineTo(14f, 11f);
        v12.horizontalLineToRelative(8f);
        v12.lineToRelative(0f, -0.57f);
        v12.curveTo(22f, 9.62f, 21.52f, 8.9f, 20.780001f, 8.58f);
        v12.close();
        v12.moveTo(21.65f, 16.65f);
        v12.lineToRelative(-2.79f, -2.79f);
        v12.curveTo(18.540001f, 13.54f, 18f, 13.76f, 18f, 14.21f);
        v12.verticalLineTo(16f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-1.79f);
        v12.curveToRelative(0f, -0.45f, -0.54f, -0.67f, -0.85f, -0.35f);
        v12.lineToRelative(-2.79f, 2.79f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(2.79f, 2.79f);
        v12.curveTo(5.46f, 20.459999f, 6f, 20.24f, 6f, 19.790001f);
        v12.verticalLineTo(18f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(1.79f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        v12.lineToRelative(2.79f, -2.79f);
        v12.curveTo(21.84f, 17.16f, 21.84f, 16.84f, 21.65f, 16.65f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SocialDistanceKt._socialDistance = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

