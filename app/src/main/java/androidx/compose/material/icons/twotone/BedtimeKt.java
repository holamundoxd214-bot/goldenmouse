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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bedtime", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Bedtime", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBedtime", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BedtimeKt {
    private static ImageVector _bedtime;

    static {
    }

    public static final ImageVector getBedtime(TwoTone arg19) {
        ImageVector v0 = BedtimeKt._bedtime;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Bedtime", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.27f, 4.49f);
        v12.curveTo(6.2f, 5.6f, 4f, 8.55f, 4f, 12f);
        v12.curveToRelative(0f, 4.41f, 3.59f, 8f, 8f, 8f);
        v12.curveToRelative(1.81f, 0f, 3.54f, -0.62f, 4.93f, -1.71f);
        v12.curveTo(13.02f, 16.9f, 7.64f, 12.03f, 9.27f, 4.49f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.34f, 2.02f);
        v12.curveToRelative(-0.12f, 0f, -0.23f, -0.01f, -0.35f, -0.01f);
        v12.curveTo(6.4f, 2.01f, 2f, 6.54f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.curveToRelative(3.71f, 0f, 6.93f, -2.02f, 8.66f, -5.02f);
        v12.curveTo(13.15f, 16.73f, 8.57f, 8.55f, 12.34f, 2.02f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.41f, 0f, -8f, -3.59f, -8f, -8f);
        v12.curveToRelative(0f, -3.45f, 2.2f, -6.4f, 5.27f, -7.51f);
        v12.curveToRelative(-1.63f, 7.54f, 3.75f, 12.41f, 7.66f, 13.8f);
        v12.curveTo(15.54f, 19.379999f, 13.81f, 20f, 12f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BedtimeKt._bedtime = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

