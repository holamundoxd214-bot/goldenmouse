package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sledding", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sledding", "Landroidx/compose/material/icons/Icons$Outlined;", "getSledding", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SleddingKt {
    private static ImageVector _sledding;

    static {
    }

    public static final ImageVector getSledding(Outlined arg19) {
        ImageVector v0 = SleddingKt._sledding;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Sledding", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 4.5f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveTo(14f, 3.4f, 14f, 4.5f);
        v12.close();
        v12.moveTo(22.799999f, 20.24f);
        v12.curveToRelative(-0.68f, 2.1f, -2.94f, 3.25f, -5.04f, 2.57f);
        v12.horizontalLineToRelative(0f);
        v12.lineTo(1f, 17.360001f);
        v12.lineToRelative(0.46f, -1.43f);
        v12.lineToRelative(3.93f, 1.28f);
        v12.lineToRelative(0.46f, -1.43f);
        v12.lineTo(1.93f, 14.5f);
        v12.lineToRelative(0.46f, -1.43f);
        v12.lineTo(4f, 13.6f);
        v12.verticalLineTo(9.5f);
        v12.lineToRelative(5.47f, -2.35f);
        v12.curveToRelative(0.39f, -0.17f, 0.84f, -0.21f, 1.28f, -0.07f);
        v12.curveToRelative(0.95f, 0.31f, 1.46f, 1.32f, 1.16f, 2.27f);
        v12.lineToRelative(-1.05f, 3.24f);
        v12.lineTo(13f, 12.25f);
        v12.curveToRelative(0.89f, -0.15f, 1.76f, 0.32f, 2.14f, 1.14f);
        v12.lineToRelative(2.08f, 4.51f);
        v12.lineToRelative(1.93f, 0.63f);
        v12.lineToRelative(-0.46f, 1.43f);
        v12.lineToRelative(-3.32f, -1.08f);
        v12.lineTo(14.9f, 20.299999f);
        v12.lineToRelative(3.32f, 1.08f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(1.31f, 0.43f, 2.72f, -0.29f, 3.15f, -1.61f);
        v12.curveToRelative(0.43f, -1.31f, -0.29f, -2.72f, -1.61f, -3.15f);
        v12.lineToRelative(0.46f, -1.43f);
        v12.curveTo(22.33f, 15.88f, 23.49f, 18.139999f, 22.799999f, 20.24f);
        v12.close();
        v12.moveTo(6f, 14.25f);
        v12.lineToRelative(1.01f, 0.33f);
        v12.curveToRelative(-0.22f, -0.42f, -0.28f, -0.92f, -0.12f, -1.4f);
        v12.lineTo(7.92f, 10f);
        v12.lineTo(6f, 10.82f);
        v12.verticalLineTo(14.25f);
        v12.close();
        v12.moveTo(13.94f, 18.41f);
        v12.lineToRelative(-6.66f, -2.16f);
        v12.lineToRelative(-0.46f, 1.43f);
        v12.lineToRelative(6.66f, 2.16f);
        v12.lineTo(13.94f, 18.41f);
        v12.close();
        v12.moveTo(14.63f, 17.049999f);
        v12.lineToRelative(-1.18f, -2.56f);
        v12.lineToRelative(-3.97f, 0.89f);
        v12.lineTo(14.63f, 17.049999f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SleddingKt._sledding = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

