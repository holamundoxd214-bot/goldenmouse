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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noFlash", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoFlash", "Landroidx/compose/material/icons/Icons$Rounded;", "getNoFlash", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoFlashKt {
    private static ImageVector _noFlash;

    static {
    }

    public static final ImageVector getNoFlash(Rounded arg19) {
        ImageVector v0 = NoFlashKt._noFlash;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NoFlash", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3.16f, 3.16f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(4.6f, 4.6f);
        v12.lineTo(6.14f, 9.4f);
        v12.horizontalLineTo(3.6f);
        v12.curveTo(2.72f, 9.4f, 2f, 10.12f, 2f, 11f);
        v12.verticalLineToRelative(9.4f);
        v12.curveTo(2f, 21.280001f, 2.72f, 22f, 3.6f, 22f);
        v12.horizontalLineToRelative(12.8f);
        v12.curveToRelative(0.75f, 0f, 1.38f, -0.52f, 1.55f, -1.22f);
        v12.lineToRelative(1.47f, 1.47f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(3.16f, 3.16f);
        v12.close();
        v12.moveTo(10f, 20f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.curveToRelative(0f, -1.95f, 1.4f, -3.57f, 3.25f, -3.92f);
        v12.lineToRelative(1.57f, 1.57f);
        v12.curveToRelative(-0.26f, -0.09f, -0.53f, -0.15f, -0.82f, -0.15f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, 1.12f, -2.5f, 2.5f);
        v12.curveToRelative(0f, 1.38f, 1.12f, 2.5f, 2.5f, 2.5f);
        v12.curveToRelative(1.38f, 0f, 2.5f, -1.12f, 2.5f, -2.5f);
        v12.curveToRelative(0f, -0.29f, -0.06f, -0.56f, -0.15f, -0.82f);
        v12.lineToRelative(1.57f, 1.57f);
        v12.curveTo(13.57f, 18.6f, 11.95f, 20f, 10f, 20f);
        v12.close();
        v12.moveTo(18f, 15.17f);
        v12.lineTo(10.83f, 8f);
        v12.horizontalLineToRelative(0.87f);
        v12.curveToRelative(0.56f, 0f, 1.1f, 0.24f, 1.48f, 0.65f);
        v12.lineToRelative(0.69f, 0.75f);
        v12.horizontalLineToRelative(2.54f);
        v12.curveToRelative(0.88f, 0f, 1.6f, 0.72f, 1.6f, 1.6f);
        v12.verticalLineTo(15.17f);
        v12.close();
        v12.moveTo(20.4f, 5.6f);
        v12.horizontalLineToRelative(0.75f);
        v12.curveToRelative(0.38f, 0f, 0.62f, 0.41f, 0.44f, 0.74f);
        v12.lineTo(19f, 11f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-0.5f);
        v12.curveTo(18.219999f, 7f, 18f, 6.78f, 18f, 6.5f);
        v12.verticalLineToRelative(-4f);
        v12.curveTo(18f, 2.22f, 18.219999f, 2f, 18.5f, 2f);
        v12.horizontalLineToRelative(2.73f);
        v12.curveToRelative(0.36f, 0f, 0.6f, 0.37f, 0.46f, 0.7f);
        v12.lineTo(20.4f, 5.6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoFlashKt._noFlash = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

