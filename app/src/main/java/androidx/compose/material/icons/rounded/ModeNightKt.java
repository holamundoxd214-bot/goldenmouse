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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_modeNight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ModeNight", "Landroidx/compose/material/icons/Icons$Rounded;", "getModeNight", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ModeNightKt {
    private static ImageVector _modeNight;

    static {
    }

    public static final ImageVector getModeNight(Rounded arg19) {
        ImageVector v0 = ModeNightKt._modeNight;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ModeNight", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.93f, 2.3f);
        v12.curveTo(9.89f, 1.8f, 7.91f, 1.95f, 6.16f, 2.58f);
        v12.curveTo(5.44f, 2.84f, 5.25f, 3.8f, 5.85f, 4.29f);
        v12.curveTo(8.08f, 6.12f, 9.5f, 8.89f, 9.5f, 12f);
        v12.curveToRelative(0f, 3.11f, -1.42f, 5.88f, -3.65f, 7.71f);
        v12.curveToRelative(-0.59f, 0.49f, -0.42f, 1.45f, 0.31f, 1.7f);
        v12.curveTo(7.2f, 21.790001f, 8.33f, 22f, 9.5f, 22f);
        v12.curveToRelative(6.05f, 0f, 10.85f, -5.38f, 9.87f, -11.6f);
        v12.curveTo(18.76f, 6.48f, 15.78f, 3.24f, 11.93f, 2.3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ModeNightKt._modeNight = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

