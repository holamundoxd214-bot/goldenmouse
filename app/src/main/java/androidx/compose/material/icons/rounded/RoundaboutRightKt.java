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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_roundaboutRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RoundaboutRight", "Landroidx/compose/material/icons/Icons$Rounded;", "getRoundaboutRight", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RoundaboutRightKt {
    private static ImageVector _roundaboutRight;

    static {
    }

    public static final ImageVector getRoundaboutRight(Rounded arg19) {
        ImageVector v0 = RoundaboutRightKt._roundaboutRight;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RoundaboutRight", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 21f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.lineToRelative(0f, -5.09f);
        v12.curveToRelative(0f, -0.98f, -0.71f, -1.8f, -1.67f, -1.97f);
        v12.curveTo(5.44f, 12.63f, 4f, 10.98f, 4f, 9f);
        v12.curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f);
        v12.curveToRelative(1.98f, 0f, 3.63f, 1.44f, 3.94f, 3.33f);
        v12.curveTo(12.11f, 9.29f, 12.93f, 10f, 13.91f, 10f);
        v12.lineToRelative(4.26f, 0f);
        v12.lineToRelative(-0.88f, 0.88f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(2.59f, -2.59f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-2.59f, -2.59f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(18.17f, 8f);
        v12.lineToRelative(-4.25f, 0f);
        v12.curveTo(13.44f, 5.16f, 10.97f, 3f, 8f, 3f);
        v12.curveTo(4.69f, 3f, 2f, 5.69f, 2f, 9f);
        v12.curveToRelative(0f, 2.97f, 2.16f, 5.44f, 5f, 5.92f);
        v12.lineTo(7f, 20f);
        v12.curveTo(7f, 20.549999f, 7.45f, 21f, 8f, 21f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RoundaboutRightKt._roundaboutRight = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

