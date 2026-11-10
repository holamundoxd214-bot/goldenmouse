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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_historyToggleOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HistoryToggleOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getHistoryToggleOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HistoryToggleOffKt {
    private static ImageVector _historyToggleOff;

    static {
    }

    public static final ImageVector getHistoryToggleOff(Rounded arg19) {
        ImageVector v0 = HistoryToggleOffKt._historyToggleOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HistoryToggleOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.1f, 19.370001f);
        v12.lineToRelative(1f, 1.74f);
        v12.curveToRelative(-0.96f, 0.44f, -2.01f, 0.73f, -3.1f, 0.84f);
        v12.verticalLineToRelative(-2.02f);
        v12.curveTo(13.74f, 19.84f, 14.44f, 19.65f, 15.1f, 19.370001f);
        v12.close();
        v12.moveTo(4.07f, 13f);
        v12.horizontalLineTo(2.05f);
        v12.curveToRelative(0.11f, 1.1f, 0.4f, 2.14f, 0.84f, 3.1f);
        v12.lineToRelative(1.74f, -1f);
        v12.curveTo(4.35f, 14.44f, 4.16f, 13.74f, 4.07f, 13f);
        v12.close();
        v12.moveTo(15.1f, 4.63f);
        v12.lineToRelative(1f, -1.74f);
        v12.curveTo(15.14f, 2.45f, 14.1f, 2.16f, 13f, 2.05f);
        v12.verticalLineToRelative(2.02f);
        v12.curveTo(13.74f, 4.16f, 14.44f, 4.35f, 15.1f, 4.63f);
        v12.close();
        v12.moveTo(19.93f, 11f);
        v12.horizontalLineToRelative(2.02f);
        v12.curveToRelative(-0.11f, -1.1f, -0.4f, -2.14f, -0.84f, -3.1f);
        v12.lineToRelative(-1.74f, 1f);
        v12.curveTo(19.65f, 9.56f, 19.84f, 10.26f, 19.93f, 11f);
        v12.close();
        v12.moveTo(8.9f, 19.370001f);
        v12.lineToRelative(-1f, 1.74f);
        v12.curveToRelative(0.96f, 0.44f, 2.01f, 0.73f, 3.1f, 0.84f);
        v12.verticalLineToRelative(-2.02f);
        v12.curveTo(10.26f, 19.84f, 9.56f, 19.65f, 8.9f, 19.370001f);
        v12.close();
        v12.moveTo(11f, 4.07f);
        v12.verticalLineTo(2.05f);
        v12.curveToRelative(-1.1f, 0.11f, -2.14f, 0.4f, -3.1f, 0.84f);
        v12.lineToRelative(1f, 1.74f);
        v12.curveTo(9.56f, 4.35f, 10.26f, 4.16f, 11f, 4.07f);
        v12.close();
        v12.moveTo(18.360001f, 7.17f);
        v12.lineToRelative(1.74f, -1.01f);
        v12.curveToRelative(-0.63f, -0.87f, -1.4f, -1.64f, -2.27f, -2.27f);
        v12.lineToRelative(-1.01f, 1.74f);
        v12.curveTo(17.41f, 6.08f, 17.92f, 6.59f, 18.360001f, 7.17f);
        v12.close();
        v12.moveTo(4.63f, 8.9f);
        v12.lineToRelative(-1.74f, -1f);
        v12.curveTo(2.45f, 8.86f, 2.16f, 9.9f, 2.05f, 11f);
        v12.horizontalLineToRelative(2.02f);
        v12.curveTo(4.16f, 10.26f, 4.35f, 9.56f, 4.63f, 8.9f);
        v12.close();
        v12.moveTo(19.93f, 13f);
        v12.curveToRelative(-0.09f, 0.74f, -0.28f, 1.44f, -0.56f, 2.1f);
        v12.lineToRelative(1.74f, 1f);
        v12.curveToRelative(0.44f, -0.96f, 0.73f, -2.01f, 0.84f, -3.1f);
        v12.horizontalLineTo(19.93f);
        v12.close();
        v12.moveTo(16.83f, 18.360001f);
        v12.lineToRelative(1.01f, 1.74f);
        v12.curveToRelative(0.87f, -0.63f, 1.64f, -1.4f, 2.27f, -2.27f);
        v12.lineToRelative(-1.74f, -1.01f);
        v12.curveTo(17.92f, 17.41f, 17.41f, 17.92f, 16.83f, 18.360001f);
        v12.close();
        v12.moveTo(7.17f, 5.64f);
        v12.lineTo(6.17f, 3.89f);
        v12.curveTo(5.29f, 4.53f, 4.53f, 5.29f, 3.9f, 6.17f);
        v12.lineToRelative(1.74f, 1.01f);
        v12.curveTo(6.08f, 6.59f, 6.59f, 6.08f, 7.17f, 5.64f);
        v12.close();
        v12.moveTo(5.64f, 16.83f);
        v12.lineTo(3.9f, 17.83f);
        v12.curveToRelative(0.63f, 0.87f, 1.4f, 1.64f, 2.27f, 2.27f);
        v12.lineToRelative(1.01f, -1.74f);
        v12.curveTo(6.59f, 17.92f, 6.08f, 17.41f, 5.64f, 16.83f);
        v12.close();
        v12.moveTo(12f, 7f);
        v12.lineTo(12f, 7f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3.59f);
        v12.curveToRelative(0f, 0.53f, 0.21f, 1.04f, 0.59f, 1.41f);
        v12.lineToRelative(3f, 3f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-3f, -3f);
        v12.verticalLineTo(8f);
        v12.curveTo(13f, 7.45f, 12.55f, 7f, 12f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HistoryToggleOffKt._historyToggleOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

