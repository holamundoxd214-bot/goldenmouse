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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_router", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Router", "Landroidx/compose/material/icons/Icons$Rounded;", "getRouter", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RouterKt {
    private static ImageVector _router;

    static {
    }

    public static final ImageVector getRouter(Rounded arg19) {
        ImageVector v0 = RouterKt._router;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Router", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.45f, 5.55f);
        v12.curveToRelative(0.19f, 0.19f, 0.5f, 0.21f, 0.72f, 0.04f);
        v12.curveTo(13.3f, 4.69f, 14.65f, 4.2f, 16f, 4.2f);
        v12.reflectiveCurveToRelative(2.7f, 0.49f, 3.84f, 1.39f);
        v12.curveToRelative(0.21f, 0.17f, 0.52f, 0.15f, 0.72f, -0.04f);
        v12.lineToRelative(0.04f, -0.05f);
        v12.curveToRelative(0.22f, -0.22f, 0.21f, -0.59f, -0.03f, -0.8f);
        v12.curveTo(19.24f, 3.57f, 17.620001f, 3f, 16f, 3f);
        v12.reflectiveCurveToRelative(-3.24f, 0.57f, -4.57f, 1.7f);
        v12.curveToRelative(-0.24f, 0.21f, -0.26f, 0.57f, -0.03f, 0.8f);
        v12.lineToRelative(0.05f, 0.05f);
        v12.close();
        v12.moveTo(13.15f, 6.31f);
        v12.curveToRelative(-0.25f, 0.2f, -0.26f, 0.58f, -0.04f, 0.8f);
        v12.lineToRelative(0.04f, 0.04f);
        v12.curveToRelative(0.2f, 0.2f, 0.5f, 0.2f, 0.72f, 0.04f);
        v12.curveToRelative(0.63f, -0.48f, 1.38f, -0.69f, 2.13f, -0.69f);
        v12.reflectiveCurveToRelative(1.5f, 0.21f, 2.13f, 0.68f);
        v12.curveToRelative(0.22f, 0.17f, 0.53f, 0.16f, 0.72f, -0.04f);
        v12.lineToRelative(0.04f, -0.04f);
        v12.curveToRelative(0.23f, -0.23f, 0.21f, -0.6f, -0.04f, -0.8f);
        v12.curveToRelative(-0.83f, -0.64f, -1.84f, -1f, -2.85f, -1f);
        v12.reflectiveCurveToRelative(-2.02f, 0.36f, -2.85f, 1.01f);
        v12.close();
        v12.moveTo(19f, 13f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(5f, 13f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(8f, 18f);
        v12.lineTo(6f, 18f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(11.5f, 18f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(15f, 18f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RouterKt._router = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

