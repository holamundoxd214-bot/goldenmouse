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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_stopScreenShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StopScreenShare", "Landroidx/compose/material/icons/Icons$Sharp;", "getStopScreenShare$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getStopScreenShare", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StopScreenShareKt {
    private static ImageVector _stopScreenShare;

    static {
    }

    public static final ImageVector getStopScreenShare(Sharp arg19) {
        ImageVector v0 = StopScreenShareKt._stopScreenShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.StopScreenShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.790001f, 18f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(24f, 20f);
        v12.verticalLineToRelative(-2f);
        v12.close();
        v12.moveTo(13f, 9.13f);
        v12.lineTo(13f, 7f);
        v12.lineToRelative(4f, 3.74f);
        v12.lineToRelative(-1.28f, 1.19f);
        v12.lineToRelative(5.18f, 5.18f);
        v12.lineTo(22f, 16f);
        v12.lineTo(22f, 4.02f);
        v12.lineTo(7.8f, 4.02f);
        v12.lineToRelative(5.13f, 5.13f);
        v12.curveToRelative(0.03f, -0.01f, 0.05f, -0.02f, 0.07f, -0.02f);
        v12.close();
        v12.moveTo(1.11f, 2.98f);
        v12.lineToRelative(0.89f, 0.9f);
        v12.verticalLineToRelative(12.14f);
        v12.lineToRelative(2f, 1.99f);
        v12.lineTo(0f, 18f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(18.129999f);
        v12.lineToRelative(2.71f, 2.71f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.52f, 1.57f);
        v12.lineTo(1.11f, 2.98f);
        v12.close();
        v12.moveTo(9.08f, 10.95f);
        v12.lineToRelative(1.59f, 1.59f);
        v12.curveTo(9.13f, 12.92f, 7.96f, 13.71f, 7f, 15f);
        v12.curveToRelative(0.31f, -1.48f, 0.94f, -2.93f, 2.08f, -4.05f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StopScreenShareKt._stopScreenShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.StopScreenShare", replaceWith="<_subannotation>") public static void getStopScreenShare$annotations(Sharp arg0) {
    }
}

