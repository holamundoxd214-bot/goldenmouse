package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_microwave", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Microwave", "Landroidx/compose/material/icons/Icons$Outlined;", "getMicrowave", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MicrowaveKt {
    private static ImageVector _microwave;

    static {
    }

    public static final ImageVector getMicrowave(Outlined arg19) {
        ImageVector v0 = MicrowaveKt._microwave;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Microwave", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 4f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 4f, 2f, 4.9f, 2f, 6f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveTo(22f, 4.9f, 21.1f, 4f, 20f, 4f);
        v12.close();
        v12.moveTo(4f, 6f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(20f, 18f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineTo(18f);
        v12.close();
        v12.moveTo(19f, 9f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(18f, 13f);
        v12.lineTo(18f, 13f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(19f, 12.55f, 18.549999f, 13f, 18f, 13f);
        v12.close();
        v12.moveTo(18f, 17f);
        v12.lineTo(18f, 17f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(19f, 16.549999f, 18.549999f, 17f, 18f, 17f);
        v12.close();
        v12.moveTo(10.25f, 16f);
        v12.curveToRelative(-0.79f, 0f, -1.37f, -0.38f, -1.79f, -0.66f);
        v12.curveTo(8.13f, 15.12f, 7.94f, 15f, 7.75f, 15f);
        v12.curveToRelative(-0.37f, 0f, -0.8f, 0.41f, -0.95f, 0.61f);
        v12.lineToRelative(-1.42f, -1.42f);
        v12.curveTo(5.73f, 13.79f, 6.59f, 13f, 7.75f, 13f);
        v12.curveToRelative(0.8f, 0f, 1.39f, 0.39f, 1.81f, 0.67f);
        v12.curveTo(9.87f, 13.88f, 10.07f, 14f, 10.25f, 14f);
        v12.curveToRelative(0.37f, 0f, 0.8f, -0.41f, 0.95f, -0.61f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(12.26f, 15.21f, 11.41f, 16f, 10.25f, 16f);
        v12.close();
        v12.moveTo(10.25f, 11f);
        v12.curveToRelative(-0.79f, 0f, -1.37f, -0.38f, -1.79f, -0.66f);
        v12.curveTo(8.13f, 10.12f, 7.94f, 10f, 7.75f, 10f);
        v12.curveToRelative(-0.37f, 0f, -0.8f, 0.41f, -0.95f, 0.61f);
        v12.lineTo(5.37f, 9.19f);
        v12.curveTo(5.73f, 8.79f, 6.59f, 8f, 7.75f, 8f);
        v12.curveToRelative(0.8f, 0f, 1.39f, 0.39f, 1.81f, 0.67f);
        v12.curveTo(9.87f, 8.88f, 10.07f, 9f, 10.25f, 9f);
        v12.curveToRelative(0.37f, 0f, 0.8f, -0.41f, 0.95f, -0.61f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(12.26f, 10.21f, 11.41f, 11f, 10.25f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MicrowaveKt._microwave = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

