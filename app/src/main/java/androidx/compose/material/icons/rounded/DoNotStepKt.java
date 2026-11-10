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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_doNotStep", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DoNotStep", "Landroidx/compose/material/icons/Icons$Rounded;", "getDoNotStep", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DoNotStepKt {
    private static ImageVector _doNotStep;

    static {
    }

    public static final ImageVector getDoNotStep(Rounded arg19) {
        ImageVector v0 = DoNotStepKt._doNotStep;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DoNotStep", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.1f, 3.51f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(7.19f, 7.19f);
        v12.curveToRelative(0.18f, 0.2f, 0.18f, 0.5f, -0.01f, 0.7f);
        v12.curveToRelative(-0.1f, 0.1f, -0.23f, 0.15f, -0.35f, 0.15f);
        v12.reflectiveCurveToRelative(-0.26f, -0.05f, -0.35f, -0.15f);
        v12.lineTo(6.87f, 11.1f);
        v12.curveToRelative(-0.11f, 0.4f, -0.26f, 0.78f, -0.45f, 1.12f);
        v12.lineToRelative(1.4f, 1.4f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.curveToRelative(-0.1f, 0.1f, -0.23f, 0.15f, -0.35f, 0.15f);
        v12.reflectiveCurveToRelative(-0.26f, -0.05f, -0.35f, -0.15f);
        v12.lineToRelative(-1.27f, -1.27f);
        v12.curveToRelative(-0.24f, 0.29f, -0.5f, 0.56f, -0.77f, 0.8f);
        v12.lineToRelative(1.28f, 1.28f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.curveTo(6.26f, 15.95f, 6.13f, 16f, 6f, 16f);
        v12.reflectiveCurveToRelative(-0.26f, -0.05f, -0.35f, -0.15f);
        v12.lineToRelative(-1.38f, -1.38f);
        v12.curveToRelative(-0.71f, 0.47f, -1.43f, 0.81f, -2.02f, 1.04f);
        v12.curveTo(1.49f, 15.81f, 1f, 16.549999f, 1f, 17.370001f);
        v12.lineTo(1f, 18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(6.67f);
        v12.curveToRelative(0.53f, 0f, 1.04f, -0.21f, 1.41f, -0.59f);
        v12.lineToRelative(2.74f, -2.74f);
        v12.lineToRelative(5.23f, 5.23f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveTo(3.12f, 3.12f, 2.49f, 3.12f, 2.1f, 3.51f);
        v12.lineTo(2.1f, 3.51f);
        v12.close();
        v12.moveTo(18.51f, 15.68f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(4.48f, -4.48f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.78f, 0.78f, 0.78f, 2.05f, 0f, 2.83f);
        v12.lineTo(18.51f, 15.68f);
        v12.close();
        v12.moveTo(20.879999f, 9.08f);
        v12.lineToRelative(-4.48f, 4.48f);
        v12.lineTo(9.3f, 6.47f);
        v12.lineToRelative(3.09f, -3.07f);
        v12.curveToRelative(0.78f, -0.78f, 2.04f, -0.77f, 2.82f, 0f);
        v12.lineTo(20.879999f, 9.08f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DoNotStepKt._doNotStep = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

