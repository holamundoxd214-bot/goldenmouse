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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_recentActors", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RecentActors", "Landroidx/compose/material/icons/Icons$Sharp;", "getRecentActors", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RecentActorsKt {
    private static ImageVector _recentActors;

    static {
    }

    public static final ImageVector getRecentActors(Sharp arg19) {
        ImageVector v0 = RecentActorsKt._recentActors;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.RecentActors", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 5f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(23f, 5f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v12.moveTo(17f, 19f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(19f, 5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(14f);
        v12.close();
        v12.moveTo(15f, 5f);
        v12.lineTo(1f, 5f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(14f);
        v12.lineTo(15f, 5f);
        v12.close();
        v12.moveTo(8f, 7.75f);
        v12.curveToRelative(1.24f, 0f, 2.25f, 1.01f, 2.25f, 2.25f);
        v12.reflectiveCurveTo(9.24f, 12.25f, 8f, 12.25f);
        v12.reflectiveCurveTo(5.75f, 11.24f, 5.75f, 10f);
        v12.reflectiveCurveTo(6.76f, 7.75f, 8f, 7.75f);
        v12.close();
        v12.moveTo(12.5f, 17f);
        v12.horizontalLineToRelative(-9f);
        v12.verticalLineToRelative(-0.75f);
        v12.curveToRelative(0f, -1.5f, 3f, -2.25f, 4.5f, -2.25f);
        v12.reflectiveCurveToRelative(4.5f, 0.75f, 4.5f, 2.25f);
        v12.lineTo(12.5f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RecentActorsKt._recentActors = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

