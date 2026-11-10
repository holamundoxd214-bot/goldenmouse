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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_appShortcut", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AppShortcut", "Landroidx/compose/material/icons/Icons$Rounded;", "getAppShortcut", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AppShortcutKt {
    private static ImageVector _appShortcut;

    static {
    }

    public static final ImageVector getAppShortcut(Rounded arg19) {
        ImageVector v0 = AppShortcutKt._appShortcut;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AppShortcut", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 18f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(7f);
        v12.curveTo(5.9f, 1f, 5f, 1.9f, 5f, 3f);
        v12.verticalLineToRelative(18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(18f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20.379999f, 9.62f);
        v12.lineToRelative(0.4f, 0.87f);
        v12.curveToRelative(0.09f, 0.2f, 0.37f, 0.2f, 0.46f, 0f);
        v12.lineToRelative(0.4f, -0.87f);
        v12.lineToRelative(0.87f, -0.4f);
        v12.curveToRelative(0.2f, -0.09f, 0.2f, -0.37f, 0f, -0.46f);
        v12.lineToRelative(-0.87f, -0.4f);
        v12.lineToRelative(-0.4f, -0.87f);
        v12.curveToRelative(-0.09f, -0.2f, -0.37f, -0.2f, -0.46f, 0f);
        v12.lineToRelative(-0.4f, 0.87f);
        v12.lineToRelative(-0.87f, 0.4f);
        v12.curveToRelative(-0.2f, 0.09f, -0.2f, 0.37f, 0f, 0.46f);
        v12.lineTo(20.379999f, 9.62f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15.54f, 9f);
        v12.lineToRelative(-0.79f, 1.75f);
        v12.lineTo(13f, 11.54f);
        v12.curveToRelative(-0.39f, 0.18f, -0.39f, 0.73f, 0f, 0.91f);
        v12.lineToRelative(1.75f, 0.79f);
        v12.lineTo(15.54f, 15f);
        v12.curveToRelative(0.18f, 0.39f, 0.73f, 0.39f, 0.91f, 0f);
        v12.lineToRelative(0.79f, -1.75f);
        v12.lineTo(19f, 12.46f);
        v12.curveToRelative(0.39f, -0.18f, 0.39f, -0.73f, 0f, -0.91f);
        v12.lineToRelative(-1.75f, -0.79f);
        v12.lineTo(16.459999f, 9f);
        v12.curveTo(16.280001f, 8.61f, 15.72f, 8.61f, 15.54f, 9f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20.77f, 13.5f);
        v12.lineToRelative(-0.4f, 0.87f);
        v12.lineToRelative(-0.87f, 0.4f);
        v12.curveToRelative(-0.2f, 0.09f, -0.2f, 0.37f, 0f, 0.46f);
        v12.lineToRelative(0.87f, 0.4f);
        v12.lineToRelative(0.4f, 0.87f);
        v12.curveToRelative(0.09f, 0.2f, 0.37f, 0.2f, 0.46f, 0f);
        v12.lineToRelative(0.4f, -0.87f);
        v12.lineToRelative(0.87f, -0.4f);
        v12.curveToRelative(0.2f, -0.09f, 0.2f, -0.37f, 0f, -0.46f);
        v12.lineToRelative(-0.87f, -0.4f);
        v12.lineToRelative(-0.4f, -0.87f);
        v12.curveTo(21.139999f, 13.31f, 20.860001f, 13.31f, 20.77f, 13.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AppShortcutKt._appShortcut = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

