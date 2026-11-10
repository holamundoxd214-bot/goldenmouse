package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_watchLater", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WatchLater", "Landroidx/compose/material/icons/Icons$Rounded;", "getWatchLater", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WatchLaterKt {
    private static ImageVector _watchLater;

    static {
    }

    public static final ImageVector getWatchLater(Rounded arg19) {
        ImageVector v0 = WatchLaterKt._watchLater;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WatchLater", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.5f, 2f, 2f, 6.5f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.5f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.5f, 10f, -10f);
        v12.reflectiveCurveTo(17.5f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(15.55f, 15.8f);
        v12.lineToRelative(-4.08f, -2.51f);
        v12.curveToRelative(-0.3f, -0.18f, -0.48f, -0.5f, -0.48f, -0.85f);
        v12.verticalLineTo(7.75f);
        v12.curveTo(11f, 7.34f, 11.34f, 7f, 11.75f, 7f);
        v12.reflectiveCurveToRelative(0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(4.45f);
        v12.lineToRelative(3.84f, 2.31f);
        v12.curveToRelative(0.36f, 0.22f, 0.48f, 0.69f, 0.26f, 1.05f);
        v12.curveTo(16.379999f, 15.91f, 15.91f, 16.02f, 15.55f, 15.8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WatchLaterKt._watchLater = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

