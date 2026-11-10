package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_crisisAlert", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CrisisAlert", "Landroidx/compose/material/icons/Icons$Filled;", "getCrisisAlert", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CrisisAlertKt {
    private static ImageVector _crisisAlert;

    static {
    }

    public static final ImageVector getCrisisAlert(Filled arg19) {
        ImageVector v0 = CrisisAlertKt._crisisAlert;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.CrisisAlert", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.5f, 2.5f);
        v12.curveToRelative(0f, 1.5f, -1.5f, 6f, -1.5f, 6f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0f, 0f, -1.5f, -4.5f, -1.5f, -6f);
        v12.curveTo(9.5f, 1.12f, 10.62f, 0f, 12f, 0f);
        v12.reflectiveCurveTo(14.5f, 1.12f, 14.5f, 2.5f);
        v12.close();
        v12.moveTo(12f, 10f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(13.1f, 10f, 12f, 10f);
        v12.close();
        v12.moveTo(16.08f, 5.11f);
        v12.curveToRelative(0.18f, -0.75f, 0.33f, -1.47f, 0.39f, -2.06f);
        v12.curveTo(19.75f, 4.69f, 22f, 8.08f, 22f, 12f);
        v12.curveToRelative(0f, 5.52f, -4.48f, 10f, -10f, 10f);
        v12.reflectiveCurveTo(2f, 17.52f, 2f, 12f);
        v12.curveToRelative(0f, -3.92f, 2.25f, -7.31f, 5.53f, -8.95f);
        v12.curveTo(7.6f, 3.64f, 7.74f, 4.37f, 7.92f, 5.11f);
        v12.curveTo(5.58f, 6.51f, 4f, 9.07f, 4f, 12f);
        v12.curveToRelative(0f, 4.42f, 3.58f, 8f, 8f, 8f);
        v12.reflectiveCurveToRelative(8f, -3.58f, 8f, -8f);
        v12.curveTo(20f, 9.07f, 18.42f, 6.51f, 16.08f, 5.11f);
        v12.close();
        v12.moveTo(18f, 12f);
        v12.curveToRelative(0f, 3.31f, -2.69f, 6f, -6f, 6f);
        v12.reflectiveCurveToRelative(-6f, -2.69f, -6f, -6f);
        v12.curveToRelative(0f, -2f, 0.98f, -3.77f, 2.48f, -4.86f);
        v12.curveToRelative(0.23f, 0.81f, 0.65f, 2.07f, 0.65f, 2.07f);
        v12.curveTo(8.43f, 9.93f, 8f, 10.92f, 8f, 12f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.curveToRelative(0f, -1.08f, -0.43f, -2.07f, -1.13f, -2.79f);
        v12.curveToRelative(0f, 0f, 0.41f, -1.22f, 0.65f, -2.07f);
        v12.curveTo(17.02f, 8.23f, 18f, 10f, 18f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CrisisAlertKt._crisisAlert = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

