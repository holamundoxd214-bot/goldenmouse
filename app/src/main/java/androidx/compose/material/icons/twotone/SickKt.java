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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sick", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sick", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSick", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SickKt {
    private static ImageVector _sick;

    static {
    }

    public static final ImageVector getSick(TwoTone arg19) {
        ImageVector v0 = SickKt._sick;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Sick", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.32f, 10.56f);
        v12.lineTo(8.38f, 9.5f);
        v12.lineTo(7.32f, 8.44f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(10.5f, 9.5f);
        v12.lineToRelative(-2.12f, 2.12f);
        v12.lineTo(7.32f, 10.56f);
        v12.close();
        v12.moveTo(4.5f, 9f);
        v12.curveToRelative(0.03f, 0f, 0.05f, 0.01f, 0.08f, 0.01f);
        v12.curveTo(5.77f, 6.07f, 8.64f, 4f, 12f, 4f);
        v12.curveToRelative(2.19f, 0f, 4.16f, 0.88f, 5.61f, 2.3f);
        v12.curveToRelative(0.15f, -0.6f, 0.45f, -1.29f, 0.81f, -1.96f);
        v12.curveTo(16.68f, 2.88f, 14.44f, 2f, 11.99f, 2f);
        v12.curveToRelative(-4.88f, 0f, -8.94f, 3.51f, -9.81f, 8.14f);
        v12.curveTo(2.74f, 9.44f, 3.59f, 9f, 4.5f, 9f);
        v12.close();
        v12.moveTo(21f, 10.5f);
        v12.curveToRelative(-0.42f, 0f, -0.82f, -0.09f, -1.19f, -0.22f);
        v12.curveTo(19.93f, 10.83f, 20f, 11.41f, 20f, 12f);
        v12.curveToRelative(0f, 4.42f, -3.58f, 8f, -8f, 8f);
        v12.curveToRelative(-3.36f, 0f, -6.23f, -2.07f, -7.42f, -5.01f);
        v12.curveTo(4.55f, 14.99f, 4.53f, 15f, 4.5f, 15f);
        v12.curveToRelative(-0.52f, 0f, -1.04f, -0.14f, -1.5f, -0.4f);
        v12.curveToRelative(-0.32f, -0.18f, -0.59f, -0.42f, -0.82f, -0.7f);
        v12.curveToRelative(0.89f, 4.61f, 4.93f, 8.1f, 9.8f, 8.1f);
        v12.curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f);
        v12.curveToRelative(0f, -0.55f, -0.06f, -1.09f, -0.14f, -1.62f);
        v12.curveTo(21.58f, 10.45f, 21.299999f, 10.5f, 21f, 10.5f);
        v12.close();
        v12.moveTo(21f, 3f);
        v12.curveToRelative(0f, 0f, -2f, 2.9f, -2f, 4f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.curveTo(23f, 5.9f, 21f, 3f, 21f, 3f);
        v12.close();
        v12.moveTo(15.62f, 7.38f);
        v12.lineTo(13.5f, 9.5f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(15.62f, 9.5f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(15.62f, 7.38f);
        v12.close();
        v12.moveTo(8.56f, 17f);
        v12.curveToRelative(0.69f, -1.19f, 1.97f, -2f, 3.44f, -2f);
        v12.reflectiveCurveToRelative(2.75f, 0.81f, 3.44f, 2f);
        v12.horizontalLineToRelative(1.68f);
        v12.curveToRelative(-0.8f, -2.05f, -2.79f, -3.5f, -5.12f, -3.5f);
        v12.curveToRelative(-0.87f, 0f, -1.7f, 0.2f, -2.43f, 0.57f);
        v12.lineToRelative(0f, 0f);
        v12.lineTo(5.99f, 12f);
        v12.curveToRelative(0f, -0.52f, -0.26f, -1.02f, -0.74f, -1.29f);
        v12.curveToRelative(-0.72f, -0.41f, -1.63f, -0.17f, -2.05f, 0.55f);
        v12.curveToRelative(-0.41f, 0.72f, -0.17f, 1.63f, 0.55f, 2.05f);
        v12.curveToRelative(0.48f, 0.28f, 1.05f, 0.25f, 1.49f, 0f);
        v12.lineToRelative(2.97f, 1.72f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(7.64f, 15.56f, 7.18f, 16.24f, 6.88f, 17f);
        v12.horizontalLineTo(8.56f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SickKt._sick = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

