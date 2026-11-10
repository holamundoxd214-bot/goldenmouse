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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fireplace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Fireplace", "Landroidx/compose/material/icons/Icons$Filled;", "getFireplace", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FireplaceKt {
    private static ImageVector _fireplace;

    static {
    }

    public static final ImageVector getFireplace(Filled arg19) {
        ImageVector v0 = FireplaceKt._fireplace;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Fireplace", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2f, 2f);
        v12.verticalLineToRelative(20f);
        v12.horizontalLineToRelative(20f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(2f);
        v12.close();
        v12.moveTo(11.86f, 16.959999f);
        v12.curveToRelative(0.76f, -0.24f, 1.4f, -1.04f, 1.53f, -1.63f);
        v12.curveToRelative(0.13f, -0.56f, -0.1f, -1.05f, -0.2f, -1.6f);
        v12.curveToRelative(-0.08f, -0.46f, -0.07f, -0.85f, 0.08f, -1.28f);
        v12.curveToRelative(0.54f, 1.21f, 2.15f, 1.64f, 1.98f, 3.18f);
        v12.curveTo(15.06f, 17.33f, 13.14f, 18.01f, 11.86f, 16.959999f);
        v12.close();
        v12.moveTo(20f, 20f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2.02f);
        v12.curveToRelative(0.63f, -0.84f, 1.02f, -1.87f, 1.02f, -3f);
        v12.curveToRelative(0f, -1.89f, -1.09f, -2.85f, -1.85f, -3.37f);
        v12.curveTo(12.2f, 9.61f, 13f, 7f, 13f, 7f);
        v12.curveToRelative(-6.73f, 3.57f, -6.02f, 7.47f, -6f, 8f);
        v12.curveToRelative(0.03f, 0.96f, 0.49f, 2.07f, 1.23f, 3f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FireplaceKt._fireplace = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

