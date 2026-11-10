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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_exploreOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ExploreOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getExploreOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ExploreOffKt {
    private static ImageVector _exploreOff;

    static {
    }

    public static final ImageVector getExploreOff(Rounded arg19) {
        ImageVector v0 = ExploreOffKt._exploreOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ExploreOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 6f);
        v12.lineToRelative(-2.91f, 6.26f);
        v12.lineToRelative(5.25f, 5.25f);
        v12.curveTo(21.389999f, 15.93f, 22f, 14.04f, 22f, 12f);
        v12.curveToRelative(0f, -5.52f, -4.48f, -10f, -10f, -10f);
        v12.curveToRelative(-2.04f, 0f, -3.93f, 0.61f, -5.51f, 1.66f);
        v12.lineToRelative(5.25f, 5.25f);
        v12.lineTo(18f, 6f);
        v12.close();
        v12.moveTo(2.81f, 5.64f);
        v12.lineToRelative(0.85f, 0.85f);
        v12.curveToRelative(-1.37f, 2.07f, -2f, 4.68f, -1.48f, 7.45f);
        v12.curveToRelative(0.75f, 3.95f, 3.92f, 7.13f, 7.88f, 7.88f);
        v12.curveToRelative(2.77f, 0.52f, 5.38f, -0.1f, 7.45f, -1.48f);
        v12.lineToRelative(0.85f, 0.85f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(4.22f, 4.22f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.03f, 0f, 1.42f);
        v12.close();
        v12.moveTo(8.91f, 11.74f);
        v12.lineToRelative(3.35f, 3.35f);
        v12.lineTo(6f, 18f);
        v12.lineToRelative(2.91f, -6.26f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ExploreOffKt._exploreOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

