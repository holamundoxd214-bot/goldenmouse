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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_arrowCircleRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowCircleRight", "Landroidx/compose/material/icons/Icons$Outlined;", "getArrowCircleRight", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ArrowCircleRightKt {
    private static ImageVector _arrowCircleRight;

    static {
    }

    public static final ImageVector getArrowCircleRight(Outlined arg19) {
        ImageVector v0 = ArrowCircleRightKt._arrowCircleRight;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.ArrowCircleRight", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 12f);
        v12.curveToRelative(0f, -5.52f, -4.48f, -10f, -10f, -10f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f);
        v12.close();
        v12.moveTo(4f, 12f);
        v12.curveToRelative(0f, -4.42f, 3.58f, -8f, 8f, -8f);
        v12.curveToRelative(4.42f, 0f, 8f, 3.58f, 8f, 8f);
        v12.reflectiveCurveToRelative(-3.58f, 8f, -8f, 8f);
        v12.curveTo(7.58f, 20f, 4f, 16.42f, 4f, 12f);
        v12.close();
        v12.moveTo(16f, 12f);
        v12.lineToRelative(-4f, 4f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineTo(12.17f, 13f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(4.17f);
        v12.lineToRelative(-1.59f, -1.59f);
        v12.lineTo(12f, 8f);
        v12.lineTo(16f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ArrowCircleRightKt._arrowCircleRight = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

