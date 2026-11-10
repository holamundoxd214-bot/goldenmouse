package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bakeryDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BakeryDining", "Landroidx/compose/material/icons/Icons$Filled;", "getBakeryDining", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BakeryDiningKt {
    private static ImageVector _bakeryDining;

    static {
    }

    public static final ImageVector getBakeryDining(Filled arg19) {
        ImageVector v0 = BakeryDiningKt._bakeryDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.BakeryDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.280001f, 16.34f);
        v12.curveTo(18.07f, 15.45f, 17.459999f, 15f, 17.459999f, 15f);
        v12.reflectiveCurveToRelative(0.32f, -0.59f, 0.96f, -1.78f);
        v12.curveToRelative(0.38f, -0.59f, 1.22f, -0.59f, 1.6f, 0f);
        v12.lineToRelative(0.81f, 1.26f);
        v12.curveToRelative(0.19f, 0.3f, 0.21f, 0.68f, 0.06f, 1f);
        v12.lineToRelative(-0.22f, 0.47f);
        v12.curveTo(20.42f, 16.49f, 19.76f, 16.67f, 19.280001f, 16.34f);
        v12.close();
        v12.moveTo(4.72f, 16.34f);
        v12.curveToRelative(-0.48f, 0.33f, -1.13f, 0.15f, -1.39f, -0.38f);
        v12.lineTo(3.1f, 15.49f);
        v12.curveToRelative(-0.15f, -0.32f, -0.13f, -0.7f, 0.06f, -1f);
        v12.lineToRelative(0.81f, -1.26f);
        v12.curveToRelative(0.38f, -0.59f, 1.22f, -0.59f, 1.6f, 0f);
        v12.curveTo(6.22f, 14.41f, 6.54f, 15f, 6.54f, 15f);
        v12.reflectiveCurveTo(5.93f, 15.45f, 4.72f, 16.34f);
        v12.close();
        v12.moveTo(15.36f, 9.37f);
        v12.curveToRelative(0.09f, -0.68f, 0.73f, -1.06f, 1.27f, -0.75f);
        v12.lineToRelative(1.59f, 0.9f);
        v12.curveToRelative(0.46f, 0.26f, 0.63f, 0.91f, 0.36f, 1.41f);
        v12.lineTo(16.5f, 15f);
        v12.horizontalLineToRelative(-1.8f);
        v12.lineTo(15.36f, 9.37f);
        v12.close();
        v12.moveTo(8.63f, 9.37f);
        v12.lineTo(9.3f, 15f);
        v12.horizontalLineTo(7.5f);
        v12.lineToRelative(-2.09f, -4.08f);
        v12.curveToRelative(-0.27f, -0.5f, -0.1f, -1.15f, 0.36f, -1.41f);
        v12.lineToRelative(1.59f, -0.9f);
        v12.curveTo(7.89f, 8.31f, 8.54f, 8.69f, 8.63f, 9.37f);
        v12.close();
        v12.moveTo(13.8f, 15f);
        v12.horizontalLineToRelative(-3.6f);
        v12.lineTo(9.46f, 8.12f);
        v12.curveTo(9.39f, 7.53f, 9.81f, 7f, 10.34f, 7f);
        v12.horizontalLineToRelative(3.3f);
        v12.curveToRelative(0.53f, 0f, 0.94f, 0.53f, 0.88f, 1.12f);
        v12.lineTo(13.8f, 15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BakeryDiningKt._bakeryDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

