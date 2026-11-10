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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pageview", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Pageview", "Landroidx/compose/material/icons/Icons$Filled;", "getPageview", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PageviewKt {
    private static ImageVector _pageview;

    static {
    }

    public static final ImageVector getPageview(Filled arg19) {
        ImageVector v0 = PageviewKt._pageview;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Pageview", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(16.790001f, 18.209999f);
        v12.lineToRelative(-2.91f, -2.91f);
        v12.curveToRelative(-0.69f, 0.44f, -1.51f, 0.7f, -2.39f, 0.7f);
        v12.curveTo(9.01f, 16f, 7f, 13.99f, 7f, 11.5f);
        v12.reflectiveCurveTo(9.01f, 7f, 11.5f, 7f);
        v12.reflectiveCurveTo(16f, 9.01f, 16f, 11.5f);
        v12.curveToRelative(0f, 0.88f, -0.26f, 1.69f, -0.7f, 2.39f);
        v12.lineToRelative(2.91f, 2.9f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PageviewKt._pageview = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

