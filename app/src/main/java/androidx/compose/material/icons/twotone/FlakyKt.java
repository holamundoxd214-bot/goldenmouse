package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_flaky", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Flaky", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFlaky", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FlakyKt {
    private static ImageVector _flaky;

    static {
    }

    public static final ImageVector getFlaky(TwoTone arg19) {
        ImageVector v0 = FlakyKt._flaky;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Flaky", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.05f, 17.58f);
        v12.lineToRelative(-0.01f, 0.01f);
        v12.lineToRelative(-2.4f, -2.4f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineToRelative(1.35f, 1.35f);
        v12.lineTo(16.540001f, 13f);
        v12.lineToRelative(1.06f, 1.06f);
        v12.lineToRelative(-3.54f, 3.54f);
        v12.lineTo(14.05f, 17.58f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.5f, 2f, 2f, 6.5f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.5f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.5f, 10f, -10f);
        v12.reflectiveCurveTo(17.5f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(7.34f, 6.28f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(1.06f, 1.06f);
        v12.lineTo(9.81f, 8.75f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineTo(8.75f, 9.81f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(-1.06f, -1.06f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(6.28f, 7.34f);
        v12.lineTo(7.34f, 6.28f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-2.2f, 0f, -4.2f, -0.9f, -5.7f, -2.3f);
        v12.lineTo(17.700001f, 6.3f);
        v12.curveTo(19.1f, 7.8f, 20f, 9.8f, 20f, 12f);
        v12.curveTo(20f, 16.4f, 16.4f, 20f, 12f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FlakyKt._flaky = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

