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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_onDeviceTraining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "OnDeviceTraining", "Landroidx/compose/material/icons/Icons$Rounded;", "getOnDeviceTraining", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class OnDeviceTrainingKt {
    private static ImageVector _onDeviceTraining;

    static {
    }

    public static final ImageVector getOnDeviceTraining(Rounded arg19) {
        ImageVector v0 = OnDeviceTrainingKt._onDeviceTraining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.OnDeviceTraining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.5f, 17f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.horizontalLineToRelative(-1f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(11f, 16.780001f, 11.22f, 17f, 11.5f, 17f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(11.52f, 11.06f);
        v12.curveToRelative(-0.71f, 0.16f, -1.29f, 0.74f, -1.46f, 1.44f);
        v12.curveToRelative(-0.23f, 0.94f, 0.21f, 1.8f, 0.94f, 2.22f);
        v12.verticalLineToRelative(0.53f);
        v12.curveToRelative(0f, 0.14f, 0.11f, 0.25f, 0.25f, 0.25f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveToRelative(0.14f, 0f, 0.25f, -0.11f, 0.25f, -0.25f);
        v12.verticalLineToRelative(-0.53f);
        v12.curveToRelative(0.6f, -0.35f, 1f, -0.98f, 1f, -1.72f);
        v12.curveTo(14f, 11.74f, 12.83f, 10.75f, 11.52f, 11.06f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18f, 1.01f);
        v12.lineTo(6f, 1f);
        v12.curveTo(4.9f, 1f, 4f, 1.9f, 4f, 3f);
        v12.verticalLineToRelative(18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(3f);
        v12.curveTo(20f, 1.9f, 19.1f, 1.01f, 18f, 1.01f);
        v12.close();
        v12.moveTo(18f, 18f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineTo(18f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15.33f, 15.27f);
        v12.curveToRelative(0.36f, 0.36f, 0.99f, 0.26f, 1.21f, -0.2f);
        v12.curveTo(16.83f, 14.44f, 17f, 13.74f, 17f, 13f);
        v12.reflectiveCurveToRelative(-0.17f, -1.44f, -0.46f, -2.07f);
        v12.curveToRelative(-0.22f, -0.47f, -0.84f, -0.57f, -1.21f, -0.2f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.22f, 0.22f, -0.28f, 0.56f, -0.15f, 0.84f);
        v12.curveToRelative(0.2f, 0.44f, 0.31f, 0.92f, 0.31f, 1.43f);
        v12.reflectiveCurveToRelative(-0.11f, 0.99f, -0.31f, 1.43f);
        v12.curveTo(15.06f, 14.72f, 15.11f, 15.05f, 15.33f, 15.27f);
        v12.lineTo(15.33f, 15.27f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8.67f, 15.27f);
        v12.curveToRelative(0.22f, -0.22f, 0.28f, -0.56f, 0.15f, -0.84f);
        v12.curveTo(8.61f, 13.99f, 8.5f, 13.51f, 8.5f, 13f);
        v12.curveToRelative(0f, -1.93f, 1.57f, -3.5f, 3.5f, -3.5f);
        v12.verticalLineToRelative(0.69f);
        v12.curveToRelative(0f, 0.22f, 0.25f, 0.33f, 0.42f, 0.19f);
        v12.lineToRelative(1.62f, -1.44f);
        v12.curveToRelative(0.11f, -0.1f, 0.11f, -0.27f, 0f, -0.37f);
        v12.lineToRelative(-1.62f, -1.44f);
        v12.curveTo(12.25f, 6.98f, 12f, 7.09f, 12f, 7.31f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.curveToRelative(0f, 0.74f, 0.17f, 1.44f, 0.46f, 2.07f);
        v12.curveTo(7.68f, 15.54f, 8.3f, 15.64f, 8.67f, 15.27f);
        v12.lineTo(8.67f, 15.27f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        OnDeviceTrainingKt._onDeviceTraining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

