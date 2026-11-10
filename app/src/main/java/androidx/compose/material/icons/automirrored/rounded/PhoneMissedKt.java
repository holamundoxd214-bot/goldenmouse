package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phoneMissed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhoneMissed", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getPhoneMissed", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhoneMissedKt {
    private static ImageVector _phoneMissed;

    static {
    }

    public static final ImageVector getPhoneMissed(Rounded arg19) {
        ImageVector v0 = PhoneMissedKt._phoneMissed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.PhoneMissed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23.09f, 16.200001f);
        v12.curveToRelative(-6.33f, -5.59f, -15.86f, -5.59f, -22.18f, 0f);
        v12.curveToRelative(-0.84f, 0.74f, -0.84f, 2.05f, -0.05f, 2.84f);
        v12.lineToRelative(1.2f, 1.2f);
        v12.curveToRelative(0.71f, 0.71f, 1.84f, 0.77f, 2.62f, 0.15f);
        v12.lineToRelative(1.97f, -1.57f);
        v12.curveToRelative(0.47f, -0.37f, 0.75f, -0.94f, 0.75f, -1.55f);
        v12.verticalLineTo(14.7f);
        v12.curveToRelative(2.98f, -0.97f, 6.21f, -0.98f, 9.2f, 0f);
        v12.verticalLineToRelative(2.58f);
        v12.curveToRelative(0f, 0.6f, 0.28f, 1.17f, 0.75f, 1.55f);
        v12.lineToRelative(1.96f, 1.56f);
        v12.curveToRelative(0.79f, 0.62f, 1.91f, 0.56f, 2.62f, -0.15f);
        v12.lineToRelative(1.2f, -1.2f);
        v12.curveToRelative(0.8f, -0.79f, 0.79f, -2.1f, -0.04f, -2.84f);
        v12.close();
        v12.moveTo(6f, 9f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(6.43f);
        v12.lineToRelative(4.24f, 4.24f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(5.66f, -5.66f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(-4.95f, 4.95f);
        v12.lineTo(8.4f, 5f);
        v12.horizontalLineTo(10f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhoneMissedKt._phoneMissed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

