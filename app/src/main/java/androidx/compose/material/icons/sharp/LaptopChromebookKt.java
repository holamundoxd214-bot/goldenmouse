package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_laptopChromebook", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LaptopChromebook", "Landroidx/compose/material/icons/Icons$Sharp;", "getLaptopChromebook", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LaptopChromebookKt {
    private static ImageVector _laptopChromebook;

    static {
    }

    public static final ImageVector getLaptopChromebook(Sharp arg18) {
        ImageVector v0 = LaptopChromebookKt._laptopChromebook;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.LaptopChromebook", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v2 = new PathBuilder();
        v2.moveTo(22f, 18f);
        v2.lineTo(22f, 3f);
        v2.lineTo(2f, 3f);
        v2.verticalLineToRelative(15f);
        v2.lineTo(0f, 18f);
        v2.verticalLineToRelative(2f);
        v2.horizontalLineToRelative(24f);
        v2.verticalLineToRelative(-2f);
        v2.horizontalLineToRelative(-2f);
        v2.close();
        v2.moveTo(14f, 18f);
        v2.horizontalLineToRelative(-4f);
        v2.verticalLineToRelative(-1f);
        v2.horizontalLineToRelative(4f);
        v2.verticalLineToRelative(1f);
        v2.close();
        v2.moveTo(20f, 15f);
        v2.lineTo(4f, 15f);
        v2.lineTo(4f, 5f);
        v2.horizontalLineToRelative(16f);
        v2.verticalLineToRelative(10f);
        v2.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v2.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LaptopChromebookKt._laptopChromebook = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

