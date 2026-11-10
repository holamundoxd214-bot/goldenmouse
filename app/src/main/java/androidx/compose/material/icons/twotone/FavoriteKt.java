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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_favorite", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Favorite", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFavorite", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FavoriteKt {
    private static ImageVector _favorite;

    static {
    }

    public static final ImageVector getFavorite(TwoTone arg19) {
        ImageVector v0 = FavoriteKt._favorite;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Favorite", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.5f, 5f);
        v12.curveToRelative(-1.54f, 0f, -3.04f, 0.99f, -3.56f, 2.36f);
        v12.horizontalLineToRelative(-1.87f);
        v12.curveTo(10.54f, 5.99f, 9.04f, 5f, 7.5f, 5f);
        v12.curveTo(5.5f, 5f, 4f, 6.5f, 4f, 8.5f);
        v12.curveToRelative(0f, 2.89f, 3.14f, 5.74f, 7.9f, 10.05f);
        v12.lineToRelative(0.1f, 0.1f);
        v12.lineToRelative(0.1f, -0.1f);
        v12.curveTo(16.860001f, 14.24f, 20f, 11.39f, 20f, 8.5f);
        v12.curveToRelative(0f, -2f, -1.5f, -3.5f, -3.5f, -3.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.5f, 3f);
        v12.curveToRelative(-1.74f, 0f, -3.41f, 0.81f, -4.5f, 2.09f);
        v12.curveTo(10.91f, 3.81f, 9.24f, 3f, 7.5f, 3f);
        v12.curveTo(4.42f, 3f, 2f, 5.42f, 2f, 8.5f);
        v12.curveToRelative(0f, 3.78f, 3.4f, 6.86f, 8.55f, 11.54f);
        v12.lineTo(12f, 21.35f);
        v12.lineToRelative(1.45f, -1.32f);
        v12.curveTo(18.6f, 15.36f, 22f, 12.28f, 22f, 8.5f);
        v12.curveTo(22f, 5.42f, 19.58f, 3f, 16.5f, 3f);
        v12.close();
        v12.moveTo(12.1f, 18.549999f);
        v12.lineToRelative(-0.1f, 0.1f);
        v12.lineToRelative(-0.1f, -0.1f);
        v12.curveTo(7.14f, 14.24f, 4f, 11.39f, 4f, 8.5f);
        v12.curveTo(4f, 6.5f, 5.5f, 5f, 7.5f, 5f);
        v12.curveToRelative(1.54f, 0f, 3.04f, 0.99f, 3.57f, 2.36f);
        v12.horizontalLineToRelative(1.87f);
        v12.curveTo(13.46f, 5.99f, 14.96f, 5f, 16.5f, 5f);
        v12.curveToRelative(2f, 0f, 3.5f, 1.5f, 3.5f, 3.5f);
        v12.curveToRelative(0f, 2.89f, -3.14f, 5.74f, -7.9f, 10.05f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FavoriteKt._favorite = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

