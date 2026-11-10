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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cloudCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CloudCircle", "Landroidx/compose/material/icons/Icons$Outlined;", "getCloudCircle", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CloudCircleKt {
    private static ImageVector _cloudCircle;

    static {
    }

    public static final ImageVector getCloudCircle(Outlined arg19) {
        ImageVector v0 = CloudCircleKt._cloudCircle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.CloudCircle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
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
        v12.moveTo(16.290001f, 10.19f);
        v12.curveToRelative(-0.4f, -2.01f, -2.16f, -3.52f, -4.29f, -3.52f);
        v12.curveToRelative(-1.69f, 0f, -3.15f, 0.96f, -3.88f, 2.36f);
        v12.curveTo(6.36f, 9.21f, 5f, 10.7f, 5f, 12.5f);
        v12.curveTo(5f, 14.43f, 6.57f, 16f, 8.5f, 16f);
        v12.horizontalLineToRelative(7.58f);
        v12.curveToRelative(1.61f, 0f, 2.92f, -1.31f, 2.92f, -2.92f);
        v12.curveToRelative(0f, -1.54f, -1.2f, -2.79f, -2.71f, -2.89f);
        v12.close();
        v12.moveTo(16f, 14f);
        v12.lineTo(8.5f, 14f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(7.67f, 11f, 8.5f, 11f);
        v12.horizontalLineToRelative(0.9f);
        v12.lineToRelative(0.49f, -1.05f);
        v12.curveToRelative(0.41f, -0.79f, 1.22f, -1.28f, 2.11f, -1.28f);
        v12.curveToRelative(1.13f, 0f, 2.11f, 0.8f, 2.33f, 1.91f);
        v12.lineToRelative(0.28f, 1.42f);
        v12.lineTo(16f, 12f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CloudCircleKt._cloudCircle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

