package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pianoOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PianoOff", "Landroidx/compose/material/icons/Icons$Sharp;", "getPianoOff", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PianoOffKt {
    private static ImageVector _pianoOff;

    static {
    }

    public static final ImageVector getPianoOff(Sharp arg18) {
        ImageVector v0 = PianoOffKt._pianoOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.PianoOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(21.190001f, 21.190001f);
        v0_1.lineTo(2.81f, 2.81f);
        v0_1.lineTo(1.39f, 4.22f);
        v0_1.lineTo(3f, 5.83f);
        v0_1.verticalLineTo(21f);
        v0_1.horizontalLineToRelative(15.17f);
        v0_1.lineToRelative(1.61f, 1.61f);
        v0_1.lineTo(21.190001f, 21.190001f);
        v0_1.close();
        v0_1.moveTo(8.25f, 19f);
        v0_1.horizontalLineTo(5f);
        v0_1.verticalLineTo(7.83f);
        v0_1.lineToRelative(2f, 2f);
        v0_1.verticalLineToRelative(4.67f);
        v0_1.horizontalLineToRelative(1.25f);
        v0_1.verticalLineTo(19f);
        v0_1.close();
        v0_1.moveTo(9.75f, 19f);
        v0_1.verticalLineToRelative(-4.5f);
        v0_1.horizontalLineTo(11f);
        v0_1.verticalLineToRelative(-0.67f);
        v0_1.lineToRelative(3.25f, 3.25f);
        v0_1.verticalLineTo(19f);
        v0_1.horizontalLineTo(9.75f);
        v0_1.close();
        v0_1.moveTo(5.83f, 3f);
        v0_1.horizontalLineTo(21f);
        v0_1.verticalLineToRelative(15.17f);
        v0_1.lineToRelative(-2f, -2f);
        v0_1.verticalLineTo(5f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.verticalLineToRelative(9.17f);
        v0_1.lineToRelative(-4f, -4f);
        v0_1.verticalLineTo(5f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.verticalLineToRelative(3.17f);
        v0_1.lineTo(5.83f, 3f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PianoOffKt._pianoOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

