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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_animation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Animation", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAnimation", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AnimationKt {
    private static ImageVector _animation;

    static {
    }

    public static final ImageVector getAnimation(TwoTone arg19) {
        ImageVector v0 = AnimationKt._animation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Animation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5f, 12f);
        v12.curveToRelative(-0.63f, 0.84f, -1f, 1.88f, -1f, 3f);
        v12.curveToRelative(0f, 2.76f, 2.24f, 5f, 5f, 5f);
        v12.curveToRelative(1.12f, 0f, 2.16f, -0.37f, 3f, -1f);
        v12.curveTo(8.13f, 19f, 5f, 15.87f, 5f, 12f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15f, 4f);
        v12.curveToRelative(-1.13f, 0f, -2.16f, 0.37f, -3f, 1f);
        v12.curveToRelative(3.87f, 0.01f, 7f, 3.14f, 7f, 7f);
        v12.curveToRelative(0.63f, -0.84f, 1f, -1.88f, 1f, -3f);
        v12.curveTo(20f, 6.24f, 17.76f, 4f, 15f, 4f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 7f);
        v12.curveToRelative(-0.6f, 0f, -1.17f, 0.11f, -1.7f, 0.3f);
        v12.curveTo(10.11f, 7.83f, 10f, 8.4f, 10f, 9f);
        v12.curveToRelative(0f, 2.76f, 2.24f, 5f, 5f, 5f);
        v12.curveToRelative(0.6f, 0f, 1.17f, -0.11f, 1.7f, -0.3f);
        v12.curveToRelative(0.19f, -0.53f, 0.3f, -1.1f, 0.3f, -1.7f);
        v12.curveTo(17f, 9.24f, 14.76f, 7f, 12f, 7f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8f, 9f);
        v12.curveToRelative(-0.63f, 0.84f, -1f, 1.88f, -1f, 3f);
        v12.curveToRelative(0f, 2.76f, 2.24f, 5f, 5f, 5f);
        v12.curveToRelative(1.12f, 0f, 2.16f, -0.37f, 3f, -1f);
        v12.curveTo(11.13f, 15.99f, 8f, 12.86f, 8f, 9f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15f, 2f);
        v12.curveToRelative(-2.71f, 0f, -5.05f, 1.54f, -6.22f, 3.78f);
        v12.curveToRelative(-1.28f, 0.67f, -2.34f, 1.72f, -3f, 3f);
        v12.curveTo(3.54f, 9.95f, 2f, 12.29f, 2f, 15f);
        v12.curveToRelative(0f, 3.87f, 3.13f, 7f, 7f, 7f);
        v12.curveToRelative(2.71f, 0f, 5.05f, -1.54f, 6.22f, -3.78f);
        v12.curveToRelative(1.28f, -0.67f, 2.34f, -1.72f, 3f, -3f);
        v12.curveTo(20.459999f, 14.05f, 22f, 11.71f, 22f, 9f);
        v12.curveTo(22f, 5.13f, 18.870001f, 2f, 15f, 2f);
        v12.close();
        v12.moveTo(9f, 20f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.curveToRelative(0f, -1.12f, 0.37f, -2.16f, 1f, -3f);
        v12.curveToRelative(0f, 3.87f, 3.13f, 7f, 7f, 7f);
        v12.curveTo(11.16f, 19.629999f, 10.12f, 20f, 9f, 20f);
        v12.close();
        v12.moveTo(12f, 17f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.curveToRelative(0f, -1.12f, 0.37f, -2.16f, 1f, -3f);
        v12.curveToRelative(0f, 3.86f, 3.13f, 6.99f, 7f, 7f);
        v12.curveTo(14.16f, 16.629999f, 13.12f, 17f, 12f, 17f);
        v12.close();
        v12.moveTo(16.700001f, 13.7f);
        v12.curveTo(16.17f, 13.89f, 15.6f, 14f, 15f, 14f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.curveToRelative(0f, -0.6f, 0.11f, -1.17f, 0.3f, -1.7f);
        v12.curveTo(10.83f, 7.11f, 11.4f, 7f, 12f, 7f);
        v12.curveToRelative(2.76f, 0f, 5f, 2.24f, 5f, 5f);
        v12.curveTo(17f, 12.6f, 16.889999f, 13.17f, 16.700001f, 13.7f);
        v12.close();
        v12.moveTo(19f, 12f);
        v12.curveToRelative(0f, -3.86f, -3.13f, -6.99f, -7f, -7f);
        v12.curveToRelative(0.84f, -0.63f, 1.87f, -1f, 3f, -1f);
        v12.curveToRelative(2.76f, 0f, 5f, 2.24f, 5f, 5f);
        v12.curveTo(20f, 10.12f, 19.629999f, 11.16f, 19f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AnimationKt._animation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

