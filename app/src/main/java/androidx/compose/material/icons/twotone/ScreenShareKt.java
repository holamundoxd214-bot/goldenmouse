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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_screenShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScreenShare", "Landroidx/compose/material/icons/Icons$TwoTone;", "getScreenShare$annotations", "(Landroidx/compose/material/icons/Icons$TwoTone;)V", "getScreenShare", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScreenShareKt {
    private static ImageVector _screenShare;

    static {
    }

    public static final ImageVector getScreenShare(TwoTone arg19) {
        ImageVector v0 = ScreenShareKt._screenShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.ScreenShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 16f);
        v12.lineTo(20f, 6f);
        v12.lineTo(4f, 6f);
        v12.verticalLineToRelative(10.01f);
        v12.lineTo(20f, 16f);
        v12.close();
        v12.moveTo(13f, 14.47f);
        v12.verticalLineToRelative(-2.19f);
        v12.curveToRelative(-2.78f, 0f, -4.61f, 0.85f, -6f, 2.72f);
        v12.curveToRelative(0.56f, -2.67f, 2.11f, -5.33f, 6f, -5.87f);
        v12.lineTo(13f, 7f);
        v12.lineToRelative(4f, 3.73f);
        v12.lineToRelative(-4f, 3.74f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20f, 18f);
        v12.curveToRelative(1.1f, 0f, 1.99f, -0.9f, 1.99f, -2f);
        v12.lineTo(22f, 6f);
        v12.curveToRelative(0f, -1.11f, -0.9f, -2f, -2f, -2f);
        v12.lineTo(4f, 4f);
        v12.curveToRelative(-1.11f, 0f, -2f, 0.89f, -2f, 2f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.lineTo(0f, 18f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(24f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-4f);
        v12.close();
        v12.moveTo(4f, 16f);
        v12.lineTo(4f, 6f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(10.01f);
        v12.lineTo(4f, 16f);
        v12.close();
        v12.moveTo(13f, 9.13f);
        v12.curveToRelative(-3.89f, 0.54f, -5.44f, 3.2f, -6f, 5.87f);
        v12.curveToRelative(1.39f, -1.87f, 3.22f, -2.72f, 6f, -2.72f);
        v12.verticalLineToRelative(2.19f);
        v12.lineToRelative(4f, -3.74f);
        v12.lineTo(13f, 7f);
        v12.verticalLineToRelative(2.13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScreenShareKt._screenShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.TwoTone.ScreenShare", replaceWith="<_subannotation>") public static void getScreenShare$annotations(TwoTone arg0) {
    }
}

