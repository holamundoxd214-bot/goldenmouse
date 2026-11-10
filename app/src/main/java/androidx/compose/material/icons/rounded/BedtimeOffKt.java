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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bedtimeOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BedtimeOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getBedtimeOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BedtimeOffKt {
    private static ImageVector _bedtimeOff;

    static {
    }

    public static final ImageVector getBedtimeOff(Rounded arg19) {
        ImageVector v0 = BedtimeOffKt._bedtimeOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.BedtimeOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.65f, 3.46f);
        v12.curveToRelative(0.27f, -0.71f, -0.36f, -1.45f, -1.12f, -1.34f);
        v12.curveTo(9.05f, 2.33f, 7.68f, 2.88f, 6.49f, 3.66f);
        v12.lineToRelative(4.59f, 4.59f);
        v12.curveTo(10.88f, 6.69f, 11.04f, 5.05f, 11.65f, 3.46f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(2.1f, 3.51f);
        v12.lineTo(2.1f, 3.51f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(1.56f, 1.56f);
        v12.curveToRelative(-1.4f, 2.11f, -2.02f, 4.77f, -1.46f, 7.56f);
        v12.curveToRelative(0.79f, 3.94f, 3.99f, 7.07f, 7.94f, 7.78f);
        v12.curveToRelative(2.74f, 0.49f, 5.3f, -0.15f, 7.35f, -1.51f);
        v12.lineToRelative(1.57f, 1.57f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveTo(3.12f, 3.12f, 2.49f, 3.12f, 2.1f, 3.51f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BedtimeOffKt._bedtimeOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

