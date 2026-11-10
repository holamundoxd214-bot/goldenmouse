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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_autoDelete", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AutoDelete", "Landroidx/compose/material/icons/Icons$Rounded;", "getAutoDelete", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AutoDeleteKt {
    private static ImageVector _autoDelete;

    static {
    }

    public static final ImageVector getAutoDelete(Rounded arg19) {
        ImageVector v0 = AutoDeleteKt._autoDelete;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AutoDelete", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 9f);
        v12.curveToRelative(-0.7f, 0f, -1.37f, 0.1f, -2f, 0.29f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 5f, 2f, 5.9f, 2f, 7f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(5.68f);
        v12.curveToRelative(1.12f, 2.36f, 3.53f, 4f, 6.32f, 4f);
        v12.curveToRelative(3.87f, 0f, 7f, -3.13f, 7f, -7f);
        v12.curveTo(23f, 12.13f, 19.870001f, 9f, 16f, 9f);
        v12.close();
        v12.moveTo(16f, 21f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.reflectiveCurveToRelative(2.24f, -5f, 5f, -5f);
        v12.reflectiveCurveToRelative(5f, 2.24f, 5f, 5f);
        v12.reflectiveCurveTo(18.76f, 21f, 16f, 21f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(14f, 4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-2.5f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.curveTo(10.61f, 1.11f, 10.35f, 1f, 10.09f, 1f);
        v12.horizontalLineTo(5.91f);
        v12.curveTo(5.65f, 1f, 5.39f, 1.11f, 5.21f, 1.29f);
        v12.lineTo(4.5f, 2f);
        v12.horizontalLineTo(2f);
        v12.curveTo(1.45f, 2f, 1f, 2.45f, 1f, 3f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineTo(14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15.75f, 12f);
        v12.lineTo(15.75f, 12f);
        v12.curveTo(15.34f, 12f, 15f, 12.34f, 15f, 12.75f);
        v12.verticalLineToRelative(3.68f);
        v12.curveToRelative(0f, 0.36f, 0.19f, 0.68f, 0.5f, 0.86f);
        v12.lineToRelative(2.52f, 1.47f);
        v12.curveToRelative(0.33f, 0.19f, 0.75f, 0.09f, 0.96f, -0.22f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0.23f, -0.34f, 0.12f, -0.81f, -0.24f, -1.02f);
        v12.lineTo(16.5f, 16.200001f);
        v12.verticalLineToRelative(-3.45f);
        v12.curveTo(16.5f, 12.34f, 16.16f, 12f, 15.75f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AutoDeleteKt._autoDelete = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

