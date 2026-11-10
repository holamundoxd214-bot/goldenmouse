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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fiberNew", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FiberNew", "Landroidx/compose/material/icons/Icons$Sharp;", "getFiberNew", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FiberNewKt {
    private static ImageVector _fiberNew;

    static {
    }

    public static final ImageVector getFiberNew(Sharp arg18) {
        ImageVector v0 = FiberNewKt._fiberNew;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.FiberNew", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(22f, 4f);
        v0_1.lineTo(2f, 4f);
        v0_1.verticalLineToRelative(16f);
        v0_1.horizontalLineToRelative(20f);
        v0_1.lineTo(22f, 4f);
        v0_1.close();
        v0_1.moveTo(8.5f, 15f);
        v0_1.lineTo(7.3f, 15f);
        v0_1.lineToRelative(-2.55f, -3.5f);
        v0_1.lineTo(4.75f, 15f);
        v0_1.lineTo(3.5f, 15f);
        v0_1.lineTo(3.5f, 9f);
        v0_1.horizontalLineToRelative(1.25f);
        v0_1.lineToRelative(2.5f, 3.5f);
        v0_1.lineTo(7.25f, 9f);
        v0_1.lineTo(8.5f, 9f);
        v0_1.verticalLineToRelative(6f);
        v0_1.close();
        v0_1.moveTo(13.5f, 10.26f);
        v0_1.lineTo(11f, 10.26f);
        v0_1.verticalLineToRelative(1.12f);
        v0_1.horizontalLineToRelative(2.5f);
        v0_1.verticalLineToRelative(1.26f);
        v0_1.lineTo(11f, 12.64f);
        v0_1.verticalLineToRelative(1.11f);
        v0_1.horizontalLineToRelative(2.5f);
        v0_1.lineTo(13.5f, 15f);
        v0_1.horizontalLineToRelative(-4f);
        v0_1.lineTo(9.5f, 9f);
        v0_1.horizontalLineToRelative(4f);
        v0_1.verticalLineToRelative(1.26f);
        v0_1.close();
        v0_1.moveTo(20.5f, 15f);
        v0_1.horizontalLineToRelative(-6f);
        v0_1.lineTo(14.5f, 9f);
        v0_1.horizontalLineToRelative(1.25f);
        v0_1.verticalLineToRelative(4.51f);
        v0_1.horizontalLineToRelative(1.13f);
        v0_1.lineTo(16.879999f, 9.99f);
        v0_1.horizontalLineToRelative(1.25f);
        v0_1.verticalLineToRelative(3.51f);
        v0_1.horizontalLineToRelative(1.12f);
        v0_1.lineTo(19.25f, 9f);
        v0_1.horizontalLineToRelative(1.25f);
        v0_1.verticalLineToRelative(6f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FiberNewKt._fiberNew = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

