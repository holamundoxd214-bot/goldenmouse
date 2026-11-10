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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_loyalty", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Loyalty", "Landroidx/compose/material/icons/Icons$Outlined;", "getLoyalty", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LoyaltyKt {
    private static ImageVector _loyalty;

    static {
    }

    public static final ImageVector getLoyalty(Outlined arg20) {
        ImageVector v0 = LoyaltyKt._loyalty;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Loyalty", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.41f, 11.58f);
        v12.lineToRelative(-9f, -9f);
        v12.curveTo(12.05f, 2.22f, 11.55f, 2f, 11f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(7f);
        v12.curveToRelative(0f, 0.55f, 0.22f, 1.05f, 0.59f, 1.42f);
        v12.lineToRelative(9f, 9f);
        v12.curveToRelative(0.36f, 0.36f, 0.86f, 0.58f, 1.41f, 0.58f);
        v12.reflectiveCurveToRelative(1.05f, -0.22f, 1.41f, -0.59f);
        v12.lineToRelative(7f, -7f);
        v12.curveToRelative(0.37f, -0.36f, 0.59f, -0.86f, 0.59f, -1.41f);
        v12.reflectiveCurveToRelative(-0.23f, -1.06f, -0.59f, -1.42f);
        v12.close();
        v12.moveTo(13f, 20.01f);
        v12.lineTo(4f, 11f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(-0.01f);
        v12.lineToRelative(9f, 9f);
        v12.lineToRelative(-7f, 7.02f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(6.5f, 6.5f);
        v12.moveToRelative(-1.5f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, 3f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, -3f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8.9f, 12.55f);
        v12.curveToRelative(0f, 0.57f, 0.23f, 1.07f, 0.6f, 1.45f);
        v12.lineToRelative(3.5f, 3.5f);
        v12.lineToRelative(3.5f, -3.5f);
        v12.curveToRelative(0.37f, -0.37f, 0.6f, -0.89f, 0.6f, -1.45f);
        v12.curveToRelative(0f, -1.13f, -0.92f, -2.05f, -2.05f, -2.05f);
        v12.curveToRelative(-0.57f, 0f, -1.08f, 0.23f, -1.45f, 0.6f);
        v12.lineToRelative(-0.6f, 0.6f);
        v12.lineToRelative(-0.6f, -0.59f);
        v12.curveToRelative(-0.37f, -0.38f, -0.89f, -0.61f, -1.45f, -0.61f);
        v12.curveToRelative(-1.13f, 0f, -2.05f, 0.92f, -2.05f, 2.05f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LoyaltyKt._loyalty = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

