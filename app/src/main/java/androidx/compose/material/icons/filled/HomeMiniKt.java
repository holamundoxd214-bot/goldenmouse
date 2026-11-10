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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_homeMini", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HomeMini", "Landroidx/compose/material/icons/Icons$Filled;", "getHomeMini", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HomeMiniKt {
    private static ImageVector _homeMini;

    static {
    }

    public static final ImageVector getHomeMini(Filled arg19) {
        ImageVector v0 = HomeMiniKt._homeMini;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.HomeMini", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 5f);
        v12.curveTo(4.19f, 5f, 2f, 9.48f, 2f, 12f);
        v12.curveToRelative(0f, 3.86f, 3.13f, 7f, 6.99f, 7f);
        v12.horizontalLineToRelative(6.02f);
        v12.curveToRelative(2.69f, 0f, 6.99f, -2.08f, 6.99f, -7f);
        v12.curveTo(22f, 12f, 22f, 5f, 12f, 5f);
        v12.close();
        v12.moveTo(12f, 7f);
        v12.curveToRelative(7.64f, 0f, 7.99f, 4.51f, 8f, 5f);
        v12.horizontalLineTo(4f);
        v12.curveTo(4f, 11.8f, 4.09f, 7f, 12f, 7f);
        v12.close();
        v12.moveTo(14.86f, 17f);
        v12.horizontalLineTo(9.14f);
        v12.curveToRelative(-2.1f, 0f, -3.92f, -1.24f, -4.71f, -3f);
        v12.horizontalLineToRelative(15.15f);
        v12.curveTo(18.780001f, 15.76f, 16.959999f, 17f, 14.86f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HomeMiniKt._homeMini = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

