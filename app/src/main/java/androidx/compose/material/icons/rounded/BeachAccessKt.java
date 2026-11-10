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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_beachAccess", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BeachAccess", "Landroidx/compose/material/icons/Icons$Rounded;", "getBeachAccess", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BeachAccessKt {
    private static ImageVector _beachAccess;

    static {
    }

    public static final ImageVector getBeachAccess(Rounded arg19) {
        ImageVector v0 = BeachAccessKt._beachAccess;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.BeachAccess", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.13f, 14.56f);
        v12.lineToRelative(1.43f, -1.43f);
        v12.lineToRelative(5.73f, 5.73f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.03f, 0f, 1.43f);
        v12.curveToRelative(-0.39f, 0.39f, -1.03f, 0.39f, -1.43f, 0f);
        v12.lineToRelative(-5.73f, -5.73f);
        v12.close();
        v12.moveTo(17.42f, 8.83f);
        v12.lineToRelative(1.27f, -1.27f);
        v12.curveToRelative(0.89f, -0.89f, 0.77f, -2.43f, -0.31f, -3.08f);
        v12.curveToRelative(-3.89f, -2.38f, -9.03f, -1.89f, -12.4f, 1.47f);
        v12.curveToRelative(3.93f, -1.3f, 8.31f, -0.25f, 11.44f, 2.88f);
        v12.close();
        v12.moveTo(5.95f, 5.98f);
        v12.curveToRelative(-3.36f, 3.37f, -3.85f, 8.51f, -1.48f, 12.4f);
        v12.curveToRelative(0.66f, 1.08f, 2.19f, 1.21f, 3.08f, 0.31f);
        v12.lineToRelative(1.27f, -1.27f);
        v12.curveTo(5.7f, 14.29f, 4.65f, 9.91f, 5.95f, 5.98f);
        v12.close();
        v12.moveTo(5.97f, 5.96f);
        v12.lineToRelative(-0.01f, 0.01f);
        v12.curveToRelative(-0.38f, 3.01f, 1.17f, 6.88f, 4.3f, 10.02f);
        v12.lineToRelative(5.73f, -5.73f);
        v12.curveToRelative(-3.13f, -3.13f, -7.01f, -4.68f, -10.02f, -4.3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BeachAccessKt._beachAccess = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

