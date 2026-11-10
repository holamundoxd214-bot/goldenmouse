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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_phoneMissed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhoneMissed", "Landroidx/compose/material/icons/Icons$Sharp;", "getPhoneMissed$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getPhoneMissed", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhoneMissedKt {
    private static ImageVector _phoneMissed;

    static {
    }

    public static final ImageVector getPhoneMissed(Sharp arg19) {
        ImageVector v0 = PhoneMissedKt._phoneMissed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.PhoneMissed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23.32f, 16.67f);
        v12.curveToRelative(-2.95f, -2.79f, -6.93f, -4.51f, -11.31f, -4.51f);
        v12.curveToRelative(-4.39f, 0f, -8.37f, 1.72f, -11.31f, 4.51f);
        v12.lineToRelative(-0.69f, 0.69f);
        v12.lineTo(3.65f, 21f);
        v12.lineToRelative(3.93f, -2.72f);
        v12.lineToRelative(-0.01f, -3.49f);
        v12.curveToRelative(1.4f, -0.45f, 2.9f, -0.7f, 4.44f, -0.7f);
        v12.curveToRelative(1.55f, 0f, 3.04f, 0.24f, 4.44f, 0.7f);
        v12.lineToRelative(-0.01f, 3.49f);
        v12.lineTo(20.370001f, 21f);
        v12.lineToRelative(3.64f, -3.64f);
        v12.curveToRelative(0f, -0.01f, -0.52f, -0.52f, -0.69f, -0.69f);
        v12.close();
        v12.moveTo(7f, 6.43f);
        v12.lineToRelative(4.94f, 4.94f);
        v12.lineToRelative(7.07f, -7.07f);
        v12.lineToRelative(-1.41f, -1.42f);
        v12.lineToRelative(-5.66f, 5.66f);
        v12.lineTo(8.4f, 5f);
        v12.horizontalLineTo(11f);
        v12.verticalLineTo(3f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhoneMissedKt._phoneMissed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.PhoneMissed", replaceWith="<_subannotation>") public static void getPhoneMissed$annotations(Sharp arg0) {
    }
}

