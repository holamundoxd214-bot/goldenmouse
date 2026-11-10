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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cameraOutdoor", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CameraOutdoor", "Landroidx/compose/material/icons/Icons$Rounded;", "getCameraOutdoor", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CameraOutdoorKt {
    private static ImageVector _cameraOutdoor;

    static {
    }

    public static final ImageVector getCameraOutdoor(Rounded arg19) {
        ImageVector v0 = CameraOutdoorKt._cameraOutdoor;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CameraOutdoor", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 13f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.lineToRelative(1.27f, 0.67f);
        v12.curveTo(19.6f, 16.85f, 20f, 16.610001f, 20f, 16.23f);
        v12.verticalLineToRelative(-2.46f);
        v12.curveToRelative(0f, -0.38f, -0.4f, -0.62f, -0.73f, -0.44f);
        v12.lineTo(18f, 14f);
        v12.verticalLineTo(13f);
        v12.close();
        v12.moveTo(10.8f, 3.9f);
        v12.lineToRelative(-6f, 4.5f);
        v12.curveTo(4.3f, 8.78f, 4f, 9.37f, 4f, 10f);
        v12.verticalLineToRelative(9f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(13f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-9f);
        v12.lineToRelative(6f, -4.5f);
        v12.lineToRelative(6f, 4.5f);
        v12.lineToRelative(0f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.63f, -0.3f, -1.22f, -0.8f, -1.6f);
        v12.lineToRelative(-6f, -4.5f);
        v12.curveTo(12.49f, 3.37f, 11.51f, 3.37f, 10.8f, 3.9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CameraOutdoorKt._cameraOutdoor = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

