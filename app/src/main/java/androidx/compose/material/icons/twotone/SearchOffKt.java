package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_searchOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SearchOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSearchOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SearchOffKt {
    private static ImageVector _searchOff;

    static {
    }

    public static final ImageVector getSearchOff(TwoTone arg19) {
        ImageVector v0 = SearchOffKt._searchOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.SearchOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.5f, 14f);
        v12.horizontalLineToRelative(-0.79f);
        v12.lineToRelative(-0.28f, -0.27f);
        v12.curveTo(15.41f, 12.59f, 16f, 11.11f, 16f, 9.5f);
        v12.curveTo(16f, 5.91f, 13.09f, 3f, 9.5f, 3f);
        v12.curveTo(6.08f, 3f, 3.28f, 5.64f, 3.03f, 9f);
        v12.horizontalLineToRelative(2.02f);
        v12.curveTo(5.3f, 6.75f, 7.18f, 5f, 9.5f, 5f);
        v12.curveTo(11.99f, 5f, 14f, 7.01f, 14f, 9.5f);
        v12.reflectiveCurveTo(11.99f, 14f, 9.5f, 14f);
        v12.curveToRelative(-0.17f, 0f, -0.33f, -0.03f, -0.5f, -0.05f);
        v12.verticalLineToRelative(2.02f);
        v12.curveTo(9.17f, 15.99f, 9.33f, 16f, 9.5f, 16f);
        v12.curveToRelative(1.61f, 0f, 3.09f, -0.59f, 4.23f, -1.57f);
        v12.lineTo(14f, 14.71f);
        v12.verticalLineToRelative(0.79f);
        v12.lineToRelative(5f, 4.99f);
        v12.lineTo(20.49f, 19f);
        v12.lineTo(15.5f, 14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(6.47f, 10.82f);
        v0_1.lineToRelative(-2.47f, 2.47f);
        v0_1.lineToRelative(-2.47f, -2.47f);
        v0_1.lineToRelative(-0.71f, 0.71f);
        v0_1.lineToRelative(2.47f, 2.47f);
        v0_1.lineToRelative(-2.47f, 2.47f);
        v0_1.lineToRelative(0.71f, 0.71f);
        v0_1.lineToRelative(2.47f, -2.47f);
        v0_1.lineToRelative(2.47f, 2.47f);
        v0_1.lineToRelative(0.71f, -0.71f);
        v0_1.lineToRelative(-2.47f, -2.47f);
        v0_1.lineToRelative(2.47f, -2.47f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SearchOffKt._searchOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

