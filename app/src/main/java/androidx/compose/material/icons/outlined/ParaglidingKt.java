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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_paragliding", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Paragliding", "Landroidx/compose/material/icons/Icons$Outlined;", "getParagliding", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ParaglidingKt {
    private static ImageVector _paragliding;

    static {
    }

    public static final ImageVector getParagliding(Outlined arg19) {
        ImageVector v0 = ParaglidingKt._paragliding;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Paragliding", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 17f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.curveTo(14f, 16.1f, 13.1f, 17f, 12f, 17f);
        v12.close();
        v12.moveTo(15.48f, 17.940001f);
        v12.curveTo(14.68f, 18.540001f, 14f, 19f, 12f, 19f);
        v12.reflectiveCurveToRelative(-2.68f, -0.46f, -3.48f, -1.06f);
        v12.curveTo(8.04f, 17.549999f, 7f, 16.76f, 7f, 14f);
        v12.horizontalLineTo(5f);
        v12.curveToRelative(0f, 2.7f, 0.93f, 4.41f, 2.3f, 5.5f);
        v12.curveToRelative(0.5f, 0.4f, 1.1f, 0.7f, 1.7f, 0.9f);
        v12.verticalLineTo(24f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-3.6f);
        v12.curveToRelative(0.6f, -0.2f, 1.2f, -0.5f, 1.7f, -0.9f);
        v12.curveToRelative(1.37f, -1.09f, 2.3f, -2.8f, 2.3f, -5.5f);
        v12.horizontalLineToRelative(-2f);
        v12.curveTo(17f, 16.76f, 15.96f, 17.549999f, 15.48f, 17.940001f);
        v12.close();
        v12.moveTo(23f, 4.25f);
        v12.verticalLineToRelative(3.49f);
        v12.curveToRelative(0f, 0.8f, -0.88f, 1.26f, -1.56f, 0.83f);
        v12.curveTo(21.299999f, 8.48f, 21.16f, 8.39f, 21f, 8.31f);
        v12.lineTo(19f, 13f);
        v12.horizontalLineToRelative(-2f);
        v12.lineToRelative(-1.5f, -6.28f);
        v12.curveTo(14.4f, 6.58f, 13.22f, 6.5f, 12f, 6.5f);
        v12.reflectiveCurveTo(9.6f, 6.58f, 8.5f, 6.72f);
        v12.lineTo(7f, 13f);
        v12.horizontalLineTo(5f);
        v12.lineTo(3f, 8.31f);
        v12.curveTo(2.84f, 8.39f, 2.7f, 8.48f, 2.56f, 8.57f);
        v12.curveTo(1.88f, 9f, 1f, 8.55f, 1f, 7.74f);
        v12.verticalLineTo(4.25f);
        v12.curveTo(1f, 1.9f, 5.92f, 0f, 12f, 0f);
        v12.reflectiveCurveTo(23f, 1.9f, 23f, 4.25f);
        v12.close();
        v12.moveTo(6.9f, 6.98f);
        v12.curveTo(5.97f, 7.17f, 5.12f, 7.41f, 4.37f, 7.69f);
        v12.lineToRelative(1.51f, 3.55f);
        v12.lineTo(6.9f, 6.98f);
        v12.close();
        v12.moveTo(19.629999f, 7.69f);
        v12.curveToRelative(-0.75f, -0.28f, -1.6f, -0.52f, -2.53f, -0.71f);
        v12.lineToRelative(1.02f, 4.25f);
        v12.lineTo(19.629999f, 7.69f);
        v12.close();
        v12.moveTo(21f, 4.31f);
        v12.curveTo(20.65f, 3.63f, 17.57f, 2f, 12f, 2f);
        v12.reflectiveCurveTo(3.35f, 3.63f, 3f, 4.31f);
        v12.verticalLineToRelative(1.77f);
        v12.curveTo(5.34f, 5.07f, 8.56f, 4.5f, 12f, 4.5f);
        v12.reflectiveCurveToRelative(6.66f, 0.57f, 9f, 1.58f);
        v12.verticalLineTo(4.31f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ParaglidingKt._paragliding = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

