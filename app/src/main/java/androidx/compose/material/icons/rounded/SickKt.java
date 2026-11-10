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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sick", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sick", "Landroidx/compose/material/icons/Icons$Rounded;", "getSick", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SickKt {
    private static ImageVector _sick;

    static {
    }

    public static final ImageVector getSick(Rounded arg19) {
        ImageVector v0 = SickKt._sick;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Sick", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23f, 7f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -0.78f, 0.99f, -2.44f, 1.58f, -3.36f);
        v12.curveToRelative(0.2f, -0.31f, 0.64f, -0.31f, 0.84f, 0f);
        v12.curveTo(22.01f, 4.56f, 23f, 6.22f, 23f, 7f);
        v12.close();
        v12.moveTo(21.860001f, 10.38f);
        v12.curveTo(21.940001f, 10.91f, 22f, 11.45f, 22f, 12f);
        v12.curveToRelative(0f, 5.52f, -4.48f, 10f, -10.01f, 10f);
        v12.curveTo(6.47f, 22f, 2f, 17.52f, 2f, 12f);
        v12.curveTo(2f, 6.48f, 6.47f, 2f, 11.99f, 2f);
        v12.curveToRelative(2.45f, 0f, 4.69f, 0.88f, 6.43f, 2.34f);
        v12.curveTo(17.91f, 5.29f, 17.5f, 6.27f, 17.5f, 7f);
        v12.curveToRelative(0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f);
        v12.curveTo(21.299999f, 10.5f, 21.58f, 10.45f, 21.860001f, 10.38f);
        v12.close();
        v12.moveTo(14.03f, 10.03f);
        v12.lineToRelative(1.06f, 1.06f);
        v12.curveToRelative(0.29f, 0.29f, 0.77f, 0.29f, 1.06f, 0f);
        v12.curveToRelative(0.29f, -0.29f, 0.29f, -0.77f, 0f, -1.06f);
        v12.lineTo(15.62f, 9.5f);
        v12.lineToRelative(0.53f, -0.53f);
        v12.curveToRelative(0.29f, -0.29f, 0.29f, -0.77f, 0f, -1.06f);
        v12.reflectiveCurveToRelative(-0.77f, -0.29f, -1.06f, 0f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.curveTo(13.74f, 9.26f, 13.74f, 9.74f, 14.03f, 10.03f);
        v12.close();
        v12.moveTo(8.38f, 9.5f);
        v12.lineToRelative(-0.53f, 0.53f);
        v12.curveToRelative(-0.29f, 0.29f, -0.29f, 0.77f, 0f, 1.06f);
        v12.curveToRelative(0.29f, 0.29f, 0.77f, 0.29f, 1.06f, 0f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.curveToRelative(0.29f, -0.29f, 0.29f, -0.77f, 0f, -1.06f);
        v12.lineTo(8.91f, 7.91f);
        v12.curveToRelative(-0.29f, -0.29f, -0.77f, -0.29f, -1.06f, 0f);
        v12.reflectiveCurveToRelative(-0.29f, 0.77f, 0f, 1.06f);
        v12.lineTo(8.38f, 9.5f);
        v12.close();
        v12.moveTo(16.469999f, 15.8f);
        v12.curveToRelative(-1f, -1.39f, -2.62f, -2.3f, -4.47f, -2.3f);
        v12.curveToRelative(-0.87f, 0f, -1.69f, 0.2f, -2.43f, 0.56f);
        v12.lineTo(5.99f, 12f);
        v12.curveToRelative(0f, -0.52f, -0.26f, -1.02f, -0.74f, -1.29f);
        v12.curveToRelative(-0.8f, -0.46f, -1.84f, -0.11f, -2.17f, 0.8f);
        v12.curveToRelative(-0.21f, 0.57f, -0.03f, 1.25f, 0.44f, 1.64f);
        v12.curveToRelative(0.52f, 0.44f, 1.2f, 0.45f, 1.72f, 0.16f);
        v12.lineToRelative(2.97f, 1.72f);
        v12.curveToRelative(-0.25f, 0.24f, -0.48f, 0.5f, -0.68f, 0.78f);
        v12.curveTo(7.17f, 16.299999f, 7.53f, 17f, 8.15f, 17f);
        v12.curveToRelative(0.23f, 0f, 0.46f, -0.1f, 0.6f, -0.3f);
        v12.curveTo(9.47f, 15.68f, 10.65f, 15f, 12f, 15f);
        v12.reflectiveCurveToRelative(2.53f, 0.68f, 3.25f, 1.7f);
        v12.curveToRelative(0.14f, 0.19f, 0.36f, 0.3f, 0.6f, 0.3f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(16.469999f, 17f, 16.83f, 16.299999f, 16.469999f, 15.8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SickKt._sick = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

