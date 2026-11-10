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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mobileOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MobileOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getMobileOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MobileOffKt {
    private static ImageVector _mobileOff;

    static {
    }

    public static final ImageVector getMobileOff(Rounded arg19) {
        ImageVector v0 = MobileOffKt._mobileOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MobileOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 16.440001f);
        v12.lineTo(3.61f, 3.05f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(5f, 7.27f);
        v12.verticalLineTo(21f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(1.02f, 0f, 1.85f, -0.77f, 1.98f, -1.75f);
        v12.lineTo(20f, 22.27f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.reflectiveCurveToRelative(0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(19f, 18.440001f);
        v12.lineToRelative(-2f, -2f);
        v12.close();
        v12.moveTo(7f, 19f);
        v12.verticalLineTo(9.27f);
        v12.lineTo(16.73f, 19f);
        v12.horizontalLineTo(7f);
        v12.close();
        v12.moveTo(17f, 5f);
        v12.verticalLineToRelative(8.61f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-0.71f, 0f, -1.33f, 0.37f, -1.68f, 0.93f);
        v12.lineTo(8.39f, 5f);
        v12.horizontalLineTo(17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MobileOffKt._mobileOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

