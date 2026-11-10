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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_emergencyShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EmergencyShare", "Landroidx/compose/material/icons/Icons$Rounded;", "getEmergencyShare", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EmergencyShareKt {
    private static ImageVector _emergencyShare;

    static {
    }

    public static final ImageVector getEmergencyShare(Rounded arg19) {
        ImageVector v0 = EmergencyShareKt._emergencyShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.EmergencyShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 9f);
        v12.curveToRelative(-3.15f, 0f, -6f, 2.41f, -6f, 6.15f);
        v12.curveToRelative(0f, 2.35f, 1.78f, 5.11f, 5.34f, 8.27f);
        v12.curveToRelative(0.37f, 0.33f, 0.95f, 0.33f, 1.33f, 0f);
        v12.curveTo(16.219999f, 20.25f, 18f, 17.5f, 18f, 15.15f);
        v12.curveTo(18f, 11.41f, 15.15f, 9f, 12f, 9f);
        v12.close();
        v12.moveTo(12f, 16.5f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(12.83f, 16.5f, 12f, 16.5f);
        v12.close();
        v12.moveTo(16.18f, 6.82f);
        v12.curveToRelative(-0.35f, 0.35f, -0.89f, 0.38f, -1.3f, 0.09f);
        v12.curveTo(14.07f, 6.34f, 13.07f, 6f, 12f, 6f);
        v12.reflectiveCurveTo(9.93f, 6.34f, 9.12f, 6.91f);
        v12.curveToRelative(-0.41f, 0.28f, -0.95f, 0.26f, -1.3f, -0.09f);
        v12.curveToRelative(-0.43f, -0.43f, -0.39f, -1.15f, 0.09f, -1.5f);
        v12.curveTo(9.06f, 4.49f, 10.48f, 4f, 12f, 4f);
        v12.reflectiveCurveToRelative(2.94f, 0.49f, 4.09f, 1.32f);
        v12.curveTo(16.58f, 5.67f, 16.610001f, 6.39f, 16.18f, 6.82f);
        v12.close();
        v12.moveTo(4.97f, 3.97f);
        v12.curveTo(4.55f, 3.54f, 4.59f, 2.85f, 5.05f, 2.47f);
        v12.curveTo(6.95f, 0.93f, 9.37f, 0f, 12.01f, 0f);
        v12.curveToRelative(2.64f, 0f, 5.06f, 0.93f, 6.95f, 2.48f);
        v12.curveToRelative(0.46f, 0.38f, 0.5f, 1.07f, 0.08f, 1.49f);
        v12.curveToRelative(-0.36f, 0.36f, -0.93f, 0.39f, -1.32f, 0.07f);
        v12.curveTo(16.16f, 2.77f, 14.17f, 2f, 12.01f, 2f);
        v12.curveTo(9.83f, 2f, 7.84f, 2.77f, 6.29f, 4.04f);
        v12.curveTo(5.9f, 4.36f, 5.33f, 4.32f, 4.97f, 3.97f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EmergencyShareKt._emergencyShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

