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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nestCamWiredStand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NestCamWiredStand", "Landroidx/compose/material/icons/Icons$Rounded;", "getNestCamWiredStand", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NestCamWiredStandKt {
    private static ImageVector _nestCamWiredStand;

    static {
    }

    public static final ImageVector getNestCamWiredStand(Rounded arg19) {
        ImageVector v0 = NestCamWiredStandKt._nestCamWiredStand;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NestCamWiredStand", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.83f, 1.01f);
        v12.lineToRelative(-4.11f, 0.42f);
        v12.curveTo(8.47f, 1.75f, 6f, 4.48f, 6f, 7.75f);
        v12.reflectiveCurveToRelative(2.47f, 6f, 5.72f, 6.33f);
        v12.lineToRelative(1.9f, 0.19f);
        v12.lineToRelative(-0.56f, 0.85f);
        v12.curveTo(12.71f, 15.04f, 12.36f, 15f, 12f, 15f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(8f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -1.67f, -0.83f, -3.15f, -2.09f, -4.06f);
        v12.lineToRelative(0.97f, -1.45f);
        v12.curveTo(17.02f, 14.56f, 18f, 13.66f, 18f, 12.5f);
        v12.verticalLineTo(3f);
        v12.curveTo(18f, 1.83f, 17f, 0.91f, 15.83f, 1.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NestCamWiredStandKt._nestCamWiredStand = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

