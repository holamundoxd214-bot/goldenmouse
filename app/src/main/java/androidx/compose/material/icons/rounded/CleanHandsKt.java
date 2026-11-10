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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cleanHands", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CleanHands", "Landroidx/compose/material/icons/Icons$Rounded;", "getCleanHands", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CleanHandsKt {
    private static ImageVector _cleanHands;

    static {
    }

    public static final ImageVector getCleanHands(Rounded arg19) {
        ImageVector v0 = CleanHandsKt._cleanHands;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CleanHands", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.99f, 7f);
        v12.lineToRelative(1.37f, -0.63f);
        v12.lineTo(16.99f, 5f);
        v12.lineToRelative(0.63f, 1.37f);
        v12.lineTo(18.99f, 7f);
        v12.lineToRelative(-1.37f, 0.63f);
        v12.lineTo(16.99f, 9f);
        v12.lineToRelative(-0.63f, -1.37f);
        v12.lineTo(14.99f, 7f);
        v12.close();
        v12.moveTo(20f, 14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -0.78f, -0.99f, -2.44f, -1.58f, -3.36f);
        v12.curveToRelative(-0.2f, -0.31f, -0.64f, -0.31f, -0.84f, 0f);
        v12.curveTo(18.99f, 9.56f, 18f, 11.22f, 18f, 12f);
        v12.curveTo(18f, 13.1f, 18.9f, 14f, 20f, 14f);
        v12.close();
        v12.moveTo(9.24f, 9.5f);
        v12.lineTo(15f, 11.65f);
        v12.verticalLineTo(11f);
        v12.curveToRelative(0f, -2.42f, -1.72f, -4.44f, -4f, -4.9f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.35f, 0f, 0.68f, 0.06f, 1f, 0.18f);
        v12.curveToRelative(0.37f, 0.13f, 0.78f, 0.05f, 1.05f, -0.22f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.51f, -0.51f, 0.34f, -1.39f, -0.33f, -1.64f);
        v12.curveTo(14.19f, 2.11f, 13.61f, 2f, 13f, 2f);
        v12.horizontalLineTo(8.5f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2.11f);
        v12.curveTo(7.22f, 6.48f, 5.8f, 7.79f, 5.25f, 9.5f);
        v12.horizontalLineTo(9.24f);
        v12.close();
        v12.moveTo(3f, 11f);
        v12.lineTo(3f, 11f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(7f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-7f);
        v12.curveTo(5f, 11.9f, 4.1f, 11f, 3f, 11f);
        v12.close();
        v12.moveTo(19.99f, 17f);
        v12.horizontalLineToRelative(-6.83f);
        v12.curveToRelative(-0.11f, 0f, -0.22f, -0.02f, -0.33f, -0.06f);
        v12.lineToRelative(-1.47f, -0.51f);
        v12.curveToRelative(-0.26f, -0.09f, -0.39f, -0.37f, -0.3f, -0.63f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.09f, -0.26f, 0.38f, -0.4f, 0.64f, -0.3f);
        v12.lineToRelative(1.12f, 0.43f);
        v12.curveToRelative(0.11f, 0.04f, 0.24f, 0.07f, 0.36f, 0.07f);
        v12.horizontalLineToRelative(2.63f);
        v12.curveToRelative(0.65f, 0f, 1.18f, -0.53f, 1.18f, -1.18f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.49f, -0.31f, -0.93f, -0.77f, -1.11f);
        v12.lineTo(9.3f, 11.13f);
        v12.curveTo(9.08f, 11.04f, 8.84f, 11f, 8.6f, 11f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(9.02f);
        v12.lineToRelative(6.37f, 1.81f);
        v12.curveToRelative(0.41f, 0.12f, 0.85f, 0.1f, 1.25f, -0.05f);
        v12.lineTo(22f, 19f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(22f, 17.889999f, 21.1f, 17f, 19.99f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CleanHandsKt._cleanHands = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

