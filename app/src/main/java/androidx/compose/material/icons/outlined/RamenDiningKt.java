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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_ramenDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RamenDining", "Landroidx/compose/material/icons/Icons$Outlined;", "getRamenDining", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RamenDiningKt {
    private static ImageVector _ramenDining;

    static {
    }

    public static final ImageVector getRamenDining(Outlined arg19) {
        ImageVector v0 = RamenDiningKt._ramenDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.RamenDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.66f, 14f);
        v12.curveToRelative(-0.66f, 1.92f, -2.24f, 3.54f, -4.4f, 4.39f);
        v12.lineTo(14f, 18.889999f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-1.11f);
        v12.lineToRelative(-1.27f, -0.5f);
        v12.curveToRelative(-2.16f, -0.85f, -3.74f, -2.47f, -4.4f, -4.39f);
        v12.horizontalLineTo(19.66f);
        v12.moveTo(22f, 2f);
        v12.lineTo(4f, 3.99f);
        v12.verticalLineTo(12f);
        v12.horizontalLineTo(2f);
        v12.curveToRelative(0f, 3.69f, 2.47f, 6.86f, 6f, 8.25f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(-1.75f);
        v12.curveToRelative(3.53f, -1.39f, 6f, -4.56f, 6f, -8.25f);
        v12.horizontalLineTo(10.5f);
        v12.verticalLineTo(8f);
        v12.horizontalLineTo(22f);
        v12.verticalLineTo(6.5f);
        v12.horizontalLineTo(10.5f);
        v12.verticalLineTo(4.78f);
        v12.lineTo(22f, 3.51f);
        v12.verticalLineTo(2f);
        v12.lineTo(22f, 2f);
        v12.close();
        v12.moveTo(8f, 6.5f);
        v12.verticalLineTo(5.06f);
        v12.lineToRelative(1f, -0.11f);
        v12.verticalLineTo(6.5f);
        v12.horizontalLineTo(8f);
        v12.lineTo(8f, 6.5f);
        v12.close();
        v12.moveTo(5.5f, 6.5f);
        v12.verticalLineTo(5.34f);
        v12.lineToRelative(1f, -0.11f);
        v12.verticalLineTo(6.5f);
        v12.horizontalLineTo(5.5f);
        v12.lineTo(5.5f, 6.5f);
        v12.close();
        v12.moveTo(8f, 12f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(8f);
        v12.lineTo(8f, 12f);
        v12.close();
        v12.moveTo(5.5f, 12f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(5.5f);
        v12.lineTo(5.5f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RamenDiningKt._ramenDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

