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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_findInPage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FindInPage", "Landroidx/compose/material/icons/Icons$Outlined;", "getFindInPage", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FindInPageKt {
    private static ImageVector _findInPage;

    static {
    }

    public static final ImageVector getFindInPage(Outlined arg19) {
        ImageVector v0 = FindInPageKt._findInPage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.FindInPage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 2f);
        v12.lineTo(6f, 2f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
        v12.lineTo(4f, 20f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 1.99f, 2f);
        v12.lineTo(18f, 22f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(20f, 8f);
        v12.lineToRelative(-6f, -6f);
        v12.close();
        v12.moveTo(6f, 4f);
        v12.horizontalLineToRelative(7f);
        v12.lineToRelative(5f, 5f);
        v12.verticalLineToRelative(8.58f);
        v12.lineToRelative(-1.84f, -1.84f);
        v12.curveToRelative(1.28f, -1.94f, 1.07f, -4.57f, -0.64f, -6.28f);
        v12.curveTo(14.55f, 8.49f, 13.28f, 8f, 12f, 8f);
        v12.curveToRelative(-1.28f, 0f, -2.55f, 0.49f, -3.53f, 1.46f);
        v12.curveToRelative(-1.95f, 1.95f, -1.95f, 5.11f, 0f, 7.05f);
        v12.curveToRelative(0.97f, 0.97f, 2.25f, 1.46f, 3.53f, 1.46f);
        v12.curveToRelative(0.96f, 0f, 1.92f, -0.28f, 2.75f, -0.83f);
        v12.lineTo(17.6f, 20f);
        v12.lineTo(6f, 20f);
        v12.lineTo(6f, 4f);
        v12.close();
        v12.moveTo(14.11f, 15.1f);
        v12.curveToRelative(-0.56f, 0.56f, -1.31f, 0.88f, -2.11f, 0.88f);
        v12.reflectiveCurveToRelative(-1.55f, -0.31f, -2.11f, -0.88f);
        v12.curveToRelative(-0.56f, -0.56f, -0.88f, -1.31f, -0.88f, -2.11f);
        v12.reflectiveCurveToRelative(0.31f, -1.55f, 0.88f, -2.11f);
        v12.curveToRelative(0.56f, -0.57f, 1.31f, -0.88f, 2.11f, -0.88f);
        v12.reflectiveCurveToRelative(1.55f, 0.31f, 2.11f, 0.88f);
        v12.curveToRelative(0.56f, 0.56f, 0.88f, 1.31f, 0.88f, 2.11f);
        v12.reflectiveCurveToRelative(-0.31f, 1.55f, -0.88f, 2.11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FindInPageKt._findInPage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

