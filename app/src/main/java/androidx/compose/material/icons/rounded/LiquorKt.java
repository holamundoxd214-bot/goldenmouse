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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_liquor", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Liquor", "Landroidx/compose/material/icons/Icons$Rounded;", "getLiquor", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LiquorKt {
    private static ImageVector _liquor;

    static {
    }

    public static final ImageVector getLiquor(Rounded arg19) {
        ImageVector v0 = LiquorKt._liquor;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Liquor", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 14f);
        v12.curveToRelative(0f, 1.3f, 0.84f, 2.4f, 2f, 2.82f);
        v12.verticalLineTo(20f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(-3.18f);
        v12.curveTo(8.16f, 16.4f, 9f, 15.3f, 9f, 14f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(4f);
        v12.curveTo(3.45f, 6f, 3f, 6.45f, 3f, 7f);
        v12.verticalLineTo(14f);
        v12.close();
        v12.moveTo(5f, 8f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20.639999f, 8.54f);
        v12.lineToRelative(-0.96f, -0.32f);
        v12.curveTo(19.27f, 8.08f, 19f, 7.7f, 19f, 7.27f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4.28f);
        v12.curveToRelative(0f, 0.43f, -0.27f, 0.81f, -0.68f, 0.95f);
        v12.lineToRelative(-0.96f, 0.32f);
        v12.curveTo(11.55f, 8.83f, 11f, 9.59f, 11f, 10.45f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(7f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-9.56f);
        v12.curveTo(22f, 9.58f, 21.450001f, 8.82f, 20.639999f, 8.54f);
        v12.close();
        v12.moveTo(16f, 4f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(4f);
        v12.close();
        v12.moveTo(13f, 10.44f);
        v12.lineToRelative(0.95f, -0.32f);
        v12.curveTo(15.18f, 9.72f, 16f, 8.57f, 16f, 7.28f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(0.28f);
        v12.curveToRelative(0f, 1.29f, 0.82f, 2.44f, 2.05f, 2.85f);
        v12.lineTo(20f, 10.44f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(-7f);
        v12.verticalLineTo(10.44f);
        v12.close();
        v12.moveTo(20f, 20f);
        v12.horizontalLineToRelative(-7f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineTo(20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LiquorKt._liquor = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

