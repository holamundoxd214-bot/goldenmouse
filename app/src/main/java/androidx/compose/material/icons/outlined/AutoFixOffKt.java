package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_autoFixOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AutoFixOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getAutoFixOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AutoFixOffKt {
    private static ImageVector _autoFixOff;

    static {
    }

    public static final ImageVector getAutoFixOff(Outlined arg19) {
        ImageVector v0 = AutoFixOffKt._autoFixOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AutoFixOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(20f, 7f);
        v0_1.lineToRelative(0.94f, -2.06f);
        v0_1.lineToRelative(2.06f, -0.94f);
        v0_1.lineToRelative(-2.06f, -0.94f);
        v0_1.lineToRelative(-0.94f, -2.06f);
        v0_1.lineToRelative(-0.94f, 2.06f);
        v0_1.lineToRelative(-2.06f, 0.94f);
        v0_1.lineToRelative(2.06f, 0.94f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.17f, 8.42f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(-1.46f, 1.46f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(2.17f, -2.17f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-2.83f, -2.83f);
        v12.curveTo(14.68f, 6.1f, 14.43f, 6f, 14.17f, 6f);
        v12.curveToRelative(-0.26f, 0f, -0.51f, 0.1f, -0.71f, 0.29f);
        v12.lineToRelative(-2.17f, 2.17f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineTo(14.17f, 8.42f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(1.39f, 4.22f);
        v12.lineToRelative(7.07f, 7.07f);
        v12.lineToRelative(-6.17f, 6.17f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.83f, 2.83f);
        v12.curveTo(5.32f, 21.9f, 5.57f, 22f, 5.83f, 22f);
        v12.reflectiveCurveToRelative(0.51f, -0.1f, 0.71f, -0.29f);
        v12.lineToRelative(6.17f, -6.17f);
        v12.lineToRelative(7.07f, 7.07f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.close();
        v12.moveTo(11.29f, 14.12f);
        v12.lineToRelative(-5.46f, 5.46f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(5.46f, -5.46f);
        v12.lineTo(11.29f, 14.12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AutoFixOffKt._autoFixOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

