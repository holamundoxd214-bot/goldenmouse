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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hvac", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Hvac", "Landroidx/compose/material/icons/Icons$TwoTone;", "getHvac", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HvacKt {
    private static ImageVector _hvac;

    static {
    }

    public static final ImageVector getHvac(TwoTone arg19) {
        ImageVector v0 = HvacKt._hvac;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Hvac", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5f, 19f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineTo(5f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(19f);
        v12.close();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(3.31f, 0f, 6f, 2.69f, 6f, 6f);
        v12.reflectiveCurveToRelative(-2.69f, 6f, -6f, 6f);
        v12.reflectiveCurveToRelative(-6f, -2.69f, -6f, -6f);
        v12.reflectiveCurveTo(8.69f, 6f, 12f, 6f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(21f, 3.9f, 20.1f, 3f, 19f, 3f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineTo(19f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(3.31f, 0f, 6f, -2.69f, 6f, -6f);
        v12.reflectiveCurveToRelative(-2.69f, -6f, -6f, -6f);
        v12.reflectiveCurveToRelative(-6f, 2.69f, -6f, 6f);
        v12.reflectiveCurveTo(8.69f, 18f, 12f, 18f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-1.01f, 0f, -1.91f, -0.39f, -2.62f, -1f);
        v12.horizontalLineToRelative(5.24f);
        v12.curveTo(13.91f, 15.61f, 13.01f, 16f, 12f, 16f);
        v12.close();
        v12.moveTo(12f, 8f);
        v12.curveToRelative(1.01f, 0f, 1.91f, 0.39f, 2.62f, 1f);
        v12.horizontalLineTo(9.38f);
        v12.curveTo(10.09f, 8.39f, 10.99f, 8f, 12f, 8f);
        v12.close();
        v12.moveTo(8.56f, 10f);
        v12.horizontalLineToRelative(6.89f);
        v12.curveToRelative(0.26f, 0.45f, 0.44f, 0.96f, 0.51f, 1.5f);
        v12.horizontalLineToRelative(-7.9f);
        v12.curveTo(8.12f, 10.96f, 8.29f, 10.45f, 8.56f, 10f);
        v12.close();
        v12.moveTo(15.95f, 12.5f);
        v12.curveToRelative(-0.07f, 0.54f, -0.24f, 1.05f, -0.51f, 1.5f);
        v12.horizontalLineTo(8.56f);
        v12.curveToRelative(-0.26f, -0.45f, -0.44f, -0.96f, -0.51f, -1.5f);
        v12.horizontalLineTo(15.95f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HvacKt._hvac = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

