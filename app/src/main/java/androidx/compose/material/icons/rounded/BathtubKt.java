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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bathtub", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Bathtub", "Landroidx/compose/material/icons/Icons$Rounded;", "getBathtub", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BathtubKt {
    private static ImageVector _bathtub;

    static {
    }

    public static final ImageVector getBathtub(Rounded arg20) {
        ImageVector v0 = BathtubKt._bathtub;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Bathtub", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 7f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21f, 13f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(4.83f);
        v12.curveTo(20f, 3.27f, 18.73f, 2f, 17.17f, 2f);
        v12.curveToRelative(-0.75f, 0f, -1.47f, 0.3f, -2f, 0.83f);
        v12.lineToRelative(-1.25f, 1.25f);
        v12.curveTo(13.76f, 4.03f, 13.59f, 4f, 13.41f, 4f);
        v12.curveToRelative(-0.4f, 0f, -0.77f, 0.12f, -1.08f, 0.32f);
        v12.lineToRelative(2.76f, 2.76f);
        v12.curveToRelative(0.2f, -0.31f, 0.32f, -0.68f, 0.32f, -1.08f);
        v12.curveToRelative(0f, -0.18f, -0.03f, -0.34f, -0.07f, -0.51f);
        v12.lineToRelative(1.25f, -1.25f);
        v12.curveTo(16.74f, 4.09f, 16.950001f, 4f, 17.17f, 4f);
        v12.curveTo(17.629999f, 4f, 18f, 4.37f, 18f, 4.83f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(-6.85f);
        v12.curveToRelative(-0.3f, -0.21f, -0.57f, -0.45f, -0.82f, -0.72f);
        v12.lineToRelative(-1.4f, -1.55f);
        v12.curveToRelative(-0.19f, -0.21f, -0.43f, -0.38f, -0.69f, -0.5f);
        v12.curveTo(7.93f, 10.08f, 7.59f, 10f, 7.24f, 10f);
        v12.curveTo(6f, 10.01f, 5f, 11.01f, 5f, 12.25f);
        v12.verticalLineTo(13f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-5f);
        v12.curveTo(22f, 13.45f, 21.549999f, 13f, 21f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BathtubKt._bathtub = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

