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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_whatshot", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Whatshot", "Landroidx/compose/material/icons/Icons$Rounded;", "getWhatshot", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WhatshotKt {
    private static ImageVector _whatshot;

    static {
    }

    public static final ImageVector getWhatshot(Rounded arg19) {
        ImageVector v0 = WhatshotKt._whatshot;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Whatshot", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.09f, 4.56f);
        v12.curveToRelative(-0.7f, -1.03f, -1.5f, -1.99f, -2.4f, -2.85f);
        v12.curveToRelative(-0.35f, -0.34f, -0.94f, -0.02f, -0.84f, 0.46f);
        v12.curveToRelative(0.19f, 0.94f, 0.39f, 2.18f, 0.39f, 3.29f);
        v12.curveToRelative(0f, 2.06f, -1.35f, 3.73f, -3.41f, 3.73f);
        v12.curveToRelative(-1.54f, 0f, -2.8f, -0.93f, -3.35f, -2.26f);
        v12.curveToRelative(-0.1f, -0.2f, -0.14f, -0.32f, -0.2f, -0.54f);
        v12.curveToRelative(-0.11f, -0.42f, -0.66f, -0.55f, -0.9f, -0.18f);
        v12.curveToRelative(-0.18f, 0.27f, -0.35f, 0.54f, -0.51f, 0.83f);
        v12.curveTo(4.68f, 9.08f, 4f, 11.46f, 4f, 14f);
        v12.curveToRelative(0f, 4.42f, 3.58f, 8f, 8f, 8f);
        v12.reflectiveCurveToRelative(8f, -3.58f, 8f, -8f);
        v12.curveToRelative(0f, -3.49f, -1.08f, -6.73f, -2.91f, -9.44f);
        v12.close();
        v12.moveTo(11.71f, 19f);
        v12.curveToRelative(-1.78f, 0f, -3.22f, -1.4f, -3.22f, -3.14f);
        v12.curveToRelative(0f, -1.62f, 1.05f, -2.76f, 2.81f, -3.12f);
        v12.curveToRelative(1.47f, -0.3f, 2.98f, -0.93f, 4.03f, -1.92f);
        v12.curveToRelative(0.28f, -0.26f, 0.74f, -0.14f, 0.82f, 0.23f);
        v12.curveToRelative(0.23f, 1.02f, 0.35f, 2.08f, 0.35f, 3.15f);
        v12.curveToRelative(0.01f, 2.65f, -2.14f, 4.8f, -4.79f, 4.8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WhatshotKt._whatshot = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

