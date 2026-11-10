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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nordicWalking", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NordicWalking", "Landroidx/compose/material/icons/Icons$Sharp;", "getNordicWalking", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NordicWalkingKt {
    private static ImageVector _nordicWalking;

    static {
    }

    public static final ImageVector getNordicWalking(Sharp arg19) {
        ImageVector v0 = NordicWalkingKt._nordicWalking;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.NordicWalking", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 23f);
        v12.horizontalLineToRelative(-1.5f);
        v12.verticalLineToRelative(-9f);
        v12.horizontalLineTo(19f);
        v12.verticalLineTo(23f);
        v12.close();
        v12.moveTo(7.53f, 14f);
        v12.horizontalLineTo(6f);
        v12.lineToRelative(-2f, 9f);
        v12.horizontalLineToRelative(1.53f);
        v12.lineTo(7.53f, 14f);
        v12.close();
        v12.moveTo(13.5f, 5.5f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(12.4f, 5.5f, 13.5f, 5.5f);
        v12.close();
        v12.moveTo(9.8f, 8.9f);
        v12.lineTo(7f, 23f);
        v12.horizontalLineToRelative(2.1f);
        v12.lineToRelative(1.8f, -8f);
        v12.lineToRelative(2.1f, 2f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-7.5f);
        v12.lineToRelative(-2.1f, -2f);
        v12.lineToRelative(0.6f, -3f);
        v12.curveTo(14.8f, 12f, 16.799999f, 13f, 19f, 13f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-1.9f, 0f, -3.5f, -1f, -4.3f, -2.4f);
        v12.lineToRelative(-1f, -1.6f);
        v12.curveToRelative(-0.56f, -0.89f, -1.68f, -1.25f, -2.65f, -0.84f);
        v12.lineTo(6f, 8.3f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(9.6f);
        v12.lineTo(9.8f, 8.9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NordicWalkingKt._nordicWalking = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

