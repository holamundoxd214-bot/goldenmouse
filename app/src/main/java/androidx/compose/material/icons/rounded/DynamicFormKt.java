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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dynamicForm", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DynamicForm", "Landroidx/compose/material/icons/Icons$Rounded;", "getDynamicForm", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DynamicFormKt {
    private static ImageVector _dynamicForm;

    static {
    }

    public static final ImageVector getDynamicForm(Rounded arg19) {
        ImageVector v0 = DynamicFormKt._dynamicForm;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DynamicForm", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.68f, 9.71f);
        v12.lineToRelative(-3.72f, 8.19f);
        v12.curveTo(17.73f, 18.389999f, 17f, 18.23f, 17f, 17.690001f);
        v12.verticalLineTo(11f);
        v12.horizontalLineToRelative(-1.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-6f);
        v12.curveTo(15f, 4.22f, 15.22f, 4f, 15.5f, 4f);
        v12.horizontalLineToRelative(5.76f);
        v12.curveToRelative(0.35f, 0f, 0.6f, 0.36f, 0.46f, 0.69f);
        v12.lineTo(20f, 9f);
        v12.horizontalLineToRelative(1.22f);
        v12.curveTo(21.59f, 9f, 21.83f, 9.38f, 21.68f, 9.71f);
        v12.close();
        v12.moveTo(15f, 13f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineTo(15f);
        v12.close();
        v12.moveTo(6.25f, 16.5f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.reflectiveCurveToRelative(-0.75f, 0.34f, -0.75f, 0.75f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(6.25f, 16.91f, 6.25f, 16.5f);
        v12.close();
        v12.moveTo(13f, 4f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineTo(13f);
        v12.close();
        v12.moveTo(6.25f, 7.5f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(4.75f, 7.09f, 4.75f, 7.5f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(6.25f, 7.91f, 6.25f, 7.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DynamicFormKt._dynamicForm = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

