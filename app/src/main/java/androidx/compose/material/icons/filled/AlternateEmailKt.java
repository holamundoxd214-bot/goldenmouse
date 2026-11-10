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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_alternateEmail", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AlternateEmail", "Landroidx/compose/material/icons/Icons$Filled;", "getAlternateEmail", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AlternateEmailKt {
    private static ImageVector _alternateEmail;

    static {
    }

    public static final ImageVector getAlternateEmail(Filled arg19) {
        ImageVector v0 = AlternateEmailKt._alternateEmail;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.AlternateEmail", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-5f);
        v12.curveToRelative(-4.34f, 0f, -8f, -3.66f, -8f, -8f);
        v12.reflectiveCurveToRelative(3.66f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.66f, 8f, 8f);
        v12.verticalLineToRelative(1.43f);
        v12.curveToRelative(0f, 0.79f, -0.71f, 1.57f, -1.5f, 1.57f);
        v12.reflectiveCurveToRelative(-1.5f, -0.78f, -1.5f, -1.57f);
        v12.lineTo(17f, 12f);
        v12.curveToRelative(0f, -2.76f, -2.24f, -5f, -5f, -5f);
        v12.reflectiveCurveToRelative(-5f, 2.24f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.24f, 5f, 5f, 5f);
        v12.curveToRelative(1.38f, 0f, 2.64f, -0.56f, 3.54f, -1.47f);
        v12.curveToRelative(0.65f, 0.89f, 1.77f, 1.47f, 2.96f, 1.47f);
        v12.curveToRelative(1.97f, 0f, 3.5f, -1.6f, 3.5f, -3.57f);
        v12.lineTo(22f, 12f);
        v12.curveToRelative(0f, -5.52f, -4.48f, -10f, -10f, -10f);
        v12.close();
        v12.moveTo(12f, 15f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.34f, 3f, 3f);
        v12.reflectiveCurveToRelative(-1.34f, 3f, -3f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AlternateEmailKt._alternateEmail = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

