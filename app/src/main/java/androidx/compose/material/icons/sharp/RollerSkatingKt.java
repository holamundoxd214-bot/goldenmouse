package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rollerSkating", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RollerSkating", "Landroidx/compose/material/icons/Icons$Sharp;", "getRollerSkating", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RollerSkatingKt {
    private static ImageVector _rollerSkating;

    static {
    }

    public static final ImageVector getRollerSkating(Sharp arg19) {
        ImageVector v0 = RollerSkatingKt._rollerSkating;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.RollerSkating", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 16f);
        v12.lineToRelative(-0.01f, -6f);
        v12.lineToRelative(-5.71f, -1.43f);
        v12.curveTo(13.4f, 8.35f, 12.7f, 7.76f, 12.32f, 7f);
        v12.horizontalLineTo(9f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(3.02f);
        v12.lineTo(12f, 5f);
        v12.horizontalLineTo(9f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineTo(1f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(15f);
        v12.horizontalLineTo(20f);
        v12.close();
        v12.moveTo(5f, 23f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.34f, 3f, 3f);
        v12.reflectiveCurveTo(6.66f, 23f, 5f, 23f);
        v12.close();
        v12.moveTo(19f, 23f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.34f, 3f, 3f);
        v12.reflectiveCurveTo(20.66f, 23f, 19f, 23f);
        v12.close();
        v12.moveTo(12f, 23f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.34f, 3f, 3f);
        v12.reflectiveCurveTo(13.66f, 23f, 12f, 23f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RollerSkatingKt._rollerSkating = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

