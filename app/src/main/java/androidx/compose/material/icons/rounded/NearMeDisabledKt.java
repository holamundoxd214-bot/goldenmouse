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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nearMeDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NearMeDisabled", "Landroidx/compose/material/icons/Icons$Rounded;", "getNearMeDisabled", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NearMeDisabledKt {
    private static ImageVector _nearMeDisabled;

    static {
    }

    public static final ImageVector getNearMeDisabled(Rounded arg19) {
        ImageVector v0 = NearMeDisabledKt._nearMeDisabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NearMeDisabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6.34f);
        v12.lineToRelative(6.95f, -2.58f);
        v12.curveToRelative(0.8f, -0.3f, 1.58f, 0.48f, 1.29f, 1.29f);
        v12.lineTo(17.66f, 12f);
        v12.lineTo(12f, 6.34f);
        v12.close();
        v12.moveTo(21.9f, 19.07f);
        v12.lineTo(4.93f, 2.1f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(4.36f, 4.36f);
        v12.lineToRelative(-4.2f, 1.56f);
        v12.curveTo(3.27f, 9.59f, 3f, 9.97f, 3f, 10.4f);
        v12.curveToRelative(0f, 0.42f, 0.26f, 0.8f, 0.65f, 0.96f);
        v12.lineToRelative(6.42f, 2.57f);
        v12.lineToRelative(2.57f, 6.42f);
        v12.curveTo(12.8f, 20.74f, 13.18f, 21f, 13.6f, 21f);
        v12.curveToRelative(0.43f, 0f, 0.82f, -0.27f, 0.97f, -0.67f);
        v12.lineToRelative(1.56f, -4.2f);
        v12.lineToRelative(4.36f, 4.36f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveTo(22.290001f, 20.09f, 22.290001f, 19.459999f, 21.9f, 19.07f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NearMeDisabledKt._nearMeDisabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

