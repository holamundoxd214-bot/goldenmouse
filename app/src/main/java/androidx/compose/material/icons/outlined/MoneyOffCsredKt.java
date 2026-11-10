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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_moneyOffCsred", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MoneyOffCsred", "Landroidx/compose/material/icons/Icons$Outlined;", "getMoneyOffCsred", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MoneyOffCsredKt {
    private static ImageVector _moneyOffCsred;

    static {
    }

    public static final ImageVector getMoneyOffCsred(Outlined arg19) {
        ImageVector v0 = MoneyOffCsredKt._moneyOffCsred;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.MoneyOffCsred", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.5f, 6.9f);
        v12.curveToRelative(1.78f, 0f, 2.44f, 0.85f, 2.5f, 2.1f);
        v12.horizontalLineToRelative(2.21f);
        v12.curveToRelative(-0.07f, -1.72f, -1.12f, -3.3f, -3.21f, -3.81f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(2.16f);
        v12.curveToRelative(-0.39f, 0.08f, -0.75f, 0.21f, -1.1f, 0.36f);
        v12.lineToRelative(1.51f, 1.51f);
        v12.curveToRelative(0.32f, -0.08f, 0.69f, -0.13f, 1.09f, -0.13f);
        v12.close();
        v12.moveTo(5.47f, 3.92f);
        v12.lineTo(4.06f, 5.33f);
        v12.lineTo(7.5f, 8.77f);
        v12.curveToRelative(0f, 2.08f, 1.56f, 3.22f, 3.91f, 3.91f);
        v12.lineToRelative(3.51f, 3.51f);
        v12.curveToRelative(-0.34f, 0.49f, -1.05f, 0.91f, -2.42f, 0.91f);
        v12.curveToRelative(-2.06f, 0f, -2.87f, -0.92f, -2.98f, -2.1f);
        v12.horizontalLineToRelative(-2.2f);
        v12.curveToRelative(0.12f, 2.19f, 1.76f, 3.42f, 3.68f, 3.83f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2.15f);
        v12.curveToRelative(0.96f, -0.18f, 1.83f, -0.55f, 2.46f, -1.12f);
        v12.lineToRelative(2.22f, 2.22f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(5.47f, 3.92f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MoneyOffCsredKt._moneyOffCsred = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

