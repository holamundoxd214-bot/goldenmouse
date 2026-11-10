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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sanitizer", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sanitizer", "Landroidx/compose/material/icons/Icons$Outlined;", "getSanitizer", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SanitizerKt {
    private static ImageVector _sanitizer;

    static {
    }

    public static final ImageVector getSanitizer(Outlined arg19) {
        ImageVector v0 = SanitizerKt._sanitizer;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Sanitizer", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.5f, 6.5f);
        v12.curveTo(15.5f, 5.66f, 17f, 4f, 17f, 4f);
        v12.reflectiveCurveToRelative(1.5f, 1.66f, 1.5f, 2.5f);
        v12.curveTo(18.5f, 7.33f, 17.83f, 8f, 17f, 8f);
        v12.reflectiveCurveTo(15.5f, 7.33f, 15.5f, 6.5f);
        v12.close();
        v12.moveTo(19.5f, 15f);
        v12.curveToRelative(1.38f, 0f, 2.5f, -1.12f, 2.5f, -2.5f);
        v12.curveToRelative(0f, -1.67f, -2.5f, -4.5f, -2.5f, -4.5f);
        v12.reflectiveCurveTo(17f, 10.83f, 17f, 12.5f);
        v12.curveTo(17f, 13.88f, 18.120001f, 15f, 19.5f, 15f);
        v12.close();
        v12.moveTo(13f, 14f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(14f);
        v12.close();
        v12.moveTo(16f, 12f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineToRelative(-8f);
        v12.curveToRelative(0f, -2.97f, 2.16f, -5.43f, 5f, -5.91f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(2f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(1.13f, 0f, 2.15f, 0.39f, 2.99f, 1.01f);
        v12.lineToRelative(-1.43f, 1.43f);
        v12.curveTo(14.1f, 4.17f, 13.57f, 4f, 13f, 4f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2.09f);
        v12.curveTo(13.84f, 6.57f, 16f, 9.03f, 16f, 12f);
        v12.close();
        v12.moveTo(14f, 12f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.reflectiveCurveToRelative(-4f, 1.79f, -4f, 4f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SanitizerKt._sanitizer = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

