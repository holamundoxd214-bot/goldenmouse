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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_downloadDone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DownloadDone", "Landroidx/compose/material/icons/Icons$Rounded;", "getDownloadDone", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DownloadDoneKt {
    private static ImageVector _downloadDone;

    static {
    }

    public static final ImageVector getDownloadDone(Rounded arg19) {
        ImageVector v0 = DownloadDoneKt._downloadDone;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DownloadDone", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6f, 18f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.lineTo(6f, 20f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.close();
        v12.moveTo(11.01f, 13.9f);
        v12.curveToRelative(-0.78f, 0.77f, -2.04f, 0.77f, -2.82f, -0.01f);
        v12.lineTo(6f, 11.7f);
        v12.curveToRelative(-0.55f, -0.55f, -0.54f, -1.44f, 0.03f, -1.97f);
        v12.curveToRelative(0.54f, -0.52f, 1.4f, -0.5f, 1.92f, 0.02f);
        v12.lineTo(9.6f, 11.4f);
        v12.lineToRelative(6.43f, -6.43f);
        v12.curveToRelative(0.54f, -0.54f, 1.41f, -0.54f, 1.95f, 0f);
        v12.lineToRelative(0.04f, 0.04f);
        v12.curveToRelative(0.54f, 0.54f, 0.54f, 1.42f, -0.01f, 1.96f);
        v12.lineToRelative(-7f, 6.93f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DownloadDoneKt._downloadDone = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

