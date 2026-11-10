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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_whatshot", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Whatshot", "Landroidx/compose/material/icons/Icons$Outlined;", "getWhatshot", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WhatshotKt {
    private static ImageVector _whatshot;

    static {
    }

    public static final ImageVector getWhatshot(Outlined arg19) {
        ImageVector v0 = WhatshotKt._whatshot;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Whatshot", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.57f, 13.16f);
        v12.curveToRelative(-1.36f, 0.28f, -2.17f, 1.16f, -2.17f, 2.41f);
        v12.curveToRelative(0f, 1.34f, 1.11f, 2.42f, 2.49f, 2.42f);
        v12.curveToRelative(2.05f, 0f, 3.71f, -1.66f, 3.71f, -3.71f);
        v12.curveToRelative(0f, -1.07f, -0.15f, -2.12f, -0.46f, -3.12f);
        v12.curveToRelative(-0.79f, 1.07f, -2.2f, 1.72f, -3.57f, 2f);
        v12.close();
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
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-3.31f, 0f, -6f, -2.69f, -6f, -6f);
        v12.curveToRelative(0f, -1.53f, 0.3f, -3.04f, 0.86f, -4.43f);
        v12.curveToRelative(1.01f, 1.01f, 2.41f, 1.63f, 3.97f, 1.63f);
        v12.curveToRelative(2.66f, 0f, 4.75f, -1.83f, 5.28f, -4.43f);
        v12.curveTo(17.34f, 8.97f, 18f, 11.44f, 18f, 14f);
        v12.curveToRelative(0f, 3.31f, -2.69f, 6f, -6f, 6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WhatshotKt._whatshot = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

