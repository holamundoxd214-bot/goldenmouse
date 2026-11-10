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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_driveFileRenameOutline", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DriveFileRenameOutline", "Landroidx/compose/material/icons/Icons$Filled;", "getDriveFileRenameOutline", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DriveFileRenameOutlineKt {
    private static ImageVector _driveFileRenameOutline;

    static {
    }

    public static final ImageVector getDriveFileRenameOutline(Filled arg19) {
        ImageVector v0 = DriveFileRenameOutlineKt._driveFileRenameOutline;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.DriveFileRenameOutline", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.41f, 5.8f);
        v12.lineTo(17.200001f, 4.59f);
        v12.curveToRelative(-0.78f, -0.78f, -2.05f, -0.78f, -2.83f, 0f);
        v12.lineToRelative(-2.68f, 2.68f);
        v12.lineTo(3f, 15.96f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(4.04f);
        v12.lineToRelative(8.74f, -8.74f);
        v12.lineToRelative(2.63f, -2.63f);
        v12.curveToRelative(0.79f, -0.78f, 0.79f, -2.05f, 0f, -2.83f);
        v12.close();
        v12.moveTo(6.21f, 18f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-1.21f);
        v12.lineToRelative(8.66f, -8.66f);
        v12.lineToRelative(1.21f, 1.21f);
        v12.lineTo(6.21f, 18f);
        v12.close();
        v12.moveTo(11f, 20f);
        v12.lineToRelative(4f, -4f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DriveFileRenameOutlineKt._driveFileRenameOutline = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

