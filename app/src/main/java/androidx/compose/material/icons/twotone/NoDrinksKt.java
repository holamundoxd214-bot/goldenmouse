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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noDrinks", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoDrinks", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNoDrinks", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoDrinksKt {
    private static ImageVector _noDrinks;

    static {
    }

    public static final ImageVector getNoDrinks(TwoTone arg22) {
        ImageVector v0 = NoDrinksKt._noDrinks;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.NoDrinks", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(14.77f, 9f);
        v0_1.lineToRelative(-2.94f, 0f);
        v0_1.lineToRelative(1.55f, 1.56f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(21.190001f, 21.190001f);
        v0_1.lineTo(2.81f, 2.81f);
        v0_1.lineTo(1.39f, 4.22f);
        v0_1.lineToRelative(8.23f, 8.23f);
        v0_1.lineTo(11f, 14f);
        v0_1.verticalLineToRelative(5f);
        v0_1.horizontalLineTo(6f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(12f);
        v0_1.verticalLineToRelative(-0.17f);
        v0_1.lineToRelative(1.78f, 1.78f);
        v0_1.lineTo(21.190001f, 21.190001f);
        v0_1.close();
        v0_1.moveTo(13f, 19f);
        v0_1.verticalLineToRelative(-3.17f);
        v0_1.lineTo(16.17f, 19f);
        v0_1.horizontalLineTo(13f);
        v0_1.close();
        v0_1.moveTo(7.83f, 5f);
        v0_1.lineToRelative(-2f, -2f);
        v0_1.horizontalLineTo(21f);
        v0_1.verticalLineToRelative(2f);
        v0_1.lineToRelative(-6.2f, 6.97f);
        v0_1.lineToRelative(-1.42f, -1.42f);
        v0_1.lineTo(14.77f, 9f);
        v0_1.horizontalLineToRelative(-2.94f);
        v0_1.lineToRelative(-2f, -2f);
        v0_1.horizontalLineToRelative(6.74f);
        v0_1.lineToRelative(1.78f, -2f);
        v0_1.horizontalLineTo(7.83f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoDrinksKt._noDrinks = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

