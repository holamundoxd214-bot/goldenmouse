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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_currencyLira", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CurrencyLira", "Landroidx/compose/material/icons/Icons$Rounded;", "getCurrencyLira", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CurrencyLiraKt {
    private static ImageVector _currencyLira;

    static {
    }

    public static final ImageVector getCurrencyLira(Rounded arg19) {
        ImageVector v0 = CurrencyLiraKt._currencyLira;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CurrencyLira", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 15.84f);
        v12.lineToRelative(-1.47f, 0.92f);
        v12.curveTo(6.86f, 17.18f, 6f, 16.700001f, 6f, 15.91f);
        v12.curveToRelative(0f, -0.34f, 0.18f, -0.66f, 0.47f, -0.85f);
        v12.lineTo(9f, 13.48f);
        v12.verticalLineToRelative(-2.36f);
        v12.lineToRelative(-1.47f, 0.92f);
        v12.curveTo(6.86f, 12.46f, 6f, 11.98f, 6f, 11.19f);
        v12.curveToRelative(0f, -0.34f, 0.18f, -0.66f, 0.47f, -0.85f);
        v12.lineTo(9f, 8.76f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(3.51f);
        v12.lineToRelative(2.47f, -1.55f);
        v12.curveTo(14.14f, 5.54f, 15f, 6.02f, 15f, 6.81f);
        v12.curveToRelative(0f, 0.34f, -0.18f, 0.66f, -0.47f, 0.85f);
        v12.lineTo(11f, 9.87f);
        v12.lineToRelative(0.01f, 2.35f);
        v12.lineToRelative(2.46f, -1.54f);
        v12.curveToRelative(0.67f, -0.42f, 1.53f, 0.06f, 1.53f, 0.85f);
        v12.curveToRelative(0f, 0.34f, -0.18f, 0.66f, -0.47f, 0.85f);
        v12.lineTo(11f, 14.59f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(2.47f, 0f, 4.52f, -1.79f, 4.93f, -4.15f);
        v12.curveToRelative(0.08f, -0.49f, 0.49f, -0.85f, 0.98f, -0.85f);
        v12.curveToRelative(0.61f, 0f, 1.09f, 0.54f, 1f, 1.14f);
        v12.curveTo(17.370001f, 18.459999f, 14.48f, 21f, 11f, 21f);
        v12.horizontalLineToRelative(-1f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(15.84f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CurrencyLiraKt._currencyLira = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

