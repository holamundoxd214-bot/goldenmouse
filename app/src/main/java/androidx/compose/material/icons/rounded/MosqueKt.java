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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mosque", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Mosque", "Landroidx/compose/material/icons/Icons$Rounded;", "getMosque", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MosqueKt {
    private static ImageVector _mosque;

    static {
    }

    public static final ImageVector getMosque(Rounded arg19) {
        ImageVector v0 = MosqueKt._mosque;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Mosque", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 8f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(0.29f, 0f, 0.57f, 0.06f, 0.84f, 0.13f);
        v12.curveTo(17.93f, 7.8f, 18f, 7.46f, 18f, 7.09f);
        v12.curveToRelative(0f, -1.31f, -0.65f, -2.53f, -1.74f, -3.25f);
        v12.lineTo(12f, 1f);
        v12.lineTo(7.74f, 3.84f);
        v12.curveTo(6.65f, 4.56f, 6f, 5.78f, 6f, 7.09f);
        v12.curveTo(6f, 7.46f, 6.07f, 7.8f, 6.16f, 8.13f);
        v12.curveTo(6.43f, 8.06f, 6.71f, 8f, 7f, 8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(24f, 7f);
        v12.curveToRelative(0f, -1.1f, -2f, -3f, -2f, -3f);
        v12.reflectiveCurveToRelative(-2f, 1.9f, -2f, 3f);
        v12.curveToRelative(0f, 0.74f, 0.4f, 1.38f, 1f, 1.72f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(3f);
        v12.verticalLineTo(8.72f);
        v12.curveTo(3.6f, 8.38f, 4f, 7.74f, 4f, 7f);
        v12.curveToRelative(0f, -1.1f, -2f, -3f, -2f, -3f);
        v12.reflectiveCurveTo(0f, 5.9f, 0f, 7f);
        v12.curveToRelative(0f, 0.74f, 0.4f, 1.38f, 1f, 1.72f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(9f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(9f);
        v12.verticalLineTo(8.72f);
        v12.curveTo(23.6f, 8.38f, 24f, 7.74f, 24f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MosqueKt._mosque = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

