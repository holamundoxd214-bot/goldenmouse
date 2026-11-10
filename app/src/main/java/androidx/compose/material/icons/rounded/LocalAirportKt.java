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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localAirport", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalAirport", "Landroidx/compose/material/icons/Icons$Rounded;", "getLocalAirport", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalAirportKt {
    private static ImageVector _localAirport;

    static {
    }

    public static final ImageVector getLocalAirport(Rounded arg19) {
        ImageVector v0 = LocalAirportKt._localAirport;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LocalAirport", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.48f, 13.7f);
        v12.lineTo(13.5f, 9f);
        v12.verticalLineTo(3.5f);
        v12.curveTo(13.5f, 2.67f, 12.83f, 2f, 12f, 2f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f);
        v12.verticalLineTo(9f);
        v12.lineToRelative(-7.98f, 4.7f);
        v12.curveTo(2.2f, 13.88f, 2f, 14.23f, 2f, 14.6f);
        v12.curveToRelative(0f, 0.7f, 0.67f, 1.2f, 1.34f, 1.01f);
        v12.lineToRelative(7.16f, -2.1f);
        v12.verticalLineTo(19f);
        v12.lineToRelative(-2.26f, 1.35f);
        v12.curveTo(8.09f, 20.440001f, 8f, 20.610001f, 8f, 20.780001f);
        v12.lineToRelative(0f, 0.5f);
        v12.horizontalLineToRelative(0f);
        v12.verticalLineToRelative(0.08f);
        v12.curveToRelative(0f, 0.33f, 0.31f, 0.57f, 0.62f, 0.49f);
        v12.lineToRelative(2.92f, -0.73f);
        v12.lineTo(12f, 21f);
        v12.lineToRelative(0.38f, 0.09f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.lineToRelative(0.42f, 0.11f);
        v12.lineToRelative(1.9f, 0.48f);
        v12.lineToRelative(0f, 0f);
        v12.lineToRelative(0.67f, 0.17f);
        v12.curveToRelative(0.32f, 0.08f, 0.62f, -0.16f, 0.62f, -0.49f);
        v12.verticalLineToRelative(-0.37f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.verticalLineToRelative(-0.21f);
        v12.curveToRelative(0f, -0.18f, -0.09f, -0.34f, -0.24f, -0.43f);
        v12.lineTo(13.5f, 19f);
        v12.verticalLineToRelative(-5.5f);
        v12.lineToRelative(7.16f, 2.1f);
        v12.curveTo(21.33f, 15.8f, 22f, 15.3f, 22f, 14.6f);
        v12.curveTo(22f, 14.23f, 21.799999f, 13.88f, 21.48f, 13.7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalAirportKt._localAirport = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

