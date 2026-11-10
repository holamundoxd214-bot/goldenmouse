package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noFlash", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoFlash", "Landroidx/compose/material/icons/Icons$Sharp;", "getNoFlash", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoFlashKt {
    private static ImageVector _noFlash;

    static {
    }

    public static final ImageVector getNoFlash(Sharp arg19) {
        ImageVector v0 = NoFlashKt._noFlash;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.NoFlash", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.45f, 2.45f);
        v12.lineTo(1.04f, 3.87f);
        v12.lineToRelative(5.3f, 5.3f);
        v12.lineTo(6.14f, 9.4f);
        v12.horizontalLineTo(2f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-1.17f);
        v12.lineToRelative(2.13f, 2.13f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.45f, 2.45f);
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
        v12.horizontalLineToRelative(1.75f);
        v12.lineToRelative(1.28f, 1.4f);
        v12.horizontalLineTo(18f);
        v12.verticalLineTo(15.17f);
        v12.close();
        v12.moveTo(20.4f, 5.6f);
        v12.horizontalLineTo(22f);
        v12.lineTo(19f, 11f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(2f);
        v12.horizontalLineToRelative(4f);
        v12.lineTo(20.4f, 5.6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoFlashKt._noFlash = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

