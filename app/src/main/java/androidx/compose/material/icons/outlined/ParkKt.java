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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_park", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Park", "Landroidx/compose/material/icons/Icons$Outlined;", "getPark", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ParkKt {
    private static ImageVector _park;

    static {
    }

    public static final ImageVector getPark(Outlined arg18) {
        ImageVector v0 = ParkKt._park;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Park", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(17f, 12f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.lineTo(12f, 2f);
        v0_1.lineTo(5.05f, 12f);
        v0_1.horizontalLineTo(7f);
        v0_1.lineToRelative(-3.9f, 6f);
        v0_1.horizontalLineToRelative(6.92f);
        v0_1.verticalLineToRelative(4f);
        v0_1.horizontalLineToRelative(3.95f);
        v0_1.verticalLineToRelative(-4f);
        v0_1.horizontalLineTo(21f);
        v0_1.lineTo(17f, 12f);
        v0_1.close();
        v0_1.moveTo(6.79f, 16f);
        v0_1.lineToRelative(3.9f, -6f);
        v0_1.horizontalLineTo(8.88f);
        v0_1.lineToRelative(3.13f, -4.5f);
        v0_1.lineToRelative(3.15f, 4.5f);
        v0_1.horizontalLineToRelative(-1.9f);
        v0_1.lineToRelative(4f, 6f);
        v0_1.horizontalLineTo(6.79f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ParkKt._park = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

