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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cropRotate", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CropRotate", "Landroidx/compose/material/icons/Icons$Rounded;", "getCropRotate", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CropRotateKt {
    private static ImageVector _cropRotate;

    static {
    }

    public static final ImageVector getCropRotate(Rounded arg19) {
        ImageVector v0 = CropRotateKt._cropRotate;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CropRotate", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 9f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(18f, 8f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(5f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.close();
        v12.moveTo(19f, 16f);
        v12.lineTo(9f, 16f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.lineTo(8f, 5f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.lineTo(5f, 6f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(17.66f, 1.4f);
        v12.curveTo(15.99f, 0.51f, 13.83f, -0.11f, 11.39f, 0.04f);
        v12.lineToRelative(3.81f, 3.81f);
        v12.lineToRelative(1.33f, -1.33f);
        v12.curveToRelative(3.09f, 1.46f, 5.34f, 4.37f, 5.89f, 7.86f);
        v12.curveToRelative(0.06f, 0.41f, 0.44f, 0.69f, 0.86f, 0.62f);
        v12.curveToRelative(0.41f, -0.06f, 0.69f, -0.45f, 0.62f, -0.86f);
        v12.curveToRelative(-0.6f, -3.8f, -2.96f, -7f, -6.24f, -8.74f);
        v12.close();
        v12.moveTo(7.47f, 21.49f);
        v12.curveToRelative(-3.09f, -1.46f, -5.34f, -4.37f, -5.89f, -7.86f);
        v12.curveToRelative(-0.06f, -0.41f, -0.44f, -0.69f, -0.86f, -0.62f);
        v12.curveToRelative(-0.41f, 0.06f, -0.69f, 0.45f, -0.62f, 0.86f);
        v12.curveToRelative(0.6f, 3.81f, 2.96f, 7.01f, 6.24f, 8.75f);
        v12.curveToRelative(1.67f, 0.89f, 3.83f, 1.51f, 6.27f, 1.36f);
        v12.lineTo(8.8f, 20.16f);
        v12.lineToRelative(-1.33f, 1.33f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CropRotateKt._cropRotate = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

