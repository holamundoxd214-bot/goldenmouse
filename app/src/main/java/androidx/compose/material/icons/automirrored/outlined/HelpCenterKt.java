package androidx.compose.material.icons.automirrored.outlined;

import androidx.compose.material.icons.Icons$AutoMirrored$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_helpCenter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HelpCenter", "Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;", "getHelpCenter", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HelpCenterKt {
    private static ImageVector _helpCenter;

    static {
    }

    public static final ImageVector getHelpCenter(Outlined arg19) {
        ImageVector v0 = HelpCenterKt._helpCenter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Outlined.HelpCenter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.25f, 16.74f);
        v12.curveToRelative(0f, 0.69f, -0.53f, 1.26f, -1.25f, 1.26f);
        v12.curveToRelative(-0.7f, 0f, -1.26f, -0.56f, -1.26f, -1.26f);
        v12.curveToRelative(0f, -0.71f, 0.56f, -1.25f, 1.26f, -1.25f);
        v12.curveTo(12.71f, 15.49f, 13.25f, 16.040001f, 13.25f, 16.74f);
        v12.close();
        v12.moveTo(11.99f, 6f);
        v12.curveToRelative(-1.77f, 0f, -2.98f, 1.15f, -3.43f, 2.49f);
        v12.lineToRelative(1.64f, 0.69f);
        v12.curveToRelative(0.22f, -0.67f, 0.74f, -1.48f, 1.8f, -1.48f);
        v12.curveToRelative(1.62f, 0f, 1.94f, 1.52f, 1.37f, 2.33f);
        v12.curveToRelative(-0.54f, 0.77f, -1.47f, 1.29f, -1.96f, 2.16f);
        v12.curveToRelative(-0.39f, 0.69f, -0.31f, 1.49f, -0.31f, 1.98f);
        v12.horizontalLineToRelative(1.82f);
        v12.curveToRelative(0f, -0.93f, 0.07f, -1.12f, 0.22f, -1.41f);
        v12.curveToRelative(0.39f, -0.72f, 1.11f, -1.06f, 1.87f, -2.17f);
        v12.curveToRelative(0.68f, -1f, 0.42f, -2.36f, -0.02f, -3.08f);
        v12.curveTo(14.48f, 6.67f, 13.47f, 6f, 11.99f, 6f);
        v12.close();
        v12.moveTo(19f, 5f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineTo(5f);
        v12.moveTo(19f, 3f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineTo(5f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineTo(19f);
        v12.lineTo(19f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HelpCenterKt._helpCenter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

