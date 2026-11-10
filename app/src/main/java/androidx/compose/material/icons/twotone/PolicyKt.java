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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_policy", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Policy", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPolicy", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PolicyKt {
    private static ImageVector _policy;

    static {
    }

    public static final ImageVector getPolicy(TwoTone arg19) {
        ImageVector v0 = PolicyKt._policy;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Policy", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5f, 6.3f);
        v12.verticalLineTo(11f);
        v12.curveToRelative(0f, 4.52f, 2.98f, 8.69f, 7f, 9.93f);
        v12.curveToRelative(1.74f, -0.53f, 3.28f, -1.62f, 4.47f, -3.04f);
        v12.lineToRelative(-1.72f, -1.72f);
        v12.curveToRelative(-1.94f, 1.29f, -4.58f, 1.07f, -6.29f, -0.64f);
        v12.curveToRelative(-1.95f, -1.95f, -1.95f, -5.12f, 0f, -7.07f);
        v12.curveToRelative(1.95f, -1.95f, 5.12f, -1.95f, 7.07f, 0f);
        v12.curveToRelative(1.71f, 1.71f, 1.92f, 4.35f, 0.64f, 6.29f);
        v12.lineToRelative(1.45f, 1.45f);
        v12.curveTo(18.49f, 14.65f, 19f, 12.85f, 19f, 11f);
        v12.verticalLineTo(6.3f);
        v12.lineToRelative(-7f, -3.11f);
        v12.lineTo(5f, 6.3f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 1f);
        v12.lineTo(3f, 5f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(0f, 5.55f, 3.84f, 10.74f, 9f, 12f);
        v12.curveToRelative(0.65f, -0.16f, 1.27f, -0.38f, 1.87f, -0.65f);
        v12.curveToRelative(1.8f, -0.82f, 3.36f, -2.13f, 4.57f, -3.74f);
        v12.curveTo(20.040001f, 16.459999f, 21f, 13.77f, 21f, 11f);
        v12.verticalLineTo(5f);
        v12.lineTo(12f, 1f);
        v12.close();
        v12.moveTo(19f, 11f);
        v12.curveToRelative(0f, 1.85f, -0.51f, 3.65f, -1.38f, 5.21f);
        v12.lineToRelative(-1.45f, -1.45f);
        v12.curveToRelative(1.29f, -1.94f, 1.07f, -4.58f, -0.64f, -6.29f);
        v12.curveToRelative(-1.95f, -1.95f, -5.12f, -1.95f, -7.07f, 0f);
        v12.curveToRelative(-1.95f, 1.95f, -1.95f, 5.12f, 0f, 7.07f);
        v12.curveToRelative(1.71f, 1.71f, 4.35f, 1.92f, 6.29f, 0.64f);
        v12.lineToRelative(1.72f, 1.72f);
        v12.curveToRelative(-1.19f, 1.42f, -2.73f, 2.51f, -4.47f, 3.04f);
        v12.curveTo(7.98f, 19.690001f, 5f, 15.52f, 5f, 11f);
        v12.verticalLineTo(6.3f);
        v12.lineToRelative(7f, -3.11f);
        v12.lineToRelative(7f, 3.11f);
        v12.verticalLineTo(11f);
        v12.close();
        v12.moveTo(15f, 12f);
        v12.curveToRelative(0f, 1.66f, -1.34f, 3f, -3f, 3f);
        v12.reflectiveCurveToRelative(-3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveTo(15f, 10.34f, 15f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PolicyKt._policy = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

