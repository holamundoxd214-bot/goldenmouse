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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_token", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Token", "Landroidx/compose/material/icons/Icons$Rounded;", "getToken", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TokenKt {
    private static ImageVector _token;

    static {
    }

    public static final ImageVector getToken(Rounded arg19) {
        ImageVector v0 = TokenKt._token;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Token", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.97f, 2.54f);
        v12.curveToRelative(-0.6f, -0.34f, -1.34f, -0.34f, -1.94f, 0f);
        v12.lineToRelative(-7f, 3.89f);
        v12.lineTo(9.1f, 9.24f);
        v12.curveTo(9.83f, 8.48f, 10.86f, 8f, 12f, 8f);
        v12.reflectiveCurveToRelative(2.17f, 0.48f, 2.9f, 1.24f);
        v12.lineToRelative(5.07f, -2.82f);
        v12.lineTo(12.97f, 2.54f);
        v12.close();
        v12.moveTo(10f, 12f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(10f, 13.1f, 10f, 12f);
        v12.close();
        v12.moveTo(3f, 8.14f);
        v12.lineToRelative(5.13f, 2.85f);
        v12.curveTo(8.04f, 11.31f, 8f, 11.65f, 8f, 12f);
        v12.curveToRelative(0f, 1.86f, 1.27f, 3.43f, 3f, 3.87f);
        v12.verticalLineToRelative(5.57f);
        v12.lineToRelative(-6.97f, -3.87f);
        v12.curveTo(3.39f, 17.219999f, 3f, 16.549999f, 3f, 15.82f);
        v12.verticalLineTo(8.14f);
        v12.close();
        v12.moveTo(13f, 21.440001f);
        v12.verticalLineToRelative(-5.57f);
        v12.curveToRelative(1.73f, -0.44f, 3f, -2.01f, 3f, -3.87f);
        v12.curveToRelative(0f, -0.35f, -0.04f, -0.69f, -0.13f, -1.01f);
        v12.lineTo(21f, 8.14f);
        v12.lineToRelative(0f, 7.68f);
        v12.curveToRelative(0f, 0.73f, -0.39f, 1.4f, -1.03f, 1.75f);
        v12.lineTo(13f, 21.440001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TokenKt._token = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

