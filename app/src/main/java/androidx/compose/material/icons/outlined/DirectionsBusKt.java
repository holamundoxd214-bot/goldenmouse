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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsBus", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsBus", "Landroidx/compose/material/icons/Icons$Outlined;", "getDirectionsBus", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsBusKt {
    private static ImageVector _directionsBus;

    static {
    }

    public static final ImageVector getDirectionsBus(Outlined arg20) {
        ImageVector v0 = DirectionsBusKt._directionsBus;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.DirectionsBus", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(-4.42f, 0f, -8f, 0.5f, -8f, 4f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 0.88f, 0.39f, 1.67f, 1f, 2.22f);
        v12.lineTo(5f, 20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1.78f);
        v12.curveToRelative(0.61f, -0.55f, 1f, -1.34f, 1f, -2.22f);
        v12.lineTo(20f, 6f);
        v12.curveToRelative(0f, -3.5f, -3.58f, -4f, -8f, -4f);
        v12.close();
        v12.moveTo(17.66f, 4.99f);
        v12.lineTo(6.34f, 4.99f);
        v12.curveTo(6.89f, 4.46f, 8.31f, 4f, 12f, 4f);
        v12.reflectiveCurveToRelative(5.11f, 0.46f, 5.66f, 0.99f);
        v12.close();
        v12.moveTo(18f, 6.99f);
        v12.lineTo(18f, 10f);
        v12.lineTo(6f, 10f);
        v12.lineTo(6f, 6.99f);
        v12.horizontalLineToRelative(12f);
        v12.close();
        v12.moveTo(17.66f, 16.73f);
        v12.lineToRelative(-0.29f, 0.27f);
        v12.lineTo(6.63f, 17f);
        v12.lineToRelative(-0.29f, -0.27f);
        v12.curveTo(6.21f, 16.620001f, 6f, 16.370001f, 6f, 16f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.37f, -0.21f, 0.62f, -0.34f, 0.73f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8.5f, 14.5f);
        v12.moveToRelative(-1.5f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, 3f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, -3f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15.5f, 14.5f);
        v12.moveToRelative(-1.5f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, 3f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, -3f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsBusKt._directionsBus = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

