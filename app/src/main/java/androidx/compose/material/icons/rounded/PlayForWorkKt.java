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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_playForWork", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PlayForWork", "Landroidx/compose/material/icons/Icons$Rounded;", "getPlayForWork", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PlayForWorkKt {
    private static ImageVector _playForWork;

    static {
    }

    public static final ImageVector getPlayForWork(Rounded arg19) {
        ImageVector v0 = PlayForWorkKt._playForWork;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PlayForWork", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 6f);
        v12.verticalLineToRelative(4.59f);
        v12.lineTo(8.71f, 10.59f);
        v12.curveToRelative(-0.45f, 0f, -0.67f, 0.54f, -0.35f, 0.85f);
        v12.lineToRelative(3.29f, 3.29f);
        v12.curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f);
        v12.lineToRelative(3.29f, -3.29f);
        v12.curveToRelative(0.31f, -0.31f, 0.09f, -0.85f, -0.35f, -0.85f);
        v12.lineTo(13f, 10.59f);
        v12.lineTo(13f, 6f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.close();
        v12.moveTo(7.1f, 14f);
        v12.curveToRelative(-0.61f, 0f, -1.11f, 0.55f, -0.99f, 1.15f);
        v12.curveTo(6.65f, 17.91f, 9.08f, 20f, 12f, 20f);
        v12.reflectiveCurveToRelative(5.35f, -2.09f, 5.89f, -4.85f);
        v12.curveToRelative(0.12f, -0.6f, -0.38f, -1.15f, -0.99f, -1.15f);
        v12.curveToRelative(-0.49f, 0f, -0.88f, 0.35f, -0.98f, 0.83f);
        v12.curveTo(15.53f, 16.639999f, 13.93f, 18f, 12f, 18f);
        v12.reflectiveCurveToRelative(-3.53f, -1.36f, -3.91f, -3.17f);
        v12.curveToRelative(-0.1f, -0.48f, -0.5f, -0.83f, -0.99f, -0.83f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PlayForWorkKt._playForWork = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

