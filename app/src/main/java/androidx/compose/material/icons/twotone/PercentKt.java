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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_percent", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Percent", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPercent", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PercentKt {
    private static ImageVector _percent;

    static {
    }

    public static final ImageVector getPercent(TwoTone arg19) {
        ImageVector v0 = PercentKt._percent;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Percent", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.5f, 4f);
        v12.curveTo(5.57f, 4f, 4f, 5.57f, 4f, 7.5f);
        v12.reflectiveCurveTo(5.57f, 11f, 7.5f, 11f);
        v12.reflectiveCurveTo(11f, 9.43f, 11f, 7.5f);
        v12.reflectiveCurveTo(9.43f, 4f, 7.5f, 4f);
        v12.close();
        v12.moveTo(7.5f, 9f);
        v12.curveTo(6.67f, 9f, 6f, 8.33f, 6f, 7.5f);
        v12.reflectiveCurveTo(6.67f, 6f, 7.5f, 6f);
        v12.reflectiveCurveTo(9f, 6.67f, 9f, 7.5f);
        v12.reflectiveCurveTo(8.33f, 9f, 7.5f, 9f);
        v12.close();
        v12.moveTo(16.5f, 13f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, 1.57f, -3.5f, 3.5f);
        v12.reflectiveCurveToRelative(1.57f, 3.5f, 3.5f, 3.5f);
        v12.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        v12.reflectiveCurveTo(18.43f, 13f, 16.5f, 13f);
        v12.close();
        v12.moveTo(16.5f, 18f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(17.33f, 18f, 16.5f, 18f);
        v12.close();
        v12.moveTo(5.41f, 20f);
        v12.lineTo(4f, 18.59f);
        v12.lineTo(18.59f, 4f);
        v12.lineTo(20f, 5.41f);
        v12.lineTo(5.41f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PercentKt._percent = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

