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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nordicWalking", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NordicWalking", "Landroidx/compose/material/icons/Icons$Rounded;", "getNordicWalking", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NordicWalkingKt {
    private static ImageVector _nordicWalking;

    static {
    }

    public static final ImageVector getNordicWalking(Rounded arg19) {
        ImageVector v0 = NordicWalkingKt._nordicWalking;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NordicWalking", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.25f, 23f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineTo(14f);
        v12.horizontalLineTo(19f);
        v12.verticalLineToRelative(8.25f);
        v12.curveTo(19f, 22.66f, 18.66f, 23f, 18.25f, 23f);
        v12.close();
        v12.moveTo(4.93f, 23f);
        v12.curveToRelative(0.35f, 0f, 0.66f, -0.24f, 0.73f, -0.59f);
        v12.lineTo(7.53f, 14f);
        v12.horizontalLineTo(6f);
        v12.lineToRelative(-1.8f, 8.09f);
        v12.curveTo(4.1f, 22.559999f, 4.45f, 23f, 4.93f, 23f);
        v12.close();
        v12.moveTo(13.5f, 5.5f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(12.4f, 5.5f, 13.5f, 5.5f);
        v12.close();
        v12.moveTo(14f, 23f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-5.64f);
        v12.curveToRelative(0f, -0.55f, -0.22f, -1.07f, -0.62f, -1.45f);
        v12.lineTo(12.9f, 13.5f);
        v12.lineToRelative(0.6f, -3f);
        v12.curveToRelative(1.07f, 1.24f, 2.62f, 2.13f, 4.36f, 2.41f);
        v12.curveToRelative(0.6f, 0.1f, 1.14f, -0.38f, 1.14f, -0.99f);
        v12.curveToRelative(0f, -0.49f, -0.35f, -0.91f, -0.83f, -0.98f);
        v12.curveToRelative(-1.53f, -0.24f, -2.79f, -1.14f, -3.47f, -2.33f);
        v12.lineToRelative(-1f, -1.6f);
        v12.curveToRelative(-0.56f, -0.89f, -1.68f, -1.25f, -2.66f, -0.84f);
        v12.lineTo(7.22f, 7.78f);
        v12.curveTo(6.48f, 8.1f, 6f, 8.82f, 6f, 9.62f);
        v12.verticalLineTo(12f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(9.6f);
        v12.lineToRelative(1.8f, -0.7f);
        v12.lineTo(7.25f, 21.76f);
        v12.curveTo(7.12f, 22.4f, 7.61f, 23f, 8.27f, 23f);
        v12.curveToRelative(0.49f, 0f, 0.91f, -0.34f, 1.02f, -0.81f);
        v12.lineTo(10.9f, 15f);
        v12.lineToRelative(2.1f, 2f);
        v12.verticalLineToRelative(5f);
        v12.curveTo(13f, 22.549999f, 13.45f, 23f, 14f, 23f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NordicWalkingKt._nordicWalking = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

