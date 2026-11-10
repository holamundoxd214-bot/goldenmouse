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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cloudOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CloudOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getCloudOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CloudOffKt {
    private static ImageVector _cloudOff;

    static {
    }

    public static final ImageVector getCloudOff(TwoTone arg19) {
        ImageVector v0 = CloudOffKt._cloudOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.CloudOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 15f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.horizontalLineToRelative(-1.5f);
        v12.verticalLineToRelative(-0.5f);
        v12.curveTo(17.5f, 8.46f, 15.04f, 6f, 12f, 6f);
        v12.curveToRelative(-0.77f, 0f, -1.49f, 0.17f, -2.16f, 0.46f);
        v12.lineTo(20.790001f, 17.4f);
        v12.curveToRelative(0.73f, -0.55f, 1.21f, -1.41f, 1.21f, -2.4f);
        v12.close();
        v12.moveTo(2f, 14f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.horizontalLineToRelative(9.73f);
        v12.lineToRelative(-8f, -8f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.35f, 10.04f);
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
        v12.curveToRelative(0f, -2.64f, -2.05f, -4.78f, -4.65f, -4.96f);
        v12.close();
        v12.moveTo(3f, 5.27f);
        v12.lineToRelative(2.77f, 2.77f);
        v12.horizontalLineToRelative(-0.42f);
        v12.curveTo(2.34f, 8.36f, 0f, 10.91f, 0f, 14f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.horizontalLineToRelative(11.73f);
        v12.lineToRelative(2f, 2f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(4.41f, 3.86f);
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

