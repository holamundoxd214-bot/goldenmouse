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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_alternateEmail", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AlternateEmail", "Landroidx/compose/material/icons/Icons$Rounded;", "getAlternateEmail", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AlternateEmailKt {
    private static ImageVector _alternateEmail;

    static {
    }

    public static final ImageVector getAlternateEmail(Rounded arg19) {
        ImageVector v0 = AlternateEmailKt._alternateEmail;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AlternateEmail", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.72f, 2.03f);
        v12.curveTo(6.63f, 1.6f, 1.6f, 6.63f, 2.03f, 12.72f);
        v12.curveTo(2.39f, 18.01f, 7.01f, 22f, 12.31f, 22f);
        v12.horizontalLineTo(16f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-3.67f);
        v12.curveToRelative(-3.73f, 0f, -7.15f, -2.42f, -8.08f, -6.03f);
        v12.curveToRelative(-1.49f, -5.8f, 3.91f, -11.21f, 9.71f, -9.71f);
        v12.curveTo(17.58f, 5.18f, 20f, 8.6f, 20f, 12.33f);
        v12.verticalLineToRelative(1.1f);
        v12.curveToRelative(0f, 0.79f, -0.71f, 1.57f, -1.5f, 1.57f);
        v12.reflectiveCurveToRelative(-1.5f, -0.78f, -1.5f, -1.57f);
        v12.verticalLineToRelative(-1.25f);
        v12.curveToRelative(0f, -2.51f, -1.78f, -4.77f, -4.26f, -5.12f);
        v12.curveToRelative(-3.4f, -0.49f, -6.27f, 2.45f, -5.66f, 5.87f);
        v12.curveToRelative(0.34f, 1.91f, 1.83f, 3.49f, 3.72f, 3.94f);
        v12.curveToRelative(1.84f, 0.43f, 3.59f, -0.16f, 4.74f, -1.33f);
        v12.curveToRelative(0.89f, 1.22f, 2.67f, 1.86f, 4.3f, 1.21f);
        v12.curveToRelative(1.34f, -0.53f, 2.16f, -1.9f, 2.16f, -3.34f);
        v12.verticalLineToRelative(-1.09f);
        v12.curveToRelative(0f, -5.31f, -3.99f, -9.93f, -9.28f, -10.29f);
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

