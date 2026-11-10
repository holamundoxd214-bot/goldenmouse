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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_textIncrease", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TextIncrease", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTextIncrease", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TextIncreaseKt {
    private static ImageVector _textIncrease;

    static {
    }

    public static final ImageVector getTextIncrease(TwoTone arg18) {
        ImageVector v0 = TextIncreaseKt._textIncrease;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.TextIncrease", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(1.99f, 19f);
        v0_1.horizontalLineToRelative(2.42f);
        v0_1.lineToRelative(1.27f, -3.58f);
        v0_1.horizontalLineToRelative(5.65f);
        v0_1.lineTo(12.59f, 19f);
        v0_1.horizontalLineToRelative(2.42f);
        v0_1.lineTo(9.75f, 5f);
        v0_1.horizontalLineToRelative(-2.5f);
        v0_1.lineTo(1.99f, 19f);
        v0_1.close();
        v0_1.moveTo(6.41f, 13.39f);
        v0_1.lineTo(8.44f, 7.6f);
        v0_1.horizontalLineToRelative(0.12f);
        v0_1.lineToRelative(2.03f, 5.79f);
        v0_1.horizontalLineTo(6.41f);
        v0_1.close();
        v0_1.moveTo(20f, 11f);
        v0_1.horizontalLineToRelative(3f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(-3f);
        v0_1.verticalLineToRelative(3f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.verticalLineToRelative(-3f);
        v0_1.horizontalLineToRelative(-3f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.horizontalLineToRelative(3f);
        v0_1.verticalLineTo(8f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineTo(11f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TextIncreaseKt._textIncrease = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

