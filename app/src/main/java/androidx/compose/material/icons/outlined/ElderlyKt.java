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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_elderly", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Elderly", "Landroidx/compose/material/icons/Icons$Outlined;", "getElderly", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ElderlyKt {
    private static ImageVector _elderly;

    static {
    }

    public static final ImageVector getElderly(Outlined arg19) {
        ImageVector v0 = ElderlyKt._elderly;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Elderly", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.5f, 5.5f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(12.4f, 5.5f, 13.5f, 5.5f);
        v12.close();
        v12.moveTo(20f, 12.5f);
        v12.verticalLineTo(23f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(12.5f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.reflectiveCurveTo(18f, 12.22f, 18f, 12.5f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-0.69f);
        v12.curveToRelative(-1.46f, -0.38f, -2.7f, -1.29f, -3.51f, -2.52f);
        v12.curveTo(13.18f, 11.16f, 13f, 12.07f, 13f, 13f);
        v12.curveToRelative(0f, 0.23f, 0.02f, 0.46f, 0.03f, 0.69f);
        v12.lineTo(15f, 16.5f);
        v12.verticalLineTo(23f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-5f);
        v12.lineToRelative(-1.78f, -2.54f);
        v12.lineTo(11f, 19f);
        v12.lineToRelative(-3f, 4f);
        v12.lineToRelative(-1.6f, -1.2f);
        v12.lineTo(9f, 18.33f);
        v12.verticalLineTo(13f);
        v12.curveToRelative(0f, -1.15f, 0.18f, -2.29f, 0.5f, -3.39f);
        v12.lineTo(8f, 10.46f);
        v12.verticalLineTo(14f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(9.3f);
        v12.lineToRelative(5.4f, -3.07f);
        v12.lineToRelative(0f, 0.01f);
        v12.curveToRelative(0.59f, -0.31f, 1.32f, -0.33f, 1.94f, 0.03f);
        v12.curveToRelative(0.36f, 0.21f, 0.63f, 0.51f, 0.8f, 0.85f);
        v12.lineToRelative(0f, 0f);
        v12.lineToRelative(0.79f, 1.67f);
        v12.curveTo(15.58f, 10.1f, 16.940001f, 11f, 18.5f, 11f);
        v12.curveTo(19.33f, 11f, 20f, 11.67f, 20f, 12.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ElderlyKt._elderly = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

