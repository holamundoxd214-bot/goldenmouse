package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_leaveBagsAtHome", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LeaveBagsAtHome", "Landroidx/compose/material/icons/Icons$Sharp;", "getLeaveBagsAtHome", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LeaveBagsAtHomeKt {
    private static ImageVector _leaveBagsAtHome;

    static {
    }

    public static final ImageVector getLeaveBagsAtHome(Sharp arg19) {
        ImageVector v0 = LeaveBagsAtHomeKt._leaveBagsAtHome;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.LeaveBagsAtHome", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.83f, 9f);
        v12.horizontalLineToRelative(0.92f);
        v12.verticalLineToRelative(0.92f);
        v12.lineToRelative(1.75f, 1.75f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(16f);
        v12.verticalLineToRelative(4.17f);
        v12.lineToRelative(3f, 3f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(8.83f);
        v12.lineTo(11.83f, 9f);
        v12.close();
        v12.moveTo(11f, 4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(4f);
        v12.close();
        v12.moveTo(21.190001f, 21.190001f);
        v12.lineTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineTo(5f, 7.83f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.horizontalLineToRelative(1.17f);
        v12.lineToRelative(1.61f, 1.61f);
        v12.lineTo(21.190001f, 21.190001f);
        v12.close();
        v12.moveTo(8f, 18f);
        v12.verticalLineToRelative(-7.17f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.verticalLineTo(18f);
        v12.horizontalLineTo(8f);
        v12.close();
        v12.moveTo(11.25f, 18f);
        v12.verticalLineToRelative(-3.92f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.verticalLineTo(18f);
        v12.horizontalLineTo(11.25f);
        v12.close();
        v12.moveTo(14.5f, 18f);
        v12.verticalLineToRelative(-0.67f);
        v12.lineTo(15.17f, 18f);
        v12.horizontalLineTo(14.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LeaveBagsAtHomeKt._leaveBagsAtHome = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

