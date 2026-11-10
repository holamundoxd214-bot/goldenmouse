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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_paid", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Paid", "Landroidx/compose/material/icons/Icons$Rounded;", "getPaid", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PaidKt {
    private static ImageVector _paid;

    static {
    }

    public static final ImageVector getPaid(Rounded arg19) {
        ImageVector v0 = PaidKt._paid;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Paid", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12.88f, 17.76f);
        v12.verticalLineToRelative(0.36f);
        v12.curveToRelative(0f, 0.48f, -0.39f, 0.88f, -0.88f, 0.88f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.48f, 0f, -0.88f, -0.39f, -0.88f, -0.88f);
        v12.verticalLineToRelative(-0.42f);
        v12.curveToRelative(-0.63f, -0.15f, -1.93f, -0.61f, -2.69f, -2.1f);
        v12.curveToRelative(-0.23f, -0.44f, -0.01f, -0.99f, 0.45f, -1.18f);
        v12.lineToRelative(0.07f, -0.03f);
        v12.curveToRelative(0.41f, -0.17f, 0.87f, 0f, 1.08f, 0.39f);
        v12.curveToRelative(0.32f, 0.61f, 0.95f, 1.37f, 2.12f, 1.37f);
        v12.curveToRelative(0.93f, 0f, 1.98f, -0.48f, 1.98f, -1.61f);
        v12.curveToRelative(0f, -0.96f, -0.7f, -1.46f, -2.28f, -2.03f);
        v12.curveToRelative(-1.1f, -0.39f, -3.35f, -1.03f, -3.35f, -3.31f);
        v12.curveToRelative(0f, -0.1f, 0.01f, -2.4f, 2.62f, -2.96f);
        v12.verticalLineTo(5.88f);
        v12.curveTo(11.12f, 5.39f, 11.52f, 5f, 12f, 5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.48f, 0f, 0.88f, 0.39f, 0.88f, 0.88f);
        v12.verticalLineToRelative(0.37f);
        v12.curveToRelative(1.07f, 0.19f, 1.75f, 0.76f, 2.16f, 1.3f);
        v12.curveToRelative(0.34f, 0.44f, 0.16f, 1.08f, -0.36f, 1.3f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(14.32f, 9f, 13.9f, 8.88f, 13.66f, 8.57f);
        v12.curveToRelative(-0.28f, -0.38f, -0.78f, -0.77f, -1.6f, -0.77f);
        v12.curveToRelative(-0.7f, 0f, -1.81f, 0.37f, -1.81f, 1.39f);
        v12.curveToRelative(0f, 0.95f, 0.86f, 1.31f, 2.64f, 1.9f);
        v12.curveToRelative(2.4f, 0.83f, 3.01f, 2.05f, 3.01f, 3.45f);
        v12.curveTo(15.9f, 17.17f, 13.4f, 17.67f, 12.88f, 17.76f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PaidKt._paid = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

