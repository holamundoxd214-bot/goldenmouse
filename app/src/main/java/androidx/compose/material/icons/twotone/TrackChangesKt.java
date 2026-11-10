package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_trackChanges", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TrackChanges", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTrackChanges", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TrackChangesKt {
    private static ImageVector _trackChanges;

    static {
    }

    public static final ImageVector getTrackChanges(TwoTone arg19) {
        ImageVector v0 = TrackChangesKt._trackChanges;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.TrackChanges", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.07f, 4.93f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.curveTo(19.1f, 7.79f, 20f, 9.79f, 20f, 12f);
        v12.curveToRelative(0f, 4.42f, -3.58f, 8f, -8f, 8f);
        v12.reflectiveCurveToRelative(-8f, -3.58f, -8f, -8f);
        v12.curveToRelative(0f, -4.08f, 3.05f, -7.44f, 7f, -7.93f);
        v12.verticalLineToRelative(2.02f);
        v12.curveTo(8.16f, 6.57f, 6f, 9.03f, 6f, 12f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.reflectiveCurveToRelative(6f, -2.69f, 6f, -6f);
        v12.curveToRelative(0f, -1.66f, -0.67f, -3.16f, -1.76f, -4.24f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.curveTo(15.55f, 9.9f, 16f, 10.9f, 16f, 12f);
        v12.curveToRelative(0f, 2.21f, -1.79f, 4f, -4f, 4f);
        v12.reflectiveCurveToRelative(-4f, -1.79f, -4f, -4f);
        v12.curveToRelative(0f, -1.86f, 1.28f, -3.41f, 3f, -3.86f);
        v12.verticalLineToRelative(2.14f);
        v12.curveToRelative(-0.6f, 0.35f, -1f, 0.98f, -1f, 1.72f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -0.74f, -0.4f, -1.38f, -1f, -1.72f);
        v12.verticalLineTo(2f);
        v12.horizontalLineToRelative(-1f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.curveToRelative(0f, -2.76f, -1.12f, -5.26f, -2.93f, -7.07f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TrackChangesKt._trackChanges = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

