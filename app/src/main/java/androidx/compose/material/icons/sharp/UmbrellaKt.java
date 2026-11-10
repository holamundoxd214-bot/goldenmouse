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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_umbrella", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Umbrella", "Landroidx/compose/material/icons/Icons$Sharp;", "getUmbrella", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UmbrellaKt {
    private static ImageVector _umbrella;

    static {
    }

    public static final ImageVector getUmbrella(Sharp arg19) {
        ImageVector v0 = UmbrellaKt._umbrella;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Umbrella", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.5f, 6.92f);
        v12.lineTo(13f, 5.77f);
        v12.verticalLineTo(3.88f);
        v12.verticalLineTo(3.4f);
        v12.curveToRelative(0f, -0.26f, 0.22f, -0.48f, 0.5f, -0.48f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.21f, 0.5f, 0.48f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(3.4f);
        v12.curveTo(16f, 2.07f, 14.88f, 1f, 13.5f, 1f);
        v12.curveTo(12.12f, 1f, 11f, 2.07f, 11f, 3.4f);
        v12.verticalLineToRelative(0.48f);
        v12.verticalLineToRelative(1.89f);
        v12.lineTo(9.5f, 6.92f);
        v12.lineTo(6f, 6.07f);
        v12.lineToRelative(5.05f, 15.25f);
        v12.curveTo(11.2f, 21.77f, 11.6f, 22f, 12f, 22f);
        v12.reflectiveCurveToRelative(0.8f, -0.23f, 0.95f, -0.69f);
        v12.lineTo(18f, 6.07f);
        v12.lineTo(14.5f, 6.92f);
        v12.close();
        v12.moveTo(13.28f, 8.5f);
        v12.lineToRelative(0.76f, 0.58f);
        v12.lineToRelative(0.92f, -0.23f);
        v12.lineTo(13f, 14.8f);
        v12.verticalLineTo(8.29f);
        v12.lineTo(13.28f, 8.5f);
        v12.close();
        v12.moveTo(9.96f, 9.09f);
        v12.lineToRelative(0.76f, -0.58f);
        v12.lineTo(11f, 8.29f);
        v12.verticalLineToRelative(6.51f);
        v12.lineTo(9.03f, 8.86f);
        v12.lineTo(9.96f, 9.09f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UmbrellaKt._umbrella = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

