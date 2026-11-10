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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nightlightRound", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NightlightRound", "Landroidx/compose/material/icons/Icons$Rounded;", "getNightlightRound", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NightlightRoundKt {
    private static ImageVector _nightlightRound;

    static {
    }

    public static final ImageVector getNightlightRound(Rounded arg19) {
        ImageVector v0 = NightlightRoundKt._nightlightRound;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NightlightRound", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.5f, 22f);
        v12.curveToRelative(0.07f, 0f, 0.14f, 0f, 0.21f, 0f);
        v12.curveToRelative(0.84f, -0.02f, 1.12f, -1.11f, 0.41f, -1.56f);
        v12.curveToRelative(-2.78f, -1.77f, -4.63f, -4.89f, -4.63f, -8.43f);
        v12.curveToRelative(0f, -3.55f, 1.85f, -6.66f, 4.63f, -8.44f);
        v12.curveToRelative(0.7f, -0.45f, 0.44f, -1.54f, -0.39f, -1.56f);
        v12.curveToRelative(-0.04f, 0f, -0.09f, 0f, -0.13f, 0f);
        v12.curveToRelative(-4.9f, -0.05f, -9.21f, 3.53f, -9.98f, 8.37f);
        v12.curveTo(4.64f, 16.610001f, 9.45f, 22f, 15.5f, 22f);
        v12.lineTo(15.5f, 22f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NightlightRoundKt._nightlightRound = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

