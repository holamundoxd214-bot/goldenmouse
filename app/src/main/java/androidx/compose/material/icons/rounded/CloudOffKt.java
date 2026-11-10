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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cloudOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CloudOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getCloudOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CloudOffKt {
    private static ImageVector _cloudOff;

    static {
    }

    public static final ImageVector getCloudOff(Rounded arg19) {
        ImageVector v0 = CloudOffKt._cloudOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CloudOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(24f, 15f);
        v12.curveToRelative(0f, -2.64f, -2.05f, -4.78f, -4.65f, -4.96f);
        v12.curveTo(18.67f, 6.59f, 15.64f, 4f, 12f, 4f);
        v12.curveToRelative(-1.33f, 0f, -2.57f, 0.36f, -3.65f, 0.97f);
        v12.lineToRelative(1.49f, 1.49f);
        v12.curveTo(10.51f, 6.17f, 11.23f, 6f, 12f, 6f);
        v12.curveToRelative(3.04f, 0f, 5.5f, 2.46f, 5.5f, 5.5f);
        v12.verticalLineToRelative(0.5f);
        v12.horizontalLineTo(19f);
        v12.curveToRelative(1.66f, 0f, 3f, 1.34f, 3f, 3f);
        v12.curveToRelative(0f, 0.99f, -0.48f, 1.85f, -1.21f, 2.4f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.curveToRelative(1.09f, -0.92f, 1.8f, -2.27f, 1.8f, -3.81f);
        v12.close();
        v12.moveTo(3.71f, 4.56f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.06f, 2.06f);
        v12.horizontalLineToRelative(-0.42f);
        v12.curveToRelative(-3.28f, 0.35f, -5.76f, 3.34f, -5.29f, 6.79f);
        v12.curveTo(0.46f, 17.84f, 3.19f, 20f, 6.22f, 20f);
        v12.horizontalLineToRelative(11.51f);
        v12.lineToRelative(1.29f, 1.29f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(5.12f, 4.56f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.close();
        v12.moveTo(6f, 18f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.reflectiveCurveToRelative(1.79f, -4f, 4f, -4f);
        v12.horizontalLineToRelative(1.73f);
        v12.lineToRelative(8f, 8f);
        v12.horizontalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CloudOffKt._cloudOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

