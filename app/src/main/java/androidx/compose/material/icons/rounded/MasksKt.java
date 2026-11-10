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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_masks", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Masks", "Landroidx/compose/material/icons/Icons$Rounded;", "getMasks", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MasksKt {
    private static ImageVector _masks;

    static {
    }

    public static final ImageVector getMasks(Rounded arg19) {
        ImageVector v0 = MasksKt._masks;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Masks", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
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
        v12.moveTo(14.3f, 11.01f);
        v12.curveToRelative(-0.4f, -0.17f, -0.72f, -0.36f, -1.01f, -0.53f);
        v12.curveTo(12.83f, 10.2f, 12.49f, 10f, 12f, 10f);
        v12.curveToRelative(-0.49f, 0f, -0.84f, 0.2f, -1.31f, 0.48f);
        v12.curveToRelative(-0.28f, 0.17f, -0.6f, 0.35f, -0.98f, 0.51f);
        v12.curveTo(9.37f, 11.14f, 9f, 10.91f, 9f, 10.54f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.2f, 0.11f, -0.38f, 0.29f, -0.45f);
        v12.curveToRelative(0.34f, -0.14f, 0.62f, -0.31f, 0.88f, -0.46f);
        v12.curveTo(10.72f, 9.3f, 11.23f, 9f, 12f, 9f);
        v12.reflectiveCurveToRelative(1.27f, 0.3f, 1.8f, 0.62f);
        v12.curveToRelative(0.27f, 0.16f, 0.55f, 0.33f, 0.9f, 0.48f);
        v12.curveToRelative(0.18f, 0.08f, 0.29f, 0.26f, 0.29f, 0.45f);
        v12.curveTo(15f, 10.91f, 14.63f, 11.15f, 14.3f, 11.01f);
        v12.close();
        v12.moveTo(20.5f, 9f);
        v12.curveToRelative(0f, 3.65f, -1.49f, 5.27f, -3.01f, 5.98f);
        v12.curveToRelative(0.64f, -1.01f, 1.01f, -2.2f, 1.01f, -3.48f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MasksKt._masks = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

