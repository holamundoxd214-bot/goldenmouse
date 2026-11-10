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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cropOriginal", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CropOriginal", "Landroidx/compose/material/icons/Icons$Rounded;", "getCropOriginal", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CropOriginalKt {
    private static ImageVector _cropOriginal;

    static {
    }

    public static final ImageVector getCropOriginal(Rounded arg19) {
        ImageVector v0 = CropOriginalKt._cropOriginal;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CropOriginal", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.lineTo(5f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(21f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(18f, 19f);
        v12.lineTo(6f, 19f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.lineTo(5f, 6f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.close();
        v12.moveTo(13.56f, 12.81f);
        v12.lineToRelative(-2.35f, 3.02f);
        v12.lineToRelative(-1.56f, -1.88f);
        v12.curveToRelative(-0.2f, -0.25f, -0.58f, -0.24f, -0.78f, 0.01f);
        v12.lineToRelative(-1.74f, 2.23f);
        v12.curveToRelative(-0.26f, 0.33f, -0.02f, 0.81f, 0.39f, 0.81f);
        v12.horizontalLineToRelative(8.98f);
        v12.curveToRelative(0.41f, 0f, 0.65f, -0.47f, 0.4f, -0.8f);
        v12.lineToRelative(-2.55f, -3.39f);
        v12.curveToRelative(-0.19f, -0.26f, -0.59f, -0.26f, -0.79f, 0f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CropOriginalKt._cropOriginal = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

