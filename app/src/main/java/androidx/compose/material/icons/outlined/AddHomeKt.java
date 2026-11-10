package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_addHome", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddHome", "Landroidx/compose/material/icons/Icons$Outlined;", "getAddHome", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AddHomeKt {
    private static ImageVector _addHome;

    static {
    }

    public static final ImageVector getAddHome(Outlined arg19) {
        ImageVector v0 = AddHomeKt._addHome;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AddHome", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 5.5f);
        v12.lineToRelative(6f, 4.5f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0.7f, 0f, 1.37f, 0.1f, 2f, 0.29f);
        v12.verticalLineTo(9f);
        v12.lineToRelative(-8f, -6f);
        v12.lineTo(4f, 9f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineToRelative(7.68f);
        v12.curveToRelative(-0.3f, -0.62f, -0.5f, -1.29f, -0.6f, -2f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-9f);
        v12.lineTo(12f, 5.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18f, 13f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.24f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.24f, 5f, -5f);
        v12.reflectiveCurveTo(20.76f, 13f, 18f, 13f);
        v12.close();
        v12.moveTo(21f, 18.5f);
        v12.horizontalLineToRelative(-2.5f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-2.5f);
        v12.horizontalLineTo(15f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(2.5f);
        v12.verticalLineTo(15f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2.5f);
        v12.horizontalLineTo(21f);
        v12.verticalLineTo(18.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AddHomeKt._addHome = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

