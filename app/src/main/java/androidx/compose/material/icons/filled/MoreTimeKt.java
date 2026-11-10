package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_moreTime", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MoreTime", "Landroidx/compose/material/icons/Icons$Filled;", "getMoreTime", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MoreTimeKt {
    private static ImageVector _moreTime;

    static {
    }

    public static final ImageVector getMoreTime(Filled arg19) {
        ImageVector v0 = MoreTimeKt._moreTime;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.MoreTime", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(10f, 8f);
        v0_1.lineToRelative(0f, 6f);
        v0_1.lineToRelative(4.7f, 2.9f);
        v0_1.lineToRelative(0.8f, -1.2f);
        v0_1.lineToRelative(-4f, -2.4f);
        v0_1.lineToRelative(0f, -5.3f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.92f, 12f);
        v12.curveToRelative(0.05f, 0.33f, 0.08f, 0.66f, 0.08f, 1f);
        v12.curveToRelative(0f, 3.9f, -3.1f, 7f, -7f, 7f);
        v12.reflectiveCurveToRelative(-7f, -3.1f, -7f, -7f);
        v12.curveToRelative(0f, -3.9f, 3.1f, -7f, 7f, -7f);
        v12.curveToRelative(0.7f, 0f, 1.37f, 0.1f, 2f, 0.29f);
        v12.verticalLineTo(4.23f);
        v12.curveTo(12.36f, 4.08f, 11.69f, 4f, 11f, 4f);
        v12.curveToRelative(-5f, 0f, -9f, 4f, -9f, 9f);
        v12.reflectiveCurveToRelative(4f, 9f, 9f, 9f);
        v12.reflectiveCurveToRelative(9f, -4f, 9f, -9f);
        v12.curveToRelative(0f, -0.34f, -0.02f, -0.67f, -0.06f, -1f);
        v12.horizontalLineTo(17.92f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(20f, 5f);
        v0_1.lineToRelative(0f, -3f);
        v0_1.lineToRelative(-2f, 0f);
        v0_1.lineToRelative(0f, 3f);
        v0_1.lineToRelative(-3f, 0f);
        v0_1.lineToRelative(0f, 2f);
        v0_1.lineToRelative(3f, 0f);
        v0_1.lineToRelative(0f, 3f);
        v0_1.lineToRelative(2f, 0f);
        v0_1.lineToRelative(0f, -3f);
        v0_1.lineToRelative(3f, 0f);
        v0_1.lineToRelative(0f, -2f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MoreTimeKt._moreTime = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

