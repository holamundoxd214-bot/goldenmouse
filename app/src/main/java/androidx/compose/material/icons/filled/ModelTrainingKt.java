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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_modelTraining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ModelTraining", "Landroidx/compose/material/icons/Icons$Filled;", "getModelTraining", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ModelTrainingKt {
    private static ImageVector _modelTraining;

    static {
    }

    public static final ImageVector getModelTraining(Filled arg19) {
        ImageVector v0 = ModelTrainingKt._modelTraining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ModelTraining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.5f, 13.5f);
        v12.curveToRelative(0f, 2f, -2.5f, 3.5f, -2.5f, 5f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0f, -1.5f, -2.5f, -3f, -2.5f, -5f);
        v12.curveToRelative(0f, -1.93f, 1.57f, -3.5f, 3.5f, -3.5f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(13.93f, 10f, 15.5f, 11.57f, 15.5f, 13.5f);
        v12.close();
        v12.moveTo(13f, 19.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(19.5f);
        v12.close();
        v12.moveTo(19f, 13f);
        v12.curveToRelative(0f, 1.68f, -0.59f, 3.21f, -1.58f, 4.42f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(20.18f, 17.27f, 21f, 15.23f, 21f, 13f);
        v12.curveToRelative(0f, -2.74f, -1.23f, -5.19f, -3.16f, -6.84f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.curveTo(17.99f, 8.86f, 19f, 10.82f, 19f, 13f);
        v12.close();
        v12.moveTo(16f, 5f);
        v12.lineToRelative(-4f, -4f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.curveToRelative(-4.97f, 0f, -9f, 4.03f, -9f, 9f);
        v12.curveToRelative(0f, 2.23f, 0.82f, 4.27f, 2.16f, 5.84f);
        v12.lineToRelative(1.42f, -1.42f);
        v12.curveTo(5.59f, 16.209999f, 5f, 14.68f, 5f, 13f);
        v12.curveToRelative(0f, -3.86f, 3.14f, -7f, 7f, -7f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(16f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ModelTrainingKt._modelTraining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

