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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_textRotationAngledown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TextRotationAngledown", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTextRotationAngledown", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TextRotationAngledownKt {
    private static ImageVector _textRotationAngledown;

    static {
    }

    public static final ImageVector getTextRotationAngledown(TwoTone arg18) {
        ImageVector v0 = TextRotationAngledownKt._textRotationAngledown;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.TextRotationAngledown", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(15f, 21f);
        v0_1.verticalLineToRelative(-4.24f);
        v0_1.lineToRelative(-1.41f, 1.41f);
        v0_1.lineToRelative(-9.2f, -9.19f);
        v0_1.lineToRelative(-1.41f, 1.41f);
        v0_1.lineToRelative(9.19f, 9.19f);
        v0_1.lineTo(10.76f, 21f);
        v0_1.lineTo(15f, 21f);
        v0_1.close();
        v0_1.moveTo(11.25f, 8.48f);
        v0_1.lineToRelative(3.54f, 3.54f);
        v0_1.lineToRelative(-0.92f, 2.19f);
        v0_1.lineToRelative(1.48f, 1.48f);
        v0_1.lineToRelative(4.42f, -11.14f);
        v0_1.lineToRelative(-1.06f, -1.05f);
        v0_1.lineTo(7.57f, 7.92f);
        v0_1.lineTo(9.06f, 9.4f);
        v0_1.lineToRelative(2.19f, -0.92f);
        v0_1.close();
        v0_1.moveTo(17.84f, 5.43f);
        v0_1.lineToRelative(-2.23f, 4.87f);
        v0_1.lineToRelative(-2.64f, -2.64f);
        v0_1.lineToRelative(4.87f, -2.23f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TextRotationAngledownKt._textRotationAngledown = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

