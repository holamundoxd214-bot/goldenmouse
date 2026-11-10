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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_crib", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Crib", "Landroidx/compose/material/icons/Icons$Rounded;", "getCrib", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CribKt {
    private static ImageVector _crib;

    static {
    }

    public static final ImageVector getCrib(Rounded arg19) {
        ImageVector v0 = CribKt._crib;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Crib", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.32f, 18.32f);
        v12.curveToRelative(-0.36f, -0.36f, -0.92f, -0.4f, -1.31f, -0.08f);
        v12.curveToRelative(-0.32f, 0.25f, -0.65f, 0.48f, -1f, 0.69f);
        v12.verticalLineTo(16f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(8f);
        v12.curveTo(5.79f, 4f, 4f, 5.79f, 4f, 8f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2.93f);
        v12.curveToRelative(-0.35f, -0.2f, -0.69f, -0.43f, -1f, -0.69f);
        v12.curveToRelative(-0.39f, -0.32f, -0.96f, -0.27f, -1.31f, 0.08f);
        v12.curveToRelative(-0.42f, 0.42f, -0.39f, 1.12f, 0.08f, 1.5f);
        v12.curveTo(7.47f, 21.18f, 9.64f, 22f, 12f, 22f);
        v12.curveToRelative(2.36f, 0f, 4.53f, -0.82f, 6.24f, -2.18f);
        v12.curveTo(18.709999f, 19.440001f, 18.74f, 18.74f, 18.32f, 18.32f);
        v12.close();
        v12.moveTo(14f, 19.75f);
        v12.curveTo(13.36f, 19.91f, 12.69f, 20f, 12f, 20f);
        v12.curveToRelative(-0.69f, 0f, -1.36f, -0.09f, -2f, -0.25f);
        v12.verticalLineTo(16f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineTo(19.75f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CribKt._crib = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

