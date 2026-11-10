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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_foundation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Foundation", "Landroidx/compose/material/icons/Icons$Outlined;", "getFoundation", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FoundationKt {
    private static ImageVector _foundation;

    static {
    }

    public static final ImageVector getFoundation(Outlined arg18) {
        ImageVector v0 = FoundationKt._foundation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Foundation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(19f, 12f);
        v0_1.horizontalLineToRelative(3f);
        v0_1.lineTo(12f, 3f);
        v0_1.lineTo(2f, 12f);
        v0_1.horizontalLineToRelative(3f);
        v0_1.verticalLineToRelative(3f);
        v0_1.horizontalLineTo(3f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(3f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(-3f);
        v0_1.horizontalLineToRelative(4f);
        v0_1.verticalLineToRelative(3f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(-3f);
        v0_1.horizontalLineToRelative(4f);
        v0_1.verticalLineToRelative(3f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(-3f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.verticalLineTo(12f);
        v0_1.close();
        v0_1.moveTo(7f, 15f);
        v0_1.verticalLineToRelative(-4.81f);
        v0_1.lineToRelative(4f, -3.6f);
        v0_1.verticalLineTo(15f);
        v0_1.horizontalLineTo(7f);
        v0_1.close();
        v0_1.moveTo(13f, 15f);
        v0_1.verticalLineTo(6.59f);
        v0_1.lineToRelative(4f, 3.6f);
        v0_1.verticalLineTo(15f);
        v0_1.horizontalLineTo(13f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FoundationKt._foundation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

