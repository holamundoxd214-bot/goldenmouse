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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pedalBike", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PedalBike", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPedalBike", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PedalBikeKt {
    private static ImageVector _pedalBike;

    static {
    }

    public static final ImageVector getPedalBike(TwoTone arg19) {
        ImageVector v0 = PedalBikeKt._pedalBike;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.PedalBike", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.18f, 10f);
        v12.lineToRelative(-1.7f, -4.68f);
        v12.curveTo(16.190001f, 4.53f, 15.44f, 4f, 14.6f, 4f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2.6f);
        v12.lineToRelative(1.46f, 4f);
        v12.horizontalLineToRelative(-4.81f);
        v12.lineToRelative(-0.36f, -1f);
        v12.horizontalLineTo(12f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(1.75f);
        v12.lineToRelative(1.82f, 5f);
        v12.horizontalLineTo(9.9f);
        v12.curveToRelative(-0.44f, -2.23f, -2.31f, -3.88f, -4.65f, -3.99f);
        v12.curveTo(2.45f, 9.87f, 0f, 12.2f, 0f, 15f);
        v12.curveToRelative(0f, 2.8f, 2.2f, 5f, 5f, 5f);
        v12.curveToRelative(2.46f, 0f, 4.45f, -1.69f, 4.9f, -4f);
        v12.horizontalLineToRelative(4.2f);
        v12.curveToRelative(0.44f, 2.23f, 2.31f, 3.88f, 4.65f, 3.99f);
        v12.curveToRelative(2.8f, 0.13f, 5.25f, -2.19f, 5.25f, -5f);
        v12.curveToRelative(0f, -2.8f, -2.2f, -5f, -5f, -5f);
        v12.horizontalLineTo(18.18f);
        v12.close();
        v12.moveTo(7.82f, 16f);
        v12.curveToRelative(-0.4f, 1.17f, -1.49f, 2f, -2.82f, 2f);
        v12.curveToRelative(-1.68f, 0f, -3f, -1.32f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.32f, -3f, 3f, -3f);
        v12.curveToRelative(1.33f, 0f, 2.42f, 0.83f, 2.82f, 2f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(7.82f);
        v12.close();
        v12.moveTo(14.1f, 14f);
        v12.horizontalLineToRelative(-1.4f);
        v12.lineToRelative(-0.73f, -2f);
        v12.horizontalLineTo(15f);
        v12.curveTo(14.56f, 12.58f, 14.24f, 13.25f, 14.1f, 14f);
        v12.close();
        v12.moveTo(19f, 18f);
        v12.curveToRelative(-1.68f, 0f, -3f, -1.32f, -3f, -3f);
        v12.curveToRelative(0f, -0.93f, 0.41f, -1.73f, 1.05f, -2.28f);
        v12.lineToRelative(0.96f, 2.64f);
        v12.lineToRelative(1.88f, -0.68f);
        v12.lineToRelative(-0.97f, -2.67f);
        v12.curveToRelative(0.03f, 0f, 0.06f, -0.01f, 0.09f, -0.01f);
        v12.curveToRelative(1.68f, 0f, 3f, 1.32f, 3f, 3f);
        v12.reflectiveCurveTo(20.68f, 18f, 19f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PedalBikeKt._pedalBike = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

