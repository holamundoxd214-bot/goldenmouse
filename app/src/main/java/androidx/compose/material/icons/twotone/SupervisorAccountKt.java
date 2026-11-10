package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_supervisorAccount", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SupervisorAccount", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSupervisorAccount", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SupervisorAccountKt {
    private static ImageVector _supervisorAccount;

    static {
    }

    public static final ImageVector getSupervisorAccount(TwoTone arg20) {
        ImageVector v0 = SupervisorAccountKt._supervisorAccount;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.SupervisorAccount", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 8.5f);
        v12.moveToRelative(-1.5f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, 3f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, -3f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(4.77f, 17f);
        v12.horizontalLineToRelative(4.28f);
        v12.curveToRelative(0.01f, -0.06f, 0.12f, -0.58f, 0.29f, -0.99f);
        v12.curveToRelative(-0.11f, 0f, -0.23f, -0.01f, -0.34f, -0.01f);
        v12.curveToRelative(-1.53f, 0f, -3.25f, 0.5f, -4.23f, 1f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9f, 12f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.reflectiveCurveTo(10.93f, 5f, 9f, 5f);
        v12.reflectiveCurveTo(5.5f, 6.57f, 5.5f, 8.5f);
        v12.reflectiveCurveTo(7.07f, 12f, 9f, 12f);
        v12.close();
        v12.moveTo(9f, 7f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(9.83f, 10f, 9f, 10f);
        v12.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(8.17f, 7f, 9f, 7f);
        v12.close();
        v12.moveTo(9.05f, 17f);
        v12.lineTo(4.77f, 17f);
        v12.curveToRelative(0.99f, -0.5f, 2.7f, -1f, 4.23f, -1f);
        v12.curveToRelative(0.11f, 0f, 0.23f, 0.01f, 0.34f, 0.01f);
        v12.curveToRelative(0.34f, -0.73f, 0.93f, -1.33f, 1.64f, -1.81f);
        v12.curveToRelative(-0.73f, -0.13f, -1.42f, -0.2f, -1.98f, -0.2f);
        v12.curveToRelative(-2.34f, 0f, -7f, 1.17f, -7f, 3.5f);
        v12.lineTo(2f, 19f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(-1.5f);
        v12.curveToRelative(0f, -0.17f, 0.02f, -0.34f, 0.05f, -0.5f);
        v12.close();
        v12.moveTo(16.5f, 14.5f);
        v12.curveToRelative(-1.84f, 0f, -5.5f, 1.01f, -5.5f, 3f);
        v12.lineTo(11f, 19f);
        v12.horizontalLineToRelative(11f);
        v12.verticalLineToRelative(-1.5f);
        v12.curveToRelative(0f, -1.99f, -3.66f, -3f, -5.5f, -3f);
        v12.close();
        v12.moveTo(17.709999f, 12.68f);
        v12.curveToRelative(0.76f, -0.43f, 1.29f, -1.24f, 1.29f, -2.18f);
        v12.curveTo(19f, 9.12f, 17.879999f, 8f, 16.5f, 8f);
        v12.reflectiveCurveTo(14f, 9.12f, 14f, 10.5f);
        v12.curveToRelative(0f, 0.94f, 0.53f, 1.75f, 1.29f, 2.18f);
        v12.curveToRelative(0.36f, 0.2f, 0.77f, 0.32f, 1.21f, 0.32f);
        v12.reflectiveCurveToRelative(0.85f, -0.12f, 1.21f, -0.32f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SupervisorAccountKt._supervisorAccount = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

