package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phonelinkLock", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhonelinkLock", "Landroidx/compose/material/icons/Icons$Sharp;", "getPhonelinkLock", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhonelinkLockKt {
    private static ImageVector _phonelinkLock;

    static {
    }

    public static final ImageVector getPhonelinkLock(Sharp arg19) {
        ImageVector v0 = PhonelinkLockKt._phonelinkLock;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.PhonelinkLock", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 1f);
        v12.lineTo(7f, 1f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(9f, 4f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(16f);
        v12.lineTo(9f, 20f);
        v12.verticalLineToRelative(-2f);
        v12.lineTo(7f, 18f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(14f);
        v12.lineTo(21f, 1f);
        v12.close();
        v12.moveTo(10.8f, 11f);
        v12.lineTo(10.8f, 9.5f);
        v12.curveTo(10.8f, 8.1f, 9.4f, 7f, 8f, 7f);
        v12.reflectiveCurveTo(5.2f, 8.1f, 5.2f, 9.5f);
        v12.lineTo(5.2f, 11f);
        v12.lineTo(4f, 11f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(-1.2f);
        v12.close();
        v12.moveTo(9.5f, 11f);
        v12.horizontalLineToRelative(-3f);
        v12.lineTo(6.5f, 9.5f);
        v12.curveToRelative(0f, -0.8f, 0.7f, -1.3f, 1.5f, -1.3f);
        v12.reflectiveCurveToRelative(1.5f, 0.5f, 1.5f, 1.3f);
        v12.lineTo(9.5f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhonelinkLockKt._phonelinkLock = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

