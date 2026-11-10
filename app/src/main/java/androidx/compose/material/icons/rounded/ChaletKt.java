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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_chalet", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Chalet", "Landroidx/compose/material/icons/Icons$Rounded;", "getChalet", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ChaletKt {
    private static ImageVector _chalet;

    static {
    }

    public static final ImageVector getChalet(Rounded arg19) {
        ImageVector v0 = ChaletKt._chalet;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Chalet", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 15f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-3.67f);
        v12.lineToRelative(-0.38f, 0.38f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(6.09f, -6.09f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(6.09f, 6.09f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineTo(15f, 15.33f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(-4f);
        v12.curveTo(11f, 15.45f, 10.55f, 15f, 10f, 15f);
        v12.close();
        v12.moveTo(17.5f, 7.5f);
        v12.verticalLineToRelative(0.89f);
        v12.lineToRelative(-1.08f, 1.08f);
        v12.curveToRelative(-0.18f, 0.18f, -0.21f, 0.48f, -0.05f, 0.69f);
        v12.curveToRelative(0.19f, 0.23f, 0.53f, 0.24f, 0.74f, 0.04f);
        v12.lineToRelative(0.39f, -0.39f);
        v12.verticalLineToRelative(0.69f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.verticalLineTo(9.81f);
        v12.lineToRelative(0.39f, 0.39f);
        v12.curveToRelative(0.21f, 0.21f, 0.55f, 0.19f, 0.74f, -0.04f);
        v12.curveToRelative(0.17f, -0.2f, 0.14f, -0.5f, -0.05f, -0.69f);
        v12.lineTo(18.5f, 8.39f);
        v12.curveToRelative(0f, 0f, 0f, -0.89f, 0f, -0.89f);
        v12.horizontalLineToRelative(0.89f);
        v12.lineToRelative(1.08f, 1.08f);
        v12.curveToRelative(0.18f, 0.18f, 0.48f, 0.21f, 0.69f, 0.05f);
        v12.curveToRelative(0.23f, -0.19f, 0.24f, -0.53f, 0.04f, -0.74f);
        v12.lineTo(20.809999f, 7.5f);
        v12.horizontalLineToRelative(0.69f);
        v12.curveTo(21.780001f, 7.5f, 22f, 7.28f, 22f, 7f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.lineToRelative(-0.69f, 0f);
        v12.lineToRelative(0.39f, -0.39f);
        v12.curveToRelative(0.21f, -0.21f, 0.19f, -0.55f, -0.04f, -0.74f);
        v12.curveToRelative(-0.2f, -0.17f, -0.5f, -0.14f, -0.69f, 0.05f);
        v12.lineTo(19.389999f, 6.5f);
        v12.curveToRelative(0f, 0f, -0.89f, 0f, -0.89f, 0f);
        v12.verticalLineTo(5.61f);
        v12.lineToRelative(1.08f, -1.08f);
        v12.curveToRelative(0.18f, -0.18f, 0.21f, -0.48f, 0.05f, -0.69f);
        v12.curveToRelative(-0.19f, -0.23f, -0.53f, -0.24f, -0.74f, -0.04f);
        v12.lineTo(18.5f, 4.19f);
        v12.verticalLineTo(3.5f);
        v12.curveTo(18.5f, 3.22f, 18.280001f, 3f, 18f, 3f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.verticalLineToRelative(0.69f);
        v12.lineTo(17.110001f, 3.8f);
        v12.curveToRelative(-0.21f, -0.21f, -0.55f, -0.19f, -0.74f, 0.04f);
        v12.curveToRelative(-0.17f, 0.2f, -0.14f, 0.5f, 0.05f, 0.69f);
        v12.lineToRelative(1.08f, 1.08f);
        v12.curveToRelative(0f, 0f, 0f, 0.89f, 0f, 0.89f);
        v12.horizontalLineToRelative(-0.89f);
        v12.lineToRelative(-1.08f, -1.08f);
        v12.curveToRelative(-0.18f, -0.18f, -0.48f, -0.21f, -0.69f, -0.05f);
        v12.curveToRelative(-0.23f, 0.19f, -0.24f, 0.53f, -0.04f, 0.74f);
        v12.lineToRelative(0.39f, 0.39f);
        v12.horizontalLineTo(14.5f);
        v12.curveTo(14.22f, 6.5f, 14f, 6.72f, 14f, 7f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.lineToRelative(0.69f, 0f);
        v12.lineTo(14.8f, 7.89f);
        v12.curveToRelative(-0.21f, 0.21f, -0.19f, 0.55f, 0.04f, 0.74f);
        v12.curveToRelative(0.2f, 0.17f, 0.5f, 0.14f, 0.69f, -0.05f);
        v12.lineToRelative(1.08f, -1.08f);
        v12.curveTo(16.610001f, 7.5f, 17.5f, 7.5f, 17.5f, 7.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ChaletKt._chalet = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

