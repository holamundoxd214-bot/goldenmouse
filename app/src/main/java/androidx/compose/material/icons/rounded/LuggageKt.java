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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_luggage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Luggage", "Landroidx/compose/material/icons/Icons$Rounded;", "getLuggage", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LuggageKt {
    private static ImageVector _luggage;

    static {
    }

    public static final ImageVector getLuggage(Rounded arg19) {
        ImageVector v0 = LuggageKt._luggage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Luggage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 6f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveTo(9.45f, 2f, 9f, 2.45f, 9f, 3f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(7f);
        v12.curveTo(5.9f, 6f, 5f, 6.9f, 5f, 8f);
        v12.verticalLineToRelative(11f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(8f);
        v12.curveTo(19f, 6.9f, 18.1f, 6f, 17f, 6f);
        v12.close();
        v12.moveTo(8.75f, 18f);
        v12.lineTo(8.75f, 18f);
        v12.curveTo(8.34f, 18f, 8f, 17.66f, 8f, 17.25f);
        v12.verticalLineToRelative(-7.5f);
        v12.curveTo(8f, 9.34f, 8.34f, 9f, 8.75f, 9f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(9.16f, 9f, 9.5f, 9.34f, 9.5f, 9.75f);
        v12.verticalLineToRelative(7.5f);
        v12.curveTo(9.5f, 17.66f, 9.16f, 18f, 8.75f, 18f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.lineTo(12f, 18f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineToRelative(-7.5f);
        v12.curveTo(11.25f, 9.34f, 11.59f, 9f, 12f, 9f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(7.5f);
        v12.curveTo(12.75f, 17.66f, 12.41f, 18f, 12f, 18f);
        v12.close();
        v12.moveTo(13.5f, 6f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(3.5f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(15.25f, 18f);
        v12.lineTo(15.25f, 18f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineToRelative(-7.5f);
        v12.curveTo(14.5f, 9.34f, 14.84f, 9f, 15.25f, 9f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(15.66f, 9f, 16f, 9.34f, 16f, 9.75f);
        v12.verticalLineToRelative(7.5f);
        v12.curveTo(16f, 17.66f, 15.66f, 18f, 15.25f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LuggageKt._luggage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

