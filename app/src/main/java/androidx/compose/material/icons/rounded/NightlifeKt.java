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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nightlife", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Nightlife", "Landroidx/compose/material/icons/Icons$Rounded;", "getNightlife", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NightlifeKt {
    private static ImageVector _nightlife;

    static {
    }

    public static final ImageVector getNightlife(Rounded arg19) {
        ImageVector v0 = NightlifeKt._nightlife;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Nightlife", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.87f, 5f);
        v12.horizontalLineToRelative(10.26f);
        v12.curveToRelative(0.8f, 0f, 1.28f, 0.89f, 0.83f, 1.55f);
        v12.lineTo(9f, 14f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(-4f);
        v12.lineTo(2.04f, 6.55f);
        v12.curveTo(1.59f, 5.89f, 2.07f, 5f, 2.87f, 5f);
        v12.close();
        v12.moveTo(10.1f, 9f);
        v12.lineToRelative(1.4f, -2f);
        v12.horizontalLineTo(4.49f);
        v12.lineToRelative(1.4f, 2f);
        v12.horizontalLineTo(10.1f);
        v12.close();
        v12.moveTo(19f, 5f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveTo(21.33f, 5f, 22f, 5.67f, 22f, 6.5f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(22f, 7.33f, 21.33f, 8f, 20.5f, 8f);
        v12.horizontalLineTo(19f);
        v12.verticalLineToRelative(9f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0f, 1.84f, -1.64f, 3.28f, -3.54f, 2.95f);
        v12.curveToRelative(-1.21f, -0.21f, -2.2f, -1.2f, -2.41f, -2.41f);
        v12.curveTo(12.72f, 15.64f, 14.16f, 14f, 16f, 14f);
        v12.curveToRelative(0.35f, 0f, 0.69f, 0.06f, 1f, 0.17f);
        v12.verticalLineTo(7f);
        v12.curveTo(17f, 5.9f, 17.9f, 5f, 19f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NightlifeKt._nightlife = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

