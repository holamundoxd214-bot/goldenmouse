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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_addLocationAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddLocationAlt", "Landroidx/compose/material/icons/Icons$Rounded;", "getAddLocationAlt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AddLocationAltKt {
    private static ImageVector _addLocationAlt;

    static {
    }

    public static final ImageVector getAddLocationAlt(Rounded arg19) {
        ImageVector v0 = AddLocationAltKt._addLocationAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AddLocationAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(1f);
        v12.curveTo(18f, 0.45f, 18.450001f, 0f, 19f, 0f);
        v12.close();
        v12.moveTo(12f, 12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(10.9f, 12f, 12f, 12f);
        v12.close();
        v12.moveTo(14.72f, 2.47f);
        v12.curveTo(14.28f, 2.83f, 14f, 3.38f, 14f, 4f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.curveToRelative(0.32f, 0f, 0.62f, -0.08f, 0.89f, -0.21f);
        v12.curveTo(19.959999f, 9.24f, 20f, 9.71f, 20f, 10.2f);
        v12.curveToRelative(0f, 3.18f, -2.45f, 6.92f, -7.34f, 11.23f);
        v12.curveToRelative(-0.38f, 0.33f, -0.95f, 0.33f, -1.33f, 0f);
        v12.curveTo(6.45f, 17.120001f, 4f, 13.38f, 4f, 10.2f);
        v12.curveTo(4f, 5.22f, 7.8f, 2f, 12f, 2f);
        v12.curveTo(12.94f, 2f, 13.86f, 2.16f, 14.72f, 2.47f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AddLocationAltKt._addLocationAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

