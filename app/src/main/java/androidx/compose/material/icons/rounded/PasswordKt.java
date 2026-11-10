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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_password", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Password", "Landroidx/compose/material/icons/Icons$Rounded;", "getPassword", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PasswordKt {
    private static ImageVector _password;

    static {
    }

    public static final ImageVector getPassword(Rounded arg19) {
        ImageVector v0 = PasswordKt._password;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Password", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 17f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(2f, 17.450001f, 2.45f, 17f, 3f, 17f);
        v12.close();
        v12.moveTo(2.5f, 12.57f);
        v12.curveToRelative(0.36f, 0.21f, 0.82f, 0.08f, 1.03f, -0.28f);
        v12.lineTo(4f, 11.47f);
        v12.lineToRelative(0.48f, 0.83f);
        v12.curveToRelative(0.21f, 0.36f, 0.67f, 0.48f, 1.03f, 0.28f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.36f, -0.21f, 0.48f, -0.66f, 0.28f, -1.02f);
        v12.lineTo(5.3f, 10.72f);
        v12.horizontalLineToRelative(0.95f);
        v12.curveTo(6.66f, 10.72f, 7f, 10.38f, 7f, 9.97f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.horizontalLineTo(5.3f);
        v12.lineTo(5.77f, 8.4f);
        v12.curveTo(5.98f, 8.04f, 5.86f, 7.58f, 5.5f, 7.37f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(5.14f, 7.17f, 4.68f, 7.29f, 4.47f, 7.65f);
        v12.lineTo(4f, 8.47f);
        v12.lineTo(3.53f, 7.65f);
        v12.curveTo(3.32f, 7.29f, 2.86f, 7.17f, 2.5f, 7.37f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(2.14f, 7.58f, 2.02f, 8.04f, 2.23f, 8.4f);
        v12.lineTo(2.7f, 9.22f);
        v12.horizontalLineTo(1.75f);
        v12.curveTo(1.34f, 9.22f, 1f, 9.56f, 1f, 9.97f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.horizontalLineTo(2.7f);
        v12.lineToRelative(-0.48f, 0.83f);
        v12.curveTo(2.02f, 11.91f, 2.14f, 12.37f, 2.5f, 12.57f);
        v12.lineTo(2.5f, 12.57f);
        v12.close();
        v12.moveTo(10.5f, 12.57f);
        v12.lineTo(10.5f, 12.57f);
        v12.curveToRelative(0.36f, 0.21f, 0.82f, 0.08f, 1.03f, -0.28f);
        v12.lineTo(12f, 11.47f);
        v12.lineToRelative(0.48f, 0.83f);
        v12.curveToRelative(0.21f, 0.36f, 0.67f, 0.48f, 1.03f, 0.28f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.36f, -0.21f, 0.48f, -0.66f, 0.28f, -1.02f);
        v12.lineToRelative(-0.48f, -0.83f);
        v12.horizontalLineToRelative(0.95f);
        v12.curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.horizontalLineTo(13.3f);
        v12.lineToRelative(0.47f, -0.82f);
        v12.curveToRelative(0.21f, -0.36f, 0.08f, -0.82f, -0.27f, -1.03f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.36f, -0.21f, -0.82f, -0.08f, -1.02f, 0.27f);
        v12.lineTo(12f, 8.47f);
        v12.lineToRelative(-0.47f, -0.82f);
        v12.curveToRelative(-0.21f, -0.36f, -0.67f, -0.48f, -1.02f, -0.27f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.36f, 0.21f, -0.48f, 0.67f, -0.27f, 1.03f);
        v12.lineToRelative(0.47f, 0.82f);
        v12.horizontalLineTo(9.75f);
        v12.curveTo(9.34f, 9.22f, 9f, 9.56f, 9f, 9.97f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.horizontalLineToRelative(0.95f);
        v12.lineToRelative(-0.48f, 0.83f);
        v12.curveTo(10.02f, 11.91f, 10.14f, 12.37f, 10.5f, 12.57f);
        v12.close();
        v12.moveTo(23f, 9.97f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.horizontalLineTo(21.299999f);
        v12.lineToRelative(0.47f, -0.82f);
        v12.curveToRelative(0.21f, -0.36f, 0.08f, -0.82f, -0.27f, -1.03f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.36f, -0.21f, -0.82f, -0.08f, -1.02f, 0.27f);
        v12.lineTo(20f, 8.47f);
        v12.lineToRelative(-0.47f, -0.82f);
        v12.curveToRelative(-0.21f, -0.36f, -0.67f, -0.48f, -1.02f, -0.27f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.36f, 0.21f, -0.48f, 0.67f, -0.27f, 1.03f);
        v12.lineToRelative(0.47f, 0.82f);
        v12.horizontalLineToRelative(-0.95f);
        v12.curveTo(17.34f, 9.22f, 17f, 9.56f, 17f, 9.97f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.horizontalLineToRelative(0.95f);
        v12.lineToRelative(-0.48f, 0.83f);
        v12.curveToRelative(-0.21f, 0.36f, -0.08f, 0.82f, 0.28f, 1.02f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.36f, 0.21f, 0.82f, 0.08f, 1.03f, -0.28f);
        v12.lineTo(20f, 11.47f);
        v12.lineToRelative(0.48f, 0.83f);
        v12.curveToRelative(0.21f, 0.36f, 0.67f, 0.48f, 1.03f, 0.28f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.36f, -0.21f, 0.48f, -0.66f, 0.28f, -1.02f);
        v12.lineToRelative(-0.48f, -0.83f);
        v12.horizontalLineToRelative(0.95f);
        v12.curveTo(22.66f, 10.72f, 23f, 10.38f, 23f, 9.97f);
        v12.lineTo(23f, 9.97f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PasswordKt._password = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

