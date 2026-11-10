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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cloudSync", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CloudSync", "Landroidx/compose/material/icons/Icons$Rounded;", "getCloudSync", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CloudSyncKt {
    private static ImageVector _cloudSync;

    static {
    }

    public static final ImageVector getCloudSync(Rounded arg19) {
        ImageVector v0 = CloudSyncKt._cloudSync;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CloudSync", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(24f, 17.48f);
        v12.curveToRelative(0f, 1.38f, -1.12f, 2.5f, -2.5f, 2.5f);
        v12.lineTo(15f, 20f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.curveToRelative(0f, -1.6f, 1.26f, -2.9f, 2.84f, -2.98f);
        v12.curveTo(15.4f, 12.83f, 16.6f, 12f, 18f, 12f);
        v12.curveToRelative(1.76f, 0f, 3.2f, 1.3f, 3.45f, 2.99f);
        v12.curveToRelative(0.02f, 0f, 0.03f, -0.01f, 0.05f, -0.01f);
        v12.curveTo(22.879999f, 14.98f, 24f, 16.1f, 24f, 17.48f);
        v12.close();
        v12.moveTo(10f, 15f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1.44f);
        v12.curveToRelative(-1.22f, -1.1f, -2f, -2.67f, -2f, -4.44f);
        v12.curveToRelative(0f, -2.38f, 1.39f, -4.43f, 3.4f, -5.4f);
        v12.curveTo(9.77f, 6.42f, 10f, 6.04f, 10f, 5.63f);
        v12.curveToRelative(0f, -0.71f, -0.73f, -1.18f, -1.37f, -0.88f);
        v12.curveTo(5.89f, 6.03f, 4f, 8.79f, 4f, 12f);
        v12.curveToRelative(0f, 2.4f, 1.06f, 4.54f, 2.73f, 6f);
        v12.horizontalLineTo(5f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(15f);
        v12.close();
        v12.moveTo(19f, 6f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(7.56f);
        v12.curveToRelative(0.98f, 0.89f, 1.68f, 2.08f, 1.92f, 3.44f);
        v12.lineToRelative(2.02f, 0f);
        v12.curveToRelative(-0.25f, -1.99f, -1.23f, -3.74f, -2.66f, -5f);
        v12.horizontalLineTo(19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CloudSyncKt._cloudSync = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

