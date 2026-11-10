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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_emergency", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Emergency", "Landroidx/compose/material/icons/Icons$Rounded;", "getEmergency", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EmergencyKt {
    private static ImageVector _emergency;

    static {
    }

    public static final ImageVector getEmergency(Rounded arg19) {
        ImageVector v0 = EmergencyKt._emergency;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Emergency", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.290001f, 8.37f);
        v12.lineToRelative(-1f, -1.73f);
        v12.curveToRelative(-0.28f, -0.48f, -0.89f, -0.64f, -1.37f, -0.37f);
        v12.lineTo(14f, 8.54f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4.54f);
        v12.lineTo(6.07f, 6.27f);
        v12.curveTo(5.59f, 5.99f, 4.98f, 6.16f, 4.71f, 6.63f);
        v12.lineToRelative(-1f, 1.73f);
        v12.curveTo(3.43f, 8.84f, 3.59f, 9.46f, 4.07f, 9.73f);
        v12.lineTo(8f, 12f);
        v12.lineToRelative(-3.93f, 2.27f);
        v12.curveToRelative(-0.48f, 0.28f, -0.64f, 0.89f, -0.37f, 1.37f);
        v12.lineToRelative(1f, 1.73f);
        v12.curveToRelative(0.28f, 0.48f, 0.89f, 0.64f, 1.37f, 0.37f);
        v12.lineTo(10f, 15.46f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-4.54f);
        v12.lineToRelative(3.93f, 2.27f);
        v12.curveToRelative(0.48f, 0.28f, 1.09f, 0.11f, 1.37f, -0.37f);
        v12.lineToRelative(1f, -1.73f);
        v12.curveToRelative(0.28f, -0.48f, 0.11f, -1.09f, -0.37f, -1.37f);
        v12.lineTo(16f, 12f);
        v12.lineToRelative(3.93f, -2.27f);
        v12.curveTo(20.41f, 9.46f, 20.57f, 8.84f, 20.290001f, 8.37f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EmergencyKt._emergency = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

