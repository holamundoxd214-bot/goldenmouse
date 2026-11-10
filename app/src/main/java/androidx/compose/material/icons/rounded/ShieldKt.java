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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_shield", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Shield", "Landroidx/compose/material/icons/Icons$Rounded;", "getShield", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ShieldKt {
    private static ImageVector _shield;

    static {
    }

    public static final ImageVector getShield(Rounded arg19) {
        ImageVector v0 = ShieldKt._shield;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Shield", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.3f, 2.26f);
        v12.lineToRelative(-6f, 2.25f);
        v12.curveTo(4.52f, 4.81f, 4f, 5.55f, 4f, 6.39f);
        v12.verticalLineToRelative(4.7f);
        v12.curveToRelative(0f, 4.83f, 3.13f, 9.37f, 7.43f, 10.75f);
        v12.curveToRelative(0.37f, 0.12f, 0.77f, 0.12f, 1.14f, 0f);
        v12.curveToRelative(4.3f, -1.38f, 7.43f, -5.91f, 7.43f, -10.75f);
        v12.verticalLineToRelative(-4.7f);
        v12.curveToRelative(0f, -0.83f, -0.52f, -1.58f, -1.3f, -1.87f);
        v12.lineToRelative(-6f, -2.25f);
        v12.curveTo(12.25f, 2.09f, 11.75f, 2.09f, 11.3f, 2.26f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ShieldKt._shield = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

