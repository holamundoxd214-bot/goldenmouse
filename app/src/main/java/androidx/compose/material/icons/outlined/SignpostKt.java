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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_signpost", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Signpost", "Landroidx/compose/material/icons/Icons$Outlined;", "getSignpost", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SignpostKt {
    private static ImageVector _signpost;

    static {
    }

    public static final ImageVector getSignpost(Outlined arg18) {
        ImageVector v0 = SignpostKt._signpost;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Signpost", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(13f, 10f);
        v0_1.horizontalLineToRelative(5f);
        v0_1.lineToRelative(3f, -3f);
        v0_1.lineToRelative(-3f, -3f);
        v0_1.horizontalLineToRelative(-5f);
        v0_1.verticalLineTo(2f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineTo(4f);
        v0_1.verticalLineToRelative(6f);
        v0_1.horizontalLineToRelative(7f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineTo(6f);
        v0_1.lineToRelative(-3f, 3f);
        v0_1.lineToRelative(3f, 3f);
        v0_1.horizontalLineToRelative(5f);
        v0_1.verticalLineToRelative(4f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(-4f);
        v0_1.horizontalLineToRelative(7f);
        v0_1.verticalLineToRelative(-6f);
        v0_1.horizontalLineToRelative(-7f);
        v0_1.verticalLineTo(10f);
        v0_1.close();
        v0_1.moveTo(6f, 6f);
        v0_1.horizontalLineToRelative(11.17f);
        v0_1.lineToRelative(1f, 1f);
        v0_1.lineToRelative(-1f, 1f);
        v0_1.horizontalLineTo(6f);
        v0_1.verticalLineTo(6f);
        v0_1.close();
        v0_1.moveTo(18f, 16f);
        v0_1.horizontalLineTo(6.83f);
        v0_1.lineToRelative(-1f, -1f);
        v0_1.lineToRelative(1f, -1f);
        v0_1.horizontalLineTo(18f);
        v0_1.verticalLineTo(16f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SignpostKt._signpost = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

