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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panoramaWideAngle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaWideAngle", "Landroidx/compose/material/icons/Icons$Rounded;", "getPanoramaWideAngle", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanoramaWideAngleKt {
    private static ImageVector _panoramaWideAngle;

    static {
    }

    public static final ImageVector getPanoramaWideAngle(Rounded arg19) {
        ImageVector v0 = PanoramaWideAngleKt._panoramaWideAngle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PanoramaWideAngle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(2.45f, 0f, 4.71f, 0.2f, 7.29f, 0.64f);
        v12.curveToRelative(0.47f, 1.78f, 0.71f, 3.58f, 0.71f, 5.36f);
        v12.reflectiveCurveToRelative(-0.24f, 3.58f, -0.71f, 5.36f);
        v12.curveToRelative(-2.58f, 0.44f, -4.84f, 0.64f, -7.29f, 0.64f);
        v12.reflectiveCurveToRelative(-4.71f, -0.2f, -7.29f, -0.64f);
        v12.curveTo(4.24f, 15.58f, 4f, 13.78f, 4f, 12f);
        v12.reflectiveCurveToRelative(0.24f, -3.58f, 0.71f, -5.36f);
        v12.curveTo(7.29f, 6.2f, 9.55f, 6f, 12f, 6f);
        v12.moveToRelative(0f, -2f);
        v12.curveToRelative(-2.73f, 0f, -5.22f, 0.24f, -7.95f, 0.72f);
        v12.lineToRelative(-0.93f, 0.16f);
        v12.lineToRelative(-0.25f, 0.9f);
        v12.curveTo(2.29f, 7.85f, 2f, 9.93f, 2f, 12f);
        v12.reflectiveCurveToRelative(0.29f, 4.15f, 0.87f, 6.22f);
        v12.lineToRelative(0.25f, 0.89f);
        v12.lineToRelative(0.93f, 0.16f);
        v12.curveToRelative(2.73f, 0.49f, 5.22f, 0.73f, 7.95f, 0.73f);
        v12.reflectiveCurveToRelative(5.22f, -0.24f, 7.95f, -0.72f);
        v12.lineToRelative(0.93f, -0.16f);
        v12.lineToRelative(0.25f, -0.89f);
        v12.curveToRelative(0.58f, -2.08f, 0.87f, -4.16f, 0.87f, -6.23f);
        v12.reflectiveCurveToRelative(-0.29f, -4.15f, -0.87f, -6.22f);
        v12.lineToRelative(-0.25f, -0.89f);
        v12.lineToRelative(-0.93f, -0.16f);
        v12.curveTo(17.219999f, 4.24f, 14.73f, 4f, 12f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanoramaWideAngleKt._panoramaWideAngle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

