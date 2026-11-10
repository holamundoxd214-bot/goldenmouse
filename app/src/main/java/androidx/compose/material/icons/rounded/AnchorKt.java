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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_anchor", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Anchor", "Landroidx/compose/material/icons/Icons$Rounded;", "getAnchor", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AnchorKt {
    private static ImageVector _anchor;

    static {
    }

    public static final ImageVector getAnchor(Rounded arg19) {
        ImageVector v0 = AnchorKt._anchor;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Anchor", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 9f);
        v12.verticalLineTo(7.82f);
        v12.curveTo(14.16f, 7.4f, 15f, 6.3f, 15f, 5f);
        v12.curveToRelative(0f, -1.65f, -1.35f, -3f, -3f, -3f);
        v12.reflectiveCurveTo(9f, 3.35f, 9f, 5f);
        v12.curveToRelative(0f, 1.3f, 0.84f, 2.4f, 2f, 2.82f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(8.92f);
        v12.curveToRelative(-2.22f, -0.33f, -4.59f, -1.68f, -5.55f, -3.37f);
        v12.lineToRelative(1.14f, -1.14f);
        v12.curveToRelative(0.22f, -0.22f, 0.19f, -0.57f, -0.05f, -0.75f);
        v12.lineTo(3.8f, 12.6f);
        v12.curveTo(3.47f, 12.35f, 3f, 12.59f, 3f, 13f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 3.88f, 4.92f, 7f, 9f, 7f);
        v12.reflectiveCurveToRelative(9f, -3.12f, 9f, -7f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.41f, -0.47f, -0.65f, -0.8f, -0.4f);
        v12.lineToRelative(-2.74f, 2.05f);
        v12.curveToRelative(-0.24f, 0.18f, -0.27f, 0.54f, -0.05f, 0.75f);
        v12.lineToRelative(1.14f, 1.14f);
        v12.curveToRelative(-0.96f, 1.69f, -3.33f, 3.04f, -5.55f, 3.37f);
        v12.verticalLineTo(11f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(13f);
        v12.close();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveTo(11.45f, 4f, 12f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AnchorKt._anchor = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

