package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mouse", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Mouse", "Landroidx/compose/material/icons/Icons$Filled;", "getMouse", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MouseKt {
    private static ImageVector _mouse;

    static {
    }

    public static final ImageVector getMouse(Filled arg19) {
        ImageVector v0 = MouseKt._mouse;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Mouse", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 1.07f);
        v12.lineTo(13f, 9f);
        v12.horizontalLineToRelative(7f);
        v12.curveToRelative(0f, -4.08f, -3.05f, -7.44f, -7f, -7.93f);
        v12.close();
        v12.moveTo(4f, 15f);
        v12.curveToRelative(0f, 4.42f, 3.58f, 8f, 8f, 8f);
        v12.reflectiveCurveToRelative(8f, -3.58f, 8f, -8f);
        v12.verticalLineToRelative(-4f);
        v12.lineTo(4f, 11f);
        v12.verticalLineToRelative(4f);
        v12.close();
        v12.moveTo(11f, 1.07f);
        v12.curveTo(7.05f, 1.56f, 4f, 4.92f, 4f, 9f);
        v12.horizontalLineToRelative(7f);
        v12.lineTo(11f, 1.07f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MouseKt._mouse = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

