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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_moreTime", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MoreTime", "Landroidx/compose/material/icons/Icons$Rounded;", "getMoreTime", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MoreTimeKt {
    private static ImageVector _moreTime;

    static {
    }

    public static final ImageVector getMoreTime(Rounded arg19) {
        ImageVector v0 = MoreTimeKt._moreTime;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MoreTime", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.75f, 8f);
        v12.curveTo(10.34f, 8f, 10f, 8.34f, 10f, 8.75f);
        v12.verticalLineToRelative(4.69f);
        v12.curveToRelative(0f, 0.35f, 0.18f, 0.67f, 0.47f, 0.85f);
        v12.lineToRelative(3.64f, 2.24f);
        v12.curveToRelative(0.33f, 0.2f, 0.76f, 0.11f, 0.97f, -0.21f);
        v12.curveToRelative(0.23f, -0.34f, 0.12f, -0.8f, -0.23f, -1.01f);
        v12.lineTo(11.5f, 13.3f);
        v12.verticalLineTo(8.75f);
        v12.curveTo(11.5f, 8.34f, 11.16f, 8f, 10.75f, 8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17.92f, 12f);
        v12.curveToRelative(0.05f, 0.33f, 0.08f, 0.66f, 0.08f, 1f);
        v12.curveToRelative(0f, 3.9f, -3.1f, 7f, -7f, 7f);
        v12.reflectiveCurveToRelative(-7f, -3.1f, -7f, -7f);
        v12.curveToRelative(0f, -3.9f, 3.1f, -7f, 7f, -7f);
        v12.curveToRelative(0.7f, 0f, 1.37f, 0.1f, 2f, 0.29f);
        v12.verticalLineTo(4.23f);
        v12.curveTo(12.36f, 4.08f, 11.69f, 4f, 11f, 4f);
        v12.curveToRelative(-5f, 0f, -9f, 4f, -9f, 9f);
        v12.reflectiveCurveToRelative(4f, 9f, 9f, 9f);
        v12.reflectiveCurveToRelative(9f, -4f, 9f, -9f);
        v12.curveToRelative(0f, -0.34f, -0.02f, -0.67f, -0.06f, -1f);
        v12.horizontalLineTo(17.92f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(22f, 5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveTo(23f, 5.45f, 22.549999f, 5f, 22f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MoreTimeKt._moreTime = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

