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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_findReplace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FindReplace", "Landroidx/compose/material/icons/Icons$Outlined;", "getFindReplace", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FindReplaceKt {
    private static ImageVector _findReplace;

    static {
    }

    public static final ImageVector getFindReplace(Outlined arg19) {
        ImageVector v0 = FindReplaceKt._findReplace;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.FindReplace", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 6f);
        v12.curveToRelative(1.38f, 0f, 2.63f, 0.56f, 3.54f, 1.46f);
        v12.lineTo(12f, 10f);
        v12.horizontalLineToRelative(6f);
        v12.lineTo(18f, 4f);
        v12.lineToRelative(-2.05f, 2.05f);
        v12.curveTo(14.68f, 4.78f, 12.93f, 4f, 11f, 4f);
        v12.curveToRelative(-3.53f, 0f, -6.43f, 2.61f, -6.92f, 6f);
        v12.lineTo(6.1f, 10f);
        v12.curveToRelative(0.46f, -2.28f, 2.48f, -4f, 4.9f, -4f);
        v12.close();
        v12.moveTo(16.639999f, 15.14f);
        v12.curveToRelative(0.66f, -0.9f, 1.12f, -1.97f, 1.28f, -3.14f);
        v12.lineTo(15.9f, 12f);
        v12.curveToRelative(-0.46f, 2.28f, -2.48f, 4f, -4.9f, 4f);
        v12.curveToRelative(-1.38f, 0f, -2.63f, -0.56f, -3.54f, -1.46f);
        v12.lineTo(10f, 12f);
        v12.lineTo(4f, 12f);
        v12.verticalLineToRelative(6f);
        v12.lineToRelative(2.05f, -2.05f);
        v12.curveTo(7.32f, 17.219999f, 9.07f, 18f, 11f, 18f);
        v12.curveToRelative(1.55f, 0f, 2.98f, -0.51f, 4.14f, -1.36f);
        v12.lineTo(20f, 21.49f);
        v12.lineTo(21.49f, 20f);
        v12.lineToRelative(-4.85f, -4.86f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FindReplaceKt._findReplace = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

