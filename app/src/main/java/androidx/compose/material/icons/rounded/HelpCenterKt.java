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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_helpCenter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HelpCenter", "Landroidx/compose/material/icons/Icons$Rounded;", "getHelpCenter$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getHelpCenter", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HelpCenterKt {
    private static ImageVector _helpCenter;

    static {
    }

    public static final ImageVector getHelpCenter(Rounded arg19) {
        ImageVector v0 = HelpCenterKt._helpCenter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HelpCenter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(21f, 3.9f, 20.1f, 3f, 19f, 3f);
        v12.close();
        v12.moveTo(12.01f, 18f);
        v12.curveToRelative(-0.7f, 0f, -1.26f, -0.56f, -1.26f, -1.26f);
        v12.curveToRelative(0f, -0.71f, 0.56f, -1.25f, 1.26f, -1.25f);
        v12.curveToRelative(0.71f, 0f, 1.25f, 0.54f, 1.25f, 1.25f);
        v12.curveTo(13.25f, 17.43f, 12.72f, 18f, 12.01f, 18f);
        v12.close();
        v12.moveTo(15.02f, 10.6f);
        v12.curveToRelative(-0.76f, 1.11f, -1.48f, 1.46f, -1.87f, 2.17f);
        v12.curveToRelative(-0.1f, 0.18f, -0.16f, 0.32f, -0.19f, 0.63f);
        v12.curveToRelative(-0.05f, 0.45f, -0.45f, 0.78f, -0.9f, 0.78f);
        v12.horizontalLineTo(12f);
        v12.curveToRelative(-0.52f, 0f, -0.93f, -0.44f, -0.88f, -0.96f);
        v12.curveToRelative(0.03f, -0.34f, 0.11f, -0.69f, 0.3f, -1.03f);
        v12.curveToRelative(0.49f, -0.87f, 1.42f, -1.39f, 1.96f, -2.16f);
        v12.curveToRelative(0.57f, -0.81f, 0.25f, -2.33f, -1.37f, -2.33f);
        v12.curveToRelative(-0.71f, 0f, -1.18f, 0.36f, -1.47f, 0.79f);
        v12.curveToRelative(-0.25f, 0.36f, -0.69f, 0.53f, -1.1f, 0.36f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(8.91f, 8.64f, 8.72f, 8f, 9.04f, 7.54f);
        v12.curveTo(9.65f, 6.65f, 10.67f, 6f, 11.99f, 6f);
        v12.curveToRelative(1.48f, 0f, 2.49f, 0.67f, 3.01f, 1.52f);
        v12.curveTo(15.44f, 8.24f, 15.7f, 9.59f, 15.02f, 10.6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HelpCenterKt._helpCenter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.HelpCenter", replaceWith="<_subannotation>") public static void getHelpCenter$annotations(Rounded arg0) {
    }
}

