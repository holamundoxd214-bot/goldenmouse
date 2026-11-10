package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_elderlyWoman", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ElderlyWoman", "Landroidx/compose/material/icons/Icons$Filled;", "getElderlyWoman", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ElderlyWomanKt {
    private static ImageVector _elderlyWoman;

    static {
    }

    public static final ImageVector getElderlyWoman(Filled arg19) {
        ImageVector v0 = ElderlyWomanKt._elderlyWoman;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ElderlyWoman", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 11f);
        v12.curveToRelative(-1.56f, 0f, -2.92f, -0.9f, -3.58f, -2.21f);
        v12.lineToRelative(-0.79f, -1.67f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(14.12f, 7.1f, 13.63f, 6f, 12.34f, 6f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(8.72f, 6f, 6f, 16.690001f, 6f, 19f);
        v12.horizontalLineToRelative(2.5f);
        v12.lineToRelative(-2.1f, 2.8f);
        v12.lineTo(8f, 23f);
        v12.lineToRelative(3f, -4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-4.03f);
        v12.lineTo(13f, 13f);
        v12.lineToRelative(0.49f, -2.71f);
        v12.curveToRelative(0.81f, 1.23f, 2.05f, 2.14f, 3.51f, 2.52f);
        v12.verticalLineToRelative(0.69f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineTo(23f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(12.5f);
        v12.curveTo(20f, 11.67f, 19.33f, 11f, 18.5f, 11f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(11.6f, 2.91f);
        v12.curveToRelative(-0.06f, 0.19f, -0.1f, 0.38f, -0.1f, 0.59f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.curveToRelative(-0.21f, 0f, -0.4f, 0.04f, -0.59f, 0.1f);
        v12.curveTo(12.76f, 1.25f, 12.41f, 1f, 12f, 1f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveTo(11f, 2.41f, 11.25f, 2.76f, 11.6f, 2.91f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ElderlyWomanKt._elderlyWoman = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

