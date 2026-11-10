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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noTransfer", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoTransfer", "Landroidx/compose/material/icons/Icons$Rounded;", "getNoTransfer", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoTransferKt {
    private static ImageVector _noTransfer;

    static {
    }

    public static final ImageVector getNoTransfer(Rounded arg19) {
        ImageVector v0 = NoTransferKt._noTransfer;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NoTransfer", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5.78f, 2.95f);
        v12.curveTo(7.24f, 2.16f, 9.48f, 2f, 12f, 2f);
        v12.curveToRelative(4.42f, 0f, 8f, 0.5f, 8f, 4f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 0.35f, -0.08f, 0.67f, -0.19f, 0.98f);
        v12.lineTo(13.83f, 11f);
        v12.horizontalLineTo(18f);
        v12.verticalLineTo(6f);
        v12.horizontalLineTo(8.83f);
        v12.lineTo(5.78f, 2.95f);
        v12.close();
        v12.moveTo(20.49f, 21.9f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(-1.01f, -1.01f);
        v12.curveTo(17.889999f, 20.959999f, 17.700001f, 21f, 17.5f, 21f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.68f, -1.5f, -1.5f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(0.5f);
        v12.curveTo(8f, 20.33f, 7.33f, 21f, 6.5f, 21f);
        v12.reflectiveCurveTo(5f, 20.33f, 5f, 19.5f);
        v12.verticalLineToRelative(-1.28f);
        v12.curveTo(4.39f, 17.67f, 4f, 16.879999f, 4f, 16f);
        v12.verticalLineTo(6.83f);
        v12.lineToRelative(-1.9f, -1.9f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(16.969999f, 16.969999f);
        v12.curveTo(20.879999f, 20.879999f, 20.879999f, 21.51f, 20.49f, 21.9f);
        v12.close();
        v12.moveTo(9f, 15.5f);
        v12.curveTo(9f, 14.67f, 8.33f, 14f, 7.5f, 14f);
        v12.reflectiveCurveTo(6f, 14.67f, 6f, 15.5f);
        v12.curveTo(6f, 16.33f, 6.67f, 17f, 7.5f, 17f);
        v12.reflectiveCurveTo(9f, 16.33f, 9f, 15.5f);
        v12.close();
        v12.moveTo(8.17f, 11f);
        v12.lineTo(6f, 8.83f);
        v12.verticalLineTo(11f);
        v12.horizontalLineTo(8.17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoTransferKt._noTransfer = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

