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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsMotorsports", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsMotorsports", "Landroidx/compose/material/icons/Icons$Rounded;", "getSportsMotorsports", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsMotorsportsKt {
    private static ImageVector _sportsMotorsports;

    static {
    }

    public static final ImageVector getSportsMotorsports(Rounded arg19) {
        ImageVector v0 = SportsMotorsportsKt._sportsMotorsports;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SportsMotorsports", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 11.39f);
        v12.curveToRelative(0f, -0.65f, -0.39f, -1.23f, -0.98f, -1.48f);
        v12.lineTo(5.44f, 7.55f);
        v12.curveToRelative(-1.48f, 1.68f, -2.32f, 3.7f, -2.8f, 5.45f);
        v12.horizontalLineToRelative(7.75f);
        v12.curveTo(11.28f, 13f, 12f, 12.28f, 12f, 11.39f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21.959999f, 11.22f);
        v12.curveToRelative(-0.41f, -4.41f, -4.56f, -7.49f, -8.98f, -7.2f);
        v12.curveToRelative(-2.51f, 0.16f, -4.44f, 0.94f, -5.93f, 2.04f);
        v12.lineToRelative(4.74f, 2.01f);
        v12.curveToRelative(1.33f, 0.57f, 2.2f, 1.87f, 2.2f, 3.32f);
        v12.curveToRelative(0f, 1.99f, -1.62f, 3.61f, -3.61f, 3.61f);
        v12.horizontalLineTo(2.21f);
        v12.curveTo(2f, 16.309999f, 2f, 17.200001f, 2f, 17.200001f);
        v12.verticalLineTo(18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10f);
        v12.curveTo(18.67f, 20f, 22.41f, 15.99f, 21.959999f, 11.22f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsMotorsportsKt._sportsMotorsports = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

