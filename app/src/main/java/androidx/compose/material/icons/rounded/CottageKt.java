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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cottage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Cottage", "Landroidx/compose/material/icons/Icons$Rounded;", "getCottage", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CottageKt {
    private static ImageVector _cottage;

    static {
    }

    public static final ImageVector getCottage(Rounded arg19) {
        ImageVector v0 = CottageKt._cottage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Cottage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22.389999f, 12.19f);
        v12.curveToRelative(0.34f, -0.44f, 0.25f, -1.07f, -0.19f, -1.4f);
        v12.lineToRelative(-9.6f, -7.33f);
        v12.curveToRelative(-0.36f, -0.27f, -0.86f, -0.27f, -1.21f, 0f);
        v12.lineTo(6f, 7.58f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveTo(4f, 6.45f, 4f, 7f);
        v12.verticalLineToRelative(2.11f);
        v12.lineToRelative(-2.21f, 1.68f);
        v12.curveToRelative(-0.44f, 0.33f, -0.52f, 0.96f, -0.19f, 1.4f);
        v12.curveToRelative(0.34f, 0.44f, 0.96f, 0.52f, 1.4f, 0.19f);
        v12.lineTo(4f, 11.62f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-5f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-8.38f);
        v12.lineToRelative(0.99f, 0.76f);
        v12.curveTo(21.43f, 12.72f, 22.059999f, 12.63f, 22.389999f, 12.19f);
        v12.close();
        v12.moveTo(5.27f, 5f);
        v12.curveToRelative(-0.74f, 0f, -1.26f, -0.8f, -0.9f, -1.45f);
        v12.curveTo(4.89f, 2.62f, 5.87f, 2f, 7f, 2f);
        v12.curveToRelative(0.38f, 0f, 0.72f, -0.22f, 0.89f, -0.53f);
        v12.curveTo(8.04f, 1.16f, 8.39f, 1f, 8.73f, 1f);
        v12.curveToRelative(0.74f, 0f, 1.26f, 0.8f, 0.9f, 1.45f);
        v12.curveTo(9.11f, 3.38f, 8.13f, 4f, 7f, 4f);
        v12.curveTo(6.62f, 4f, 6.28f, 4.22f, 6.11f, 4.53f);
        v12.curveTo(5.96f, 4.84f, 5.61f, 5f, 5.27f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CottageKt._cottage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

