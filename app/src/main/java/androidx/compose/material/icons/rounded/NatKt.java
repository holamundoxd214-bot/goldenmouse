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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nat", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Nat", "Landroidx/compose/material/icons/Icons$Rounded;", "getNat", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NatKt {
    private static ImageVector _nat;

    static {
    }

    public static final ImageVector getNat(Rounded arg19) {
        ImageVector v0 = NatKt._nat;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Nat", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(22.469999f, 12.4f);
        v12.curveToRelative(0.27f, -0.2f, 0.27f, -0.6f, 0f, -0.8f);
        v12.lineTo(19f, 9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-4.05f);
        v12.curveToRelative(-0.47f, -4.69f, -4.16f, -8.42f, -8.83f, -8.94f);
        v12.curveTo(5.52f, 2f, 5f, 2.46f, 5f, 3.06f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.5f, 0.37f, 0.93f, 0.87f, 0.99f);
        v12.curveTo(9.88f, 4.48f, 13f, 7.87f, 13f, 12f);
        v12.reflectiveCurveToRelative(-3.12f, 7.52f, -7.13f, 7.95f);
        v12.curveTo(5.37f, 20.01f, 5f, 20.440001f, 5f, 20.940001f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.6f, 0.52f, 1.07f, 1.11f, 1f);
        v12.curveToRelative(4.67f, -0.52f, 8.37f, -4.25f, 8.83f, -8.94f);
        v12.horizontalLineTo(19f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(22.469999f, 12.4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NatKt._nat = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

