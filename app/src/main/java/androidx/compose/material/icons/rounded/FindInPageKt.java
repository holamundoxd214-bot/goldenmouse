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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_findInPage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FindInPage", "Landroidx/compose/material/icons/Icons$Rounded;", "getFindInPage", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FindInPageKt {
    private static ImageVector _findInPage;

    static {
    }

    public static final ImageVector getFindInPage(Rounded arg19) {
        ImageVector v0 = FindInPageKt._findInPage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FindInPage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 19.59f);
        v12.verticalLineTo(8.83f);
        v12.curveToRelative(0f, -0.53f, -0.21f, -1.04f, -0.59f, -1.41f);
        v12.lineToRelative(-4.83f, -4.83f);
        v12.curveToRelative(-0.37f, -0.38f, -0.88f, -0.59f, -1.41f, -0.59f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
        v12.lineTo(4f, 20f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 1.99f, 2f);
        v12.horizontalLineTo(18f);
        v12.curveToRelative(0.45f, 0f, 0.85f, -0.15f, 1.19f, -0.4f);
        v12.lineToRelative(-4.43f, -4.43f);
        v12.curveToRelative(-0.86f, 0.56f, -1.89f, 0.88f, -3f, 0.82f);
        v12.curveToRelative(-2.37f, -0.11f, -4.4f, -1.96f, -4.72f, -4.31f);
        v12.curveToRelative(-0.44f, -3.35f, 2.45f, -6.18f, 5.83f, -5.61f);
        v12.curveToRelative(1.95f, 0.33f, 3.57f, 1.85f, 4f, 3.78f);
        v12.curveToRelative(0.33f, 1.46f, 0.01f, 2.82f, -0.7f, 3.9f);
        v12.lineTo(20f, 19.59f);
        v12.close();
        v12.moveTo(9f, 13f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.34f, 3f, -3f);
        v12.reflectiveCurveToRelative(-1.34f, -3f, -3f, -3f);
        v12.reflectiveCurveToRelative(-3f, 1.34f, -3f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FindInPageKt._findInPage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

