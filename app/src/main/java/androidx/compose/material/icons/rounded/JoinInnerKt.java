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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_joinInner", "Landroidx/compose/ui/graphics/vector/ImageVector;", "JoinInner", "Landroidx/compose/material/icons/Icons$Rounded;", "getJoinInner", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class JoinInnerKt {
    private static ImageVector _joinInner;

    static {
    }

    public static final ImageVector getJoinInner(Rounded arg19) {
        ImageVector v0 = JoinInnerKt._joinInner;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.JoinInner", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.68f, 6.8f);
        v12.curveToRelative(-0.39f, -0.35f, -0.98f, -0.35f, -1.37f, 0f);
        v12.curveTo(9.35f, 8.56f, 9f, 10.84f, 9f, 12f);
        v12.curveToRelative(0f, 1.15f, 0.35f, 3.44f, 2.32f, 5.2f);
        v12.curveToRelative(0.39f, 0.35f, 0.98f, 0.35f, 1.37f, 0f);
        v12.curveTo(14.65f, 15.44f, 15f, 13.16f, 15f, 12f);
        v12.curveTo(15f, 10.85f, 14.65f, 8.56f, 12.68f, 6.8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9.04f, 16.870001f);
        v12.curveTo(8.71f, 16.950001f, 8.36f, 17f, 8f, 17f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.reflectiveCurveToRelative(2.24f, -5f, 5f, -5f);
        v12.curveToRelative(0.36f, 0f, 0.71f, 0.05f, 1.04f, 0.13f);
        v12.curveToRelative(0.39f, -0.56f, 0.88f, -1.12f, 1.49f, -1.63f);
        v12.curveTo(9.75f, 5.19f, 8.9f, 5f, 8f, 5f);
        v12.curveToRelative(-3.86f, 0f, -7f, 3.14f, -7f, 7f);
        v12.reflectiveCurveToRelative(3.14f, 7f, 7f, 7f);
        v12.curveToRelative(0.9f, 0f, 1.75f, -0.19f, 2.53f, -0.5f);
        v12.curveTo(9.92f, 17.99f, 9.43f, 17.43f, 9.04f, 16.870001f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16f, 5f);
        v12.curveToRelative(-0.9f, 0f, -1.75f, 0.19f, -2.53f, 0.5f);
        v12.curveToRelative(0.61f, 0.51f, 1.1f, 1.07f, 1.49f, 1.63f);
        v12.curveTo(15.29f, 7.05f, 15.64f, 7f, 16f, 7f);
        v12.curveToRelative(2.76f, 0f, 5f, 2.24f, 5f, 5f);
        v12.reflectiveCurveToRelative(-2.24f, 5f, -5f, 5f);
        v12.curveToRelative(-0.36f, 0f, -0.71f, -0.05f, -1.04f, -0.13f);
        v12.curveToRelative(-0.39f, 0.56f, -0.88f, 1.12f, -1.49f, 1.63f);
        v12.curveTo(14.25f, 18.809999f, 15.1f, 19f, 16f, 19f);
        v12.curveToRelative(3.86f, 0f, 7f, -3.14f, 7f, -7f);
        v12.reflectiveCurveTo(19.860001f, 5f, 16f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        JoinInnerKt._joinInner = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

