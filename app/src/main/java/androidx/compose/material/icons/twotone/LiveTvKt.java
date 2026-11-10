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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_liveTv", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LiveTv", "Landroidx/compose/material/icons/Icons$TwoTone;", "getLiveTv", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LiveTvKt {
    private static ImageVector _liveTv;

    static {
    }

    public static final ImageVector getLiveTv(TwoTone arg19) {
        ImageVector v0 = LiveTvKt._liveTv;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.LiveTv", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(3f, 20f);
        v0_1.horizontalLineToRelative(18f);
        v0_1.lineTo(21f, 8f);
        v0_1.lineTo(3f, 8f);
        v0_1.verticalLineToRelative(12f);
        v0_1.close();
        v0_1.moveTo(9f, 10f);
        v0_1.lineToRelative(7f, 4f);
        v0_1.lineToRelative(-7f, 4f);
        v0_1.verticalLineToRelative(-8f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 10f);
        v12.verticalLineToRelative(8f);
        v12.lineToRelative(7f, -4f);
        v12.close();
        v12.moveTo(21f, 6f);
        v12.horizontalLineToRelative(-7.58f);
        v12.lineToRelative(3.29f, -3.29f);
        v12.lineTo(16f, 2f);
        v12.lineToRelative(-4f, 4f);
        v12.horizontalLineToRelative(-0.03f);
        v12.lineToRelative(-4f, -4f);
        v12.lineToRelative(-0.69f, 0.71f);
        v12.lineTo(10.56f, 6f);
        v12.lineTo(3f, 6f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(23f, 8f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(21f, 20f);
        v12.lineTo(3f, 20f);
        v12.lineTo(3f, 8f);
        v12.horizontalLineToRelative(18f);
        v12.verticalLineToRelative(12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LiveTvKt._liveTv = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

