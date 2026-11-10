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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_offlineBolt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "OfflineBolt", "Landroidx/compose/material/icons/Icons$Sharp;", "getOfflineBolt", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class OfflineBoltKt {
    private static ImageVector _offlineBolt;

    static {
    }

    public static final ImageVector getOfflineBolt(Sharp arg19) {
        ImageVector v0 = OfflineBoltKt._offlineBolt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.OfflineBolt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2.02f);
        v12.curveToRelative(-5.51f, 0f, -9.98f, 4.47f, -9.98f, 9.98f);
        v12.reflectiveCurveToRelative(4.47f, 9.98f, 9.98f, 9.98f);
        v12.reflectiveCurveToRelative(9.98f, -4.47f, 9.98f, -9.98f);
        v12.reflectiveCurveTo(17.51f, 2.02f, 12f, 2.02f);
        v12.close();
        v12.moveTo(11.48f, 20f);
        v12.verticalLineToRelative(-6.26f);
        v12.horizontalLineTo(8f);
        v12.lineTo(13f, 4f);
        v12.verticalLineToRelative(6.26f);
        v12.horizontalLineToRelative(3.35f);
        v12.lineTo(11.48f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        OfflineBoltKt._offlineBolt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

