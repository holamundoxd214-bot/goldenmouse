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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_appBlocking", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AppBlocking", "Landroidx/compose/material/icons/Icons$Outlined;", "getAppBlocking", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AppBlockingKt {
    private static ImageVector _appBlocking;

    static {
    }

    public static final ImageVector getAppBlocking(Outlined arg19) {
        ImageVector v0 = AppBlockingKt._appBlocking;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AppBlocking", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 8f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.curveTo(22f, 9.79f, 20.209999f, 8f, 18f, 8f);
        v12.close();
        v12.moveTo(15.5f, 12f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.curveToRelative(0.42f, 0f, 0.8f, 0.11f, 1.15f, 0.29f);
        v12.lineToRelative(-3.36f, 3.36f);
        v12.curveTo(15.61f, 12.8f, 15.5f, 12.42f, 15.5f, 12f);
        v12.close();
        v12.moveTo(18f, 14.5f);
        v12.curveToRelative(-0.42f, 0f, -0.8f, -0.11f, -1.15f, -0.29f);
        v12.lineToRelative(3.36f, -3.36f);
        v12.curveToRelative(0.18f, 0.35f, 0.29f, 0.73f, 0.29f, 1.15f);
        v12.curveTo(20.5f, 13.38f, 19.379999f, 14.5f, 18f, 14.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 18f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(6f);
        v12.verticalLineTo(5f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(7f);
        v12.curveTo(5.9f, 1f, 5f, 1.9f, 5f, 3f);
        v12.verticalLineToRelative(18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-2f);
        v12.verticalLineToRelative(-1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(18f);
        v12.close();
        v12.moveTo(7f, 3f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(3f);
        v12.close();
        v12.moveTo(17f, 21f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineTo(21f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AppBlockingKt._appBlocking = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

