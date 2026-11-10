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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bluetoothDrive", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BluetoothDrive", "Landroidx/compose/material/icons/Icons$Filled;", "getBluetoothDrive", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BluetoothDriveKt {
    private static ImageVector _bluetoothDrive;

    static {
    }

    public static final ImageVector getBluetoothDrive(Filled arg19) {
        ImageVector v0 = BluetoothDriveKt._bluetoothDrive;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.BluetoothDrive", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 10f);
        v12.horizontalLineTo(4.81f);
        v12.lineToRelative(1.04f, -3f);
        v12.horizontalLineTo(15f);
        v12.verticalLineTo(5f);
        v12.horizontalLineTo(5.5f);
        v12.curveTo(4.84f, 5f, 4.29f, 5.42f, 4.08f, 6.01f);
        v12.lineTo(2f, 12f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-8f);
        v12.horizontalLineToRelative(-3f);
        v12.curveTo(15.9f, 12f, 15f, 11.1f, 15f, 10f);
        v12.close();
        v12.moveTo(6.5f, 16f);
        v12.curveTo(5.67f, 16f, 5f, 15.33f, 5f, 14.5f);
        v12.reflectiveCurveTo(5.67f, 13f, 6.5f, 13f);
        v12.reflectiveCurveTo(8f, 13.67f, 8f, 14.5f);
        v12.reflectiveCurveTo(7.33f, 16f, 6.5f, 16f);
        v12.close();
        v12.moveTo(15.5f, 16f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(16.33f, 16f, 15.5f, 16f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(22f, 3.85f);
        v0_1.lineTo(19.15f, 1f);
        v0_1.horizontalLineToRelative(-0.5f);
        v0_1.verticalLineToRelative(3.79f);
        v0_1.lineToRelative(-2.3f, -2.29f);
        v0_1.lineToRelative(-0.7f, 0.7f);
        v0_1.lineTo(18.440001f, 6f);
        v0_1.lineToRelative(-2.79f, 2.79f);
        v0_1.lineToRelative(0.7f, 0.71f);
        v0_1.lineToRelative(2.3f, -2.3f);
        v0_1.verticalLineTo(11f);
        v0_1.horizontalLineToRelative(0.5f);
        v0_1.lineTo(22f, 8.14f);
        v0_1.lineTo(19.85f, 6f);
        v0_1.lineTo(22f, 3.85f);
        v0_1.close();
        v0_1.moveTo(19.65f, 2.91f);
        v0_1.lineToRelative(0.94f, 0.94f);
        v0_1.lineToRelative(-0.94f, 0.94f);
        v0_1.verticalLineTo(2.91f);
        v0_1.close();
        v0_1.moveTo(20.59f, 8.14f);
        v0_1.lineToRelative(-0.94f, 0.94f);
        v0_1.verticalLineTo(7.2f);
        v0_1.lineTo(20.59f, 8.14f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BluetoothDriveKt._bluetoothDrive = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

