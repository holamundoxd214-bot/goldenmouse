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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_ramenDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RamenDining", "Landroidx/compose/material/icons/Icons$Rounded;", "getRamenDining", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RamenDiningKt {
    private static ImageVector _ramenDining;

    static {
    }

    public static final ImageVector getRamenDining(Rounded arg19) {
        ImageVector v0 = RamenDiningKt._ramenDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RamenDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 2.84f);
        v12.lineTo(22f, 2.84f);
        v12.curveToRelative(0f, -0.45f, -0.39f, -0.79f, -0.83f, -0.75f);
        v12.lineTo(4.89f, 3.9f);
        v12.curveTo(4.38f, 3.95f, 4f, 4.38f, 4f, 4.89f);
        v12.verticalLineTo(12f);
        v12.horizontalLineTo(3.08f);
        v12.curveToRelative(-0.6f, 0f, -1.08f, 0.53f, -1f, 1.13f);
        v12.curveTo(2.52f, 16.33f, 4.83f, 19f, 8f, 20.25f);
        v12.verticalLineTo(21f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-0.75f);
        v12.curveToRelative(3.17f, -1.25f, 5.48f, -3.92f, 5.92f, -7.12f);
        v12.curveToRelative(0.08f, -0.6f, -0.4f, -1.13f, -1f, -1.13f);
        v12.horizontalLineTo(10.5f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(10.75f);
        v12.curveTo(21.66f, 8f, 22f, 7.66f, 22f, 7.25f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.horizontalLineTo(10.5f);
        v12.verticalLineTo(4.78f);
        v12.lineToRelative(10.83f, -1.19f);
        v12.curveTo(21.709999f, 3.54f, 22f, 3.22f, 22f, 2.84f);
        v12.close();
        v12.moveTo(6.5f, 5.22f);
        v12.verticalLineTo(6.5f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(5.34f);
        v12.lineTo(6.5f, 5.22f);
        v12.close();
        v12.moveTo(5.5f, 8f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(8f);
        v12.close();
        v12.moveTo(9f, 12f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(12f);
        v12.close();
        v12.moveTo(9f, 6.5f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(5.06f);
        v12.lineToRelative(1f, -0.11f);
        v12.verticalLineTo(6.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RamenDiningKt._ramenDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

