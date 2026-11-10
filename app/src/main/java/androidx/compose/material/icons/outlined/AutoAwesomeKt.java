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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_autoAwesome", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AutoAwesome", "Landroidx/compose/material/icons/Icons$Outlined;", "getAutoAwesome", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AutoAwesomeKt {
    private static ImageVector _autoAwesome;

    static {
    }

    public static final ImageVector getAutoAwesome(Outlined arg25) {
        ImageVector v0 = AutoAwesomeKt._autoAwesome;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AutoAwesome", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(19f, 9f);
        v0_1.lineToRelative(1.25f, -2.75f);
        v0_1.lineToRelative(2.75f, -1.25f);
        v0_1.lineToRelative(-2.75f, -1.25f);
        v0_1.lineToRelative(-1.25f, -2.75f);
        v0_1.lineToRelative(-1.25f, 2.75f);
        v0_1.lineToRelative(-2.75f, 1.25f);
        v0_1.lineToRelative(2.75f, 1.25f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v2 = new PathBuilder();
        v2.moveTo(19f, 15f);
        v2.lineToRelative(-1.25f, 2.75f);
        v2.lineToRelative(-2.75f, 1.25f);
        v2.lineToRelative(2.75f, 1.25f);
        v2.lineToRelative(1.25f, 2.75f);
        v2.lineToRelative(1.25f, -2.75f);
        v2.lineToRelative(2.75f, -1.25f);
        v2.lineToRelative(-2.75f, -1.25f);
        v2.close();
        Builder.addPath-oIyEayM$default(v1, v2.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(11.5f, 9.5f);
        v0_1.lineTo(9f, 4f);
        v0_1.lineTo(6.5f, 9.5f);
        v0_1.lineTo(1f, 12f);
        v0_1.lineToRelative(5.5f, 2.5f);
        v0_1.lineTo(9f, 20f);
        v0_1.lineToRelative(2.5f, -5.5f);
        v0_1.lineTo(17f, 12f);
        v0_1.lineTo(11.5f, 9.5f);
        v0_1.close();
        v0_1.moveTo(9.99f, 12.99f);
        v0_1.lineTo(9f, 15.17f);
        v0_1.lineToRelative(-0.99f, -2.18f);
        v0_1.lineTo(5.83f, 12f);
        v0_1.lineToRelative(2.18f, -0.99f);
        v0_1.lineTo(9f, 8.83f);
        v0_1.lineToRelative(0.99f, 2.18f);
        v0_1.lineTo(12.17f, 12f);
        v0_1.lineTo(9.99f, 12.99f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AutoAwesomeKt._autoAwesome = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

