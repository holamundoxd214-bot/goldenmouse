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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_connectWithoutContact", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ConnectWithoutContact", "Landroidx/compose/material/icons/Icons$Sharp;", "getConnectWithoutContact", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ConnectWithoutContactKt {
    private static ImageVector _connectWithoutContact;

    static {
    }

    public static final ImageVector getConnectWithoutContact(Sharp arg19) {
        ImageVector v0 = ConnectWithoutContactKt._connectWithoutContact;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.ConnectWithoutContact", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 14f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(0f, -4.97f, 4.03f, -9f, 9f, -9f);
        v12.verticalLineToRelative(2f);
        v12.curveTo(14.13f, 7f, 11f, 10.13f, 11f, 14f);
        v12.close();
        v12.moveTo(18f, 11f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.horizontalLineToRelative(2f);
        v12.curveTo(15f, 12.34f, 16.34f, 11f, 18f, 11f);
        v12.close();
        v12.moveTo(7f, 4f);
        v12.curveToRelative(0f, -1.11f, -0.89f, -2f, -2f, -2f);
        v12.reflectiveCurveTo(3f, 2.89f, 3f, 4f);
        v12.reflectiveCurveToRelative(0.89f, 2f, 2f, 2f);
        v12.reflectiveCurveTo(7f, 5.11f, 7f, 4f);
        v12.close();
        v12.moveTo(11.45f, 4.5f);
        v12.horizontalLineToRelative(-2f);
        v12.curveTo(9.21f, 5.92f, 7.99f, 7f, 6.5f, 7f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineTo(8.74f);
        v12.curveTo(9.86f, 8.15f, 11.25f, 6.51f, 11.45f, 4.5f);
        v12.close();
        v12.moveTo(19f, 17f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.89f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.89f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.89f, -2f, 2f);
        v12.reflectiveCurveTo(17.889999f, 17f, 19f, 17f);
        v12.close();
        v12.moveTo(17.5f, 18f);
        v12.curveToRelative(-1.49f, 0f, -2.71f, -1.08f, -2.95f, -2.5f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0.2f, 2.01f, 1.59f, 3.65f, 3.45f, 4.24f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineTo(17.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ConnectWithoutContactKt._connectWithoutContact = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

