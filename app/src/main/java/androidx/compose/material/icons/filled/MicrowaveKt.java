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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_microwave", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Microwave", "Landroidx/compose/material/icons/Icons$Filled;", "getMicrowave", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MicrowaveKt {
    private static ImageVector _microwave;

    static {
    }

    public static final ImageVector getMicrowave(Filled arg19) {
        ImageVector v0 = MicrowaveKt._microwave;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Microwave", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.8f, 10.61f);
        v12.lineTo(5.37f, 9.19f);
        v12.curveTo(5.73f, 8.79f, 6.59f, 8f, 7.75f, 8f);
        v12.curveToRelative(0.8f, 0f, 1.39f, 0.39f, 1.81f, 0.67f);
        v12.curveTo(9.87f, 8.88f, 10.07f, 9f, 10.25f, 9f);
        v12.curveToRelative(0.37f, 0f, 0.8f, -0.41f, 0.95f, -0.61f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveToRelative(-0.36f, 0.4f, -1.22f, 1.19f, -2.37f, 1.19f);
        v12.curveToRelative(-0.79f, 0f, -1.37f, -0.38f, -1.79f, -0.66f);
        v12.curveTo(8.13f, 10.12f, 7.94f, 10f, 7.75f, 10f);
        v12.curveTo(7.38f, 10f, 6.95f, 10.41f, 6.8f, 10.61f);
        v12.close();
        v12.moveTo(7.75f, 15f);
        v12.curveToRelative(0.19f, 0f, 0.38f, 0.12f, 0.71f, 0.34f);
        v12.curveToRelative(0.42f, 0.28f, 1f, 0.66f, 1.79f, 0.66f);
        v12.curveToRelative(1.16f, 0f, 2.01f, -0.79f, 2.37f, -1.19f);
        v12.lineToRelative(-1.42f, -1.42f);
        v12.curveToRelative(-0.15f, 0.2f, -0.59f, 0.61f, -0.95f, 0.61f);
        v12.curveToRelative(-0.18f, 0f, -0.38f, -0.12f, -0.69f, -0.33f);
        v12.curveTo(9.14f, 13.39f, 8.55f, 13f, 7.75f, 13f);
        v12.curveToRelative(-1.16f, 0f, -2.02f, 0.79f, -2.38f, 1.19f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(6.95f, 15.41f, 7.38f, 15f, 7.75f, 15f);
        v12.close();
        v12.moveTo(22f, 6f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineToRelative(16f);
        v12.curveTo(21.1f, 4f, 22f, 4.9f, 22f, 6f);
        v12.close();
        v12.moveTo(14f, 6f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(19f, 16f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.curveTo(18.549999f, 17f, 19f, 16.549999f, 19f, 16f);
        v12.close();
        v12.moveTo(19f, 12f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.curveTo(18.549999f, 13f, 19f, 12.55f, 19f, 12f);
        v12.close();
        v12.moveTo(19f, 7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MicrowaveKt._microwave = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

