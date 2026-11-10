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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_thumbsUpDown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbsUpDown", "Landroidx/compose/material/icons/Icons$Rounded;", "getThumbsUpDown", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ThumbsUpDownKt {
    private static ImageVector _thumbsUpDown;

    static {
    }

    public static final ImageVector getThumbsUpDown(Rounded arg19) {
        ImageVector v0 = ThumbsUpDownKt._thumbsUpDown;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ThumbsUpDown", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.06f, 5f);
        v12.horizontalLineTo(5.82f);
        v12.lineToRelative(0.66f, -3.18f);
        v12.curveToRelative(0.08f, -0.37f, -0.04f, -0.75f, -0.3f, -1.02f);
        v12.curveTo(5.74f, 0.36f, 5.03f, 0.36f, 4.6f, 0.8f);
        v12.lineToRelative(-4f, 4f);
        v12.curveToRelative(-0.39f, 0.37f, -0.6f, 0.88f, -0.6f, 1.41f);
        v12.verticalLineTo(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(5.92f);
        v12.curveToRelative(0.8f, 0f, 1.52f, -0.48f, 1.84f, -1.21f);
        v12.lineToRelative(2.14f, -5f);
        v12.curveTo(12.46f, 6.47f, 11.49f, 5f, 10.06f, 5f);
        v12.close();
        v12.moveTo(22f, 10f);
        v12.horizontalLineToRelative(-5.92f);
        v12.curveToRelative(-0.8f, 0f, -1.52f, 0.48f, -1.84f, 1.21f);
        v12.lineToRelative(-2.14f, 5f);
        v12.curveToRelative(-0.56f, 1.32f, 0.4f, 2.79f, 1.84f, 2.79f);
        v12.horizontalLineToRelative(4.24f);
        v12.lineToRelative(-0.66f, 3.18f);
        v12.curveToRelative(-0.08f, 0.37f, 0.04f, 0.75f, 0.3f, 1.02f);
        v12.curveToRelative(0.44f, 0.44f, 1.15f, 0.44f, 1.58f, 0f);
        v12.lineToRelative(4f, -4f);
        v12.curveToRelative(0.38f, -0.38f, 0.59f, -0.88f, 0.59f, -1.41f);
        v12.verticalLineTo(12f);
        v12.curveToRelative(0.01f, -1.1f, -0.89f, -2f, -1.99f, -2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ThumbsUpDownKt._thumbsUpDown = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

