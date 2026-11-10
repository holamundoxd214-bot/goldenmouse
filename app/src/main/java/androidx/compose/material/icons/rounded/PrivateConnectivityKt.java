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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_privateConnectivity", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PrivateConnectivity", "Landroidx/compose/material/icons/Icons$Rounded;", "getPrivateConnectivity", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PrivateConnectivityKt {
    private static ImageVector _privateConnectivity;

    static {
    }

    public static final ImageVector getPrivateConnectivity(Rounded arg19) {
        ImageVector v0 = PrivateConnectivityKt._privateConnectivity;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PrivateConnectivity", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 12f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-2.07f);
        v12.curveToRelative(-0.49f, -3.39f, -3.4f, -6f, -6.93f, -6f);
        v12.reflectiveCurveToRelative(-6.44f, 2.61f, -6.93f, 6f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2.07f);
        v12.curveToRelative(0.49f, 3.39f, 3.4f, 6f, 6.93f, 6f);
        v12.reflectiveCurveToRelative(6.44f, -2.61f, 6.93f, -6f);
        v12.horizontalLineTo(21f);
        v12.curveTo(21.549999f, 13f, 22f, 12.55f, 22f, 12f);
        v12.close();
        v12.moveTo(15f, 14.5f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -1.21f, 1.08f, -2.18f, 2.34f, -1.97f);
        v12.curveTo(13.32f, 7.69f, 14f, 8.61f, 14f, 9.61f);
        v12.verticalLineToRelative(0.89f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(14.5f);
        v12.close();
        v12.moveTo(12.75f, 13f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.reflectiveCurveTo(12.75f, 12.59f, 12.75f, 13f);
        v12.close();
        v12.moveTo(13f, 9.5f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveTo(13f, 8.95f, 13f, 9.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PrivateConnectivityKt._privateConnectivity = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

