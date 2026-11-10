package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tonality", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Tonality", "Landroidx/compose/material/icons/Icons$Filled;", "getTonality", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TonalityKt {
    private static ImageVector _tonality;

    static {
    }

    public static final ImageVector getTonality(Filled arg19) {
        ImageVector v0 = TonalityKt._tonality;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Tonality", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(11f, 19.93f);
        v12.curveToRelative(-3.94f, -0.49f, -7f, -3.85f, -7f, -7.93f);
        v12.reflectiveCurveToRelative(3.05f, -7.44f, 7f, -7.93f);
        v12.verticalLineToRelative(15.86f);
        v12.close();
        v12.moveTo(13f, 4.07f);
        v12.curveToRelative(1.03f, 0.13f, 2f, 0.45f, 2.87f, 0.93f);
        v12.lineTo(13f, 5f);
        v12.verticalLineToRelative(-0.93f);
        v12.close();
        v12.moveTo(13f, 7f);
        v12.horizontalLineToRelative(5.24f);
        v12.curveToRelative(0.25f, 0.31f, 0.48f, 0.65f, 0.68f, 1f);
        v12.lineTo(13f, 8f);
        v12.lineTo(13f, 7f);
        v12.close();
        v12.moveTo(13f, 10f);
        v12.horizontalLineToRelative(6.74f);
        v12.curveToRelative(0.08f, 0.33f, 0.15f, 0.66f, 0.19f, 1f);
        v12.lineTo(13f, 11f);
        v12.verticalLineToRelative(-1f);
        v12.close();
        v12.moveTo(13f, 19.93f);
        v12.lineTo(13f, 19f);
        v12.horizontalLineToRelative(2.87f);
        v12.curveToRelative(-0.87f, 0.48f, -1.84f, 0.8f, -2.87f, 0.93f);
        v12.close();
        v12.moveTo(18.24f, 17f);
        v12.lineTo(13f, 17f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(5.92f);
        v12.curveToRelative(-0.2f, 0.35f, -0.43f, 0.69f, -0.68f, 1f);
        v12.close();
        v12.moveTo(19.74f, 14f);
        v12.lineTo(13f, 14f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(6.93f);
        v12.curveToRelative(-0.04f, 0.34f, -0.11f, 0.67f, -0.19f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TonalityKt._tonality = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

