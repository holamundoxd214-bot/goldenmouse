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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_airplaneTicket", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AirplaneTicket", "Landroidx/compose/material/icons/Icons$Rounded;", "getAirplaneTicket$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getAirplaneTicket", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AirplaneTicketKt {
    private static ImageVector _airplaneTicket;

    static {
    }

    public static final ImageVector getAirplaneTicket(Rounded arg19) {
        ImageVector v0 = AirplaneTicketKt._airplaneTicket;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AirplaneTicket", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(17.73f, 13.3f);
        v12.lineToRelative(-8.49f, 2.26f);
        v12.curveToRelative(-0.22f, 0.06f, -0.45f, -0.04f, -0.56f, -0.23f);
        v12.lineToRelative(-1.12f, -1.95f);
        v12.curveToRelative(-0.18f, -0.3f, -0.01f, -0.69f, 0.32f, -0.78f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.16f, -0.04f, 0.34f, -0.01f, 0.47f, 0.1f);
        v12.lineToRelative(1.05f, 0.82f);
        v12.lineToRelative(2.39f, -0.64f);
        v12.lineTo(9.9f, 9.6f);
        v12.curveToRelative(-0.26f, -0.44f, -0.02f, -1.01f, 0.47f, -1.15f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.26f, -0.07f, 0.54f, 0f, 0.74f, 0.18f);
        v12.lineToRelative(3.69f, 3.44f);
        v12.lineToRelative(2.44f, -0.65f);
        v12.curveToRelative(0.51f, -0.14f, 1.04f, 0.17f, 1.18f, 0.68f);
        v12.curveTo(18.549999f, 12.62f, 18.25f, 13.15f, 17.73f, 13.3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AirplaneTicketKt._airplaneTicket = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.AirplaneTicket", replaceWith="<_subannotation>") public static void getAirplaneTicket$annotations(Rounded arg0) {
    }
}

