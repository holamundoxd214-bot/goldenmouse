package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_contentCut", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ContentCut", "Landroidx/compose/material/icons/Icons$Sharp;", "getContentCut", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ContentCutKt {
    private static ImageVector _contentCut;

    static {
    }

    public static final ImageVector getContentCut(Sharp arg19) {
        ImageVector v0 = ContentCutKt._contentCut;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.ContentCut", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.64f, 7.64f);
        v12.curveToRelative(0.23f, -0.5f, 0.36f, -1.05f, 0.36f, -1.64f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.reflectiveCurveTo(2f, 3.79f, 2f, 6f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.curveToRelative(0.59f, 0f, 1.14f, -0.13f, 1.64f, -0.36f);
        v12.lineTo(10f, 12f);
        v12.lineToRelative(-2.36f, 2.36f);
        v12.curveTo(7.14f, 14.13f, 6.59f, 14f, 6f, 14f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.curveToRelative(0f, -0.59f, -0.13f, -1.14f, -0.36f, -1.64f);
        v12.lineTo(12f, 14f);
        v12.lineToRelative(7f, 7f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-1f);
        v12.lineTo(9.64f, 7.64f);
        v12.close();
        v12.moveTo(6f, 8f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.89f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.89f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.close();
        v12.moveTo(6f, 20f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.89f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.89f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.close();
        v12.moveTo(12f, 12.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f);
        v12.close();
        v12.moveTo(19f, 3f);
        v12.lineToRelative(-6f, 6f);
        v12.lineToRelative(2f, 2f);
        v12.lineToRelative(7f, -7f);
        v12.lineTo(22f, 3f);
        v12.horizontalLineToRelative(-3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ContentCutKt._contentCut = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

