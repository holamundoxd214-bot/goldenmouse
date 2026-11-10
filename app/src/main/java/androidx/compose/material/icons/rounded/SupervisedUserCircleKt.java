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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_supervisedUserCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SupervisedUserCircle", "Landroidx/compose/material/icons/Icons$Rounded;", "getSupervisedUserCircle", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SupervisedUserCircleKt {
    private static ImageVector _supervisedUserCircle;

    static {
    }

    public static final ImageVector getSupervisedUserCircle(Rounded arg19) {
        ImageVector v0 = SupervisedUserCircleKt._supervisedUserCircle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SupervisedUserCircle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(15.61f, 8.34f);
        v12.curveToRelative(1.07f, 0f, 1.93f, 0.86f, 1.93f, 1.93f);
        v12.reflectiveCurveToRelative(-0.86f, 1.93f, -1.93f, 1.93f);
        v12.reflectiveCurveToRelative(-1.93f, -0.86f, -1.93f, -1.93f);
        v12.curveToRelative(-0.01f, -1.07f, 0.86f, -1.93f, 1.93f, -1.93f);
        v12.close();
        v12.moveTo(9.61f, 6.76f);
        v12.curveToRelative(1.3f, 0f, 2.36f, 1.06f, 2.36f, 2.36f);
        v12.reflectiveCurveToRelative(-1.06f, 2.36f, -2.36f, 2.36f);
        v12.reflectiveCurveToRelative(-2.36f, -1.06f, -2.36f, -2.36f);
        v12.curveToRelative(0f, -1.31f, 1.05f, -2.36f, 2.36f, -2.36f);
        v12.close();
        v12.moveTo(9.61f, 15.89f);
        v12.verticalLineToRelative(3.75f);
        v12.curveToRelative(-2.4f, -0.75f, -4.3f, -2.6f, -5.14f, -4.96f);
        v12.curveToRelative(1.05f, -1.12f, 3.67f, -1.69f, 5.14f, -1.69f);
        v12.curveToRelative(0.53f, 0f, 1.2f, 0.08f, 1.9f, 0.22f);
        v12.curveToRelative(-1.64f, 0.87f, -1.9f, 2.02f, -1.9f, 2.68f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-0.27f, 0f, -0.53f, -0.01f, -0.79f, -0.04f);
        v12.verticalLineToRelative(-4.07f);
        v12.curveToRelative(0f, -1.42f, 2.94f, -2.13f, 4.4f, -2.13f);
        v12.curveToRelative(1.07f, 0f, 2.92f, 0.39f, 3.84f, 1.15f);
        v12.curveTo(18.280001f, 17.879999f, 15.39f, 20f, 12f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SupervisedUserCircleKt._supervisedUserCircle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

