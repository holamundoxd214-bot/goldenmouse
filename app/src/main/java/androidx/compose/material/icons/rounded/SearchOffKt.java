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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_searchOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SearchOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getSearchOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SearchOffKt {
    private static ImageVector _searchOff;

    static {
    }

    public static final ImageVector getSearchOff(Rounded arg19) {
        ImageVector v0 = SearchOffKt._searchOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SearchOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.5f, 14f);
        v12.horizontalLineToRelative(-0.79f);
        v12.lineToRelative(-0.28f, -0.27f);
        v12.curveToRelative(1.2f, -1.4f, 1.82f, -3.31f, 1.48f, -5.34f);
        v12.curveToRelative(-0.47f, -2.78f, -2.79f, -4.99f, -5.58f, -5.34f);
        v12.curveTo(6.54f, 2.58f, 3.3f, 5.38f, 3.03f, 9f);
        v12.horizontalLineToRelative(2.02f);
        v12.curveToRelative(0.24f, -2.12f, 1.92f, -3.8f, 4.06f, -3.98f);
        v12.curveTo(11.65f, 4.8f, 14f, 6.95f, 14f, 9.5f);
        v12.curveToRelative(0f, 2.49f, -2.01f, 4.5f, -4.5f, 4.5f);
        v12.curveToRelative(-0.17f, 0f, -0.33f, -0.03f, -0.5f, -0.05f);
        v12.lineToRelative(0f, 2.02f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0.01f, 0.01f);
        v12.curveToRelative(1.8f, 0.13f, 3.47f, -0.47f, 4.72f, -1.55f);
        v12.lineTo(14f, 14.71f);
        v12.verticalLineToRelative(0.79f);
        v12.lineToRelative(4.25f, 4.25f);
        v12.curveToRelative(0.41f, 0.41f, 1.08f, 0.41f, 1.49f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.41f, -0.41f, 0.41f, -1.08f, 0f, -1.49f);
        v12.lineTo(15.5f, 14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(6.12f, 11.17f);
        v12.lineTo(4f, 13.29f);
        v12.lineToRelative(-2.12f, -2.12f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.lineTo(3.29f, 14f);
        v12.lineToRelative(-2.12f, 2.12f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f);
        v12.lineTo(4f, 14.71f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f);
        v12.lineTo(4.71f, 14f);
        v12.lineToRelative(2.12f, -2.12f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(6.63f, 10.98f, 6.32f, 10.98f, 6.12f, 11.17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SearchOffKt._searchOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

