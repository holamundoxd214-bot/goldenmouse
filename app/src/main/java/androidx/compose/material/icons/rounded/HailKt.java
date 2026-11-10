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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hail", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Hail", "Landroidx/compose/material/icons/Icons$Rounded;", "getHail", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HailKt {
    private static ImageVector _hail;

    static {
    }

    public static final ImageVector getHail(Rounded arg19) {
        ImageVector v0 = HailKt._hail;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Hail", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveTo(13.1f, 6f, 12f, 6f);
        v12.close();
        v12.moveTo(17.950001f, 2f);
        v12.lineTo(17.950001f, 2f);
        v12.curveToRelative(0.59f, 0f, 1.06f, 0.51f, 1f, 1.09f);
        v12.curveTo(18.93f, 3.24f, 18.74f, 7.15f, 15f, 8.4f);
        v12.verticalLineTo(21f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(10.1f);
        v12.curveToRelative(-0.3f, 0.1f, -0.5f, 0.2f, -0.6f, 0.3f);
        v12.curveToRelative(-0.46f, 0.36f, -1.17f, 0.87f, -1.36f, 2.67f);
        v12.curveTo(6.99f, 13.59f, 6.57f, 14f, 6.04f, 14f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.58f, 0f, -1.05f, -0.49f, -1f, -1.07f);
        v12.curveToRelative(0.13f, -1.6f, 0.62f, -2.98f, 2.07f, -4.22f);
        v12.curveTo(8.21f, 7.81f, 10f, 7f, 12f, 7f);
        v12.reflectiveCurveToRelative(2.68f, -0.46f, 3.48f, -1.06f);
        v12.curveToRelative(0.43f, -0.34f, 1.28f, -0.99f, 1.48f, -3.02f);
        v12.curveTo(17.01f, 2.4f, 17.43f, 2f, 17.950001f, 2f);
        v12.close();
        v12.moveTo(5f, 16f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(5f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveTo(4f, 16.450001f, 4.45f, 16f, 5f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HailKt._hail = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

