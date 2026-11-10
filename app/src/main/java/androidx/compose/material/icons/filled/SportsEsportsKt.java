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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsEsports", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsEsports", "Landroidx/compose/material/icons/Icons$Filled;", "getSportsEsports", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsEsportsKt {
    private static ImageVector _sportsEsports;

    static {
    }

    public static final ImageVector getSportsEsports(Filled arg19) {
        ImageVector v0 = SportsEsportsKt._sportsEsports;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SportsEsports", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.58f, 16.09f);
        v12.lineToRelative(-1.09f, -7.66f);
        v12.curveTo(20.209999f, 6.46f, 18.52f, 5f, 16.530001f, 5f);
        v12.horizontalLineTo(7.47f);
        v12.curveTo(5.48f, 5f, 3.79f, 6.46f, 3.51f, 8.43f);
        v12.lineToRelative(-1.09f, 7.66f);
        v12.curveTo(2.2f, 17.629999f, 3.39f, 19f, 4.94f, 19f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.68f, 0f, 1.32f, -0.27f, 1.8f, -0.75f);
        v12.lineTo(9f, 16f);
        v12.horizontalLineToRelative(6f);
        v12.lineToRelative(2.25f, 2.25f);
        v12.curveToRelative(0.48f, 0.48f, 1.13f, 0.75f, 1.8f, 0.75f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(20.610001f, 19f, 21.799999f, 17.629999f, 21.58f, 16.09f);
        v12.close();
        v12.moveTo(11f, 11f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(11f);
        v12.close();
        v12.moveTo(15f, 10f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(16f, 9.55f, 15.55f, 10f, 15f, 10f);
        v12.close();
        v12.moveTo(17f, 13f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(18f, 12.55f, 17.549999f, 13f, 17f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsEsportsKt._sportsEsports = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

