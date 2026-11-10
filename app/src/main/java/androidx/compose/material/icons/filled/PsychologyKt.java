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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_psychology", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Psychology", "Landroidx/compose/material/icons/Icons$Filled;", "getPsychology", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PsychologyKt {
    private static ImageVector _psychology;

    static {
    }

    public static final ImageVector getPsychology(Filled arg19) {
        ImageVector v0 = PsychologyKt._psychology;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Psychology", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 8.57f);
        v12.curveToRelative(-0.79f, 0f, -1.43f, 0.64f, -1.43f, 1.43f);
        v12.reflectiveCurveToRelative(0.64f, 1.43f, 1.43f, 1.43f);
        v12.reflectiveCurveToRelative(1.43f, -0.64f, 1.43f, -1.43f);
        v12.reflectiveCurveTo(13.79f, 8.57f, 13f, 8.57f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(13f, 3f);
        v12.curveTo(9.25f, 3f, 6.2f, 5.94f, 6.02f, 9.64f);
        v12.lineTo(4.1f, 12.2f);
        v12.curveTo(3.85f, 12.53f, 4.09f, 13f, 4.5f, 13f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(-4.68f);
        v12.curveToRelative(2.36f, -1.12f, 4f, -3.53f, 4f, -6.32f);
        v12.curveTo(20f, 6.13f, 16.870001f, 3f, 13f, 3f);
        v12.close();
        v12.moveTo(16f, 10f);
        v12.curveToRelative(0f, 0.13f, -0.01f, 0.26f, -0.02f, 0.39f);
        v12.lineToRelative(0.83f, 0.66f);
        v12.curveToRelative(0.08f, 0.06f, 0.1f, 0.16f, 0.05f, 0.25f);
        v12.lineToRelative(-0.8f, 1.39f);
        v12.curveToRelative(-0.05f, 0.09f, -0.16f, 0.12f, -0.24f, 0.09f);
        v12.lineToRelative(-0.99f, -0.4f);
        v12.curveToRelative(-0.21f, 0.16f, -0.43f, 0.29f, -0.67f, 0.39f);
        v12.lineTo(14f, 13.83f);
        v12.curveToRelative(-0.01f, 0.1f, -0.1f, 0.17f, -0.2f, 0.17f);
        v12.horizontalLineToRelative(-1.6f);
        v12.curveToRelative(-0.1f, 0f, -0.18f, -0.07f, -0.2f, -0.17f);
        v12.lineToRelative(-0.15f, -1.06f);
        v12.curveToRelative(-0.25f, -0.1f, -0.47f, -0.23f, -0.68f, -0.39f);
        v12.lineToRelative(-0.99f, 0.4f);
        v12.curveToRelative(-0.09f, 0.03f, -0.2f, 0f, -0.25f, -0.09f);
        v12.lineToRelative(-0.8f, -1.39f);
        v12.curveToRelative(-0.05f, -0.08f, -0.03f, -0.19f, 0.05f, -0.25f);
        v12.lineToRelative(0.84f, -0.66f);
        v12.curveTo(10.01f, 10.26f, 10f, 10.13f, 10f, 10f);
        v12.curveToRelative(0f, -0.13f, 0.02f, -0.27f, 0.04f, -0.39f);
        v12.lineTo(9.19f, 8.95f);
        v12.curveToRelative(-0.08f, -0.06f, -0.1f, -0.16f, -0.05f, -0.26f);
        v12.lineToRelative(0.8f, -1.38f);
        v12.curveToRelative(0.05f, -0.09f, 0.15f, -0.12f, 0.24f, -0.09f);
        v12.lineToRelative(1f, 0.4f);
        v12.curveToRelative(0.2f, -0.15f, 0.43f, -0.29f, 0.67f, -0.39f);
        v12.lineToRelative(0.15f, -1.06f);
        v12.curveTo(12.02f, 6.07f, 12.1f, 6f, 12.2f, 6f);
        v12.horizontalLineToRelative(1.6f);
        v12.curveToRelative(0.1f, 0f, 0.18f, 0.07f, 0.2f, 0.17f);
        v12.lineToRelative(0.15f, 1.06f);
        v12.curveToRelative(0.24f, 0.1f, 0.46f, 0.23f, 0.67f, 0.39f);
        v12.lineToRelative(1f, -0.4f);
        v12.curveToRelative(0.09f, -0.03f, 0.2f, 0f, 0.24f, 0.09f);
        v12.lineToRelative(0.8f, 1.38f);
        v12.curveToRelative(0.05f, 0.09f, 0.03f, 0.2f, -0.05f, 0.26f);
        v12.lineToRelative(-0.85f, 0.66f);
        v12.curveTo(15.99f, 9.73f, 16f, 9.86f, 16f, 10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PsychologyKt._psychology = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

