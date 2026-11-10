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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_scale", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Scale", "Landroidx/compose/material/icons/Icons$Sharp;", "getScale", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScaleKt {
    private static ImageVector _scale;

    static {
    }

    public static final ImageVector getScale(Sharp arg19) {
        ImageVector v0 = ScaleKt._scale;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Scale", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 11f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(4.56f, -0.58f, 8f, -3.1f, 8f, -6f);
        v12.horizontalLineTo(2f);
        v12.curveToRelative(0f, 2.9f, 3.44f, 5.42f, 8f, 6f);
        v12.lineToRelative(0f, 3f);
        v12.curveToRelative(-3.68f, 0.73f, -8f, 3.61f, -8f, 11f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(4.13f);
        v12.curveToRelative(0.93f, -6.83f, 6.65f, -7.2f, 7.87f, -7.2f);
        v12.reflectiveCurveToRelative(6.94f, 0.37f, 7.87f, 7.2f);
        v12.horizontalLineTo(16f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.curveTo(22f, 14.61f, 17.68f, 11.73f, 14f, 11f);
        v12.close();
        v12.moveTo(12f, 22f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -0.55f, 0.22f, -1.05f, 0.59f, -1.41f);
        v12.curveTo(11.39f, 17.790001f, 16f, 16f, 16f, 16f);
        v12.reflectiveCurveToRelative(-1.79f, 4.61f, -2.59f, 5.41f);
        v12.curveTo(13.05f, 21.780001f, 12.55f, 22f, 12f, 22f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScaleKt._scale = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

