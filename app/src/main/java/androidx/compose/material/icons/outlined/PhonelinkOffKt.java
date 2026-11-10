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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phonelinkOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhonelinkOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getPhonelinkOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhonelinkOffKt {
    private static ImageVector _phonelinkOff;

    static {
    }

    public static final ImageVector getPhonelinkOff(Outlined arg19) {
        ImageVector v0 = PhonelinkOffKt._phonelinkOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PhonelinkOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 6f);
        v12.lineTo(22f, 4f);
        v12.lineTo(7.39f, 4f);
        v12.lineToRelative(2f, 2f);
        v12.close();
        v12.moveTo(24f, 19f);
        v12.lineTo(24f, 9f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-6f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3.61f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(18f, 10f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineToRelative(-1.61f);
        v12.lineToRelative(2.93f, 2.93f);
        v12.curveToRelative(0.39f, -0.13f, 0.68f, -0.49f, 0.68f, -0.93f);
        v12.close();
        v12.moveTo(2.06f, 1.51f);
        v12.lineTo(0.65f, 2.92f);
        v12.lineToRelative(1.82f, 1.82f);
        v12.curveTo(2.18f, 5.08f, 2f, 5.52f, 2f, 6f);
        v12.verticalLineToRelative(11f);
        v12.lineTo(0f, 17f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(17.73f);
        v12.lineToRelative(2.35f, 2.35f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.06f, 1.51f);
        v12.close();
        v12.moveTo(4f, 17f);
        v12.lineTo(4f, 6.27f);
        v12.lineTo(14.73f, 17f);
        v12.lineTo(4f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhonelinkOffKt._phonelinkOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

