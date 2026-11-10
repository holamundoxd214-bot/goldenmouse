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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_markEmailRead", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MarkEmailRead", "Landroidx/compose/material/icons/Icons$Rounded;", "getMarkEmailRead", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MarkEmailReadKt {
    private static ImageVector _markEmailRead;

    static {
    }

    public static final ImageVector getMarkEmailRead(Rounded arg19) {
        ImageVector v0 = MarkEmailReadKt._markEmailRead;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MarkEmailRead", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.049999f, 21.290001f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(-2.12f, -2.12f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(3.54f, -3.54f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(18.049999f, 21.290001f);
        v12.close();
        v12.moveTo(12.08f, 20f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(6.68f);
        v12.curveTo(21.09f, 12.25f, 20.08f, 12f, 19f, 12f);
        v12.curveToRelative(-3.87f, 0f, -7f, 3.13f, -7f, 7f);
        v12.curveTo(12f, 19.34f, 12.03f, 19.67f, 12.08f, 20f);
        v12.close();
        v12.moveTo(11.47f, 12.67f);
        v12.curveToRelative(0.32f, 0.2f, 0.74f, 0.2f, 1.06f, 0f);
        v12.lineToRelative(7.07f, -4.42f);
        v12.curveTo(19.85f, 8.09f, 20f, 7.82f, 20f, 7.53f);
        v12.curveToRelative(0f, -0.67f, -0.73f, -1.07f, -1.3f, -0.72f);
        v12.lineTo(12f, 11f);
        v12.lineTo(5.3f, 6.81f);
        v12.curveTo(4.73f, 6.46f, 4f, 6.86f, 4f, 7.53f);
        v12.curveToRelative(0f, 0.29f, 0.15f, 0.56f, 0.4f, 0.72f);
        v12.lineTo(11.47f, 12.67f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MarkEmailReadKt._markEmailRead = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

