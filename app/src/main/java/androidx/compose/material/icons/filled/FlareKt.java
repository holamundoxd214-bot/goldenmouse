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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_flare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Flare", "Landroidx/compose/material/icons/Icons$Filled;", "getFlare", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FlareKt {
    private static ImageVector _flare;

    static {
    }

    public static final ImageVector getFlare(Filled arg21) {
        ImageVector v0 = FlareKt._flare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Flare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 11f);
        v12.lineTo(1f, 11f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-2f);
        v12.close();
        v12.moveTo(9.17f, 7.76f);
        v12.lineTo(7.05f, 5.64f);
        v12.lineTo(5.64f, 7.05f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.close();
        v12.moveTo(13f, 1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(13f, 1f);
        v12.close();
        v12.moveTo(18.360001f, 7.05f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(-2.12f, 2.12f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(2.12f, -2.12f);
        v12.close();
        v12.moveTo(17f, 11f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-6f);
        v12.close();
        v12.moveTo(12f, 9f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.34f, 3f, -3f);
        v12.reflectiveCurveToRelative(-1.34f, -3f, -3f, -3f);
        v12.close();
        v12.moveTo(14.83f, 16.24f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(-2.12f, -2.12f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.close();
        v12.moveTo(5.64f, 16.950001f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(2.12f, -2.12f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(-2.12f, 2.12f);
        v12.close();
        v12.moveTo(11f, 23f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FlareKt._flare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

