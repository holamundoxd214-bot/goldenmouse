package androidx.compose.material.icons.automirrored.filled;

import androidx.compose.material.icons.Icons$AutoMirrored$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phoneCallback", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhoneCallback", "Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;", "getPhoneCallback", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhoneCallbackKt {
    private static ImageVector _phoneCallback;

    static {
    }

    public static final ImageVector getPhoneCallback(Filled arg19) {
        ImageVector v0 = PhoneCallbackKt._phoneCallback;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Filled.PhoneCallback", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.62f, 10.79f);
        v12.curveToRelative(1.44f, 2.83f, 3.76f, 5.14f, 6.59f, 6.59f);
        v12.lineToRelative(2.2f, -2.2f);
        v12.curveToRelative(0.27f, -0.27f, 0.67f, -0.36f, 1.02f, -0.24f);
        v12.curveToRelative(1.12f, 0.37f, 2.33f, 0.57f, 3.57f, 0.57f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.lineTo(21f, 20f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.curveToRelative(-9.39f, 0f, -17f, -7.61f, -17f, -17f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(3.5f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.curveToRelative(0f, 1.25f, 0.2f, 2.45f, 0.57f, 3.57f);
        v12.curveToRelative(0.11f, 0.35f, 0.03f, 0.74f, -0.25f, 1.02f);
        v12.lineToRelative(-2.2f, 2.2f);
        v12.close();
        v12.moveTo(20.16f, 3.69f);
        v12.lineToRelative(-0.71f, -0.7f);
        v12.lineTo(13f, 9.29f);
        v12.lineTo(13f, 5f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(-4.15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhoneCallbackKt._phoneCallback = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

