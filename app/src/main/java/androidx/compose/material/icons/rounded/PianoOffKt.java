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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pianoOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PianoOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getPianoOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PianoOffKt {
    private static ImageVector _pianoOff;

    static {
    }

    public static final ImageVector getPianoOff(Rounded arg19) {
        ImageVector v0 = PianoOffKt._pianoOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PianoOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.49f, 21.9f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(3f, 5.83f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(13.17f);
        v12.lineToRelative(0.9f, 0.9f);
        v12.curveTo(19.459999f, 22.290001f, 20.09f, 22.290001f, 20.49f, 21.9f);
        v12.close();
        v12.moveTo(8.25f, 19f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(7.83f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineToRelative(3.67f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0.25f);
        v12.verticalLineTo(19f);
        v12.close();
        v12.moveTo(9.75f, 19f);
        v12.verticalLineToRelative(-4.5f);
        v12.horizontalLineTo(10f);
        v12.curveToRelative(0.46f, 0f, 0.82f, -0.31f, 0.94f, -0.73f);
        v12.lineToRelative(3.31f, 3.31f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(9.75f);
        v12.close();
        v12.moveTo(11f, 8.17f);
        v12.lineTo(5.83f, 3f);
        v12.horizontalLineTo(19f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(13.17f);
        v12.lineToRelative(-2f, -2f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(8.5f);
        v12.curveToRelative(0f, 0.19f, -0.07f, 0.36f, -0.16f, 0.51f);
        v12.lineTo(13f, 10.17f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(8.17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PianoOffKt._pianoOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

