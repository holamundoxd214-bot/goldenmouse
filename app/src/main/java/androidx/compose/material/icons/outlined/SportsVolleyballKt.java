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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsVolleyball", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsVolleyball", "Landroidx/compose/material/icons/Icons$Outlined;", "getSportsVolleyball", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsVolleyballKt {
    private static ImageVector _sportsVolleyball;

    static {
    }

    public static final ImageVector getSportsVolleyball(Outlined arg19) {
        ImageVector v0 = SportsVolleyballKt._sportsVolleyball;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SportsVolleyball", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(13f, 4.07f);
        v12.curveToRelative(3.07f, 0.38f, 5.57f, 2.52f, 6.54f, 5.36f);
        v12.lineTo(13f, 5.65f);
        v12.verticalLineTo(4.07f);
        v12.close();
        v12.moveTo(8f, 5.08f);
        v12.curveToRelative(1.18f, -0.69f, 3.33f, -1.06f, 3f, -1.02f);
        v12.verticalLineToRelative(7.35f);
        v12.lineToRelative(-3f, 1.73f);
        v12.verticalLineTo(5.08f);
        v12.close();
        v12.moveTo(4.63f, 15.1f);
        v12.curveTo(4.23f, 14.14f, 4f, 13.1f, 4f, 12f);
        v12.curveToRelative(0f, -2.02f, 0.76f, -3.86f, 2f, -5.27f);
        v12.verticalLineToRelative(7.58f);
        v12.lineTo(4.63f, 15.1f);
        v12.close();
        v12.moveTo(5.64f, 16.83f);
        v12.lineTo(12f, 13.15f);
        v12.lineToRelative(3f, 1.73f);
        v12.lineToRelative(-6.98f, 4.03f);
        v12.curveTo(7.09f, 18.379999f, 6.28f, 17.68f, 5.64f, 16.83f);
        v12.close();
        v12.moveTo(10.42f, 19.84f);
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-0.54f, 0f, -1.07f, -0.06f, -1.58f, -0.16f);
        v12.lineToRelative(6.58f, -3.8f);
        v12.lineToRelative(1.36f, 0.78f);
        v12.curveTo(16.9f, 18.75f, 14.6f, 20f, 12f, 20f);
        v12.close();
        v12.moveTo(13f, 11.42f);
        v12.verticalLineTo(7.96f);
        v12.lineToRelative(7f, 4.05f);
        v12.curveToRelative(0f, 1.1f, -0.23f, 2.14f, -0.63f, 3.09f);
        v12.lineTo(13f, 11.42f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsVolleyballKt._sportsVolleyball = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

