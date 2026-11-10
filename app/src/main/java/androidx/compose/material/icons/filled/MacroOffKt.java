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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_macroOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MacroOff", "Landroidx/compose/material/icons/Icons$Filled;", "getMacroOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MacroOffKt {
    private static ImageVector _macroOff;

    static {
    }

    public static final ImageVector getMacroOff(Filled arg19) {
        ImageVector v0 = MacroOffKt._macroOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.MacroOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.98f, 17.15f);
        v12.curveTo(20.629999f, 15.91f, 21f, 14.5f, 21f, 13f);
        v12.curveToRelative(-1.5f, 0f, -2.91f, 0.37f, -4.15f, 1.02f);
        v12.lineTo(19.98f, 17.15f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(3f, 13f);
        v12.curveToRelative(0f, 4.97f, 4.03f, 9f, 9f, 9f);
        v12.curveTo(12f, 17.030001f, 7.97f, 13f, 3f, 13f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 5.5f);
        v12.curveToRelative(1.38f, 0f, 2.5f, 1.12f, 2.5f, 2.5f);
        v12.curveToRelative(0f, 0.99f, -0.58f, 1.84f, -1.42f, 2.25f);
        v12.lineToRelative(2.48f, 2.48f);
        v12.curveToRelative(0.11f, 0.02f, 0.23f, 0.03f, 0.35f, 0.03f);
        v12.curveToRelative(1.38f, 0f, 2.5f, -1.12f, 2.5f, -2.5f);
        v12.curveToRelative(0f, -1f, -0.59f, -1.85f, -1.43f, -2.25f);
        v12.curveToRelative(0.84f, -0.4f, 1.43f, -1.25f, 1.43f, -2.25f);
        v12.curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        v12.curveToRelative(-0.53f, 0f, -1.01f, 0.16f, -1.42f, 0.44f);
        v12.lineTo(14.5f, 3.5f);
        v12.curveTo(14.5f, 2.12f, 13.38f, 1f, 12f, 1f);
        v12.reflectiveCurveTo(9.5f, 2.12f, 9.5f, 3.5f);
        v12.lineToRelative(0.02f, 0.19f);
        v12.curveTo(9.12f, 3.41f, 8.63f, 3.25f, 8.1f, 3.25f);
        v12.curveToRelative(-0.57f, 0f, -1.09f, 0.2f, -1.51f, 0.52f);
        v12.lineToRelative(3.16f, 3.16f);
        v12.curveTo(10.16f, 6.08f, 11.01f, 5.5f, 12f, 5.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(4.64f, 4.64f);
        v12.curveTo(5.76f, 9.26f, 5.6f, 9.73f, 5.6f, 10.25f);
        v12.curveToRelative(0f, 1.38f, 1.12f, 2.5f, 2.5f, 2.5f);
        v12.curveToRelative(0.52f, 0f, 0.99f, -0.16f, 1.4f, -0.43f);
        v12.lineToRelative(0.02f, 0.02f);
        v12.lineTo(9.5f, 12.5f);
        v12.curveToRelative(0f, 1.38f, 1.12f, 2.5f, 2.5f, 2.5f);
        v12.curveToRelative(0.05f, 0f, 0.1f, -0.01f, 0.16f, -0.02f);
        v12.lineToRelative(1.64f, 1.64f);
        v12.curveTo(12.67f, 18.120001f, 12f, 19.98f, 12f, 22f);
        v12.curveToRelative(2.02f, 0f, 3.88f, -0.67f, 5.38f, -1.8f);
        v12.lineToRelative(2.4f, 2.4f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.81f, 2.81f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MacroOffKt._macroOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

