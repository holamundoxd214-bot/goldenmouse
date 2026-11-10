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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cookie", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Cookie", "Landroidx/compose/material/icons/Icons$Sharp;", "getCookie", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CookieKt {
    private static ImageVector _cookie;

    static {
    }

    public static final ImageVector getCookie(Sharp arg19) {
        ImageVector v0 = CookieKt._cookie;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Cookie", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.950001f, 10.99f);
        v12.curveToRelative(-1.79f, -0.03f, -3.7f, -1.95f, -2.68f, -4.22f);
        v12.curveToRelative(-2.98f, 1f, -5.77f, -1.59f, -5.19f, -4.56f);
        v12.curveTo(6.95f, 0.71f, 2f, 6.58f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.curveTo(17.889999f, 22f, 22.540001f, 16.92f, 21.950001f, 10.99f);
        v12.close();
        v12.moveTo(8.5f, 15f);
        v12.curveTo(7.67f, 15f, 7f, 14.33f, 7f, 13.5f);
        v12.reflectiveCurveTo(7.67f, 12f, 8.5f, 12f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(9.33f, 15f, 8.5f, 15f);
        v12.close();
        v12.moveTo(10.5f, 10f);
        v12.curveTo(9.67f, 10f, 9f, 9.33f, 9f, 8.5f);
        v12.reflectiveCurveTo(9.67f, 7f, 10.5f, 7f);
        v12.reflectiveCurveTo(12f, 7.67f, 12f, 8.5f);
        v12.reflectiveCurveTo(11.33f, 10f, 10.5f, 10f);
        v12.close();
        v12.moveTo(15f, 16f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(16f, 15.55f, 15.55f, 16f, 15f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CookieKt._cookie = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

