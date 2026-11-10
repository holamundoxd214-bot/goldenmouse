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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tableBar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TableBar", "Landroidx/compose/material/icons/Icons$Rounded;", "getTableBar", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TableBarKt {
    private static ImageVector _tableBar;

    static {
    }

    public static final ImageVector getTableBar(Rounded arg19) {
        ImageVector v0 = TableBarKt._tableBar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TableBar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 7.5f);
        v12.curveTo(22f, 5.57f, 17.52f, 4f, 12f, 4f);
        v12.reflectiveCurveTo(2f, 5.57f, 2f, 7.5f);
        v12.curveToRelative(0f, 1.81f, 3.95f, 3.31f, 9f, 3.48f);
        v12.verticalLineTo(15f);
        v12.horizontalLineTo(9.35f);
        v12.curveToRelative(-0.82f, 0f, -1.55f, 0.5f, -1.86f, 1.26f);
        v12.lineToRelative(-0.99f, 2.47f);
        v12.curveTo(6.27f, 19.34f, 6.71f, 20f, 7.37f, 20f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.38f, 0f, 0.72f, -0.23f, 0.86f, -0.58f);
        v12.lineTo(9.2f, 17f);
        v12.horizontalLineToRelative(5.6f);
        v12.lineToRelative(0.97f, 2.42f);
        v12.curveToRelative(0.14f, 0.35f, 0.48f, 0.58f, 0.86f, 0.58f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.66f, 0f, 1.11f, -0.66f, 0.86f, -1.27f);
        v12.lineToRelative(-0.99f, -2.47f);
        v12.curveTo(16.200001f, 15.5f, 15.46f, 15f, 14.65f, 15f);
        v12.horizontalLineTo(13f);
        v12.verticalLineToRelative(-4.02f);
        v12.curveTo(18.049999f, 10.81f, 22f, 9.31f, 22f, 7.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TableBarKt._tableBar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

