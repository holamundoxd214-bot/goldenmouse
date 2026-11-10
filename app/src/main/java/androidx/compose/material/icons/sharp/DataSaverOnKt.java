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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dataSaverOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DataSaverOn", "Landroidx/compose/material/icons/Icons$Sharp;", "getDataSaverOn", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DataSaverOnKt {
    private static ImageVector _dataSaverOn;

    static {
    }

    public static final ImageVector getDataSaverOn(Sharp arg19) {
        ImageVector v0 = DataSaverOnKt._dataSaverOn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.DataSaverOn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 8f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(8f);
        v12.horizontalLineTo(11f);
        v12.close();
        v12.moveTo(13f, 2.05f);
        v12.verticalLineToRelative(3.03f);
        v12.curveToRelative(3.39f, 0.49f, 6f, 3.39f, 6f, 6.92f);
        v12.curveToRelative(0f, 0.9f, -0.18f, 1.75f, -0.48f, 2.54f);
        v12.lineToRelative(2.6f, 1.53f);
        v12.curveTo(21.68f, 14.83f, 22f, 13.45f, 22f, 12f);
        v12.curveTo(22f, 6.82f, 18.049999f, 2.55f, 13f, 2.05f);
        v12.close();
        v12.moveTo(12f, 19f);
        v12.curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f);
        v12.curveToRelative(0f, -3.53f, 2.61f, -6.43f, 6f, -6.92f);
        v12.verticalLineTo(2.05f);
        v12.curveTo(5.94f, 2.55f, 2f, 6.81f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.47f, 10f, 9.99f, 10f);
        v12.curveToRelative(3.31f, 0f, 6.24f, -1.61f, 8.06f, -4.09f);
        v12.lineToRelative(-2.6f, -1.53f);
        v12.curveTo(16.17f, 17.98f, 14.21f, 19f, 12f, 19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DataSaverOnKt._dataSaverOn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

