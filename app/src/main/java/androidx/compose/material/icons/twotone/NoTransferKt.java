package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noTransfer", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoTransfer", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNoTransfer", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoTransferKt {
    private static ImageVector _noTransfer;

    static {
    }

    public static final ImageVector getNoTransfer(TwoTone arg19) {
        ImageVector v0 = NoTransferKt._noTransfer;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.NoTransfer", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.83f, 12f);
        v12.horizontalLineTo(18f);
        v12.verticalLineToRelative(3.17f);
        v12.lineTo(14.83f, 12f);
        v12.close();
        v12.moveTo(9.17f, 12f);
        v12.lineToRelative(5f, 5f);
        v12.horizontalLineTo(6.63f);
        v12.lineToRelative(-0.29f, -0.27f);
        v12.curveTo(6.21f, 16.620001f, 6f, 16.370001f, 6f, 16f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineTo(9.17f);
        v12.close();
        v12.moveTo(10f, 14.5f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(7f, 13.67f, 7f, 14.5f);
        v12.curveTo(7f, 15.33f, 7.67f, 16f, 8.5f, 16f);
        v12.reflectiveCurveTo(10f, 15.33f, 10f, 14.5f);
        v12.close();
        v12.moveTo(7.82f, 4.99f);
        v12.horizontalLineToRelative(9.83f);
        v12.curveTo(17.110001f, 4.46f, 15.69f, 4f, 12f, 4f);
        v12.curveTo(9.6f, 4f, 8.17f, 4.2f, 7.31f, 4.48f);
        v12.lineTo(7.82f, 4.99f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8.5f, 13f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(9.33f, 16f, 8.5f, 16f);
        v12.reflectiveCurveTo(7f, 15.33f, 7f, 14.5f);
        v12.reflectiveCurveTo(7.67f, 13f, 8.5f, 13f);
        v12.close();
        v12.moveTo(7.31f, 4.48f);
        v12.curveTo(8.17f, 4.2f, 9.6f, 4f, 12f, 4f);
        v12.curveToRelative(3.69f, 0f, 5.11f, 0.46f, 5.66f, 0.99f);
        v12.horizontalLineTo(7.82f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineTo(18f);
        v12.verticalLineTo(10f);
        v12.horizontalLineToRelative(-5.17f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineTo(18f);
        v12.verticalLineToRelative(3.17f);
        v12.lineToRelative(1.81f, 1.81f);
        v12.curveTo(19.92f, 16.67f, 20f, 16.35f, 20f, 16f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -3.5f, -3.58f, -4f, -8f, -4f);
        v12.curveTo(9.48f, 2f, 7.24f, 2.16f, 5.78f, 2.95f);
        v12.lineTo(7.31f, 4.48f);
        v12.close();
        v12.moveTo(19.780001f, 22.610001f);
        v12.lineToRelative(-1.64f, -1.64f);
        v12.curveTo(18.09f, 20.98f, 18.049999f, 21f, 18f, 21f);
        v12.horizontalLineToRelative(-1f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-1.78f);
        v12.curveTo(4.39f, 17.67f, 4f, 16.879999f, 4f, 16f);
        v12.verticalLineTo(6.83f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(18.379999f, 18.379999f);
        v12.lineTo(19.780001f, 22.610001f);
        v12.close();
        v12.moveTo(6f, 8.83f);
        v12.verticalLineTo(10f);
        v12.horizontalLineToRelative(1.17f);
        v12.lineTo(6f, 8.83f);
        v12.close();
        v12.moveTo(14.17f, 17f);
        v12.lineToRelative(-5f, -5f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.37f, 0.21f, 0.62f, 0.34f, 0.73f);
        v12.lineTo(6.63f, 17f);
        v12.horizontalLineTo(8f);
        v12.horizontalLineTo(14.17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoTransferKt._noTransfer = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

