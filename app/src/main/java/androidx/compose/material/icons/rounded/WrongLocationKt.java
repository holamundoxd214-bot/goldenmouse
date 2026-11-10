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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wrongLocation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WrongLocation", "Landroidx/compose/material/icons/Icons$Rounded;", "getWrongLocation", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WrongLocationKt {
    private static ImageVector _wrongLocation;

    static {
    }

    public static final ImageVector getWrongLocation(Rounded arg19) {
        ImageVector v0 = WrongLocationKt._wrongLocation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WrongLocation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.42f, 4.5f);
        v12.lineToRelative(1.38f, -1.38f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineTo(19f, 3.08f);
        v12.lineToRelative(-1.38f, -1.38f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.reflectiveCurveToRelative(-0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(1.38f, 1.38f);
        v12.lineToRelative(-1.38f, 1.38f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineTo(19f, 5.92f);
        v12.lineToRelative(1.38f, 1.38f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(20.42f, 4.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.67f, 8f);
        v12.lineTo(19f, 7.33f);
        v12.lineToRelative(-0.59f, 0.59f);
        v12.curveToRelative(-0.7f, 0.7f, -1.84f, 0.88f, -2.65f, 0.3f);
        v12.curveToRelative(-1.03f, -0.74f, -1.12f, -2.19f, -0.26f, -3.05f);
        v12.lineToRelative(0.67f, -0.67f);
        v12.lineTo(15.5f, 3.83f);
        v12.curveToRelative(-0.36f, -0.36f, -0.54f, -0.81f, -0.57f, -1.28f);
        v12.curveTo(14.01f, 2.19f, 13.02f, 2f, 12f, 2f);
        v12.curveToRelative(-4.2f, 0f, -8f, 3.22f, -8f, 8.2f);
        v12.curveToRelative(0f, 3.18f, 2.45f, 6.92f, 7.34f, 11.23f);
        v12.curveToRelative(0.38f, 0.33f, 0.95f, 0.33f, 1.33f, 0f);
        v12.curveTo(17.549999f, 17.120001f, 20f, 13.38f, 20f, 10.2f);
        v12.curveToRelative(0f, -0.76f, -0.1f, -1.47f, -0.26f, -2.14f);
        v12.curveTo(19.719999f, 8.04f, 19.690001f, 8.02f, 19.67f, 8f);
        v12.close();
        v12.moveTo(12f, 12f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveTo(13.1f, 12f, 12f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WrongLocationKt._wrongLocation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

