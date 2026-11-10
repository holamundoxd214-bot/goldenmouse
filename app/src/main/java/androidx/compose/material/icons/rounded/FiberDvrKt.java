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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fiberDvr", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FiberDvr", "Landroidx/compose/material/icons/Icons$Rounded;", "getFiberDvr", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FiberDvrKt {
    private static ImageVector _fiberDvr;

    static {
    }

    public static final ImageVector getFiberDvr(Rounded arg19) {
        ImageVector v0 = FiberDvrKt._fiberDvr;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FiberDvr", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.5f, 10.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v12.moveTo(17.5f, 10.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v12.moveTo(21f, 3f);
        v12.lineTo(3f, 3f);
        v12.curveToRelative(-1.11f, 0f, -2f, 0.89f, -2f, 2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(23f, 5f);
        v12.curveToRelative(0f, -1.11f, -0.89f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(8f, 13.5f);
        v12.curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-5f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.verticalLineToRelative(3f);
        v12.close();
        v12.moveTo(14.1f, 9.92f);
        v12.lineToRelative(-1.27f, 4.36f);
        v12.curveToRelative(-0.12f, 0.43f, -0.52f, 0.72f, -0.96f, 0.72f);
        v12.reflectiveCurveToRelative(-0.84f, -0.29f, -0.96f, -0.72f);
        v12.lineTo(9.64f, 9.92f);
        v12.curveToRelative(-0.14f, -0.46f, 0.21f, -0.92f, 0.69f, -0.92f);
        v12.curveToRelative(0.32f, 0f, 0.6f, 0.21f, 0.69f, 0.52f);
        v12.lineToRelative(0.85f, 2.91f);
        v12.lineToRelative(0.85f, -2.91f);
        v12.curveToRelative(0.09f, -0.31f, 0.37f, -0.52f, 0.69f, -0.52f);
        v12.curveToRelative(0.48f, 0f, 0.83f, 0.46f, 0.69f, 0.92f);
        v12.close();
        v12.moveTo(21f, 11.5f);
        v12.curveToRelative(0f, 0.6f, -0.4f, 1.15f, -0.9f, 1.4f);
        v12.lineToRelative(0.63f, 1.48f);
        v12.curveToRelative(0.19f, 0.45f, -0.14f, 0.96f, -0.63f, 0.96f);
        v12.curveToRelative(-0.28f, 0f, -0.53f, -0.16f, -0.63f, -0.42f);
        v12.lineTo(18.65f, 13f);
        v12.lineTo(17.5f, 13f);
        v12.verticalLineToRelative(1.31f);
        v12.curveToRelative(0f, 0.38f, -0.31f, 0.69f, -0.69f, 0.69f);
        v12.horizontalLineToRelative(-0.12f);
        v12.curveToRelative(-0.38f, 0f, -0.69f, -0.31f, -0.69f, -0.69f);
        v12.lineTo(16f, 9.64f);
        v12.curveToRelative(0f, -0.35f, 0.29f, -0.64f, 0.64f, -0.64f);
        v12.horizontalLineToRelative(2.86f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.verticalLineToRelative(1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FiberDvrKt._fiberDvr = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

