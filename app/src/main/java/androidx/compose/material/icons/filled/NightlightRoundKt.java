package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nightlightRound", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NightlightRound", "Landroidx/compose/material/icons/Icons$Filled;", "getNightlightRound", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NightlightRoundKt {
    private static ImageVector _nightlightRound;

    static {
    }

    public static final ImageVector getNightlightRound(Filled arg19) {
        ImageVector v0 = NightlightRoundKt._nightlightRound;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.NightlightRound", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.01f, 12f);
        v12.curveToRelative(0f, -3.57f, 2.2f, -6.62f, 5.31f, -7.87f);
        v12.curveToRelative(0.89f, -0.36f, 0.75f, -1.69f, -0.19f, -1.9f);
        v12.curveToRelative(-1.1f, -0.24f, -2.27f, -0.3f, -3.48f, -0.14f);
        v12.curveToRelative(-4.51f, 0.6f, -8.12f, 4.31f, -8.59f, 8.83f);
        v12.curveTo(4.44f, 16.93f, 9.13f, 22f, 15.01f, 22f);
        v12.curveToRelative(0.73f, 0f, 1.43f, -0.08f, 2.12f, -0.23f);
        v12.curveToRelative(0.95f, -0.21f, 1.1f, -1.53f, 0.2f, -1.9f);
        v12.curveToRelative(-3.22f, -1.29f, -5.33f, -4.41f, -5.32f, -7.87f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NightlightRoundKt._nightlightRound = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

