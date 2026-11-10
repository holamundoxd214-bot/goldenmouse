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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_altRoute", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AltRoute", "Landroidx/compose/material/icons/Icons$Rounded;", "getAltRoute$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getAltRoute", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AltRouteKt {
    private static ImageVector _altRoute;

    static {
    }

    public static final ImageVector getAltRoute(Rounded arg19) {
        ImageVector v0 = AltRouteKt._altRoute;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AltRoute", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.78f, 11.16f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.curveToRelative(-0.68f, -0.69f, -1.34f, -1.58f, -1.79f, -2.94f);
        v12.lineToRelative(1.94f, -0.49f);
        v12.curveTo(8.83f, 10.04f, 9.28f, 10.65f, 9.78f, 11.16f);
        v12.close();
        v12.moveTo(10.15f, 5.15f);
        v12.lineTo(7.35f, 2.35f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.lineTo(3.85f, 5.15f);
        v12.curveTo(3.54f, 5.46f, 3.76f, 6f, 4.21f, 6f);
        v12.horizontalLineToRelative(1.81f);
        v12.curveTo(6.04f, 6.81f, 6.1f, 7.54f, 6.21f, 8.17f);
        v12.lineToRelative(1.94f, -0.49f);
        v12.curveTo(8.08f, 7.2f, 8.03f, 6.63f, 8.02f, 6f);
        v12.horizontalLineToRelative(1.78f);
        v12.curveTo(10.24f, 6f, 10.46f, 5.46f, 10.15f, 5.15f);
        v12.close();
        v12.moveTo(20.15f, 5.15f);
        v12.lineToRelative(-2.79f, -2.79f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.lineToRelative(-2.79f, 2.79f);
        v12.curveTo(13.54f, 5.46f, 13.76f, 6f, 14.21f, 6f);
        v12.horizontalLineToRelative(1.78f);
        v12.curveToRelative(-0.1f, 3.68f, -1.28f, 4.75f, -2.54f, 5.88f);
        v12.curveToRelative(-0.5f, 0.44f, -1.01f, 0.92f, -1.45f, 1.55f);
        v12.curveToRelative(-0.34f, -0.49f, -0.73f, -0.88f, -1.13f, -1.24f);
        v12.lineTo(9.46f, 13.6f);
        v12.curveTo(10.39f, 14.45f, 11f, 15.14f, 11f, 17f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.horizontalLineToRelative(0f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.curveToRelative(0f, -2.02f, 0.71f, -2.66f, 1.79f, -3.63f);
        v12.curveToRelative(1.38f, -1.24f, 3.08f, -2.78f, 3.2f, -7.37f);
        v12.horizontalLineToRelative(1.8f);
        v12.curveTo(20.24f, 6f, 20.459999f, 5.46f, 20.15f, 5.15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AltRouteKt._altRoute = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.AltRoute", replaceWith="<_subannotation>") public static void getAltRoute$annotations(Rounded arg0) {
    }
}

