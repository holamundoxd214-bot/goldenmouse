package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_squareFoot", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SquareFoot", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSquareFoot", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SquareFootKt {
    private static ImageVector _squareFoot;

    static {
    }

    public static final ImageVector getSquareFoot(TwoTone arg22) {
        ImageVector v0 = SquareFootKt._squareFoot;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.SquareFoot", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(7f, 17f);
        v0_1.lineToRelative(5.76f, 0f);
        v0_1.lineToRelative(-5.76f, -5.76f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.66f, 17.66f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineToRelative(-1.94f, -1.94f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineToRelative(-1.94f, -1.94f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(9.7f, 9.7f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(7.05f, 7.05f);
        v12.lineTo(5.99f, 8.11f);
        v12.lineTo(5.28f, 7.4f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(4f, 4f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.lineTo(17.66f, 17.66f);
        v12.close();
        v12.moveTo(7f, 17f);
        v12.verticalLineToRelative(-5.76f);
        v12.lineTo(12.76f, 17f);
        v12.horizontalLineTo(7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SquareFootKt._squareFoot = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

