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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noStroller", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoStroller", "Landroidx/compose/material/icons/Icons$Rounded;", "getNoStroller", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoStrollerKt {
    private static ImageVector _noStroller;

    static {
    }

    public static final ImageVector getNoStroller(Rounded arg19) {
        ImageVector v0 = NoStrollerKt._noStroller;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NoStroller", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 20f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveTo(8f, 18.9f, 8f, 20f);
        v12.close();
        v12.moveTo(14.3f, 4.1f);
        v12.curveTo(13.03f, 3.4f, 11.56f, 3f, 10f, 3f);
        v12.curveTo(8.77f, 3f, 7.61f, 3.26f, 6.54f, 3.71f);
        v12.lineToRelative(4.37f, 4.37f);
        v12.lineTo(14.3f, 4.1f);
        v12.close();
        v12.moveTo(20.49f, 21.9f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-9.82f, -9.82f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(7.26f, 7.26f);
        v12.lineToRelative(-2.66f, 3.12f);
        v12.curveToRelative(-0.55f, 0.65f, -0.09f, 1.65f, 0.76f, 1.65f);
        v12.horizontalLineToRelative(6.66f);
        v12.lineToRelative(1.17f, 1.17f);
        v12.curveToRelative(-0.88f, 0.33f, -1.47f, 1.25f, -1.26f, 2.28f);
        v12.curveToRelative(0.15f, 0.76f, 0.78f, 1.39f, 1.54f, 1.54f);
        v12.curveToRelative(1.03f, 0.21f, 1.95f, -0.38f, 2.28f, -1.26f);
        v12.lineToRelative(1.2f, 1.2f);
        v12.curveTo(19.459999f, 22.290001f, 20.09f, 22.290001f, 20.49f, 21.9f);
        v12.lineTo(20.49f, 21.9f);
        v12.close();
        v12.moveTo(17f, 6.27f);
        v12.curveTo(17.58f, 5.59f, 17.969999f, 5f, 18.65f, 5f);
        v12.curveToRelative(0.68f, 0f, 1.22f, 0.52f, 1.33f, 1.21f);
        v12.curveTo(20.08f, 6.66f, 20.48f, 7f, 20.959999f, 7f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(0f, -0.06f, 0f, -0.11f, -0.01f, -0.16f);
        v12.lineToRelative(0f, -0.01f);
        v12.curveTo(21.65f, 4.22f, 20.299999f, 3f, 18.65f, 3f);
        v12.curveToRelative(-1.66f, 0f, -2.54f, 1.27f, -3.18f, 2.03f);
        v12.lineToRelative(-3.5f, 4.11f);
        v12.lineTo(17f, 14.17f);
        v12.verticalLineTo(6.27f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoStrollerKt._noStroller = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

