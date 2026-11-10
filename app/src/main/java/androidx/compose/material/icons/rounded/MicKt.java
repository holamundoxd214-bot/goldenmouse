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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mic", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Mic", "Landroidx/compose/material/icons/Icons$Rounded;", "getMic", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MicKt {
    private static ImageVector _mic;

    static {
    }

    public static final ImageVector getMic(Rounded arg19) {
        ImageVector v0 = MicKt._mic;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Mic", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 14f);
        v12.curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f);
        v12.lineTo(15f, 5f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.reflectiveCurveTo(9f, 3.34f, 9f, 5f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.close();
        v12.moveTo(17.91f, 11f);
        v12.curveToRelative(-0.49f, 0f, -0.9f, 0.36f, -0.98f, 0.85f);
        v12.curveTo(16.52f, 14.2f, 14.47f, 16f, 12f, 16f);
        v12.reflectiveCurveToRelative(-4.52f, -1.8f, -4.93f, -4.15f);
        v12.curveToRelative(-0.08f, -0.49f, -0.49f, -0.85f, -0.98f, -0.85f);
        v12.curveToRelative(-0.61f, 0f, -1.09f, 0.54f, -1f, 1.14f);
        v12.curveToRelative(0.49f, 3f, 2.89f, 5.35f, 5.91f, 5.78f);
        v12.lineTo(11f, 20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2.08f);
        v12.curveToRelative(3.02f, -0.43f, 5.42f, -2.78f, 5.91f, -5.78f);
        v12.curveToRelative(0.1f, -0.6f, -0.39f, -1.14f, -1f, -1.14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MicKt._mic = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

