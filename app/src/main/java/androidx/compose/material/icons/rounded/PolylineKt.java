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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_polyline", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Polyline", "Landroidx/compose/material/icons/Icons$Rounded;", "getPolyline", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PolylineKt {
    private static ImageVector _polyline;

    static {
    }

    public static final ImageVector getPolyline(Rounded arg19) {
        ImageVector v0 = PolylineKt._polyline;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Polyline", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.04f, 6.85f);
        v12.lineTo(7.3f, 10f);
        v12.horizontalLineTo(4.5f);
        v12.curveTo(3.67f, 10f, 3f, 10.67f, 3f, 11.5f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(3f, 15.33f, 3.67f, 16f, 4.5f, 16f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.14f, 0f, 0.27f, -0.02f, 0.39f, -0.05f);
        v12.lineTo(15f, 19.5f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.75f, 0f, -1.37f, 0.55f, -1.48f, 1.27f);
        v12.lineTo(9f, 14.26f);
        v12.verticalLineTo(11.5f);
        v12.curveToRelative(0f, -0.12f, -0.01f, -0.24f, -0.04f, -0.36f);
        v12.lineTo(11.7f, 8f);
        v12.horizontalLineToRelative(2.8f);
        v12.curveTo(15.33f, 8f, 16f, 7.33f, 16f, 6.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(16f, 2.67f, 15.33f, 2f, 14.5f, 2f);
        v12.horizontalLineToRelative(-3f);
        v12.curveTo(10.67f, 2f, 10f, 2.67f, 10f, 3.5f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(10f, 6.62f, 10.01f, 6.74f, 10.04f, 6.85f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PolylineKt._polyline = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

