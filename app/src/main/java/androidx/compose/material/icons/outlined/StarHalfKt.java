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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_starHalf", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StarHalf", "Landroidx/compose/material/icons/Icons$Outlined;", "getStarHalf$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getStarHalf", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StarHalfKt {
    private static ImageVector _starHalf;

    static {
    }

    public static final ImageVector getStarHalf(Outlined arg18) {
        ImageVector v0 = StarHalfKt._starHalf;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.StarHalf", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(22f, 9.24f);
        v0_1.lineToRelative(-7.19f, -0.62f);
        v0_1.lineTo(12f, 2f);
        v0_1.lineTo(9.19f, 8.63f);
        v0_1.lineTo(2f, 9.24f);
        v0_1.lineToRelative(5.46f, 4.73f);
        v0_1.lineTo(5.82f, 21f);
        v0_1.lineTo(12f, 17.27f);
        v0_1.lineTo(18.18f, 21f);
        v0_1.lineToRelative(-1.63f, -7.03f);
        v0_1.lineTo(22f, 9.24f);
        v0_1.close();
        v0_1.moveTo(12f, 15.4f);
        v0_1.verticalLineTo(6.1f);
        v0_1.lineToRelative(1.71f, 4.04f);
        v0_1.lineToRelative(4.38f, 0.38f);
        v0_1.lineToRelative(-3.32f, 2.88f);
        v0_1.lineToRelative(1f, 4.28f);
        v0_1.lineTo(12f, 15.4f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StarHalfKt._starHalf = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Outlined.StarHalf", replaceWith="<_subannotation>") public static void getStarHalf$annotations(Outlined arg0) {
    }
}

