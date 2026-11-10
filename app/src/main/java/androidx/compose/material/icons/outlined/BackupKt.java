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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_backup", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Backup", "Landroidx/compose/material/icons/Icons$Outlined;", "getBackup", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BackupKt {
    private static ImageVector _backup;

    static {
    }

    public static final ImageVector getBackup(Outlined arg19) {
        ImageVector v0 = BackupKt._backup;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Backup", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.35f, 10.04f);
        v12.curveTo(18.67f, 6.59f, 15.64f, 4f, 12f, 4f);
        v12.curveTo(9.11f, 4f, 6.6f, 5.64f, 5.35f, 8.04f);
        v12.curveTo(2.34f, 8.36f, 0f, 10.91f, 0f, 14f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.horizontalLineToRelative(13f);
        v12.curveToRelative(2.76f, 0f, 5f, -2.24f, 5f, -5f);
        v12.curveToRelative(0f, -2.64f, -2.05f, -4.78f, -4.65f, -4.96f);
        v12.close();
        v12.moveTo(19f, 18f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.curveToRelative(0f, -2.05f, 1.53f, -3.76f, 3.56f, -3.97f);
        v12.lineToRelative(1.07f, -0.11f);
        v12.lineToRelative(0.5f, -0.95f);
        v12.curveTo(8.08f, 7.14f, 9.94f, 6f, 12f, 6f);
        v12.curveToRelative(2.62f, 0f, 4.88f, 1.86f, 5.39f, 4.43f);
        v12.lineToRelative(0.3f, 1.5f);
        v12.lineToRelative(1.53f, 0.11f);
        v12.curveToRelative(1.56f, 0.1f, 2.78f, 1.41f, 2.78f, 2.96f);
        v12.curveToRelative(0f, 1.65f, -1.35f, 3f, -3f, 3f);
        v12.close();
        v12.moveTo(8f, 13f);
        v12.horizontalLineToRelative(2.55f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2.9f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineTo(16f);
        v12.lineToRelative(-4f, -4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BackupKt._backup = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

