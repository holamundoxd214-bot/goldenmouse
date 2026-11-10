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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_gppBad", "Landroidx/compose/ui/graphics/vector/ImageVector;", "GppBad", "Landroidx/compose/material/icons/Icons$Rounded;", "getGppBad", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GppBadKt {
    private static ImageVector _gppBad;

    static {
    }

    public static final ImageVector getGppBad(Rounded arg19) {
        ImageVector v0 = GppBadKt._gppBad;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.GppBad", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.700001f, 4.51f);
        v12.lineToRelative(-6f, -2.25f);
        v12.curveToRelative(-0.45f, -0.17f, -0.95f, -0.17f, -1.4f, 0f);
        v12.lineToRelative(-6f, 2.25f);
        v12.curveTo(4.52f, 4.81f, 4f, 5.55f, 4f, 6.39f);
        v12.verticalLineToRelative(4.7f);
        v12.curveToRelative(0f, 4.94f, 3.27f, 9.57f, 7.71f, 10.83f);
        v12.curveToRelative(0.19f, 0.05f, 0.39f, 0.05f, 0.57f, 0f);
        v12.curveTo(16.73f, 20.66f, 20f, 16.030001f, 20f, 11.09f);
        v12.verticalLineToRelative(-4.7f);
        v12.curveTo(20f, 5.55f, 19.48f, 4.81f, 18.700001f, 4.51f);
        v12.close();
        v12.moveTo(14.8f, 14.79f);
        v12.lineTo(14.8f, 14.79f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0.01f);
        v12.lineTo(12f, 13.42f);
        v12.lineToRelative(-1.39f, 1.38f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(10.59f, 12f);
        v12.lineTo(9.2f, 10.61f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineTo(12f, 10.59f);
        v12.lineToRelative(1.39f, -1.39f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(13.42f, 12f);
        v12.lineToRelative(1.38f, 1.38f);
        v12.curveTo(15.19f, 13.77f, 15.19f, 14.4f, 14.8f, 14.79f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GppBadKt._gppBad = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

