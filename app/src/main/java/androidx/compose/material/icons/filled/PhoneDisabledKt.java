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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phoneDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhoneDisabled", "Landroidx/compose/material/icons/Icons$Filled;", "getPhoneDisabled", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhoneDisabledKt {
    private static ImageVector _phoneDisabled;

    static {
    }

    public static final ImageVector getPhoneDisabled(Filled arg19) {
        ImageVector v0 = PhoneDisabledKt._phoneDisabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PhoneDisabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.34f, 14.54f);
        v12.lineToRelative(-1.43f, -1.43f);
        v12.curveToRelative(0.56f, -0.73f, 1.05f, -1.5f, 1.47f, -2.32f);
        v12.lineToRelative(-2.2f, -2.2f);
        v12.curveToRelative(-0.28f, -0.28f, -0.36f, -0.67f, -0.25f, -1.02f);
        v12.curveToRelative(0.37f, -1.12f, 0.57f, -2.32f, 0.57f, -3.57f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.lineTo(20f, 3f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.curveToRelative(0f, 3.98f, -1.37f, 7.64f, -3.66f, 10.54f);
        v12.close();
        v12.moveTo(14.52f, 17.35f);
        v12.curveTo(11.63f, 19.639999f, 7.97f, 21f, 4f, 21f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-3.49f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.curveToRelative(1.24f, 0f, 2.45f, -0.2f, 3.57f, -0.57f);
        v12.curveToRelative(0.35f, -0.12f, 0.75f, -0.03f, 1.02f, 0.24f);
        v12.lineToRelative(2.2f, 2.2f);
        v12.curveToRelative(0.81f, -0.42f, 1.58f, -0.9f, 2.3f, -1.46f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(1.42f, -1.41f);
        v12.lineTo(21.190001f, 21.200001f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(-5.26f, -5.26f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhoneDisabledKt._phoneDisabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

