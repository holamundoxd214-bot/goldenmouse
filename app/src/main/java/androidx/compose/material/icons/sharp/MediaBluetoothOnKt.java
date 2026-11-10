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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mediaBluetoothOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MediaBluetoothOn", "Landroidx/compose/material/icons/Icons$Sharp;", "getMediaBluetoothOn", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MediaBluetoothOnKt {
    private static ImageVector _mediaBluetoothOn;

    static {
    }

    public static final ImageVector getMediaBluetoothOn(Sharp arg19) {
        ImageVector v0 = MediaBluetoothOnKt._mediaBluetoothOn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.MediaBluetoothOn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 3f);
        v12.lineToRelative(0.01f, 10.55f);
        v12.curveToRelative(-0.6f, -0.34f, -1.28f, -0.55f, -2f, -0.55f);
        v12.curveTo(4.79f, 13f, 3f, 14.79f, 3f, 17f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4.01f, 4f);
        v12.reflectiveCurveTo(11f, 19.209999f, 11f, 17f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineTo(3f);
        v12.horizontalLineTo(9f);
        v12.close();
        v12.moveTo(21f, 12.43f);
        v12.lineTo(17.57f, 9f);
        v12.horizontalLineToRelative(-0.6f);
        v12.verticalLineToRelative(4.55f);
        v12.lineToRelative(-2.75f, -2.75f);
        v12.lineToRelative(-0.85f, 0.85f);
        v12.lineTo(16.73f, 15f);
        v12.lineToRelative(-3.35f, 3.35f);
        v12.lineToRelative(0.85f, 0.85f);
        v12.lineToRelative(2.75f, -2.75f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(0.6f);
        v12.lineTo(21f, 17.57f);
        v12.lineTo(18.42f, 15f);
        v12.lineTo(21f, 12.43f);
        v12.close();
        v12.moveTo(18.17f, 11.3f);
        v12.lineToRelative(1.13f, 1.13f);
        v12.lineToRelative(-1.13f, 1.13f);
        v12.verticalLineTo(11.3f);
        v12.close();
        v12.moveTo(19.299999f, 17.57f);
        v12.lineToRelative(-1.13f, 1.13f);
        v12.verticalLineToRelative(-2.26f);
        v12.lineTo(19.299999f, 17.57f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MediaBluetoothOnKt._mediaBluetoothOn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

