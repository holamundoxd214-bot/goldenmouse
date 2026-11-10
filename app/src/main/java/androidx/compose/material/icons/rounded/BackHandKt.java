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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_backHand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BackHand", "Landroidx/compose/material/icons/Icons$Rounded;", "getBackHand", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BackHandKt {
    private static ImageVector _backHand;

    static {
    }

    public static final ImageVector getBackHand(Rounded arg19) {
        ImageVector v0 = BackHandKt._backHand;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.BackHand", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 16f);
        v12.curveToRelative(0f, 4.42f, -3.58f, 8f, -8f, 8f);
        v12.curveToRelative(-3.26f, 0f, -6.19f, -1.99f, -7.4f, -5.02f);
        v12.lineToRelative(-3.03f, -7.61f);
        v12.curveTo(2.26f, 10.58f, 3f, 9.79f, 3.81f, 10.05f);
        v12.lineToRelative(0.79f, 0.26f);
        v12.curveToRelative(0.56f, 0.18f, 1.02f, 0.61f, 1.24f, 1.16f);
        v12.lineToRelative(1.28f, 3.21f);
        v12.curveTo(7.2f, 14.88f, 7.38f, 15f, 7.58f, 15f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(3.25f);
        v12.curveTo(8f, 2.56f, 8.56f, 2f, 9.25f, 2f);
        v12.reflectiveCurveToRelative(1.25f, 0.56f, 1.25f, 1.25f);
        v12.verticalLineToRelative(8.25f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.verticalLineTo(1.25f);
        v12.curveTo(11.5f, 0.56f, 12.06f, 0f, 12.75f, 0f);
        v12.reflectiveCurveTo(14f, 0.56f, 14f, 1.25f);
        v12.verticalLineTo(11.5f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.verticalLineTo(2.75f);
        v12.curveToRelative(0f, -0.69f, 0.56f, -1.25f, 1.25f, -1.25f);
        v12.curveToRelative(0.69f, 0f, 1.25f, 0.56f, 1.25f, 1.25f);
        v12.verticalLineToRelative(8.75f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.verticalLineTo(5.75f);
        v12.curveToRelative(0f, -0.69f, 0.56f, -1.25f, 1.25f, -1.25f);
        v12.reflectiveCurveTo(21f, 5.06f, 21f, 5.75f);
        v12.verticalLineTo(16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BackHandKt._backHand = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

