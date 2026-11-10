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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_selfImprovement", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SelfImprovement", "Landroidx/compose/material/icons/Icons$Rounded;", "getSelfImprovement", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SelfImprovementKt {
    private static ImageVector _selfImprovement;

    static {
    }

    public static final ImageVector getSelfImprovement(Rounded arg20) {
        ImageVector v0 = SelfImprovementKt._selfImprovement;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SelfImprovement", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21f, 14.94f);
        v12.lineTo(21f, 14.94f);
        v12.curveToRelative(0f, -0.5f, -0.36f, -0.93f, -0.85f, -0.98f);
        v12.curveToRelative(-1.88f, -0.21f, -3.49f, -1.13f, -4.75f, -2.63f);
        v12.lineToRelative(-1.34f, -1.6f);
        v12.curveTo(13.68f, 9.26f, 13.12f, 9f, 12.53f, 9f);
        v12.horizontalLineToRelative(-1.05f);
        v12.curveToRelative(-0.59f, 0f, -1.15f, 0.26f, -1.53f, 0.72f);
        v12.lineToRelative(-1.34f, 1.6f);
        v12.curveToRelative(-1.25f, 1.5f, -2.87f, 2.42f, -4.75f, 2.63f);
        v12.curveTo(3.36f, 14.01f, 3f, 14.44f, 3f, 14.94f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.6f, 0.53f, 1.07f, 1.13f, 1f);
        v12.curveToRelative(2.3f, -0.27f, 4.32f, -1.39f, 5.87f, -3.19f);
        v12.verticalLineTo(15f);
        v12.lineToRelative(-3.76f, 1.5f);
        v12.curveToRelative(-0.65f, 0.26f, -1.16f, 0.83f, -1.23f, 1.53f);
        v12.curveTo(4.91f, 19.1f, 5.74f, 20f, 6.79f, 20f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(-0.5f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.reflectiveCurveTo(14.78f, 18f, 14.5f, 18f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f);
        v12.verticalLineTo(20f);
        v12.lineToRelative(7.1f, 0f);
        v12.curveToRelative(0.85f, 0f, 1.65f, -0.54f, 1.85f, -1.37f);
        v12.curveToRelative(0.21f, -0.89f, -0.27f, -1.76f, -1.08f, -2.08f);
        v12.lineTo(14f, 15f);
        v12.verticalLineToRelative(-2.25f);
        v12.curveToRelative(1.56f, 1.8f, 3.57f, 2.91f, 5.87f, 3.19f);
        v12.curveTo(20.469999f, 16f, 21f, 15.54f, 21f, 14.94f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SelfImprovementKt._selfImprovement = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

