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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dry", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Dry", "Landroidx/compose/material/icons/Icons$Outlined;", "getDry", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DryKt {
    private static ImageVector _dry;

    static {
    }

    public static final ImageVector getDry(Outlined arg19) {
        ImageVector v0 = DryKt._dry;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Dry", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.75f, 16f);
        v12.curveToRelative(0.69f, 0f, 1.25f, -0.56f, 1.25f, -1.25f);
        v12.reflectiveCurveToRelative(-0.56f, -1.25f, -1.25f, -1.25f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(6.75f);
        v12.curveToRelative(0.69f, 0f, 1.25f, -0.56f, 1.25f, -1.25f);
        v12.curveToRelative(0f, -0.67f, -0.53f, -1.2f, -1.18f, -1.24f);
        v12.lineTo(8.87f, 10f);
        v12.lineToRelative(1.48f, -2.6f);
        v12.curveToRelative(0.09f, -0.17f, 0.14f, -0.34f, 0.14f, -0.54f);
        v12.curveToRelative(0f, -0.26f, -0.09f, -0.5f, -0.26f, -0.7f);
        v12.lineTo(9.12f, 5f);
        v12.lineToRelative(-7.18f, 6.8f);
        v12.curveTo(1.34f, 12.36f, 1f, 13.15f, 1f, 13.97f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.horizontalLineToRelative(13.75f);
        v12.curveToRelative(0.69f, 0f, 1.25f, -0.56f, 1.25f, -1.25f);
        v12.reflectiveCurveToRelative(-0.56f, -1.25f, -1.25f, -1.25f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(7.75f);
        v12.curveToRelative(0.69f, 0f, 1.25f, -0.56f, 1.25f, -1.25f);
        v12.reflectiveCurveTo(20.440001f, 17f, 19.75f, 17f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(20.75f);
        v12.close();
        v12.moveTo(10f, 21f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-6f);
        v12.curveToRelative(0f, -0.39f, 0.23f, -0.64f, 0.36f, -0.75f);
        v12.lineTo(7f, 9.87f);
        v12.verticalLineTo(12f);
        v12.lineToRelative(3f, 0f);
        v12.verticalLineTo(21f);
        v12.close();
        v12.moveTo(15.65f, 4.86f);
        v12.lineToRelative(-0.07f, -0.07f);
        v12.curveToRelative(-0.57f, -0.62f, -0.82f, -1.41f, -0.67f, -2.2f);
        v12.lineTo(15f, 2f);
        v12.horizontalLineToRelative(-1.89f);
        v12.lineToRelative(-0.06f, 0.43f);
        v12.curveToRelative(-0.2f, 1.36f, 0.27f, 2.71f, 1.3f, 3.72f);
        v12.lineToRelative(0.07f, 0.06f);
        v12.curveToRelative(0.57f, 0.62f, 0.82f, 1.41f, 0.67f, 2.2f);
        v12.lineTo(14.98f, 9f);
        v12.horizontalLineToRelative(1.91f);
        v12.lineToRelative(0.06f, -0.43f);
        v12.curveTo(17.16f, 7.21f, 16.68f, 5.86f, 15.65f, 4.86f);
        v12.close();
        v12.moveTo(19.65f, 4.86f);
        v12.lineToRelative(-0.07f, -0.07f);
        v12.curveToRelative(-0.57f, -0.62f, -0.82f, -1.41f, -0.67f, -2.2f);
        v12.lineTo(19f, 2f);
        v12.horizontalLineToRelative(-1.89f);
        v12.lineToRelative(-0.06f, 0.43f);
        v12.curveToRelative(-0.2f, 1.36f, 0.27f, 2.71f, 1.3f, 3.72f);
        v12.lineToRelative(0.07f, 0.06f);
        v12.curveToRelative(0.57f, 0.62f, 0.82f, 1.41f, 0.67f, 2.2f);
        v12.lineTo(18.98f, 9f);
        v12.horizontalLineToRelative(1.91f);
        v12.lineToRelative(0.06f, -0.43f);
        v12.curveTo(21.16f, 7.21f, 20.68f, 5.86f, 19.65f, 4.86f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DryKt._dry = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

