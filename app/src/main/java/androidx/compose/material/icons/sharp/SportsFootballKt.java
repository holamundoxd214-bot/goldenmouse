package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsFootball", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsFootball", "Landroidx/compose/material/icons/Icons$Sharp;", "getSportsFootball", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsFootballKt {
    private static ImageVector _sportsFootball;

    static {
    }

    public static final ImageVector getSportsFootball(Sharp arg19) {
        ImageVector v0 = SportsFootballKt._sportsFootball;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.SportsFootball", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3.02f, 15.62f);
        v12.curveToRelative(-0.08f, 2.42f, 0.32f, 4.34f, 0.67f, 4.69f);
        v12.reflectiveCurveToRelative(2.28f, 0.76f, 4.69f, 0.67f);
        v12.lineTo(3.02f, 15.62f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(13.08f, 3.28f);
        v12.curveTo(10.75f, 3.7f, 8.29f, 4.62f, 6.46f, 6.46f);
        v12.reflectiveCurveToRelative(-2.76f, 4.29f, -3.18f, 6.62f);
        v12.lineToRelative(7.63f, 7.63f);
        v12.curveToRelative(2.34f, -0.41f, 4.79f, -1.34f, 6.62f, -3.18f);
        v12.reflectiveCurveToRelative(2.76f, -4.29f, 3.18f, -6.62f);
        v12.lineTo(13.08f, 3.28f);
        v12.close();
        v12.moveTo(9.9f, 15.5f);
        v12.lineToRelative(-1.4f, -1.4f);
        v12.lineToRelative(5.6f, -5.6f);
        v12.lineToRelative(1.4f, 1.4f);
        v12.lineTo(9.9f, 15.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20.98f, 8.38f);
        v12.curveToRelative(0.08f, -2.42f, -0.32f, -4.34f, -0.67f, -4.69f);
        v12.reflectiveCurveToRelative(-2.28f, -0.76f, -4.69f, -0.67f);
        v12.lineTo(20.98f, 8.38f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsFootballKt._sportsFootball = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

