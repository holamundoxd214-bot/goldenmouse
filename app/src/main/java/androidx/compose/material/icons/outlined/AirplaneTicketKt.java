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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_airplaneTicket", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AirplaneTicket", "Landroidx/compose/material/icons/Icons$Outlined;", "getAirplaneTicket$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getAirplaneTicket", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AirplaneTicketKt {
    private static ImageVector _airplaneTicket;

    static {
    }

    public static final ImageVector getAirplaneTicket(Outlined arg19) {
        ImageVector v0 = AirplaneTicketKt._airplaneTicket;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AirplaneTicket", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.190001f, 4f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 4f, 2.01f, 4.9f, 2.01f, 6f);
        v12.verticalLineToRelative(4f);
        v12.curveTo(3.11f, 10f, 4f, 10.9f, 4f, 12f);
        v12.reflectiveCurveToRelative(-0.89f, 2f, -2f, 2f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveTo(22f, 4.9f, 21.190001f, 4f, 20.190001f, 4f);
        v12.close();
        v12.moveTo(20f, 18f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(-2.54f);
        v12.curveToRelative(1.19f, -0.69f, 2f, -1.99f, 2f, -3.46f);
        v12.curveToRelative(0f, -1.48f, -0.8f, -2.77f, -1.99f, -3.46f);
        v12.lineTo(4f, 6f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(18f);
        v12.close();
        v12.moveTo(8.87f, 15.66f);
        v12.lineToRelative(-1.66f, -2.88f);
        v12.lineToRelative(0.93f, -0.25f);
        v12.lineToRelative(1.26f, 0.99f);
        v12.lineToRelative(2.39f, -0.64f);
        v12.lineToRelative(-2.4f, -4.16f);
        v12.lineToRelative(1.4f, -0.38f);
        v12.lineToRelative(4.01f, 3.74f);
        v12.lineToRelative(2.44f, -0.65f);
        v12.curveToRelative(0.51f, -0.14f, 1.04f, 0.17f, 1.18f, 0.68f);
        v12.curveToRelative(0.13f, 0.51f, -0.17f, 1.04f, -0.69f, 1.19f);
        v12.lineTo(8.87f, 15.66f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AirplaneTicketKt._airplaneTicket = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Outlined.AirplaneTicket", replaceWith="<_subannotation>") public static void getAirplaneTicket$annotations(Outlined arg0) {
    }
}

