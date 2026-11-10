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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_trackChanges", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TrackChanges", "Landroidx/compose/material/icons/Icons$Rounded;", "getTrackChanges", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TrackChangesKt {
    private static ImageVector _trackChanges;

    static {
    }

    public static final ImageVector getTrackChanges(Rounded arg19) {
        ImageVector v0 = TrackChangesKt._trackChanges;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TrackChanges", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.32f, 5.68f);
        v12.curveToRelative(-0.36f, 0.36f, -0.39f, 0.92f, -0.07f, 1.32f);
        v12.curveToRelative(1.45f, 1.82f, 2.21f, 4.31f, 1.53f, 6.92f);
        v12.curveToRelative(-0.79f, 3.05f, -3.18f, 5.33f, -6.21f, 5.94f);
        v12.curveTo(8.47f, 20.870001f, 4f, 16.93f, 4f, 12f);
        v12.curveToRelative(0f, -4.08f, 3.05f, -7.44f, 7f, -7.93f);
        v12.verticalLineToRelative(2.02f);
        v12.curveToRelative(-3.13f, 0.53f, -5.43f, 3.46f, -4.93f, 6.83f);
        v12.curveToRelative(0.39f, 2.61f, 2.56f, 4.71f, 5.18f, 5.03f);
        v12.curveTo(14.89f, 18.4f, 18f, 15.56f, 18f, 12f);
        v12.curveToRelative(0f, -1.25f, -0.38f, -2.4f, -1.03f, -3.36f);
        v12.curveToRelative(-0.34f, -0.5f, -1.07f, -0.53f, -1.5f, -0.11f);
        v12.lineToRelative(-0.01f, 0.01f);
        v12.curveToRelative(-0.34f, 0.34f, -0.37f, 0.87f, -0.11f, 1.27f);
        v12.curveToRelative(0.6f, 0.92f, 0.84f, 2.1f, 0.49f, 3.32f);
        v12.curveToRelative(-0.39f, 1.37f, -1.54f, 2.46f, -2.94f, 2.77f);
        v12.curveToRelative(-2.6f, 0.57f, -4.9f, -1.39f, -4.9f, -3.9f);
        v12.curveToRelative(0f, -1.86f, 1.28f, -3.41f, 3f, -3.86f);
        v12.verticalLineToRelative(2.14f);
        v12.curveToRelative(-0.6f, 0.35f, -1f, 0.98f, -1f, 1.72f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -0.74f, -0.4f, -1.38f, -1f, -1.72f);
        v12.verticalLineTo(2.71f);
        v12.curveToRelative(0f, -0.39f, -0.32f, -0.71f, -0.71f, -0.71f);
        v12.curveToRelative(-5.36f, -0.2f, -9.98f, 4.06f, -10.27f, 9.4f);
        v12.curveToRelative(-0.36f, 6.55f, 5.41f, 11.82f, 12.01f, 10.4f);
        v12.curveToRelative(3.88f, -0.83f, 6.88f, -3.8f, 7.75f, -7.67f);
        v12.curveToRelative(0.71f, -3.16f, -0.2f, -6.16f, -1.97f, -8.37f);
        v12.curveToRelative(-0.37f, -0.47f, -1.07f, -0.5f, -1.49f, -0.08f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TrackChangesKt._trackChanges = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

