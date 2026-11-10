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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phoneLocked", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhoneLocked", "Landroidx/compose/material/icons/Icons$Outlined;", "getPhoneLocked", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhoneLockedKt {
    private static ImageVector _phoneLocked;

    static {
    }

    public static final ImageVector getPhoneLocked(Outlined arg19) {
        ImageVector v0 = PhoneLockedKt._phoneLocked;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PhoneLocked", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 5f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineTo(5f);
        v12.horizontalLineTo(20f);
        v12.close();
        v12.moveTo(19f, 5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20.200001f, 14.87f);
        v12.lineToRelative(-3.67f, -0.73f);
        v12.curveToRelative(-0.5f, -0.1f, -0.83f, 0.2f, -0.9f, 0.27f);
        v12.lineToRelative(-2.52f, 2.5f);
        v12.curveToRelative(-2.5f, -1.43f, -4.57f, -3.5f, -6f, -6f);
        v12.lineToRelative(2.5f, -2.52f);
        v12.curveToRelative(0.23f, -0.24f, 0.33f, -0.57f, 0.27f, -0.9f);
        v12.lineTo(9.13f, 3.8f);
        v12.curveTo(9.04f, 3.34f, 8.63f, 3f, 8.15f, 3f);
        v12.lineTo(4f, 3f);
        v12.curveTo(3.44f, 3f, 2.97f, 3.47f, 3f, 4.03f);
        v12.curveTo(3.17f, 6.92f, 4.05f, 9.63f, 5.43f, 12f);
        v12.curveToRelative(1.58f, 2.73f, 3.85f, 4.99f, 6.57f, 6.57f);
        v12.curveToRelative(2.37f, 1.37f, 5.08f, 2.26f, 7.97f, 2.43f);
        v12.curveToRelative(0.55f, 0.03f, 1.03f, -0.43f, 1.03f, -1f);
        v12.verticalLineToRelative(-4.15f);
        v12.curveTo(21f, 15.37f, 20.66f, 14.96f, 20.200001f, 14.87f);
        v12.close();
        v12.moveTo(5.1f, 5f);
        v12.horizontalLineToRelative(2.23f);
        v12.lineTo(7.8f, 7.35f);
        v12.lineTo(6.17f, 9f);
        v12.curveTo(5.63f, 7.7f, 5.27f, 6.37f, 5.1f, 5f);
        v12.close();
        v12.moveTo(19f, 18.9f);
        v12.curveToRelative(-1.37f, -0.18f, -2.7f, -0.53f, -4f, -1.07f);
        v12.lineToRelative(1.65f, -1.63f);
        v12.lineTo(19f, 16.67f);
        v12.verticalLineTo(18.9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhoneLockedKt._phoneLocked = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

