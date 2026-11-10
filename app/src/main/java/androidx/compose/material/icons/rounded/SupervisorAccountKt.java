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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_supervisorAccount", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SupervisorAccount", "Landroidx/compose/material/icons/Icons$Rounded;", "getSupervisorAccount", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SupervisorAccountKt {
    private static ImageVector _supervisorAccount;

    static {
    }

    public static final ImageVector getSupervisorAccount(Rounded arg19) {
        ImageVector v0 = SupervisorAccountKt._supervisorAccount;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SupervisorAccount", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.5f, 12f);
        v12.curveToRelative(1.38f, 0f, 2.49f, -1.12f, 2.49f, -2.5f);
        v12.reflectiveCurveTo(17.879999f, 7f, 16.5f, 7f);
        v12.reflectiveCurveTo(14f, 8.12f, 14f, 9.5f);
        v12.reflectiveCurveToRelative(1.12f, 2.5f, 2.5f, 2.5f);
        v12.close();
        v12.moveTo(9f, 11f);
        v12.curveToRelative(1.66f, 0f, 2.99f, -1.34f, 2.99f, -3f);
        v12.reflectiveCurveTo(10.66f, 5f, 9f, 5f);
        v12.reflectiveCurveTo(6f, 6.34f, 6f, 8f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.close();
        v12.moveTo(16.5f, 14f);
        v12.curveToRelative(-1.83f, 0f, -5.5f, 0.92f, -5.5f, 2.75f);
        v12.lineTo(11f, 18f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(9f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1.25f);
        v12.curveToRelative(0f, -1.83f, -3.67f, -2.75f, -5.5f, -2.75f);
        v12.close();
        v12.moveTo(9f, 13f);
        v12.curveToRelative(-2.33f, 0f, -7f, 1.17f, -7f, 3.5f);
        v12.lineTo(2f, 18f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-2.25f);
        v12.curveToRelative(0f, -0.85f, 0.33f, -2.34f, 2.37f, -3.47f);
        v12.curveTo(10.5f, 13.1f, 9.66f, 13f, 9f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SupervisorAccountKt._supervisorAccount = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

