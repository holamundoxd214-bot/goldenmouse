package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_recycling", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Recycling", "Landroidx/compose/material/icons/Icons$Sharp;", "getRecycling", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RecyclingKt {
    private static ImageVector _recycling;

    static {
    }

    public static final ImageVector getRecycling(Sharp arg19) {
        ImageVector v0 = RecyclingKt._recycling;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Recycling", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5.77f, 7.15f);
        v12.lineTo(7.2f, 4.78f);
        v12.lineToRelative(1.03f, -1.71f);
        v12.curveToRelative(0.39f, -0.65f, 1.33f, -0.65f, 1.72f, 0f);
        v12.lineToRelative(1.48f, 2.46f);
        v12.lineToRelative(-1.23f, 2.06f);
        v12.lineTo(9.2f, 9.21f);
        v12.lineTo(5.77f, 7.15f);
        v12.close();
        v12.moveTo(21.719999f, 12.97f);
        v12.lineToRelative(-1.6f, -2.66f);
        v12.lineToRelative(-3.46f, 2f);
        v12.lineTo(18.870001f, 16f);
        v12.horizontalLineTo(20f);
        v12.curveToRelative(0.76f, 0f, 1.45f, -0.43f, 1.79f, -1.11f);
        v12.curveTo(21.93f, 14.61f, 22f, 14.31f, 22f, 14f);
        v12.curveTo(22f, 13.64f, 21.9f, 13.29f, 21.719999f, 12.97f);
        v12.close();
        v12.moveTo(16f, 21f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveToRelative(0.76f, 0f, 1.45f, -0.43f, 1.79f, -1.11f);
        v12.lineTo(20.74f, 17f);
        v12.horizontalLineTo(16f);
        v12.verticalLineToRelative(-2f);
        v12.lineToRelative(-4f, 4f);
        v12.lineToRelative(4f, 4f);
        v12.verticalLineTo(21f);
        v12.close();
        v12.moveTo(10f, 17f);
        v12.horizontalLineTo(5.7f);
        v12.lineToRelative(-0.84f, 1.41f);
        v12.curveToRelative(-0.3f, 0.5f, -0.32f, 1.12f, -0.06f, 1.65f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(5.08f, 20.629999f, 5.67f, 21f, 6.32f, 21f);
        v12.horizontalLineTo(10f);
        v12.verticalLineTo(17f);
        v12.close();
        v12.moveTo(6.12f, 14.35f);
        v12.lineToRelative(1.73f, 1.04f);
        v12.lineTo(6.48f, 9.9f);
        v12.lineTo(1f, 11.27f);
        v12.lineToRelative(1.7f, 1.02f);
        v12.lineToRelative(-0.41f, 0.69f);
        v12.curveToRelative(-0.35f, 0.59f, -0.38f, 1.31f, -0.07f, 1.92f);
        v12.lineToRelative(1.63f, 3.26f);
        v12.lineTo(6.12f, 14.35f);
        v12.close();
        v12.moveTo(17.02f, 5.14f);
        v12.lineToRelative(-1.3f, -2.17f);
        v12.curveTo(15.35f, 2.37f, 14.7f, 2f, 14f, 2f);
        v12.horizontalLineToRelative(-3.53f);
        v12.lineToRelative(3.12f, 5.2f);
        v12.lineToRelative(-1.72f, 1.03f);
        v12.lineToRelative(5.49f, 1.37f);
        v12.lineToRelative(1.37f, -5.49f);
        v12.lineTo(17.02f, 5.14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RecyclingKt._recycling = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

