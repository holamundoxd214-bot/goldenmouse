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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fireplace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Fireplace", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFireplace", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FireplaceKt {
    private static ImageVector _fireplace;

    static {
    }

    public static final ImageVector getFireplace(TwoTone arg19) {
        ImageVector v0 = FireplaceKt._fireplace;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Fireplace", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 20f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2.23f);
        v12.curveToRelative(-0.75f, -0.93f, -1.2f, -2.04f, -1.23f, -3f);
        v12.curveToRelative(-0.02f, -0.53f, -0.73f, -4.43f, 6f, -8f);
        v12.curveToRelative(0f, 0f, -0.8f, 2.61f, 2.15f, 4.63f);
        v12.curveTo(15.91f, 12.15f, 17f, 13.11f, 17f, 15f);
        v12.curveToRelative(0f, 1.13f, -0.39f, 2.16f, -1.02f, 3f);
        v12.horizontalLineTo(18f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(20f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.01f, 12.46f);
        v12.curveToRelative(-0.15f, 0.42f, -0.15f, 0.82f, -0.08f, 1.28f);
        v12.curveToRelative(0.1f, 0.55f, 0.33f, 1.04f, 0.2f, 1.6f);
        v12.curveToRelative(-0.13f, 0.59f, -0.77f, 1.38f, -1.53f, 1.63f);
        v12.curveToRelative(1.28f, 1.05f, 3.2f, 0.37f, 3.39f, -1.32f);
        v12.curveTo(14.16f, 14.11f, 12.55f, 13.67f, 12.01f, 12.46f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(2f, 2f);
        v12.verticalLineToRelative(20f);
        v12.horizontalLineToRelative(20f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(2f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(-1.58f, 0f, -2.97f, -1.88f, -3f, -3.06f);
        v12.curveToRelative(0f, -0.05f, -0.01f, -0.13f, -0.01f, -0.22f);
        v12.curveToRelative(-0.13f, -1.73f, 1f, -3.2f, 2.47f, -4.37f);
        v12.curveToRelative(0.47f, 1.01f, 1.27f, 2.03f, 2.57f, 2.92f);
        v12.curveTo(14.61f, 13.69f, 15f, 14.13f, 15f, 15f);
        v12.curveTo(15f, 16.65f, 13.65f, 18f, 12f, 18f);
        v12.close();
        v12.moveTo(20f, 20f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2.02f);
        v12.curveToRelative(0.63f, -0.84f, 1.02f, -1.87f, 1.02f, -3f);
        v12.curveToRelative(0f, -1.89f, -1.09f, -2.85f, -1.85f, -3.37f);
        v12.curveTo(12.2f, 9.61f, 13f, 7f, 13f, 7f);
        v12.curveToRelative(-6.73f, 3.57f, -6.02f, 7.47f, -6f, 8f);
        v12.curveToRelative(0.03f, 0.96f, 0.49f, 2.07f, 1.23f, 3f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FireplaceKt._fireplace = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

