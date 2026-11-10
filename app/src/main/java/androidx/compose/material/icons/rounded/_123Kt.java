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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"__123", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_123", "Landroidx/compose/material/icons/Icons$Rounded;", "get_123", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class _123Kt {
    private static ImageVector __123;

    static {
    }

    public static final ImageVector get_123(Rounded arg19) {
        ImageVector v0 = _123Kt.__123;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded._123", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.75f, 10.5f);
        v12.curveTo(4.34f, 10.5f, 4f, 10.16f, 4f, 9.75f);
        v12.reflectiveCurveTo(4.34f, 9f, 4.75f, 9f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4.25f);
        v12.curveTo(7f, 14.66f, 6.66f, 15f, 6.25f, 15f);
        v12.reflectiveCurveTo(5.5f, 14.66f, 5.5f, 14.25f);
        v12.verticalLineTo(10.5f);
        v12.horizontalLineTo(4.75f);
        v12.close();
        v12.moveTo(9.75f, 9f);
        v12.curveTo(9.34f, 9f, 9f, 9.34f, 9f, 9.75f);
        v12.reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineTo(14f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2.75f);
        v12.curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.horizontalLineTo(10.5f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(10f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(9.75f);
        v12.close();
        v12.moveTo(18.5f, 15f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-2.75f);
        v12.curveTo(15.34f, 9f, 15f, 9.34f, 15f, 9.75f);
        v12.reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f);
        v12.horizontalLineTo(18f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-1.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f);
        v12.horizontalLineTo(18f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2.25f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f);
        v12.reflectiveCurveTo(15.34f, 15f, 15.75f, 15f);
        v12.horizontalLineTo(18.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        _123Kt.__123 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

