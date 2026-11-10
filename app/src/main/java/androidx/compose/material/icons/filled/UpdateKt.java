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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_update", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Update", "Landroidx/compose/material/icons/Icons$Filled;", "getUpdate", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UpdateKt {
    private static ImageVector _update;

    static {
    }

    public static final ImageVector getUpdate(Filled arg19) {
        ImageVector v0 = UpdateKt._update;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Update", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 10.12f);
        v12.horizontalLineToRelative(-6.78f);
        v12.lineToRelative(2.74f, -2.82f);
        v12.curveToRelative(-2.73f, -2.7f, -7.15f, -2.8f, -9.88f, -0.1f);
        v12.curveToRelative(-2.73f, 2.71f, -2.73f, 7.08f, 0f, 9.79f);
        v12.reflectiveCurveToRelative(7.15f, 2.71f, 9.88f, 0f);
        v12.curveTo(18.32f, 15.65f, 19f, 14.08f, 19f, 12.1f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, 1.98f, -0.88f, 4.55f, -2.64f, 6.29f);
        v12.curveToRelative(-3.51f, 3.48f, -9.21f, 3.48f, -12.72f, 0f);
        v12.curveToRelative(-3.5f, -3.47f, -3.53f, -9.11f, -0.02f, -12.58f);
        v12.reflectiveCurveToRelative(9.14f, -3.47f, 12.65f, 0f);
        v12.lineTo(21f, 3f);
        v12.verticalLineTo(10.12f);
        v12.close();
        v12.moveTo(12.5f, 8f);
        v12.verticalLineToRelative(4.25f);
        v12.lineToRelative(3.5f, 2.08f);
        v12.lineToRelative(-0.72f, 1.21f);
        v12.lineTo(11f, 13f);
        v12.verticalLineTo(8f);
        v12.horizontalLineTo(12.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UpdateKt._update = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

