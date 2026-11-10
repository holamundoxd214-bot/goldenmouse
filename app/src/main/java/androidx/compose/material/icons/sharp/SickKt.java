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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sick", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sick", "Landroidx/compose/material/icons/Icons$Sharp;", "getSick", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SickKt {
    private static ImageVector _sick;

    static {
    }

    public static final ImageVector getSick(Sharp arg19) {
        ImageVector v0 = SickKt._sick;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Sick", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 9f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -1.1f, 2f, -4f, 2f, -4f);
        v12.reflectiveCurveToRelative(2f, 2.9f, 2f, 4f);
        v12.curveTo(23f, 8.1f, 22.1f, 9f, 21f, 9f);
        v12.close();
        v12.moveTo(17.5f, 7f);
        v12.curveToRelative(0f, -0.73f, 0.41f, -1.71f, 0.92f, -2.66f);
        v12.curveTo(16.68f, 2.88f, 14.44f, 2f, 11.99f, 2f);
        v12.curveTo(6.47f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.47f, 10f, 9.99f, 10f);
        v12.curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f);
        v12.curveToRelative(0f, -0.55f, -0.06f, -1.09f, -0.14f, -1.62f);
        v12.curveTo(21.58f, 10.45f, 21.299999f, 10.5f, 21f, 10.5f);
        v12.curveTo(19.07f, 10.5f, 17.5f, 8.93f, 17.5f, 7f);
        v12.close();
        v12.moveTo(15.62f, 7.38f);
        v12.lineToRelative(1.06f, 1.06f);
        v12.lineTo(15.62f, 9.5f);
        v12.lineToRelative(1.06f, 1.06f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineTo(13.5f, 9.5f);
        v12.lineTo(15.62f, 7.38f);
        v12.close();
        v12.moveTo(7.32f, 8.44f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(10.5f, 9.5f);
        v12.lineToRelative(-2.12f, 2.12f);
        v12.lineToRelative(-1.06f, -1.06f);
        v12.lineTo(8.38f, 9.5f);
        v12.lineTo(7.32f, 8.44f);
        v12.close();
        v12.moveTo(15.44f, 17f);
        v12.curveToRelative(-0.69f, -1.19f, -1.97f, -2f, -3.44f, -2f);
        v12.reflectiveCurveToRelative(-2.75f, 0.81f, -3.44f, 2f);
        v12.horizontalLineTo(6.88f);
        v12.curveToRelative(0.3f, -0.76f, 0.76f, -1.43f, 1.34f, -1.99f);
        v12.lineTo(5.24f, 13.3f);
        v12.curveToRelative(-0.45f, 0.26f, -1.01f, 0.28f, -1.49f, 0f);
        v12.curveToRelative(-0.72f, -0.41f, -0.96f, -1.33f, -0.55f, -2.05f);
        v12.curveToRelative(0.41f, -0.72f, 1.33f, -0.96f, 2.05f, -0.55f);
        v12.curveToRelative(0.48f, 0.28f, 0.74f, 0.78f, 0.74f, 1.29f);
        v12.lineToRelative(3.58f, 2.07f);
        v12.curveToRelative(0.73f, -0.36f, 1.55f, -0.56f, 2.43f, -0.56f);
        v12.curveToRelative(2.33f, 0f, 4.32f, 1.45f, 5.12f, 3.5f);
        v12.horizontalLineTo(15.44f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SickKt._sick = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

