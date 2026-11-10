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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_brokenImage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BrokenImage", "Landroidx/compose/material/icons/Icons$Sharp;", "getBrokenImage", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BrokenImageKt {
    private static ImageVector _brokenImage;

    static {
    }

    public static final ImageVector getBrokenImage(Sharp arg18) {
        ImageVector v0 = BrokenImageKt._brokenImage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.BrokenImage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(21f, 3f);
        v0_1.verticalLineToRelative(8.59f);
        v0_1.lineToRelative(-3f, -3.01f);
        v0_1.lineToRelative(-4f, 4.01f);
        v0_1.lineToRelative(-4f, -4f);
        v0_1.lineToRelative(-4f, 4f);
        v0_1.lineToRelative(-3f, -3.01f);
        v0_1.lineTo(3f, 3f);
        v0_1.horizontalLineToRelative(18f);
        v0_1.close();
        v0_1.moveTo(18f, 11.42f);
        v0_1.lineToRelative(3f, 3.01f);
        v0_1.lineTo(21f, 21f);
        v0_1.lineTo(3f, 21f);
        v0_1.verticalLineToRelative(-8.58f);
        v0_1.lineToRelative(3f, 2.99f);
        v0_1.lineToRelative(4f, -4f);
        v0_1.lineToRelative(4f, 4f);
        v0_1.lineToRelative(4f, -3.99f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BrokenImageKt._brokenImage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

