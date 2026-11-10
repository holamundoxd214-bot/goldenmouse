package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_stopScreenShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StopScreenShare", "Landroidx/compose/material/icons/Icons$Outlined;", "getStopScreenShare$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getStopScreenShare", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StopScreenShareKt {
    private static ImageVector _stopScreenShare;

    static {
    }

    public static final ImageVector getStopScreenShare(Outlined arg19) {
        ImageVector v0 = StopScreenShareKt._stopScreenShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.StopScreenShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.790001f, 18f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(24f, 20f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2.21f);
        v12.close();
        v12.moveTo(1.11f, 2.98f);
        v12.lineToRelative(1.55f, 1.56f);
        v12.curveToRelative(-0.41f, 0.37f, -0.66f, 0.89f, -0.66f, 1.48f);
        v12.lineTo(2f, 16f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2.01f, 2f);
        v12.lineTo(0f, 18f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(18.129999f);
        v12.lineToRelative(2.71f, 2.71f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.52f, 1.57f);
        v12.lineTo(1.11f, 2.98f);
        v12.close();
        v12.moveTo(4f, 6.02f);
        v12.horizontalLineToRelative(0.13f);
        v12.lineToRelative(4.95f, 4.93f);
        v12.curveTo(7.94f, 12.07f, 7.31f, 13.52f, 7f, 15f);
        v12.curveToRelative(0.96f, -1.29f, 2.13f, -2.08f, 3.67f, -2.46f);
        v12.lineToRelative(3.46f, 3.48f);
        v12.lineTo(4f, 16.02f);
        v12.verticalLineToRelative(-10f);
        v12.close();
        v12.moveTo(20f, 6.02f);
        v12.verticalLineToRelative(10.19f);
        v12.lineToRelative(1.3f, 1.3f);
        v12.curveToRelative(0.42f, -0.37f, 0.7f, -0.89f, 0.7f, -1.49f);
        v12.verticalLineToRelative(-10f);
        v12.curveToRelative(0f, -1.11f, -0.9f, -2f, -2f, -2f);
        v12.lineTo(7.8f, 4.02f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(20f, 6.02f);
        v12.close();
        v12.moveTo(12.93f, 9.15f);
        v12.lineToRelative(2.79f, 2.78f);
        v12.lineToRelative(1.28f, -1.2f);
        v12.lineTo(13f, 7f);
        v12.verticalLineToRelative(2.13f);
        v12.lineToRelative(-0.07f, 0.02f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StopScreenShareKt._stopScreenShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Outlined.StopScreenShare", replaceWith="<_subannotation>") public static void getStopScreenShare$annotations(Outlined arg0) {
    }
}

