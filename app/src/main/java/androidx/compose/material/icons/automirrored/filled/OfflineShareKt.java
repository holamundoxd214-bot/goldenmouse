package androidx.compose.material.icons.automirrored.filled;

import androidx.compose.material.icons.Icons$AutoMirrored$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_offlineShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "OfflineShare", "Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;", "getOfflineShare", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class OfflineShareKt {
    private static ImageVector _offlineShare;

    static {
    }

    public static final ImageVector getOfflineShare(Filled arg19) {
        ImageVector v0 = OfflineShareKt._offlineShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Filled.OfflineShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.6f, 10.26f);
        v12.verticalLineToRelative(1.31f);
        v12.lineTo(17f, 9.33f);
        v12.lineTo(14.6f, 7.1f);
        v12.verticalLineToRelative(1.28f);
        v12.curveToRelative(-2.33f, 0.32f, -3.26f, 1.92f, -3.6f, 3.52f);
        v12.curveToRelative(0.83f, -1.13f, 1.93f, -1.64f, 3.6f, -1.64f);
        v12.close();
        v12.moveTo(16f, 23f);
        v12.lineTo(6f, 23f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.lineTo(4f, 5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(16f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(18f, 1f);
        v12.horizontalLineToRelative(-8f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(8f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(20f, 3f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(18f, 16f);
        v12.horizontalLineToRelative(-8f);
        v12.lineTo(10f, 4f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        OfflineShareKt._offlineShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

