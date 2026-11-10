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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rotate90DegreesCw", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Rotate90DegreesCw", "Landroidx/compose/material/icons/Icons$Rounded;", "getRotate90DegreesCw", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Rotate90DegreesCwKt {
    private static ImageVector _rotate90DegreesCw;

    static {
    }

    public static final ImageVector getRotate90DegreesCw(Rounded arg19) {
        ImageVector v0 = Rotate90DegreesCwKt._rotate90DegreesCw;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Rotate90DegreesCw", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3.86f, 18.459999f);
        v12.curveToRelative(2.65f, 3.45f, 7.11f, 4.37f, 10.74f, 2.79f);
        v12.curveToRelative(0.61f, -0.27f, 0.74f, -1.09f, 0.27f, -1.56f);
        v12.lineToRelative(-0.05f, -0.05f);
        v12.curveToRelative(-0.29f, -0.29f, -0.72f, -0.35f, -1.1f, -0.19f);
        v12.curveToRelative(-2.96f, 1.24f, -6.59f, 0.37f, -8.58f, -2.62f);
        v12.curveToRelative(-1.58f, -2.37f, -1.55f, -5.37f, 0.05f, -7.73f);
        v12.curveTo(6.6f, 7.03f, 8.8f, 6.03f, 11f, 6.03f);
        v12.verticalLineToRelative(1.76f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.86f, 0.36f);
        v12.lineToRelative(2.79f, -2.79f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f);
        v12.lineToRelative(-2.8f, -2.79f);
        v12.curveTo(11.54f, 1.54f, 11f, 1.76f, 11f, 2.21f);
        v12.verticalLineToRelative(1.8f);
        v12.curveToRelative(-2.76f, 0f, -5.52f, 1.25f, -7.34f, 3.78f);
        v12.curveTo(1.38f, 10.96f, 1.46f, 15.37f, 3.86f, 18.459999f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17.700001f, 7.71f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(-4.59f, 4.58f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(4.59f, 4.59f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(4.59f, -4.59f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(17.700001f, 7.71f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Rotate90DegreesCwKt._rotate90DegreesCw = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

