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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_php", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Php", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPhp", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhpKt {
    private static ImageVector _php;

    static {
    }

    public static final ImageVector getPhp(TwoTone arg19) {
        ImageVector v0 = PhpKt._php;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Php", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 9f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineTo(13f);
        v12.verticalLineToRelative(-2.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(15f);
        v12.horizontalLineTo(9.5f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(11f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(8f, 10.5f);
        v12.verticalLineToRelative(1f);
        v12.curveTo(8f, 12.3f, 7.3f, 13f, 6.5f, 13f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(3f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(3.5f);
        v12.curveTo(7.3f, 9f, 8f, 9.7f, 8f, 10.5f);
        v12.close();
        v12.moveTo(6.5f, 10.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(10.5f);
        v12.close();
        v12.moveTo(21.5f, 10.5f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.8f, -0.7f, 1.5f, -1.5f, 1.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-1.5f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(20f);
        v12.curveTo(20.799999f, 9f, 21.5f, 9.7f, 21.5f, 10.5f);
        v12.close();
        v12.moveTo(20f, 10.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(10.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhpKt._php = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

