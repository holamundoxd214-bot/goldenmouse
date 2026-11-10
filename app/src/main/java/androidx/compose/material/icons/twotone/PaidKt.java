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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_paid", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Paid", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPaid", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PaidKt {
    private static ImageVector _paid;

    static {
    }

    public static final ImageVector getPaid(TwoTone arg19) {
        ImageVector v0 = PaidKt._paid;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Paid", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(-4.41f, 0f, -8f, 3.59f, -8f, 8f);
        v12.curveToRelative(0f, 4.41f, 3.59f, 8f, 8f, 8f);
        v12.reflectiveCurveToRelative(8f, -3.59f, 8f, -8f);
        v12.curveTo(20f, 7.59f, 16.41f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(12.88f, 17.76f);
        v12.verticalLineTo(19f);
        v12.horizontalLineToRelative(-1.75f);
        v12.verticalLineToRelative(-1.29f);
        v12.curveToRelative(-0.74f, -0.18f, -2.39f, -0.77f, -3.02f, -2.96f);
        v12.lineToRelative(1.65f, -0.67f);
        v12.curveToRelative(0.06f, 0.22f, 0.58f, 2.09f, 2.4f, 2.09f);
        v12.curveToRelative(0.93f, 0f, 1.98f, -0.48f, 1.98f, -1.61f);
        v12.curveToRelative(0f, -0.96f, -0.7f, -1.46f, -2.28f, -2.03f);
        v12.curveToRelative(-1.1f, -0.39f, -3.35f, -1.03f, -3.35f, -3.31f);
        v12.curveToRelative(0f, -0.1f, 0.01f, -2.4f, 2.62f, -2.96f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(1.75f);
        v12.verticalLineToRelative(1.24f);
        v12.curveToRelative(1.84f, 0.32f, 2.51f, 1.79f, 2.66f, 2.23f);
        v12.lineToRelative(-1.58f, 0.67f);
        v12.curveToRelative(-0.11f, -0.35f, -0.59f, -1.34f, -1.9f, -1.34f);
        v12.curveToRelative(-0.7f, 0f, -1.81f, 0.37f, -1.81f, 1.39f);
        v12.curveToRelative(0f, 0.95f, 0.86f, 1.31f, 2.64f, 1.9f);
        v12.curveToRelative(2.4f, 0.83f, 3.01f, 2.05f, 3.01f, 3.45f);
        v12.curveTo(15.9f, 17.17f, 13.4f, 17.67f, 12.88f, 17.76f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.89f, 11.1f);
        v12.curveToRelative(-1.78f, -0.59f, -2.64f, -0.96f, -2.64f, -1.9f);
        v12.curveToRelative(0f, -1.02f, 1.11f, -1.39f, 1.81f, -1.39f);
        v12.curveToRelative(1.31f, 0f, 1.79f, 0.99f, 1.9f, 1.34f);
        v12.lineToRelative(1.58f, -0.67f);
        v12.curveToRelative(-0.15f, -0.44f, -0.82f, -1.91f, -2.66f, -2.23f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(-1.75f);
        v12.verticalLineToRelative(1.26f);
        v12.curveToRelative(-2.6f, 0.56f, -2.62f, 2.85f, -2.62f, 2.96f);
        v12.curveToRelative(0f, 2.27f, 2.25f, 2.91f, 3.35f, 3.31f);
        v12.curveToRelative(1.58f, 0.56f, 2.28f, 1.07f, 2.28f, 2.03f);
        v12.curveToRelative(0f, 1.13f, -1.05f, 1.61f, -1.98f, 1.61f);
        v12.curveToRelative(-1.82f, 0f, -2.34f, -1.87f, -2.4f, -2.09f);
        v12.lineTo(8.1f, 14.75f);
        v12.curveToRelative(0.63f, 2.19f, 2.28f, 2.78f, 3.02f, 2.96f);
        v12.verticalLineTo(19f);
        v12.horizontalLineToRelative(1.75f);
        v12.verticalLineToRelative(-1.24f);
        v12.curveToRelative(0.52f, -0.09f, 3.02f, -0.59f, 3.02f, -3.22f);
        v12.curveTo(15.9f, 13.15f, 15.29f, 11.93f, 12.89f, 11.1f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.41f, 0f, -8f, -3.59f, -8f, -8f);
        v12.curveToRelative(0f, -4.41f, 3.59f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.59f, 8f, 8f);
        v12.curveTo(20f, 16.41f, 16.41f, 20f, 12f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PaidKt._paid = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

