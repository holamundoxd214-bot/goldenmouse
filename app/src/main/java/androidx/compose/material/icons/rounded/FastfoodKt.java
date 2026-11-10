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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fastfood", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Fastfood", "Landroidx/compose/material/icons/Icons$Rounded;", "getFastfood", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FastfoodKt {
    private static ImageVector _fastfood;

    static {
    }

    public static final ImageVector getFastfood(Rounded arg19) {
        ImageVector v0 = FastfoodKt._fastfood;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Fastfood", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.9f, 5f);
        v12.horizontalLineTo(18f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-3.9f);
        v12.curveToRelative(-0.59f, 0f, -1.05f, 0.51f, -1f, 1.1f);
        v12.lineToRelative(0.12f, 1.21f);
        v12.curveTo(14.9f, 8.16f, 18f, 10.77f, 18f, 15f);
        v12.lineToRelative(0.02f, 8f);
        v12.horizontalLineToRelative(1.7f);
        v12.curveToRelative(0.84f, 0f, 1.53f, -0.65f, 1.63f, -1.47f);
        v12.lineTo(22.889999f, 6.1f);
        v12.curveToRelative(0.06f, -0.59f, -0.4f, -1.1f, -0.99f, -1.1f);
        v12.close();
        v12.moveTo(15f, 21f);
        v12.horizontalLineTo(2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(13f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(2.1f, 15f);
        v12.horizontalLineToRelative(12.8f);
        v12.curveToRelative(0.62f, 0f, 1.11f, -0.56f, 0.99f, -1.16f);
        v12.curveToRelative(-0.65f, -3.23f, -4.02f, -4.85f, -7.39f, -4.85f);
        v12.reflectiveCurveToRelative(-6.73f, 1.62f, -7.39f, 4.85f);
        v12.curveToRelative(-0.12f, 0.6f, 0.38f, 1.16f, 0.99f, 1.16f);
        v12.close();
        v12.moveTo(15f, 17f);
        v12.horizontalLineTo(2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(13f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FastfoodKt._fastfood = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

