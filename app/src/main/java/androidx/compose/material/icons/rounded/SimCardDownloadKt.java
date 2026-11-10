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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_simCardDownload", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SimCardDownload", "Landroidx/compose/material/icons/Icons$Rounded;", "getSimCardDownload", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SimCardDownloadKt {
    private static ImageVector _simCardDownload;

    static {
    }

    public static final ImageVector getSimCardDownload(Rounded arg19) {
        ImageVector v0 = SimCardDownloadKt._simCardDownload;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SimCardDownload", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 2f);
        v12.horizontalLineToRelative(-7.17f);
        v12.curveTo(10.3f, 2f, 9.79f, 2.21f, 9.41f, 2.59f);
        v12.lineTo(4.59f, 7.41f);
        v12.curveTo(4.21f, 7.79f, 4f, 8.3f, 4f, 8.83f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(20f, 2.9f, 19.1f, 2f, 18f, 2f);
        v12.close();
        v12.moveTo(11.65f, 16.65f);
        v12.lineToRelative(-2.79f, -2.79f);
        v12.curveTo(8.54f, 13.54f, 8.76f, 13f, 9.21f, 13f);
        v12.horizontalLineTo(11f);
        v12.verticalLineToRelative(-2.99f);
        v12.curveToRelative(0f, -0.55f, 0.44f, -0.99f, 0.99f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(12.55f, 9f, 13f, 9.45f, 13f, 10.01f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(1.79f);
        v12.curveToRelative(0.45f, 0f, 0.67f, 0.54f, 0.35f, 0.85f);
        v12.lineToRelative(-2.79f, 2.79f);
        v12.curveTo(12.16f, 16.84f, 11.84f, 16.84f, 11.65f, 16.65f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SimCardDownloadKt._simCardDownload = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

