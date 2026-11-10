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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiTetheringErrorRounded", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiTetheringErrorRounded", "Landroidx/compose/material/icons/Icons$TwoTone;", "getWifiTetheringErrorRounded", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiTetheringErrorRoundedKt {
    private static ImageVector _wifiTetheringErrorRounded;

    static {
    }

    public static final ImageVector getWifiTetheringErrorRounded(TwoTone arg19) {
        ImageVector v0 = WifiTetheringErrorRoundedKt._wifiTetheringErrorRounded;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.WifiTetheringErrorRounded", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 7f);
        v12.curveToRelative(-3.31f, 0f, -6f, 2.69f, -6f, 6f);
        v12.curveToRelative(0f, 1.66f, 0.68f, 3.15f, 1.76f, 4.24f);
        v12.lineToRelative(1.42f, -1.42f);
        v12.curveTo(8.45f, 15.1f, 8f, 14.11f, 8f, 13f);
        v12.curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 1.11f, -0.45f, 2.1f, -1.18f, 2.82f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(17.32f, 16.15f, 18f, 14.66f, 18f, 13f);
        v12.curveTo(18f, 9.69f, 15.31f, 7f, 12f, 7f);
        v12.close();
        v12.moveTo(12f, 3f);
        v12.curveTo(6.48f, 3f, 2f, 7.48f, 2f, 13f);
        v12.curveToRelative(0f, 2.76f, 1.12f, 5.26f, 2.93f, 7.07f);
        v12.lineToRelative(1.42f, -1.42f);
        v12.curveTo(4.9f, 17.209999f, 4f, 15.21f, 4f, 13f);
        v12.curveToRelative(0f, -4.42f, 3.58f, -8f, 8f, -8f);
        v12.curveToRelative(2.53f, 0f, 4.78f, 1.17f, 6.24f, 3f);
        v12.horizontalLineToRelative(2.42f);
        v12.curveTo(18.93f, 5.01f, 15.7f, 3f, 12f, 3f);
        v12.close();
        v12.moveTo(12f, 11f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.curveToRelative(0f, 0.55f, 0.23f, 1.05f, 0.59f, 1.41f);
        v12.curveTo(10.95f, 14.77f, 11.45f, 15f, 12f, 15f);
        v12.reflectiveCurveToRelative(1.05f, -0.23f, 1.41f, -0.59f);
        v12.curveTo(13.77f, 14.05f, 14f, 13.55f, 14f, 13f);
        v12.curveTo(14f, 11.9f, 13.1f, 11f, 12f, 11f);
        v12.close();
        v12.moveTo(20f, 10f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(10f);
        v12.close();
        v12.moveTo(20f, 18f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiTetheringErrorRoundedKt._wifiTetheringErrorRounded = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

