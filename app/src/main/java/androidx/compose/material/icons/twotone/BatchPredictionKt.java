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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_batchPrediction", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BatchPrediction", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBatchPrediction", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BatchPredictionKt {
    private static ImageVector _batchPrediction;

    static {
    }

    public static final ImageVector getBatchPrediction(TwoTone arg19) {
        ImageVector v0 = BatchPredictionKt._batchPrediction;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.BatchPrediction", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 20.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(19f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(20.5f);
        v12.close();
        v12.moveTo(13f, 18f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0f, -1.5f, -2.5f, -3f, -2.5f, -5f);
        v12.curveToRelative(0f, -1.93f, 1.57f, -3.5f, 3.5f, -3.5f);
        v12.curveToRelative(1.93f, 0f, 3.5f, 1.57f, 3.5f, 3.5f);
        v12.curveTo(15.5f, 15f, 13f, 16.5f, 13f, 18f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 8f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(10f);
        v12.curveTo(19f, 8.9f, 18.1f, 8f, 17f, 8f);
        v12.close();
        v12.moveTo(13f, 20.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(19f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(20.5f);
        v12.close();
        v12.moveTo(13f, 18f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0f, -1.5f, -2.5f, -3f, -2.5f, -5f);
        v12.curveToRelative(0f, -1.93f, 1.57f, -3.5f, 3.5f, -3.5f);
        v12.curveToRelative(1.93f, 0f, 3.5f, 1.57f, 3.5f, 3.5f);
        v12.curveTo(15.5f, 15f, 13f, 16.5f, 13f, 18f);
        v12.close();
        v12.moveTo(18f, 6.5f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(6f, 5.67f, 6.67f, 5f, 7.5f, 5f);
        v12.horizontalLineToRelative(9f);
        v12.curveTo(17.33f, 5f, 18f, 5.67f, 18f, 6.5f);
        v12.lineTo(18f, 6.5f);
        v12.close();
        v12.moveTo(17f, 3.5f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(7f, 2.67f, 7.67f, 2f, 8.5f, 2f);
        v12.horizontalLineToRelative(7f);
        v12.curveTo(16.33f, 2f, 17f, 2.67f, 17f, 3.5f);
        v12.lineTo(17f, 3.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BatchPredictionKt._batchPrediction = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

