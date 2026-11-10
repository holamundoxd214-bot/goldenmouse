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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_formatClear", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FormatClear", "Landroidx/compose/material/icons/Icons$Rounded;", "getFormatClear", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FormatClearKt {
    private static ImageVector _formatClear;

    static {
    }

    public static final ImageVector getFormatClear(Rounded arg19) {
        ImageVector v0 = FormatClearKt._formatClear;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FormatClear", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 8f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveTo(19.33f, 5f, 18.5f, 5f);
        v12.lineTo(6.39f, 5f);
        v12.lineToRelative(3f, 3f);
        v12.horizontalLineToRelative(1.83f);
        v12.lineToRelative(-0.55f, 1.28f);
        v12.lineToRelative(2.09f, 2.09f);
        v12.lineTo(14.21f, 8f);
        v12.horizontalLineToRelative(4.29f);
        v12.close();
        v12.moveTo(17.440001f, 18.879999f);
        v12.lineTo(4.12f, 5.56f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(6.26f, 6.26f);
        v12.lineToRelative(-1.65f, 3.84f);
        v12.curveToRelative(-0.39f, 0.92f, 0.28f, 1.93f, 1.27f, 1.93f);
        v12.curveToRelative(0.55f, 0f, 1.05f, -0.33f, 1.27f, -0.84f);
        v12.lineToRelative(1.21f, -2.83f);
        v12.lineToRelative(4.95f, 4.95f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.4f, -0.38f, 0.4f, -1.01f, 0.01f, -1.4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FormatClearKt._formatClear = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

