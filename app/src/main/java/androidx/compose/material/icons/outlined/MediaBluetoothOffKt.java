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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mediaBluetoothOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MediaBluetoothOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getMediaBluetoothOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MediaBluetoothOffKt {
    private static ImageVector _mediaBluetoothOff;

    static {
    }

    public static final ImageVector getMediaBluetoothOff(Outlined arg19) {
        ImageVector v0 = MediaBluetoothOffKt._mediaBluetoothOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.MediaBluetoothOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 6.17f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(1.17f);
        v12.lineTo(9f, 6.17f);
        v12.close();
        v12.moveTo(19.42f, 15f);
        v12.lineTo(22f, 17.57f);
        v12.lineToRelative(-0.8f, 0.8f);
        v12.lineToRelative(-6.78f, -6.78f);
        v12.lineToRelative(0.8f, -0.8f);
        v12.lineToRelative(2.75f, 2.75f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(0.6f);
        v12.lineTo(22f, 12.43f);
        v12.lineTo(19.42f, 15f);
        v12.close();
        v12.moveTo(19.17f, 13.55f);
        v12.lineToRelative(1.13f, -1.13f);
        v12.lineToRelative(-1.13f, -1.13f);
        v12.verticalLineTo(13.55f);
        v12.close();
        v12.moveTo(21.190001f, 21.190001f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(-3.98f, -3.98f);
        v12.lineToRelative(-0.58f, 0.58f);
        v12.lineToRelative(-0.85f, -0.85f);
        v12.lineToRelative(0.58f, -0.58f);
        v12.lineTo(11f, 13.83f);
        v12.verticalLineTo(17f);
        v12.curveToRelative(0f, 2.21f, -1.78f, 4f, -3.99f, 4f);
        v12.reflectiveCurveTo(3f, 19.209999f, 3f, 17f);
        v12.reflectiveCurveToRelative(1.79f, -4f, 4.01f, -4f);
        v12.curveToRelative(0.73f, 0f, 1.41f, 0.21f, 2f, 0.55f);
        v12.verticalLineToRelative(-1.72f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineTo(2.8f, 2.81f);
        v12.lineTo(21.190001f, 21.190001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MediaBluetoothOffKt._mediaBluetoothOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

