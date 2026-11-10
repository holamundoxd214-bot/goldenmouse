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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pestControlRodent", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PestControlRodent", "Landroidx/compose/material/icons/Icons$Rounded;", "getPestControlRodent", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PestControlRodentKt {
    private static ImageVector _pestControlRodent;

    static {
    }

    public static final ImageVector getPestControlRodent(Rounded arg19) {
        ImageVector v0 = PestControlRodentKt._pestControlRodent;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PestControlRodent", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.309999f, 17.379999f);
        v12.lineToRelative(-2.39f, -2.13f);
        v12.curveTo(19.440001f, 12.89f, 17.559999f, 11f, 15.5f, 11f);
        v12.curveToRelative(-1.16f, 0f, -3.5f, 0.9f, -3.5f, 3.5f);
        v12.curveToRelative(0f, 0.81f, 0.27f, 1.55f, 0.74f, 2.15f);
        v12.curveToRelative(0.15f, 0.2f, 0.14f, 0.48f, -0.04f, 0.66f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.21f, 0.21f, -0.56f, 0.19f, -0.75f, -0.04f);
        v12.curveTo(11.35f, 16.5f, 11f, 15.54f, 11f, 14.5f);
        v12.curveToRelative(0f, -1.7f, 0.96f, -3.17f, 2.35f, -3.93f);
        v12.curveToRelative(-0.7f, -0.36f, -1.48f, -0.57f, -2.28f, -0.57f);
        v12.curveToRelative(-2.38f, 0f, -4.37f, 1.65f, -4.91f, 3.87f);
        v12.curveToRelative(-1.33f, -0.39f, -2.28f, -1.66f, -2.15f, -3.14f);
        v12.curveTo(4.15f, 9.16f, 5.54f, 8f, 7.11f, 8f);
        v12.lineToRelative(2f, 0f);
        v12.curveToRelative(1.58f, 0f, 2.75f, -0.95f, 2.87f, -2.25f);
        v12.curveTo(12.13f, 4.25f, 10.96f, 3f, 9.5f, 3f);
        v12.horizontalLineTo(8.05f);
        v12.curveToRelative(-0.5f, 0f, -0.96f, 0.34f, -1.04f, 0.83f);
        v12.curveTo(6.91f, 4.46f, 7.39f, 5f, 8f, 5f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveTo(9.78f, 5f, 10f, 5.22f, 10f, 5.5f);
        v12.curveTo(10f, 5.78f, 9.78f, 6f, 9.5f, 6f);
        v12.lineTo(7.16f, 6f);
        v12.curveToRelative(-2.67f, 0f, -4.99f, 2.03f, -5.15f, 4.7f);
        v12.curveTo(1.86f, 13.25f, 3.62f, 15.42f, 6f, 15.9f);
        v12.verticalLineToRelative(0.03f);
        v12.curveTo(6f, 18.73f, 8.27f, 21f, 11.07f, 21f);
        v12.horizontalLineToRelative(8.86f);
        v12.curveTo(21.799999f, 21f, 22.74f, 18.66f, 21.309999f, 17.379999f);
        v12.close();
        v12.moveTo(18f, 19f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(19f, 18.549999f, 18.549999f, 19f, 18f, 19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PestControlRodentKt._pestControlRodent = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

