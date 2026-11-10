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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_masks", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Masks", "Landroidx/compose/material/icons/Icons$TwoTone;", "getMasks", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MasksKt {
    private static ImageVector _masks;

    static {
    }

    public static final ImageVector getMasks(TwoTone arg19) {
        ImageVector v0 = MasksKt._masks;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Masks", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.34f, 8.78f);
        v12.curveTo(13.52f, 8.33f, 12.93f, 8f, 12f, 8f);
        v12.curveToRelative(-0.93f, 0f, -1.52f, 0.33f, -2.34f, 0.77f);
        v12.curveTo(8.95f, 9.16f, 8.12f, 9.62f, 7f, 9.85f);
        v12.verticalLineToRelative(1.65f);
        v12.curveToRelative(0f, 2.76f, 2.24f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.24f, 5f, -5f);
        v12.verticalLineTo(9.85f);
        v12.curveTo(15.88f, 9.62f, 15.05f, 9.16f, 14.34f, 8.78f);
        v12.close();
        v12.moveTo(15f, 11.25f);
        v12.curveToRelative(-0.75f, -0.21f, -1.26f, -0.51f, -1.71f, -0.78f);
        v12.curveTo(12.83f, 10.2f, 12.49f, 10f, 12f, 10f);
        v12.curveToRelative(-0.49f, 0f, -0.84f, 0.2f, -1.31f, 0.48f);
        v12.curveToRelative(-0.44f, 0.26f, -0.96f, 0.56f, -1.69f, 0.76f);
        v12.verticalLineTo(10.2f);
        v12.curveToRelative(0.48f, -0.17f, 0.84f, -0.38f, 1.18f, -0.58f);
        v12.curveTo(10.72f, 9.3f, 11.23f, 9f, 12f, 9f);
        v12.reflectiveCurveToRelative(1.27f, 0.3f, 1.8f, 0.62f);
        v12.curveToRelative(0.34f, 0.2f, 0.71f, 0.42f, 1.2f, 0.59f);
        v12.verticalLineTo(11.25f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.5f, 6f);
        v12.curveToRelative(-1.31f, 0f, -2.37f, 1.01f, -2.48f, 2.3f);
        v12.curveTo(15.14f, 7.8f, 14.18f, 6.5f, 12f, 6.5f);
        v12.curveToRelative(-2.19f, 0f, -3.14f, 1.3f, -5.02f, 1.8f);
        v12.curveTo(6.87f, 7.02f, 5.81f, 6f, 4.5f, 6f);
        v12.curveTo(3.12f, 6f, 2f, 7.12f, 2f, 8.5f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, 6f, 3.6f, 7.81f, 6.52f, 7.98f);
        v12.curveTo(9.53f, 17.620001f, 10.72f, 18f, 12f, 18f);
        v12.reflectiveCurveToRelative(2.47f, -0.38f, 3.48f, -1.02f);
        v12.curveTo(18.4f, 16.809999f, 22f, 15f, 22f, 9f);
        v12.verticalLineTo(8.5f);
        v12.curveTo(22f, 7.12f, 20.879999f, 6f, 19.5f, 6f);
        v12.close();
        v12.moveTo(3.5f, 9f);
        v12.verticalLineTo(8.5f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 1.28f, 0.38f, 2.47f, 1.01f, 3.48f);
        v12.curveTo(4.99f, 14.27f, 3.5f, 12.65f, 3.5f, 9f);
        v12.close();
        v12.moveTo(7f, 11.5f);
        v12.verticalLineTo(9.85f);
        v12.curveToRelative(1.12f, -0.23f, 1.95f, -0.69f, 2.66f, -1.08f);
        v12.curveTo(10.48f, 8.33f, 11.07f, 8f, 12f, 8f);
        v12.curveToRelative(0.93f, 0f, 1.52f, 0.33f, 2.34f, 0.78f);
        v12.curveToRelative(0.71f, 0.39f, 1.54f, 0.84f, 2.66f, 1.08f);
        v12.verticalLineToRelative(1.65f);
        v12.curveToRelative(0f, 2.76f, -2.24f, 5f, -5f, 5f);
        v12.reflectiveCurveTo(7f, 14.26f, 7f, 11.5f);
        v12.close();
        v12.moveTo(20.5f, 9f);
        v12.curveToRelative(0f, 3.65f, -1.49f, 5.27f, -3.01f, 5.98f);
        v12.curveToRelative(0.64f, -1.01f, 1.01f, -2.2f, 1.01f, -3.48f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(10.69f, 10.48f);
        v12.curveToRelative(-0.44f, 0.26f, -0.96f, 0.56f, -1.69f, 0.76f);
        v12.verticalLineTo(10.2f);
        v12.curveToRelative(0.48f, -0.17f, 0.84f, -0.38f, 1.18f, -0.58f);
        v12.curveTo(10.72f, 9.3f, 11.23f, 9f, 12f, 9f);
        v12.reflectiveCurveToRelative(1.27f, 0.3f, 1.8f, 0.62f);
        v12.curveToRelative(0.34f, 0.2f, 0.71f, 0.42f, 1.2f, 0.59f);
        v12.verticalLineToRelative(1.04f);
        v12.curveToRelative(-0.75f, -0.21f, -1.26f, -0.51f, -1.71f, -0.78f);
        v12.curveTo(12.83f, 10.2f, 12.49f, 10f, 12f, 10f);
        v12.curveTo(11.51f, 10f, 11.16f, 10.2f, 10.69f, 10.48f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MasksKt._masks = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

