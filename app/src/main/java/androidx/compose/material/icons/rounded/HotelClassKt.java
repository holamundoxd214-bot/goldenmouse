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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hotelClass", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HotelClass", "Landroidx/compose/material/icons/Icons$Rounded;", "getHotelClass", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HotelClassKt {
    private static ImageVector _hotelClass;

    static {
    }

    public static final ImageVector getHotelClass(Rounded arg19) {
        ImageVector v0 = HotelClassKt._hotelClass;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HotelClass", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.58f, 10f);
        v12.horizontalLineTo(2.56f);
        v12.curveToRelative(-0.49f, 0f, -0.69f, 0.62f, -0.29f, 0.91f);
        v12.lineToRelative(4.91f, 3.51f);
        v12.lineToRelative(-1.89f, 6.1f);
        v12.curveToRelative(-0.14f, 0.46f, 0.39f, 0.84f, 0.78f, 0.55f);
        v12.lineTo(11f, 17.309999f);
        v12.lineToRelative(4.93f, 3.75f);
        v12.curveToRelative(0.39f, 0.29f, 0.92f, -0.08f, 0.78f, -0.55f);
        v12.lineToRelative(-1.89f, -6.1f);
        v12.lineToRelative(4.91f, -3.51f);
        v12.curveToRelative(0.4f, -0.28f, 0.2f, -0.91f, -0.29f, -0.91f);
        v12.horizontalLineToRelative(-6.02f);
        v12.lineToRelative(-1.95f, -6.42f);
        v12.curveToRelative(-0.14f, -0.47f, -0.81f, -0.47f, -0.96f, 0f);
        v12.lineTo(8.58f, 10f);
        v12.close();
        v12.moveTo(20.9f, 20.51f);
        v12.lineToRelative(-1.4f, -4.52f);
        v12.lineToRelative(2.91f, -2.08f);
        v12.curveToRelative(0.4f, -0.28f, 0.2f, -0.91f, -0.29f, -0.91f);
        v12.horizontalLineToRelative(-1.88f);
        v12.lineToRelative(-3.08f, 2.2f);
        v12.lineToRelative(1.46f, 4.72f);
        v12.lineToRelative(1.5f, 1.14f);
        v12.curveTo(20.51f, 21.35f, 21.040001f, 20.969999f, 20.9f, 20.51f);
        v12.close();
        v12.moveTo(17f, 8f);
        v12.lineToRelative(-1.34f, -4.42f);
        v12.curveToRelative(-0.14f, -0.47f, -0.81f, -0.47f, -0.96f, 0f);
        v12.lineToRelative(-0.57f, 1.87f);
        v12.lineTo(14.91f, 8f);
        v12.horizontalLineTo(17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HotelClassKt._hotelClass = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

