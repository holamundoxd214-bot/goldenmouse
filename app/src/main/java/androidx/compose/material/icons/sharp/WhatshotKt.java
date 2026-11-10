package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_whatshot", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Whatshot", "Landroidx/compose/material/icons/Icons$Sharp;", "getWhatshot", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WhatshotKt {
    private static ImageVector _whatshot;

    static {
    }

    public static final ImageVector getWhatshot(Sharp arg19) {
        ImageVector v0 = WhatshotKt._whatshot;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Whatshot", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.5f, 0.67f);
        v12.reflectiveCurveToRelative(0.74f, 2.65f, 0.74f, 4.8f);
        v12.curveToRelative(0f, 2.06f, -1.35f, 3.73f, -3.41f, 3.73f);
        v12.curveToRelative(-2.07f, 0f, -3.63f, -1.67f, -3.63f, -3.73f);
        v12.lineToRelative(0.03f, -0.36f);
        v12.curveTo(5.21f, 7.51f, 4f, 10.62f, 4f, 14f);
        v12.curveToRelative(0f, 4.42f, 3.58f, 8f, 8f, 8f);
        v12.reflectiveCurveToRelative(8f, -3.58f, 8f, -8f);
        v12.curveTo(20f, 8.61f, 17.41f, 3.8f, 13.5f, 0.67f);
        v12.close();
        v12.moveTo(11.71f, 19f);
        v12.curveToRelative(-1.78f, 0f, -3.22f, -1.4f, -3.22f, -3.14f);
        v12.curveToRelative(0f, -1.62f, 1.05f, -2.76f, 2.81f, -3.12f);
        v12.curveToRelative(1.77f, -0.36f, 3.6f, -1.21f, 4.62f, -2.58f);
        v12.curveToRelative(0.39f, 1.29f, 0.59f, 2.65f, 0.59f, 4.04f);
        v12.curveToRelative(0f, 2.65f, -2.15f, 4.8f, -4.8f, 4.8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WhatshotKt._whatshot = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

