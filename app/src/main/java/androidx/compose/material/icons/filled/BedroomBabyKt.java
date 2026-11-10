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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bedroomBaby", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BedroomBaby", "Landroidx/compose/material/icons/Icons$Filled;", "getBedroomBaby", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BedroomBabyKt {
    private static ImageVector _bedroomBaby;

    static {
    }

    public static final ImageVector getBedroomBaby(Filled arg19) {
        ImageVector v0 = BedroomBabyKt._bedroomBaby;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.BedroomBaby", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 2f, 2f, 2.9f, 2f, 4f);
        v12.verticalLineToRelative(16f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(22f, 2.9f, 21.1f, 2f, 20f, 2f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(-2.64f, 0f, -5.13f, -1.03f, -7f, -2.9f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.curveToRelative(0.34f, 0.34f, 0.71f, 0.65f, 1.1f, 0.92f);
        v12.lineTo(8f, 13.5f);
        v12.verticalLineTo(9.51f);
        v12.lineTo(6.45f, 10.5f);
        v12.lineToRelative(-0.95f, -1f);
        v12.lineTo(7f, 7.76f);
        v12.lineTo(6f, 7f);
        v12.horizontalLineToRelative(3.65f);
        v12.lineToRelative(1.73f, 3f);
        v12.horizontalLineTo(17f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(2.5f);
        v12.lineToRelative(0.84f, 1.46f);
        v12.curveToRelative(0.39f, -0.28f, 0.76f, -0.58f, 1.1f, -0.92f);
        v12.lineTo(19f, 15.1f);
        v12.curveTo(17.129999f, 16.969999f, 14.64f, 18f, 12f, 18f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(14.69f, 14.24f);
        v12.curveToRelative(-1.74f, 0.65f, -3.66f, 0.65f, -5.4f, 0f);
        v12.lineToRelative(-0.81f, 1.41f);
        v12.lineToRelative(-0.03f, 0.06f);
        v12.curveToRelative(1.1f, 0.52f, 2.28f, 0.79f, 3.53f, 0.79f);
        v12.reflectiveCurveToRelative(2.45f, -0.28f, 3.55f, -0.79f);
        v12.lineToRelative(-0.03f, -0.06f);
        v12.lineTo(14.69f, 14.24f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BedroomBabyKt._bedroomBaby = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

