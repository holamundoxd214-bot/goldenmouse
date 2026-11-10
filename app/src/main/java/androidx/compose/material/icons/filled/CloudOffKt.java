package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cloudOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CloudOff", "Landroidx/compose/material/icons/Icons$Filled;", "getCloudOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CloudOffKt {
    private static ImageVector _cloudOff;

    static {
    }

    public static final ImageVector getCloudOff(Filled arg19) {
        ImageVector v0 = CloudOffKt._cloudOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.CloudOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.35f, 10.04f);
        v12.curveTo(18.67f, 6.59f, 15.64f, 4f, 12f, 4f);
        v12.curveToRelative(-1.48f, 0f, -2.85f, 0.43f, -4.01f, 1.17f);
        v12.lineToRelative(1.46f, 1.46f);
        v12.curveTo(10.21f, 6.23f, 11.08f, 6f, 12f, 6f);
        v12.curveToRelative(3.04f, 0f, 5.5f, 2.46f, 5.5f, 5.5f);
        v12.verticalLineToRelative(0.5f);
        v12.horizontalLineTo(19f);
        v12.curveToRelative(1.66f, 0f, 3f, 1.34f, 3f, 3f);
        v12.curveToRelative(0f, 1.13f, -0.64f, 2.11f, -1.56f, 2.62f);
        v12.lineToRelative(1.45f, 1.45f);
        v12.curveTo(23.16f, 18.16f, 24f, 16.68f, 24f, 15f);
        v12.curveToRelative(0f, -2.64f, -2.05f, -4.78f, -4.65f, -4.96f);
        v12.close();
        v12.moveTo(3f, 5.27f);
        v12.lineToRelative(2.75f, 2.74f);
        v12.curveTo(2.56f, 8.15f, 0f, 10.77f, 0f, 14f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.horizontalLineToRelative(11.73f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(21f, 20.73f);
        v12.lineTo(4.27f, 4f);
        v12.lineTo(3f, 5.27f);
        v12.close();
        v12.moveTo(7.73f, 10f);
        v12.lineToRelative(8f, 8f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.reflectiveCurveToRelative(1.79f, -4f, 4f, -4f);
        v12.horizontalLineToRelative(1.73f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CloudOffKt._cloudOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

