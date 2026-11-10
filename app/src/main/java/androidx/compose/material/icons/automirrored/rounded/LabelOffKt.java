package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_labelOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LabelOff", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getLabelOff", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LabelOffKt {
    private static ImageVector _labelOff;

    static {
    }

    public static final ImageVector getLabelOff(Rounded arg19) {
        ImageVector v0 = LabelOffKt._labelOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.LabelOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.59f, 12.58f);
        v12.curveToRelative(0.25f, -0.35f, 0.25f, -0.81f, 0f, -1.16f);
        v12.lineToRelative(-3.96f, -5.58f);
        v12.curveTo(17.27f, 5.33f, 16.67f, 5f, 16f, 5f);
        v12.horizontalLineTo(8.66f);
        v12.lineToRelative(10.7f, 10.73f);
        v12.lineToRelative(2.23f, -3.15f);
        v12.close();
        v12.moveTo(2.72f, 4.72f);
        v12.lineToRelative(0.87f, 0.87f);
        v12.curveTo(3.23f, 5.95f, 3f, 6.45f, 3f, 7f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.lineToRelative(1.29f, 1.29f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(4.14f, 3.31f);
        v12.curveToRelative(-0.38f, -0.38f, -1.01f, -0.39f, -1.4f, -0.01f);
        v12.curveToRelative(-0.41f, 0.38f, -0.41f, 1.03f, -0.02f, 1.42f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LabelOffKt._labelOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

