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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bungalow", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Bungalow", "Landroidx/compose/material/icons/Icons$Rounded;", "getBungalow", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BungalowKt {
    private static ImageVector _bungalow;

    static {
    }

    public static final ImageVector getBungalow(Rounded arg19) {
        ImageVector v0 = BungalowKt._bungalow;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Bungalow", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-5.21f);
        v12.lineToRelative(0.57f, 0.92f);
        v12.curveToRelative(0.29f, 0.47f, 0.91f, 0.61f, 1.38f, 0.32f);
        v12.curveToRelative(0.47f, -0.29f, 0.61f, -0.91f, 0.32f, -1.38f);
        v12.lineTo(12.85f, 4.36f);
        v12.curveToRelative(-0.39f, -0.63f, -1.31f, -0.63f, -1.7f, 0f);
        v12.lineTo(4.73f, 14.65f);
        v12.curveToRelative(-0.29f, 0.47f, -0.15f, 1.09f, 0.32f, 1.38f);
        v12.curveToRelative(0.47f, 0.29f, 1.08f, 0.15f, 1.38f, -0.32f);
        v12.lineTo(7f, 14.8f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-4f);
        v12.curveTo(11f, 16.450001f, 11.45f, 16f, 12f, 16f);
        v12.close();
        v12.moveTo(13f, 13f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveTo(13f, 12.45f, 13f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BungalowKt._bungalow = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

