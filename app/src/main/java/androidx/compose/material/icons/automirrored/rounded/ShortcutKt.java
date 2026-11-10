package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_shortcut", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Shortcut", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getShortcut", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ShortcutKt {
    private static ImageVector _shortcut;

    static {
    }

    public static final ImageVector getShortcut(Rounded arg19) {
        ImageVector v0 = ShortcutKt._shortcut;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.Shortcut", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.290001f, 10.29f);
        v12.lineToRelative(-3.59f, -3.59f);
        v12.curveTo(16.08f, 6.08f, 15f, 6.52f, 15f, 7.41f);
        v12.verticalLineTo(10f);
        v12.horizontalLineTo(8f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -1.65f, 1.35f, -3f, 3f, -3f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(2.59f);
        v12.curveToRelative(0f, 0.89f, 1.08f, 1.34f, 1.71f, 0.71f);
        v12.lineToRelative(3.59f, -3.59f);
        v12.curveTo(20.68f, 11.32f, 20.68f, 10.68f, 20.290001f, 10.29f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ShortcutKt._shortcut = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

