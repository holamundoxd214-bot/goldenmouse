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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_thumbDownAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbDownAlt", "Landroidx/compose/material/icons/Icons$Outlined;", "getThumbDownAlt", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ThumbDownAltKt {
    private static ImageVector _thumbDownAlt;

    static {
    }

    public static final ImageVector getThumbDownAlt(Outlined arg19) {
        ImageVector v0 = ThumbDownAltKt._thumbDownAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.ThumbDownAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 3f);
        v12.lineTo(6f, 3f);
        v12.curveToRelative(-0.83f, 0f, -1.54f, 0.5f, -1.84f, 1.22f);
        v12.lineToRelative(-3.02f, 7.05f);
        v12.curveToRelative(-0.09f, 0.23f, -0.14f, 0.47f, -0.14f, 0.73f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(6.31f);
        v12.lineToRelative(-0.95f, 4.57f);
        v12.lineToRelative(-0.03f, 0.32f);
        v12.curveToRelative(0f, 0.41f, 0.17f, 0.79f, 0.44f, 1.06f);
        v12.lineTo(9.83f, 23f);
        v12.lineToRelative(6.58f, -6.59f);
        v12.curveToRelative(0.37f, -0.36f, 0.59f, -0.86f, 0.59f, -1.41f);
        v12.lineTo(17f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(15f, 15f);
        v12.lineToRelative(-4.34f, 4.34f);
        v12.lineTo(11.77f, 14f);
        v12.lineTo(3f, 14f);
        v12.verticalLineToRelative(-2f);
        v12.lineToRelative(3f, -7f);
        v12.horizontalLineToRelative(9f);
        v12.verticalLineToRelative(10f);
        v12.close();
        v12.moveTo(19f, 3f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineToRelative(-4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ThumbDownAltKt._thumbDownAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

