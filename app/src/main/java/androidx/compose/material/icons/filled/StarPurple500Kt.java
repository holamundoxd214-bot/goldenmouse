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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_starPurple500", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StarPurple500", "Landroidx/compose/material/icons/Icons$Filled;", "getStarPurple500", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StarPurple500Kt {
    private static ImageVector _starPurple500;

    static {
    }

    public static final ImageVector getStarPurple500(Filled arg18) {
        ImageVector v0 = StarPurple500Kt._starPurple500;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.StarPurple500", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(12f, 8.89f);
        v0_1.lineTo(12.94f, 12f);
        v0_1.horizontalLineToRelative(2.82f);
        v0_1.lineToRelative(-2.27f, 1.62f);
        v0_1.lineToRelative(0.93f, 3.01f);
        v0_1.lineTo(12f, 14.79f);
        v0_1.lineToRelative(-2.42f, 1.84f);
        v0_1.lineToRelative(0.93f, -3.01f);
        v0_1.lineTo(8.24f, 12f);
        v0_1.horizontalLineToRelative(2.82f);
        v0_1.lineTo(12f, 8.89f);
        v0_1.moveTo(12f, 2f);
        v0_1.lineToRelative(-2.42f, 8f);
        v0_1.horizontalLineTo(2f);
        v0_1.lineToRelative(6.17f, 4.41f);
        v0_1.lineTo(5.83f, 22f);
        v0_1.lineTo(12f, 17.309999f);
        v0_1.lineTo(18.18f, 22f);
        v0_1.lineToRelative(-2.35f, -7.59f);
        v0_1.lineTo(22f, 10f);
        v0_1.horizontalLineToRelative(-7.58f);
        v0_1.lineTo(12f, 2f);
        v0_1.lineTo(12f, 2f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StarPurple500Kt._starPurple500 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

