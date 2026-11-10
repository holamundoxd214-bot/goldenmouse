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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_offlineShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "OfflineShare", "Landroidx/compose/material/icons/Icons$Sharp;", "getOfflineShare$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getOfflineShare", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class OfflineShareKt {
    private static ImageVector _offlineShare;

    static {
    }

    public static final ImageVector getOfflineShare(Sharp arg23) {
        ImageVector v0 = OfflineShareKt._offlineShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.OfflineShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(6f, 5f);
        v0_1.lineToRelative(-2f, 0f);
        v0_1.lineToRelative(0f, 18f);
        v0_1.lineToRelative(12f, 0f);
        v0_1.lineToRelative(0f, -2f);
        v0_1.lineToRelative(-10f, 0f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v2 = new PathBuilder();
        v2.moveTo(20f, 1f);
        v2.horizontalLineTo(8f);
        v2.verticalLineToRelative(18f);
        v2.horizontalLineToRelative(12f);
        v2.verticalLineTo(1f);
        v2.close();
        v2.moveTo(18f, 15f);
        v2.horizontalLineToRelative(-8f);
        v2.verticalLineTo(5f);
        v2.horizontalLineToRelative(8f);
        v2.verticalLineTo(15f);
        v2.close();
        Builder.addPath-oIyEayM$default(v1, v2.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(12.5f, 10.25f);
        v0_1.lineToRelative(2f, 0f);
        v0_1.lineToRelative(0f, 1.75f);
        v0_1.lineToRelative(2.5f, -2.5f);
        v0_1.lineToRelative(-2.5f, -2.5f);
        v0_1.lineToRelative(0f, 1.75f);
        v0_1.lineToRelative(-3.5f, 0f);
        v0_1.lineToRelative(0f, 3.25f);
        v0_1.lineToRelative(1.5f, 0f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        OfflineShareKt._offlineShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.OfflineShare", replaceWith="<_subannotation>") public static void getOfflineShare$annotations(Sharp arg0) {
    }
}

