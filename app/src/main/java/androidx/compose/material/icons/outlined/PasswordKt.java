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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_password", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Password", "Landroidx/compose/material/icons/Icons$Outlined;", "getPassword", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PasswordKt {
    private static ImageVector _password;

    static {
    }

    public static final ImageVector getPassword(Outlined arg18) {
        ImageVector v0 = PasswordKt._password;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Password", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(2f, 17f);
        v0_1.horizontalLineToRelative(20f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineTo(2f);
        v0_1.verticalLineTo(17f);
        v0_1.close();
        v0_1.moveTo(3.15f, 12.95f);
        v0_1.lineTo(4f, 11.47f);
        v0_1.lineToRelative(0.85f, 1.48f);
        v0_1.lineToRelative(1.3f, -0.75f);
        v0_1.lineTo(5.3f, 10.72f);
        v0_1.horizontalLineTo(7f);
        v0_1.verticalLineToRelative(-1.5f);
        v0_1.horizontalLineTo(5.3f);
        v0_1.lineToRelative(0.85f, -1.47f);
        v0_1.lineTo(4.85f, 7f);
        v0_1.lineTo(4f, 8.47f);
        v0_1.lineTo(3.15f, 7f);
        v0_1.lineToRelative(-1.3f, 0.75f);
        v0_1.lineTo(2.7f, 9.22f);
        v0_1.horizontalLineTo(1f);
        v0_1.verticalLineToRelative(1.5f);
        v0_1.horizontalLineToRelative(1.7f);
        v0_1.lineTo(1.85f, 12.2f);
        v0_1.lineTo(3.15f, 12.95f);
        v0_1.close();
        v0_1.moveTo(9.85f, 12.2f);
        v0_1.lineToRelative(1.3f, 0.75f);
        v0_1.lineTo(12f, 11.47f);
        v0_1.lineToRelative(0.85f, 1.48f);
        v0_1.lineToRelative(1.3f, -0.75f);
        v0_1.lineToRelative(-0.85f, -1.48f);
        v0_1.horizontalLineTo(15f);
        v0_1.verticalLineToRelative(-1.5f);
        v0_1.horizontalLineToRelative(-1.7f);
        v0_1.lineToRelative(0.85f, -1.47f);
        v0_1.lineTo(12.85f, 7f);
        v0_1.lineTo(12f, 8.47f);
        v0_1.lineTo(11.15f, 7f);
        v0_1.lineToRelative(-1.3f, 0.75f);
        v0_1.lineToRelative(0.85f, 1.47f);
        v0_1.horizontalLineTo(9f);
        v0_1.verticalLineToRelative(1.5f);
        v0_1.horizontalLineToRelative(1.7f);
        v0_1.lineTo(9.85f, 12.2f);
        v0_1.close();
        v0_1.moveTo(23f, 9.22f);
        v0_1.horizontalLineToRelative(-1.7f);
        v0_1.lineToRelative(0.85f, -1.47f);
        v0_1.lineTo(20.85f, 7f);
        v0_1.lineTo(20f, 8.47f);
        v0_1.lineTo(19.15f, 7f);
        v0_1.lineToRelative(-1.3f, 0.75f);
        v0_1.lineToRelative(0.85f, 1.47f);
        v0_1.horizontalLineTo(17f);
        v0_1.verticalLineToRelative(1.5f);
        v0_1.horizontalLineToRelative(1.7f);
        v0_1.lineToRelative(-0.85f, 1.48f);
        v0_1.lineToRelative(1.3f, 0.75f);
        v0_1.lineTo(20f, 11.47f);
        v0_1.lineToRelative(0.85f, 1.48f);
        v0_1.lineToRelative(1.3f, -0.75f);
        v0_1.lineToRelative(-0.85f, -1.48f);
        v0_1.horizontalLineTo(23f);
        v0_1.verticalLineTo(9.22f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PasswordKt._password = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

