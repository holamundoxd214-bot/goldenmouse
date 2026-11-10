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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_formatColorReset", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FormatColorReset", "Landroidx/compose/material/icons/Icons$Rounded;", "getFormatColorReset", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FormatColorResetKt {
    private static ImageVector _formatColorReset;

    static {
    }

    public static final ImageVector getFormatColorReset(Rounded arg19) {
        ImageVector v0 = FormatColorResetKt._formatColorReset;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FormatColorReset", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 14f);
        v12.curveToRelative(0f, -3.09f, -3.6f, -7.88f, -5.23f, -9.87f);
        v12.curveToRelative(-0.4f, -0.49f, -1.15f, -0.49f, -1.55f, 0f);
        v12.curveToRelative(-0.46f, 0.57f, -1.08f, 1.36f, -1.73f, 2.27f);
        v12.lineToRelative(8.44f, 8.44f);
        v12.curveToRelative(0.04f, -0.28f, 0.07f, -0.56f, 0.07f, -0.84f);
        v12.close();
        v12.moveTo(19.290001f, 19.01f);
        v12.lineTo(6.12f, 5.84f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.61f, 2.61f);
        v12.curveTo(6.55f, 11.33f, 6f, 12.79f, 6f, 14f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.curveToRelative(1.52f, 0f, 2.9f, -0.57f, 3.95f, -1.5f);
        v12.lineToRelative(1.92f, 1.92f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.4f, -0.38f, 0.4f, -1.02f, 0.01f, -1.41f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FormatColorResetKt._formatColorReset = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

