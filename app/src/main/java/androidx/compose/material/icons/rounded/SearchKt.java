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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_search", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Search", "Landroidx/compose/material/icons/Icons$Rounded;", "getSearch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SearchKt {
    private static ImageVector _search;

    static {
    }

    public static final ImageVector getSearch(Rounded arg19) {
        ImageVector v0 = SearchKt._search;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Search", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.5f, 14f);
        v12.horizontalLineToRelative(-0.79f);
        v12.lineToRelative(-0.28f, -0.27f);
        v12.curveToRelative(1.2f, -1.4f, 1.82f, -3.31f, 1.48f, -5.34f);
        v12.curveToRelative(-0.47f, -2.78f, -2.79f, -5f, -5.59f, -5.34f);
        v12.curveToRelative(-4.23f, -0.52f, -7.79f, 3.04f, -7.27f, 7.27f);
        v12.curveToRelative(0.34f, 2.8f, 2.56f, 5.12f, 5.34f, 5.59f);
        v12.curveToRelative(2.03f, 0.34f, 3.94f, -0.28f, 5.34f, -1.48f);
        v12.lineToRelative(0.27f, 0.28f);
        v12.verticalLineToRelative(0.79f);
        v12.lineToRelative(4.25f, 4.25f);
        v12.curveToRelative(0.41f, 0.41f, 1.08f, 0.41f, 1.49f, 0f);
        v12.curveToRelative(0.41f, -0.41f, 0.41f, -1.08f, 0f, -1.49f);
        v12.lineTo(15.5f, 14f);
        v12.close();
        v12.moveTo(9.5f, 14f);
        v12.curveTo(7.01f, 14f, 5f, 11.99f, 5f, 9.5f);
        v12.reflectiveCurveTo(7.01f, 5f, 9.5f, 5f);
        v12.reflectiveCurveTo(14f, 7.01f, 14f, 9.5f);
        v12.reflectiveCurveTo(11.99f, 14f, 9.5f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SearchKt._search = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

