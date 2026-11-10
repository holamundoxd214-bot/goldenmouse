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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_musicOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MusicOff", "Landroidx/compose/material/icons/Icons$Filled;", "getMusicOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MusicOffKt {
    private static ImageVector _musicOff;

    static {
    }

    public static final ImageVector getMusicOff(Filled arg19) {
        ImageVector v0 = MusicOffKt._musicOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.MusicOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.27f, 3f);
        v12.lineTo(3f, 4.27f);
        v12.lineToRelative(9f, 9f);
        v12.verticalLineToRelative(0.28f);
        v12.curveToRelative(-0.59f, -0.34f, -1.27f, -0.55f, -2f, -0.55f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.verticalLineToRelative(-1.73f);
        v12.lineTo(19.73f, 21f);
        v12.lineTo(21f, 19.73f);
        v12.lineTo(4.27f, 3f);
        v12.close();
        v12.moveTo(14f, 7f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineToRelative(5.18f);
        v12.lineToRelative(2f, 2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MusicOffKt._musicOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

