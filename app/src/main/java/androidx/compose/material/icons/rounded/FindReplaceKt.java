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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_findReplace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FindReplace", "Landroidx/compose/material/icons/Icons$Rounded;", "getFindReplace", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FindReplaceKt {
    private static ImageVector _findReplace;

    static {
    }

    public static final ImageVector getFindReplace(Rounded arg19) {
        ImageVector v0 = FindReplaceKt._findReplace;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FindReplace", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 6f);
        v12.curveToRelative(1.38f, 0f, 2.63f, 0.56f, 3.54f, 1.46f);
        v12.lineToRelative(-1.69f, 1.69f);
        v12.curveToRelative(-0.31f, 0.31f, -0.09f, 0.85f, 0.36f, 0.85f);
        v12.horizontalLineToRelative(4.29f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.lineTo(18f, 5.21f);
        v12.curveToRelative(0f, -0.45f, -0.54f, -0.67f, -0.85f, -0.35f);
        v12.lineToRelative(-1.2f, 1.2f);
        v12.curveTo(14.68f, 4.78f, 12.93f, 4f, 11f, 4f);
        v12.curveTo(7.96f, 4f, 5.38f, 5.94f, 4.42f, 8.64f);
        v12.curveToRelative(-0.24f, 0.66f, 0.23f, 1.36f, 0.93f, 1.36f);
        v12.curveToRelative(0.42f, 0f, 0.79f, -0.26f, 0.93f, -0.66f);
        v12.curveTo(6.96f, 7.4f, 8.82f, 6f, 11f, 6f);
        v12.close();
        v12.moveTo(16.639999f, 15.14f);
        v12.curveToRelative(0.4f, -0.54f, 0.72f, -1.15f, 0.95f, -1.8f);
        v12.curveToRelative(0.23f, -0.65f, -0.25f, -1.34f, -0.94f, -1.34f);
        v12.curveToRelative(-0.42f, 0f, -0.79f, 0.26f, -0.93f, 0.66f);
        v12.curveTo(15.04f, 14.6f, 13.18f, 16f, 11f, 16f);
        v12.curveToRelative(-1.38f, 0f, -2.63f, -0.56f, -3.54f, -1.46f);
        v12.lineToRelative(1.69f, -1.69f);
        v12.curveToRelative(0.31f, -0.31f, 0.09f, -0.85f, -0.36f, -0.85f);
        v12.lineTo(4.5f, 12f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.verticalLineToRelative(4.29f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        v12.lineToRelative(1.2f, -1.2f);
        v12.curveTo(7.32f, 17.219999f, 9.07f, 18f, 11f, 18f);
        v12.curveToRelative(1.55f, 0f, 2.98f, -0.51f, 4.14f, -1.36f);
        v12.lineToRelative(4.11f, 4.11f);
        v12.curveToRelative(0.41f, 0.41f, 1.08f, 0.41f, 1.49f, 0f);
        v12.curveToRelative(0.41f, -0.41f, 0.41f, -1.08f, 0f, -1.49f);
        v12.lineToRelative(-4.1f, -4.12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FindReplaceKt._findReplace = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

