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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pix", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Pix", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPix", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PixKt {
    private static ImageVector _pix;

    static {
    }

    public static final ImageVector getPix(TwoTone arg19) {
        ImageVector v0 = PixKt._pix;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Pix", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.45f, 16.52f);
        v12.lineToRelative(-3.01f, -3.01f);
        v12.curveToRelative(-0.11f, -0.11f, -0.24f, -0.13f, -0.31f, -0.13f);
        v12.reflectiveCurveToRelative(-0.2f, 0.02f, -0.31f, 0.13f);
        v12.lineTo(8.8f, 16.530001f);
        v12.curveToRelative(-0.34f, 0.34f, -0.87f, 0.89f, -2.64f, 0.89f);
        v12.lineToRelative(3.71f, 3.7f);
        v12.curveToRelative(1.17f, 1.17f, 3.07f, 1.17f, 4.24f, 0f);
        v12.lineToRelative(3.72f, -3.71f);
        v12.curveTo(16.92f, 17.41f, 16.16f, 17.23f, 15.45f, 16.52f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8.8f, 7.47f);
        v12.lineToRelative(3.02f, 3.02f);
        v12.curveToRelative(0.08f, 0.08f, 0.2f, 0.13f, 0.31f, 0.13f);
        v12.reflectiveCurveToRelative(0.23f, -0.05f, 0.31f, -0.13f);
        v12.lineToRelative(2.99f, -2.99f);
        v12.curveToRelative(0.71f, -0.74f, 1.52f, -0.91f, 2.43f, -0.91f);
        v12.lineToRelative(-3.72f, -3.71f);
        v12.curveToRelative(-1.17f, -1.17f, -3.07f, -1.17f, -4.24f, 0f);
        v12.lineToRelative(-3.71f, 3.7f);
        v12.curveTo(7.95f, 6.58f, 8.49f, 7.16f, 8.8f, 7.47f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21.110001f, 9.85f);
        v12.lineToRelative(-2.25f, -2.26f);
        v12.horizontalLineTo(17.6f);
        v12.curveToRelative(-0.54f, 0f, -1.08f, 0.22f, -1.45f, 0.61f);
        v12.lineToRelative(-3f, 3f);
        v12.curveToRelative(-0.28f, 0.28f, -0.65f, 0.42f, -1.02f, 0.42f);
        v12.curveToRelative(-0.36f, 0f, -0.74f, -0.15f, -1.02f, -0.42f);
        v12.lineTo(8.09f, 8.17f);
        v12.curveToRelative(-0.38f, -0.38f, -0.9f, -0.6f, -1.45f, -0.6f);
        v12.horizontalLineTo(5.17f);
        v12.lineToRelative(-2.29f, 2.3f);
        v12.curveToRelative(-1.17f, 1.17f, -1.17f, 3.07f, 0f, 4.24f);
        v12.lineToRelative(2.29f, 2.3f);
        v12.horizontalLineToRelative(1.48f);
        v12.curveToRelative(0.54f, 0f, 1.06f, -0.22f, 1.45f, -0.6f);
        v12.lineToRelative(3.02f, -3.02f);
        v12.curveToRelative(0.28f, -0.28f, 0.65f, -0.42f, 1.02f, -0.42f);
        v12.curveToRelative(0.37f, 0f, 0.74f, 0.14f, 1.02f, 0.42f);
        v12.lineToRelative(3.01f, 3.01f);
        v12.curveToRelative(0.38f, 0.38f, 0.9f, 0.6f, 1.45f, 0.6f);
        v12.horizontalLineToRelative(1.26f);
        v12.lineToRelative(2.25f, -2.26f);
        v12.curveTo(22.299999f, 12.96f, 22.299999f, 11.04f, 21.110001f, 9.85f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PixKt._pix = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

