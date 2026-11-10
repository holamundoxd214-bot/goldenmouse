package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_repeatOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RepeatOn", "Landroidx/compose/material/icons/Icons$Rounded;", "getRepeatOn", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RepeatOnKt {
    private static ImageVector _repeatOn;

    static {
    }

    public static final ImageVector getRepeatOn(Rounded arg19) {
        ImageVector v0 = RepeatOnKt._repeatOn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RepeatOn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 1f);
        v12.horizontalLineTo(3f);
        v12.curveTo(1.9f, 1f, 1f, 1.9f, 1f, 3f);
        v12.verticalLineToRelative(18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(3f);
        v12.curveTo(23f, 1.9f, 22.1f, 1f, 21f, 1f);
        v12.close();
        v12.moveTo(19f, 18f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(1.79f);
        v12.curveToRelative(0f, 0.45f, -0.54f, 0.67f, -0.85f, 0.36f);
        v12.lineToRelative(-2.79f, -2.79f);
        v12.curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f);
        v12.lineToRelative(2.79f, -2.79f);
        v12.curveTo(6.46f, 14.54f, 7f, 14.76f, 7f, 15.21f);
        v12.verticalLineTo(17f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(18f);
        v12.close();
        v12.moveTo(20.639999f, 6.35f);
        v12.lineToRelative(-2.79f, 2.79f);
        v12.curveTo(17.540001f, 9.46f, 17f, 9.24f, 17f, 8.79f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(11f);
        v12.verticalLineTo(3.21f);
        v12.curveToRelative(0f, -0.45f, 0.54f, -0.67f, 0.85f, -0.36f);
        v12.lineToRelative(2.79f, 2.79f);
        v12.curveTo(20.84f, 5.84f, 20.84f, 6.15f, 20.639999f, 6.35f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RepeatOnKt._repeatOn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

