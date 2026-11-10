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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_adsClick", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AdsClick", "Landroidx/compose/material/icons/Icons$Sharp;", "getAdsClick", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AdsClickKt {
    private static ImageVector _adsClick;

    static {
    }

    public static final ImageVector getAdsClick(Sharp arg19) {
        ImageVector v0 = AdsClickKt._adsClick;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.AdsClick", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.71f, 17.99f);
        v12.curveTo(8.53f, 17.84f, 6f, 15.22f, 6f, 12f);
        v12.curveToRelative(0f, -3.31f, 2.69f, -6f, 6f, -6f);
        v12.curveToRelative(3.22f, 0f, 5.84f, 2.53f, 5.99f, 5.71f);
        v12.lineToRelative(-2.1f, -0.63f);
        v12.curveTo(15.48f, 9.31f, 13.89f, 8f, 12f, 8f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.curveToRelative(0f, 1.89f, 1.31f, 3.48f, 3.08f, 3.89f);
        v12.lineTo(11.71f, 17.99f);
        v12.close();
        v12.moveTo(22f, 12f);
        v12.curveToRelative(0f, 0.3f, -0.01f, 0.6f, -0.04f, 0.9f);
        v12.lineToRelative(-1.97f, -0.59f);
        v12.curveTo(20f, 12.21f, 20f, 12.1f, 20f, 12f);
        v12.curveToRelative(0f, -4.42f, -3.58f, -8f, -8f, -8f);
        v12.reflectiveCurveToRelative(-8f, 3.58f, -8f, 8f);
        v12.reflectiveCurveToRelative(3.58f, 8f, 8f, 8f);
        v12.curveToRelative(0.1f, 0f, 0.21f, 0f, 0.31f, -0.01f);
        v12.lineToRelative(0.59f, 1.97f);
        v12.curveTo(12.6f, 21.99f, 12.3f, 22f, 12f, 22f);
        v12.curveTo(6.48f, 22f, 2f, 17.52f, 2f, 12f);
        v12.curveTo(2f, 6.48f, 6.48f, 2f, 12f, 2f);
        v12.reflectiveCurveTo(22f, 6.48f, 22f, 12f);
        v12.close();
        v12.moveTo(18.23f, 16.26f);
        v12.lineTo(22f, 15f);
        v12.lineToRelative(-10f, -3f);
        v12.lineToRelative(3f, 10f);
        v12.lineToRelative(1.26f, -3.77f);
        v12.lineToRelative(4.27f, 4.27f);
        v12.lineToRelative(1.98f, -1.98f);
        v12.lineTo(18.23f, 16.26f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AdsClickKt._adsClick = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

