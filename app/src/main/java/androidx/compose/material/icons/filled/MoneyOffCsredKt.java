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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_moneyOffCsred", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MoneyOffCsred", "Landroidx/compose/material/icons/Icons$Filled;", "getMoneyOffCsred", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MoneyOffCsredKt {
    private static ImageVector _moneyOffCsred;

    static {
    }

    public static final ImageVector getMoneyOffCsred(Filled arg19) {
        ImageVector v0 = MoneyOffCsredKt._moneyOffCsred;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.MoneyOffCsred", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.53f, 7.43f);
        v12.curveToRelative(0.42f, -0.31f, 0.93f, -0.47f, 1.54f, -0.47f);
        v12.reflectiveCurveToRelative(1.11f, 0.16f, 1.5f, 0.49f);
        v12.curveToRelative(0.39f, 0.32f, 0.65f, 0.7f, 0.79f, 1.12f);
        v12.lineToRelative(1.89f, -0.8f);
        v12.curveToRelative(-0.24f, -0.71f, -0.71f, -1.35f, -1.4f, -1.92f);
        v12.curveToRelative(-0.5f, -0.4f, -1.12f, -0.65f, -1.85f, -0.77f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2.11f);
        v12.curveToRelative(-0.41f, 0.08f, -0.79f, 0.21f, -1.14f, 0.39f);
        v12.curveToRelative(-0.35f, 0.18f, -0.64f, 0.39f, -0.9f, 0.63f);
        v12.lineToRelative(1.43f, 1.43f);
        v12.curveTo(10.43f, 7.52f, 10.48f, 7.47f, 10.53f, 7.43f);
        v12.close();
        v12.moveTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(12.35f, 12.35f);
        v12.curveTo(13.31f, 16.85f, 12.79f, 17f, 12.19f, 17f);
        v12.curveToRelative(-0.71f, 0f, -1.32f, -0.23f, -1.83f, -0.7f);
        v12.curveToRelative(-0.5f, -0.47f, -0.86f, -1.07f, -1.06f, -1.81f);
        v12.lineToRelative(-1.98f, 0.8f);
        v12.curveToRelative(0.34f, 1.17f, 0.95f, 2.08f, 1.83f, 2.73f);
        v12.curveToRelative(0.57f, 0.42f, 1.19f, 0.68f, 1.85f, 0.83f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2.08f);
        v12.curveToRelative(0.44f, -0.07f, 0.87f, -0.17f, 1.29f, -0.35f);
        v12.curveToRelative(0.34f, -0.14f, 0.64f, -0.32f, 0.92f, -0.53f);
        v12.lineToRelative(4.57f, 4.57f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.81f, 2.81f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MoneyOffCsredKt._moneyOffCsred = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

