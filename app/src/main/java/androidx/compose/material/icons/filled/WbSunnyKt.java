package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wbSunny", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WbSunny", "Landroidx/compose/material/icons/Icons$Filled;", "getWbSunny", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WbSunnyKt {
    private static ImageVector _wbSunny;

    static {
    }

    public static final ImageVector getWbSunny(Filled arg22) {
        ImageVector v0 = WbSunnyKt._wbSunny;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.WbSunny", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.76f, 4.84f);
        v12.lineToRelative(-1.8f, -1.79f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(1.79f, 1.79f);
        v12.lineToRelative(1.42f, -1.41f);
        v12.close();
        v12.moveTo(4f, 10.5f);
        v12.lineTo(1f, 10.5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.close();
        v12.moveTo(13f, 0.55f);
        v12.horizontalLineToRelative(-2f);
        v12.lineTo(11f, 3.5f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(13f, 0.55f);
        v12.close();
        v12.moveTo(20.450001f, 4.46f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(-1.79f, 1.79f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(1.79f, -1.79f);
        v12.close();
        v12.moveTo(17.24f, 18.16f);
        v12.lineToRelative(1.79f, 1.8f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(-1.8f, -1.79f);
        v12.lineToRelative(-1.4f, 1.4f);
        v12.close();
        v12.moveTo(20f, 10.5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-3f);
        v12.close();
        v12.moveTo(12f, 5.5f);
        v12.curveToRelative(-3.31f, 0f, -6f, 2.69f, -6f, 6f);
        v12.reflectiveCurveToRelative(2.69f, 6f, 6f, 6f);
        v12.reflectiveCurveToRelative(6f, -2.69f, 6f, -6f);
        v12.reflectiveCurveToRelative(-2.69f, -6f, -6f, -6f);
        v12.close();
        v12.moveTo(11f, 22.450001f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(13f, 19.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2.95f);
        v12.close();
        v12.moveTo(3.55f, 18.540001f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(1.79f, -1.8f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(-1.79f, 1.8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WbSunnyKt._wbSunny = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

