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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_generatingTokens", "Landroidx/compose/ui/graphics/vector/ImageVector;", "GeneratingTokens", "Landroidx/compose/material/icons/Icons$Rounded;", "getGeneratingTokens", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GeneratingTokensKt {
    private static ImageVector _generatingTokens;

    static {
    }

    public static final ImageVector getGeneratingTokens(Rounded arg19) {
        ImageVector v0 = GeneratingTokensKt._generatingTokens;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.GeneratingTokens", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 4f);
        v12.curveToRelative(-4.42f, 0f, -8f, 3.58f, -8f, 8f);
        v12.curveToRelative(0f, 4.42f, 3.58f, 8f, 8f, 8f);
        v12.reflectiveCurveToRelative(8f, -3.58f, 8f, -8f);
        v12.curveTo(17f, 7.58f, 13.42f, 4f, 9f, 4f);
        v12.close();
        v12.moveTo(9f, 15.5f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineTo(6.75f);
        v12.curveTo(6.34f, 10.5f, 6f, 10.16f, 6f, 9.75f);
        v12.reflectiveCurveTo(6.34f, 9f, 6.75f, 9f);
        v12.horizontalLineToRelative(4.5f);
        v12.curveTo(11.66f, 9f, 12f, 9.34f, 12f, 9.75f);
        v12.reflectiveCurveToRelative(-0.34f, 0.75f, -0.75f, 0.75f);
        v12.horizontalLineTo(10f);
        v12.verticalLineToRelative(4f);
        v12.curveTo(10f, 15.05f, 9.55f, 15.5f, 9f, 15.5f);
        v12.close();
        v12.moveTo(20.25f, 3.75f);
        v12.lineTo(22f, 4.54f);
        v12.curveToRelative(0.39f, 0.18f, 0.39f, 0.73f, 0f, 0.91f);
        v12.lineToRelative(-1.75f, 0.79f);
        v12.lineTo(19.459999f, 8f);
        v12.curveToRelative(-0.18f, 0.39f, -0.73f, 0.39f, -0.91f, 0f);
        v12.lineToRelative(-0.79f, -1.75f);
        v12.lineTo(16f, 5.46f);
        v12.curveToRelative(-0.39f, -0.18f, -0.39f, -0.73f, 0f, -0.91f);
        v12.lineToRelative(1.75f, -0.79f);
        v12.lineTo(18.540001f, 2f);
        v12.curveToRelative(0.18f, -0.39f, 0.73f, -0.39f, 0.91f, 0f);
        v12.lineTo(20.25f, 3.75f);
        v12.close();
        v12.moveTo(20.25f, 17.75f);
        v12.lineTo(22f, 18.540001f);
        v12.curveToRelative(0.39f, 0.18f, 0.39f, 0.73f, 0f, 0.91f);
        v12.lineToRelative(-1.75f, 0.79f);
        v12.lineTo(19.459999f, 22f);
        v12.curveToRelative(-0.18f, 0.39f, -0.73f, 0.39f, -0.91f, 0f);
        v12.lineToRelative(-0.79f, -1.75f);
        v12.lineTo(16f, 19.459999f);
        v12.curveToRelative(-0.39f, -0.18f, -0.39f, -0.73f, 0f, -0.91f);
        v12.lineToRelative(1.75f, -0.79f);
        v12.lineTo(18.540001f, 16f);
        v12.curveToRelative(0.18f, -0.39f, 0.73f, -0.39f, 0.91f, 0f);
        v12.lineTo(20.25f, 17.75f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GeneratingTokensKt._generatingTokens = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

