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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_videoCameraFront", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VideoCameraFront", "Landroidx/compose/material/icons/Icons$Sharp;", "getVideoCameraFront", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VideoCameraFrontKt {
    private static ImageVector _videoCameraFront;

    static {
    }

    public static final ImageVector getVideoCameraFront(Sharp arg19) {
        ImageVector v0 = VideoCameraFrontKt._videoCameraFront;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.VideoCameraFront", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 10.48f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(16f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-6.48f);
        v12.lineToRelative(4f, 3.98f);
        v12.verticalLineToRelative(-11f);
        v12.lineTo(18f, 10.48f);
        v12.close();
        v12.moveTo(10f, 8f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveTo(8.9f, 8f, 10f, 8f);
        v12.close();
        v12.moveTo(14f, 16f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-0.57f);
        v12.curveToRelative(0f, -0.81f, 0.48f, -1.53f, 1.22f, -1.85f);
        v12.curveTo(8.07f, 13.21f, 9.01f, 13f, 10f, 13f);
        v12.curveToRelative(0.99f, 0f, 1.93f, 0.21f, 2.78f, 0.58f);
        v12.curveTo(13.52f, 13.9f, 14f, 14.62f, 14f, 15.43f);
        v12.verticalLineTo(16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VideoCameraFrontKt._videoCameraFront = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

