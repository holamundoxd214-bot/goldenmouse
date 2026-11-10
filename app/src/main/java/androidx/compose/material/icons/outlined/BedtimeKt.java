package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bedtime", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Bedtime", "Landroidx/compose/material/icons/Icons$Outlined;", "getBedtime", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BedtimeKt {
    private static ImageVector _bedtime;

    static {
    }

    public static final ImageVector getBedtime(Outlined arg19) {
        ImageVector v0 = BedtimeKt._bedtime;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Bedtime", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.27f, 4.49f);
        v12.curveToRelative(-1.63f, 7.54f, 3.75f, 12.41f, 7.66f, 13.8f);
        v12.curveTo(15.54f, 19.379999f, 13.81f, 20f, 12f, 20f);
        v12.curveToRelative(-4.41f, 0f, -8f, -3.59f, -8f, -8f);
        v12.curveTo(4f, 8.55f, 6.2f, 5.6f, 9.27f, 4.49f);
        v12.moveTo(11.99f, 2.01f);
        v12.curveTo(6.4f, 2.01f, 2f, 6.54f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.curveToRelative(3.71f, 0f, 6.93f, -2.02f, 8.66f, -5.02f);
        v12.curveToRelative(-7.51f, -0.25f, -12.09f, -8.43f, -8.32f, -14.97f);
        v12.curveTo(12.22f, 2.01f, 12.11f, 2.01f, 11.99f, 2.01f);
        v12.lineTo(11.99f, 2.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BedtimeKt._bedtime = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

