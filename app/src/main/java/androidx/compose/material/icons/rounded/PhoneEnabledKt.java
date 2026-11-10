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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phoneEnabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhoneEnabled", "Landroidx/compose/material/icons/Icons$Rounded;", "getPhoneEnabled", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhoneEnabledKt {
    private static ImageVector _phoneEnabled;

    static {
    }

    public static final ImageVector getPhoneEnabled(Rounded arg19) {
        ImageVector v0 = PhoneEnabledKt._phoneEnabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PhoneEnabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.78f, 15.27f);
        v12.lineToRelative(2.54f, -0.29f);
        v12.curveToRelative(0.61f, -0.07f, 1.21f, 0.14f, 1.64f, 0.57f);
        v12.lineToRelative(1.84f, 1.84f);
        v12.curveToRelative(2.83f, -1.44f, 5.15f, -3.75f, 6.59f, -6.59f);
        v12.lineToRelative(-1.85f, -1.85f);
        v12.curveToRelative(-0.43f, -0.43f, -0.64f, -1.03f, -0.57f, -1.64f);
        v12.lineToRelative(0.29f, -2.52f);
        v12.curveToRelative(0.12f, -1.01f, 0.97f, -1.77f, 1.99f, -1.77f);
        v12.horizontalLineToRelative(1.73f);
        v12.curveToRelative(1.13f, 0f, 2.07f, 0.94f, 2f, 2.07f);
        v12.curveToRelative(-0.53f, 8.54f, -7.36f, 15.36f, -15.89f, 15.89f);
        v12.curveToRelative(-1.13f, 0.07f, -2.07f, -0.87f, -2.07f, -2f);
        v12.verticalLineToRelative(-1.73f);
        v12.curveTo(3.01f, 16.24f, 3.77f, 15.39f, 4.78f, 15.27f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhoneEnabledKt._phoneEnabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

