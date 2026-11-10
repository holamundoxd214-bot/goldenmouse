package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_driveEta", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DriveEta", "Landroidx/compose/material/icons/Icons$Rounded;", "getDriveEta", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DriveEtaKt {
    private static ImageVector _driveEta;

    static {
    }

    public static final ImageVector getDriveEta(Rounded arg19) {
        ImageVector v0 = DriveEtaKt._driveEta;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DriveEta", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.92f, 5.01f);
        v12.curveTo(18.719999f, 4.42f, 18.16f, 4f, 17.5f, 4f);
        v12.horizontalLineToRelative(-11f);
        v12.curveToRelative(-0.66f, 0f, -1.21f, 0.42f, -1.42f, 1.01f);
        v12.lineToRelative(-1.97f, 5.67f);
        v12.curveToRelative(-0.07f, 0.21f, -0.11f, 0.43f, -0.11f, 0.66f);
        v12.verticalLineToRelative(7.16f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(6f, 19.33f, 6f, 18.5f);
        v12.lineTo(6f, 18f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(0.5f);
        v12.curveToRelative(0f, 0.82f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.curveToRelative(0.82f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-7.16f);
        v12.curveToRelative(0f, -0.22f, -0.04f, -0.45f, -0.11f, -0.66f);
        v12.lineToRelative(-1.97f, -5.67f);
        v12.close();
        v12.moveTo(6.5f, 15f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(5.67f, 12f, 6.5f, 12f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(7.33f, 15f, 6.5f, 15f);
        v12.close();
        v12.moveTo(17.5f, 15f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f);
        v12.close();
        v12.moveTo(5f, 10f);
        v12.lineToRelative(1.27f, -3.82f);
        v12.curveToRelative(0.14f, -0.4f, 0.52f, -0.68f, 0.95f, -0.68f);
        v12.horizontalLineToRelative(9.56f);
        v12.curveToRelative(0.43f, 0f, 0.81f, 0.28f, 0.95f, 0.68f);
        v12.lineTo(19f, 10f);
        v12.lineTo(5f, 10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DriveEtaKt._driveEta = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

