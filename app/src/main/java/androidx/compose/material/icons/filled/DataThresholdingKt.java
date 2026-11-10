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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dataThresholding", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DataThresholding", "Landroidx/compose/material/icons/Icons$Filled;", "getDataThresholding", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DataThresholdingKt {
    private static ImageVector _dataThresholding;

    static {
    }

    public static final ImageVector getDataThresholding(Filled arg19) {
        ImageVector v0 = DataThresholdingKt._dataThresholding;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.DataThresholding", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(21f, 3.9f, 20.1f, 3f, 19f, 3f);
        v12.close();
        v12.moveTo(10.67f, 8.17f);
        v12.lineToRelative(2f, 2f);
        v12.lineToRelative(3.67f, -3.67f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineTo(12.67f, 13f);
        v12.lineToRelative(-2f, -2f);
        v12.lineToRelative(-3f, 3f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineTo(10.67f, 8.17f);
        v12.close();
        v12.moveTo(5f, 16f);
        v12.horizontalLineToRelative(1.72f);
        v12.lineTo(5f, 17.719999f);
        v12.verticalLineTo(16f);
        v12.close();
        v12.moveTo(5.84f, 19f);
        v12.lineToRelative(3f, -3f);
        v12.horizontalLineToRelative(1.83f);
        v12.lineToRelative(-3f, 3f);
        v12.horizontalLineTo(5.84f);
        v12.close();
        v12.moveTo(9.8f, 19f);
        v12.lineToRelative(3f, -3f);
        v12.horizontalLineToRelative(1.62f);
        v12.lineToRelative(-3f, 3f);
        v12.horizontalLineTo(9.8f);
        v12.close();
        v12.moveTo(13.53f, 19f);
        v12.lineToRelative(3f, -3f);
        v12.horizontalLineToRelative(1.62f);
        v12.lineToRelative(-3f, 3f);
        v12.horizontalLineTo(13.53f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.horizontalLineToRelative(-1.73f);
        v12.lineTo(19f, 17.27f);
        v12.verticalLineTo(19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DataThresholdingKt._dataThresholding = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

