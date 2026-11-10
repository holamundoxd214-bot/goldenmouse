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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noPhotography", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoPhotography", "Landroidx/compose/material/icons/Icons$Outlined;", "getNoPhotography", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoPhotographyKt {
    private static ImageVector _noPhotography;

    static {
    }

    public static final ImageVector getNoPhotography(Outlined arg19) {
        ImageVector v0 = NoPhotographyKt._noPhotography;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.NoPhotography", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.9f, 6.07f);
        v12.lineTo(7.48f, 4.66f);
        v12.lineTo(9f, 3f);
        v12.horizontalLineToRelative(6f);
        v12.lineToRelative(1.83f, 2f);
        v12.horizontalLineTo(20f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 0.05f, -0.01f, 0.1f, -0.02f, 0.16f);
        v12.lineTo(20f, 17.17f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-4.05f);
        v12.lineToRelative(-1.83f, -2f);
        v12.horizontalLineTo(9.88f);
        v12.lineTo(8.9f, 6.07f);
        v12.close();
        v12.moveTo(20.49f, 23.309999f);
        v12.lineTo(18.17f, 21f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -0.59f, 0.27f, -1.12f, 0.68f, -1.49f);
        v12.lineToRelative(-2f, -2f);
        v12.lineTo(2.1f, 2.1f);
        v12.lineToRelative(19.799999f, 19.799999f);
        v12.lineTo(20.49f, 23.309999f);
        v12.close();
        v12.moveTo(9.19f, 12.02f);
        v12.curveTo(9.08f, 12.33f, 9f, 12.65f, 9f, 13f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.curveToRelative(0.35f, 0f, 0.67f, -0.08f, 0.98f, -0.19f);
        v12.lineTo(9.19f, 12.02f);
        v12.close();
        v12.moveTo(16.17f, 19f);
        v12.lineToRelative(-1.68f, -1.68f);
        v12.curveTo(13.76f, 17.75f, 12.91f, 18f, 12f, 18f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.curveToRelative(0f, -0.91f, 0.25f, -1.76f, 0.68f, -2.49f);
        v12.lineTo(4.17f, 7f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineTo(16.17f);
        v12.close();
        v12.moveTo(14.81f, 11.98f);
        v12.lineToRelative(2.07f, 2.07f);
        v12.curveTo(16.959999f, 13.71f, 17f, 13.36f, 17f, 13f);
        v12.curveToRelative(0f, -2.76f, -2.24f, -5f, -5f, -5f);
        v12.curveToRelative(-0.36f, 0f, -0.71f, 0.04f, -1.06f, 0.12f);
        v12.lineToRelative(2.07f, 2.07f);
        v12.curveTo(13.85f, 10.49f, 14.51f, 11.15f, 14.81f, 11.98f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoPhotographyKt._noPhotography = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

