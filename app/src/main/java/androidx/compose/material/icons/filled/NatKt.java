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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nat", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Nat", "Landroidx/compose/material/icons/Icons$Filled;", "getNat", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NatKt {
    private static ImageVector _nat;

    static {
    }

    public static final ImageVector getNat(Filled arg19) {
        ImageVector v0 = NatKt._nat;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Nat", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.82f, 13f);
        v12.horizontalLineTo(11f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(6.82f);
        v12.curveTo(6.4f, 9.84f, 5.3f, 9f, 4f, 9f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.curveTo(5.3f, 15f, 6.4f, 14.16f, 6.82f, 13f);
        v12.close();
        v12.moveTo(4f, 13f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(5f, 12.55f, 4.55f, 13f, 4f, 13f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(23f, 12f);
        v12.lineToRelative(-4f, -3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-4.05f);
        v12.curveTo(14.45f, 5.95f, 10.19f, 2f, 5f, 2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(4.42f, 0f, 8f, 3.58f, 8f, 8f);
        v12.reflectiveCurveToRelative(-3.58f, 8f, -8f, 8f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(5.19f, 0f, 9.45f, -3.95f, 9.95f, -9f);
        v12.horizontalLineTo(19f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(23f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NatKt._nat = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

