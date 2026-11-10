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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_blurCircular", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BlurCircular", "Landroidx/compose/material/icons/Icons$Sharp;", "getBlurCircular", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BlurCircularKt {
    private static ImageVector _blurCircular;

    static {
    }

    public static final ImageVector getBlurCircular(Sharp arg19) {
        ImageVector v0 = BlurCircularKt._blurCircular;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.BlurCircular", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 9f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(10f, 13f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(7f, 9.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f);
        v12.close();
        v12.moveTo(10f, 16.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f);
        v12.close();
        v12.moveTo(7f, 13.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f);
        v12.close();
        v12.moveTo(10f, 7.5f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.5f, 0.22f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f);
        v12.close();
        v12.moveTo(14f, 9f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(14f, 7.5f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.5f, 0.22f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f);
        v12.close();
        v12.moveTo(17f, 13.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f);
        v12.close();
        v12.moveTo(17f, 9.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.42f, 0f, -8f, -3.58f, -8f, -8f);
        v12.reflectiveCurveToRelative(3.58f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.58f, 8f, 8f);
        v12.reflectiveCurveToRelative(-3.58f, 8f, -8f, 8f);
        v12.close();
        v12.moveTo(14f, 16.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f);
        v12.close();
        v12.moveTo(14f, 13f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BlurCircularKt._blurCircular = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

