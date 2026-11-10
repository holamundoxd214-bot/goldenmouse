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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_storm", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Storm", "Landroidx/compose/material/icons/Icons$TwoTone;", "getStorm", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StormKt {
    private static ImageVector _storm;

    static {
    }

    public static final ImageVector getStorm(TwoTone arg20) {
        ImageVector v0 = StormKt._storm;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Storm", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 12f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17.200001f, 9f);
        v12.curveTo(15.54f, 6.13f, 11.86f, 5.15f, 9f, 6.8f);
        v12.curveToRelative(-2.67f, 1.54f, -3.7f, 4.84f, -2.5f, 7.6f);
        v12.curveToRelative(0.09f, 0.2f, 0.19f, 0.4f, 0.3f, 0.6f);
        v12.curveToRelative(1.66f, 2.87f, 5.33f, 3.85f, 8.2f, 2.2f);
        v12.curveToRelative(2.67f, -1.54f, 3.7f, -4.84f, 2.5f, -7.6f);
        v12.curveTo(17.41f, 9.4f, 17.309999f, 9.2f, 17.200001f, 9f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.reflectiveCurveToRelative(1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.reflectiveCurveTo(14.21f, 16f, 12f, 16f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 8f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.reflectiveCurveTo(14.21f, 8f, 12f, 8f);
        v12.close();
        v12.moveTo(12f, 14f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveTo(13.1f, 14f, 12f, 14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18.93f, 8f);
        v12.curveTo(16.719999f, 4.18f, 11.82f, 2.87f, 8f, 5.07f);
        v12.curveToRelative(-1.41f, 0.82f, -2.48f, 2f, -3.16f, 3.37f);
        v12.curveTo(4.71f, 6.24f, 5.06f, 4.04f, 5.86f, 2f);
        v12.horizontalLineTo(3.74f);
        v12.curveTo(2.2f, 6.49f, 2.52f, 11.58f, 5.07f, 16f);
        v12.curveToRelative(1.1f, 1.91f, 2.88f, 3.19f, 4.86f, 3.72f);
        v12.curveToRelative(1.98f, 0.53f, 4.16f, 0.31f, 6.07f, -0.79f);
        v12.curveToRelative(1.41f, -0.82f, 2.48f, -2f, 3.16f, -3.37f);
        v12.curveToRelative(0.13f, 2.2f, -0.21f, 4.4f, -1.01f, 6.44f);
        v12.horizontalLineToRelative(2.11f);
        v12.curveTo(21.790001f, 17.51f, 21.48f, 12.42f, 18.93f, 8f);
        v12.close();
        v12.moveTo(15f, 17.200001f);
        v12.curveToRelative(-2.87f, 1.65f, -6.54f, 0.67f, -8.2f, -2.2f);
        v12.curveToRelative(-0.11f, -0.2f, -0.21f, -0.4f, -0.3f, -0.6f);
        v12.curveTo(5.3f, 11.64f, 6.33f, 8.34f, 9f, 6.8f);
        v12.curveToRelative(2.86f, -1.65f, 6.54f, -0.67f, 8.2f, 2.2f);
        v12.curveToRelative(0.11f, 0.2f, 0.21f, 0.4f, 0.3f, 0.6f);
        v12.curveTo(18.700001f, 12.36f, 17.67f, 15.66f, 15f, 17.200001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StormKt._storm = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

