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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_videoCameraBack", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VideoCameraBack", "Landroidx/compose/material/icons/Icons$Rounded;", "getVideoCameraBack", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VideoCameraBackKt {
    private static ImageVector _videoCameraBack;

    static {
    }

    public static final ImageVector getVideoCameraBack(Rounded arg19) {
        ImageVector v0 = VideoCameraBackKt._videoCameraBack;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.VideoCameraBack", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 10.48f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 4f, 2f, 4.9f, 2f, 6f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-4.48f);
        v12.lineToRelative(3.15f, 3.13f);
        v12.curveTo(21.459999f, 16.969999f, 22f, 16.74f, 22f, 16.299999f);
        v12.verticalLineTo(7.7f);
        v12.curveToRelative(0f, -0.44f, -0.54f, -0.67f, -0.85f, -0.35f);
        v12.lineTo(18f, 10.48f);
        v12.close();
        v12.moveTo(5.6f, 15.2f);
        v12.lineToRelative(1.38f, -1.83f);
        v12.curveToRelative(0.2f, -0.27f, 0.6f, -0.27f, 0.8f, 0f);
        v12.lineTo(9f, 15f);
        v12.lineToRelative(2.23f, -2.97f);
        v12.curveToRelative(0.2f, -0.27f, 0.6f, -0.27f, 0.8f, 0f);
        v12.lineToRelative(2.38f, 3.17f);
        v12.curveToRelative(0.25f, 0.33f, 0.01f, 0.8f, -0.4f, 0.8f);
        v12.horizontalLineTo(6f);
        v12.curveTo(5.59f, 16f, 5.35f, 15.53f, 5.6f, 15.2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VideoCameraBackKt._videoCameraBack = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

