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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_savedSearch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SavedSearch", "Landroidx/compose/material/icons/Icons$Rounded;", "getSavedSearch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SavedSearchKt {
    private static ImageVector _savedSearch;

    static {
    }

    public static final ImageVector getSavedSearch(Rounded arg19) {
        ImageVector v0 = SavedSearchKt._savedSearch;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SavedSearch", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.73f, 13.31f);
        v12.curveToRelative(1.13f, -1.55f, 1.63f, -3.58f, 0.98f, -5.74f);
        v12.curveToRelative(-0.68f, -2.23f, -2.57f, -3.98f, -4.85f, -4.44f);
        v12.curveTo(6.21f, 2.2f, 2.2f, 6.22f, 3.14f, 10.86f);
        v12.curveToRelative(0.46f, 2.29f, 2.21f, 4.18f, 4.44f, 4.85f);
        v12.curveToRelative(2.16f, 0.65f, 4.19f, 0.15f, 5.74f, -0.98f);
        v12.lineToRelative(5.56f, 5.56f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(14.73f, 13.31f);
        v12.close();
        v12.moveTo(9.5f, 14f);
        v12.curveTo(7.01f, 14f, 5f, 11.99f, 5f, 9.5f);
        v12.reflectiveCurveTo(7.01f, 5f, 9.5f, 5f);
        v12.reflectiveCurveTo(14f, 7.01f, 14f, 9.5f);
        v12.reflectiveCurveTo(11.99f, 14f, 9.5f, 14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(10.29f, 8.44f);
        v0_1.lineToRelative(-0.79f, -2.44f);
        v0_1.lineToRelative(-0.79f, 2.44f);
        v0_1.lineToRelative(-2.46f, 0f);
        v0_1.lineToRelative(2.01f, 1.59f);
        v0_1.lineToRelative(-0.77f, 2.47f);
        v0_1.lineToRelative(2.01f, -1.53f);
        v0_1.lineToRelative(2.01f, 1.53f);
        v0_1.lineToRelative(-0.77f, -2.47f);
        v0_1.lineToRelative(2.01f, -1.59f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SavedSearchKt._savedSearch = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

