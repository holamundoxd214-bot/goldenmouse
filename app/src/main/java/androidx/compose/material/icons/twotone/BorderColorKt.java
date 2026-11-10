package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_borderColor", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BorderColor", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBorderColor", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BorderColorKt {
    private static ImageVector _borderColor;

    static {
    }

    public static final ImageVector getBorderColor(TwoTone arg19) {
        ImageVector v0 = BorderColorKt._borderColor;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.BorderColor", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(16.809999f, 8.94f);
        v0_1.lineToRelative(-3.75f, -3.75f);
        v0_1.lineTo(4f, 14.25f);
        v0_1.verticalLineTo(18f);
        v0_1.horizontalLineToRelative(3.75f);
        v0_1.lineTo(16.809999f, 8.94f);
        v0_1.close();
        v0_1.moveTo(6f, 16f);
        v0_1.verticalLineToRelative(-0.92f);
        v0_1.lineToRelative(7.06f, -7.06f);
        v0_1.lineToRelative(0.92f, 0.92f);
        v0_1.lineTo(6.92f, 16f);
        v0_1.horizontalLineTo(6f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.709999f, 6.04f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-2.34f, -2.34f);
        v12.curveTo(17.17f, 2.09f, 16.92f, 2f, 16.66f, 2f);
        v12.curveToRelative(-0.25f, 0f, -0.51f, 0.1f, -0.7f, 0.29f);
        v12.lineToRelative(-1.83f, 1.83f);
        v12.lineToRelative(3.75f, 3.75f);
        v12.lineTo(19.709999f, 6.04f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(2f, 20f);
        v0_1.horizontalLineToRelative(20f);
        v0_1.verticalLineToRelative(4f);
        v0_1.horizontalLineToRelative(-20f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BorderColorKt._borderColor = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

