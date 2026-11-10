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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_signLanguage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SignLanguage", "Landroidx/compose/material/icons/Icons$Sharp;", "getSignLanguage", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SignLanguageKt {
    private static ImageVector _signLanguage;

    static {
    }

    public static final ImageVector getSignLanguage(Sharp arg19) {
        ImageVector v0 = SignLanguageKt._signLanguage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.SignLanguage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.49f, 13f);
        v12.lineToRelative(-1.39f, -2.7f);
        v12.lineTo(12.49f, 9f);
        v12.lineTo(19f, 15.2f);
        v12.verticalLineTo(24f);
        v12.horizontalLineTo(4.5f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(10f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(3.5f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(12.49f);
        v12.close();
        v12.moveTo(11.78f, 7.12f);
        v12.curveToRelative(-0.84f, 0.4f, -1.17f, 0.62f, -1.63f, 1.19f);
        v12.lineTo(6.76f, 4.74f);
        v12.lineToRelative(1.45f, -1.38f);
        v12.lineTo(11.78f, 7.12f);
        v12.close();
        v12.moveTo(9.64f, 9.21f);
        v12.curveTo(9.41f, 9.76f, 9.35f, 10.45f, 9.44f, 11f);
        v12.horizontalLineTo(8.58f);
        v12.lineTo(5.62f, 7.89f);
        v12.lineToRelative(1.45f, -1.38f);
        v12.lineTo(9.64f, 9.21f);
        v12.close();
        v12.moveTo(21.98f, 12.34f);
        v12.lineTo(22f, 3.35f);
        v12.lineToRelative(-1.9f, -0.1f);
        v12.lineToRelative(-1f, 2.86f);
        v12.lineTo(13.3f, 0f);
        v12.lineToRelative(-1.45f, 1.38f);
        v12.lineToRelative(4.09f, 4.3f);
        v12.lineToRelative(-0.73f, 0.69f);
        v12.lineTo(9.74f, 0.64f);
        v12.lineTo(8.3f, 2f);
        v12.lineToRelative(3.36f, 3.53f);
        v12.lineToRelative(1.06f, 1.11f);
        v12.lineToRelative(2.65f, 2.33f);
        v12.lineToRelative(5.08f, 4.83f);
        v12.lineTo(21.98f, 12.34f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SignLanguageKt._signLanguage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

