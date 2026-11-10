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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_installDesktop", "Landroidx/compose/ui/graphics/vector/ImageVector;", "InstallDesktop", "Landroidx/compose/material/icons/Icons$Filled;", "getInstallDesktop", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class InstallDesktopKt {
    private static ImageVector _installDesktop;

    static {
    }

    public static final ImageVector getInstallDesktop(Filled arg22) {
        ImageVector v0 = InstallDesktopKt._installDesktop;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.InstallDesktop", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 17f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(3f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.89f, 3f, 2f, 3.89f, 2f, 5f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(17f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(17f, 14f);
        v0_1.lineToRelative(5f, -5f);
        v0_1.lineToRelative(-1.41f, -1.41f);
        v0_1.lineToRelative(-2.59f, 2.58f);
        v0_1.lineToRelative(0f, -7.17f);
        v0_1.lineToRelative(-2f, 0f);
        v0_1.lineToRelative(0f, 7.17f);
        v0_1.lineToRelative(-2.59f, -2.58f);
        v0_1.lineToRelative(-1.41f, 1.41f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        InstallDesktopKt._installDesktop = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

