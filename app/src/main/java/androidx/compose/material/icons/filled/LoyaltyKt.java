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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_loyalty", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Loyalty", "Landroidx/compose/material/icons/Icons$Filled;", "getLoyalty", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LoyaltyKt {
    private static ImageVector _loyalty;

    static {
    }

    public static final ImageVector getLoyalty(Filled arg19) {
        ImageVector v0 = LoyaltyKt._loyalty;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Loyalty", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.41f, 11.58f);
        v12.lineToRelative(-9f, -9f);
        v12.curveTo(12.05f, 2.22f, 11.55f, 2f, 11f, 2f);
        v12.lineTo(4f, 2f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(7f);
        v12.curveToRelative(0f, 0.55f, 0.22f, 1.05f, 0.59f, 1.42f);
        v12.lineToRelative(9f, 9f);
        v12.curveToRelative(0.36f, 0.36f, 0.86f, 0.58f, 1.41f, 0.58f);
        v12.curveToRelative(0.55f, 0f, 1.05f, -0.22f, 1.41f, -0.59f);
        v12.lineToRelative(7f, -7f);
        v12.curveToRelative(0.37f, -0.36f, 0.59f, -0.86f, 0.59f, -1.41f);
        v12.curveToRelative(0f, -0.55f, -0.23f, -1.06f, -0.59f, -1.42f);
        v12.close();
        v12.moveTo(5.5f, 7f);
        v12.curveTo(4.67f, 7f, 4f, 6.33f, 4f, 5.5f);
        v12.reflectiveCurveTo(4.67f, 4f, 5.5f, 4f);
        v12.reflectiveCurveTo(7f, 4.67f, 7f, 5.5f);
        v12.reflectiveCurveTo(6.33f, 7f, 5.5f, 7f);
        v12.close();
        v12.moveTo(17.27f, 15.27f);
        v12.lineTo(13f, 19.540001f);
        v12.lineToRelative(-4.27f, -4.27f);
        v12.curveTo(8.28f, 14.81f, 8f, 14.19f, 8f, 13.5f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.curveToRelative(0.69f, 0f, 1.32f, 0.28f, 1.77f, 0.74f);
        v12.lineToRelative(0.73f, 0.72f);
        v12.lineToRelative(0.73f, -0.73f);
        v12.curveToRelative(0.45f, -0.45f, 1.08f, -0.73f, 1.77f, -0.73f);
        v12.curveToRelative(1.38f, 0f, 2.5f, 1.12f, 2.5f, 2.5f);
        v12.curveToRelative(0f, 0.69f, -0.28f, 1.32f, -0.73f, 1.77f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LoyaltyKt._loyalty = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

