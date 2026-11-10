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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_dvr", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Dvr", "Landroidx/compose/material/icons/Icons$Sharp;", "getDvr$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getDvr", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DvrKt {
    private static ImageVector _dvr;

    static {
    }

    public static final ImageVector getDvr(Sharp arg18) {
        ImageVector v0 = DvrKt._dvr;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Dvr", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(23f, 3f);
        v0_1.lineTo(1f, 3f);
        v0_1.verticalLineToRelative(16f);
        v0_1.horizontalLineToRelative(7f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(8f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.horizontalLineToRelative(7f);
        v0_1.lineTo(23f, 3f);
        v0_1.close();
        v0_1.moveTo(21f, 17f);
        v0_1.lineTo(3f, 17f);
        v0_1.lineTo(3f, 5f);
        v0_1.horizontalLineToRelative(18f);
        v0_1.verticalLineToRelative(12f);
        v0_1.close();
        v0_1.moveTo(19f, 8f);
        v0_1.lineTo(8f, 8f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(11f);
        v0_1.lineTo(19f, 8f);
        v0_1.close();
        v0_1.moveTo(19f, 12f);
        v0_1.lineTo(8f, 12f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(11f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.close();
        v0_1.moveTo(7f, 8f);
        v0_1.lineTo(5f, 8f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.lineTo(7f, 8f);
        v0_1.close();
        v0_1.moveTo(7f, 12f);
        v0_1.lineTo(5f, 12f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DvrKt._dvr = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.Dvr", replaceWith="<_subannotation>") public static void getDvr$annotations(Sharp arg0) {
    }
}

