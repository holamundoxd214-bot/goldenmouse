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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_iosShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "IosShare", "Landroidx/compose/material/icons/Icons$Filled;", "getIosShare", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class IosShareKt {
    private static ImageVector _iosShare;

    static {
    }

    public static final ImageVector getIosShare(Filled arg19) {
        ImageVector v0 = IosShareKt._iosShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.IosShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 5f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.lineToRelative(-1.59f, -1.59f);
        v12.lineTo(12.99f, 16f);
        v12.horizontalLineToRelative(-1.98f);
        v12.lineTo(11.01f, 4.83f);
        v12.lineTo(9.42f, 6.42f);
        v12.lineTo(8f, 5f);
        v12.lineToRelative(4f, -4f);
        v12.lineToRelative(4f, 4f);
        v12.close();
        v12.moveTo(20f, 10f);
        v12.verticalLineToRelative(11f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.lineTo(6f, 23f);
        v12.curveToRelative(-1.11f, 0f, -2f, -0.9f, -2f, -2f);
        v12.lineTo(4f, 10f);
        v12.curveToRelative(0f, -1.11f, 0.89f, -2f, 2f, -2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(6f, 10f);
        v12.verticalLineToRelative(11f);
        v12.horizontalLineToRelative(12f);
        v12.lineTo(18f, 10f);
        v12.horizontalLineToRelative(-3f);
        v12.lineTo(15f, 8f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.89f, 2f, 2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        IosShareKt._iosShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

