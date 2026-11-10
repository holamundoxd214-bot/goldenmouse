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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rotate90DegreesCw", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Rotate90DegreesCw", "Landroidx/compose/material/icons/Icons$TwoTone;", "getRotate90DegreesCw", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Rotate90DegreesCwKt {
    private static ImageVector _rotate90DegreesCw;

    static {
    }

    public static final ImageVector getRotate90DegreesCw(TwoTone arg19) {
        ImageVector v0 = Rotate90DegreesCwKt._rotate90DegreesCw;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Rotate90DegreesCw", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.64f, 19.370001f);
        v12.curveToRelative(3.03f, 3.03f, 7.67f, 3.44f, 11.15f, 1.25f);
        v12.lineToRelative(-1.46f, -1.46f);
        v12.curveToRelative(-2.66f, 1.43f, -6.04f, 1.03f, -8.28f, -1.21f);
        v12.curveToRelative(-2.73f, -2.73f, -2.73f, -7.17f, 0f, -9.9f);
        v12.curveTo(7.42f, 6.69f, 9.21f, 6.03f, 11f, 6.03f);
        v12.verticalLineTo(9f);
        v12.lineToRelative(4f, -4f);
        v12.lineToRelative(-4f, -4f);
        v12.verticalLineToRelative(3.01f);
        v12.curveToRelative(-2.3f, 0f, -4.61f, 0.87f, -6.36f, 2.63f);
        v12.curveTo(1.12f, 10.15f, 1.12f, 15.85f, 4.64f, 19.370001f);
        v12.close();
        v12.moveTo(11f, 13f);
        v12.lineToRelative(6f, 6f);
        v12.lineToRelative(6f, -6f);
        v12.lineToRelative(-6f, -6f);
        v12.lineTo(11f, 13f);
        v12.close();
        v12.moveTo(17f, 16.17f);
        v12.lineTo(13.83f, 13f);
        v12.lineTo(17f, 9.83f);
        v12.lineTo(20.17f, 13f);
        v12.lineTo(17f, 16.17f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(13.817f, 12.995f);
        v0_1.lineToRelative(3.175f, -3.175f);
        v0_1.lineToRelative(3.175f, 3.175f);
        v0_1.lineToRelative(-3.175f, 3.175f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Rotate90DegreesCwKt._rotate90DegreesCw = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

