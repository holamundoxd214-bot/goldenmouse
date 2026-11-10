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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hiking", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Hiking", "Landroidx/compose/material/icons/Icons$Rounded;", "getHiking", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HikingKt {
    private static ImageVector _hiking;

    static {
    }

    public static final ImageVector getHiking(Rounded arg19) {
        ImageVector v0 = HikingKt._hiking;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Hiking", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(18.25f, 9f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f);
        v12.lineToRelative(0f, 1.03f);
        v12.curveToRelative(-1.23f, -0.37f, -2.22f, -1.17f, -2.8f, -2.18f);
        v12.lineToRelative(-1f, -1.6f);
        v12.curveToRelative(-0.41f, -0.65f, -1.11f, -1f, -1.84f, -1f);
        v12.curveToRelative(-0.78f, 0f, -1.59f, 0.5f, -1.78f, 1.44f);
        v12.lineTo(7.25f, 21.76f);
        v12.curveTo(7.12f, 22.4f, 7.61f, 23f, 8.27f, 23f);
        v12.curveToRelative(0.49f, 0f, 0.91f, -0.34f, 1.02f, -0.81f);
        v12.lineTo(10.9f, 15f);
        v12.lineToRelative(2.1f, 2f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-5.64f);
        v12.curveToRelative(0f, -0.55f, -0.22f, -1.07f, -0.62f, -1.45f);
        v12.lineTo(12.9f, 13.5f);
        v12.lineToRelative(0.6f, -3f);
        v12.curveToRelative(1f, 1.15f, 2.41f, 2.01f, 4f, 2.34f);
        v12.verticalLineToRelative(9.41f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(19f, 22.66f, 19f, 22.25f);
        v12.verticalLineTo(9.75f);
        v12.curveTo(19f, 9.34f, 18.66f, 9f, 18.25f, 9f);
        v12.close();
        v12.moveTo(7.43f, 13.13f);
        v12.lineToRelative(-2.12f, -0.41f);
        v12.curveToRelative(-0.54f, -0.11f, -0.9f, -0.63f, -0.79f, -1.17f);
        v12.lineToRelative(0.76f, -3.93f);
        v12.curveToRelative(0.21f, -1.08f, 1.26f, -1.79f, 2.34f, -1.58f);
        v12.lineToRelative(1.16f, 0.23f);
        v12.lineTo(7.43f, 13.13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HikingKt._hiking = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

