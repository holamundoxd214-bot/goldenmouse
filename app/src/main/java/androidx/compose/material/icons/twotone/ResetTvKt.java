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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_resetTv", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ResetTv", "Landroidx/compose/material/icons/Icons$TwoTone;", "getResetTv", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ResetTvKt {
    private static ImageVector _resetTv;

    static {
    }

    public static final ImageVector getResetTv(TwoTone arg19) {
        ImageVector v0 = ResetTvKt._resetTv;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.ResetTv", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 10f);
        v12.horizontalLineToRelative(-7.01f);
        v12.verticalLineTo(7f);
        v12.lineTo(9f, 11f);
        v12.lineToRelative(3.99f, 4f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineTo(20f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(0f, -3f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 3f, 2f, 3.9f, 2f, 5f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(1.1f, 0f, 1.99f, -0.9f, 1.99f, -2f);
        v12.lineToRelative(0f, -5f);
        v12.horizontalLineTo(22f);
        v12.curveTo(22f, 10.9f, 21.1f, 10f, 20f, 10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ResetTvKt._resetTv = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

