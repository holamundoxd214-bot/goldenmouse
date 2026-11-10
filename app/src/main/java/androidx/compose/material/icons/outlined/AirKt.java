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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_air", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Air", "Landroidx/compose/material/icons/Icons$Outlined;", "getAir", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AirKt {
    private static ImageVector _air;

    static {
    }

    public static final ImageVector getAir(Outlined arg19) {
        ImageVector v0 = AirKt._air;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Air", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.5f, 17f);
        v12.curveToRelative(0f, 1.65f, -1.35f, 3f, -3f, 3f);
        v12.reflectiveCurveToRelative(-3f, -1.35f, -3f, -3f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(9.5f);
        v12.curveTo(13.15f, 14f, 14.5f, 15.35f, 14.5f, 17f);
        v12.close();
        v12.moveTo(19f, 6.5f);
        v12.curveTo(19f, 4.57f, 17.43f, 3f, 15.5f, 3f);
        v12.reflectiveCurveTo(12f, 4.57f, 12f, 6.5f);
        v12.horizontalLineToRelative(2f);
        v12.curveTo(14f, 5.67f, 14.67f, 5f, 15.5f, 5f);
        v12.reflectiveCurveTo(17f, 5.67f, 17f, 6.5f);
        v12.reflectiveCurveTo(16.33f, 8f, 15.5f, 8f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(13.5f);
        v12.curveTo(17.43f, 10f, 19f, 8.43f, 19f, 6.5f);
        v12.close();
        v12.moveTo(18.5f, 11f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(16.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(19.33f, 16f, 18.5f, 16f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.reflectiveCurveTo(20.43f, 11f, 18.5f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AirKt._air = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

