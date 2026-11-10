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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fiberPin", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FiberPin", "Landroidx/compose/material/icons/Icons$Rounded;", "getFiberPin", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FiberPinKt {
    private static ImageVector _fiberPin;

    static {
    }

    public static final ImageVector getFiberPin(Rounded arg19) {
        ImageVector v0 = FiberPinKt._fiberPin;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FiberPin", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 4f);
        v12.lineTo(4f, 4f);
        v12.curveToRelative(-1.11f, 0f, -1.99f, 0.89f, -1.99f, 2f);
        v12.lineTo(2f, 18f);
        v12.curveToRelative(0f, 1.11f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.89f, 2f, -2f);
        v12.lineTo(22f, 6f);
        v12.curveToRelative(0f, -1.11f, -0.89f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(9f, 11.5f);
        v12.curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1.25f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.reflectiveCurveTo(4f, 14.66f, 4f, 14.25f);
        v12.lineTo(4f, 10f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(2.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.verticalLineToRelative(1f);
        v12.close();
        v12.moveTo(12.5f, 14.25f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineToRelative(-4.5f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.reflectiveCurveToRelative(0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(4.5f);
        v12.close();
        v12.moveTo(20f, 14.21f);
        v12.curveToRelative(0f, 0.44f, -0.35f, 0.79f, -0.79f, 0.79f);
        v12.curveToRelative(-0.25f, 0f, -0.49f, -0.12f, -0.64f, -0.33f);
        v12.lineToRelative(-2.31f, -3.17f);
        v12.verticalLineToRelative(2.88f);
        v12.curveToRelative(0f, 0.34f, -0.28f, 0.62f, -0.62f, 0.62f);
        v12.horizontalLineToRelative(-0.01f);
        v12.curveToRelative(-0.35f, 0f, -0.63f, -0.28f, -0.63f, -0.62f);
        v12.lineTo(15f, 9.83f);
        v12.curveToRelative(0f, -0.46f, 0.37f, -0.83f, 0.83f, -0.83f);
        v12.curveToRelative(0.27f, 0f, 0.52f, 0.13f, 0.67f, 0.35f);
        v12.lineToRelative(2.25f, 3.15f);
        v12.lineTo(18.75f, 9.62f);
        v12.curveToRelative(0f, -0.34f, 0.28f, -0.62f, 0.62f, -0.62f);
        v12.horizontalLineToRelative(0.01f);
        v12.curveToRelative(0.34f, 0f, 0.62f, 0.28f, 0.62f, 0.62f);
        v12.verticalLineToRelative(4.59f);
        v12.close();
        v12.moveTo(5.5f, 10.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FiberPinKt._fiberPin = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

