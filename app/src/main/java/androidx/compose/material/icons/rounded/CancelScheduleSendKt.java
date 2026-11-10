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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cancelScheduleSend", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CancelScheduleSend", "Landroidx/compose/material/icons/Icons$Rounded;", "getCancelScheduleSend", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CancelScheduleSendKt {
    private static ImageVector _cancelScheduleSend;

    static {
    }

    public static final ImageVector getCancelScheduleSend(Rounded arg19) {
        ImageVector v0 = CancelScheduleSendKt._cancelScheduleSend;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CancelScheduleSend", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.5f, 9f);
        v12.curveToRelative(-0.42f, 0f, -0.83f, 0.04f, -1.24f, 0.11f);
        v12.lineTo(2.4f, 3.6f);
        v12.curveTo(1.74f, 3.31f, 1.01f, 3.8f, 1.01f, 4.51f);
        v12.lineTo(1f, 9.2f);
        v12.curveToRelative(0f, 0.47f, 0.33f, 0.88f, 0.78f, 0.98f);
        v12.lineTo(10f, 12f);
        v12.lineToRelative(-8.22f, 1.83f);
        v12.curveTo(1.33f, 13.93f, 1f, 14.33f, 1f, 14.8f);
        v12.lineToRelative(0.01f, 4.68f);
        v12.curveToRelative(0f, 0.72f, 0.73f, 1.2f, 1.39f, 0.92f);
        v12.lineToRelative(6.68f, -2.86f);
        v12.curveTo(9.59f, 21.190001f, 12.71f, 24f, 16.5f, 24f);
        v12.curveToRelative(4.14f, 0f, 7.5f, -3.36f, 7.5f, -7.5f);
        v12.reflectiveCurveTo(20.639999f, 9f, 16.5f, 9f);
        v12.close();
        v12.moveTo(16.5f, 22f);
        v12.curveToRelative(-3.03f, 0f, -5.5f, -2.47f, -5.5f, -5.5f);
        v12.reflectiveCurveToRelative(2.47f, -5.5f, 5.5f, -5.5f);
        v12.reflectiveCurveToRelative(5.5f, 2.47f, 5.5f, 5.5f);
        v12.reflectiveCurveTo(19.530001f, 22f, 16.5f, 22f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18.620001f, 14.38f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.reflectiveCurveToRelative(-0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.curveTo(18.82f, 14.89f, 18.82f, 14.57f, 18.620001f, 14.38f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CancelScheduleSendKt._cancelScheduleSend = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

