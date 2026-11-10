package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dinnerDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DinnerDining", "Landroidx/compose/material/icons/Icons$Filled;", "getDinnerDining", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DinnerDiningKt {
    private static ImageVector _dinnerDining;

    static {
    }

    public static final ImageVector getDinnerDining(Filled arg19) {
        ImageVector v0 = DinnerDiningKt._dinnerDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.DinnerDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2f, 19f);
        v12.horizontalLineToRelative(20f);
        v12.lineToRelative(-2f, 2f);
        v12.horizontalLineTo(4f);
        v12.lineTo(2f, 19f);
        v12.close();
        v12.moveTo(5f, 6f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(5f, 4f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(4f);
        v12.close();
        v12.moveTo(9f, 4f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(9f);
        v12.close();
        v12.moveTo(9f, 7f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(6f, 15.23f);
        v12.curveToRelative(-0.36f, 0.11f, -0.69f, 0.28f, -1f, 0.47f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(15.23f);
        v12.close();
        v12.moveTo(4f, 16.52f);
        v12.curveTo(3.62f, 16.959999f, 3.32f, 17.450001f, 3.16f, 18f);
        v12.horizontalLineToRelative(16.82f);
        v12.curveToRelative(0.01f, -0.16f, 0.03f, -0.33f, 0.03f, -0.5f);
        v12.curveToRelative(0f, -3.04f, -2.46f, -5.5f, -5.5f, -5.5f);
        v12.curveToRelative(-2.29f, 0f, -4.25f, 1.4f, -5.08f, 3.4f);
        v12.curveTo(8.84f, 15.15f, 8.19f, 15f, 7.5f, 15f);
        v12.curveToRelative(-0.17f, 0f, -0.33f, 0.02f, -0.5f, 0.04f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(1.03f, 0.06f, 1.9f, -0.96f, 2f, -2f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineTo(5f);
        v12.horizontalLineTo(11f);
        v12.curveToRelative(-0.1f, -1.05f, -0.97f, -1.97f, -2f, -2f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(16.52f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DinnerDiningKt._dinnerDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

