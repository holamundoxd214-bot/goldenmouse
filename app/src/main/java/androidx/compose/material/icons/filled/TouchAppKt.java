package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_touchApp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TouchApp", "Landroidx/compose/material/icons/Icons$Filled;", "getTouchApp", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TouchAppKt {
    private static ImageVector _touchApp;

    static {
    }

    public static final ImageVector getTouchApp(Filled arg19) {
        ImageVector v0 = TouchAppKt._touchApp;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.TouchApp", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 11.24f);
        v12.verticalLineTo(7.5f);
        v12.curveTo(9f, 6.12f, 10.12f, 5f, 11.5f, 5f);
        v12.reflectiveCurveTo(14f, 6.12f, 14f, 7.5f);
        v12.verticalLineToRelative(3.74f);
        v12.curveToRelative(1.21f, -0.81f, 2f, -2.18f, 2f, -3.74f);
        v12.curveTo(16f, 5.01f, 13.99f, 3f, 11.5f, 3f);
        v12.reflectiveCurveTo(7f, 5.01f, 7f, 7.5f);
        v12.curveTo(7f, 9.06f, 7.79f, 10.43f, 9f, 11.24f);
        v12.close();
        v12.moveTo(18.84f, 15.87f);
        v12.lineToRelative(-4.54f, -2.26f);
        v12.curveToRelative(-0.17f, -0.07f, -0.35f, -0.11f, -0.54f, -0.11f);
        v12.horizontalLineTo(13f);
        v12.verticalLineToRelative(-6f);
        v12.curveTo(13f, 6.67f, 12.33f, 6f, 11.5f, 6f);
        v12.reflectiveCurveTo(10f, 6.67f, 10f, 7.5f);
        v12.verticalLineToRelative(10.74f);
        v12.curveToRelative(-3.6f, -0.76f, -3.54f, -0.75f, -3.67f, -0.75f);
        v12.curveToRelative(-0.31f, 0f, -0.59f, 0.13f, -0.79f, 0.33f);
        v12.lineToRelative(-0.79f, 0.8f);
        v12.lineToRelative(4.94f, 4.94f);
        v12.curveTo(9.96f, 23.83f, 10.34f, 24f, 10.75f, 24f);
        v12.horizontalLineToRelative(6.79f);
        v12.curveToRelative(0.75f, 0f, 1.33f, -0.55f, 1.44f, -1.28f);
        v12.lineToRelative(0.75f, -5.27f);
        v12.curveToRelative(0.01f, -0.07f, 0.02f, -0.14f, 0.02f, -0.2f);
        v12.curveTo(19.75f, 16.629999f, 19.370001f, 16.09f, 18.84f, 15.87f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TouchAppKt._touchApp = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

