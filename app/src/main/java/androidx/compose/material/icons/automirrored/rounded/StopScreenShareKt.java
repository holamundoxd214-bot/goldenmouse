package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_stopScreenShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StopScreenShare", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getStopScreenShare", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StopScreenShareKt {
    private static ImageVector _stopScreenShare;

    static {
    }

    public static final ImageVector getStopScreenShare(Rounded arg19) {
        ImageVector v0 = StopScreenShareKt._stopScreenShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.StopScreenShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23f, 18f);
        v12.horizontalLineToRelative(-1.2f);
        v12.lineToRelative(1.79f, 1.79f);
        v12.curveToRelative(0.24f, -0.18f, 0.41f, -0.46f, 0.41f, -0.79f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(3.23f, 2.28f);
        v12.curveToRelative(-0.39f, -0.39f, -1.03f, -0.39f, -1.42f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(0.84f, 0.86f);
        v12.reflectiveCurveToRelative(-0.66f, 0.57f, -0.66f, 1.47f);
        v12.curveTo(2f, 6.92f, 2f, 16f, 2f, 16f);
        v12.lineToRelative(0.01f, 0.01f);
        v12.curveToRelative(0f, 1.09f, 0.88f, 1.98f, 1.97f, 1.99f);
        v12.lineTo(1f, 18f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(17.129999f);
        v12.lineToRelative(2f, 2f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.reflectiveCurveToRelative(0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(3.23f, 2.28f);
        v12.close();
        v12.moveTo(7f, 15f);
        v12.curveToRelative(0.31f, -1.48f, 0.94f, -2.93f, 2.08f, -4.05f);
        v12.lineToRelative(1.59f, 1.59f);
        v12.curveTo(9.13f, 12.92f, 7.96f, 13.71f, 7f, 15f);
        v12.close();
        v12.moveTo(13f, 9.13f);
        v12.verticalLineToRelative(-0.98f);
        v12.curveToRelative(0f, -0.44f, 0.52f, -0.66f, 0.84f, -0.37f);
        v12.lineTo(15f, 8.87f);
        v12.lineToRelative(1.61f, 1.5f);
        v12.curveToRelative(0.21f, 0.2f, 0.21f, 0.53f, 0f, 0.73f);
        v12.lineToRelative(-0.89f, 0.83f);
        v12.lineToRelative(5.58f, 5.58f);
        v12.curveToRelative(0.43f, -0.37f, 0.7f, -0.9f, 0.7f, -1.51f);
        v12.lineTo(22f, 6f);
        v12.curveToRelative(0f, -1.09f, -0.89f, -1.98f, -1.98f, -1.98f);
        v12.lineTo(7.8f, 4.02f);
        v12.lineToRelative(5.14f, 5.13f);
        v12.curveToRelative(0.02f, -0.01f, 0.04f, -0.02f, 0.06f, -0.02f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StopScreenShareKt._stopScreenShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

