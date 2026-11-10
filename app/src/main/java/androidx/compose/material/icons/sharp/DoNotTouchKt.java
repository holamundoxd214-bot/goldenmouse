package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_doNotTouch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DoNotTouch", "Landroidx/compose/material/icons/Icons$Sharp;", "getDoNotTouch", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DoNotTouchKt {
    private static ImageVector _doNotTouch;

    static {
    }

    public static final ImageVector getDoNotTouch(Sharp arg18) {
        ImageVector v0 = DoNotTouchKt._doNotTouch;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.DoNotTouch", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(13f, 10.17f);
        v0_1.lineToRelative(-2.5f, -2.5f);
        v0_1.verticalLineTo(1f);
        v0_1.horizontalLineTo(13f);
        v0_1.verticalLineTo(10.17f);
        v0_1.close();
        v0_1.moveTo(20f, 4f);
        v0_1.horizontalLineToRelative(-2.5f);
        v0_1.verticalLineToRelative(7f);
        v0_1.horizontalLineToRelative(-1f);
        v0_1.verticalLineTo(2f);
        v0_1.horizontalLineTo(14f);
        v0_1.verticalLineToRelative(9.17f);
        v0_1.lineToRelative(6f, 6f);
        v0_1.verticalLineTo(4f);
        v0_1.close();
        v0_1.moveTo(9.5f, 3f);
        v0_1.horizontalLineTo(7.01f);
        v0_1.verticalLineToRelative(1.18f);
        v0_1.lineTo(9.5f, 6.67f);
        v0_1.verticalLineTo(3f);
        v0_1.close();
        v0_1.moveTo(21.190001f, 21.190001f);
        v0_1.lineTo(2.81f, 2.81f);
        v0_1.lineTo(1.39f, 4.22f);
        v0_1.lineTo(7f, 9.83f);
        v0_1.verticalLineToRelative(4.3f);
        v0_1.lineToRelative(-3.32f, -1.9f);
        v0_1.lineTo(2f, 13.88f);
        v0_1.lineTo(9.68f, 22f);
        v0_1.horizontalLineToRelative(9.54f);
        v0_1.lineToRelative(0.56f, 0.61f);
        v0_1.lineTo(21.190001f, 21.190001f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DoNotTouchKt._doNotTouch = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

