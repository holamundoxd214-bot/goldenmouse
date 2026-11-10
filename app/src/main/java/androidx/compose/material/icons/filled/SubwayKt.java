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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_subway", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Subway", "Landroidx/compose/material/icons/Icons$Filled;", "getSubway", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SubwayKt {
    private static ImageVector _subway;

    static {
    }

    public static final ImageVector getSubway(Filled arg20) {
        ImageVector v0 = SubwayKt._subway;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Subway", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.5f, 16f);
        v12.moveToRelative(-1f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, 2f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, -2f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8.5f, 16f);
        v12.moveToRelative(-1f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, 2f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, -2f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(7.01f, 9f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(-10f);
        v12.close();
        v12.moveTo(17.799999f, 2.8f);
        v12.curveTo(16f, 2.09f, 13.86f, 2f, 12f, 2f);
        v12.curveToRelative(-1.86f, 0f, -4f, 0.09f, -5.8f, 0.8f);
        v12.curveTo(3.53f, 3.84f, 2f, 6.05f, 2f, 8.86f);
        v12.lineTo(2f, 22f);
        v12.horizontalLineToRelative(20f);
        v12.lineTo(22f, 8.86f);
        v12.curveToRelative(0f, -2.81f, -1.53f, -5.02f, -4.2f, -6.06f);
        v12.close();
        v12.moveTo(18f, 15.88f);
        v12.curveToRelative(0f, 1.45f, -1.18f, 2.62f, -2.63f, 2.62f);
        v12.lineToRelative(1.13f, 1.12f);
        v12.lineTo(16.5f, 20f);
        v12.lineTo(15f, 20f);
        v12.lineToRelative(-1.5f, -1.5f);
        v12.horizontalLineToRelative(-2.83f);
        v12.lineTo(9.17f, 20f);
        v12.lineTo(7.5f, 20f);
        v12.verticalLineToRelative(-0.38f);
        v12.lineToRelative(1.12f, -1.12f);
        v12.curveTo(7.18f, 18.5f, 6f, 17.32f, 6f, 15.88f);
        v12.lineTo(6f, 9f);
        v12.curveToRelative(0f, -2.63f, 3f, -3f, 6f, -3f);
        v12.curveToRelative(3.32f, 0f, 6f, 0.38f, 6f, 3f);
        v12.verticalLineToRelative(6.88f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SubwayKt._subway = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

