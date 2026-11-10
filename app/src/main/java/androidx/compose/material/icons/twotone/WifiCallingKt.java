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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiCalling", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiCalling", "Landroidx/compose/material/icons/Icons$TwoTone;", "getWifiCalling", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiCallingKt {
    private static ImageVector _wifiCalling;

    static {
    }

    public static final ImageVector getWifiCalling(TwoTone arg19) {
        ImageVector v0 = WifiCallingKt._wifiCalling;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.WifiCalling", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.2f, 18.209999f);
        v12.curveToRelative(1.2f, 0.41f, 2.48f, 0.67f, 3.8f, 0.75f);
        v12.verticalLineToRelative(-1.49f);
        v12.curveToRelative(-0.88f, -0.07f, -1.75f, -0.22f, -2.6f, -0.45f);
        v12.lineTo(15.2f, 18.209999f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(6.54f, 5f);
        v12.horizontalLineToRelative(-1.5f);
        v12.curveToRelative(0.09f, 1.32f, 0.35f, 2.59f, 0.75f, 3.8f);
        v12.lineToRelative(1.2f, -1.2f);
        v12.curveTo(6.75f, 6.76f, 6.6f, 5.89f, 6.54f, 5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20f, 15.51f);
        v12.curveToRelative(-1.24f, 0f, -2.45f, -0.2f, -3.57f, -0.57f);
        v12.curveToRelative(-0.1f, -0.04f, -0.21f, -0.05f, -0.31f, -0.05f);
        v12.curveToRelative(-0.26f, 0f, -0.51f, 0.1f, -0.71f, 0.29f);
        v12.lineToRelative(-2.2f, 2.2f);
        v12.curveToRelative(-2.83f, -1.45f, -5.15f, -3.76f, -6.59f, -6.59f);
        v12.lineToRelative(2.2f, -2.2f);
        v12.curveTo(9.1f, 8.31f, 9.18f, 7.92f, 9.07f, 7.57f);
        v12.curveTo(8.7f, 6.45f, 8.5f, 5.25f, 8.5f, 4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(4f);
        v12.curveTo(3.45f, 3f, 3f, 3.45f, 3f, 4f);
        v12.curveToRelative(0f, 9.39f, 7.61f, 17f, 17f, 17f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-3.49f);
        v12.curveTo(21f, 15.96f, 20.549999f, 15.51f, 20f, 15.51f);
        v12.close();
        v12.moveTo(5.03f, 5f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveTo(6.6f, 5.89f, 6.75f, 6.76f, 6.99f, 7.59f);
        v12.lineToRelative(-1.2f, 1.2f);
        v12.curveTo(5.38f, 7.59f, 5.12f, 6.32f, 5.03f, 5f);
        v12.close();
        v12.moveTo(19f, 18.969999f);
        v12.curveToRelative(-1.32f, -0.09f, -2.59f, -0.35f, -3.8f, -0.75f);
        v12.lineToRelative(1.19f, -1.19f);
        v12.curveToRelative(0.85f, 0.24f, 1.72f, 0.39f, 2.6f, 0.45f);
        v12.verticalLineTo(18.969999f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(22f, 4.95f);
        v12.curveTo(21.790001f, 4.78f, 19.67f, 3f, 16.5f, 3f);
        v12.curveToRelative(-3.18f, 0f, -5.29f, 1.78f, -5.5f, 1.95f);
        v12.lineTo(16.5f, 12f);
        v12.lineTo(22f, 4.95f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiCallingKt._wifiCalling = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

