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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_support", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Support", "Landroidx/compose/material/icons/Icons$Sharp;", "getSupport", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SupportKt {
    private static ImageVector _support;

    static {
    }

    public static final ImageVector getSupport(Sharp arg19) {
        ImageVector v0 = SupportKt._support;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Support", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(19.459999f, 9.12f);
        v12.lineToRelative(-2.78f, 1.15f);
        v12.curveToRelative(-0.51f, -1.36f, -1.58f, -2.44f, -2.95f, -2.94f);
        v12.lineToRelative(1.15f, -2.78f);
        v12.curveTo(16.98f, 5.35f, 18.65f, 7.02f, 19.459999f, 9.12f);
        v12.close();
        v12.moveTo(12f, 15f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.34f, 3f, 3f);
        v12.reflectiveCurveTo(13.66f, 15f, 12f, 15f);
        v12.close();
        v12.moveTo(9.13f, 4.54f);
        v12.lineToRelative(1.17f, 2.78f);
        v12.curveToRelative(-1.38f, 0.5f, -2.47f, 1.59f, -2.98f, 2.97f);
        v12.lineTo(4.54f, 9.13f);
        v12.curveTo(5.35f, 7.02f, 7.02f, 5.35f, 9.13f, 4.54f);
        v12.close();
        v12.moveTo(4.54f, 14.87f);
        v12.lineToRelative(2.78f, -1.15f);
        v12.curveToRelative(0.51f, 1.38f, 1.59f, 2.46f, 2.97f, 2.96f);
        v12.lineToRelative(-1.17f, 2.78f);
        v12.curveTo(7.02f, 18.65f, 5.35f, 16.98f, 4.54f, 14.87f);
        v12.close();
        v12.moveTo(14.88f, 19.459999f);
        v12.lineToRelative(-1.15f, -2.78f);
        v12.curveToRelative(1.37f, -0.51f, 2.45f, -1.59f, 2.95f, -2.97f);
        v12.lineToRelative(2.78f, 1.17f);
        v12.curveTo(18.65f, 16.98f, 16.98f, 18.65f, 14.88f, 19.459999f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SupportKt._support = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

