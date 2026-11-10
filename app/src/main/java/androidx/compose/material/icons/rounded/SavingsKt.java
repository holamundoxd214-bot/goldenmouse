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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_savings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Savings", "Landroidx/compose/material/icons/Icons$Rounded;", "getSavings", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SavingsKt {
    private static ImageVector _savings;

    static {
    }

    public static final ImageVector getSavings(Rounded arg19) {
        ImageVector v0 = SavingsKt._savings;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Savings", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.83f, 7.5f);
        v12.lineToRelative(-2.27f, -2.27f);
        v12.curveToRelative(0.07f, -0.42f, 0.18f, -0.81f, 0.32f, -1.15f);
        v12.curveToRelative(0.11f, -0.26f, 0.15f, -0.56f, 0.09f, -0.87f);
        v12.curveTo(17.84f, 2.49f, 17.139999f, 1.99f, 16.4f, 2f);
        v12.curveToRelative(-1.59f, 0.03f, -3f, 0.81f, -3.9f, 2f);
        v12.lineToRelative(-5f, 0f);
        v12.curveTo(4.46f, 4f, 2f, 6.46f, 2f, 9.5f);
        v12.curveToRelative(0f, 2.25f, 1.37f, 7.48f, 2.08f, 10.04f);
        v12.curveTo(4.32f, 20.4f, 5.11f, 21f, 6.01f, 21f);
        v12.lineTo(8f, 21f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(0f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.lineToRelative(2.01f, 0f);
        v12.curveToRelative(0.88f, 0f, 1.66f, -0.58f, 1.92f, -1.43f);
        v12.lineToRelative(1.25f, -4.16f);
        v12.lineToRelative(2.14f, -0.72f);
        v12.curveToRelative(0.41f, -0.14f, 0.68f, -0.52f, 0.68f, -0.95f);
        v12.verticalLineTo(8.5f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(19.83f);
        v12.close();
        v12.moveTo(12f, 9f);
        v12.horizontalLineTo(9f);
        v12.curveTo(8.45f, 9f, 8f, 8.55f, 8f, 8f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(13f, 8.55f, 12.55f, 9f, 12f, 9f);
        v12.close();
        v12.moveTo(16f, 11f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(17f, 10.55f, 16.549999f, 11f, 16f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SavingsKt._savings = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

