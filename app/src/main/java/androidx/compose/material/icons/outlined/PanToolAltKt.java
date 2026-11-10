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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panToolAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanToolAlt", "Landroidx/compose/material/icons/Icons$Outlined;", "getPanToolAlt", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanToolAltKt {
    private static ImageVector _panToolAlt;

    static {
    }

    public static final ImageVector getPanToolAlt(Outlined arg19) {
        ImageVector v0 = PanToolAltKt._panToolAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PanToolAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.889999f, 11.77f);
        v12.lineToRelative(-3.8f, -1.67f);
        v12.curveTo(14.96f, 10.04f, 14.81f, 10f, 14.65f, 10f);
        v12.horizontalLineTo(14f);
        v12.verticalLineTo(5.5f);
        v12.curveTo(14f, 4.12f, 12.88f, 3f, 11.5f, 3f);
        v12.reflectiveCurveTo(9f, 4.12f, 9f, 5.5f);
        v12.verticalLineToRelative(8.15f);
        v12.lineToRelative(-1.87f, -0.4f);
        v12.curveToRelative(-0.19f, -0.03f, -1.02f, -0.15f, -1.73f, 0.56f);
        v12.lineTo(4f, 15.22f);
        v12.lineToRelative(5.12f, 5.19f);
        v12.curveTo(9.49f, 20.790001f, 10f, 21f, 10.53f, 21f);
        v12.horizontalLineToRelative(6.55f);
        v12.curveToRelative(0.98f, 0f, 1.81f, -0.7f, 1.97f, -1.67f);
        v12.lineToRelative(0.92f, -5.44f);
        v12.curveTo(20.120001f, 13.03f, 19.68f, 12.17f, 18.889999f, 11.77f);
        v12.close();
        v12.moveTo(17.08f, 19f);
        v12.horizontalLineToRelative(-6.55f);
        v12.lineToRelative(-3.7f, -3.78f);
        v12.lineTo(11f, 16.110001f);
        v12.verticalLineTo(5.5f);
        v12.curveTo(11f, 5.22f, 11.22f, 5f, 11.5f, 5f);
        v12.reflectiveCurveTo(12f, 5.22f, 12f, 5.5f);
        v12.verticalLineToRelative(6.18f);
        v12.horizontalLineToRelative(1.76f);
        v12.lineTo(18f, 13.56f);
        v12.lineTo(17.08f, 19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanToolAltKt._panToolAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

