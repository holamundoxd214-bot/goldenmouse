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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_stopScreenShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StopScreenShare", "Landroidx/compose/material/icons/Icons$Filled;", "getStopScreenShare$annotations", "(Landroidx/compose/material/icons/Icons$Filled;)V", "getStopScreenShare", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StopScreenShareKt {
    private static ImageVector _stopScreenShare;

    static {
    }

    public static final ImageVector getStopScreenShare(Filled arg19) {
        ImageVector v0 = StopScreenShareKt._stopScreenShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.StopScreenShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.219999f, 18.02f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(24f, 20.02f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2.78f);
        v12.close();
        v12.moveTo(21.99f, 16.02f);
        v12.lineToRelative(0.01f, -10f);
        v12.curveToRelative(0f, -1.11f, -0.9f, -2f, -2f, -2f);
        v12.lineTo(7.22f, 4.02f);
        v12.lineToRelative(5.23f, 5.23f);
        v12.curveToRelative(0.18f, -0.04f, 0.36f, -0.07f, 0.55f, -0.1f);
        v12.lineTo(13f, 7.02f);
        v12.lineToRelative(4f, 3.73f);
        v12.lineToRelative(-1.58f, 1.47f);
        v12.lineToRelative(5.54f, 5.54f);
        v12.curveToRelative(0.61f, -0.33f, 1.03f, -0.99f, 1.03f, -1.74f);
        v12.close();
        v12.moveTo(2.39f, 1.73f);
        v12.lineTo(1.11f, 3f);
        v12.lineToRelative(1.54f, 1.54f);
        v12.curveToRelative(-0.4f, 0.36f, -0.65f, 0.89f, -0.65f, 1.48f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.lineTo(0f, 18.02f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(18.129999f);
        v12.lineToRelative(2.71f, 2.71f);
        v12.lineToRelative(1.27f, -1.27f);
        v12.lineTo(2.39f, 1.73f);
        v12.close();
        v12.moveTo(7f, 15.02f);
        v12.curveToRelative(0.31f, -1.48f, 0.92f, -2.95f, 2.07f, -4.06f);
        v12.lineToRelative(1.59f, 1.59f);
        v12.curveToRelative(-1.54f, 0.38f, -2.7f, 1.18f, -3.66f, 2.47f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StopScreenShareKt._stopScreenShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Filled.StopScreenShare", replaceWith="<_subannotation>") public static void getStopScreenShare$annotations(Filled arg0) {
    }
}

