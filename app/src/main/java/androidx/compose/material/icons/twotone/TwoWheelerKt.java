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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_twoWheeler", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TwoWheeler", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTwoWheeler", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TwoWheelerKt {
    private static ImageVector _twoWheeler;

    static {
    }

    public static final ImageVector getTwoWheeler(TwoTone arg19) {
        ImageVector v0 = TwoWheelerKt._twoWheeler;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.TwoWheeler", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.17f, 11f);
        v12.lineTo(4.17f, 11f);
        v12.curveTo(4.12f, 11f, 4.06f, 11f, 4f, 11f);
        v12.horizontalLineTo(4.17f);
        v12.moveTo(13.41f, 5f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3.59f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineTo(11f);
        v12.lineToRelative(-4f, 2f);
        v12.lineTo(5f, 9f);
        v12.horizontalLineTo(0f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineToRelative(3f);
        v12.lineToRelative(3.49f, -6.1f);
        v12.lineToRelative(1.01f, 1.01f);
        v12.curveTo(16.59f, 12.64f, 16f, 13.75f, 16f, 15f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.curveToRelative(-0.18f, 0f, -0.36f, 0.03f, -0.53f, 0.05f);
        v12.lineTo(17.41f, 9f);
        v12.horizontalLineTo(20f);
        v12.verticalLineTo(6f);
        v12.lineToRelative(-3.72f, 1.86f);
        v12.lineTo(13.41f, 5f);
        v12.lineTo(13.41f, 5f);
        v12.close();
        v12.moveTo(20f, 17f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.curveTo(22f, 16.1f, 21.1f, 17f, 20f, 17f);
        v12.lineTo(20f, 17f);
        v12.close();
        v12.moveTo(4f, 17f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.curveTo(6f, 16.1f, 5.1f, 17f, 4f, 17f);
        v12.lineTo(4f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TwoWheelerKt._twoWheeler = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

