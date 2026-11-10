package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_selfImprovement", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SelfImprovement", "Landroidx/compose/material/icons/Icons$Outlined;", "getSelfImprovement", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SelfImprovementKt {
    private static ImageVector _selfImprovement;

    static {
    }

    public static final ImageVector getSelfImprovement(Outlined arg20) {
        ImageVector v0 = SelfImprovementKt._selfImprovement;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SelfImprovement", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(21f, 16f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-2.24f, 0f, -4.16f, -0.96f, -5.6f, -2.68f);
        v12.lineToRelative(-1.34f, -1.6f);
        v12.curveTo(13.68f, 9.26f, 13.12f, 9f, 12.53f, 9f);
        v12.horizontalLineToRelative(-1.05f);
        v12.curveToRelative(-0.59f, 0f, -1.15f, 0.26f, -1.53f, 0.72f);
        v12.lineToRelative(-1.34f, 1.6f);
        v12.curveTo(7.16f, 13.04f, 5.24f, 14f, 3f, 14f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(2.77f, 0f, 5.19f, -1.17f, 7f, -3.25f);
        v12.verticalLineTo(15f);
        v12.lineToRelative(-3.88f, 1.55f);
        v12.curveTo(5.45f, 16.82f, 5f, 17.48f, 5f, 18.209999f);
        v12.curveTo(5f, 19.200001f, 5.8f, 20f, 6.79f, 20f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(-0.5f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.reflectiveCurveTo(14.78f, 18f, 14.5f, 18f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(7.21f);
        v12.curveTo(18.200001f, 20f, 19f, 19.200001f, 19f, 18.209999f);
        v12.curveToRelative(0f, -0.73f, -0.45f, -1.39f, -1.12f, -1.66f);
        v12.lineTo(14f, 15f);
        v12.verticalLineToRelative(-2.25f);
        v12.curveTo(15.81f, 14.83f, 18.23f, 16f, 21f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SelfImprovementKt._selfImprovement = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

