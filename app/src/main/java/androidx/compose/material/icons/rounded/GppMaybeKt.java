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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_gppMaybe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "GppMaybe", "Landroidx/compose/material/icons/Icons$Rounded;", "getGppMaybe", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GppMaybeKt {
    private static ImageVector _gppMaybe;

    static {
    }

    public static final ImageVector getGppMaybe(Rounded arg19) {
        ImageVector v0 = GppMaybeKt._gppMaybe;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.GppMaybe", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.3f, 2.26f);
        v12.lineToRelative(-6f, 2.25f);
        v12.curveTo(4.52f, 4.81f, 4f, 5.55f, 4f, 6.39f);
        v12.verticalLineToRelative(4.7f);
        v12.curveToRelative(0f, 5.05f, 3.41f, 9.76f, 8f, 10.91f);
        v12.curveToRelative(4.59f, -1.15f, 8f, -5.86f, 8f, -10.91f);
        v12.verticalLineToRelative(-4.7f);
        v12.curveToRelative(0f, -0.83f, -0.52f, -1.58f, -1.3f, -1.87f);
        v12.lineToRelative(-6f, -2.25f);
        v12.curveTo(12.25f, 2.09f, 11.75f, 2.09f, 11.3f, 2.26f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.lineTo(12f, 16f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(13f, 15.55f, 12.55f, 16f, 12f, 16f);
        v12.close();
        v12.moveTo(12f, 12f);
        v12.lineTo(12f, 12f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(13f, 11.55f, 12.55f, 12f, 12f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GppMaybeKt._gppMaybe = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

