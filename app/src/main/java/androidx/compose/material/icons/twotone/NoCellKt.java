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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noCell", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoCell", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNoCell", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoCellKt {
    private static ImageVector _noCell;

    static {
    }

    public static final ImageVector getNoCell(TwoTone arg19) {
        ImageVector v0 = NoCellKt._noCell;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.NoCell", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(7f, 21f);
        v0_1.horizontalLineToRelative(10f);
        v0_1.verticalLineToRelative(-1f);
        v0_1.horizontalLineTo(7f);
        v0_1.verticalLineTo(21f);
        v0_1.close();
        v0_1.moveTo(7f, 3f);
        v0_1.verticalLineToRelative(1f);
        v0_1.horizontalLineToRelative(10f);
        v0_1.verticalLineTo(3f);
        v0_1.horizontalLineTo(7f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 6f);
        v12.verticalLineToRelative(8.17f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -1.99f, -2f, -1.99f);
        v12.lineTo(7f, 1f);
        v12.curveTo(6.15f, 1f, 5.42f, 1.55f, 5.13f, 2.3f);
        v12.lineTo(8.83f, 6f);
        v12.horizontalLineTo(17f);
        v12.close();
        v12.moveTo(7f, 3f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(3f);
        v12.close();
        v12.moveTo(21.190001f, 21.190001f);
        v12.lineTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineTo(5f, 7.83f);
        v12.verticalLineTo(21f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(0.85f, 0f, 1.58f, -0.55f, 1.87f, -1.3f);
        v12.lineToRelative(0.91f, 0.91f);
        v12.lineTo(21.190001f, 21.190001f);
        v12.close();
        v12.moveTo(17f, 21f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineTo(21f);
        v12.close();
        v12.moveTo(7f, 18f);
        v12.verticalLineTo(9.83f);
        v12.lineTo(15.17f, 18f);
        v12.horizontalLineTo(7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoCellKt._noCell = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

