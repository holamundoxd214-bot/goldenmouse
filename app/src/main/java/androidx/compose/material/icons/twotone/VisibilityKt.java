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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_visibility", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Visibility", "Landroidx/compose/material/icons/Icons$TwoTone;", "getVisibility", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VisibilityKt {
    private static ImageVector _visibility;

    static {
    }

    public static final ImageVector getVisibility(TwoTone arg19) {
        ImageVector v0 = VisibilityKt._visibility;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Visibility", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(-3.79f, 0f, -7.17f, 2.13f, -8.82f, 5.5f);
        v12.curveTo(4.83f, 14.87f, 8.21f, 17f, 12f, 17f);
        v12.reflectiveCurveToRelative(7.17f, -2.13f, 8.82f, -5.5f);
        v12.curveTo(19.17f, 8.13f, 15.79f, 6f, 12f, 6f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-2.48f, 0f, -4.5f, -2.02f, -4.5f, -4.5f);
        v12.reflectiveCurveTo(9.52f, 7f, 12f, 7f);
        v12.reflectiveCurveToRelative(4.5f, 2.02f, 4.5f, 4.5f);
        v12.reflectiveCurveTo(14.48f, 16f, 12f, 16f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveTo(7f, 4f, 2.73f, 7.11f, 1f, 11.5f);
        v12.curveTo(2.73f, 15.89f, 7f, 19f, 12f, 19f);
        v12.reflectiveCurveToRelative(9.27f, -3.11f, 11f, -7.5f);
        v12.curveTo(21.27f, 7.11f, 17f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(12f, 17f);
        v12.curveToRelative(-3.79f, 0f, -7.17f, -2.13f, -8.82f, -5.5f);
        v12.curveTo(4.83f, 8.13f, 8.21f, 6f, 12f, 6f);
        v12.reflectiveCurveToRelative(7.17f, 2.13f, 8.82f, 5.5f);
        v12.curveTo(19.17f, 14.87f, 15.79f, 17f, 12f, 17f);
        v12.close();
        v12.moveTo(12f, 7f);
        v12.curveToRelative(-2.48f, 0f, -4.5f, 2.02f, -4.5f, 4.5f);
        v12.reflectiveCurveTo(9.52f, 16f, 12f, 16f);
        v12.reflectiveCurveToRelative(4.5f, -2.02f, 4.5f, -4.5f);
        v12.reflectiveCurveTo(14.48f, 7f, 12f, 7f);
        v12.close();
        v12.moveTo(12f, 14f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, -1.12f, -2.5f, -2.5f);
        v12.reflectiveCurveTo(10.62f, 9f, 12f, 9f);
        v12.reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f);
        v12.reflectiveCurveTo(13.38f, 14f, 12f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VisibilityKt._visibility = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

