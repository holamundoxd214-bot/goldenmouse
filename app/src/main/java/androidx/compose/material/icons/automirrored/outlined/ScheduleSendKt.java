package androidx.compose.material.icons.automirrored.outlined;

import androidx.compose.material.icons.Icons$AutoMirrored$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_scheduleSend", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScheduleSend", "Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;", "getScheduleSend", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScheduleSendKt {
    private static ImageVector _scheduleSend;

    static {
    }

    public static final ImageVector getScheduleSend(Outlined arg19) {
        ImageVector v0 = ScheduleSendKt._scheduleSend;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Outlined.ScheduleSend", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 12f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.24f, 5f, 5f, 5f);
        v12.curveToRelative(2.76f, 0f, 5f, -2.24f, 5f, -5f);
        v12.reflectiveCurveTo(19.76f, 12f, 17f, 12f);
        v12.close();
        v12.moveTo(18.65f, 19.35f);
        v12.lineToRelative(-2.15f, -2.15f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2.79f);
        v12.lineToRelative(1.85f, 1.85f);
        v12.lineTo(18.65f, 19.35f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(11f, 12f);
        v12.lineToRelative(-6f, -1.5f);
        v12.verticalLineTo(7.01f);
        v12.lineToRelative(8.87f, 3.74f);
        v12.curveToRelative(0.94f, -0.47f, 2f, -0.75f, 3.13f, -0.75f);
        v12.curveToRelative(0.1f, 0f, 0.19f, 0.01f, 0.28f, 0.01f);
        v12.lineTo(3f, 4f);
        v12.verticalLineToRelative(16f);
        v12.lineToRelative(7f, -2.95f);
        v12.curveToRelative(0f, -0.02f, 0f, -0.03f, 0f, -0.05f);
        v12.curveToRelative(0f, -0.8f, 0.14f, -1.56f, 0.39f, -2.28f);
        v12.lineTo(5f, 16.99f);
        v12.verticalLineTo(13.5f);
        v12.lineTo(11f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScheduleSendKt._scheduleSend = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

