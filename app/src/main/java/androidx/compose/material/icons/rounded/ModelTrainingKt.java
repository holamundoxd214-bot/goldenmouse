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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_modelTraining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ModelTraining", "Landroidx/compose/material/icons/Icons$Rounded;", "getModelTraining", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ModelTrainingKt {
    private static ImageVector _modelTraining;

    static {
    }

    public static final ImageVector getModelTraining(Rounded arg19) {
        ImageVector v0 = ModelTrainingKt._modelTraining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ModelTraining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(19.5f);
        v12.close();
        v12.moveTo(19f, 13f);
        v12.curveToRelative(0f, 1.39f, -0.41f, 2.69f, -1.12f, 3.78f);
        v12.curveToRelative(-0.25f, 0.39f, -0.19f, 0.91f, 0.14f, 1.24f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.44f, 0.44f, 1.2f, 0.38f, 1.54f, -0.15f);
        v12.curveTo(20.469999f, 16.469999f, 21f, 14.8f, 21f, 13f);
        v12.curveToRelative(0f, -2.36f, -0.91f, -4.51f, -2.4f, -6.12f);
        v12.curveToRelative(-0.39f, -0.42f, -1.05f, -0.43f, -1.45f, -0.03f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.38f, 0.38f, -0.38f, 0.99f, -0.02f, 1.39f);
        v12.curveTo(18.290001f, 9.49f, 19f, 11.16f, 19f, 13f);
        v12.close();
        v12.moveTo(15.65f, 4.65f);
        v12.lineToRelative(-2.79f, -2.79f);
        v12.curveTo(12.54f, 1.54f, 12f, 1.76f, 12f, 2.21f);
        v12.verticalLineTo(4f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-4.97f, 0f, -9f, 4.03f, -9f, 9f);
        v12.curveToRelative(0f, 1.8f, 0.53f, 3.47f, 1.44f, 4.88f);
        v12.curveToRelative(0.34f, 0.53f, 1.1f, 0.59f, 1.54f, 0.15f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.33f, -0.33f, 0.39f, -0.84f, 0.14f, -1.23f);
        v12.curveTo(4.73f, 14.65f, 4.48f, 11.7f, 6.25f, 8.8f);
        v12.curveTo(7.45f, 6.85f, 9.71f, 5.81f, 12f, 6f);
        v12.lineToRelative(0f, 0f);
        v12.verticalLineToRelative(1.79f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        v12.lineToRelative(2.79f, -2.79f);
        v12.curveTo(15.84f, 5.16f, 15.84f, 4.84f, 15.65f, 4.65f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ModelTrainingKt._modelTraining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

