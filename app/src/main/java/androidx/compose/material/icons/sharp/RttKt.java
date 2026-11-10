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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_rtt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Rtt", "Landroidx/compose/material/icons/Icons$Sharp;", "getRtt$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getRtt", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RttKt {
    private static ImageVector _rtt;

    static {
    }

    public static final ImageVector getRtt(Sharp arg18) {
        ImageVector v0 = RttKt._rtt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Rtt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(9.03f, 3f);
        v0_1.lineToRelative(-1.11f, 7.07f);
        v0_1.horizontalLineToRelative(2.62f);
        v0_1.lineToRelative(0.7f, -4.5f);
        v0_1.horizontalLineToRelative(2.58f);
        v0_1.lineTo(11.8f, 18.43f);
        v0_1.horizontalLineTo(9.47f);
        v0_1.lineTo(9.06f, 21f);
        v0_1.horizontalLineToRelative(7.27f);
        v0_1.lineToRelative(0.4f, -2.57f);
        v0_1.horizontalLineToRelative(-2.35f);
        v0_1.lineToRelative(2f, -12.86f);
        v0_1.horizontalLineToRelative(2.58f);
        v0_1.lineToRelative(-0.71f, 4.5f);
        v0_1.horizontalLineToRelative(2.65f);
        v0_1.lineTo(22f, 3f);
        v0_1.horizontalLineTo(9.03f);
        v0_1.close();
        v0_1.moveTo(8f, 5f);
        v0_1.horizontalLineTo(4f);
        v0_1.lineTo(3.69f, 7f);
        v0_1.horizontalLineToRelative(4f);
        v0_1.lineTo(8f, 5f);
        v0_1.close();
        v0_1.moveTo(7.39f, 9f);
        v0_1.horizontalLineToRelative(-4f);
        v0_1.lineToRelative(-0.31f, 2f);
        v0_1.horizontalLineToRelative(4f);
        v0_1.lineTo(7.39f, 9f);
        v0_1.close();
        v0_1.moveTo(8.31f, 17f);
        v0_1.horizontalLineToRelative(-6f);
        v0_1.lineTo(2f, 19f);
        v0_1.horizontalLineToRelative(6f);
        v0_1.lineTo(8.31f, 17f);
        v0_1.close();
        v0_1.moveTo(8.93f, 13f);
        v0_1.horizontalLineToRelative(-6f);
        v0_1.lineToRelative(-0.31f, 2f);
        v0_1.horizontalLineToRelative(6.01f);
        v0_1.lineTo(8.93f, 13f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RttKt._rtt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.Rtt", replaceWith="<_subannotation>") public static void getRtt$annotations(Sharp arg0) {
    }
}

