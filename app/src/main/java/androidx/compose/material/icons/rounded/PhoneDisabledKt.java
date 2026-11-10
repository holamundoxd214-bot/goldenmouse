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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phoneDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhoneDisabled", "Landroidx/compose/material/icons/Icons$Rounded;", "getPhoneDisabled", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhoneDisabledKt {
    private static ImageVector _phoneDisabled;

    static {
    }

    public static final ImageVector getPhoneDisabled(Rounded arg19) {
        ImageVector v0 = PhoneDisabledKt._phoneDisabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PhoneDisabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.54f, 17.370001f);
        v12.curveToRelative(-2.63f, 2.08f, -5.89f, 3.39f, -9.45f, 3.61f);
        v12.curveToRelative(-1.13f, 0.07f, -2.07f, -0.87f, -2.07f, -2f);
        v12.verticalLineToRelative(-1.73f);
        v12.curveToRelative(-0.01f, -1.01f, 0.75f, -1.86f, 1.76f, -1.98f);
        v12.lineToRelative(2.54f, -0.29f);
        v12.curveToRelative(0.61f, -0.07f, 1.21f, 0.14f, 1.64f, 0.57f);
        v12.lineToRelative(1.84f, 1.84f);
        v12.curveToRelative(0.81f, -0.41f, 1.59f, -0.9f, 2.31f, -1.45f);
        v12.lineTo(2.1f, 4.93f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 1.03f, -0.39f, 1.42f, 0f);
        v12.lineTo(20.49f, 20.5f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.reflectiveCurveToRelative(-1.02f, 0.39f, -1.41f, 0f);
        v12.lineTo(14.54f, 17.370001f);
        v12.close();
        v12.moveTo(17.389999f, 10.8f);
        v12.lineToRelative(-1.85f, -1.85f);
        v12.curveToRelative(-0.43f, -0.43f, -0.64f, -1.03f, -0.57f, -1.64f);
        v12.lineToRelative(0.29f, -2.52f);
        v12.curveToRelative(0.12f, -1.01f, 0.97f, -1.77f, 1.99f, -1.77f);
        v12.horizontalLineToRelative(1.73f);
        v12.curveToRelative(1.13f, 0f, 2.07f, 0.94f, 2f, 2.07f);
        v12.curveToRelative(-0.22f, 3.57f, -1.54f, 6.83f, -3.62f, 9.47f);
        v12.lineToRelative(-1.43f, -1.43f);
        v12.curveTo(16.48f, 12.4f, 16.969999f, 11.62f, 17.389999f, 10.8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhoneDisabledKt._phoneDisabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

