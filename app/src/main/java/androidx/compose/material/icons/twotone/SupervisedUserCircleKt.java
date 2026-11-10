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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_supervisedUserCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SupervisedUserCircle", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSupervisedUserCircle", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SupervisedUserCircleKt {
    private static ImageVector _supervisedUserCircle;

    static {
    }

    public static final ImageVector getSupervisedUserCircle(TwoTone arg20) {
        ImageVector v0 = SupervisedUserCircleKt._supervisedUserCircle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.SupervisedUserCircle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.5f, 10f);
        v12.moveToRelative(-1f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, 2f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, -2f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(11.5f, 17.209999f);
        v12.curveToRelative(0f, -1.88f, 2.98f, -2.7f, 4.5f, -2.7f);
        v12.curveToRelative(0.88f, 0f, 2.24f, 0.27f, 3.24f, 0.87f);
        v12.curveToRelative(0.48f, -1.02f, 0.75f, -2.16f, 0.75f, -3.37f);
        v12.curveToRelative(0f, -4.41f, -3.59f, -8f, -8f, -8f);
        v12.reflectiveCurveToRelative(-8f, 3.59f, -8f, 8f);
        v12.curveToRelative(0f, 1.23f, 0.29f, 2.39f, 0.78f, 3.43f);
        v12.curveToRelative(1.34f, -0.98f, 3.43f, -1.43f, 4.73f, -1.43f);
        v12.curveToRelative(0.44f, 0f, 0.97f, 0.05f, 1.53f, 0.16f);
        v12.curveToRelative(-0.63f, 0.57f, -1.06f, 1.22f, -1.3f, 1.86f);
        v12.curveToRelative(-0.08f, 0f, -0.15f, -0.01f, -0.23f, -0.01f);
        v12.curveToRelative(-1.38f, 0f, -2.98f, 0.57f, -3.66f, 1.11f);
        v12.curveToRelative(1.37f, 1.65f, 3.39f, 2.73f, 5.66f, 2.86f);
        v12.verticalLineToRelative(-2.78f);
        v12.close();
        v12.moveTo(16f, 9f);
        v12.curveToRelative(1.11f, 0f, 2f, 0.89f, 2f, 2f);
        v12.curveToRelative(0f, 1.11f, -0.89f, 2f, -2f, 2f);
        v12.curveToRelative(-1.11f, 0f, -2f, -0.89f, -2f, -2f);
        v12.curveToRelative(-0.01f, -1.11f, 0.89f, -2f, 2f, -2f);
        v12.close();
        v12.moveTo(9.5f, 13f);
        v12.curveToRelative(-1.65f, 0f, -3f, -1.35f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.35f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.35f, 3f, 3f);
        v12.reflectiveCurveToRelative(-1.35f, 3f, -3f, 3f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.5f, 10f);
        v12.curveToRelative(0f, -1.65f, -1.35f, -3f, -3f, -3f);
        v12.reflectiveCurveToRelative(-3f, 1.35f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.35f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.35f, 3f, -3f);
        v12.close();
        v12.moveTo(9.5f, 11f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.close();
        v12.moveTo(16f, 13f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.89f, 2f, -2f);
        v12.curveToRelative(0f, -1.11f, -0.89f, -2f, -2f, -2f);
        v12.curveToRelative(-1.11f, 0f, -2.01f, 0.89f, -2f, 2f);
        v12.curveToRelative(0f, 1.11f, 0.89f, 2f, 2f, 2f);
        v12.close();
        v12.moveTo(11.99f, 2.01f);
        v12.curveToRelative(-5.52f, 0f, -10f, 4.48f, -10f, 10f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveToRelative(-4.48f, -10f, -10f, -10f);
        v12.close();
        v12.moveTo(5.84f, 17.120001f);
        v12.curveToRelative(0.68f, -0.54f, 2.27f, -1.11f, 3.66f, -1.11f);
        v12.curveToRelative(0.07f, 0f, 0.15f, 0.01f, 0.23f, 0.01f);
        v12.curveToRelative(0.24f, -0.64f, 0.67f, -1.29f, 1.3f, -1.86f);
        v12.curveToRelative(-0.56f, -0.1f, -1.09f, -0.16f, -1.53f, -0.16f);
        v12.curveToRelative(-1.3f, 0f, -3.39f, 0.45f, -4.73f, 1.43f);
        v12.curveToRelative(-0.5f, -1.04f, -0.78f, -2.2f, -0.78f, -3.43f);
        v12.curveToRelative(0f, -4.41f, 3.59f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.59f, 8f, 8f);
        v12.curveToRelative(0f, 1.2f, -0.27f, 2.34f, -0.75f, 3.37f);
        v12.curveToRelative(-1f, -0.59f, -2.36f, -0.87f, -3.24f, -0.87f);
        v12.curveToRelative(-1.52f, 0f, -4.5f, 0.81f, -4.5f, 2.7f);
        v12.verticalLineToRelative(2.78f);
        v12.curveToRelative(-2.27f, -0.13f, -4.29f, -1.21f, -5.66f, -2.86f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SupervisedUserCircleKt._supervisedUserCircle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

