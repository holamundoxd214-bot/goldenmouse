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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_watch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Watch", "Landroidx/compose/material/icons/Icons$TwoTone;", "getWatch", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WatchKt {
    private static ImageVector _watch;

    static {
    }

    public static final ImageVector getWatch(TwoTone arg19) {
        ImageVector v0 = WatchKt._watch;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Watch", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.72f, 4.48f);
        v12.lineTo(14.31f, 2f);
        v12.horizontalLineTo(9.7f);
        v12.lineToRelative(-0.41f, 2.47f);
        v12.curveTo(10.13f, 4.17f, 11.05f, 4f, 12f, 4f);
        v12.curveToRelative(0.96f, 0f, 1.87f, 0.17f, 2.72f, 0.48f);
        v12.close();
        v12.moveTo(9.29f, 19.530001f);
        v12.lineTo(9.7f, 22f);
        v12.horizontalLineToRelative(4.61f);
        v12.lineToRelative(0.41f, -2.48f);
        v12.curveToRelative(-0.85f, 0.31f, -1.76f, 0.48f, -2.72f, 0.48f);
        v12.curveToRelative(-0.95f, 0f, -1.87f, -0.17f, -2.71f, -0.47f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.959999f, 5.73f);
        v12.lineTo(16f, 0f);
        v12.lineTo(8f, 0f);
        v12.lineToRelative(-0.95f, 5.73f);
        v12.curveTo(5.19f, 7.19f, 4f, 9.45f, 4f, 12f);
        v12.reflectiveCurveToRelative(1.19f, 4.81f, 3.05f, 6.27f);
        v12.lineTo(8f, 24f);
        v12.horizontalLineToRelative(8f);
        v12.lineToRelative(0.96f, -5.73f);
        v12.curveTo(18.809999f, 16.809999f, 20f, 14.54f, 20f, 12f);
        v12.reflectiveCurveToRelative(-1.19f, -4.81f, -3.04f, -6.27f);
        v12.close();
        v12.moveTo(9.7f, 2f);
        v12.horizontalLineToRelative(4.61f);
        v12.lineToRelative(0.41f, 2.48f);
        v12.curveTo(13.87f, 4.17f, 12.96f, 4f, 12f, 4f);
        v12.curveToRelative(-0.95f, 0f, -1.87f, 0.17f, -2.71f, 0.47f);
        v12.lineTo(9.7f, 2f);
        v12.close();
        v12.moveTo(14.31f, 22f);
        v12.lineTo(9.7f, 22f);
        v12.lineToRelative(-0.41f, -2.47f);
        v12.curveToRelative(0.84f, 0.3f, 1.76f, 0.47f, 2.71f, 0.47f);
        v12.curveToRelative(0.96f, 0f, 1.87f, -0.17f, 2.72f, -0.48f);
        v12.lineTo(14.31f, 22f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(-3.31f, 0f, -6f, -2.69f, -6f, -6f);
        v12.reflectiveCurveToRelative(2.69f, -6f, 6f, -6f);
        v12.reflectiveCurveToRelative(6f, 2.69f, 6f, 6f);
        v12.reflectiveCurveToRelative(-2.69f, 6f, -6f, 6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WatchKt._watch = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

