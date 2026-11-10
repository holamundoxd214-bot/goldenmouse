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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_safetyCheck", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SafetyCheck", "Landroidx/compose/material/icons/Icons$Rounded;", "getSafetyCheck", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SafetyCheckKt {
    private static ImageVector _safetyCheck;

    static {
    }

    public static final ImageVector getSafetyCheck(Rounded arg19) {
        ImageVector v0 = SafetyCheckKt._safetyCheck;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SafetyCheck", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.3f, 2.26f);
        v12.lineToRelative(-6f, 2.25f);
        v12.curveTo(4.52f, 4.81f, 4f, 5.55f, 4f, 6.39f);
        v12.verticalLineToRelative(4.7f);
        v12.curveToRelative(0f, 4.83f, 3.13f, 9.37f, 7.43f, 10.75f);
        v12.curveToRelative(0.37f, 0.12f, 0.77f, 0.12f, 1.14f, 0f);
        v12.curveToRelative(4.3f, -1.38f, 7.43f, -5.91f, 7.43f, -10.75f);
        v12.verticalLineToRelative(-4.7f);
        v12.curveToRelative(0f, -0.83f, -0.52f, -1.58f, -1.3f, -1.87f);
        v12.lineToRelative(-6f, -2.25f);
        v12.curveTo(12.25f, 2.09f, 11.75f, 2.09f, 11.3f, 2.26f);
        v12.close();
        v12.moveTo(12f, 17f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.reflectiveCurveToRelative(2.24f, -5f, 5f, -5f);
        v12.reflectiveCurveToRelative(5f, 2.24f, 5f, 5f);
        v12.reflectiveCurveTo(14.76f, 17f, 12f, 17f);
        v12.close();
        v12.moveTo(14f, 14f);
        v12.curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f);
        v12.lineToRelative(-1.65f, -1.65f);
        v12.curveToRelative(-0.09f, -0.09f, -0.15f, -0.22f, -0.15f, -0.35f);
        v12.verticalLineTo(9.5f);
        v12.curveTo(11.5f, 9.22f, 11.72f, 9f, 12f, 9f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineToRelative(2.29f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.curveTo(14.2f, 13.49f, 14.2f, 13.8f, 14f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SafetyCheckKt._safetyCheck = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

