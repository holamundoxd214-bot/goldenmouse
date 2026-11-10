package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nightsStay", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NightsStay", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNightsStay", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NightsStayKt {
    private static ImageVector _nightsStay;

    static {
    }

    public static final ImageVector getNightsStay(TwoTone arg19) {
        ImageVector v0 = NightsStayKt._nightsStay;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.NightsStay", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.1f, 14.15f);
        v12.curveTo(9.77f, 14.63f, 11f, 16.17f, 11f, 18f);
        v12.curveToRelative(0f, 0.68f, -0.19f, 1.31f, -0.48f, 1.87f);
        v12.curveToRelative(0.48f, 0.09f, 0.97f, 0.14f, 1.48f, 0.14f);
        v12.curveToRelative(1.48f, 0f, 2.9f, -0.41f, 4.13f, -1.15f);
        v12.curveToRelative(-2.62f, -0.92f, -5.23f, -2.82f, -6.8f, -5.86f);
        v12.curveTo(7.74f, 9.94f, 7.78f, 7.09f, 8.29f, 4.9f);
        v12.curveToRelative(-2.57f, 1.33f, -4.3f, 4.01f, -4.3f, 7.1f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.curveToRelative(0.01f, 0f, 0.01f, 0f, 0.02f, 0f);
        v12.curveTo(5.66f, 12f, 7.18f, 12.83f, 8.1f, 14.15f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.780001f, 17.51f);
        v12.curveToRelative(-2.47f, 0f, -6.57f, -1.33f, -8.68f, -5.43f);
        v12.curveTo(8.77f, 7.57f, 10.6f, 3.6f, 11.63f, 2.01f);
        v12.curveTo(6.27f, 2.2f, 1.98f, 6.59f, 1.98f, 12f);
        v12.curveToRelative(0f, 0.14f, 0.02f, 0.28f, 0.02f, 0.42f);
        v12.curveTo(2.61f, 12.16f, 3.28f, 12f, 3.98f, 12f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.curveToRelative(0f, -3.09f, 1.73f, -5.77f, 4.3f, -7.1f);
        v12.curveTo(7.78f, 7.09f, 7.74f, 9.94f, 9.32f, 13f);
        v12.curveToRelative(1.57f, 3.04f, 4.18f, 4.95f, 6.8f, 5.86f);
        v12.curveToRelative(-1.23f, 0.74f, -2.65f, 1.15f, -4.13f, 1.15f);
        v12.curveToRelative(-0.5f, 0f, -1f, -0.05f, -1.48f, -0.14f);
        v12.curveToRelative(-0.37f, 0.7f, -0.94f, 1.27f, -1.64f, 1.64f);
        v12.curveToRelative(0.98f, 0.32f, 2.03f, 0.5f, 3.11f, 0.5f);
        v12.curveToRelative(3.5f, 0f, 6.58f, -1.8f, 8.37f, -4.52f);
        v12.curveTo(20.18f, 17.5f, 19.98f, 17.51f, 19.780001f, 17.51f);
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

