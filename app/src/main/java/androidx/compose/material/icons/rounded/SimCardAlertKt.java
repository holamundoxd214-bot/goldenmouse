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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_simCardAlert", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SimCardAlert", "Landroidx/compose/material/icons/Icons$Rounded;", "getSimCardAlert", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SimCardAlertKt {
    private static ImageVector _simCardAlert;

    static {
    }

    public static final ImageVector getSimCardAlert(Rounded arg19) {
        ImageVector v0 = SimCardAlertKt._simCardAlert;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SimCardAlert", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 2f);
        v12.horizontalLineToRelative(-7.17f);
        v12.curveTo(10.3f, 2f, 9.79f, 2.21f, 9.41f, 2.59f);
        v12.lineTo(4.6f, 7.42f);
        v12.curveTo(4.23f, 7.79f, 4.02f, 8.3f, 4.02f, 8.82f);
        v12.lineTo(4f, 20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(20f, 2.9f, 19.1f, 2f, 18f, 2f);
        v12.close();
        v12.moveTo(12f, 17f);
        v12.lineTo(12f, 17f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(13f, 16.549999f, 12.55f, 17f, 12f, 17f);
        v12.close();
        v12.moveTo(12f, 13f);
        v12.lineTo(12f, 13f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(13f, 12.55f, 12.55f, 13f, 12f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SimCardAlertKt._simCardAlert = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

