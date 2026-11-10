package androidx.compose.material.icons.automirrored.sharp;

import androidx.compose.material.icons.Icons$AutoMirrored$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_stickyNote2", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StickyNote2", "Landroidx/compose/material/icons/Icons$AutoMirrored$Sharp;", "getStickyNote2", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StickyNote2Kt {
    private static ImageVector _stickyNote2;

    static {
    }

    public static final ImageVector getStickyNote2(Sharp arg18) {
        ImageVector v0 = StickyNote2Kt._stickyNote2;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Sharp.StickyNote2", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(2.99f, 3f);
        v0_1.lineTo(3f, 21f);
        v0_1.horizontalLineToRelative(12f);
        v0_1.lineToRelative(6f, -6f);
        v0_1.verticalLineTo(3f);
        v0_1.horizontalLineTo(2.99f);
        v0_1.close();
        v0_1.moveTo(7f, 8f);
        v0_1.horizontalLineToRelative(10f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineTo(7f);
        v0_1.verticalLineTo(8f);
        v0_1.close();
        v0_1.moveTo(12f, 14f);
        v0_1.horizontalLineTo(7f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.horizontalLineToRelative(5f);
        v0_1.verticalLineTo(14f);
        v0_1.close();
        v0_1.moveTo(14f, 19.5f);
        v0_1.verticalLineTo(14f);
        v0_1.horizontalLineToRelative(5.5f);
        v0_1.lineTo(14f, 19.5f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StickyNote2Kt._stickyNote2 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

