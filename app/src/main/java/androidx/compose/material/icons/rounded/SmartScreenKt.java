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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_smartScreen", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SmartScreen", "Landroidx/compose/material/icons/Icons$Rounded;", "getSmartScreen", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SmartScreenKt {
    private static ImageVector _smartScreen;

    static {
    }

    public static final ImageVector getSmartScreen(Rounded arg19) {
        ImageVector v0 = SmartScreenKt._smartScreen;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SmartScreen", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 5f);
        v12.horizontalLineTo(3f);
        v12.curveTo(1.9f, 5f, 1f, 5.9f, 1f, 7f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(7f);
        v12.curveTo(23f, 5.9f, 22.1f, 5f, 21f, 5f);
        v12.close();
        v12.moveTo(18f, 7f);
        v12.verticalLineToRelative(10f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(18f);
        v12.close();
        v12.moveTo(14f, 12f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(12.5f, 11.59f, 12.5f, 12f);
        v12.reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(14f, 12.41f, 14f, 12f);
        v12.close();
        v12.moveTo(9f, 12f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(7.5f, 11.59f, 7.5f, 12f);
        v12.reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(9f, 12.41f, 9f, 12f);
        v12.close();
        v12.moveTo(16.5f, 12f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(15f, 11.59f, 15f, 12f);
        v12.reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(16.5f, 12.41f, 16.5f, 12f);
        v12.close();
        v12.moveTo(11.5f, 12f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(10f, 11.59f, 10f, 12f);
        v12.reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(11.5f, 12.41f, 11.5f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SmartScreenKt._smartScreen = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

