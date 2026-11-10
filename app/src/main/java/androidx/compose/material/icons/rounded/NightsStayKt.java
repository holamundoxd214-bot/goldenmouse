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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nightsStay", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NightsStay", "Landroidx/compose/material/icons/Icons$Rounded;", "getNightsStay", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NightsStayKt {
    private static ImageVector _nightsStay;

    static {
    }

    public static final ImageVector getNightsStay(Rounded arg19) {
        ImageVector v0 = NightsStayKt._nightsStay;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NightsStay", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.1f, 12.08f);
        v12.curveToRelative(-2f, -3.88f, -0.92f, -7.36f, 0.07f, -9.27f);
        v12.curveToRelative(0.19f, -0.36f, -0.12f, -0.77f, -0.53f, -0.72f);
        v12.curveTo(5.62f, 2.77f, 1.78f, 7.16f, 1.99f, 12.41f);
        v12.curveToRelative(0.01f, 0f, 0.01f, 0f, 0.01f, 0.01f);
        v12.curveTo(2.62f, 12.15f, 3.29f, 12f, 4f, 12f);
        v12.curveToRelative(1.66f, 0f, 3.18f, 0.83f, 4.1f, 2.15f);
        v12.curveTo(9.77f, 14.63f, 11f, 16.17f, 11f, 18f);
        v12.curveToRelative(0f, 1.52f, -0.87f, 2.83f, -2.12f, 3.51f);
        v12.curveToRelative(0.98f, 0.32f, 2.03f, 0.5f, 3.11f, 0.5f);
        v12.curveToRelative(3.13f, 0f, 5.92f, -1.44f, 7.76f, -3.69f);
        v12.curveToRelative(0.26f, -0.32f, 0.04f, -0.79f, -0.37f, -0.82f);
        v12.curveTo(16.889999f, 17.370001f, 13.1f, 15.97f, 11.1f, 12.08f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(7f, 16f);
        v12.lineToRelative(-0.18f, 0f);
        v12.curveTo(6.4f, 14.84f, 5.3f, 14f, 4f, 14f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.curveToRelative(0.62f, 0f, 2.49f, 0f, 3f, 0f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveTo(9f, 16.9f, 8.1f, 16f, 7f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NightsStayKt._nightsStay = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

