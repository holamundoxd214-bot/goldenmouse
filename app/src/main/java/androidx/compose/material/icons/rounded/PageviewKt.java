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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pageview", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Pageview", "Landroidx/compose/material/icons/Icons$Rounded;", "getPageview", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PageviewKt {
    private static ImageVector _pageview;

    static {
    }

    public static final ImageVector getPageview(Rounded arg19) {
        ImageVector v0 = PageviewKt._pageview;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Pageview", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.5f, 9f);
        v12.curveTo(10.12f, 9f, 9f, 10.12f, 9f, 11.5f);
        v12.reflectiveCurveToRelative(1.12f, 2.5f, 2.5f, 2.5f);
        v12.reflectiveCurveToRelative(2.5f, -1.12f, 2.5f, -2.5f);
        v12.reflectiveCurveTo(12.88f, 9f, 11.5f, 9f);
        v12.close();
        v12.moveTo(20f, 4f);
        v12.lineTo(4f, 4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(22f, 6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(16.08f, 17.5f);
        v12.lineToRelative(-2.2f, -2.2f);
        v12.curveToRelative(-0.9f, 0.58f, -2.03f, 0.84f, -3.22f, 0.62f);
        v12.curveToRelative(-1.88f, -0.35f, -3.38f, -1.93f, -3.62f, -3.83f);
        v12.curveToRelative(-0.38f, -3.01f, 2.18f, -5.52f, 5.21f, -5.04f);
        v12.curveToRelative(1.88f, 0.3f, 3.39f, 1.84f, 3.7f, 3.71f);
        v12.curveToRelative(0.19f, 1.16f, -0.08f, 2.23f, -0.64f, 3.12f);
        v12.lineToRelative(2.2f, 2.19f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.03f, 0f, 1.42f);
        v12.curveToRelative(-0.4f, 0.4f, -1.04f, 0.4f, -1.43f, 0.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PageviewKt._pageview = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

