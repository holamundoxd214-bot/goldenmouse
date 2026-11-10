package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_thumbUpAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbUpAlt", "Landroidx/compose/material/icons/Icons$Filled;", "getThumbUpAlt", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ThumbUpAltKt {
    private static ImageVector _thumbUpAlt;

    static {
    }

    public static final ImageVector getThumbUpAlt(Filled arg19) {
        ImageVector v0 = ThumbUpAltKt._thumbUpAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ThumbUpAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2f, 20f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-9f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.lineTo(2f, 9f);
        v12.verticalLineToRelative(11f);
        v12.close();
        v12.moveTo(21.83f, 12.88f);
        v12.curveToRelative(0.11f, -0.25f, 0.17f, -0.52f, 0.17f, -0.8f);
        v12.lineTo(22f, 11f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-5.5f);
        v12.lineToRelative(0.92f, -4.65f);
        v12.curveToRelative(0.05f, -0.22f, 0.02f, -0.46f, -0.08f, -0.66f);
        v12.curveToRelative(-0.23f, -0.45f, -0.52f, -0.86f, -0.88f, -1.22f);
        v12.lineTo(14f, 2f);
        v12.lineTo(7.59f, 8.41f);
        v12.curveTo(7.21f, 8.79f, 7f, 9.3f, 7f, 9.83f);
        v12.verticalLineToRelative(7.84f);
        v12.curveTo(7f, 18.950001f, 8.05f, 20f, 9.34f, 20f);
        v12.horizontalLineToRelative(8.11f);
        v12.curveToRelative(0.7f, 0f, 1.36f, -0.37f, 1.72f, -0.97f);
        v12.lineToRelative(2.66f, -6.15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ThumbUpAltKt._thumbUpAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

