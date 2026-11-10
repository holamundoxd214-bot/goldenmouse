package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_thumbsUpDown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbsUpDown", "Landroidx/compose/material/icons/Icons$TwoTone;", "getThumbsUpDown", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ThumbsUpDownKt {
    private static ImageVector _thumbsUpDown;

    static {
    }

    public static final ImageVector getThumbsUpDown(TwoTone arg19) {
        ImageVector v0 = ThumbsUpDownKt._thumbsUpDown;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.ThumbsUpDown", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.lineTo(5.82f, 5f);
        v12.lineToRelative(0.66f, -3.18f);
        v12.lineToRelative(0.02f, -0.23f);
        v12.curveToRelative(0f, -0.31f, -0.13f, -0.59f, -0.33f, -0.8f);
        v12.lineTo(5.38f, 0f);
        v12.lineTo(0.44f, 4.94f);
        v12.curveTo(0.17f, 5.21f, 0f, 5.59f, 0f, 6f);
        v12.verticalLineToRelative(6.5f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.horizontalLineToRelative(6.75f);
        v12.curveToRelative(0.62f, 0f, 1.15f, -0.38f, 1.38f, -0.91f);
        v12.lineToRelative(2.26f, -5.29f);
        v12.curveToRelative(0.07f, -0.17f, 0.11f, -0.36f, 0.11f, -0.55f);
        v12.lineTo(12f, 6f);
        v12.close();
        v12.moveTo(10f, 7.13f);
        v12.lineTo(7.92f, 12f);
        v12.lineTo(2f, 12f);
        v12.lineTo(2f, 6.21f);
        v12.lineToRelative(1.93f, -1.93f);
        v12.lineTo(3.36f, 7f);
        v12.lineTo(10f, 7f);
        v12.verticalLineToRelative(0.13f);
        v12.close();
        v12.moveTo(22.5f, 10f);
        v12.horizontalLineToRelative(-6.75f);
        v12.curveToRelative(-0.62f, 0f, -1.15f, 0.38f, -1.38f, 0.91f);
        v12.lineToRelative(-2.26f, 5.29f);
        v12.curveToRelative(-0.07f, 0.17f, -0.11f, 0.36f, -0.11f, 0.55f);
        v12.lineTo(12f, 18f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(5.18f);
        v12.lineToRelative(-0.66f, 3.18f);
        v12.lineToRelative(-0.02f, 0.24f);
        v12.curveToRelative(0f, 0.31f, 0.13f, 0.59f, 0.33f, 0.8f);
        v12.lineToRelative(0.79f, 0.78f);
        v12.lineToRelative(4.94f, -4.94f);
        v12.curveToRelative(0.27f, -0.27f, 0.44f, -0.65f, 0.44f, -1.06f);
        v12.verticalLineToRelative(-6.5f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.close();
        v12.moveTo(22f, 17.790001f);
        v12.lineToRelative(-1.93f, 1.93f);
        v12.lineToRelative(0.57f, -2.72f);
        v12.lineTo(14f, 17f);
        v12.verticalLineToRelative(-0.13f);
        v12.lineTo(16.08f, 12f);
        v12.lineTo(22f, 12f);
        v12.verticalLineToRelative(5.79f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(3.93f, 4.28f);
        v0_1.lineTo(2f, 6.21f);
        v0_1.verticalLineTo(12f);
        v0_1.horizontalLineToRelative(5.92f);
        v0_1.lineTo(10f, 7.13f);
        v0_1.verticalLineTo(7f);
        v0_1.horizontalLineTo(3.36f);
        v0_1.close();
        v0_1.moveTo(14f, 16.870001f);
        v0_1.verticalLineTo(17f);
        v0_1.horizontalLineToRelative(6.64f);
        v0_1.lineToRelative(-0.57f, 2.72f);
        v0_1.lineTo(22f, 17.790001f);
        v0_1.verticalLineTo(12f);
        v0_1.horizontalLineToRelative(-5.92f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ThumbsUpDownKt._thumbsUpDown = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

