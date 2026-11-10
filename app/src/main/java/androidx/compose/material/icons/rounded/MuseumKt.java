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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_museum", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Museum", "Landroidx/compose/material/icons/Icons$Rounded;", "getMuseum", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MuseumKt {
    private static ImageVector _museum;

    static {
    }

    public static final ImageVector getMuseum(Rounded arg19) {
        ImageVector v0 = MuseumKt._museum;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Museum", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.5f, 11f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.verticalLineTo(9.26f);
        v12.curveToRelative(0f, -0.16f, -0.08f, -0.32f, -0.21f, -0.41f);
        v12.lineTo(12.57f, 2.4f);
        v12.curveToRelative(-0.34f, -0.24f, -0.8f, -0.24f, -1.15f, 0f);
        v12.lineTo(2.21f, 8.85f);
        v12.curveTo(2.08f, 8.94f, 2f, 9.1f, 2f, 9.26f);
        v12.verticalLineToRelative(1.24f);
        v12.curveTo(2f, 10.78f, 2.22f, 11f, 2.5f, 11f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(9f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-9f);
        v12.horizontalLineTo(21.5f);
        v12.close();
        v12.moveTo(16f, 17f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.lineToRelative(-1.17f, 1.75f);
        v12.curveToRelative(-0.4f, 0.59f, -1.27f, 0.59f, -1.66f, 0f);
        v12.lineTo(10f, 14f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4.7f);
        v12.curveTo(8f, 11.58f, 8.58f, 11f, 9.3f, 11f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.43f, 0f, 0.84f, 0.22f, 1.08f, 0.58f);
        v12.lineTo(12f, 14f);
        v12.lineToRelative(1.61f, -2.42f);
        v12.curveTo(13.86f, 11.22f, 14.26f, 11f, 14.7f, 11f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.72f, 0f, 1.3f, 0.58f, 1.3f, 1.3f);
        v12.verticalLineTo(17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MuseumKt._museum = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

