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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_videoSettings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VideoSettings", "Landroidx/compose/material/icons/Icons$Sharp;", "getVideoSettings", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VideoSettingsKt {
    private static ImageVector _videoSettings;

    static {
    }

    public static final ImageVector getVideoSettings(Sharp arg19) {
        ImageVector v0 = VideoSettingsKt._videoSettings;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.VideoSettings", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(3f, 6f);
        v0_1.lineToRelative(18f, 0f);
        v0_1.lineToRelative(0f, 5f);
        v0_1.lineToRelative(2f, 0f);
        v0_1.lineToRelative(0f, -7f);
        v0_1.lineToRelative(-22f, 0f);
        v0_1.lineToRelative(0f, 16f);
        v0_1.lineToRelative(11f, 0f);
        v0_1.lineToRelative(0f, -2f);
        v0_1.lineToRelative(-9f, 0f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(15f, 12f);
        v0_1.lineToRelative(-6f, -4f);
        v0_1.lineToRelative(0f, 8f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22.719999f, 17.57f);
        v12.lineToRelative(1.23f, -0.98f);
        v12.lineToRelative(-1.25f, -2.17f);
        v12.lineTo(21.23f, 15f);
        v12.curveToRelative(-0.23f, -0.17f, -0.48f, -0.31f, -0.75f, -0.42f);
        v12.lineTo(20.25f, 13f);
        v12.horizontalLineToRelative(-2.5f);
        v12.lineToRelative(-0.24f, 1.58f);
        v12.curveToRelative(-0.26f, 0.11f, -0.51f, 0.26f, -0.74f, 0.42f);
        v12.lineToRelative(-1.48f, -0.58f);
        v12.lineToRelative(-1.25f, 2.17f);
        v12.lineToRelative(1.24f, 0.99f);
        v12.curveToRelative(-0.03f, 0.29f, -0.04f, 0.58f, -0.01f, 0.86f);
        v12.lineToRelative(-1.23f, 0.98f);
        v12.lineToRelative(1.25f, 2.17f);
        v12.lineTo(16.77f, 21f);
        v12.curveToRelative(0.23f, 0.17f, 0.48f, 0.31f, 0.75f, 0.42f);
        v12.lineTo(17.75f, 23f);
        v12.horizontalLineToRelative(2.5f);
        v12.lineToRelative(0.24f, -1.58f);
        v12.curveToRelative(0.26f, -0.11f, 0.51f, -0.26f, 0.74f, -0.42f);
        v12.lineToRelative(1.48f, 0.58f);
        v12.lineToRelative(1.25f, -2.17f);
        v12.lineToRelative(-1.24f, -0.99f);
        v12.curveTo(22.75f, 18.139999f, 22.75f, 17.85f, 22.719999f, 17.57f);
        v12.close();
        v12.moveTo(19f, 19.5f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(19.83f, 19.5f, 19f, 19.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VideoSettingsKt._videoSettings = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

