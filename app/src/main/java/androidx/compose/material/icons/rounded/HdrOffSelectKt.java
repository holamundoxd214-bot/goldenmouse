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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hdrOffSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HdrOffSelect", "Landroidx/compose/material/icons/Icons$Rounded;", "getHdrOffSelect", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HdrOffSelectKt {
    private static ImageVector _hdrOffSelect;

    static {
    }

    public static final ImageVector getHdrOffSelect(Rounded arg19) {
        ImageVector v0 = HdrOffSelectKt._hdrOffSelect;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HdrOffSelect", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 18.5f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineTo(14f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4.31f);
        v12.curveToRelative(0f, 0.38f, 0.31f, 0.69f, 0.69f, 0.69f);
        v12.horizontalLineToRelative(0.11f);
        v12.curveToRelative(0.38f, 0f, 0.69f, -0.31f, 0.69f, -0.69f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(1.1f);
        v12.lineToRelative(0.72f, 1.59f);
        v12.curveToRelative(0.11f, 0.25f, 0.36f, 0.41f, 0.63f, 0.41f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.5f, 0f, 0.83f, -0.51f, 0.64f, -0.97f);
        v12.lineTo(17.1f, 19.9f);
        v12.curveTo(17.6f, 19.6f, 18f, 19.1f, 18f, 18.5f);
        v12.close();
        v12.moveTo(16.5f, 18.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(18.5f);
        v12.close();
        v12.moveTo(3.5f, 18f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1.25f);
        v12.curveTo(1.5f, 16.34f, 1.16f, 16f, 0.75f, 16f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(0.34f, 16f, 0f, 16.34f, 0f, 16.75f);
        v12.verticalLineToRelative(4.5f);
        v12.curveTo(0f, 21.66f, 0.34f, 22f, 0.75f, 22f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f);
        v12.verticalLineTo(19.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(1.75f);
        v12.curveTo(3.5f, 21.66f, 3.84f, 22f, 4.25f, 22f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(4.66f, 22f, 5f, 21.66f, 5f, 21.25f);
        v12.verticalLineToRelative(-4.5f);
        v12.curveTo(5f, 16.34f, 4.66f, 16f, 4.25f, 16f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f);
        v12.verticalLineTo(18f);
        v12.close();
        v12.moveTo(10f, 16f);
        v12.horizontalLineTo(7.5f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineTo(10f);
        v12.curveToRelative(0.82f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(11.5f, 16.67f, 10.82f, 16f, 10f, 16f);
        v12.close();
        v12.moveTo(10f, 20.5f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(20.5f);
        v12.close();
        v12.moveTo(23.25f, 20f);
        v12.horizontalLineTo(22f);
        v12.verticalLineToRelative(1.25f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(-1.25f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.horizontalLineToRelative(1.25f);
        v12.verticalLineToRelative(-1.25f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(1.25f);
        v12.horizontalLineToRelative(1.25f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(24f, 19.66f, 23.66f, 20f, 23.25f, 20f);
        v12.close();
        v12.moveTo(10.98f, 4.15f);
        v12.lineTo(9.42f, 2.59f);
        v12.curveToRelative(5.1f, -2.42f, 10.41f, 2.89f, 7.99f, 7.99f);
        v12.lineToRelative(-1.56f, -1.56f);
        v12.curveTo(16.66f, 6.06f, 13.94f, 3.34f, 10.98f, 4.15f);
        v12.close();
        v12.moveTo(5.63f, 3.05f);
        v12.lineTo(5.63f, 3.05f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(0.96f, 0.96f);
        v12.curveToRelative(-2.42f, 5.1f, 2.88f, 10.41f, 7.99f, 7.99f);
        v12.lineToRelative(0.95f, 0.95f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-9.9f, -9.91f);
        v12.curveTo(6.66f, 2.66f, 6.02f, 2.66f, 5.63f, 3.05f);
        v12.close();
        v12.moveTo(8.15f, 6.98f);
        v12.lineToRelative(4.87f, 4.87f);
        v12.curveTo(10.06f, 12.66f, 7.34f, 9.94f, 8.15f, 6.98f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HdrOffSelectKt._hdrOffSelect = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

