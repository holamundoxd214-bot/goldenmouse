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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_commute", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Commute", "Landroidx/compose/material/icons/Icons$Rounded;", "getCommute", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CommuteKt {
    private static ImageVector _commute;

    static {
    }

    public static final ImageVector getCommute(Rounded arg19) {
        ImageVector v0 = CommuteKt._commute;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Commute", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.lineTo(5f, 4f);
        v12.curveTo(3.34f, 4f, 2f, 5.34f, 2f, 7f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.lineToRelative(-0.77f, 0.77f);
        v12.curveToRelative(-0.28f, 0.28f, -0.28f, 0.72f, 0f, 1f);
        v12.reflectiveCurveToRelative(0.72f, 0.28f, 1f, 0f);
        v12.lineTo(7f, 18f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-5f);
        v12.lineTo(4.5f, 13f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-6f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.horizontalLineToRelative(8f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.lineTo(13f, 8f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(15f, 7f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.close();
        v12.moveTo(5f, 14f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.close();
        v12.moveTo(20.57f, 9.66f);
        v12.curveToRelative(-0.14f, -0.4f, -0.52f, -0.66f, -0.97f, -0.66f);
        v12.horizontalLineToRelative(-7.19f);
        v12.curveToRelative(-0.46f, 0f, -0.83f, 0.26f, -0.98f, 0.66f);
        v12.lineToRelative(-1.42f, 4.11f);
        v12.verticalLineToRelative(5.24f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 0.99f, 1f, 0.99f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(0.99f, -0.44f, 1f, -0.99f);
        v12.lineTo(22f, 13.77f);
        v12.lineToRelative(-1.43f, -4.11f);
        v12.close();
        v12.moveTo(12.77f, 10f);
        v12.horizontalLineToRelative(6.48f);
        v12.curveToRelative(0.21f, 0f, 0.4f, 0.14f, 0.47f, 0.34f);
        v12.lineToRelative(0.69f, 2f);
        v12.curveToRelative(0.11f, 0.32f, -0.13f, 0.66f, -0.47f, 0.66f);
        v12.horizontalLineToRelative(-7.85f);
        v12.curveToRelative(-0.34f, 0f, -0.58f, -0.34f, -0.47f, -0.66f);
        v12.lineToRelative(0.69f, -2f);
        v12.curveToRelative(0.05f, -0.2f, 0.24f, -0.34f, 0.46f, -0.34f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.close();
        v12.moveTo(20f, 16f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CommuteKt._commute = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

