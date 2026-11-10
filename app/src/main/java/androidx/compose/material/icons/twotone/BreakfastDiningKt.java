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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_breakfastDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BreakfastDining", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBreakfastDining", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BreakfastDiningKt {
    private static ImageVector _breakfastDining;

    static {
    }

    public static final ImageVector getBreakfastDining(TwoTone arg19) {
        ImageVector v0 = BreakfastDiningKt._breakfastDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.BreakfastDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 5f);
        v12.horizontalLineTo(6f);
        v12.curveTo(4.9f, 5f, 4f, 5.9f, 4f, 7f);
        v12.curveToRelative(0f, 0.71f, 0.38f, 1.35f, 1.01f, 1.73f);
        v12.lineTo(6f, 9.31f);
        v12.verticalLineTo(19f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineTo(9.3f);
        v12.lineToRelative(1f, -0.58f);
        v12.curveToRelative(0.63f, -0.36f, 1f, -1.01f, 1f, -1.72f);
        v12.curveTo(20f, 5.9f, 19.1f, 5f, 18f, 5f);
        v12.close();
        v12.moveTo(15.71f, 13.7f);
        v12.lineToRelative(-3f, 3f);
        v12.curveTo(12.51f, 16.9f, 12.26f, 17f, 12f, 17f);
        v12.reflectiveCurveToRelative(-0.51f, -0.1f, -0.71f, -0.29f);
        v12.lineToRelative(-3f, -3f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(3f, -3f);
        v12.curveTo(11.49f, 9.1f, 11.74f, 9f, 12f, 9f);
        v12.reflectiveCurveToRelative(0.51f, 0.1f, 0.71f, 0.29f);
        v12.lineToRelative(3f, 3f);
        v12.curveTo(16.1f, 12.68f, 16.1f, 13.31f, 15.71f, 13.7f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18f, 3f);
        v12.horizontalLineTo(6f);
        v12.curveTo(3.79f, 3f, 2f, 4.79f, 2f, 7f);
        v12.curveToRelative(0f, 1.48f, 0.81f, 2.75f, 2f, 3.45f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-8.55f);
        v12.curveToRelative(1.19f, -0.69f, 2f, -1.97f, 2f, -3.45f);
        v12.curveTo(22f, 4.79f, 20.209999f, 3f, 18f, 3f);
        v12.close();
        v12.moveTo(19f, 8.72f);
        v12.lineTo(18f, 9.3f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(9.31f);
        v12.lineTo(5.01f, 8.73f);
        v12.curveTo(4.38f, 8.35f, 4f, 7.71f, 4f, 7f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.curveTo(20f, 7.71f, 19.620001f, 8.36f, 19f, 8.72f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.71f, 9.29f);
        v12.curveTo(12.51f, 9.1f, 12.26f, 9f, 12f, 9f);
        v12.reflectiveCurveToRelative(-0.51f, 0.1f, -0.71f, 0.29f);
        v12.lineToRelative(-3f, 3f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(3f, 3f);
        v12.curveTo(11.49f, 16.9f, 11.74f, 17f, 12f, 17f);
        v12.reflectiveCurveToRelative(0.51f, -0.1f, 0.71f, -0.29f);
        v12.lineToRelative(3f, -3f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(12.71f, 9.29f);
        v12.close();
        v12.moveTo(12f, 14.58f);
        v12.lineTo(10.41f, 13f);
        v12.lineTo(12f, 11.41f);
        v12.lineTo(13.59f, 13f);
        v12.lineTo(12f, 14.58f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BreakfastDiningKt._breakfastDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

