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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_disabledVisible", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DisabledVisible", "Landroidx/compose/material/icons/Icons$Rounded;", "getDisabledVisible", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DisabledVisibleKt {
    private static ImageVector _disabledVisible;

    static {
    }

    public static final ImageVector getDisabledVisible(Rounded arg19) {
        ImageVector v0 = DisabledVisibleKt._disabledVisible;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DisabledVisible", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.99f, 12.34f);
        v12.curveTo(22f, 12.23f, 22f, 12.11f, 22f, 12f);
        v12.curveToRelative(0f, -5.52f, -4.48f, -10f, -10f, -10f);
        v12.reflectiveCurveTo(2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 5.17f, 3.93f, 9.43f, 8.96f, 9.95f);
        v12.curveToRelative(-0.93f, -0.73f, -1.72f, -1.64f, -2.32f, -2.68f);
        v12.curveTo(5.9f, 18f, 4f, 15.22f, 4f, 12f);
        v12.curveToRelative(0f, -1.85f, 0.63f, -3.55f, 1.69f, -4.9f);
        v12.lineToRelative(5.66f, 5.66f);
        v12.curveToRelative(0.56f, -0.4f, 1.17f, -0.73f, 1.82f, -1f);
        v12.lineTo(7.1f, 5.69f);
        v12.curveTo(8.45f, 4.63f, 10.15f, 4f, 12f, 4f);
        v12.curveToRelative(4.24f, 0f, 7.7f, 3.29f, 7.98f, 7.45f);
        v12.curveTo(20.690001f, 11.67f, 21.370001f, 11.97f, 21.99f, 12.34f);
        v12.close();
        v12.moveTo(17f, 13f);
        v12.curveToRelative(-3.18f, 0f, -5.9f, 1.87f, -7f, 4.5f);
        v12.curveToRelative(1.1f, 2.63f, 3.82f, 4.5f, 7f, 4.5f);
        v12.reflectiveCurveToRelative(5.9f, -1.87f, 7f, -4.5f);
        v12.curveTo(22.9f, 14.87f, 20.18f, 13f, 17f, 13f);
        v12.close();
        v12.moveTo(17f, 20f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, -1.12f, -2.5f, -2.5f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f);
        v12.curveTo(19.5f, 18.879999f, 18.379999f, 20f, 17f, 20f);
        v12.close();
        v12.moveTo(18.5f, 17.5f);
        v12.curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        v12.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        v12.curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveTo(18.5f, 16.67f, 18.5f, 17.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DisabledVisibleKt._disabledVisible = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

