package androidx.compose.material.icons.automirrored.twotone;

import androidx.compose.material.icons.Icons$AutoMirrored$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_labelOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LabelOff", "Landroidx/compose/material/icons/Icons$AutoMirrored$TwoTone;", "getLabelOff", "(Landroidx/compose/material/icons/Icons$AutoMirrored$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LabelOffKt {
    private static ImageVector _labelOff;

    static {
    }

    public static final ImageVector getLabelOff(TwoTone arg19) {
        ImageVector v0 = LabelOffKt._labelOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.TwoTone.LabelOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(5f, 7.03f);
        v0_1.verticalLineTo(17f);
        v0_1.horizontalLineToRelative(9.97f);
        v0_1.close();
        v0_1.moveTo(16f, 7f);
        v0_1.horizontalLineToRelative(-5.37f);
        v0_1.lineToRelative(7.29f, 7.29f);
        v0_1.lineTo(19.549999f, 12f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 7f);
        v12.lineToRelative(3.55f, 5f);
        v12.lineToRelative(-1.63f, 2.29f);
        v12.lineToRelative(1.43f, 1.43f);
        v12.lineTo(22f, 12f);
        v12.lineToRelative(-4.37f, -6.16f);
        v12.curveTo(17.27f, 5.33f, 16.67f, 5f, 16f, 5f);
        v12.lineToRelative(-7.37f, 0.01f);
        v12.lineToRelative(2f, 1.99f);
        v12.lineTo(16f, 7f);
        v12.close();
        v12.moveTo(2f, 4.03f);
        v12.lineToRelative(1.58f, 1.58f);
        v12.curveTo(3.22f, 5.96f, 3f, 6.46f, 3f, 7f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 1.99f, 2f, 1.99f);
        v12.lineTo(16f, 19f);
        v12.curveToRelative(0.28f, 0f, 0.55f, -0.07f, 0.79f, -0.18f);
        v12.lineTo(18.969999f, 21f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(3.41f, 2.62f);
        v12.lineTo(2f, 4.03f);
        v12.close();
        v12.moveTo(5f, 7.03f);
        v12.lineTo(14.97f, 17f);
        v12.lineTo(5f, 17f);
        v12.lineTo(5f, 7.03f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LabelOffKt._labelOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

