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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phoneMissed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhoneMissed", "Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;", "getPhoneMissed", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhoneMissedKt {
    private static ImageVector _phoneMissed;

    static {
    }

    public static final ImageVector getPhoneMissed(Filled arg19) {
        ImageVector v0 = PhoneMissedKt._phoneMissed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Filled.PhoneMissed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.5f, 5.5f);
        v12.lineTo(12f, 11f);
        v12.lineToRelative(7f, -7f);
        v12.lineToRelative(-1f, -1f);
        v12.lineToRelative(-6f, 6f);
        v12.lineToRelative(-4.5f, -4.5f);
        v12.lineTo(11f, 4.5f);
        v12.lineTo(11f, 3f);
        v12.lineTo(5f, 3f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(1.5f);
        v12.lineTo(6.5f, 5.5f);
        v12.close();
        v12.moveTo(23.709999f, 16.67f);
        v12.curveTo(20.66f, 13.78f, 16.540001f, 12f, 12f, 12f);
        v12.curveTo(7.46f, 12f, 3.34f, 13.78f, 0.29f, 16.67f);
        v12.curveToRelative(-0.18f, 0.18f, -0.29f, 0.43f, -0.29f, 0.71f);
        v12.reflectiveCurveToRelative(0.11f, 0.53f, 0.29f, 0.71f);
        v12.lineToRelative(2.48f, 2.48f);
        v12.curveToRelative(0.18f, 0.18f, 0.43f, 0.29f, 0.71f, 0.29f);
        v12.curveToRelative(0.27f, 0f, 0.52f, -0.11f, 0.7f, -0.28f);
        v12.curveToRelative(0.79f, -0.74f, 1.69f, -1.36f, 2.66f, -1.85f);
        v12.curveToRelative(0.33f, -0.16f, 0.56f, -0.5f, 0.56f, -0.9f);
        v12.verticalLineToRelative(-3.1f);
        v12.curveToRelative(1.45f, -0.48f, 3f, -0.73f, 4.6f, -0.73f);
        v12.curveToRelative(1.6f, 0f, 3.15f, 0.25f, 4.6f, 0.72f);
        v12.verticalLineToRelative(3.1f);
        v12.curveToRelative(0f, 0.39f, 0.23f, 0.74f, 0.56f, 0.9f);
        v12.curveToRelative(0.98f, 0.49f, 1.87f, 1.12f, 2.67f, 1.85f);
        v12.curveToRelative(0.18f, 0.18f, 0.43f, 0.28f, 0.7f, 0.28f);
        v12.curveToRelative(0.28f, 0f, 0.53f, -0.11f, 0.71f, -0.29f);
        v12.lineToRelative(2.48f, -2.48f);
        v12.curveToRelative(0.18f, -0.18f, 0.29f, -0.43f, 0.29f, -0.71f);
        v12.reflectiveCurveToRelative(-0.12f, -0.52f, -0.3f, -0.7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhoneMissedKt._phoneMissed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

