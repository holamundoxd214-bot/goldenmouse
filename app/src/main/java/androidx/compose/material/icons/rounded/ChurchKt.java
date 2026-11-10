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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_church", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Church", "Landroidx/compose/material/icons/Icons$Rounded;", "getChurch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ChurchKt {
    private static ImageVector _church;

    static {
    }

    public static final ImageVector getChurch(Rounded arg19) {
        ImageVector v0 = ChurchKt._church;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Church", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 12.22f);
        v12.verticalLineToRelative(-1.99f);
        v12.curveToRelative(0f, -0.76f, -0.43f, -1.45f, -1.11f, -1.79f);
        v12.lineTo(13f, 6.5f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-1f);
        v12.curveTo(9.45f, 3f, 9f, 3.45f, 9f, 4f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(1.5f);
        v12.lineTo(7.11f, 8.45f);
        v12.curveTo(6.43f, 8.79f, 6f, 9.48f, 6f, 10.24f);
        v12.verticalLineToRelative(1.99f);
        v12.lineToRelative(-2.81f, 1.25f);
        v12.curveTo(2.47f, 13.79f, 2f, 14.51f, 2f, 15.3f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(6f);
        v12.lineToRelative(0f, -2.89f);
        v12.curveToRelative(0f, -1f, 0.68f, -1.92f, 1.66f, -2.08f);
        v12.curveTo(12.92f, 16.82f, 14f, 17.790001f, 14f, 19f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-4.7f);
        v12.curveToRelative(0f, -0.79f, -0.47f, -1.51f, -1.19f, -1.83f);
        v12.lineTo(18f, 12.22f);
        v12.close();
        v12.moveTo(12f, 13.5f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(12.83f, 13.5f, 12f, 13.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ChurchKt._church = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

