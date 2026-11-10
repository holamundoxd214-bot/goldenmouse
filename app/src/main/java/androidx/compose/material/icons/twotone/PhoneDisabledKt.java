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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phoneDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhoneDisabled", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPhoneDisabled", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhoneDisabledKt {
    private static ImageVector _phoneDisabled;

    static {
    }

    public static final ImageVector getPhoneDisabled(TwoTone arg19) {
        ImageVector v0 = PhoneDisabledKt._phoneDisabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.PhoneDisabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.curveTo(15.3f, 6.45f, 15.5f, 5.25f, 15.5f, 4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineTo(20f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.curveTo(21f, 7.98f, 19.629999f, 11.64f, 17.34f, 14.54f);
        v12.close();
        v12.moveTo(14.52f, 17.35f);
        v12.curveTo(11.63f, 19.639999f, 7.97f, 21f, 4f, 21f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-3.49f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.curveToRelative(1.24f, 0f, 2.45f, -0.2f, 3.57f, -0.57f);
        v12.curveToRelative(0.1f, -0.04f, 0.21f, -0.05f, 0.31f, -0.05f);
        v12.curveToRelative(0.26f, 0f, 0.51f, 0.1f, 0.71f, 0.29f);
        v12.lineToRelative(2.2f, 2.2f);
        v12.curveToRelative(0.81f, -0.42f, 1.58f, -0.9f, 2.3f, -1.46f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(1.42f, -1.41f);
        v12.lineTo(21.190001f, 21.200001f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineTo(14.52f, 17.35f);
        v12.close();
        v12.moveTo(17.459999f, 5f);
        v12.curveToRelative(-0.06f, 0.89f, -0.21f, 1.76f, -0.45f, 2.59f);
        v12.lineToRelative(1.2f, 1.2f);
        v12.curveToRelative(0.41f, -1.2f, 0.67f, -2.47f, 0.76f, -3.79f);
        v12.horizontalLineTo(17.459999f);
        v12.close();
        v12.moveTo(7.6f, 17.02f);
        v12.curveToRelative(-0.85f, 0.24f, -1.72f, 0.39f, -2.6f, 0.45f);
        v12.verticalLineToRelative(1.49f);
        v12.curveToRelative(1.32f, -0.09f, 2.59f, -0.35f, 3.8f, -0.75f);
        v12.lineTo(7.6f, 17.02f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhoneDisabledKt._phoneDisabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

