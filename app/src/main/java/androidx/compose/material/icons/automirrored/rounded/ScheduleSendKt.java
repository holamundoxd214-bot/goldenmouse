package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_scheduleSend", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScheduleSend", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getScheduleSend", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScheduleSendKt {
    private static ImageVector _scheduleSend;

    static {
    }

    public static final ImageVector getScheduleSend(Rounded arg19) {
        ImageVector v0 = ScheduleSendKt._scheduleSend;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.ScheduleSend", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 10f);
        v12.curveToRelative(0.1f, 0f, 0.19f, 0.01f, 0.28f, 0.01f);
        v12.lineTo(4.39f, 4.58f);
        v12.curveTo(3.73f, 4.31f, 3f, 4.79f, 3f, 5.51f);
        v12.verticalLineToRelative(3.71f);
        v12.curveToRelative(0f, 0.46f, 0.31f, 0.86f, 0.76f, 0.97f);
        v12.lineTo(11f, 12f);
        v12.lineToRelative(-7.24f, 1.81f);
        v12.curveTo(3.31f, 13.92f, 3f, 14.32f, 3f, 14.78f);
        v12.verticalLineToRelative(3.71f);
        v12.curveToRelative(0f, 0.72f, 0.73f, 1.2f, 1.39f, 0.92f);
        v12.lineTo(10f, 17.049999f);
        v12.curveToRelative(0f, -0.02f, 0f, -0.03f, 0f, -0.05f);
        v12.curveTo(10f, 13.14f, 13.14f, 10f, 17f, 10f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 12f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.24f, 5f, 5f, 5f);
        v12.curveToRelative(2.76f, 0f, 5f, -2.24f, 5f, -5f);
        v12.reflectiveCurveTo(19.76f, 12f, 17f, 12f);
        v12.close();
        v12.moveTo(18.290001f, 19f);
        v12.lineToRelative(-1.65f, -1.65f);
        v12.curveToRelative(-0.09f, -0.09f, -0.15f, -0.22f, -0.15f, -0.35f);
        v12.verticalLineToRelative(-2.5f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineToRelative(2.29f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(18.799999f, 19.200001f, 18.49f, 19.200001f, 18.290001f, 19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScheduleSendKt._scheduleSend = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

