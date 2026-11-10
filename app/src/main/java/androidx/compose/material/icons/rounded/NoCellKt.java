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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noCell", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoCell", "Landroidx/compose/material/icons/Icons$Rounded;", "getNoCell", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoCellKt {
    private static ImageVector _noCell;

    static {
    }

    public static final ImageVector getNoCell(Rounded arg19) {
        ImageVector v0 = NoCellKt._noCell;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NoCell", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.83f, 6f);
        v12.lineToRelative(-3.7f, -3.7f);
        v12.curveTo(5.42f, 1.55f, 6.15f, 1f, 7f, 1f);
        v12.lineToRelative(10f, 0.01f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.89f, 2f, 1.99f);
        v12.verticalLineToRelative(13.17f);
        v12.lineToRelative(-2f, -2f);
        v12.verticalLineTo(6f);
        v12.horizontalLineTo(8.83f);
        v12.close();
        v12.moveTo(20.49f, 21.9f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(-0.2f, -0.2f);
        v12.curveTo(18.58f, 22.450001f, 17.85f, 23f, 17f, 23f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(7.83f);
        v12.lineToRelative(-2.9f, -2.9f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(16.969999f, 16.969999f);
        v12.curveTo(20.879999f, 20.879999f, 20.879999f, 21.51f, 20.49f, 21.9f);
        v12.close();
        v12.moveTo(15.17f, 18f);
        v12.lineTo(7f, 9.83f);
        v12.verticalLineTo(18f);
        v12.horizontalLineTo(15.17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoCellKt._noCell = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

