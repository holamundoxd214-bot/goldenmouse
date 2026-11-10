package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsTennis", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsTennis", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSportsTennis", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsTennisKt {
    private static ImageVector _sportsTennis;

    static {
    }

    public static final ImageVector getSportsTennis(TwoTone arg19) {
        ImageVector v0 = SportsTennisKt._sportsTennis;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.SportsTennis", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.52f, 2.49f);
        v12.curveToRelative(-2.34f, -2.34f, -6.62f, -1.87f, -9.55f, 1.06f);
        v12.curveToRelative(-1.6f, 1.6f, -2.52f, 3.87f, -2.54f, 5.46f);
        v12.curveToRelative(-0.02f, 1.58f, 0.26f, 3.89f, -1.35f, 5.5f);
        v12.lineToRelative(-4.24f, 4.24f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.lineToRelative(4.24f, -4.24f);
        v12.curveToRelative(1.61f, -1.61f, 3.92f, -1.33f, 5.5f, -1.35f);
        v12.reflectiveCurveToRelative(3.86f, -0.94f, 5.46f, -2.54f);
        v12.curveTo(21.379999f, 9.11f, 21.860001f, 4.83f, 19.52f, 2.49f);
        v12.close();
        v12.moveTo(10.32f, 11.68f);
        v12.curveToRelative(-1.53f, -1.53f, -1.05f, -4.61f, 1.06f, -6.72f);
        v12.reflectiveCurveToRelative(5.18f, -2.59f, 6.72f, -1.06f);
        v12.curveToRelative(1.53f, 1.53f, 1.05f, 4.61f, -1.06f, 6.72f);
        v12.reflectiveCurveTo(11.86f, 13.21f, 10.32f, 11.68f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18f, 17f);
        v12.curveToRelative(0.53f, 0f, 1.04f, 0.21f, 1.41f, 0.59f);
        v12.curveToRelative(0.78f, 0.78f, 0.78f, 2.05f, 0f, 2.83f);
        v12.curveTo(19.040001f, 20.790001f, 18.530001f, 21f, 18f, 21f);
        v12.reflectiveCurveToRelative(-1.04f, -0.21f, -1.41f, -0.59f);
        v12.curveToRelative(-0.78f, -0.78f, -0.78f, -2.05f, 0f, -2.83f);
        v12.curveTo(16.959999f, 17.209999f, 17.469999f, 17f, 18f, 17f);
        v12.moveTo(18f, 15f);
        v12.curveToRelative(-1.02f, 0f, -2.05f, 0.39f, -2.83f, 1.17f);
        v12.curveToRelative(-1.56f, 1.56f, -1.56f, 4.09f, 0f, 5.66f);
        v12.curveTo(15.95f, 22.610001f, 16.98f, 23f, 18f, 23f);
        v12.reflectiveCurveToRelative(2.05f, -0.39f, 2.83f, -1.17f);
        v12.curveToRelative(1.56f, -1.56f, 1.56f, -4.09f, 0f, -5.66f);
        v12.curveTo(20.049999f, 15.39f, 19.02f, 15f, 18f, 15f);
        v12.lineTo(18f, 15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsTennisKt._sportsTennis = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

