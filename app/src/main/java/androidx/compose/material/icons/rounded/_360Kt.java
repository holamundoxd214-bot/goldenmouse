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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"__360", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_360", "Landroidx/compose/material/icons/Icons$Rounded;", "get_360$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "get_360", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class _360Kt {
    private static ImageVector __360;

    static {
    }

    public static final ImageVector get_360(Rounded arg19) {
        ImageVector v0 = _360Kt.__360;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded._360", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 7f);
        v12.curveTo(6.48f, 7f, 2f, 9.24f, 2f, 12f);
        v12.curveToRelative(0f, 2.24f, 2.94f, 4.13f, 7f, 4.77f);
        v12.verticalLineToRelative(2.02f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        v12.lineToRelative(2.79f, -2.79f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f);
        v12.lineToRelative(-2.79f, -2.79f);
        v12.curveToRelative(-0.31f, -0.31f, -0.85f, -0.09f, -0.85f, 0.36f);
        v12.verticalLineToRelative(1.52f);
        v12.curveToRelative(-3.15f, -0.56f, -5f, -1.9f, -5f, -2.73f);
        v12.curveToRelative(0f, -1.06f, 3.04f, -3f, 8f, -3f);
        v12.reflectiveCurveToRelative(8f, 1.94f, 8f, 3f);
        v12.curveToRelative(0f, 0.66f, -1.2f, 1.68f, -3.32f, 2.34f);
        v12.curveToRelative(-0.41f, 0.13f, -0.68f, 0.51f, -0.68f, 0.94f);
        v12.curveToRelative(0f, 0.67f, 0.65f, 1.16f, 1.28f, 0.96f);
        v12.curveTo(20.110001f, 15.36f, 22f, 13.79f, 22f, 12f);
        v12.curveToRelative(0f, -2.76f, -4.48f, -5f, -10f, -5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        _360Kt.__360 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded._360", replaceWith="<_subannotation>") public static void get_360$annotations(Rounded arg0) {
    }
}

