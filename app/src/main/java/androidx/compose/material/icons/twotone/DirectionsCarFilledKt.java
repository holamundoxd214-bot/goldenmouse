package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsCarFilled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsCarFilled", "Landroidx/compose/material/icons/Icons$TwoTone;", "getDirectionsCarFilled", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsCarFilledKt {
    private static ImageVector _directionsCarFilled;

    static {
    }

    public static final ImageVector getDirectionsCarFilled(TwoTone arg20) {
        ImageVector v0 = DirectionsCarFilledKt._directionsCarFilled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.DirectionsCarFilled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5f, 17f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(17f);
        v12.close();
        v12.moveTo(16.5f, 13f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(17.33f, 16f, 16.5f, 16f);
        v12.reflectiveCurveTo(15f, 15.33f, 15f, 14.5f);
        v12.reflectiveCurveTo(15.67f, 13f, 16.5f, 13f);
        v12.close();
        v12.moveTo(7.5f, 13f);
        v12.curveTo(8.33f, 13f, 9f, 13.67f, 9f, 14.5f);
        v12.reflectiveCurveTo(8.33f, 16f, 7.5f, 16f);
        v12.reflectiveCurveTo(6f, 15.33f, 6f, 14.5f);
        v12.reflectiveCurveTo(6.67f, 13f, 7.5f, 13f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18.92f, 6.01f);
        v12.curveTo(18.719999f, 5.42f, 18.16f, 5f, 17.5f, 5f);
        v12.horizontalLineToRelative(-11f);
        v12.curveTo(5.84f, 5f, 5.29f, 5.42f, 5.08f, 6.01f);
        v12.lineTo(3f, 12f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-8f);
        v12.lineTo(18.92f, 6.01f);
        v12.close();
        v12.moveTo(6.85f, 7f);
        v12.horizontalLineToRelative(10.29f);
        v12.lineToRelative(1.04f, 3f);
        v12.horizontalLineTo(5.81f);
        v12.lineTo(6.85f, 7f);
        v12.close();
        v12.moveTo(19f, 17f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineTo(17f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(7.5f, 14.5f);
        v12.moveToRelative(-1.5f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, 3f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, -3f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.5f, 14.5f);
        v12.moveToRelative(-1.5f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, 3f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, -3f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsCarFilledKt._directionsCarFilled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

