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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_transgender", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Transgender", "Landroidx/compose/material/icons/Icons$Filled;", "getTransgender", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TransgenderKt {
    private static ImageVector _transgender;

    static {
    }

    public static final ImageVector getTransgender(Filled arg19) {
        ImageVector v0 = TransgenderKt._transgender;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Transgender", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 8f);
        v12.curveToRelative(1.93f, 0f, 3.5f, 1.57f, 3.5f, 3.5f);
        v12.reflectiveCurveTo(13.93f, 15f, 12f, 15f);
        v12.reflectiveCurveToRelative(-3.5f, -1.57f, -3.5f, -3.5f);
        v12.reflectiveCurveTo(10.07f, 8f, 12f, 8f);
        v12.close();
        v12.moveTo(16.530001f, 8.38f);
        v12.lineToRelative(3.97f, -3.96f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(1f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2.58f);
        v12.lineToRelative(-3.97f, 3.97f);
        v12.curveTo(14.23f, 6.36f, 13.16f, 6f, 12f, 6f);
        v12.curveToRelative(-1.16f, 0f, -2.23f, 0.36f, -3.11f, 0.97f);
        v12.lineTo(8.24f, 6.32f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(8.24f, 3.49f);
        v12.lineTo(6.82f, 4.9f);
        v12.lineTo(4.92f, 3f);
        v12.horizontalLineTo(7.5f);
        v12.verticalLineTo(1f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(4.42f);
        v12.lineToRelative(1.91f, 1.9f);
        v12.lineTo(3.99f, 7.74f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(0.65f, 0.65f);
        v12.curveTo(6.86f, 9.27f, 6.5f, 10.34f, 6.5f, 11.5f);
        v12.curveToRelative(0f, 2.7f, 1.94f, 4.94f, 4.5f, 5.41f);
        v12.lineTo(11f, 19f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2f);
        v12.lineToRelative(0f, -2.09f);
        v12.curveToRelative(2.56f, -0.47f, 4.5f, -2.71f, 4.5f, -5.41f);
        v12.curveTo(17.5f, 10.34f, 17.139999f, 9.27f, 16.530001f, 8.38f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TransgenderKt._transgender = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

