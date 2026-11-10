package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rotate90DegreesCcw", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Rotate90DegreesCcw", "Landroidx/compose/material/icons/Icons$Sharp;", "getRotate90DegreesCcw", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Rotate90DegreesCcwKt {
    private static ImageVector _rotate90DegreesCcw;

    static {
    }

    public static final ImageVector getRotate90DegreesCcw(Sharp arg19) {
        ImageVector v0 = Rotate90DegreesCcwKt._rotate90DegreesCcw;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Rotate90DegreesCcw", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.34f, 6.41f);
        v12.lineTo(0.86f, 12.9f);
        v12.lineToRelative(6.49f, 6.48f);
        v12.lineToRelative(6.49f, -6.48f);
        v12.lineToRelative(-6.5f, -6.49f);
        v12.close();
        v12.moveTo(3.69f, 12.9f);
        v12.lineToRelative(3.66f, -3.66f);
        v12.lineTo(11f, 12.9f);
        v12.lineToRelative(-3.66f, 3.66f);
        v12.lineToRelative(-3.65f, -3.66f);
        v12.close();
        v12.moveTo(19.360001f, 6.64f);
        v12.curveTo(17.610001f, 4.88f, 15.3f, 4f, 13f, 4f);
        v12.lineTo(13f, 0.76f);
        v12.lineTo(8.76f, 5f);
        v12.lineTo(13f, 9.24f);
        v12.lineTo(13f, 6f);
        v12.curveToRelative(1.79f, 0f, 3.58f, 0.68f, 4.95f, 2.05f);
        v12.curveToRelative(2.73f, 2.73f, 2.73f, 7.17f, 0f, 9.9f);
        v12.curveTo(16.58f, 19.32f, 14.79f, 20f, 13f, 20f);
        v12.curveToRelative(-0.97f, 0f, -1.94f, -0.21f, -2.84f, -0.61f);
        v12.lineToRelative(-1.49f, 1.49f);
        v12.curveTo(10.02f, 21.620001f, 11.51f, 22f, 13f, 22f);
        v12.curveToRelative(2.3f, 0f, 4.61f, -0.88f, 6.36f, -2.64f);
        v12.curveToRelative(3.52f, -3.51f, 3.52f, -9.21f, 0f, -12.72f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Rotate90DegreesCcwKt._rotate90DegreesCcw = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

