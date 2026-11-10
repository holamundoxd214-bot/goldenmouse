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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_compost", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Compost", "Landroidx/compose/material/icons/Icons$Outlined;", "getCompost", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CompostKt {
    private static ImageVector _compost;

    static {
    }

    public static final ImageVector getCompost(Outlined arg19) {
        ImageVector v0 = CompostKt._compost;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Compost", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.87f, 11.81f);
        v12.curveToRelative(-0.23f, -0.38f, -0.37f, -0.83f, -0.37f, -1.31f);
        v12.curveTo(12.5f, 9.12f, 13.62f, 8f, 15f, 8f);
        v12.lineToRelative(1f, 0f);
        v12.curveToRelative(1.51f, 0f, 2f, -1f, 2f, -1f);
        v12.reflectiveCurveToRelative(0.55f, 6f, -3f, 6f);
        v12.curveToRelative(-0.49f, 0f, -0.94f, -0.14f, -1.32f, -0.38f);
        v12.curveToRelative(-0.24f, 0.64f, -0.59f, 1.76f, -0.76f, 2.96f);
        v12.curveToRelative(1.26f, 0.22f, 2.28f, 0.89f, 2.77f, 1.77f);
        v12.curveToRelative(1.69f, -1.17f, 2.81f, -3.13f, 2.81f, -5.35f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0f, 5.24f, -4.26f, 9.5f, -9.5f, 9.5f);
        v12.reflectiveCurveTo(2.5f, 17.24f, 2.5f, 12f);
        v12.reflectiveCurveTo(6.76f, 2.5f, 12f, 2.5f);
        v12.verticalLineTo(0f);
        v12.lineToRelative(4f, 4f);
        v12.lineToRelative(-4f, 4f);
        v12.verticalLineTo(5.5f);
        v12.curveToRelative(-3.58f, 0f, -6.5f, 2.92f, -6.5f, 6.5f);
        v12.curveToRelative(0f, 2.21f, 1.11f, 4.17f, 2.81f, 5.35f);
        v12.curveToRelative(0.51f, -0.92f, 1.63f, -1.62f, 2.98f, -1.8f);
        v12.curveToRelative(-0.09f, -0.69f, -0.26f, -1.42f, -0.49f, -2.03f);
        v12.curveTo(10.45f, 13.82f, 10f, 14f, 9.5f, 14f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineToRelative(-0.99f);
        v12.curveToRelative(0f, -0.56f, -0.19f, -1.09f, -0.5f, -1.51f);
        v12.curveToRelative(0f, 0f, 4.45f, -0.23f, 4.5f, 2.5f);
        v12.curveToRelative(0f, 0.29f, -0.06f, 0.56f, -0.17f, 0.8f);
        v12.curveTo(10.91f, 12.48f, 10.47f, 12.2f, 10f, 12f);
        v12.curveToRelative(0.58f, 0.43f, 1.37f, 1.37f, 2f, 2.6f);
        v12.curveToRelative(0.67f, -1.62f, 1.68f, -3.27f, 3f, -4.6f);
        v12.curveTo(14.24f, 10.52f, 13.53f, 11.12f, 12.87f, 11.81f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CompostKt._compost = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

