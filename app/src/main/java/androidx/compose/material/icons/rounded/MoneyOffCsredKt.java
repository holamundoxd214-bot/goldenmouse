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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_moneyOffCsred", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MoneyOffCsred", "Landroidx/compose/material/icons/Icons$Rounded;", "getMoneyOffCsred", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MoneyOffCsredKt {
    private static ImageVector _moneyOffCsred;

    static {
    }

    public static final ImageVector getMoneyOffCsred(Rounded arg19) {
        ImageVector v0 = MoneyOffCsredKt._moneyOffCsred;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MoneyOffCsred", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.5f, 6.9f);
        v12.curveToRelative(1.42f, 0f, 2.13f, 0.54f, 2.39f, 1.4f);
        v12.curveToRelative(0.13f, 0.43f, 0.56f, 0.7f, 1.01f, 0.7f);
        v12.horizontalLineToRelative(0.06f);
        v12.curveToRelative(0.7f, 0f, 1.22f, -0.71f, 0.97f, -1.36f);
        v12.curveToRelative(-0.44f, -1.15f, -1.41f, -2.08f, -2.93f, -2.45f);
        v12.verticalLineTo(4.5f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(11f, 3.67f, 11f, 4.5f);
        v12.verticalLineToRelative(0.66f);
        v12.curveToRelative(-0.39f, 0.08f, -0.75f, 0.21f, -1.1f, 0.36f);
        v12.lineToRelative(1.51f, 1.51f);
        v12.curveToRelative(0.32f, -0.08f, 0.69f, -0.13f, 1.09f, -0.13f);
        v12.close();
        v12.moveTo(4.77f, 4.62f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(7.5f, 8.77f);
        v12.curveToRelative(0f, 2.08f, 1.56f, 3.22f, 3.91f, 3.91f);
        v12.lineToRelative(3.51f, 3.51f);
        v12.curveToRelative(-0.34f, 0.49f, -1.05f, 0.91f, -2.42f, 0.91f);
        v12.curveToRelative(-1.65f, 0f, -2.5f, -0.59f, -2.83f, -1.43f);
        v12.curveToRelative(-0.15f, -0.39f, -0.49f, -0.67f, -0.9f, -0.67f);
        v12.horizontalLineTo(8.6f);
        v12.curveToRelative(-0.72f, 0f, -1.24f, 0.74f, -0.95f, 1.39f);
        v12.curveToRelative(0.59f, 1.33f, 1.89f, 2.12f, 3.36f, 2.44f);
        v12.verticalLineToRelative(0.67f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-0.65f);
        v12.curveToRelative(0.96f, -0.18f, 1.83f, -0.55f, 2.46f, -1.12f);
        v12.lineToRelative(1.51f, 1.51f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(6.18f, 4.62f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MoneyOffCsredKt._moneyOffCsred = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

